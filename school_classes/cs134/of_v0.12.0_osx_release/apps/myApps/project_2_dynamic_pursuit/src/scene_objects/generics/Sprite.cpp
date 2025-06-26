#include "scene_objects/generics/Sprite.h"

// Constructor
Sprite::Sprite() {
    // default geometry (triangle) if no image attached.
    //
    verts.push_back(glm::vec3(-20, 30, 0));
    verts.push_back(glm::vec3(20, 30, 0));
    verts.push_back(glm::vec3(0, -30, 0));
}

// Deconstructor
Sprite::~Sprite() {
    
}

void Sprite::update() {
    forward(1.0f);
}

void Sprite::draw() {
    // Case: Image
    if (bShowImage) {
        ofPushMatrix();
        ofSetColor(ofColor::white);
        ofMultMatrix(getTransform());
        spriteImage.draw(-spriteImage.getWidth() / 2, -spriteImage.getHeight() / 2.0);
        ofPopMatrix();
        return;
    }

    // Case: Shape
    if (bHighlight) ofSetColor(ofColor::white);
    else ofSetColor(color);

    ofPushMatrix();
    ofMultMatrix(getTransform());
    ofDrawTriangle(verts[0], verts[1], verts[2]);
    ofPopMatrix();
}

float Sprite::age() {
	return (ofGetElapsedTimeMillis() - birthtime);
}

void Sprite::setImage(ofImage img) {
    spriteImage = img;
    bShowImage = true;
    width = img.getWidth();
    height = img.getHeight();
}
void Sprite::setSelected(bool state) { bSelected = state; }
void Sprite::setHighlight(bool state) { bHighlight = state; }
bool Sprite::isSelected() { return bSelected; }
bool Sprite::isHighlight() { return bHighlight; }

//
	// inside - check if point is inside player (can be an image or TriangleShape if no image)
	//
bool Sprite::inside(const glm::vec3 p) {

    
	// if there is no sprite image attached, then just use triangle case.
	//
	if (!bShowImage) {
		return insideTriangle (p);
	}

	// if sprite image attached, then first check if point is inside bounds of image
	// in object space.  If point is inside bounds, then make sure the point is in
	// opaque part of image.
	//
	glm::vec3 s = glm::inverse(getTransform()) * glm::vec4(p, 1);
	int w = spriteImage.getWidth();
	int h = spriteImage.getHeight();
	if (s.x > -w / 2 && s.x < w / 2 && s.y > -h / 2 && s.y < h / 2) {
		int x = s.x + w / 2;
		int y = s.y + h / 2;
		ofColor color = spriteImage.getColor(x, y);
		return (color.a != 0);   // check if color is opaque (not the transparent background)
	}
	else return false;
}


bool Sprite::insideTriangle(const glm::vec3 p) {

	// transform the screen space point p to the triangle's local 
	// oordinate system  (object space);  this will take into account any
	// rotation, translation or scale on the object.
	//
	glm::vec4 p2 = glm::inverse(getTransform()) * glm::vec4(p, 1);

	glm::vec3 v1 = glm::normalize(verts[0] - p2);
	glm::vec3 v2 = glm::normalize(verts[1] - p2);
	glm::vec3 v3 = glm::normalize(verts[2] - p2);
	float a1 = glm::orientedAngle(v1, v2, glm::vec3(0, 0, 1));
	float a2 = glm::orientedAngle(v2, v3, glm::vec3(0, 0, 1));
	float a3 = glm::orientedAngle(v3, v1, glm::vec3(0, 0, 1));
	if (a1 < 0 && a2 < 0 && a3 < 0) return true;
	else return false;

}

void Sprite::forward(float t) {
    // Move base on heading vector (glm::vec3(0, n, 0))
    // f(t) = o + dt
    pos += glm::rotate(headingVector, glm::radians(rotation), glm::vec3(0, 0, 1)) * forwardSpeed * t / ofGetFrameRate();
}

void Sprite::rotate(glm::vec3 loc) {
    if (rotationSpeed == 0) return;
    // Fix rotation to 0 - 360
    while (rotation < 0) rotation += 360;
    while (rotation > 360) rotation -= 360;
    
    glm::vec3 v1 = glm::normalize(loc - pos);
    glm::vec3 v2 = glm::vec3(0, -1, 0);
    
    // Get angle from 0 - 360
    float angle = glm::degrees(glm::orientedAngle(v1, v2, glm::vec3(0, 0, 1)));
    if (angle >= 0) {
        angle = 360 - angle;
    } else {
        angle = glm::abs(angle);
    }

    // Edge case: current angle is less than then rotation speed
    if (glm::abs(glm::abs(rotation) - angle) < glm::abs(rotationSpeed)) {
        rotation = angle;
        return;
    }
    
    if (shouldRotateLeft(rotation, angle)) {
        rotation -= rotationSpeed;
    } else {
        rotation += rotationSpeed;
    }
    while (rotation > 360) rotation -= 360;
    while (rotation < 0) rotation += 360;
}

bool Sprite::shouldRotateLeft(float currentAngle, float targetAngle) {
    // Normalize the angles to the range [0, 360)
    currentAngle = fmod(currentAngle, 360.0);
    if (currentAngle < 0) currentAngle += 360.0;
    
    targetAngle = fmod(targetAngle, 360.0);
    if (targetAngle < 0) targetAngle += 360.0;

    // Calculate the difference between target and current angle
    float diff = fmod(targetAngle - currentAngle, 360.0);
    if (diff < 0) diff += 360.0;

    // If the difference is less than 180 degrees, it's faster to rotate right
    // If the difference is greater than 180 degrees, it's faster to rotate left
    return (diff > 180.0);
}
