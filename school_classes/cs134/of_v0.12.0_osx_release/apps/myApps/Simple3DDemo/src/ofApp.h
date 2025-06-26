#pragma once

#include "ofMain.h"
#include "ofxGUI.h"
#include <glm/gtx/intersect.hpp>

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

		ofEasyCam cam;
		vector<glm::vec3> verts;

		bool bHide = false;
		ofxFloatSlider beta, gamma;
		ofxPanel gui;
		
        // Sphere intersection
    glm::vec3 spherePosition;
    bool showSphere = false;
    ofxToggle applyIntersection, hideSphere;
};
