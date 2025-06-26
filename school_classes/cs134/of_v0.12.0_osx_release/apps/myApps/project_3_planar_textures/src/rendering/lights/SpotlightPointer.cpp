#include "rendering/lights/SpotlightPointer.h"

SpotlightPointer::SpotlightPointer(glm::vec3 p) : Light(p, 0) {

}

void SpotlightPointer::draw() {
    ofSetColor(63, 63, 63);
    ofDrawSphere(position, 0.2f);
}