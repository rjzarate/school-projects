#include "scene_objects/forces/ImpulseRadialForce.h"

// Impulse Radial Force - this is a "one shot" force that
// eminates radially outward in random directions.
//
ImpulseRadialForce::ImpulseRadialForce(float magnitude) {
	this->magnitude = magnitude;
	applyOnce = true;
}

void ImpulseRadialForce::updateForce(Sprite * sprite) {

	// we basically create a random direction for each particle
	// the force is only added once after it is triggered.
	//
	ofVec3f dir = ofVec3f(ofRandom(-1, 1), ofRandom(-1, 1), ofRandom(-1, 1));
	// dir.y *= height;
    dir.z = 0;
	sprite->force += dir.getNormalized() * magnitude;
}

void ImpulseRadialForce::set(float magnitude) {
    this->magnitude = magnitude;
}