#pragma once

#include "rendering/Ray.h"
#include <glm/gtx/euler_angles.hpp>

//  Base class for any renderable object in the scene
//
class SceneObject {
public:
    public:
	virtual ~SceneObject() = default;
	virtual void draw() = 0;    // pure virtual funcs - must be overloaded
	virtual bool intersect(const Ray& ray, glm::vec3& point, glm::vec3& normal);
	virtual glm::vec3 getNormal(const glm::vec3& p);

	virtual glm::mat4 getMatrix();
	void setPosition(glm::vec3 p);
    glm::vec3 getPosition();
	void resetTransform();
	virtual glm::vec2 getTileUV(const glm::vec3 & p);
	// Uses UV coords (0.0 to 1.0)
	virtual ofColor getDiffuseTexturePixel(float u, float v);
	virtual ofColor getSpecularTexturePixel(float u, float v);
	virtual ofColor getNormalTexturePixel(float u, float v);
	virtual ofColor getDisplacementTexturePixel(float u, float v);
	virtual ofColor getAmbientOcclusionTexturePixel(float u, float v);
	virtual glm::vec3 getTangent(const glm::vec3 & p);

	// material properties (we will ultimately replace this with a Material class - TBD)
	//
	ofColor diffuseColor = ofColor::grey;    // default colors - can be changed.
	ofColor specularColor = ofColor::lightGray;
	

	// any data common to all scene objects goes here
	glm::vec3 position = glm::vec3(0, 0, 0);
	glm::vec3 rotation = glm::vec3(0, 0, 0);    // degrees
	glm::vec3 scale = glm::vec3(1, 1, 1);
	glm::mat4 transform;

	// Textures
	ofImage *diffuseTexture = NULL;
	ofImage *specularTexture = NULL;
	ofImage *normalTexture = NULL;
	ofImage *displacementTexture = NULL;
	ofImage *ambientOcclusionTexture = NULL;
	float displacementScale = 1.0f;
	glm::vec2 tileSize = glm::vec2(1, 1);

    // Ray trace
    bool willRender = true;

	// selection
	//
	bool isSelectable = true;
	bool isSelected = false;
	string name = "SceneObject";
};