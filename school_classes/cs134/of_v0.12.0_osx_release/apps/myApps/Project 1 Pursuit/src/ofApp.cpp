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
    gui.add(playerSpeed.setup("Player Speed", 500, 1, 2500));
    gui.add(playerRotationSpeed.setup("Player Rotation Speed", 6, 1, 90));
    gui.add(playerEnergy.setup("Player Max Energy", 3, 1, 10));
    
    gui.add(showImages.setup("Toggle Sprite Images", true, 20, 20));
    
    

	// create an array of emitters and set their position;
	// Fill vector
    for (int i = 0; i < 1; i++) {
        emitters.push_back(new AgentEmitter());
    }
    
    // Initialize each agent
    for (int i = 0; i < emitters.size(); i++) {
        Emitter * e = emitters[i];

        // Change color for certain emitters
        switch (i) {
            case 0:
                e->emitterColor = ofColor::yellow;
                break;
            case 1:
                e->emitterColor = ofColor::red;
                break;
        }
        
        // Position, drawing, and image loading
        e->pos = glm::vec3(ofGetWindowWidth() / 2.0 + i * 50, ofGetWindowHeight() / 2.0, 0);
        e->drawable = true;
        if (imageLoaded) e->setChildImage(defaultImage);
        
        // Start emitter
        e->start();
        
        // Default emitter values from GUI
        e->setRate(rate);
        e->setLifespan(life * 1000);    // convert to milliseconds
        e->setVelocity(ofVec3f(velocity->x, velocity->y, velocity->z));
        e->setChildScale(scale);
        e->setChildRotationSpeed(rotationSpeed);
        
        // Update
        e->drawable = false;
        e->update();
        
    }
    
    emitter = emitters[0];
    
    // Player
    nEnergy = 0;
    player.pos = glm::vec3(ofGetWindowWidth() / 2.0, ofGetWindowHeight() / 2.0, 0);
    player.spriteImage = playerImage;
    
    // Time
    firstLoaded = true;
    startedTime = ofGetElapsedTimeMillis();
}

