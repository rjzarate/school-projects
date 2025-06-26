#pragma once

#include "scene_objects/generics/Sprite.h"

//  Pure Virtual Function Class - must be subclassed to create new forces.
//
class ParticleForce {
protected:
public:
	bool applyOnce = false;
	bool applied = false;
	virtual void updateForce(Sprite *) = 0;
};