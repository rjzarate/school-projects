//  CS 134 - In-Class exercise - Getting started with Particle Physics
//
//  Kevin M. Smith - CS 134 - SJSU CS

#include "ofApp.h"


Particle::Particle() {

	// initialize particle with some reasonable values first;
	//
	velocity.set(0, 0, 0);
	acceleration.set(0, 0, 0);
	position.set(0, 0, 0);
	lifespan = 5;
	birthtime = 0;
	radius = .5;
	damping = .99;
	mass = 1;

	// To be deleted
	toDelete = false;
}

void Particle::draw() {

	ofSetColor(ofColor::blue);
	ofDrawSphere(position, radius);
}

// write your own integrator here.. (hint: it's only 3 lines of code)
//
void Particle::integrate() {

	// (1) update position from velocity and time interval
	position += velocity / ofGetFrameRate();
	// (2) update velocity (based on acceleration
	velocity += acceleration / ofGetFrameRate();
	// (3) multiply final result by the damping factor to sim drag
	//
	velocity *= damping;


	// Life span check
	if (lifespan < ofGetElapsedTimeMillis()) {
		toDelete = true;
		return;
	}

} 

void ofApp::launchParticle() {

	// Create initialize a new particle with values from sliders
	//
	Particle particle;


	particle.velocity.x = velocity->x;
	particle.velocity.y = velocity->y;
	particle.velocity.z = velocity->z;

	particle.acceleration.set(0, -gravity, 0);
	particle.damping = damping;
	particle.radius = radius;
	
	// Lifespan converted to milliseconds
	particle.lifespan = ofGetElapsedTimeMillis() + lifespan * 1000;
	particle.birthtime = ofGetElapsedTimeMillis();

	cout << "vel: " << particle.velocity << endl;
	cout << "accel: " << particle.acceleration << endl;
	cout << "damp: " << damping << endl;
	cout << "rad: " << radius << endl;
	cout << "life: " << lifespan << endl;
	cout << "birth: " << ofGetElapsedTimeMillis() << endl;

	// save your particle here  - you can use an array
	// but make sure to clear() it first as we are using it for 
	// just one particle.
    
	particles.push_back(particle);

}

//--------------------------------------------------------------
void ofApp::setup(){
	cam.setDistance(10);
	cam.setNearClip(.1);
	cam.setFov(65.5);   // approx equivalent to 28mm in 35mm format
	ofSetVerticalSync(true);
	framerate = ofGetFrameRate();

	// some simple sliders to play with parameters
	//
	gui.setup();
	gui.add(velocity.setup("Initial Velocity", ofVec3f(0, 20, 0), ofVec3f(0, 0, 0), ofVec3f(100, 100, 100)));	
	gui.add(damping.setup("Damping", .99, .1, 1.0));
    gui.add(gravity.setup("Gravity", 10, 1, 20));
	gui.add(radius.setup("Radius", .5, .1, 1.0));
	gui.add(lifespan.setup("Lifespan", 5, .1, 10.0));
	bHide = false;

}

//--------------------------------------------------------------
void ofApp::update() {
	//
	// need to call integrate() method in your particles here
	//  - loop through your 
	//
	for (auto& particle : particles) {
		particle.integrate();
	}

	// Delete particle and remove from the vector
	for (int i = particles.size() - 1; i >= 0; i--) {
		if (particles[i].toDelete) {
			particles.erase(particles.begin() + i);
			continue;
		}
	}

}

//--------------------------------------------------------------
void ofApp::draw(){
	ofSetBackgroundColor(ofColor::black);

	// draw the GUI
	if (!bHide) gui.draw();


	cam.begin();

	// draw a grid
	//
	ofPushMatrix();
	ofRotate(90, 0, 0, 1);
	ofSetLineWidth(1);
	ofSetColor(ofColor::dimGrey);
	ofDrawGridPlane();
	ofPopMatrix();

	// draw particle(s) here..
	//
	for (auto& particle : particles) {
		particle.draw();
	}

	cam.end();

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
	case ' ':
		launchParticle();
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
