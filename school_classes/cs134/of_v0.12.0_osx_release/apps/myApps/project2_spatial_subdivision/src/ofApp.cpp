
//--------------------------------------------------------------
//
//  Kevin M. Smith
//
//  Octree Test - startup scene
// 
//
//  Student Name:   Froilan Zarate
//  Date: 11/20/24

#include "ofApp.h"

//--------------------------------------------------------------
// setup scene, lighting, state and load geometry
//
void ofApp::setup(){
	bWireframe = false;
	bDisplayPoints = false;
	bAltKeyDown = false;
	bCtrlKeyDown = false;
	bLanderLoaded = false;
	bTerrainSelected = true;
//	ofSetWindowShape(1024, 768);
	mainCam.setPosition(0, 4, 0);
	mainCam.setDistance(10);
	mainCam.setNearClip(.1);
	mainCam.setFov(65.5);   // approx equivalent to 28mm in 35mm format
	ofSetVerticalSync(true);
	mainCam.disableMouseInput();
	ofEnableSmoothing();
	ofEnableDepthTest();

	sideCam.setPosition(80, 5, 0);
    sideCam.lookAt(glm::vec3(0, 0, 0));
    topCam.setPosition(0, 25, 0);
    topCam.lookAt(glm::vec3(0, -1, 0));
	cam = &mainCam;

	// setup rudimentary lighting 
	//
	initLightingAndMaterials();
	bTerrainLoaded = mars.load("geo/moon-houdini.obj");
	// bTerrainLoaded = mars.load("geo/mars-low-5x-v2.obj");
	mars.setScaleNormalization(false);

	// Load lander
	bLanderLoaded = lander.load("geo/lander.obj");
	if (bLanderLoaded) {
		lander.setScaleNormalization(false);
		lander.setPosition(0, 10, 0);
		cout << "number of meshes: " << lander.getNumMeshes() << endl;
		bboxList.clear();
		for (int i = 0; i < lander.getMeshCount(); i++) {
			bboxList.push_back(Octree::meshBounds(lander.getMesh(i)));
		}

		glm::vec3 min = lander.getSceneMin();
		glm::vec3 max = lander.getSceneMax();

		// set up bounding box for lander while we are at it
		//
		landerBounds = Box(Vector3(min.x, min.y, min.z), Vector3(max.x, max.y, max.z));
	}

	// create sliders for testing
	//
	gui.setup();
	gui.add(numLevels.setup("Number of Octree Levels", 1, 1, 10));
	gui.add(timingInfoGUI.setup("Timing Info", true, 50, 50));
	gui.add(skipCollisionFramesGUI.setup("Skip Collision Frames", 1, 0, 5));

	gui.add(restitutionGUI.setup("Restitution (Bounciness)", 0.05, 0, 1));
	gui.add(gravityGUI.setup("Gravity", 0.35, 0, 5));
	gui.add(dampingGUI.setup("Damping", 0.999, 0, 1));
	gui.add(horizontalThrustGUI.setup("Horizontal Thrust", 5, 0.1, 10));
	gui.add(verticalThrustGUI.setup("Vertical Thrust", 4, 0.1, 10));
	gui.add(rotationalThrustGUI.setup("Rotational Thrust", 5, 0.1, 10));

	bHide = false;

	//  Create Octree for testing.
	//
	
	float time = ofGetElapsedTimef();
	octree.create(mars.getMesh(0), 10);
	if (timingInfoGUI) {
		cout << "Time to load octree: " << 1000 * (ofGetElapsedTimef() - time) << "ms" << endl;
		cout << "Number of Verts: " << mars.getMesh(0).getNumVertices() << endl;
	}
	

	testBox = Box(Vector3(3, 3, 0), Vector3(5, 5, 2));

	// Fill colors
	for (int i = 0; i < 11; i++) {
		levelColors.push_back(ofColor(ofRandom(255), ofRandom(255), ofRandom(255)));
	}

	// Physics
	// setup any objects you've created here...
	// emitter.setRate(1);
	emitter.setPosition(ofVec3f(0, 20, 0));
	emitter.setDamping(0.5);
	emitter.visible = false;
	emitter.setOneShot(true);

	emitter.setLifespan(1000000);


	ParticleSystem *sys = emitter.sys;
	grav.set(ofVec3f(0, -2.0, 0));
	sys->addForce(&grav);
	turbulence = TurbulenceForce(ofVec3f(-3, -1, -3), ofVec3f(3, 1, 3));
	sys->addForce(&turbulence);
	emitter.setParticleRadius(0.05);
	emitter.setVelocity(glm::vec3(0, 10, 0));

	// Create a particle with long lifespan, link to lander
	emitter.spawn(ofGetElapsedTimeMillis());


	// Sound
	thrustSoundPlayer.load("sounds/thrusters-loop.wav");
	thrustSoundPlayer.setLoop(true);
	thrustSoundPlayer.play();
	thrustSoundPlayer.setPaused(true);

	explosionSoundPlayer.load("sounds/explosion.wav");
	explosionSoundPlayer.setLoop(false);

	// Designated areas
	area1 = Box(Vector3(-60, -100, -20), Vector3(-80, 100, 0));
	area2 = Box(Vector3(50, -100, 50), Vector3(70, 100, 70));
	area3 = Box(Vector3(130, -100, 130), Vector3(150, 100, 150));

	// Load images
	stars.load("images/stars.jpg");

	// Lights
	light.enable();
    light.setDirectional();
    light.setDiffuseColor(ofFloatColor(0.8, 0.8, 0.8));
    light.setSpecularColor(ofFloatColor(0.4, 0.4, 0.4));
    light.setPosition(0, 300, 0);
    light.lookAt(glm::vec3(0, 0, 0)); // Target the origin
	light.tiltDeg(180);

	light1.setup();
	light1.enable();
	light1.setSpotlight();
	light1.setScale(.1);
	light1.setSpotlightCutOff(35);
	light1.setAttenuation(.2, .001, .001);
	light1.setAmbientColor(ofFloatColor(0.1, 0.1, 0.1));
	light1.setDiffuseColor(ofFloatColor(0.2, 0.5, 0.2));
	light1.setSpecularColor(ofFloatColor(0.5, 0.5, 0.5));
	light1.setPosition(0, 0, 0);
	light1.lookAt(glm::vec3(0, -1, 0));
	light1.setPosition(60, 20, 60);

	light2.setup();
	light2.enable();
	light2.setSpotlight();
	light2.setScale(.1);
	light2.setSpotlightCutOff(35);
	light2.setAttenuation(.2, .001, .001);
	light2.setAmbientColor(ofFloatColor(0.1, 0.1, 0.1));
	light2.setDiffuseColor(ofFloatColor(0.2, 0.5, 0.2));
	light2.setSpecularColor(ofFloatColor(0.5, 0.5, 0.5));
	light2.setPosition(0, 0, 0);
	light2.lookAt(glm::vec3(0, -1, 0));
	light2.setPosition(-70, 20, -10);

	light3.setup();
	light3.enable();
	light3.setSpotlight();
	light3.setScale(.1);
	light3.setSpotlightCutOff(35);
	light3.setAttenuation(.2, .001, .001);
	light3.setAmbientColor(ofFloatColor(0.1, 0.1, 0.1));
	light3.setDiffuseColor(ofFloatColor(0.2, 0.5, 0.2));
	light3.setSpecularColor(ofFloatColor(0.5, 0.5, 0.5));
	light3.setPosition(0, 0, 0);
	light3.lookAt(glm::vec3(0, -1, 0));
	light3.setPosition(140, 20, 140);

	// Shaders
	#ifdef TARGET_OPENGLES
		shader.load("shaders_gles/shader");
	#else
		shader.load("shaders/shader");
	#endif
	// texture loading
	ofDisableArbTex();
	if (!ofLoadImage(particleTex, "images/dot.png")) {
		cout << "Particle Texture File: images/dot.png not found" << endl;
		ofExit();
	}

	// Explosion effect
	ImpulseRadialForce* irf = new ImpulseRadialForce(10);
	explosionEmitter.sys->addForce(irf);
	explosionEmitter.setOneShot(true);
	explosionEmitter.setEmitterType(RadialEmitter);
	explosionEmitter.setGroupSize(100);
	explosionEmitter.setRandomLife(true);
	explosionEmitter.setParticleRadius(0.5);
	explosionEmitter.setMass(1);
	explosionEmitter.setDamping(1);
	explosionEmitter.setLifespanRange(ofVec2f(0.5, 2));

	// Thrust Effect
	thrustEmitter.setOneShot(false);
	thrustEmitter.setGroupSize(1);
	thrustEmitter.setMass(1);
	thrustEmitter.setDamping(0.5);
	thrustEmitter.setLifespan(0.1);
	thrustEmitter.setVelocity(ofVec3f(0, -5, 0));
	thrustEmitter.setRate(8);
	thrustEmitter.setParticleRadius(0.5);
	thrustEmitter.visible = false;
	thrustEmitter.particleColor = ofColor::yellow;

	// Reset fuel (1 bug where you hit button)
	fuel = 120;
}

