
//
//  Starter file for Project 3 - Skeleton Builder
//
//  This file includes functionality that supports selection and translate/rotation
//  of scene objects using the mouse.
//
//  Modifer keys for rotatation are x, y and z keys (for each axis of rotation)
//
//  (c) Kevin M. Smith  - 24 September 2018
//


#include "ofApp.h"



//--------------------------------------------------------------
//
void ofApp::setup() {

	ofSetBackgroundColor(ofColor::black);
	ofEnableDepthTest();
	mainCam.setDistance(15);
	mainCam.setNearClip(.1);
	
	sideCam.setPosition(40, 0, 0);
	sideCam.lookAt(glm::vec3(0, 0, 0));
	topCam.setNearClip(.1);
	topCam.setPosition(0, 16, 0);
	topCam.lookAt(glm::vec3(0, 0, 0));
	ofSetSmoothLighting(true);


	// setup one point light
	//
	light1.enable();
	light1.setPosition(5, 5, 0);
	light1.setDiffuseColor(ofColor(255.f, 255.f, 255.f));
	light1.setSpecularColor(ofColor(255.f, 255.f, 255.f));

	theCam = &mainCam;

	//  create a scene consisting of a ground plane with 2x2 blocks
	//  arranged in semi-random positions, scales and rotations
	//
	// ground plane
	//
	scene.push_back(new Plane(glm::vec3(0, -2, 0), glm::vec3(0, 1, 0)));   


	restoreFromFile();

}

 
//--------------------------------------------------------------
void ofApp::update(){

}

//--------------------------------------------------------------
void ofApp::draw(){

	theCam->begin();
	ofNoFill();
	drawAxis();
	ofEnableLighting();

	//  draw the objects in scene
	//
	material.begin();
	ofFill();
	// cout << "Scene Size: " << scene.size() << endl;
	for (int i = 0; i < scene.size(); i++) {
		if (objSelected() && scene[i] == selected[0])
			ofSetColor(ofColor::white);
		else ofSetColor(scene[i]->diffuseColor);
		scene[i]->draw();
	}

	material.end();
	ofDisableLighting();
	theCam->end();
}

// 
// Draw an XYZ axis in RGB at transform
//
void ofApp::drawAxis(glm::mat4 m, float len) {

	ofSetLineWidth(1.0);

	// X Axis
	ofSetColor(ofColor(255, 0, 0));
	ofDrawLine(glm::vec3(m*glm::vec4(0, 0, 0, 1)), glm::vec3(m*glm::vec4(len, 0, 0, 1)));


	// Y Axis
	ofSetColor(ofColor(0, 255, 0));
	ofDrawLine(glm::vec3(m*glm::vec4(0, 0, 0, 1)), glm::vec3(m*glm::vec4(0, len, 0, 1)));

	// Z Axis
	ofSetColor(ofColor(0, 0, 255));
	ofDrawLine(glm::vec3(m*glm::vec4(0, 0, 0, 1)), glm::vec3(m*glm::vec4(0, 0, len, 1)));
}

// print C++ code for obj tranformation channels. (for debugging);
//
void ofApp::printChannels(SceneObject *obj) {
	cout << "position = glm::vec3(" << obj->position.x << "," << obj->position.y << "," << obj->position.z << ");" << endl;
	cout << "rotation = glm::vec3(" << obj->rotation.x << "," << obj->rotation.y << "," << obj->rotation.z << ");" << endl;
	cout << "scale = glm::vec3(" << obj->scale.x << "," << obj->scale.y << "," << obj->scale.z << ");" << endl;
}

//--------------------------------------------------------------
void ofApp::keyReleased(int key){

	switch (key) {
	case OF_KEY_ALT:
		bAltKeyDown = false;
		mainCam.disableMouseInput();
		break;
	case 'x':
		bRotateX = false;
		break;
	case 'y':
		bRotateY = false;
		break;
	case 'z':
		bRotateZ = false;
		break;
	default:
		break;
	}
}

//--------------------------------------------------------------
void ofApp::keyPressed(int key) {
	switch (key) {
	case 'C':
	case 'c':
		if (mainCam.getMouseInputEnabled()) mainCam.disableMouseInput();
		else mainCam.enableMouseInput();
		break;
	case 'd':
	case 'D':
		deleteJoint();
		break;
	
	case 'F':
	case 'b':
		break;
	case 'f':
		ofToggleFullscreen();
		break;
	case 'h':
		bHide = !bHide;
		break;
	case 'i':
		break;
	case 'j':
		createJoint();
		break;
	case 'n':
		break;
	case 'p':
		if (objSelected()) printChannels(selected[0]);
		break;
	case 'r':
	case 'R':
		restoreFromFile();
		break;
	case 's':
	case 'S':
		saveToFile();
		break;
	case 'x':
		bRotateX = true;
		break;
	case 'y':
		bRotateY = true;
		break;
	case 'z':
		bRotateZ = true;
		break;
	case OF_KEY_F1: 
		theCam = &mainCam;
		break;
	case OF_KEY_F2:
		theCam = &sideCam;
		break;
	case OF_KEY_F3:
		theCam = &topCam;
		break;
	case OF_KEY_ALT:
		bAltKeyDown = true;
		if (!mainCam.getMouseInputEnabled()) mainCam.enableMouseInput();
		break;
	default:
		break;
	}
}

