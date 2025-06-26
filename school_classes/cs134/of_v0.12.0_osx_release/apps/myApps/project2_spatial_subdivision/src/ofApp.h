#pragma once

#include "ofMain.h"

// Addons
#include "ofxGui.h"
#include "ofxAssimpModelLoader.h"

// <>
#include <glm/gtx/intersect.hpp>
#include <set>
#include "glm/gtx/quaternion.hpp"

// Main files
#include "generics/main.h"
#include "physics/main.h"



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
		void dragEvent2(ofDragInfo dragInfo);
		void dragEvent(ofDragInfo dragInfo);
		void gotMessage(ofMessage msg);
		void drawAxis(ofVec3f);
		void initLightingAndMaterials();
		void savePicture();
		void toggleWireframeMode();
		void togglePointsDisplay();
		void toggleSelectTerrain();
		void setCameraTarget();
		bool tryCollisions();
		void drawBox(const Box &box);
		bool mouseIntersectPlane(ofVec3f planePoint, ofVec3f planeNorm, ofVec3f &point);
		bool raySelectWithOctree(ofVec3f &pointRet);
		glm::vec3 getMousePointOnPlane(glm::vec3 p , glm::vec3 n);
		void loadVbo();

		ofEasyCam  mainCam;
		ofCamera topCam;
		ofCamera sideCam;
		ofCamera* cam;    // set to current camera either mainCam or sideCam

		ofxAssimpModelLoader mars, lander;
		ofLight light, light1, light2, light3;
		Box boundingBox, landerBounds;
		Box testBox;
		vector<Box> colBoxList;
		bool bLanderSelected = false;
		Octree octree;
		TreeNode selectedNode;
		glm::vec3 mouseDownPos, mouseLastPos;
		bool bInDrag = false;

		ofImage stars;

		// Sound
		ofSoundPlayer thrustSoundPlayer;
		ofSoundPlayer explosionSoundPlayer;

		// textures
		ofTexture  particleTex;

		// shaders
		ofVbo vbo;
		ofShader shader;

		// Designated Areas
		Box area1, area2, area3;

		// Physics
		ParticleEmitter emitter;
		GravityForce grav;
		ImpulseForce impulse;  // test for collisions;
		TurbulenceForce turbulence;
		bool stillColliding = false;

		// Flame effects
		ParticleEmitter thrustEmitter;
		ParticleEmitter explosionEmitter;

		// TODO: CHANGE VALUES DEPENDING ON TERRAIN
		float groundPlaneWidth = 100;
		float groundPlaneHeight = 100;
		// Particle* landerParticle;

		// Fuel
		float fuel = 120.0;
		float distance = 0;
		int score = 0;
		
		// Game states
		bool hasGameEnded = false;
		string endString = "";

		// Colors
		vector<ofColor> levelColors;

		// Draw sphere for intersection
		bool drawTerrainSphereIntersection = false;
		glm::vec3 terrainSphereIntersectionPos = glm::vec3(0);

		// Collision resolution
		const float moveAmount = 0.05f;
		float moveAmountMultiplier = 1;
		bool animateLander = false;
		glm::vec3 headingVector = glm::vec3(0, 0, 1);

		ofxIntSlider numLevels;
		ofxIntSlider skipCollisionFramesGUI;
		int skipCollisionFramesCounter = 0;
		ofxFloatSlider restitutionGUI;
		ofxFloatSlider gravityGUI;
		ofxFloatSlider dampingGUI;
		ofxFloatSlider horizontalThrustGUI;
		ofxFloatSlider verticalThrustGUI;
		ofxFloatSlider rotationalThrustGUI;

		ofxToggle timingInfoGUI;
		ofxPanel gui;

		bool hideGUI = true;
		bool hideInfo = false;
		bool bAltKeyDown;
		bool bCtrlKeyDown;
		bool bWireframe;
		bool bDisplayPoints;
		bool bPointSelected;
		bool bHide;
		bool pointSelected = false;
		bool bDisplayLeafNodes = false;
		bool bDisplayOctree = false;
		bool bDisplayBBoxes = false;
		
		bool bLanderLoaded;
		bool bTerrainLoaded;
		bool bTerrainSelected;
	
		ofVec3f selectedPoint;
		ofVec3f intersectPoint;

		vector<Box> bboxList;

		const float selectionRange = 4.0;

		bool rightArrowKeyDown = false;
		bool leftArrowKeyDown = false;
		bool upArrowKeyDown = false;
		bool downArrowKeyDown = false;
		bool shiftKeyDown = false;
		bool spacebarKeyDown = false;
};