void ofApp::loadVbo() {
	if (explosionEmitter.sys->particles.size() < 1) return;

	vector<ofVec3f> sizes; 
	vector<ofVec3f> points;
	for (int i = 0; i < explosionEmitter.sys->particles.size(); i++) {
		points.push_back(explosionEmitter.sys->particles[i].position);
		sizes.push_back(ofVec3f(5));
	}
	// upload the data to the vbo
	//
	int total = (int)points.size();
	vbo.clear();
	vbo.setVertexData(&points[0], total, GL_STATIC_DRAW);
	vbo.setNormalData(&sizes[0], total, GL_STATIC_DRAW);
}
 
//--------------------------------------------------------------
// incrementally update scene (animation)
//
void ofApp::update() {

	// Update explosion
	explosionEmitter.update();
	

	// Get Lander particle
	Particle landerParticle = emitter.sys->particles[0];
	lander.setPosition(landerParticle.position.x, landerParticle.position.y, landerParticle.position.z);
	explosionEmitter.setPosition(landerParticle.position + ofVec3f(0, 1, 0));
	thrustEmitter.setPosition(landerParticle.position);

	if (hasGameEnded) return;

	// Update thrust
	thrustEmitter.update();

	// PHYSICS //
	grav.set(ofVec3f(0, -gravityGUI, 0));
	emitter.sys->particles[0].damping = dampingGUI;

	// Movement
	if (shiftKeyDown) emitter.sys->particles[0].forces -= ofVec3f(0, verticalThrustGUI, 0);
	if (spacebarKeyDown) emitter.sys->particles[0].forces += ofVec3f(0, verticalThrustGUI, 0);
	
	if (upArrowKeyDown) emitter.sys->particles[0].forces += glm::rotate(headingVector, glm::radians(emitter.sys->particles[0].rotation), glm::vec3(0, 1, 0)) * (float) horizontalThrustGUI;
	if (downArrowKeyDown) emitter.sys->particles[0].forces -= glm::rotate(headingVector, glm::radians(emitter.sys->particles[0].rotation), glm::vec3(0, 1, 0)) * (float) horizontalThrustGUI;
	if (rightArrowKeyDown) emitter.sys->particles[0].rotationalForces -= rotationalThrustGUI;
	if (leftArrowKeyDown) emitter.sys->particles[0].rotationalForces += rotationalThrustGUI;

	// Update physics
	bool hasCollided = false;
	if (skipCollisionFramesCounter >= skipCollisionFramesGUI) { 
		hasCollided = tryCollisions();
		stillColliding = hasCollided;
		skipCollisionFramesCounter = 0;
	} else {
		skipCollisionFramesCounter++;
	}
	emitter.update();

	// Check acceleration, if it's very large then explode ship
	if (hasCollided) {
		float total = abs(emitter.sys->particles[0].velocity.x)
					+ abs(emitter.sys->particles[0].velocity.y)
					+ abs(emitter.sys->particles[0].velocity.z);
		
		if (total > 7) {
			cout << "Explode" << endl;
			endString = "You lost! You crashed!";
			thrustSoundPlayer.setPaused(true);
			explosionSoundPlayer.play();
			explosionEmitter.sys->reset();
			explosionEmitter.start();
			hasGameEnded = true;
		} else {
			cout << "Bounce" << endl;
			
			// Get rover bounds (as box)
			ofVec3f min = lander.getSceneMin() + lander.getPosition();
			ofVec3f max = lander.getSceneMax() + lander.getPosition();
			Box bounds = Box(Vector3(min.x, min.y, min.z), Vector3(max.x, max.y, max.z));
			
			// Check if desginated area to land!
			if (area1.overlap(bounds) || area2.overlap(bounds) || area3.overlap(bounds)) {
				cout << "Landed" << endl;
				score = fuel * 10 + (10 - total) * 100;
				endString = "You win! You landed successfully! Score: " + to_string(score);
				thrustSoundPlayer.setPaused(true);
				hasGameEnded = true;
			}
		}
	}

	// Camera
	topCam.setPosition(landerParticle.position.x, landerParticle.position.y + 15, landerParticle.position.z);
	glm::quat downOrientation = glm::quat(glm::vec3(-HALF_PI, 0, 0));
	glm::quat yawRotation = glm::angleAxis(glm::radians(landerParticle.rotation + 180), glm::vec3(0, 1, 0));
	glm::quat combinedOrientation = yawRotation * downOrientation;
	topCam.setOrientation(combinedOrientation);

	// Sound & fuel
	// Play sound when key is pressed
	if (shiftKeyDown || spacebarKeyDown || upArrowKeyDown || downArrowKeyDown || rightArrowKeyDown || leftArrowKeyDown) {
		thrustSoundPlayer.setPaused(false);
		thrustEmitter.start();
		fuel -= (ofGetLastFrameTime() < 2) ? ofGetLastFrameTime() : 2;
	} else {
		thrustSoundPlayer.setPaused(true);
		thrustEmitter.stop();
	}

	if (fuel < 0) {
		cout << "No Fuel" << endl;
		endString = "You lost! You ran out of fuel!";
		hasGameEnded = true;
	}
}

