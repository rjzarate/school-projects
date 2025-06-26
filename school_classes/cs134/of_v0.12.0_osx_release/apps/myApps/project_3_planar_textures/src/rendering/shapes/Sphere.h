#pragma once

#include "rendering/SceneObject.h"
#include <glm/gtx/intersect.hpp>

//  General purpose sphere  (assume parametric)
//
class Sphere: public SceneObject {
public:
    Sphere(glm::vec3 p, float r, ofColor diffuse = ofColor::lightGray);
    Sphere();
    bool intersect(const Ray &ray, glm::vec3 &point, glm::vec3 &normal);
    void draw();

    glm::vec2 getTileUV(const glm::vec3 & p);
    glm::vec3 getTangent(const glm::vec3 & p);

    float radius = 1.0;
};