#pragma once
//  Kevin M. Smith - CS 134 SJSU

#include "ofMain.h"
#include "Particle.h"


//  Pure Virtual Function Class - must be subclassed to create new forces.
//
class ParticleForce {
protected:
public:
	bool applyOnce = false;
	bool applied = false;
	virtual void updateForce(Particle *) = 0;
};

class ParticleSystem {
public:
	void add(const Particle &);
	void addForce(ParticleForce *);
	void remove(int);
	void update();
	void setLifespan(float);
	void reset();
	int removeNear(const ofVec3f & point, float dist);
	void draw();
	vector<Particle> particles;
	vector<ParticleForce *> forces;
};



// Some convenient built-in forces
//
class GravityForce: public ParticleForce {
	ofVec3f gravity;
public:
	GravityForce(const ofVec3f & gravity);
	void updateForce(Particle *);
	void set(const ofVec3f & gravity) { this->gravity = gravity; };
};

class TurbulenceForce : public ParticleForce {
	ofVec3f tmin, tmax;
public:
	TurbulenceForce(const ofVec3f & min, const ofVec3f &max);
	void updateForce(Particle *);
	void set(const ofVec3f & min, const ofVec3f &max) { this->tmin = min; this->tmax = max; }
};

class ImpulseRadialForce : public ParticleForce {
	float magnitude;
	
public:
	float height;

	ImpulseRadialForce(float magnitude, float height = 1.0f); 
	void updateForce(Particle *);
	void set(float magnitude) {this->magnitude = magnitude; }
};


class CyclicForce : public ParticleForce {
	float magnitude;
	ofVec3f *position;
	
public:
	CyclicForce(float magnitude, ofVec3f *position); 
	void updateForce(Particle *);
	void set(float magnitude) {this->magnitude = magnitude; }
};