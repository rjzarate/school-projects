#pragma once

#include "scene_objects/forces/ParticleForce.h"

class ImpulseRadialForce : public ParticleForce {
    float magnitude;

public:
    ImpulseRadialForce(float);
    void updateForce(Sprite *);
    void set(float);
};