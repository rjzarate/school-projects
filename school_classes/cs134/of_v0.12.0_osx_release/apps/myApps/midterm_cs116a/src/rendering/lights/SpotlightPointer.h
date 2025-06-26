#pragma once

#include "ofMain.h"
#include "rendering/lights/Light.h"

class SpotlightPointer : public Light {
    public:
    SpotlightPointer(glm::vec3 p);
    virtual void draw();
};