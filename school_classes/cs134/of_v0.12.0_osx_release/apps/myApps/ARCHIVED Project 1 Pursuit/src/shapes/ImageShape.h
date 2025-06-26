#pragma once

#include "Shape.h"

class ImageShape : public Shape {
public:
    ImageShape();
    
    // Collision and Physics
    bool inside(glm::vec3 p);
    void forward(float t);
    
    // Getters and Setters
    int getWidth() { return width; }
    int getHeight() { return height; }
    ofImage getImage() { return image; }
    
    // Open Frameworks functions
    void draw();
    
    // Debugging
    ofColor getBoundsColor() { return boundsColor; }
    void setBoundsColor(ofColor color) { boundsColor = color; }
    void setShowBounds(bool b) { showBounds = b; }
    
protected:
    // Visuals
    ofImage image;
    int width, height;
    
    // Debugging
    ofColor boundsColor = ofColor::blue;
    bool showBounds = false;
};
