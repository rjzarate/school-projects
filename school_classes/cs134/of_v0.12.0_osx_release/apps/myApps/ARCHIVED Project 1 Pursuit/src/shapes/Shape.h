#pragma once

#include "ofMain.h"

class Shape {
public:
    // Collision and Physics
    glm::mat4 getTransform();
    virtual bool inside(glm::vec3 point) { return false; }
    virtual void forward(float t) { }
    
    // Getters and Setters
    ofColor getShapeColor() { return shapeColor; }
    
    // Open Frameworks functions
    virtual void draw() { cout << this << "draw function not implement" << endl; }
    
    // Debugging
    ofColor getHeadingVectorColor() { return headingVectorColor; }
    void setHeadingVectorColor(ofColor color) { headingVectorColor = color; }
    void setShowHeadingVector(bool b) { showHeadingVector = b; }

protected:
    // Transformations
    glm::vec3 position = glm::vec3(0, 0, 0);
    float rotation = 0;
    glm::vec3 scale = glm::vec3(1, 1, 1);
    
    // Vertices and points
    vector<glm::vec3> vertices;
    glm::vec3 headingVector = glm::vec3(0, 1, 0);
    
    // Visuals
    ofColor shapeColor = ofColor::white;
    
    // Debugging
    ofColor headingVectorColor = ofColor::red;
    bool showHeadingVector = false;
};
