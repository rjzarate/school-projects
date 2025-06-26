#pragma once

#include "rendering/SceneObject.h"
#include <glm/gtx/intersect.hpp>

//  Mesh class
//
class Mesh : public SceneObject {
    public:
    Mesh(glm::vec3 p, string fileName, ofColor diffuse = ofColor::lightGray);
    bool intersect(const Ray &ray, glm::vec3 &point, glm::vec3 &normal);
    void draw();

    vector<glm::vec3> vertices;
    vector<glm::vec3> faces;
    // bool showNormal;
    // bool fill;
    // float normalLength;
};