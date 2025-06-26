#pragma once

#include "ofMain.h"
#include "glm/gtx/intersect.hpp"

class Sphere {
    public: 
    
    glm::vec3 pos = glm::vec3(0, 0, 0);
	ofColor color = ofColor::green;
    float radius = 1.0;
    void draw() {
        ofDrawSphere(pos, radius);
    }
    bool intersect(glm::vec3 p, glm::vec3 d, glm::vec3 &intersectPoint) {
        glm::vec3 point, norm;
        return glm::intersectRaySphere(p, d, pos, radius, intersectPoint, norm);
    }

};

class Plane {
    public: 
    
    glm::vec3 pos;
    glm::vec3 normal;
    void draw() {
        
    }
    bool intersect(glm::vec3 p, glm::vec3 d, glm::vec3 &intersectPoint) {
        float dist;
        
        if (glm::intersectRayPlane(p, d, pos, normal, dist)) {
            intersectPoint = p + d * dist;
            return true;
        }
        
        
        return false;
    }

};

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
		

		ofEasyCam cam;
		Sphere sphere;
        bool isSphereClicked = false;
        glm::vec3 lastPlaneClickedPosition;
		Plane plane;
};
