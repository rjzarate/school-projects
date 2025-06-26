#pragma once

#include "scene_objects/generics/Shape.h"

// Shape with physics

class PhysicsShape : public Shape {
public:
	glm::vec3 velocity = glm::vec3(0, 0, 0);
	glm::vec3 acceleration = glm::vec3(0, 0, 0);
	glm::vec3 force = glm::vec3(0, 0, 0);
	float mass = 1.0;
	float damping = .99;

	// Rotation
	float rotationalVelocity;
	float rotationalAcceleration;
	float rotationalForce;


	void integrate(bool clampToScreen = false);
};