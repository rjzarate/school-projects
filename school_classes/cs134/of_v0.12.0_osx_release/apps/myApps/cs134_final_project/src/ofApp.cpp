//  CS 134 - In-Class exercise - Getting started with Particle Physics
//
//  Kevin M. Smith - CS 134 - SJSU CS

#include "ofApp.h"






//--------------------------------------------------------------
//  Setup Application data
//
void ofApp::setup(){
	cam.setDistance(10);
	cam.setNearClip(.1);
	cam.setFov(65.5);   // approx equivalent to 28mm in 35mm format
	ofSetVerticalSync(true);


	// some simple sliders to play with parameters
	//
	gui.setup();
	gui.add(velocity.setup("Initial Velocity", ofVec3f(5, 10, 0), ofVec3f(0, 0, 0), ofVec3f(100, 100, 100)));	
	gui.add(lifespan.setup("Lifespan", 2.0, .1, 10.0));
	gui.add(rate.setup("Rate", 1.0, .5, 60.0));
	gui.add(damping.setup("Damping", .99, .1, 1.0));
    gui.add(gravity.setup("Gravity", 10, 1, 20));
	gui.add(radius.setup("Radius", .1, .01, 1.0));
	gui.add(restitution.setup("Restitution", .85, 0, 1.5));
	bHide = false;
	
	//
	// setup any objects you've created here...
	emitter.setRate(rate);
	emitter.setOneShot(true);

	emitter.start();
	emitter.setLifespan(10);


	ParticleSystem *sys = emitter.sys;
	grav.set(ofVec3f(0, -1.0, 0));
	sys->addForce(&grav);
	sys->addForce(new TurbulenceForce(ofVec3f(-3, -1, -1), ofVec3f(3, 1, 1)));
}

//  This a very simple function to check for collision on the ground plane at (0,0,0)
//  If the partical position.y value is smaller than it's radius, we will assume
//  it's has gone through the plane and we apply a simple impulse function
//  resolve it..
//
void ofApp::checkCollisions() {
	
	// for each particle, determine if we hit the groud plane.
	//
	for (int i = 0; i < emitter.sys->particles.size(); i++) {

        // only bother to check for descending particles.
        //
		ofVec3f vel = emitter.sys->particles[i].velocity; // velocity of particle
		if (vel.y >= 0) break;                             // ascending;

		ofVec3f pos = emitter.sys->particles[i].position;

		if (pos.y < emitter.sys->particles[i].radius) {

            // apply impulse function
            //
			ofVec3f norm = ofVec3f(0, 1, 0);  // just use vertical for normal for now
			ofVec3f f = (restitution + 1.0)*((-vel.dot(norm))*norm);
			emitter.sys->particles[i].forces += ofGetFrameRate() * f;
		}
	}


}

//--------------------------------------------------------------
//
void ofApp::update() {
	checkCollisions();


	grav.set(ofVec3f(0, -gravity, 0));
	emitter.setParticleRadius(radius);

	// get velocity from slider
	glm::vec3 v = velocity;
	emitter.setVelocity(v);
	//
	// update objects you've created here
	emitter.update();
	
}

//--------------------------------------------------------------
void ofApp::draw(){
	ofSetBackgroundColor(ofColor::black);

	// draw the GUI
	if (!bHide) gui.draw();

	// begin drawing in the camera
	//
	cam.begin();

	// draw a grid
	//
	ofPushMatrix();
	ofRotate(90, 0, 0, 1);
	ofSetLineWidth(1);
	ofSetColor(ofColor::dimGrey);
	ofDrawGridPlane();
	ofPopMatrix();

	
	ofFill();
	ofPushMatrix();
	ofRotateX(90);
	ofTranslate(0, 0, .1);
	ofSetColor(ofColor::darkGreen);
	//ofDrawBox(groundPlaneWidth, groundPlaneHeight, .2);
	ofPopMatrix();

	//
	// draw any other objects here...
	//
	emitter.draw();


	//  end drawing in the camera
	// 
	cam.end();

	// draw screen data
	//
	string str;
	str += "Frame Rate: " + std::to_string(ofGetFrameRate());
	ofSetColor(ofColor::white);
	ofDrawBitmapString(str, ofGetWindowWidth() -170, 15);
}


//--------------------------------------------------------------
void ofApp::keyPressed(int key){

	switch (key) {
	case 'C':
	case 'c':
		if (cam.getMouseInputEnabled()) cam.disableMouseInput();
		else cam.enableMouseInput();
		break;
	case 'F':
	case 'f':
		ofToggleFullscreen();
		break;
	case 'h':
		bHide = !bHide;
	case ' ':
		emitter.start();
		break;
	}
}

//--------------------------------------------------------------
void ofApp::keyReleased(int key){

}

//--------------------------------------------------------------
void ofApp::mouseMoved(int x, int y ){

}

//--------------------------------------------------------------
void ofApp::mouseDragged(int x, int y, int button){

}

//--------------------------------------------------------------
void ofApp::mousePressed(int x, int y, int button){

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

//--------------------------------------------------------------
void ofApp::windowResized(int w, int h){

}

//--------------------------------------------------------------
void ofApp::gotMessage(ofMessage msg){

}

//--------------------------------------------------------------
void ofApp::dragEvent(ofDragInfo dragInfo){ 

}
