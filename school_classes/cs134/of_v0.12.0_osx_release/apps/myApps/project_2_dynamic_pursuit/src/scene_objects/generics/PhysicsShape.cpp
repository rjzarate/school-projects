#include "scene_objects/generics/PhysicsShape.h"


// Integrator for simple trajectory physics
//
void PhysicsShape::integrate(bool clampToScreen) {
	// init current framerate (or you can use ofGetLastFrameTime())
	//
	float framerate = ofGetFrameRate();
	float dt = 1.0 / framerate;

	// Implement Euler integrator here...
	// 
	// linear motion
	//
	pos = pos + velocity * dt;
	acceleration = (1 / mass) * force;
	velocity = velocity + acceleration * dt;
	velocity *= damping;

	// angular motion
	//
	rotation = rotation + rotationalVelocity * dt;
	rotationalAcceleration = (1 / mass) * rotationalForce;
	rotationalVelocity = rotationalVelocity + rotationalAcceleration * dt;
	rotationalVelocity *= damping;

	
	// zero out forces
	//
	force = glm::vec3(0, 0, 0);
	rotationalForce = 0;

	// Movement clamping borders
	if (!clampToScreen) return;
	if (pos.x < 0) pos.x = 0; // Left
	if (pos.y < 0) pos.y = 0; // Top
	if (pos.x > ofGetWindowWidth()) pos.x = ofGetWindowWidth(); // Right
	if (pos.y > ofGetWindowWidth()) pos.y = ofGetWindowHeight(); // Bottom
}