void ofApp::createJoint() {
	// Check if selected item is a joint
	SceneObject* parent = NULL;
	if (objSelected() && static_cast<Joint*>(selected[0]) != nullptr) {
		parent = selected[0];
	}


	Joint* joint = new Joint(glm::vec3(0, 1, 0), 1, ofColor::yellow, parent);
	scene.push_back(joint);
}

void ofApp::deleteJoint() {
	// Check if selected item is a joint
	Joint* joint = NULL;
	if (objSelected() && static_cast<Joint*>(selected[0]) != nullptr) {
		joint = static_cast<Joint*>(selected[0]);
	}
	if (joint == NULL) return;


	// Get parent and remove from child list
	if (joint->parent != NULL) {
		Joint* parent = static_cast<Joint*>(joint->parent);

		int childIndex = 0;
		for (auto& c : parent->childList) {
			if (c == joint) break;
			childIndex++;
		}
		parent->childList.erase(parent->childList.begin() + childIndex++);
	}

	// Get it's children, change parent and add to new parent
	for (auto& c : joint->childList) {
		c->parent = joint->parent;
		if (joint->parent) joint->parent->addChild(c);
	}

	// Get index of the selected object
	int index = 0;
	for (auto& s : scene) {
		if (s == selected[0]) break;
		index ++;
	}
	cout << "Removing on index: " << index << endl;

	// Remove and delete object
	scene.erase(scene.begin() + index);
	delete joint;
	selected[0] = NULL;
}

void ofApp::saveToFile() {
    ofFile file("skeleton.txt", ofFile::WriteOnly);
    if (!file.is_open()) {
        cout << "Error opening file for writing: skeleton.txt" << endl;
        return;
    }

    for (auto& s : scene) {
        // Check if the object is a Joint
        Joint* joint = dynamic_cast<Joint*>(s);
        if (joint) {
            // Write the joint information to the file in the required format
            std::string parentName = joint->parent && dynamic_cast<Joint*>(joint->parent) ? dynamic_cast<Joint*>(joint->parent)->jointName : "none";
            file << "create -joint \"" << joint->jointName << "\" "
                 << "-rotate \"<" << joint->rotation.x << ", " << joint->rotation.y << ", " << joint->rotation.z << ">\" "
                 << "-translate \"<" << joint->position.x << ", " << joint->position.y << ", " << joint->position.z << ">\" "
                 << "-parent \"" << parentName << "\";" << endl;
        }
    }

    file.close();
	cout << "Successfully saved file to skeleton.txt" << endl;
}

float ofApp::stringToNumber(string str) {
    std::string result;
    for (char ch : str) {
        // Allow only numbers, '-', and '.' characters
        if (isdigit(ch) || ch == '-' || ch == '.') {
            result.push_back(ch);
        }
    }

    return std::stof(result);
}

void ofApp::restoreFromFile() {
	// Delete every joint in the scene
	Joint::counter = 0;
	for (int i = scene.size() - 1; i >= 1; i--) {
		if (static_cast<Joint*>(scene[i]) != nullptr) {
			delete scene[i];
			scene.erase(scene.begin() + i);
		}
	}


    // Use ofBuffer to read the file
    ofBuffer buffer = ofBufferFromFile("skeleton.txt");
    
    if (!buffer.size()) {
        ofLogError() << "File does not exist or is empty: skeleton.txt";
        return;
    }

    std::vector<Joint*> jointList;  // To keep track of created joints

    for (auto line : buffer.getLines()) {
        // Look for lines that define joints
        if (line.find("create -joint") != std::string::npos) {
            // Get the joint name, position, rotation, and parent
            string jointName;
            glm::vec3 position = glm::vec3(0);
            glm::vec3 rotation = glm::vec3(0);
            string parentName;

			// Split by spaces
            stringstream ss(line);
            string token;

            // Read the line tokens
            while (ss >> token) {
                if (token == "-joint") {
                    ss >> jointName;
					
					// Update counter
					if (Joint::counter < (int) stringToNumber(jointName)) {
						Joint::counter = (int) stringToNumber(jointName);
					}
                }

                if (token == "-rotate") {
					string temp;
                    ss >> temp;
					rotation.x = stringToNumber(temp);
					ss >> temp;
					rotation.y = stringToNumber(temp);
					ss >> temp;
					rotation.z = stringToNumber(temp);
                }

                if (token == "-translate") {
                    string temp;
                    ss >> temp;
					position.x = stringToNumber(temp);
					ss >> temp;
					position.y = stringToNumber(temp);
					ss >> temp;
					position.z = stringToNumber(temp);
                }

                if (token == "-parent") {
                    ss >> parentName;

					// Trim quotations and semi colon
					parentName = parentName.substr(1, parentName.size() - 3);
                }
            }

            // Create the joint
            Joint* newJoint = new Joint(position, 1, ofColor::yellow);
            newJoint->rotation = rotation;
            newJoint->name = jointName;

            // Add joint to the scene
            scene.push_back(newJoint);
            jointList.push_back(newJoint);

            // If there's a parent, link to it
            if (parentName != "none") {
                Joint* parentJoint = nullptr;
                for (Joint* j : jointList) {
                    if (j->jointName == parentName) {
                        parentJoint = j;
                        break;
                    }
                }
                if (parentJoint) {
                    parentJoint->addChild(newJoint);
                }
            }
        }
    }
}

