#include "rendering/shapes/Sphere.h"

Sphere::Sphere(glm::vec3 p, float r, ofColor diffuse) {
    this->position = p;
    this->radius = r;
    this->diffuseColor = diffuse;
}
Sphere::Sphere() {

}
bool Sphere::intersect(const Ray &ray, glm::vec3 &point, glm::vec3 &normal) {
    return (glm::intersectRaySphere(ray.p, ray.d, this->position, this->radius, point, normal));
}
void Sphere::draw()  {
    ofDrawSphere(this->position, this->radius);
}