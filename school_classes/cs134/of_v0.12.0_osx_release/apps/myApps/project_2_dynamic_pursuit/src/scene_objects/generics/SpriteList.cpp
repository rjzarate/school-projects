#include "scene_objects/generics/SpriteList.h"

// Empty constructor
SpriteList::SpriteList() {

}

//  Add a Sprite to the Sprite System
//
void SpriteList::add(unique_ptr<Sprite> s) {
	sprites.push_back(std::move(s));
}

// Remove a sprite from the sprite system. Note that this function is not currently
// used. The typical case is that sprites automatically get removed when the reach
// their lifespan.
//
void SpriteList::remove(int i) {
	if (i >= 0 && i < sprites.size()) {
		sprites.erase(sprites.begin() + i);
	}
}


//  Update the SpriteSystem by checking which sprites have exceeded their
//  lifespan (and deleting).  Also the sprite is moved to it's next
//  location based on velocity and direction.
//
void SpriteList::update() {
	// Delete if no lifespan	
	for (int i = sprites.size() - 1; i >= 0; i--) {
		if (sprites[i]->lifespan != -1 && sprites[i]->age() > sprites[i]->lifespan) {
			remove(i);
		}
	}

	// Update sprites (usually for movement)
	for (auto &sprite : sprites) {
		sprite->update();
	}
}

//  Render all the sprites
void SpriteList::draw() {
	for (auto &sprite: sprites) {
		sprite->draw();
	}
}