//--------------------------------------------------------------
void ofApp::mouseMoved(int x, int y ){

}

//--------------------------------------------------------------
void ofApp::mouseDragged(int x, int y, int button) {

	if (objSelected() && bDrag) {
		glm::vec3 point; 
		mouseToDragPlane(x, y, point);
		if (bRotateX) {
			selected[0]->rotation += glm::vec3((point.x - lastPoint.x) * 20.0, 0, 0);
		}
		else if (bRotateY) {
			selected[0]->rotation += glm::vec3(0, (point.x - lastPoint.x) * 20.0, 0);
		}
		else if (bRotateZ) {
			selected[0]->rotation += glm::vec3(0, 0, (point.x - lastPoint.x) * 20.0);
		}
		else {
			selected[0]->position += (point - lastPoint);
		}
		lastPoint = point;
	}

}

//  This projects the mouse point in screen space (x, y) to a 3D point on a plane
//  normal to the view axis of the camera passing through the point of the selected object.
//  If no object selected, the plane passing through the world origin is used.
//
bool ofApp::mouseToDragPlane(int x, int y, glm::vec3 &point) {
	glm::vec3 p = theCam->screenToWorld(glm::vec3(x, y, 0));
	glm::vec3 d = p - theCam->getPosition();
	glm::vec3 dn = glm::normalize(d);

	float dist;
	glm::vec3 pos;
	if (objSelected()) {
		pos = selected[0]->position;
	}
	else pos = glm::vec3(0, 0, 0);
	if (glm::intersectRayPlane(p, dn, pos, glm::normalize(theCam->getZAxis()), dist)) {
		point = p + dn * dist;
		return true;
	}
	return false;
}

//--------------------------------------------------------------
//
// Provides functionality of single selection and if something is already selected,
// sets up state for translation/rotation of object using mouse.
//
void ofApp::mousePressed(int x, int y, int button){

	// if we are moving the camera around, don't allow selection
	//
	if (mainCam.getMouseInputEnabled()) return;

	// clear selection list
	//
	selected.clear();

	//
	// test if something selected
	//
	vector<SceneObject *> hits;

	glm::vec3 p = theCam->screenToWorld(glm::vec3(x, y, 0));
	glm::vec3 d = p - theCam->getPosition();
	glm::vec3 dn = glm::normalize(d);

	// check for selection of scene objects
	//
	for (int i = 0; i < scene.size(); i++) {
		
		glm::vec3 point, norm;
		
		//  We hit an object
		//
		if (scene[i]->isSelectable && scene[i]->intersect(Ray(p, dn), point, norm)) {
			hits.push_back(scene[i]);
		}
	}


	// if we selected more than one, pick nearest
	//
	SceneObject *selectedObj = NULL;
	if (hits.size() > 0) {
		selectedObj = hits[0];
		float nearestDist = std::numeric_limits<float>::infinity();
		for (int n = 0; n < hits.size(); n++) {
			float dist = glm::length(hits[n]->position - theCam->getPosition());
			if (dist < nearestDist) {
				nearestDist = dist;
				selectedObj = hits[n];
			}	
		}
	}
	if (selectedObj) {
		selected.push_back(selectedObj);
		bDrag = true;
		mouseToDragPlane(x, y, lastPoint);
	}
	else {
		selected.clear();
	}
}

//--------------------------------------------------------------
void ofApp::mouseReleased(int x, int y, int button){
	bDrag = false;

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
void ofApp::dragEvent(ofDragInfo dragInfo){ 

}