//--------------------------------------------------------------
void ofApp::draw() {

	ofBackground(ofColor::black);

	// Draw the background image in 2D
	ofSetColor(ofColor::white);
    ofDisableDepthTest(); // Disable depth testing
    stars.draw(0, 0, ofGetWidth(), ofGetHeight()); // Fill the screen
    ofEnableDepthTest(); // Re-enable depth testing for 3D
	

	// Next cam
	cam->begin();
	ofPushMatrix();
	if (bWireframe) {                    // wireframe mode  (include axis)
		ofDisableLighting();
		ofSetColor(ofColor::slateGray);
		mars.drawWireframe();

		if (bLanderLoaded) {
			lander.drawWireframe();
			// if (!bTerrainSelected) drawAxis(lander.getPosition());
		}
		// if (bTerrainSelected) drawAxis(ofVec3f(0, 0, 0));
	}
	else {
		ofEnableLighting(); 
		ofEnableDepthTest();             // shaded mode
		mars.drawFaces();
		ofMesh mesh;
		if (bLanderLoaded) {
			ofPushMatrix();
			ofTranslate(lander.getPosition());
			ofRotateDeg(emitter.sys->particles[0].rotation, 0, 1, 0);

			ofVec3f savedPosition = emitter.sys->particles[0].position;
			emitter.sys->particles[0].position = ofVec3f(0, 0, 0);
			lander.setPosition(0, 0, 0);

			// PHYSICS //
			// emitter.draw();
			lander.drawFaces();

			emitter.sys->particles[0].position = savedPosition;
			lander.setPosition(savedPosition.x, savedPosition.y, savedPosition.z);

			ofPopMatrix();
			thrustEmitter.draw();

			// if (!bTerrainSelected) drawAxis(lander.getPosition());
			if (bDisplayBBoxes) {
				ofNoFill();
				ofSetColor(ofColor::white);
				for (int i = 0; i < lander.getNumMeshes(); i++) {
					ofPushMatrix();
					ofMultMatrix(lander.getModelMatrix());
					// ofRotateDeg(-90, 1, 0, 0);
					Octree::drawBox(bboxList[i]);
					ofPopMatrix();
				}
			}

			if (bLanderSelected) {

				ofVec3f min = lander.getSceneMin() + lander.getPosition();
				ofVec3f max = lander.getSceneMax() + lander.getPosition();

				Box bounds = Box(Vector3(min.x, min.y, min.z), Vector3(max.x, max.y, max.z));
				ofNoFill();
				ofSetColor(ofColor::white);
				Octree::drawBox(bounds);

				// draw colliding boxes
				//
				ofSetColor(ofColor::lightBlue);
				for (int i = 0; i < colBoxList.size(); i++) {
					Octree::drawBox(colBoxList[i]);
				}
			}
		}
	}
	//if (bTerrainSelected) drawAxis(ofVec3f(0, 0, 0));


	// if (bDisplayPoints) {                // display points as an option    
	// 	glPointSize(3);
	// 	ofSetColor(ofColor::green);
	// 	mars.drawVertices();
	// }

	// highlight selected point (draw sphere around selected point)
	//
	// if (bPointSelected) {
	// 	ofSetColor(ofColor::blue);
	// 	ofDrawSphere(selectedPoint, .1);
	// }

	// recursively draw octree
	//
	ofDisableLighting();
	// int level = 0;

	if (bDisplayLeafNodes) {
		ofNoFill();
		octree.drawLeafNodes(octree.root);
		// cout << "num leaf: " << octree.numLeaf << endl;
    }
	else if (bDisplayOctree) {
		ofNoFill();
		// ofSetColor(ofColor::white);
		ofSetColor(levelColors[numLevels]);
		octree.draw(numLevels, 0);
	}

	// if point selected, draw a sphere
	//
	if (pointSelected) {
		ofVec3f p = octree.mesh.getVertex(selectedNode.points[0]);
		ofVec3f d = p - cam->getPosition();
		ofSetColor(ofColor::lightGreen);
		ofDrawSphere(p, .02 * d.length());
	}

	// Draw designated areas
	ofSetColor(ofColor::green);
	ofNoFill();
	drawBox(area1);
	drawBox(area2);
	drawBox(area3);

	ofPopMatrix();
	cam->end();

	// Explosion effect
	loadVbo();
	ofDisableLighting();
	glDepthMask(GL_FALSE);
	ofSetColor(255, 100, 90);
	ofEnableBlendMode(OF_BLENDMODE_ADD);
	ofEnablePointSprites();
	ofNoFill();
	shader.begin();
	cam->begin();

	particleTex.bind();
	vbo.draw(GL_POINTS, 0, (int)explosionEmitter.sys->particles.size());
	particleTex.unbind();

	cam->end();
	shader.end();
	glDepthMask(GL_TRUE);
	ofDisablePointSprites();
	ofDisableBlendMode();
	ofEnableAlphaBlending();

	// Gui
	glDepthMask(false);
	if (!hideGUI) gui.draw();
	glDepthMask(true);


	// Text
	if (!hideInfo) {
		ofDisableDepthTest();
		ofSetColor(ofColor::green);
		// Distance between ship and ground
		Ray ray = Ray(Vector3(lander.getPosition().x, lander.getPosition().y, lander.getPosition().z), Vector3(0, -1, 0));
		TreeNode treeNode;
		if (octree.intersect(ray, octree.root, treeNode)) {
			glm::vec3 p1 = glm::vec3(lander.getPosition().x, lander.getPosition().y, lander.getPosition().z);
			glm::vec3 p2 = glm::vec3(treeNode.box.center().x(), treeNode.box.center().y(), treeNode.box.center().z());
			distance = glm::distance(p1, p2);
		}

		string str = "Distance from Ground: " + to_string(distance);
		ofDrawBitmapString(str, 120, 50);

		// Show fuel
		string str2 = "Fuel left: " + to_string(fuel);
		ofDrawBitmapString(str2, 120, 70);
		ofEnableDepthTest();
	}

	// Win/Lose
	if (hasGameEnded) {
		ofDisableDepthTest();
		ofDrawBitmapStringHighlight(endString, ofGetWindowWidth() / 2 - 20, ofGetWindowHeight() / 2);
		ofEnableDepthTest();
	}
}


