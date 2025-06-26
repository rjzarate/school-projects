#pragma once

#include "ofMain.h"
#include "Shape.h"
#include "Sprite.h"

//
//  Manages all Sprites in a system.  You can create multiple systems
//
class SpriteList {
public:
	void add(Sprite);
	void remove(int);
	void update();
	void draw();
	vector<Sprite> sprites;
    
    Sprite player;
};


//  General purpose Emitter class for emitting sprites
//  This works similar to a Particle emitter
//
class Emitter : public Shape {
public:
	Emitter();
	void init();
	void draw();
	void start();
	void stop();
	void setLifespan(float);
	void setVelocity(const glm::vec3 v);
    void setChildForwardSpeed(float);
	void setChildImage(ofImage);
	void setImage(ofImage);
	void setRate(float);
    void setSpritesPerUpdate(int);
    void setChildScale(float);
    void setChildRotationSpeed(float);
    void setIsClicked(bool);
	void update();
	

	// virtuals - can overloaded
	virtual void moveSprite(Sprite *);
	virtual void spawnSprite();
	virtual bool inside(glm::vec3 p) {
		glm::vec3 s = glm::inverse(getTransform()) * glm::vec4(p, 1);
		return (s.x > -width / 2 && s.x < width / 2 && s.y > -height / 2 && s.y < height / 2);
	}

	SpriteList *sys;
	float rate;
	glm::vec3 velocity;
	float lifespan;
	bool started;
	float lastSpawned;
	ofImage childImage;
	ofImage image;
	bool drawable;
	bool haveChildImage;
	bool haveImage;
	float width, height;
    int spritesPerUpdate = 1;
    
    float childSpeed;
    float childScale;
    float childRotationSpeed;
    bool isClicked = false;
    ofColor emitterColor;
};

