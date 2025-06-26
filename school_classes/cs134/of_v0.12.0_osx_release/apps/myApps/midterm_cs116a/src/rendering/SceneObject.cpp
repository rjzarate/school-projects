#include "rendering/SceneObject.h"

bool SceneObject::intersect(const Ray& ray, glm::vec3& point, glm::vec3& normal) {
    return false;
}

glm::vec3 SceneObject::getNormal(const glm::vec3& p) {
    return glm::vec3(1, 0, 0);
}

glm::mat4 SceneObject::getMatrix() {
    glm::mat4 T = glm::translate(glm::mat4(1.0), glm::vec3(position));
    glm::mat4 R = glm::eulerAngleYXZ(glm::radians(rotation.y), glm::radians(rotation.x), glm::radians(rotation.z));   // yaw, pitch, roll 
    glm::mat4 S = glm::scale(glm::mat4(1.0), scale);      // added this scale if you want to change size of object
    return T * R * S;
}

void SceneObject::setPosition(glm::vec3 p) {
    position = p;
    transform = getMatrix();
}

glm::vec3 SceneObject::getPosition() {
    return position;
}

void SceneObject::resetTransform() {
    transform = getMatrix();
}