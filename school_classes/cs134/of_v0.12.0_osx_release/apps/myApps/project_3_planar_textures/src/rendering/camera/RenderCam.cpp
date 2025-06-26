#include "rendering/camera/RenderCam.h"

RenderCam::RenderCam() {
    position = glm::vec3(0, 0, 10);
    aim = glm::vec3(0, 0, -1);
}

// Get a ray from the current camera position to the (u, v) position on
// the ViewPlane
//
Ray RenderCam::getRay(float u, float v) {
    glm::vec3 pointOnPlane = view.toWorld(u, v);
    return(Ray(position, glm::normalize(pointOnPlane - position)));
}

void RenderCam::draw() {
    ofDrawBox(position, 1.0);
}

// This could be drawn a lot simpler but I wanted to use the getRay call
// to test it at the corners.
//
void RenderCam::drawFrustum() {
    Ray r1 = getRay(0, 0);
    Ray r2 = getRay(0, 1);
    Ray r3 = getRay(1, 1);
    Ray r4 = getRay(1, 0);
    float dist = glm::length((view.toWorld(0, 0) - position));
    r1.draw(dist);
    r2.draw(dist);
    r3.draw(dist);
    r4.draw(dist);
}