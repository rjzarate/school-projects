#pragma once
#include "Shape.h"

class TriangleShape : public Shape {
public:
    TriangleShape(glm::vec3 position, glm::vec3 scale, glm::vec3 vertex0, glm::vec3 vertex1, glm::vec3 vertex2);
    
    // Collision and Physics
    void forward(float t);
    bool inside(glm::vec3 p0);
    
    // Open Frameworks functions
    void draw();
};
