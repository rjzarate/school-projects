#pragma once

#include "ofMain.h"
#include "ofApp.h"

class Shape {
public:
    glm::mat4 getTransform();
    // transformations
    //
    glm::vec3 position = glm::vec3(0, 0, 0);
    float rotation = 0;
    glm::vec3 scale = glm::vec3(1, 1, 1);
    // methods of shape
    //
    virtual bool inside(glm::vec3 point) { return false; }
    virtual ofColor getColor() { return color; }
    // OF methods
    //
    virtual void draw() {}
    ofColor color = ofColor::blue;
};

class TriangleShape : public Shape {
public:
    TriangleShape();
    bool inside(glm::vec3 p);
    void draw();
    vector<glm::vec3> verts;
    
    // Initalized when running TriangleShape()
    glm::vec3 headingVector;
    bool showHeadingVector = true;
    ofColor headingVectorColor = ofColor::red;
    
    // Moving the triangle with a given parameter t
    void forward(float t);
};

class ImageShape : public Shape {
public:
    ImageShape();
    ofImage image;
    bool inside(glm::vec3 p);
    ofColor getColorWithPercentage(float x, float y);
    void draw();
    vector<glm::vec3> verts;
    int width, height;
    
    // Initalized when running TriangleShape()
    glm::vec3 headingVector;
    bool showHeadingVector = true;
    ofColor headingVectorColor = ofColor::red;
    
    // Moving the triangle with a given parameter t
    void forward(float t);
    
    // Bounding rectangle
    ofColor boundingColor = ofColor::blue;
    
    
};