// 
// Draw an XYZ axis in RGB at world (0,0,0) for reference.
//
void ofApp::drawAxis(ofVec3f location) {

	ofPushMatrix();
	ofTranslate(location);

	ofSetLineWidth(1.0);

	// X Axis
	ofSetColor(ofColor(255, 0, 0));
	ofDrawLine(ofPoint(0, 0, 0), ofPoint(1, 0, 0));
	

	// Y Axis
	ofSetColor(ofColor(0, 255, 0));
	ofDrawLine(ofPoint(0, 0, 0), ofPoint(0, 1, 0));

	// Z Axis
	ofSetColor(ofColor(0, 0, 255));
	ofDrawLine(ofPoint(0, 0, 0), ofPoint(0, 0, 1));

	ofPopMatrix();
}

bool ofApp::tryCollisions() {
	// Get rover bounds (as box)
	ofVec3f min = lander.getSceneMin() + lander.getPosition();
	ofVec3f max = lander.getSceneMax() + lander.getPosition();
	Box bounds = Box(Vector3(min.x, min.y, min.z), Vector3(max.x, max.y, max.z));

	vector<TreeNode*> treeNodeList;
	octree.intersect(bounds, octree.root, treeNodeList);

	// Collision of 10 boxes
	if (treeNodeList.size() > 10) {
		
		// Edge case: still colliding, don't add more force
		if (stillColliding) {
			return true;
		}

		// Get faces of collision
		set<int> faceIndices;

		// Add faces to set
		for (auto& treeNode : treeNodeList) {			
			faceIndices.insert(treeNode->faces.begin(), treeNode->faces.end());
		}
		
		// Get average normal, or just use upwards if no faces
		glm::vec3 norm = ofVec3f(0, 1, 0);
		if (faceIndices.size() > 0) {
			norm = ofVec3f(0, 0, 0);
			ofMesh mesh = mars.getMesh(0);

			for (auto& faceIndex : faceIndices) {
				ofVec3f n = mesh.getFace(faceIndex).getNormal(0);
				norm += n;
			}
			norm /= faceIndices.size();
		} 

		// Calculate impulse
		ofVec3f vel = emitter.sys->particles[0].velocity;
		ofVec3f f = (restitutionGUI + 1.0)*((-vel.dot(norm))*norm);
		emitter.sys->particles[0].forces += ofGetFrameRate() * f * (skipCollisionFramesGUI + 1);

		return true;
	} 

	return false;
}


