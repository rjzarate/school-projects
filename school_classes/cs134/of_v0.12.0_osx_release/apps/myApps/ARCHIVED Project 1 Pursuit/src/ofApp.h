#pragma once

// generics folder
#include "Health.h"

// shapes folder
#include "TriangleShape.h"
#include "ImageShape.h"
#include "Shape.h"

#include "ofMain.h"

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
    
private:
    TriangleShape triangleShape = TriangleShape(glm::vec3(90, 90, 0), glm::vec3(50, 50, 1), glm::vec3(1, 1, 0), glm::vec3(-1, 1, 0), glm::vec3(0, -2, 0));
};
