#pragma once

#include "scene_objects/generics/SpriteList.h"

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
	virtual bool inside(glm::vec3 p);

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

