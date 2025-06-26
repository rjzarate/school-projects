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

glm::vec2 Sphere::getTileUV(const glm::vec3 & point) {
    // Get direction vector
    glm::vec3 direction = glm::normalize(point - position);

    // Get pitch (lattitude) and yaw (longitude) for uv
    float pitch = asin(-direction.y);
    float yaw = atan2(direction.x, direction.z);

    // Convert to uv coords 0 to 1
    float u = (pitch + HALF_PI) / PI;
    float v = 0.5f + (yaw + HALF_PI) / PI;

    return glm::vec2(u, v);
}

glm::vec3 Sphere::getTangent(const glm::vec3 & point) {
    // Get direction
    glm::vec3 direction = glm::normalize(point - position);

    // Choose an arbitrary vector that is not parallel to direction
    glm::vec3 arbitrary = glm::abs(direction.y) < 0.999f ? glm::vec3(0, 1, 0) : glm::vec3(1, 0, 0);

    // Compute the tangent by taking the cross product
    glm::vec3 tangent = glm::normalize(glm::cross(direction, arbitrary));

    return tangent;
}