void ofApp::keyPressed(int key) {

	switch (key) {
	// case 'A':
	// case 'a':
	// 	animateLander = !animateLander;
	// 	if (animateLander) lander.setPosition(lander.getPosition().x, lander.getPosition().y, lander.getPosition().z + (moveAmount * moveAmountMultiplier * 4));
		
	// 	break;
	case 'B':
	case 'b':
		bDisplayBBoxes = !bDisplayBBoxes;
		break;
	case 'C':
	case 'c':
		if (mainCam.getMouseInputEnabled()) mainCam.disableMouseInput();
		else mainCam.enableMouseInput();
		break;
	case 'F':
	case 'f':
		ofToggleFullscreen();
		break;
	case 'G':
	case 'g':
		hideInfo = !hideInfo;
	break;
	case 'H':
	case 'h':
		hideGUI = !hideGUI;
		break;
	case 'L':
	case 'l':
		bDisplayLeafNodes = !bDisplayLeafNodes;
		break;
	case 'O':
	case 'o':
		bDisplayOctree = !bDisplayOctree;
		break;
	case 'r':
		mainCam.reset();
		break;
	case 's':
		savePicture();
		break;
	case 't':
		setCameraTarget();
		break;
	case 'u':
		explosionEmitter.sys->reset();
		explosionEmitter.start();
		break;
	case 'v':
		togglePointsDisplay();
		break;
	case 'V':
		break;
	case 'w':
		toggleWireframeMode();
		break;

	case '1':
		cam = &mainCam;
		break;
	case '2':
		cam = &topCam;
		break;
	case '3':
		cam = &sideCam;
		break;
	case OF_KEY_ALT:
		mainCam.enableMouseInput();
		bAltKeyDown = true;
		break;
	case OF_KEY_CONTROL:
		bCtrlKeyDown = true;
		break;
	case OF_KEY_DEL:
		break;
	
	case OF_KEY_SHIFT:
		shiftKeyDown = true;
		break;
	case ' ':
		spacebarKeyDown = true;
		break;
	case OF_KEY_UP:
		upArrowKeyDown = true;
		break;
	case OF_KEY_RIGHT:
		rightArrowKeyDown = true;
		break;
	case OF_KEY_DOWN:
		downArrowKeyDown = true;
		break;
	case OF_KEY_LEFT:
		leftArrowKeyDown = true;
		break;
	default:
		break;
	}
}

