#include "scene_objects/particles/ParticleEmitter.h"

void ParticleEmitter::spawnSprite() {   
    Particle sprite;
    if (haveChildImage) sprite.setImage(childImage);
    sprite.color = ofColor::green;
    sprite.lifespan = lifespan;
    sprite.pos = pos;
    sprite.forwardSpeed = childSpeed;
    sprite.birthtime = ofGetElapsedTimeMillis();
    
    // NON PHYSICS
    // Rotation is random
    // sprite.rotation = ofRandom(0, 1) * 360;

    // PHYSICS
    // Forces is random
    // TODO: add GUI that modifies magnitude
    glm::vec3 force = glm::vec3(ofRandom(-1, 1), ofRandom(-1, 1), 0);
    float magnitude = 10000.0f;
    sprite.force += normalize(force) * magnitude;
    sprite.rotation = ofRandom(0, 1) * 360;

    sys->add(make_unique<Particle>(std::move(sprite)));

    lastSpawned = ofGetElapsedTimeMillis();
}