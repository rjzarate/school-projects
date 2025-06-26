#include "ofApp.h"



//--------------------------------------------------------------
void ofApp::setup(){
	ofSetVerticalSync(true);

	// create an image for sprites being spawned by emitter
	//
	if (defaultImage.load("images/space-invaders-ship-scaled.png")) {
		imageLoaded = true;
	}
	else {
		cout << "Can't open image file" << endl;
//		ofExit();
	}
    playerImage.load("images/player.png");
    backgroundImage.load("images/background.png");

    // Background
	ofSetBackgroundColor(ofColor::black);

	
    // GUI
    gui.setup();
    gui.add(rate.setup("Agent Rate", 1, 0, 10));
    gui.add(life.setup("Agent Life", 7, .1, 10));
    gui.add(speed.setup("Agent Speed", 100, .1, 1000));
    // gui.add(velocity.setup("velocity", ofVec3f(0, -200, 0), ofVec3f(-1000, -1000, -1000), ofVec3f(1000, 1000, 1000)));
    gui.add(scale.setup("Agent Scale", .15, .05, 1.0));
    gui.add(rotationSpeed.setup("Agent Rotation Speed (deg/Frame)", 0.2, 0, 20));
    gui.add(nAgents.setup("Agent Per Update", 1, 1, 10));
    bHide = false;
    
    
    gui.add(playerSize.setup("Player Size", 0.5, 0.1, 20));
    // gui.add(playerSpeed.setup("Player Speed", 500, 1, 2500));
    gui.add(thrustGUI.setup("Thrust", 500, 100, 1000));
    gui.add(playerRotationSpeed.setup("Player Rotation Speed", 6, 1, 90));
    gui.add(playerEnergy.setup("Player Max Energy", 3, 1, 10));
    
    gui.add(showImages.setup("Toggle Sprite Images", true, 20, 20));
    
    

    // Agent Emitter
    emitter = new AgentEmitter();
    // Drawing and image loading
    emitter->drawable = false;
    if (imageLoaded) emitter->setChildImage(defaultImage);
    
    // Start emitter
    emitter->start();

    // Default emitter values from GUI
    emitter->setRate(rate);
    emitter->setLifespan(life * 1000); // convert to milliseconds
    emitter->setVelocity(ofVec3f(velocity->x, velocity->y, velocity->z));
    emitter->setChildScale(scale);
    emitter->setChildForwardSpeed(speed);
    emitter->setChildRotationSpeed(rotationSpeed);

    emitter->player = &player;

    // Update
    emitter->update();
        
    emitters.push_back(emitter);

    // Ray Emitter
    rayEmitter = new RayEmitter();
    if (imageLoaded) rayEmitter->setChildImage(defaultImage);
    // TODO: changable in GUI
    rayEmitter->setChildForwardSpeed(100.0f);
    rayEmitter->setChildRotationSpeed(0);
    emitters.push_back(rayEmitter);

    // Particle Emitter
    particleEmitter = new ParticleEmitter();
    if (imageLoaded) particleEmitter->setChildImage(defaultImage);
    // TODO: changable in GUI, especially size and amt
    // particleEmitter->setChildForwardSpeed(100.0f);
    particleEmitter->setChildRotationSpeed(1.0f);
    emitters.push_back(particleEmitter);

    // Player
    nEnergy = 0;
    player.shootEmitter = rayEmitter;
    player.pos = glm::vec3(ofGetWindowWidth() / 2.0, ofGetWindowHeight() / 2.0, 0);
    player.spriteImage = playerImage;
    
    // Time
    firstLoaded = true;
    startedTime = ofGetElapsedTimeMillis();
}

