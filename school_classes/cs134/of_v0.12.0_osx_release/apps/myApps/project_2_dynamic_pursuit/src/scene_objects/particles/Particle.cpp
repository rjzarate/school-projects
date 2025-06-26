#include "scene_objects/particles/Particle.h"

Particle::Particle() {
    Sprite();
//		cout << "in Agent Constuctor" << endl;
}

void Particle::update() {
    // Use physics: integrate
    integrate();
    rotation += rotationSpeed;
}