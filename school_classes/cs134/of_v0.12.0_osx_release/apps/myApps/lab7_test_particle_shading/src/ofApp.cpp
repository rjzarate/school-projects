//  CS 134 - In-Class exercise - Getting started with Particle Physics
//
//  This is fairly comprehensive example of how to use an emitter setup in
//  "one shot" mode with various types of external forecs such as 
//  gravity, turbulence, cyclic, radial.   
//
//  All of the emitter parameters are connected to sliders in order to vary
//  mass, damping, number of particles created.
//
//  All of the force parameters are also connected to sliders. Each force
//  has it's own parameter(s) that are specific to that type of force.
//
//  You can easily extend the system with any types of new/weird forces you want
//  to experiment with.  (look at CyclicForce as an example)
//
//  I have also demonstarted a way to render particles using a textures, shaders
//  and the VBO  (Vertex Buffer).  You will need the textures dot.png file to 
//  be installed in your data/images directory.
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
	ofSetBackgroundColor(ofColor::black);
	ofEnableSmoothing();
	ofEnableDepthTest();
	ofDisableArbTex();

	if (!ofLoadImage(particleTex, "images/dot.png")) {
		cout << "Particle Texture File: images/dot.png not found" << endl;
		ofExit();
	}

#ifdef TARGET_OPENGLES
	shader.load("shaders_gles/shader");
#else
	shader.load("shaders/shader");
#endif

	radialForce = new ImpulseRadialForce(20);

	// set up the emitter
	// 
	emitter.sys->addForce(radialForce);

	emitter.setVelocity(ofVec3f(0, 0, 0));
	emitter.setOneShot(true);
	emitter.setEmitterType(RadialEmitter);
	emitter.setGroupSize(100);
	emitter.setRandomLife(true);
	emitter.setLifespanRange(ofVec2f(0.5, 2));
}

// load vertex buffer in preparation for rendering
//
void ofApp::loadVbo() {
	if (emitter.sys->particles.size() < 1) return;

	vector<ofVec3f> sizes; 
	vector<ofVec3f> points;
	for (int i = 0; i < emitter.sys->particles.size(); i++) {
		points.push_back(emitter.sys->particles[i].position);
		sizes.push_back(ofVec3f(5));
	}
	// upload the data to the vbo
	//
	int total = (int)points.size();
	vbo.clear();
	vbo.setVertexData(&points[0], total, GL_STATIC_DRAW);
	vbo.setNormalData(&sizes[0], total, GL_STATIC_DRAW);
}

//--------------------------------------------------------------
//
void ofApp::update() {
	emitter.update();
}

//--------------------------------------------------------------
void ofApp::draw(){

	loadVbo();
	ofDisableLighting();
	glDepthMask(GL_FALSE);
	ofSetColor(255, 100, 90);
	ofEnableBlendMode(OF_BLENDMODE_ADD);
	ofEnablePointSprites();
	ofNoFill();
	shader.begin();
	cam.clearParent();

	particleTex.bind();
	vbo.draw(GL_POINTS, 0, (int)emitter.sys->particles.size());
	particleTex.unbind();

	cam.end();
	shader.end();
	glDepthMask(GL_TRUE);
	ofDisablePointSprites();
	ofDisableBlendMode();
	ofEnableAlphaBlending();
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
	case 'b':
		break;
	case 'f':
		ofToggleFullscreen();
		break;
	case 'h':
		bHide = !bHide;
	case ' ':
		emitter.sys->reset();
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