void ofApp::toggleWireframeMode() {
	bWireframe = !bWireframe;
}

void ofApp::toggleSelectTerrain() {
	bTerrainSelected = !bTerrainSelected;
}

void ofApp::togglePointsDisplay() {
	bDisplayPoints = !bDisplayPoints;
}

void ofApp::keyReleased(int key) {

	switch (key) {
	
	case OF_KEY_ALT:
		mainCam.disableMouseInput();
		bAltKeyDown = false;
		break;
	case OF_KEY_CONTROL:
		bCtrlKeyDown = false;
		break;

	case OF_KEY_SHIFT:
		shiftKeyDown = false;
		break;
	case ' ':
		spacebarKeyDown = false;
		break;
	case OF_KEY_UP:
		upArrowKeyDown = false;
		break;
	case OF_KEY_RIGHT:
		rightArrowKeyDown = false;
		break;
	case OF_KEY_DOWN:
		downArrowKeyDown = false;
		break;
	case OF_KEY_LEFT:
		leftArrowKeyDown = false;
		break;
	default:
		break;

	}
}



//--------------------------------------------------------------
void ofApp::mouseMoved(int x, int y ){

	
}


//--------------------------------------------------------------
void ofApp::mousePressed(int x, int y, int button) {

	// if moving camera, don't allow mouse interaction
	//
	if (mainCam.getMouseInputEnabled()) return;

	// if moving camera, don't allow mouse interaction
//
	if (mainCam.getMouseInputEnabled()) return;

	// if rover is loaded, test for selection
	//
	if (bLanderLoaded) {
		glm::vec3 origin = cam->getPosition();
		glm::vec3 mouseWorld = cam->screenToWorld(glm::vec3(mouseX, mouseY, 0));
		glm::vec3 mouseDir = glm::normalize(mouseWorld - origin);

		ofVec3f min = lander.getSceneMin() + lander.getPosition();
		ofVec3f max = lander.getSceneMax() + lander.getPosition();

		Box bounds = Box(Vector3(min.x, min.y, min.z), Vector3(max.x, max.y, max.z));
		bool hit = bounds.intersect(Ray(Vector3(origin.x, origin.y, origin.z), Vector3(mouseDir.x, mouseDir.y, mouseDir.z)), 0, 10000);
		if (hit) {
			bLanderSelected = true;
			mouseDownPos = getMousePointOnPlane(lander.getPosition(), cam->getZAxis());
			mouseLastPos = mouseDownPos;
			bInDrag = true;
		}
		else {
			bLanderSelected = false;
		}
	}
	else {
		ofVec3f p;
		
		raySelectWithOctree(p);
		
	}
}

