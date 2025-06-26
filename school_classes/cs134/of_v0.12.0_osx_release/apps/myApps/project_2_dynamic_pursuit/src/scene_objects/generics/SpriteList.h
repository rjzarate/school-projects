#pragma once
#include "scene_objects/generics/Sprite.h"

//
//  Manages all Sprites in a system.  You can create multiple systems
//
class SpriteList {
public:
	SpriteList();
	void add(unique_ptr<Sprite>);
	void remove(int);
	void update();
	void draw();
	vector<unique_ptr<Sprite>> sprites;
};