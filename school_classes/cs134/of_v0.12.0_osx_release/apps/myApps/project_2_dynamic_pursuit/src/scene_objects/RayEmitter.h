#pragma once

#include "scene_objects/generics/Emitter.h"

//  Emitter for player guns
class RayEmitter : public Emitter {
public:
    RayEmitter();
    void spawnSprite();
};