bool ofApp::raySelectWithOctree(ofVec3f &pointRet) {
	ofVec3f mouse(mouseX, mouseY);
	ofVec3f rayPoint = cam->screenToWorld(mouse);
	ofVec3f rayDir = rayPoint - cam->getPosition();
	rayDir.normalize();
	Ray ray = Ray(Vector3(rayPoint.x, rayPoint.y, rayPoint.z),
		Vector3(rayDir.x, rayDir.y, rayDir.z));
	
	float time = ofGetElapsedTimef();
	pointSelected = octree.intersect(ray, octree.root, selectedNode);

	if (pointSelected) {
		pointRet = octree.mesh.getVertex(selectedNode.points[0]);
		if (timingInfoGUI) cout << "Time for ray intersection: " << std::fixed << std::setprecision(10) << 1000 * (ofGetElapsedTimef() - time) <<  "ms" << endl;
	}
	return pointSelected;
}




//--------------------------------------------------------------
void ofApp::mouseDragged(int x, int y, int button) {

	// if moving camera, don't allow mouse interaction
	//
	if (mainCam.getMouseInputEnabled()) return;

	if (bInDrag) {

		glm::vec3 landerPos = lander.getPosition();

		glm::vec3 mousePos = getMousePointOnPlane(landerPos, cam->getZAxis());
		glm::vec3 delta = mousePos - mouseLastPos;
	
		landerPos += delta;
		lander.setPosition(landerPos.x, landerPos.y, landerPos.z);
		mouseLastPos = mousePos;

		ofVec3f min = lander.getSceneMin() + lander.getPosition();
		ofVec3f max = lander.getSceneMax() + lander.getPosition();

		Box bounds = Box(Vector3(min.x, min.y, min.z), Vector3(max.x, max.y, max.z));

		colBoxList.clear();
		octree.intersect(bounds, octree.root, colBoxList);
	

		/*if (bounds.overlap(testBox)) {
			cout << "overlap" << endl;
		}
		else {
			cout << "OK" << endl;
		}*/


	}
	else {
		ofVec3f p;
		raySelectWithOctree(p);
	}
}

//--------------------------------------------------------------
void ofApp::mouseReleased(int x, int y, int button) {
	bInDrag = false;
}



// Set the camera to use the selected point as it's new target
//  
void ofApp::setCameraTarget() {

}


//--------------------------------------------------------------
void ofApp::mouseEntered(int x, int y){

}

//--------------------------------------------------------------
void ofApp::mouseExited(int x, int y){

}

//--------------------------------------------------------------
void ofApp::windowResized(int w, int h){

}

//--------------------------------------------------------------
void ofApp::gotMessage(ofMessage msg){

}



//--------------------------------------------------------------
// setup basic ambient lighting in GL  (for now, enable just 1 light)
//
void ofApp::initLightingAndMaterials() {

	static float ambient[] =
	{ .5f, .5f, .5, 1.0f };
	static float diffuse[] =
	{ 1.0f, 1.0f, 1.0f, 1.0f };

	static float position[] =
	{5.0, 5.0, 5.0, 0.0 };

	static float lmodel_ambient[] =
	{ 1.0f, 1.0f, 1.0f, 1.0f };

	static float lmodel_twoside[] =
	{ GL_TRUE };


	glLightfv(GL_LIGHT0, GL_AMBIENT, ambient);
	glLightfv(GL_LIGHT0, GL_DIFFUSE, diffuse);
	glLightfv(GL_LIGHT0, GL_POSITION, position);

	glLightfv(GL_LIGHT1, GL_AMBIENT, ambient);
	glLightfv(GL_LIGHT1, GL_DIFFUSE, diffuse);
	glLightfv(GL_LIGHT1, GL_POSITION, position);


	glLightModelfv(GL_LIGHT_MODEL_AMBIENT, lmodel_ambient);
	glLightModelfv(GL_LIGHT_MODEL_TWO_SIDE, lmodel_twoside);

	glEnable(GL_LIGHTING);
	glEnable(GL_LIGHT0);
//	glEnable(GL_LIGHT1);
	glShadeModel(GL_SMOOTH);
} 

void ofApp::savePicture() {
	ofImage picture;
	picture.grabScreen(0, 0, ofGetWidth(), ofGetHeight());
	picture.save("screenshot.png");
	cout << "picture saved" << endl;
}

