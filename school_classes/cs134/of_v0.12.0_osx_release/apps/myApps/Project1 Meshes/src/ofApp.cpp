#include "ofApp.h"
#include <limits>
#include <iostream>
#include <fstream>
#include <string>

Mesh::Mesh() {
    // Load obj
    ofBuffer objBuffer = ofBufferFromFile("cat.obj");
    
    // Grab each line
    for (auto line : objBuffer.getLines()) {
        
        
        // Split line via whitespaces
        stringstream ss(line);
        string word;
        int i = 0;
        bool isVertex = false;
        float f1, f2, f3;
        while (ss >> word) {
            bool isVertexOrFace = true;
            switch (i) {
            // First line, check if vertex or face
            case 0:
                    if (word.size() > 1) {
                        isVertexOrFace = false;
                        break;
                    }
                    if (word[0] == 'v') {
                        isVertex = true;
                        break;
                    }
                    if (word[0] == 'f') {
                        isVertex = false;
                        break;
                    }
                    isVertexOrFace = false;
                    break;
            case 1:
                    f1 = stof(word);
                    break;
            case 2:
                    f2 = stof(word);
                    break;
            case 3:
                    f3 = stof(word);
                    break;
            }
            if (!isVertexOrFace) {
                break;
            }
            i++;
        }
        
        // Put in vector array
        if (isVertex) {
            vertices.push_back(glm::vec3(f1, f2, f3));
        }
        if (!isVertex) {
            faces.push_back(glm::vec3(f1, f2, f3));
        }
    }
    
    cout << "File Byte Size: " << objBuffer.size() << endl;
    cout << "Vertices Size : " << vertices.size() << endl;
    cout << "Faces Size    : " << faces.size() << endl;
    cout << "initialize mesh" << endl;
}

void Mesh::draw() {
    
    for (auto face : faces) {
        // Draw each face
        if (fill) ofFill();
        if (!fill) ofNoFill();
        
        ofSetColor(ofColor::white);
        ofDrawTriangle(vertices[face.x - 1], vertices[face.y - 1], vertices[face.z - 1]);
        
        
        if (showNormal) {
            // Get centroid and normal
            glm::vec3 centroid = (vertices[face.x - 1] + vertices[face.y - 1] + vertices[face.z - 1]) / 3;
            glm::vec3 AB = vertices[face.y - 1] - vertices[face.x - 1];
            glm::vec3 AC = vertices[face.z - 1] - vertices[face.x - 1];
            
            glm::vec3 normal = glm::cross(AB, AC);
            
            // Draw line (Start from Centroid, extend out with normal)
            ofSetColor(ofColor::red);
            ofDrawLine(centroid, centroid + (glm::normalize(normal) * normalLength));
        }
    }
}

//--------------------------------------------------------------
void ofApp::setup(){
	// set camera parameters
	//
	cam.setDistance(20.0);
	cam.setNearClip(.1);
	cam.setTarget(glm::vec3(0, 0, 0));

	gui.setup(); // most of the time you don't need a name
	gui.add(normalLength.setup("Normal Length", 1.0, 1.0, 20.0));
    gui.add(showNormal.setup("Show Normal", true, 125.0, 20.0));
    gui.add(fill.setup("Fill", false, 125.0, 20.0));
    
}

//--------------------------------------------------------------
void ofApp::update(){
    // Update mesh data with gui
    mesh.normalLength = normalLength;
    mesh.showNormal = showNormal;
    mesh.fill = fill;
}

//--------------------------------------------------------------
void ofApp::draw(){
	cam.begin();
    
    // Draw mesh
    mesh.draw();

	cam.end();

	if (!bHide) {
		gui.draw();
	}
}

//--------------------------------------------------------------
void ofApp::keyPressed(int key){
	switch (key) {
	case 'f':
		ofToggleFullscreen();
		break;
	case 'h':
		bHide = !bHide;
		break;
	default:
		break;

	}

}

//--------------------------------------------------------------
void ofApp::keyReleased(int key){

}

//--------------------------------------------------------------
void ofApp::mouseMoved(int x, int y ){

}

//--------------------------------------------------------------
void ofApp::mouseDragged(int x, int y, int button){

}

//--------------------------------------------------------------
void ofApp::mousePressed(int x, int y, int button){

}

//--------------------------------------------------------------
void ofApp::mouseReleased(int x, int y, int button){

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
