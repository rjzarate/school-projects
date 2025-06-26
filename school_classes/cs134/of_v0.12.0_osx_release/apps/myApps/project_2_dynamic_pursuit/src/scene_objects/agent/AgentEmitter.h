#pragma once

#include "scene_objects/generics/Emitter.h"
#include "scene_objects/agent/Agent.h"

class AgentEmitter : public Emitter {
public:
	void spawnSprite();

	Player *player;
};