//--------------------------------------------------------------
//
// support drag-and-drop of model (.obj) file loading.  when
// model is dropped in viewport, place origin under cursor
//
void ofApp::dragEvent2(ofDragInfo dragInfo) {

	ofVec3f point;
	mouseIntersectPlane(ofVec3f(0, 0, 0), cam->getZAxis(), point);
	if (lander.load(dragInfo.files[0])) {
		lander.setScaleNormalization(false);
//		lander.setScale(.1, .1, .1);
	//	lander.setPosition(point.x, point.y, point.z);
		lander.setPosition(1, 1, 0);

		bLanderLoaded = true;
		for (int i = 0; i < lander.getMeshCount(); i++) {
			bboxList.push_back(Octree::meshBounds(lander.getMesh(i)));
		}

		cout << "Mesh Count: " << lander.getMeshCount() << endl;
	}
	else cout << "Error: Can't load model" << dragInfo.files[0] << endl;
}

bool ofApp::mouseIntersectPlane(ofVec3f planePoint, ofVec3f planeNorm, ofVec3f &point) {
	ofVec2f mouse(mouseX, mouseY);
	ofVec3f rayPoint = cam->screenToWorld(glm::vec3(mouseX, mouseY, 0));
	ofVec3f rayDir = rayPoint - cam->getPosition();
	rayDir.normalize();
	return (rayIntersectPlane(rayPoint, rayDir, planePoint, planeNorm, point));
}

//--------------------------------------------------------------
//
// support drag-and-drop of model (.obj) file loading.  when
// model is dropped in viewport, place origin under cursor
//
void ofApp::dragEvent(ofDragInfo dragInfo) {
	if (lander.load(dragInfo.files[0])) {
		bLanderLoaded = true;
		lander.setScaleNormalization(false);
		lander.setPosition(0, 0, 0);
		cout << "number of meshes: " << lander.getNumMeshes() << endl;
		bboxList.clear();
		for (int i = 0; i < lander.getMeshCount(); i++) {
			bboxList.push_back(Octree::meshBounds(lander.getMesh(i)));
		}

		//		lander.setRotation(1, 180, 1, 0, 0);

				// We want to drag and drop a 3D object in space so that the model appears 
				// under the mouse pointer where you drop it !
				//
				// Our strategy: intersect a plane parallel to the camera plane where the mouse drops the model
				// once we find the point of intersection, we can position the lander/lander
				// at that location.
				//

				// Setup our rays
				//
		glm::vec3 origin = cam->getPosition();
		glm::vec3 camAxis = cam->getZAxis();
		glm::vec3 mouseWorld = cam->screenToWorld(glm::vec3(mouseX, mouseY, 0));
		glm::vec3 mouseDir = glm::normalize(mouseWorld - origin);
		float distance;

		bool hit = glm::intersectRayPlane(origin, mouseDir, glm::vec3(0, 0, 0), camAxis, distance);
		if (hit) {
			// find the point of intersection on the plane using the distance 
			// We use the parameteric line or vector representation of a line to compute
			//
			// p' = p + s * dir;
			//
			glm::vec3 intersectPoint = origin + distance * mouseDir;

			// Now position the lander's origin at that intersection point
			//
			glm::vec3 min = lander.getSceneMin();
			glm::vec3 max = lander.getSceneMax();
			float offset = (max.y - min.y) / 2.0;
			lander.setPosition(intersectPoint.x, intersectPoint.y - offset, intersectPoint.z);

			// set up bounding box for lander while we are at it
			//
			landerBounds = Box(Vector3(min.x, min.y, min.z), Vector3(max.x, max.y, max.z));
		}
	}


}

//  intersect the mouse ray with the plane normal to the camera 
//  return intersection point.   (package code above into function)
//
glm::vec3 ofApp::getMousePointOnPlane(glm::vec3 planePt, glm::vec3 planeNorm) {
	// Setup our rays
	//
	glm::vec3 origin = cam->getPosition();
	// glm::vec3 camAxis = cam.getZAxis();
	glm::vec3 mouseWorld = cam->screenToWorld(glm::vec3(mouseX, mouseY, 0));
	glm::vec3 mouseDir = glm::normalize(mouseWorld - origin);
	float distance;

	bool hit = glm::intersectRayPlane(origin, mouseDir, planePt, planeNorm, distance);

	if (hit) {
		// find the point of intersection on the plane using the distance 
		// We use the parameteric line or vector representation of a line to compute
		//
		// p' = p + s * dir;
		//
		glm::vec3 intersectPoint = origin + distance * mouseDir;

		return intersectPoint;
	}
	else return glm::vec3(0, 0, 0);
}

//draw a box from a "Box" class  
//
void ofApp::drawBox(const Box &box) {
	Vector3 min = box.parameters[0];
	Vector3 max = box.parameters[1];
	Vector3 size = max - min;
	Vector3 center = size / 2 + min;
	ofVec3f p = ofVec3f(center.x(), center.y(), center.z());
	float w = size.x();
	float h = size.y();
	float d = size.z();
	ofDrawBox(p, w, h, d);
}