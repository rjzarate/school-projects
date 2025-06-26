#pragma once

#include "ofMain.h"
#include "rendering/lights/Light.h"
#include "rendering/lights/SpotlightPointer.h"

class Spotlight : public Light {
    public:
    Spotlight(glm::vec3 p, float lightIntensity, ofColor color = ofColor::white, float radius = 0.2f, SpotlightPointer * pointer = NULL);

    // Rotate based on the DIRECTION point
    virtual glm::mat4 getMatrix();
    virtual void draw();
    bool isIlluminating(glm::vec3 &p);
    void addRadius(float x);

    float radius = 0.2f;
    SpotlightPointer * pointer;
};