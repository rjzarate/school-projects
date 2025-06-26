#include "TriangleShape.h"

TriangleShape::TriangleShape(glm::vec3 position, glm::vec3 scale, glm::vec3 vertex0, glm::vec3 vertex1, glm::vec3 vertex2) {
    vertices.push_back(vertex0);
    vertices.push_back(vertex1);
    vertices.push_back(vertex2);
    this->scale = scale;
    this->position = position;
    
    // Heading vector
    // Choose greatest distance from the 3 points
    float distance = 0.0f;
    for (int i = 0; i < vertices.size(); i++) {
        glm::vec3 trianglePoint = vertices[i] + position;
        float pointDistance = glm::distance(trianglePoint, position);
        distance = (pointDistance > distance) ? pointDistance : distance;
    }
    headingVector = glm::vec3(0, -1 * distance * 3, 0);
}

bool TriangleShape::inside(glm::vec3 p0) {
    glm::vec3 p = glm::inverse(getTransform()) * glm::vec4(p0, 1);
    glm::vec3 v1 = glm::normalize(vertices[0] - p);
    glm::vec3 v2 = glm::normalize(vertices[1] - p);
    glm::vec3 v3 = glm::normalize(vertices[2] - p);
    float a1 = glm::orientedAngle(v1, v2, glm::vec3(0, 0, 1));
    float a2 = glm::orientedAngle(v2, v3, glm::vec3(0, 0, 1));
    float a3 = glm::orientedAngle(v3, v1, glm::vec3(0, 0, 1));
    return a1 < 0 && a2 < 0 && a3 < 0;
}

void TriangleShape::forward(float t) {
    // Move base on heading vector  f(t) = o + dt
    position += glm::rotate(glm::vec3(0, -1, 0), glm::radians(rotation), glm::vec3(0, 0, 1)) * t;
}

void TriangleShape::draw() {
    // Transformation
    ofPushMatrix();
    ofMultMatrix(getTransform());
    
    // Draw Triangle
    ofFill();
    ofSetColor(shapeColor);
    ofDrawTriangle(vertices[0], vertices[1], vertices[2]);
    
    // Draw heading vector
    if (showHeadingVector) {
        ofSetColor(headingVectorColor);
        ofDrawLine(glm::vec3(0, 0, 0), headingVector);
    }
    
    // Remove matrix transformation
    ofPopMatrix();
}
