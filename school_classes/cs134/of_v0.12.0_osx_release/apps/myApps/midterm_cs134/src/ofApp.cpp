//--------------------------------------------------------------
//
//  CS134 - Fall Midterm 2024 Take-home
// 
//   
//  (c) Kevin M. Smith - 2024

#include "ofApp.h"



// Integrator for simple trajectory physics
//
void ParticleShape::integrate() {

	// init current framerate (or you can use ofGetLastFrameTime())
	//
	float framerate = ofGetFrameRate();
	float dt = 1.0 / framerate;

	// Implement Euler integrator here...
	// 
	// linear motion
	//
	pos = pos + velocity * dt;
	acceleration = (1 / mass) * force;
	velocity = velocity + acceleration * dt;
	velocity *= damping;

	// angular motion
	//
	rotation = rotation + rotationalVelocity * dt;
	rotationalAcceleration = (1 / mass) * rotationalForce;
	rotationalVelocity = rotationalVelocity + rotationalAcceleration * dt;
	rotationalVelocity *= damping;

	
	// zero out forces
	//
	force = glm::vec3(0, 0, 0);
	rotationalForce = 0;

}

// inside() test method - check to see if point p is inside triangle.
// how could you improve the design of t7is method ?
//
bool TriShip::inside(glm::vec3 p0) {
	glm::vec3 p = glm::inverse(getTransform()) * glm::vec4(p0, 1);
	glm::vec3 v1 = glm::normalize(verts[0] - p);
	glm::vec3 v2 = glm::normalize(verts[1] - p);
	glm::vec3 v3 = glm::normalize(verts[2] - p);
	float a1 = glm::orientedAngle(v1, v2, glm::vec3(0, 0, -1));
	float a2 = glm::orientedAngle(v2, v3, glm::vec3(0, 0, -1));
	float a3 = glm::orientedAngle(v3, v1, glm::vec3(0, 0, -1));
	if (a1 < 0 && a2 < 0 && a3 < 0) return true;
	else return false;
}

void TriShip::draw() {

	// tell OpenGL to transform all points using the "current transformation matrix" (CTM);
	//
	ofPushMatrix();
	ofMultMatrix(getTransform());   // get the current transform for the object.

	// now everything I draw will be transformed by the matrix "T"
	ofSetColor(ofColor::blue);
	ofDrawTriangle(verts[0], verts[1], verts[2]);

	// Draw heading vector
	if (drawHeading) {
		ofSetColor(ofColor::red);
		ofDrawLine(glm::vec3(0, 0, 0), headingVector * headingVectorScale);
	}

	ofPopMatrix();
}

void ofApp::animateTriangle() {
	// Edge case: GUI changed, move back the triangle to it's correct position;
	if (lastAmplitude != amplitude || lastCycles != cycles) {
		// Set 't' to closest point on the sine graph based on the x, and move triangle
		unsigned int closestIndex;
		float y = (sin(tri.pos.x * TWO_PI * cycles / ofGetWidth()) * amplitude) + ofGetHeight() / 2.0;
		line.getClosestPoint(glm::vec3(tri.pos.x, y, 0), &closestIndex);

		t = line.getLengthAtIndex(closestIndex);
		tri.pos = line.getPointAtLength(t);

		lastAmplitude = amplitude;
		lastCycles = cycles;
		return;
	}


	// Walking along the line, get point on the line with the given t (i.e. current distance)
	t += speed / ofGetFrameRate();
	if (t > line.getPerimeter()) t = 0;

	// Rotation
	glm::vec3 p1 = normalize(line.getPointAtLength(t) - tri.pos);
	tri.rotation = glm::degrees(orientedAngle(glm::vec3(0, 1, 0), p1, glm::vec3(0, 0, 1)));

	// Position
	tri.pos = line.getPointAtLength(t);
}

//--------------------------------------------------------------
void ofApp::setup(){

	
	tri.pos = glm::vec3(ofGetWidth()/2.0, ofGetHeight()/2.0, 0);
	

	ofSetBackgroundColor(ofColor::black);

	// Sound
	soundPlayer.load("sounds/thrusters-loop.wav");
	soundPlayer.setLoop(true);
	soundPlayer.play();
	soundPlayer.setPaused(true);

	// setup GUI
	//
	gui.setup();
	gui.add(thrust.setup("Thrust", 500, 100, 1000));
	gui.add(amplitude.setup("Amplitude", 200, 1, 400));
	gui.add(cycles.setup("Cycles", 4, 1, 10));
	gui.add(speed.setup("Speed", 400, 50, 800));
	gui.add(drawPath.setup("Draw path", true));
	gui.add(drawHeading.setup("Draw heading", false));
	gui.add(triScale.setup("Triangle Scale", 1.0, .5, 3));


}

