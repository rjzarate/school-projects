#include "scene_objects/Player.h"

Player::Player() {
    Sprite();
//		cout << "in Player Constuctor" << endl;
}

void Player::update() {
    
}

void Player::shoot() {
    // Set rayEmitter position and orientation to player
    shootEmitter->pos = pos;
    shootEmitter->rotation = rotation;
    shootEmitter->scale = scale;

    // Fire emitter
    shootEmitter->spawnSprite();
}