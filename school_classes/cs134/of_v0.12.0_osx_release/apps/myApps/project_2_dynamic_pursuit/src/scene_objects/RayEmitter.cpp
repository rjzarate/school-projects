#include "scene_objects/RayEmitter.h"

RayEmitter::RayEmitter() {
    Emitter();
}

void RayEmitter::spawnSprite() {   
    Sprite sprite;
    if (haveChildImage) sprite.setImage(childImage);
    sprite.color = ofColor::green;
    sprite.lifespan = lifespan;
    sprite.pos = pos;
    sprite.forwardSpeed = childSpeed;
    sprite.birthtime = ofGetElapsedTimeMillis();
    
    // Rotation is emitter rotation
    sprite.rotation = rotation;

    sys->add(make_unique<Sprite>(std::move(sprite)));

    lastSpawned = ofGetElapsedTimeMillis();
}