#include "rendering/shapes/Plane.h"

Plane::Plane(glm::vec3 p, glm::vec3 n, ofColor diffuse, float w, float h) {
    this->position = p;
    this->normal = n;
    this->width = w;
    this->height = h;
    this->diffuseColor = diffuse;
    // plane.rotateDeg(90, 1, 0, 0);
    this->plane.lookAt(n);

    // Dragging
    isSelectable = false;
}
Plane::Plane() { 
    // Dragging
    isSelectable = false;
}

// Intersect Ray with Plane  (wrapper on glm::intersect*
//
bool Plane::intersect(const Ray &ray, glm::vec3 & point, glm::vec3 & normalAtIntersect) {
    float dist;
    bool hit = glm::intersectRayPlane(ray.p, ray.d, this->position, this->normal, dist);
    if (hit) {
        Ray r = ray;
        point = r.evalPoint(dist);
        normalAtIntersect = this->normal;
    }
    return (hit);
}

void Plane::draw() {
    plane.setPosition(position);
    plane.setWidth(width);
    plane.setHeight(height);
    plane.setResolution(4, 4);
    plane.drawWireframe();
}