#pragma once

#include "ofMain.h"


// Basic Shape class supporting matrix transformations and drawing.
// 
//
class Shape {
public:
	Shape();
	virtual void draw();
	virtual bool inside(glm::vec3 p);
	glm::mat4 getTransform();

	glm::vec3 pos = glm::vec3(0);
	float rotation = 0.0;    // degrees 
	glm::vec3 scale = glm::vec3(1, 1, 1);
	float defaultSize = 20.0;
};