//--------------------------------------------------------------
void ofApp::update() {
    
    // Show image
    player.bShowImage = showImages;
    
    // Kill all sprites when 0 life
    if (nEnergy <= 0) {
        emitter->stop();
        for (auto &e : emitters) {
            for (int i = e->sys->sprites.size() -1; i >= 0; i--) {
                e->sys->sprites[i]->lifespan = -1;
                e->sys->remove(i);
            }
        }

        return;
    }
    
    // Update all emitters
    for (Emitter * e : emitters) {
        e->update();

        float sc = e->childScale;
        float fs = e->childSpeed;
        float rs = e->childRotationSpeed;

        for (int i = 0; i < e->sys->sprites.size(); i++) {
            // Get values from sliders and update sprites dynamically
            //
            e->sys->sprites[i]->scale = glm::vec3(sc, sc, sc);
            e->sys->sprites[i]->forwardSpeed = fs;
            e->sys->sprites[i]->rotationSpeed = rs;
            e->sys->sprites[i]->bShowImage = showImages;
        }
    }
    // Update only the agent emitter
    if (emitter != NULL) {
        emitter->setRate(rate);
        emitter->setLifespan(life * 1000);    // convert to milliseconds
        emitter->setSpritesPerUpdate(nAgents);
        emitter->setChildForwardSpeed(speed);
        emitter->setChildScale(scale);
        emitter->setChildRotationSpeed(rotationSpeed);
    }
    
    /**
     * COLLISION
     */
    
    // Vertices of player hits emitted sprite
    for (int i = 0; i < player.verts.size(); i++) {
        for (int j = emitter->sys->sprites.size() - 1; j >= 0; j--) {
            
            // Object -> World
            glm::vec4 t4 = player.getTransform() * glm::vec4(player.verts[i], 1);
            glm::vec3 t = glm::vec3(t4.x, t4.y, t4.z);
            if (emitter->sys->sprites[j]->inside(t)) {
                // Particles VFX
                // TODO: GUI
                particleEmitter->pos = player.pos;
                for (int k = 0; k < 20; k++) {
                    particleEmitter->spawnSprite();
                }

                // Delete agent
                emitter->sys->sprites[j]->lifespan = -1;
                emitter->sys->remove(j);

                // Dec energy
                nEnergy--;
                endedTime = ofGetElapsedTimeMillis();
                if (nEnergy <= 0) return;
            }
        }
    }
    
    // Vertices of emitted sprite hits player
    for (int i = emitter->sys->sprites.size() - 1; i >= 0; i--) {
        for (int j = 0; j < emitter->sys->sprites[i]->verts.size(); j++) {
            
            // Object -> World
            glm::vec4 t4 = emitter->sys->sprites[i]->getTransform() * glm::vec4(emitter->sys->sprites[i]->verts[j], 1);
            glm::vec3 t = glm::vec3(t4.x, t4.y, t4.z);
            if (player.inside(t)) {
                // Particles VFX
                // TODO: GUI
                particleEmitter->pos = player.pos;
                for (int k = 0; k < 20; k++) {
                    particleEmitter->spawnSprite();
                }

                // Delete agent
                emitter->sys->sprites[i]->lifespan = -1;
                emitter->sys->remove(i);

                // Dec energy
                nEnergy--;
                endedTime = ofGetElapsedTimeMillis();
                if (nEnergy <= 0) return;
                break;
            }
        }
    }

    // Vertices of emitted ray hits emitted agent
    for (int i = rayEmitter->sys->sprites.size() - 1; i >= 0; i--) {
        bool isDeleted = false;
        for (int j = 0; j < rayEmitter->sys->sprites[i]->verts.size(); j++) {
            
            // Object -> World
            glm::vec4 t4 = rayEmitter->sys->sprites[i]->getTransform() * glm::vec4(rayEmitter->sys->sprites[i]->verts[j], 1);
            glm::vec3 t = glm::vec3(t4.x, t4.y, t4.z);

            for (int k = emitter->sys->sprites.size() - 1; k >= 0; k--) {
                if (emitter->sys->sprites[k]->inside(t)) {
                    // TODO: GUI
                    particleEmitter->pos = rayEmitter->sys->sprites[i]->pos;
                    for (int k = 0; k < 20; k++) {
                        particleEmitter->spawnSprite();
                    }
                    
                    // Delete agent
                    emitter->sys->sprites[k]->lifespan = -1;
                    emitter->sys->remove(k);

                    // Also delete ray
                    rayEmitter->sys->sprites[i]->lifespan = -1;
                    rayEmitter->sys->remove(i);
                    isDeleted = true;

                    // Inc energy
                    if (nEnergy < playerEnergy) nEnergy ++;
                    break;
                }
            }
            if (isDeleted) break;
        }
    }

    
    // Player
    float ps = playerSize;
    player.scale = glm::vec3(ps, ps, ps);

    // Add force via the thrust and what key is pressed
    if (isUpArrowKeyPressed) player.force += glm::rotate(player.headingVector, glm::radians(player.rotation), glm::vec3(0, 0, 1)) * (float) thrustGUI;
    if (isDownArrowKeyPressed) player.force -= glm::rotate(player.headingVector, glm::radians(player.rotation), glm::vec3(0, 0, 1)) * (float) thrustGUI;
    // Add rotational force via the thrust and what key is pressed
    if (isRightArrowKeyPressed) player.rotationalForce += thrustGUI;
    if (isLeftArrowKeyPressed) player.rotationalForce -= thrustGUI;
    // Apply forces, make sure to clamp to screen
    player.integrate(true);
}


