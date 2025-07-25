
// Kevin M.Smith - CS 134 SJSU

#include "ParticleSystem.h"

void ParticleSystem::add(const Particle &p) {
	particles.push_back(p);
}

void ParticleSystem::addForce(ParticleForce *f) {
	forces.push_back(f);
}

void ParticleSystem::remove(int i) {
	particles.erase(particles.begin() + i);
}

void ParticleSystem::update() {
	// check if empty and just return
	if (particles.size() == 0) return;

	vector<Particle>::iterator p = particles.begin();
	vector<Particle>::iterator tmp;

	// check which particles have exceed their lifespan and delete
	// from list.  When deleting multiple objects from a vector while
	// traversing at the same time, we need to use an iterator.
	//
	while (p != particles.end()) {
		if (p->lifespan != -1 && p->age() > p->lifespan) {
			tmp = particles.erase(p);
			p = tmp;
		}
		else p++;
	}

	// update forces on all particles first 
	//
	for (int i = 0; i < particles.size(); i++) {
		for (int k = 0; k < forces.size(); k++) {
			forces[k]->updateForce( &particles[i] );
		}
	}

	// integrate all the particles in the store
	//
	for (int i = 0; i < particles.size(); i++)
		particles[i].integrate();

}

// remove all particlies within "dist" of point (not implemented as yet)
//
int ParticleSystem::removeNear(const ofVec3f & point, float dist) { return 0; }

//  draw the particle cloud
//
void ParticleSystem::draw() {
	for (int i = 0; i < particles.size(); i++) {
		particles[i].draw();
	}
}


// Gravity Force Field 
//
GravityForce::GravityForce(const ofVec3f &g) {
	gravity = g;
}

void GravityForce::set(const ofVec3f &g) {
	gravity = g;
}

void GravityForce::updateForce(Particle * particle) {
	if (!isEnabled) return;
	//
	// f = mg
	//
	particle->forces += gravity * particle->mass;
}

// Turbulence Force Field 
//
TurbulenceForce::TurbulenceForce(const ofVec3f &min, const ofVec3f &max) {
	tmin = min;
	tmax = max;
}

void TurbulenceForce::set(const ofVec3f &min, const ofVec3f &max) {
	tmin = min;
	tmax = max;
}

void TurbulenceForce::updateForce(Particle * particle) {
	if (!isEnabled) return;
	//
	// We are going to add a little "noise" to a particles
	// forces to achieve a more natual look to the motion
	//
	particle->forces.x += ofRandom(tmin.x, tmax.x);
	particle->forces.y += ofRandom(tmin.y, tmax.y);
	particle->forces.z += ofRandom(tmin.z, tmax.z);
}

NoiseForce::NoiseForce(const ofVec3f &min, const ofVec3f &max) {
	this->min = min;
	this->max = max;
}

void NoiseForce::set(const ofVec3f &min, const ofVec3f &max) {
	this->min = min;
	this->max = max;
}

void NoiseForce::updateForce(Particle * particle) {
	if (!isEnabled) return;

	// Adds "noise" using the ofNoise function and time
	float time = ofGetElapsedTimef();

	// Need offset to have different noise values from other particles
	// DEPRICATED: Need lifespan to have different noise values from it's 3 values (x, y, z)
		// Just add Turbulence for more randomness
	particle->forces.x += ofLerp(min.x, max.x, ofNoise(time - particle->lifespan));
	particle->forces.y += ofLerp(min.y, max.y, ofNoise(time));
	particle->forces.z += ofLerp(min.z, max.z, ofNoise(time + particle->lifespan));
	
}