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
	ofSetFrameRate(60);


	// some simple sliders to play with parameters
	//
	gui.setup();
	gui.add(velocity.setup("Initial Velocity", ofVec3f(0, 20, 0), ofVec3f(0, 0, 0), ofVec3f(100, 100, 100)));
	gui.add(turbulenceForceMinimumGUI.setup("Turbulence Min", ofVec3f(-2, -1, -3), ofVec3f(-maximumTurbulence, -maximumTurbulence, -maximumTurbulence), ofVec3f(maximumTurbulence, maximumTurbulence, maximumTurbulence)));
	gui.add(turbulenceForceMaximumGUI.setup("Turbulence Max", ofVec3f(1, 2, 5), ofVec3f(-maximumTurbulence, -maximumTurbulence, -maximumTurbulence), ofVec3f(maximumTurbulence, maximumTurbulence, maximumTurbulence)));
	gui.add(noiseForceMinimumGUI.setup("Noise Min", ofVec3f(0, 0, 0), ofVec3f(-maximumNoise, -maximumNoise, -maximumNoise), ofVec3f(maximumNoise, maximumNoise, maximumNoise)));
	gui.add(noiseForceMaximumGUI.setup("Noise Max", ofVec3f(0, 0, 0), ofVec3f(-maximumNoise, -maximumNoise, -maximumNoise), ofVec3f(maximumNoise, maximumNoise, maximumNoise)));
	// gui.add(noiseForceOffsetGUI.setup("Noise Offset", 10, -100, 100));
	gui.add(gravity.setup("Gravity", 10, 1, 20));
	gui.add(lifespan.setup("Lifespan", 2.0, .1, 10.0));
	gui.add(rate.setup("Rate", 1.0, .5, 60.0));
	gui.add(damping.setup("Damping", .99, .1, 1.0));
	gui.add(radius.setup("Radius", .1, .01, .3));
	gui.add(enableTurbulenceForceGUI.setup("Turbulence Enabled", true, 50, 50));
	gui.add(enableNoiseForceGUI.setup("Noise Enabled", true, 50, 50));
	gui.add(enableGravityForceGUI.setup("Gravity Enabled", true, 50, 50));

	bHide = false;

	//
	// setup any objects you've created here...
	// Instantiate particle emitter
	particleEmitter = new ParticleEmitter();

	// Add forces
	gravityForce = new GravityForce(ofVec3f(0, -1 * (float) gravity, 0));
	particleEmitter->sys->addForce(gravityForce);
	turbulenceForce = new TurbulenceForce((ofVec3f) turbulenceForceMinimumGUI, (ofVec3f) turbulenceForceMaximumGUI);
	particleEmitter->sys->addForce(turbulenceForce);
	noiseForce = new NoiseForce((ofVec3f) noiseForceMinimumGUI, (ofVec3f) noiseForceMaximumGUI);
	particleEmitter->sys->addForce(noiseForce);

	// Start particle emitter
	particleEmitter->start();
	
}

void ofApp::exit() {
	cout << "Program exited" << endl;
	if (particleEmitter != NULL) delete particleEmitter;
}

//--------------------------------------------------------------
//
void ofApp::update() {
	//
	// update objects you've created here

	// Update particle
	particleEmitter->setLifespan(lifespan);
	particleEmitter->setVelocity((ofVec3f) velocity);
	particleEmitter->setRate(rate);
	particleEmitter->setParticleRadius(radius);
	particleEmitter->setDamping(damping);
	particleEmitter->update();

	// Toggle forces
	gravityForce->toggle(enableGravityForceGUI);
	turbulenceForce->toggle(enableTurbulenceForceGUI);
	noiseForce->toggle(enableNoiseForceGUI);

	// Update forces
	gravityForce->set(ofVec3f(0, -1 * (float) gravity, 0));
	turbulenceForce->set((ofVec3f) turbulenceForceMinimumGUI, (ofVec3f) turbulenceForceMaximumGUI);
	noiseForce->set((ofVec3f) noiseForceMinimumGUI, (ofVec3f) noiseForceMaximumGUI);
	


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
	ofRotateDeg(90, 0, 0, 1);
	ofSetLineWidth(1);
	ofSetColor(ofColor::dimGrey);
	ofDrawGridPlane();
	ofPopMatrix();

	//
	// draw any other objects here...
	//

	// Draw emitter
	particleEmitter->draw();




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
