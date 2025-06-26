#include "rendering/lights/Light.h"

Light::Light(glm::vec3 position, float lightIntensity, ofColor color) { 
    this->position = position; 
    this->lightIntensity = lightIntensity;
    this->color = color;

}

void Light::draw() {
    ofSetColor(255, 255, 0);
    ofDrawSphere(position, 0.2f);

    // // Draw with light intensity
    // float lightIntensityDistance = glm::sqrt(lightIntensity);
    // ofSetColor(color, 63);
    // ofDrawLine(position - glm::vec3(lightIntensityDistance / 0.1, 0, 0), position + glm::vec3(lightIntensityDistance / 0.1, 0, 0));
    // ofDrawLine(position - glm::vec3(0, lightIntensityDistance / 0.1, 0), position + glm::vec3(0, lightIntensityDistance / 0.1, 0));
    // ofDrawLine(position - glm::vec3(0, 0, lightIntensityDistance / 0.1), position + glm::vec3(0, 0, lightIntensityDistance / 0.1));
    
    // // Draw light intensity circle
    // ofDrawCircle(position, lightIntensityDistance);
    // ofPushMatrix();
    // glm::mat4 T = glm::translate(glm::mat4(1.0), glm::vec3(position));
    // glm::mat4 R = glm::eulerAngleYXZ(0.0, HALF_PI, 0.0);
    // glm::mat4 S = glm::scale(glm::mat4(1.0), scale);
    // ofMultMatrix(T * R * S);
    // ofDrawCircle(glm::vec3(0), lightIntensityDistance);
    // ofPopMatrix();

    // ofPushMatrix();
    // T = glm::translate(glm::mat4(1.0), glm::vec3(position));
    // R = glm::eulerAngleYXZ(HALF_PI, 0.0, 0.0);
    // S = glm::scale(glm::mat4(1.0), scale);
    // ofMultMatrix(T * R * S);
    // ofDrawCircle(glm::vec3(0), lightIntensityDistance);
    // ofPopMatrix();
}

bool Light::intersect(const Ray &ray, glm::vec3 &point, glm::vec3 &normal) {
    return (glm::intersectRaySphere(ray.p, ray.d, position, 0.2f, point, normal));
}

bool Light::isIlluminating(glm::vec3 &p) {
    return true;
}