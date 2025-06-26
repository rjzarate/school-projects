#pragma once

#include "ofMain.h"
#include "rendering/SceneObject.h"
#include <glm/gtx/euler_angles.hpp>
#include <glm/gtx/intersect.hpp>

// Light class
class Light : public SceneObject {
    public:
    Light(glm::vec3 position, float lightIntensity, ofColor color = ofColor::white);
    virtual void draw();
    virtual bool intersect(const Ray &ray, glm::vec3 &point, glm::vec3 &normal);
    virtual bool isIlluminating(glm::vec3 &p);

    float lightIntensity;
    ofColor color;
};