//--------------------------------------------------------------
void ofApp::update() {
    
    // Show image
    if (showImages) {
        player.bShowImage = true;
    } else {
        player.bShowImage = false;
    }
    
    
    // Kill all sprites when 0 life
    if (nEnergy <= 0) {
        emitter->stop();
        for (int i = 0; i < emitter->sys->sprites.size(); i++) {
            emitter->sys->remove(i);
            emitter->sys->sprites[i].lifespan = -1;
            i--;
        }
        return;
    }
    

    // Update all emitters
    for (Emitter * e : emitters) {

        // Update
        e->update();

        for (int i = 0; i < e->sys->sprites.size(); i++) {

            // Get values from sliders and update sprites dynamically
            //
            float sc = e->childScale;
            float fs = e->childSpeed;
            float rs = e->childRotationSpeed;
            e->sys->sprites[i].scale = glm::vec3(sc, sc, sc);
            e->sys->sprites[i].forwardSpeed = fs;
            e->sys->sprites[i].rotationSpeed = rs;
            e->sys->player = player;
            
            if (showImages) {
                e->sys->sprites[i].bShowImage = true;
            } else {
                e->sys->sprites[i].bShowImage = false;
            }
            
        }
    }
    
    
    // Vertices of player hits emitted sprite
    for (int i = 0; i < player.verts.size(); i++) {
        for (int j = 0; j < emitter->sys->sprites.size(); j++) {
            
            // Object -> World
            glm::vec4 t4 = player.getTransform() * glm::vec4(player.verts[i], 1);
            glm::vec3 t = glm::vec3(t4.x, t4.y, t4.z);
            if (emitter->sys->sprites[j].inside(t)) {
                emitter->sys->remove(j);
                emitter->sys->sprites[j].lifespan = -1;
                nEnergy--;
                endedTime = ofGetElapsedTimeMillis();
            }
        }
    }
    
    // Vertices of emitted sprite hits player
    for (int i = 0; i < emitter->sys->sprites.size(); i++) {
        for (int j = 0; j < emitter->sys->sprites[i].verts.size(); j++) {
            
            // Object -> World
            glm::vec4 t4 = emitter->sys->sprites[i].getTransform() * glm::vec4(emitter->sys->sprites[i].verts[j], 1);
            glm::vec3 t = glm::vec3(t4.x, t4.y, t4.z);
            if (player.inside(t)) {
                emitter->sys->remove(i);
                emitter->sys->sprites[i].lifespan = -1;
                i--;
                nEnergy--;
                endedTime = ofGetElapsedTimeMillis();
                break;
            }
        }
    }
    
    
//
//    if (emitter == NULL) {
//        cout << "hi" << endl;
//    }
    
    // Update only the clicked emitter
    if (emitter != NULL) {
        emitter->setRate(rate);
        emitter->setLifespan(life * 1000);    // convert to milliseconds
        emitter->setVelocity(ofVec3f(velocity->x, velocity->y, velocity->z));
        emitter->setSpritesPerUpdate(nAgents);
        emitter->setChildForwardSpeed(speed);
        emitter->setChildScale(scale);
        emitter->setChildRotationSpeed(rotationSpeed);
        
    }
    
    // Player
    float ps = playerSize;
    player.scale = glm::vec3(ps, ps, ps);
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
    
    
//     Draw all emitters
    for (int i = 0; i < emitters.size(); i++) {
        emitters[i]->draw();
    }

	// emitter->draw();
    
    player.draw();
    // ofDrawSphere(200, 200, 1);
    
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
    
    
//    glm::vec3 n1 = glm::normalize(mousePosition - glm::vec3(100, 100, 0));
//    glm::vec3 n2 = glm::normalize(glm::vec3(0, -1, 0));
//    cout << glm::degrees(orientedAngle(n1, n2, glm::vec3(0, 0, 1))) << endl;
//
//
//    // All emitters are now not all clicked
//    for (Emitter * e : emitters) {
//        e->setIsClicked(false);
//        emitter = NULL;
//    }
//
//    // Go through each emitter if they're clicked on
//    for (Emitter * e : emitters) {
//        if (e->inside(mousePosition)) {
//            // On click, change emitter pointer and adjust GUI
//            emitter = e;
//
//            rate = emitter->rate;
//            life = emitter->lifespan / 1000;
//            velocity = ofVec3f(emitter->velocity.x, emitter->velocity.y, emitter->velocity.z);
//            scale = emitter->childScale;
//            rotationSpeed = emitter->childRotationSpeed;
//            emitter->setIsClicked(true);
//
//            return;
//        }
//    }
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
    // Left arrow
    case 57356:
        player.rot -= playerRotationSpeed;
        break;
    // Right arrow
    case 57358:
        player.rot += playerRotationSpeed;
        break;
    // Up arrow
    case 57357:
        player.forward(1.0f * playerSpeed);
            // Player movement clamping borders
            if (player.pos.x < 0) {
                player.pos = glm::vec3(0, player.pos.y, 0);
            }
            if (player.pos.y < 0) {
                player.pos = glm::vec3(player.pos.x, 0, 0);
            }
            if (player.pos.x > ofGetWindowWidth()) {
                player.pos = glm::vec3(ofGetWindowWidth(), player.pos.y, 0);
            }
            if (player.pos.y > ofGetWindowWidth()) {
                player.pos = glm::vec3(player.pos.x, ofGetWindowHeight(), 0);
            }
            
        break;
    // Down arrow
    case 57359:
        player.forward(-1.0f * playerSpeed);
            // Player movement clamping borders
            if (player.pos.x < 0) {
                player.pos = glm::vec3(0, player.pos.y, 0);
            }
            if (player.pos.y < 0) {
                player.pos = glm::vec3(player.pos.x, 0, 0);
            }
            if (player.pos.x > ofGetWindowWidth()) {
                player.pos = glm::vec3(ofGetWindowWidth(), player.pos.y, 0);
            }
            if (player.pos.y > ofGetWindowWidth()) {
                player.pos = glm::vec3(player.pos.x, ofGetWindowHeight(), 0);
            }
        break;
    // Space bar: restart
        case 32:
            firstLoaded = false;
            startedTime = ofGetElapsedTimeMillis();
            emitter->start();
            player.pos = glm::vec3(ofGetWindowWidth() / 2.0, ofGetWindowHeight() / 2.0, 0);
            player.rot = 0;
            nEnergy = playerEnergy;
            break;
        default:
            cout << "Unknown Key: " << key << endl;
            break;
	}
    
}


//--------------------------------------------------------------
void ofApp::keyReleased(int key) {
	switch (key) {
	case OF_KEY_LEFT:
	case OF_KEY_RIGHT:
	case OF_KEY_UP:
	case OF_KEY_DOWN:
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

