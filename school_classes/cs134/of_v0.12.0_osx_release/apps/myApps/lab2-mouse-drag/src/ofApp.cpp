#include "ofApp.h"


//--------------------------------------------------------------
void ofApp::setup(){
    cam.setDistance(10.0);
    cam.setNearClip(0.1);
}

//--------------------------------------------------------------
void ofApp::update(){

}

//--------------------------------------------------------------
void ofApp::draw(){
    ofSetBackgroundColor(ofColor::black);

    cam.begin();
    if (isSphereClicked) {
        cam.disableMouseInput();
    } else {
        cam.enableMouseInput();
    }
    

    ofSetColor(sphere.color);
    ofNoFill();
    sphere.draw();

    cam.end();

}

//--------------------------------------------------------------
void ofApp::exit(){

}

//--------------------------------------------------------------
void ofApp::keyPressed(int key){

}

//--------------------------------------------------------------
void ofApp::keyReleased(int key){

}

//--------------------------------------------------------------
void ofApp::mouseMoved(int x, int y ){

}

//--------------------------------------------------------------
void ofApp::mouseDragged(int x, int y, int button){
    // Mouse Screen Space -> Mouse World Space
    glm::vec3 wp = cam.screenToWorld(glm::vec3(x, y, 0));
    glm::vec3 d = glm::normalize(wp - cam.getPosition());

    // If sphere is clicked, sphere should drag
    if (isSphereClicked) {
        // Get plane intersection on sphere
        plane.pos = sphere.pos;
        plane.normal = cam.getZAxis();
        glm::vec3 p;
        if (!plane.intersect(wp, d, p)) {
            cout << "Error: no plane intersection on sphere" << endl;
            return;
        }

        // Move sphere by delta
        sphere.pos += p - lastPlaneClickedPosition;
        lastPlaneClickedPosition = p;
    }
}

//--------------------------------------------------------------
void ofApp::mousePressed(int x, int y, int button){
    // Mouse Screen Space -> Mouse World Space
    glm::vec3 wp = cam.screenToWorld(glm::vec3(x, y, 0));
    glm::vec3 d = glm::normalize(wp - cam.getPosition());

    // Sphere intersection check
    glm::vec3 p;
    if (sphere.intersect(wp, d, p)) {
        cout << "sphere intersect point: " << p << endl;
        isSphereClicked = true;
    } else {
        cout << "no sphere intersection" << endl;
        isSphereClicked = false;
    }

    // Plane intersection check
    plane.pos = sphere.pos;
    plane.normal = cam.getZAxis();
    glm::vec3 p1;
    if (plane.intersect(wp, d, p1)) {
        cout << "plane intersect point " << p1 << endl;
        lastPlaneClickedPosition = p1;
    } else {
        cout << "no plane intersection" << endl;
    }


}

//--------------------------------------------------------------
void ofApp::mouseReleased(int x, int y, int button){

}

//--------------------------------------------------------------
void ofApp::mouseScrolled(int x, int y, float scrollX, float scrollY){

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
