#pragma once

#include "rendering/SceneObject.h"
#include <glm/gtx/intersect.hpp>

//  General purpose plane
//
class Plane: public SceneObject {
public:
    Plane(glm::vec3 p, glm::vec3 n, ofColor diffuse = ofColor::darkOliveGreen, float w = 20, float h = 20);
    Plane();
    bool intersect(const Ray &ray, glm::vec3 & point, glm::vec3 & normal);
    void draw();
    glm::vec2 getTileUV(const glm::vec3 & p);
    glm::vec3 getTangent(const glm::vec3 & p);
    vector<glm::vec3> getEdges() const;

    ofPlanePrimitive plane;
    glm::vec3 normal = glm::vec3(0, 1, 0);
    float width = 20;
    float height = 20;
};