//--------------------------------------------------------------
void ofApp::update(){
	// GUI stuff
	tri.drawHeading = drawHeading;

	// Animate Triangle
	if (isAnimate) animateTriangle();

	// Simulate
	if (bStartSim) {
		// Add force depending thurst

		// Add velocity via the speed of the animation
		if (isAnimate) {
			tri.velocity += glm::rotate(tri.headingVector, glm::radians(tri.rotation), glm::vec3(0, 0, 1)) * (float) speed;
			isAnimate = false;
		}
		
		// Add force via the thrust and what key is pressed
		if (isUpArrowKeyPressed) tri.force += glm::rotate(tri.headingVector, glm::radians(tri.rotation), glm::vec3(0, 0, 1)) * (float) thrust;
		if (isDownArrowKeyPressed) tri.force -= glm::rotate(tri.headingVector, glm::radians(tri.rotation), glm::vec3(0, 0, 1)) * (float) thrust;

		// Add rotational force via the thrust and what key is pressed
		if (isRightArrowKeyPressed) tri.rotationalForce += thrust;
		if (isLeftArrowKeyPressed) tri.rotationalForce -= thrust;

		// Play sound when key is pressed
		if (isUpArrowKeyPressed || isDownArrowKeyPressed) {
			soundPlayer.setPaused(false);
		} else {
			soundPlayer.setPaused(true);
		}

		// When clicked, don't move (integrate) the triangle
		if (isMouseOnTriangle) return;

		// Integrate triangle
		tri.integrate();
	}
}


void ofApp::draw() {

	ofSetBackgroundColor(ofColor::black);

	 
	float scale = triScale;
	tri.scale = glm::vec3(scale, scale, scale);
	
	ofSetColor(ofColor::blue);

	// draw the ship
	//
	tri.draw();

	// Line and draw path.
	//
	line.clear();
	float i = 0;
	while (i < ofGetWidth()) { // make a heart
		float y = (sin(i * TWO_PI * cycles / ofGetWidth()) * amplitude) + ofGetHeight() / 2.0;
		line.addVertex(ofVec3f(i, y, 0));
		i+=1;
	}
	// line.close();
	if (drawPath) {
		ofSetColor(ofColor::purple);
		line.draw();
	}
	

	// draw the GUI
	if (!bHide) gui.draw(); 

	//
	// draw screen data
	//
	string str, state;
	state = (bStartSim ? "ON" : "OFF");
	str += "Simulation : " + state;
	ofSetColor(ofColor::white);
	ofDrawBitmapString(str, ofGetWindowWidth() - 170, 15);

}



//--------------------------------------------------------------
void ofApp::keyPressed(int key){
	switch (key) {
	case 'h':
		bHide = !bHide;
		break;
	case 'f':
		bFullscreen = !bFullscreen;
		ofSetFullscreen(bFullscreen);
		break;
	case OF_KEY_CONTROL:
		bCtrlKeyDown = true;
		break;
	case ' ': {
	    // Disable simulation
		bStartSim = false;

		// Set 't' to closest point on the sine graph based on position of the triangle
		unsigned int closestIndex;
		line.getClosestPoint(glm::vec3(tri.pos.x, tri.pos.y, 0), &closestIndex);
		t = line.getLengthAtIndex(closestIndex);

		soundPlayer.setPaused(true); // Stop sound

		// animate tri ship along sin wave path
	    isAnimate = !isAnimate;
		break;
	}
	case 'r':           // reset explosion and ship position
		break;
	case OF_KEY_LEFT:   // turn left
		isLeftArrowKeyPressed = true;
		break;
	case OF_KEY_RIGHT:  // turn right
		isRightArrowKeyPressed = true;
		break;
	case OF_KEY_UP:     // go forward
		isUpArrowKeyPressed = true;
		break;
	case OF_KEY_DOWN:   // go backward
		isDownArrowKeyPressed = true;
		break;

	case 's':
	case 'S':
		tri.velocity = glm::vec3(0, 0, 0); // Remove velocity
		tri.rotationalVelocity = 0;
		soundPlayer.setPaused(true); // Stop sound
		bStartSim = !bStartSim;  // toggle simulation
		break;

	default:
		break;
	}
}

//--------------------------------------------------------------
void ofApp::keyReleased(int key){
	switch (key) {
	case OF_KEY_CONTROL:
		bCtrlKeyDown = false;
		break;
	case OF_KEY_LEFT:   // turn left
		isLeftArrowKeyPressed = false;
		break;
	case OF_KEY_RIGHT:  // turn right
		isRightArrowKeyPressed = false;
		break;
	case OF_KEY_UP:     // go forward
		isUpArrowKeyPressed = false;
		break;
	case OF_KEY_DOWN:   // go backward
		isDownArrowKeyPressed = false;
		break;
	default:
		break;
	}
}

//--------------------------------------------------------------
void ofApp::mouseMoved(int x, int y ){

}

//--------------------------------------------------------------
void ofApp::mouseDragged(int x, int y, int button){
	// Get mouse position
    glm::vec3 mousePosition = glm::vec3(x, y, 0);

   if (isMouseOnTriangle) {
        glm::vec3 delta = mousePosition - lastMousePosition;
        tri.pos += delta;
   }

	// Update last mouse position
	lastMousePosition = mousePosition;
}

//--------------------------------------------------------------
void ofApp::mousePressed(int x, int y, int button) {
	// Get mouse position
    glm::vec3 mousePosition = glm::vec3(x, y, 0);
    lastMousePosition = mousePosition;
	
	// Triangle click detection
	isMouseOnTriangle = tri.inside(mousePosition);
}

//--------------------------------------------------------------
void ofApp::mouseReleased(int x, int y, int button){
	isMouseOnTriangle = false;
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
