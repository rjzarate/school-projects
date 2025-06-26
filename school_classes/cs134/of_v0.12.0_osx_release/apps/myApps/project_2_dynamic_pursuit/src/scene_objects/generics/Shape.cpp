#include "scene_objects/generics/Shape.h"

Shape::Shape() {

}

void Shape::draw() {
    // draw a box by defaultd if not overridden
    //
    ofPushMatrix();
    ofMultMatrix(getTransform());
    ofDrawBox(defaultSize);
    ofPopMatrix();
}

bool Shape::inside(glm::vec3 p) {
    cout << "Shape inside function unimplemented. Returning false." << endl;
    return false;
}

glm::mat4 Shape::getTransform() {
    glm::mat4 T = glm::translate(glm::mat4(1.0), glm::vec3(pos));
    glm::mat4 R = glm::rotate(glm::mat4(1.0), glm::radians(rotation), glm::vec3(0, 0, 1));
    glm::mat4 S = glm::scale(glm::mat4(1.0), scale);      // added this scale if you want to change size of object
    return T*R*S;
}