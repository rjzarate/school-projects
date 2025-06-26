#pragma once

#include "scene_objects/generics/Sprite.h"
#include "scene_objects/Player.h"

class Agent : public Sprite {
public:
	Agent();
	void update();

	Player *player;
};