#include "Shape.h"

glm::mat4 Shape::getTransform() {
    glm::mat4 trans = glm::translate(glm::mat4(1.0), glm::vec3(position));
    glm::mat4 rot = glm::rotate(glm::mat4(1.0), glm::radians(rotation),
    glm::vec3(0, 0, 1));
    glm::mat4 scale = glm::scale(glm::mat4(1.0), this->scale);
    return (trans * rot * scale);
}

