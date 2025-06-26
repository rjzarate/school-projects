#include "ImageShape.h"

bool ImageShape::inside(glm::vec3 p0) {
    // Get point in object space; have to add half of width and height later for transparency
    glm::vec4 p = (glm::inverse(getTransform()) * glm::vec4(p0, 1));
    
    // Check for bounds; can use absolute value
    if (!(glm::abs(p.x) < width / 2.0) || !(glm::abs(p.y) < height / 2.0)) return false;
    
    // Check if pixel is nontransparent; add half of width and height for top left
    p += glm::vec4(width / 2.0, height / 2.0, 0, 0);
    ofColor pixelColor = image.getColor(p.x, p.y);
    return pixelColor.a != 0;
}

void ImageShape::forward(float t) {
    // Move base on heading vector  f(t) = o + dt
    position += glm::rotate(glm::vec3(0, -1, 0), glm::radians(rotation), glm::vec3(0, 0, 1)) * t;
}

ImageShape::ImageShape() {
    // Transforms
    scale = glm::vec3(0.25, 0.25, 1);
    position = glm::vec3(ofGetWindowWidth() / 2.0, ofGetWindowHeight() / 2.0, 0);
    
    // Load image
    if (image.load("images/ship.png")) {
        cout << "image loaded" << endl;
    }
    
    // Set height and width and verts
    width = image.getWidth();
    height = image.getHeight();
    
    vertices.push_back(glm::vec3(width / -2.0, height / -2.0, 0));
    vertices.push_back(glm::vec3(width / 2.0, height / -2.0, 0));
    vertices.push_back(glm::vec3(width / 2.0, height / 2.0, 0));
    vertices.push_back(glm::vec3(width / -2.0, height / 2.0, 0));
    
    // Heading vector
    headingVector = glm::vec3(0, -1 * height, 0);
}

void ImageShape::draw() {
    // Transformation
    ofPushMatrix();
    ofMultMatrix(getTransform());
    
    // Draw image
    ofFill();
    ofSetColor(shapeColor);
    image.draw(glm::vec3(width / -2.0, height / -2.0, 0));
    
    // Draw rectangle
    if (showBounds) {
        ofNoFill();
        ofSetColor(boundsColor);
        ofDrawRectangle(width / -2.0, height / -2.0, width, height);
    }
    
    // Draw heading vector
    if (showHeadingVector) {
        ofFill();
        ofSetColor(headingVectorColor);
        ofDrawLine(glm::vec3(0, 0, 0), headingVector);
    }
    
    // Remove matrix transformation
    ofPopMatrix();
}