//--------------------------------------------------------------
void ofApp::draw(){
    // Draw background
    ofSetColor(ofColor::white);
    if (nEnergy > 0) backgroundImage.draw(-100, -100);
    
    // Gui
    if (!bHide) {
        gui.draw();
    }
    
    if (firstLoaded) {
        ofSetColor(ofColor::white);
        ofDrawBitmapString("Arrow keys to move. Don't get hit.", ofGetWindowWidth() / 2.0 - 30, ofGetWindowHeight() / 2.0);
        ofDrawBitmapString("Press [SPACEBAR] to Start", ofGetWindowWidth() / 2.0 - 30, ofGetWindowHeight() / 2.0 - 20);
        return;
    }
    
    
    if (nEnergy <= 0) {
        ofSetColor(ofColor::white);
        string timeString = "Time: " + ofToString((endedTime - startedTime) / 1000.0) + "s";
        ofDrawBitmapString(timeString, ofGetWindowWidth() / 2.0 - 30, ofGetWindowHeight() / 2.0);
        ofDrawBitmapString("Press [SPACEBAR] to restart", ofGetWindowWidth() / 2.0 - 30, ofGetWindowHeight() / 2.0 - 20);
        return;
    }
    
    
    // Display current Energy and frame rate
    ofSetColor(ofColor::white);
    string energyString = "Energy: " + ofToString(nEnergy);
    ofDrawBitmapString(energyString, ofGetWindowWidth() - 100, ofGetWindowHeight() - 10);
    string frameRateString = "Frame Rate: " + ofToString(ofGetFrameRate());
    ofDrawBitmapString(frameRateString, ofGetWindowWidth() - 150, ofGetWindowHeight() - 50);

    player.draw();

    // Draw all emitters
    for (auto &e : emitters) {
        e->draw();
    }
}


//--------------------------------------------------------------

//--------------------------------------------------------------
void ofApp::mouseMoved(int x, int y ){
//	cout << "mouse( " << x << "," << y << ")" << endl;
}

//--------------------------------------------------------------
void ofApp::mouseDragged(int x, int y, int button){
    // Get mouse position
    glm::vec3 mousePosition = glm::vec3(x, y, 0);
    
    // Drag clicked emitter
    if (emitter != NULL) {
        glm::vec3 delta = mousePosition - lastMousePosition;
        emitter->pos += delta;
    }
    lastMousePosition = glm::vec3(x, y, 0);
}

//--------------------------------------------------------------
void ofApp::mousePressed(int x, int y, int button){
    // Get mouse position; also change last mouse pos
    glm::vec3 mousePosition = glm::vec3(x, y, 0);
    lastMousePosition = glm::vec3(x, y, 0);
}

//--------------------------------------------------------------
void ofApp::mouseReleased(int x, int y, int button){

}

//--------------------------------------------------------------
void ofApp::mouseEntered(int x, int y){
}

//--------------------------------------------------------------
void ofApp::mouseExited(int x, int y){

}

void ofApp::keyPressed(int key) {
	switch (key) {
	case 'C':
	case 'c':
		break;
	case 'F':
	case 'f':
		ofToggleFullscreen();
		break;
	case 'H':
	case 'h':
		bHide = !bHide;
		break;
	case 'r':
		break;
	case 's':
		break;
	case 'u':
		break;
	case OF_KEY_ALT:
		break;
	case OF_KEY_CONTROL:
		break;
	case OF_KEY_SHIFT:
		break;
	case OF_KEY_DEL:
		break;
    case 'z': // Shoot
        player.shoot();
        break;
    case OF_KEY_LEFT: // turn left
        isLeftArrowKeyPressed = true;
        break;
    case OF_KEY_RIGHT: // turn right
        isRightArrowKeyPressed = true;
        break;
    case OF_KEY_UP: // go forward
        isUpArrowKeyPressed = true;
        break;
    case OF_KEY_DOWN: // go backward
        isDownArrowKeyPressed = true;
        break;
    // Space bar: restart
        case 32:
            firstLoaded = false;
            startedTime = ofGetElapsedTimeMillis();
            emitter->start();
            player.pos = glm::vec3(ofGetWindowWidth() / 2.0, ofGetWindowHeight() / 2.0, 0);
            player.rotation = 0;
            nEnergy = playerEnergy;
            break;
        default:
            // cout << "Unknown Key: " << key << endl;
            break;
	}
    
}


//--------------------------------------------------------------
void ofApp::keyReleased(int key) {
	switch (key) {
    case OF_KEY_LEFT:
        isLeftArrowKeyPressed = false;
        break;
    case OF_KEY_RIGHT:
        isRightArrowKeyPressed = false;
        break;
    case OF_KEY_UP:
        isUpArrowKeyPressed = false;
        break;
    case OF_KEY_DOWN:
        isDownArrowKeyPressed = false;
        break;
	case OF_KEY_ALT:
		break;
	case OF_KEY_CONTROL:
		break;
	case OF_KEY_SHIFT:
		break;
	}
}

//--------------------------------------------------------------
void ofApp::windowResized(int w, int h){

}

//--------------------------------------------------------------
void ofApp::gotMessage(ofMessage msg){

}

//--------------------------------------------------------------
void ofApp::dragEvent(ofDragInfo dragInfo){ 

}

