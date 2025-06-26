#pragma once

#include "scene_objects/generics/PhysicsShape.h"

// Base class for a Sprite. Can be instantiated on it's own (deafult)
// or subclassed to create a custom sprite.  Includes Shape transformations.
// If the sprite has no image set on it, then a simple triangle will be drawn.
//

class Sprite : public PhysicsShape {
public:
	Sprite();
	virtual ~Sprite();

	// some functions for highlighting when selected
	//
	virtual void draw();
	float age();
	void setImage(ofImage img);
	virtual bool inside(const glm::vec3 p);
	virtual void update();

	void setSelected(bool state);
	void setHighlight(bool state);
	bool isSelected();
	bool isHighlight();


	bool bHighlight = false;
	bool bSelected = false;
	bool bShowImage = false;

	glm::vec3 velocity = glm::vec3(0, 0, 0);
	float rotationSpeed = 0.0;
	float birthtime = 0; // elapsed time in ms
	float lifespan = -1;  //  time in ms
	string name =  "UnammedSprite";
	float width = 40;
	float height = 40;

    // Heading vector and movement
    glm::vec3 headingVector = glm::vec3(0, -1, 0);
    bool showHeadingVector = true;
    ofColor headingVectorColor = ofColor::red;
    float forwardSpeed = 1.0f;
    void forward(float);
    void rotate(glm::vec3);
	bool shouldRotateLeft(float, float);

	// Collision
	bool insideTriangle(const glm::vec3 p);


    
    glm::vec3 playerPosition;
    
	ofImage spriteImage;
    ofColor color = ofColor::yellow;

	// default verts for polyline shape if no image on sprite
	//
	vector<glm::vec3> verts;
};
