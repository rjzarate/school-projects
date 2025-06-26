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

    // Background
	ofSetBackgroundColor(ofColor::black);

	
    // GUI
    gui.setup();
    gui.add(rate.setup("rate", 1, 1, 10));
    gui.add(life.setup("life", 5, .1, 10));
    gui.add(velocity.setup("velocity", ofVec3f(0, -200, 0), ofVec3f(-1000, -1000, -1000), ofVec3f(1000, 1000, 1000)));
    gui.add(scale.setup("Scale", .1, .05, 1.0));
    gui.add(rotationSpeed.setup("Rotation Speed (deg/Frame)", 3, 0, 10));
    bHide = false;


	// create an array of emitters and set their position;
	// Fill vector
    for (int i = 0; i < 3; i++) {
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
        e->update();
        
    }
    
    // emitter = &emitters[0];
}

//--------------------------------------------------------------
void ofApp::update() {
    // Update all emitters
    for (Emitter * e : emitters) {

        // Update
        e->update();
        
        for (int i = 0; i < e->sys->sprites.size(); i++) {

            // Get values from sliders and update sprites dynamically
            //
            float sc = e->childScale;
            float rs = e->childRotationSpeed;
            e->sys->sprites[i].scale = glm::vec3(sc, sc, sc);
            e->sys->sprites[i].rotationSpeed = rs;
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
        emitter->setChildScale(scale);
        emitter->setChildRotationSpeed(rotationSpeed);
    }
}


//--------------------------------------------------------------
void ofApp::draw(){
    // Draw all emitters
    for (int i = 0; i < emitters.size(); i++) {
        emitters[i]->draw();
    }

	// emitter->draw();
	
	if (!bHide) {
		gui.draw();
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
    
    // All emitters are now not all clicked
    for (Emitter * e : emitters) {
        e->setIsClicked(false);
        emitter = NULL;
    }
    
    // Go through each emitter if they're clicked on
    for (Emitter * e : emitters) {
        if (e->inside(mousePosition)) {
            // On click, change emitter pointer and adjust GUI
            emitter = e;
            
            rate = emitter->rate;
            life = emitter->lifespan / 1000;
            velocity = ofVec3f(emitter->velocity.x, emitter->velocity.y, emitter->velocity.z);
            scale = emitter->childScale;
            rotationSpeed = emitter->childRotationSpeed;
            emitter->setIsClicked(true);
            
            return;
        }
    }
    
    
//    // Move the circle when cursor is on the circle
//    if (isMouseOnCircle) {
//        circlePosition = mousePosition + circleMouseOffsetPosition;
//    }
//
//    // Move the triangle when cursor is on the triangle
//    if (isMouseOnTriangle) {
//        glm::vec3 delta = mousePosition - lastMousePosition;
//        triangle.position += delta;
////        glm::vec3 delta = mousePosition - lastMousePosition;
////        for (int i = 0; i < (sizeof(trianglePoints)/sizeof(*trianglePoints)); i++) {
////            trianglePoints[i] += delta;
////        }
////        std::cout << delta << std::endl;
//    }
//
//    if (isMouseOnImage) {
//        glm::vec3 delta = mousePosition - lastMousePosition;
//        ship.position += delta;
//    }
//
//
//    lastMousePosition = glm::vec3(x, y, 0);
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

