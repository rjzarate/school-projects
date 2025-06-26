#pragma once

#include "ofMain.h"

//  General Purpose Ray class
//
class Ray {
public:
    Ray(glm::vec3 p, glm::vec3 d);
    void draw(float t);
    glm::vec3 evalPoint(float t);

    glm::vec3 p, d;
};