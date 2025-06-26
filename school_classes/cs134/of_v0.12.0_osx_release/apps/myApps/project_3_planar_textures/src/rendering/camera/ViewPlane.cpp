#include "rendering/camera/ViewPlane.h"

// create reasonable defaults (6x4 aspect)
ViewPlane::ViewPlane() {
    min = glm::vec2(-3, -2);
    max = glm::vec2(3, 2);
    position = glm::vec3(0, 0, 5);
    normal = glm::vec3(0, 0, 1);      // viewplane currently limited to Z axis orientation
}

ViewPlane::ViewPlane(glm::vec2 min, glm::vec2 max) {
    this->min = min;
    this->max = max;
}

void ViewPlane::setSize(glm::vec2 min, glm::vec2 max) {
    this->min = min; 
    this->max = max; 
}

float ViewPlane::getAspect() { return getWidth() / getHeight(); }

// Convert (u, v) to (x, y, z)
// We assume u,v is in [0, 1]
//
glm::vec3 ViewPlane::toWorld(float u, float v) {
    float w = getWidth();
    float h = getHeight();
    return (glm::vec3((u * w) + min.x, (v * h) + min.y, position.z));
}

void ViewPlane::draw() {
    ofDrawRectangle(glm::vec3(min.x, min.y, position.z), getWidth(), getHeight());
}

float ViewPlane::getWidth() {
    return (max.x - min.x);
}
float ViewPlane::getHeight() {
    return (max.y - min.y);
}

glm::vec2 ViewPlane::topLeft() { return glm::vec2(min.x, max.y); }
glm::vec2 ViewPlane::topRight() { return max; }
glm::vec2 ViewPlane::bottomLeft() { return min;  }
glm::vec2 ViewPlane::bottomRight() { return glm::vec2(max.x, min.y); }