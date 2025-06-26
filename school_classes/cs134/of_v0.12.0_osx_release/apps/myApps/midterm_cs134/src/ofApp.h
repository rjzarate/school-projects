#pragma once

#include "ofMain.h"
#include "ofxGui.h"

//  Shape base class
//
class Shape {
public:
	Shape() {}
	virtual void draw() {}
	virtual bool inside(glm::vec3 p) { return false; }

	glm::vec3 pos;
	float rotation = 0.0;
	glm::vec3 scale = glm::vec3(1.0, 1.0, 1.0);

	// get transformation matrix for object (based on it's current pos, rotation and scale channels)
	//
	glm::mat4 getTransform() {
		glm::mat4 trans = glm::translate(glm::mat4(1.0), glm::vec3(pos));
		glm::mat4 rot = glm::rotate(glm::mat4(1.0), glm::radians(rotation), glm::vec3(0, 0, 1));
		glm::mat4 scale = glm::scale(glm::mat4(1.0), this->scale);

		return (trans * rot * scale);
	}

	vector<glm::vec3> verts;

};

class ParticleShape : public Shape {
public:
	glm::vec3 velocity = glm::vec3(0, 0, 0);
	glm::vec3 acceleration = glm::vec3(0, 0, 0);
	glm::vec3 force = glm::vec3(0, 0, 0);
	float mass = 1.0;
	float damping = .99;

	// Rotation
	float rotationalVelocity;
	float rotationalAcceleration;
	float rotationalForce;


	void integrate();
};



//  The Triangle "Space Ship"
//
class TriShip : public ParticleShape {
public:
	TriShip(glm::vec3 p1 = glm::vec3(-10, -10, 0),
		glm::vec3 p2 = glm::vec3(10, -10, 0),
		glm::vec3 p3 = glm::vec3(0, 20, 0),
		ofColor color = ofColor::yellow) {
		verts.push_back(p1);
		verts.push_back(p2);
		verts.push_back(p3);

		headingVector = glm::vec3(0, 1, 0);

		// Heading vector scale
		// Choose greatest distance from the 3 points
		float distance = 0.0f;
		for (int i = 0; i < verts.size(); i++) {
			glm::vec3 trianglePoint = verts[i] + pos;
			float pointDistance = glm::distance(trianglePoint, pos);
			distance = (pointDistance > distance) ? pointDistance : distance;
		}
		headingVectorScale = distance * 3;
	}

	bool inside(glm::vec3 p) override;

	// Heading
	glm::vec3 headingVector;
	float headingVectorScale;
	bool drawHeading = false;

	void draw() override;

};





class ofApp : public ofBaseApp{

	public:
		void setup();
		void update();
		void draw();

		void keyPressed(int key);
		void keyReleased(int key);
	  	void mouseMoved(int x, int y );
		void mouseDragged(int x, int y, int button);
		void mousePressed(int x, int y, int button);
		void mouseReleased(int x, int y, int button);
		void mouseEntered(int x, int y);
		void mouseExited(int x, int y);
		void windowResized(int w, int h);
		void dragEvent(ofDragInfo dragInfo);
		void gotMessage(ofMessage msg);

	
		// application data
	

		// UI control data
		//
		bool bFullscreen = false;	
		bool bCtrlKeyDown = false;

		// create one triangle
		//
		TriShip tri;

		bool bStartSim = false;

		// Line animation
		ofPolyline line;
		void animateTriangle();
		bool isAnimate = false;
		float t = 0;

		// Dragging
		bool isMouseOnTriangle;
		glm::vec3 lastMousePosition;

		// Integration
		bool isUpArrowKeyPressed;
		bool isDownArrowKeyPressed;
		bool isLeftArrowKeyPressed;
		bool isRightArrowKeyPressed;

		// Sound
		ofSoundPlayer soundPlayer;

		// GUI
		bool bHide = true;
		ofxFloatSlider amplitude;
		ofxFloatSlider thrust;
		ofxFloatSlider cycles;
		ofxFloatSlider speed;
		ofxToggle drawPath;
		ofxToggle drawHeading;
		ofxVec3Slider velocity;
		ofxFloatSlider imageScale;
		ofxFloatSlider triScale;
		ofxPanel gui;

		float lastCycles = 0;
		float lastAmplitude = 0;
};
