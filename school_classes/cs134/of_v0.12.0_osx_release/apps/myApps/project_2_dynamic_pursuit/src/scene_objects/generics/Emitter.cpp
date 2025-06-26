//----------------------------------------------------------------------------------
//
// This example code demonstrates the use of an "Emitter" class to emit Sprites
// and set them in motion. The concept of an "Emitter" is taken from particle
// systems (which we will cover next week).
//
// The Sprite class has also been upgraded to include lifespan, velocity and age
// members.   The emitter can control rate of emission and the current velocity
// of the particles. In this example, there is no acceleration or physics, the
// sprites just move simple frame-based animation.
//
// The code shows a way to attach images to the sprites and optional the
// emitter (which is a point source) can also have an image.  If there are
// no images attached, a placeholder rectangle is drawn.
// Emitters  can be placed anywhere in the window. In this example, you can drag
// it around with the mouse.
//
// OF has an add-in called ofxGUI which is a very simple UI that is useful for
// creating sliders, buttons and fields. It is not recommended for commercial 
// game development, but it is useful for testing.  The "h" key will hide the GUI
// 
// If you want to run this example, you need to use the ofxGUI add-in in your
// setup.
//
//
//  Kevin M. Smith - CS 134 SJSU

#include "scene_objects/generics/Emitter.h"

Emitter::Emitter() {
	sys = new SpriteList();
	init();
}


void Emitter::init() {
	lifespan = 3000;    // default milliseconds
	started = false;

	lastSpawned = 0;
	rate = 1;    // sprites/sec
	haveChildImage = false;
	haveImage = false;
	velocity = ofVec3f(100, 100, 0);
	drawable = false;
	width = 50;
	height = 50;
    emitterColor = ofColor::blue;
    spritesPerUpdate = 1;

	childSpeed = 10.0f;
	childScale = 0.1f;
	childRotationSpeed = 0;
}



//  Draw the Emitter if it is drawable. In many cases you would want a hidden emitter
//
//
void Emitter::draw() {

	// draw the Emitter itself 
	// note: set drawable=false if you want the emitter to be invisible
	//
	if (drawable) {

		ofPushMatrix();
		ofMultMatrix(getTransform());

		if (haveImage) {
			image.draw(-image.getWidth() / 2.0, -image.getHeight() / 2.0);
		}
		else {
			// draw some default shape (square) if drawable but no image attached.
			//
            if (isClicked) {
                ofSetColor(ofColor::white);
            } else {
                ofSetColor(emitterColor);
            }

			ofDrawRectangle(-width / 2, -height / 2, width, height);
		}

		ofPopMatrix();
	}

	// draw sprite system
	//
	sys->draw();
}

//  Update the Emitter. If it has been started, spawn new sprites with
//  initial velocity, lifespan, birthtime.
//
void Emitter::update() {
	// Update sprite list
	sys->update();
	float time = ofGetElapsedTimeMillis();

	if (!started) return;
    
	if ((time - lastSpawned) > (1000.0 / rate)) {

		// call virtual to spawn a new sprite
		//
        for (int i = 0; i < spritesPerUpdate; i++) {
            spawnSprite();
        }
	}


    
//
//	// update sprite list
//	//
//	if (sys->sprites.size() == 0) return;
//	vector<Sprite>::iterator s = sys->sprites.begin();
//	vector<Sprite>::iterator tmp;
//
//	// check which sprites have exceed their lifespan and delete
//	// from list.  When deleting multiple objects from a vector while
//	// traversing at the same time, use an iterator.
//	//
//	while (s != sys->sprites.end()) {
//		if (s->lifespan != -1 && s->age() > s->lifespan) {
//			//			cout << "deleting sprite: " << s->name << endl;
//			tmp = sys->sprites.erase(s);
//			s = tmp;
//		}
//		else s++;
//	}
//
//
//	for (int i = 0; i < sys->sprites.size(); i++) {
//		moveSprite(&sys->sprites[i]);
//	}
	
}

// virtual function to move sprite (can be overloaded)
//
void Emitter::moveSprite(Sprite *sprite) {
    sprite->pos += sprite->velocity / ofGetFrameRate();
	// sprite->rot += sprite->rotationSpeed;
}

// virtual function to spawn sprite (can be overloaded)
//
void Emitter::spawnSprite() {
	Sprite sprite;
	if (haveChildImage) sprite.setImage(childImage);
	sprite.velocity = velocity;
	sprite.lifespan = lifespan;
	sprite.pos = pos;
	sprite.birthtime = ofGetElapsedTimeMillis();

	// Align path to the direction
	glm::vec3 v = glm::normalize(velocity);
	glm::vec3 u = glm::vec3(0, -1, 0);
	float a = glm::orientedAngle(u, v, glm::vec3(0, 0, 1));
	sprite.rotation = glm::degrees(a);

	sys->add(make_unique<Sprite>(std::move(sprite)));

	lastSpawned = ofGetElapsedTimeMillis();
}

// Start/Stop the emitter.
//
void Emitter::start() {
	started = true;
	lastSpawned = ofGetElapsedTimeMillis();
}

void Emitter::stop() {
	started = false;
}


void Emitter::setLifespan(float life) {
	lifespan = life;
}

void Emitter::setChildForwardSpeed(float s) {
    childSpeed = s;
}

void Emitter::setVelocity(const glm::vec3 v) {
	velocity = v;
}

void Emitter::setChildImage(ofImage img) {
	childImage = img;
	haveChildImage = true;
}

void Emitter::setImage(ofImage img) {
	image = img;
	haveImage = true;
}

void Emitter::setRate(float r) {
	rate = r;
}

void Emitter::setChildScale(float s) {
    childScale = s;
}

void Emitter::setChildRotationSpeed(float rs) {
    childRotationSpeed = rs;
}

void Emitter::setIsClicked(bool b) {
    isClicked = b;
}

void Emitter::setSpritesPerUpdate(int s) {
    spritesPerUpdate = s;
}

bool Emitter::inside(glm::vec3 p) {
	glm::vec3 s = glm::inverse(getTransform()) * glm::vec4(p, 1);
	return (s.x > -width / 2 && s.x < width / 2 && s.y > -height / 2 && s.y < height / 2);
}