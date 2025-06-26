#include "rendering/lights/Spotlight.h"

Spotlight::Spotlight(glm::vec3 p, float lightIntensity, ofColor color, float radius, SpotlightPointer * pointer)
        : Light(p, lightIntensity, color) {
    this->pointer = pointer;
    this->radius = radius;

    if (pointer == NULL) {
        this->pointer = new SpotlightPointer(position + glm::vec3(0, -2, 0));
    }
}

// Rotate based on the DIRECTION point
glm::mat4 Spotlight::getMatrix() {
    glm::mat4 T = glm::translate(glm::mat4(1.0), glm::vec3(position));
    //glm::mat4 R = glm::eulerAngleYXZ(glm::radians(rotation.y), glm::radians(rotation.x), glm::radians(rotation.z));   // yaw, pitch, roll 
    
    // Get look direction towards the pointer
    glm::vec3 direction = pointer->position - this->position;
    glm::mat4 D;
    if (normalize(direction).y > 0) {
        // Upper half, use up vector
        D = glm::lookAt(glm::vec3(0, 0, 0), normalize(direction), glm::vec3(0.0f, 0.0f, 1.0f));
    } else {
        // Lower half, use down vector
        D = glm::lookAt(glm::vec3(0, 0, 0), normalize(direction), glm::vec3(0.0f, 0.0f, -1.0f));
    }
    // Transpose to avoid x-axis gimble lock
    D = glm::transpose(D);
    
    // Orient so that the base is looking at the bottom
    glm::mat4 R = glm::eulerAngleYXZ(0.0f, glm::radians(-90.0f), 0.0f);

    glm::mat4 S = glm::scale(glm::mat4(1.0), scale);      // added this scale if you want to change size of object
    return T * D * R * S;
}

void Spotlight::draw() {
    ofPushMatrix();
    ofMultMatrix(getMatrix());

    ofSetColor(255, 255, 0);
    ofDrawCone(glm::vec3(0, 0, 0), radius, 0.2f);

    ofPopMatrix();

    // Line to pointer
    ofSetColor(color);
    ofDrawLine(glm::vec3(position), glm::vec3(pointer->position));
}

bool Spotlight::isIlluminating(glm::vec3 &p) {
    // // Create ray from point to this light
    // Ray ray = Ray(position, glm::normalize(p - position));

    // // Check if it intersects the radius
    // glm::vec3 point, normal;
    // glm::vec3 direction = (0.1f + glm::sqrt(radius)) * glm::normalize(pointer->position - position);
    // return glm::intersectRaySphere(ray.p, ray.d, position + direction, glm::sqrt(radius), point, normal);

    // Get point direction and pointer direction
    glm::vec3 a = p - position;
    glm::vec3 b = pointer->position - position;

    // Get angle
    float angle = glm::acos(
        glm::dot(a, b) /
        (
            glm::length(a) * glm::length(b)
        )
    );
    
    // Get spotlight angle
    float spotlightAngle = glm::atan(
        radius / 0.2f
    );

    return spotlightAngle > angle;
    
}

void Spotlight::addRadius(float x) {
    // Make sure to not go below 0
    if (radius + x < 0.0f) return;
    
    radius += x;
}