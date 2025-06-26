#include "rendering/Ray.h"

Ray::Ray(glm::vec3 p, glm::vec3 d) {
    this->p = p; this->d = d;
}
void Ray::draw(float t) { 
    ofDrawLine(p, p + t * d);
}

glm::vec3 Ray::evalPoint(float t) {
    return (p + t * d);
}