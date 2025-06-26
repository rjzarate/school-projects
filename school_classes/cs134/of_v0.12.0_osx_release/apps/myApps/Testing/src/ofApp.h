#pragma once

#include "Shape.h"
#include "ofxGUI.h"
#include "ofMain.h"
#include "TriangleShape.h"


class ofApp : public ofBaseApp{
    
	public:
		void setup() override;
		void update() override;
		void draw() override;
		void exit() override;

		void keyPressed(int key) override;
		void keyReleased(int key) override;
		void mouseMoved(int x, int y ) override;
		void mouseDragged(int x, int y, int button) override;
		void mousePressed(int x, int y, int button) override;
		void mouseReleased(int x, int y, int button) override;
		void mouseScrolled(int x, int y, float scrollX, float scrollY) override;
		void mouseEntered(int x, int y) override;
		void mouseExited(int x, int y) override;
		void windowResized(int w, int h) override;
		void dragEvent(ofDragInfo dragInfo) override;
		void gotMessage(ofMessage msg) override;
    
        
    
        glm::vec3 circlePosition = glm::vec3(500, 350, 0); // Changed during setup()
        glm::vec3 circleMouseOffsetPosition = glm::vec3(0, 0, 0);
        float radius = 100;
        bool isMouseOnCircle = false;
        // bool isMouseInCircle(glm::vec3 mousePosition) { return glm::distance(circlePosition, mousePosition) <= radius; }
    
    
    TriangleShape triangle;
//        glm::vec3 trianglePoints[3] = { glm::vec3(0, 0, 0), glm::vec3(100, 0, 0), glm::vec3(100, 100, 0) };
    bool isMouseOnTriangle = false;
    glm::vec3 lastMousePosition = glm::vec3(0, 0, 0);
    
    ImageShape ship;
    bool isMouseOnImage = false;
    
    ofxPanel gui;
    ofxFloatSlider scaleGUI;
    ofxToggle shipGUI, headingVectorGUI;
    bool shipGUISwap = false;
		
};
