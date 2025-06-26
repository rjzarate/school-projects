#pragma once

#include "scene_objects/generics/Sprite.h"
#include "scene_objects/RayEmitter.h"

class Player : public Sprite {
public:
	Player();
	void update();
	void shoot();

	Emitter *shootEmitter;
};