//
//  Starter file for Lighting Experiments--  
//
//  Kevin M. Smith SJSU - CS134
//
//  This file consists of a 3-Point Lighting Setup  (classic stage lighting)
//
//  Uses the OF ofLight class which is an object interface to OpenGL lighting.
//
//  -- Experiment with different lighting types 
//  -- Experiment with different lighting parameters
//  -- Disable lights to see the effect of individual lights or combinations
//  -- Connect sliders from ofxGUI to make this easier.
// 
//
//   (c) Kevin M. Smith - 2018  - Do not redistribute code or models with
//       permission from the author. 
//


#include "ofApp.h"


//--------------------------------------------------------------
void ofApp::setup(){

	cam.setDistance(10);
	cam.setNearClip(.1);
	cam.setFov(65.5);   // approx equivalent to 28mm in 35mm format
//	ofSetVerticalSync(true);
	cam.disableMouseInput();
	ofEnableDepthTest();
	ofEnableLighting();

	// Setup 3 - Light System
	// 
	keyLight.setup();
	keyLight.enable();
	keyLight.setAreaLight(1, 1);
	keyLight.setAmbientColor(ofFloatColor(0.1, 0.1, 0.1));
	keyLight.setDiffuseColor(ofFloatColor(1, 1, 1));
	keyLight.setSpecularColor(ofFloatColor(1, 1, 1));
	
	keyLight.rotate(45, ofVec3f(0, 1, 0));
	keyLight.rotate(-45, ofVec3f(1, 0, 0));
	keyLight.setPosition(5, 5, 5);

	fillLight.setup();
	fillLight.enable();
	fillLight.setSpotlight();
	fillLight.setScale(.05);
	fillLight.setSpotlightCutOff(15);
	fillLight.setAttenuation(2, .001, .001);
	fillLight.setAmbientColor(ofFloatColor(0.1, 0.1, 0.1));
	fillLight.setDiffuseColor(ofFloatColor(1, 1, 1));
	fillLight.setSpecularColor(ofFloatColor(1, 1, 1));
	fillLight.rotate(-10, ofVec3f(1, 0, 0));
	fillLight.rotate(-45, ofVec3f(0, 1, 0));
	fillLight.setPosition(-5, 5, 5);

	rimLight.setup();
	rimLight.enable();
	rimLight.setSpotlight();
	rimLight.setScale(.05);
	rimLight.setSpotlightCutOff(30);
	rimLight.setAttenuation(.2, .001, .001);
	rimLight.setAmbientColor(ofFloatColor(0.1, 0.1, 0.1));
	rimLight.setDiffuseColor(ofFloatColor(1, 1, 1));
	rimLight.setSpecularColor(ofFloatColor(1, 1, 1));
	rimLight.rotate(180, ofVec3f(0, 1, 0));
	rimLight.setPosition(0, 5, -7);

	// Create Ground Plane
	//
	plane.set(20, 20, 2, 2);
	plane.rotate(-90, ofVec3f(1, 0, 0));
	planeMaterial.setAmbientColor(ofFloatColor(0.1, 0.1, 0.1, 1.0));
	planeMaterial.setDiffuseColor(ofFloatColor(0.3, 0.3, 0.3, 1.0));
	planeMaterial.setSpecularColor(ofFloatColor(0.8, 0.8, 0.8, 1.0));
	planeMaterial.setShininess(5);
	
	if (model.loadModel("geo/monster.obj")) {
		model.setScaleNormalization(false);
		model.setPosition(0, 0, 0);
		bModelLoaded = true;
	}
	else cout << "Error: Can't load model:" << " geo/monster.obj" << endl;

	
	gui.setup("Lighting Controls");

	// Key Light
	keyLightParams.setName("Key Light");
	keyLightParams.add(keyLightPosition.set("Position", ofVec3f(5, 5, 5), ofVec3f(-10, -10, -10), ofVec3f(10, 10, 10)));
	keyLightParams.add(keyLightCutOff.set("CutOff", 45, 0, 90));
	keyLightParams.add(keyLightIntensity.set("Intensity", 1.0, 0.0, 2.0));

	// Fill Light
	fillLightParams.setName("Fill Light");
	fillLightParams.add(fillLightPosition.set("Position", ofVec3f(-5, 5, 5), ofVec3f(-10, -10, -10), ofVec3f(10, 10, 10)));
	fillLightParams.add(fillLightCutOff.set("CutOff", 15, 0, 90));
	fillLightParams.add(fillLightIntensity.set("Intensity", 1.0, 0.0, 2.0));

	// Rim Light
	rimLightParams.setName("Rim Light");
	rimLightParams.add(rimLightPosition.set("Position", ofVec3f(0, 5, -7), ofVec3f(-10, -10, -10), ofVec3f(10, 10, 10)));
	rimLightParams.add(rimLightCutOff.set("CutOff", 30, 0, 90));
	rimLightParams.add(rimLightIntensity.set("Intensity", 1.0, 0.0, 2.0));

	gui.add(keyLightParams);
	gui.add(fillLightParams);
	gui.add(rimLightParams);
}

//--------------------------------------------------------------
void ofApp::update(){
	// Key light
	keyLight.setPosition(keyLightPosition->x, keyLightPosition->y, keyLightPosition->z);
	keyLight.setSpotlightCutOff(keyLightCutOff);
	keyLight.setDiffuseColor(ofFloatColor(keyLightIntensity));

	// Fill light
	fillLight.setPosition(fillLightPosition->x, fillLightPosition->y, fillLightPosition->z);
	fillLight.setSpotlightCutOff(fillLightCutOff);
	fillLight.setDiffuseColor(ofFloatColor(fillLightIntensity));

	// Rim light
	rimLight.setPosition(rimLightPosition->x, rimLightPosition->y, rimLightPosition->z);
	rimLight.setSpotlightCutOff(rimLightCutOff);
	rimLight.setDiffuseColor(ofFloatColor(rimLightIntensity));
}

//--------------------------------------------------------------
void ofApp::draw(){
	ofBackground(ofColor::black);
	glDepthMask(false);
	gui.draw();
	glDepthMask(true);
	cam.begin();
	ofPushMatrix();

//	drawAxis(ofVec3f(0, 0, 0));

	// draw the model (model has textures on it)
	//
	if (bModelLoaded) {
		if (!bWireFrame) model.drawFaces();
		else model.drawWireframe();
	}

	// draw the ground plane with basic material
	//
	planeMaterial.begin();
	plane.draw();
	planeMaterial.end();

	
	ofPopMatrix();

	// draw all the lights 
	keyLight.draw();
	fillLight.draw();
	rimLight.draw();


	cam.end();
	
	

}

// 
// Draw an XYZ axis in RGB at world (0,0,0) for reference.
//
void ofApp::drawAxis(ofVec3f location) {

	ofPushMatrix();
	ofTranslate(location);

	ofSetLineWidth(1.0);

	// X Axis
	ofSetColor(ofColor(255, 0, 0));
	ofDrawLine(ofPoint(0, 0, 0), ofPoint(1, 0, 0));


	// Y Axis
	ofSetColor(ofColor(0, 255, 0));
	ofDrawLine(ofPoint(0, 0, 0), ofPoint(0, 1, 0));

	// Z Axis
	ofSetColor(ofColor(0, 0, 255));
	ofDrawLine(ofPoint(0, 0, 0), ofPoint(0, 0, 1));

	ofPopMatrix();
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
	case 'H':
	case 'h':
		break;
	case 'r':
		cam.reset();
		break;
	case 'W':
	case 'w':
		bWireFrame = !bWireFrame;
		break;
	default:
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
