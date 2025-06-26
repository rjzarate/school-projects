#define _USE_MATH_DEFINES
 
#include <cmath>
#include "ofxGUI.h"
#include "ofApp.h"
#include "Shape.h"

// Example on how to use GLM to return a transform based on component matrices
//
glm::mat4 Shape::getTransform() {
    glm::mat4 trans = glm::translate(glm::mat4(1.0), glm::vec3(position));
    glm::mat4 rot = glm::rotate(glm::mat4(1.0), glm::radians(rotation),
    glm::vec3(0, 0, 1));
    glm::mat4 scale = glm::scale(glm::mat4(1.0), this->scale);
    return (trans * rot * scale);
}

bool TriangleShape::inside(glm::vec3 p0) {
    glm::vec3 p = glm::inverse(getTransform()) * glm::vec4(p0, 1);
    glm::vec3 v1 = glm::normalize(verts[0] - p);
    glm::vec3 v2 = glm::normalize(verts[1] - p);
    glm::vec3 v3 = glm::normalize(verts[2] - p);
    float a1 = glm::orientedAngle(v1, v2, glm::vec3(0, 0, 1));
    float a2 = glm::orientedAngle(v2, v3, glm::vec3(0, 0, 1));
    float a3 = glm::orientedAngle(v3, v1, glm::vec3(0, 0, 1));
    return a1 < 0 && a2 < 0 && a3 < 0;
}

//bool TriangleShape::inside(glm::vec3 p0) {
//
//    /* TRIANGLE */
//    // Detect if cursor is touching the triangle
//    /* Barycentric coordinates equation: https://stackoverflow.com/questions/13300904/determine-whether-point-lies-inside-triangle */
//
//    // p0 is basically mouse position, but then eventually other collisions it won't be considered mouse positions
//    glm::vec3 mousePosition = p0;
//
//    // Get the actual points on the screen from the position, rotation, and scale
//    glm::vec3 trianglePoints[3];
//    trianglePoints[0] = glm::rotate(verts[0], glm::radians(rotation), glm::vec3(0, 0, 1)) * scale + position;
//    trianglePoints[1] = glm::rotate(verts[1], glm::radians(rotation), glm::vec3(0, 0, 1)) * scale + position;
//    trianglePoints[2] = glm::rotate(verts[2], glm::radians(rotation), glm::vec3(0, 0, 1)) * scale + position;
//
////    cout << "TP0: " << trianglePoints[0] << endl;
////    cout << "TP1: " << trianglePoints[1] << endl;
////    cout << "TP2: " << trianglePoints[2] << endl;
//
//    // Equation from stack overflow
//    float alpha = ((trianglePoints[1].y - trianglePoints[2].y) * (mousePosition.x - trianglePoints[2].x) + (trianglePoints[2].x - trianglePoints[1].x) * (mousePosition.y - trianglePoints[2].y)) /
//            ((trianglePoints[1].y - trianglePoints[2].y) * (trianglePoints[0].x - trianglePoints[2].x) + (trianglePoints[2].x - trianglePoints[1].x)*(trianglePoints[0].y - trianglePoints[2].y));
//    float beta = ((trianglePoints[2].y - trianglePoints[0].y) * (mousePosition.x - trianglePoints[2].x) + (trianglePoints[0].x - trianglePoints[2].x) * (mousePosition.y - trianglePoints[2].y)) /
//           ((trianglePoints[1].y - trianglePoints[2].y)*(trianglePoints[0].x - trianglePoints[2].x) + (trianglePoints[2].x - trianglePoints[1].x) * (trianglePoints[0].y - trianglePoints[2].y));
//    float gamma = 1.0f - alpha - beta;
//
//    // alpha, beta, and gamma have to be greater than 0
//    return alpha > 0 && beta > 0 && gamma > 0;
//}



bool ImageShape::inside(glm::vec3 p0) {
    // Get point in object space; have to add half of width and height later for transparency
    glm::vec4 p = (glm::inverse(getTransform()) * glm::vec4(p0, 1));
    
    // Check for bounds; can use absolute value
    if (!(glm::abs(p.x) < width / 2.0) || !(glm::abs(p.y) < height / 2.0)) return false;
    
    // Check if pixel is nontransparent; add half of width and height for top left
    p += glm::vec4(width / 2.0, height / 2.0, 0, 0);
    ofColor pixelColor = image.getColor(p.x, p.y);
    return pixelColor.a != 0;
}

//bool ImageShape::inside(glm::vec3 p0) {
//    // Detect if cursor is touching a triangle (rectangle is 2 triangles)
//    /* Barycentric coordinates equation: https://stackoverflow.com/questions/13300904/determine-whether-point-lies-inside-triangle */
//
//    // p0 is basically mouse position, but then eventually other collisions it won't be considered mouse positions
//    glm::vec3 mousePosition = p0;
//
//    // Get the actual points on the screen from the position, rotation, and scale
//    glm::vec3 trianglePoints[3];
//    trianglePoints[0] = glm::rotate(verts[0], glm::radians(rotation), glm::vec3(0, 0, 1)) * scale + position;
//    trianglePoints[1] = glm::rotate(verts[1], glm::radians(rotation), glm::vec3(0, 0, 1)) * scale + position;
//    trianglePoints[2] = glm::rotate(verts[2], glm::radians(rotation), glm::vec3(0, 0, 1)) * scale + position;
//
////    cout << "MP : " << mousePosition << endl;
////    cout << "TP0: " << trianglePoints[0] << endl;
////    cout << "TP1: " << trianglePoints[1] << endl;
////    cout << "TP2: " << trianglePoints[2] << endl;
//
//    // Equation from stack overflow
//    float alpha, beta, gamma;
//    alpha = ((trianglePoints[1].y - trianglePoints[2].y) * (mousePosition.x - trianglePoints[2].x) + (trianglePoints[2].x - trianglePoints[1].x) * (mousePosition.y - trianglePoints[2].y)) /
//            ((trianglePoints[1].y - trianglePoints[2].y) * (trianglePoints[0].x - trianglePoints[2].x) + (trianglePoints[2].x - trianglePoints[1].x)*(trianglePoints[0].y - trianglePoints[2].y));
//    beta = ((trianglePoints[2].y - trianglePoints[0].y) * (mousePosition.x - trianglePoints[2].x) + (trianglePoints[0].x - trianglePoints[2].x) * (mousePosition.y - trianglePoints[2].y)) /
//           ((trianglePoints[1].y - trianglePoints[2].y)*(trianglePoints[0].x - trianglePoints[2].x) + (trianglePoints[2].x - trianglePoints[1].x) * (trianglePoints[0].y - trianglePoints[2].y));
//    gamma = 1.0f - alpha - beta;
//
//    // alpha, beta, and gamma have to be greater than 0
//    if (alpha > 0 && beta > 0 && gamma > 0) {
//        // Get projection to get length and width
//        glm::vec3 a = trianglePoints[0] - mousePosition;
//        glm::vec3 b = trianglePoints[0] - trianglePoints[1];
//        glm::vec3 c = trianglePoints[0] - (glm::rotate(verts[3], glm::radians(rotation), glm::vec3(0, 0, 1)) * scale + position);
//        float projectionWidth = glm::dot(a, b) / glm::distance(trianglePoints[0], trianglePoints[1]);
//        float projectionHeight = glm::dot(a, c) / glm::distance(trianglePoints[0], (glm::rotate(verts[3], glm::radians(rotation), glm::vec3(0, 0, 1)) * scale + position));
//
//        // Get color
//        // cout << "Projection: " << projectionWidth << ", " << projectionHeight << endl;
//        ofColor pixelColor = getColorWithPercentage(projectionWidth / (width * scale.x), projectionHeight / (height * scale.y));
//
//        // Check for transparency
//        return pixelColor.a != 0;
//    }
//
//    // Compute other half of rectangle
//    trianglePoints[0] = glm::rotate(verts[0], glm::radians(rotation), glm::vec3(0, 0, 1)) * scale + position;
//    trianglePoints[1] = glm::rotate(verts[3], glm::radians(rotation), glm::vec3(0, 0, 1)) * scale + position;
//    trianglePoints[2] = glm::rotate(verts[2], glm::radians(rotation), glm::vec3(0, 0, 1)) * scale + position;
//
//    alpha = ((trianglePoints[1].y - trianglePoints[2].y) * (mousePosition.x - trianglePoints[2].x) + (trianglePoints[2].x - trianglePoints[1].x) * (mousePosition.y - trianglePoints[2].y)) /
//            ((trianglePoints[1].y - trianglePoints[2].y) * (trianglePoints[0].x - trianglePoints[2].x) + (trianglePoints[2].x - trianglePoints[1].x)*(trianglePoints[0].y - trianglePoints[2].y));
//    beta = ((trianglePoints[2].y - trianglePoints[0].y) * (mousePosition.x - trianglePoints[2].x) + (trianglePoints[0].x - trianglePoints[2].x) * (mousePosition.y - trianglePoints[2].y)) /
//           ((trianglePoints[1].y - trianglePoints[2].y)*(trianglePoints[0].x - trianglePoints[2].x) + (trianglePoints[2].x - trianglePoints[1].x) * (trianglePoints[0].y - trianglePoints[2].y));
//    gamma = 1.0f - alpha - beta;
//
//    // alpha, beta, and gamma have to be greater than 0
//    if (alpha > 0 && beta > 0 && gamma > 0) {
//        // Get projection to get length and width
//        glm::vec3 a = trianglePoints[0] - mousePosition;
//        glm::vec3 b = trianglePoints[0] - (glm::rotate(verts[1], glm::radians(rotation), glm::vec3(0, 0, 1)) * scale + position);
//        glm::vec3 c = trianglePoints[0] - trianglePoints[1];
//        float projectionWidth = glm::dot(a, b) / glm::distance(trianglePoints[0], trianglePoints[1]);
//        float projectionHeight = glm::dot(a, c) / glm::distance(trianglePoints[0], (glm::rotate(verts[3], glm::radians(rotation), glm::vec3(0, 0, 1)) * scale + position));
//
//        // Get color
//        // cout << "Projection: " << projectionWidth << ", " << projectionHeight << endl;
//        ofColor pixelColor = getColorWithPercentage(projectionWidth / (width * scale.x), projectionHeight / (height * scale.y));
//
//        // Check for transparency
//        return pixelColor.a != 0;
//    }
//
//    // Didn't even touch the rectangle
//    return false;
//}
//
//ofColor ImageShape::getColorWithPercentage(float x, float y) {
//    // cout << "x : " << x << " y : " << y << endl;
//    if (x > 1 || y > 1) {
//        cout << "x/y is greater than 1. Values should be 0 - 1" << endl;
//        // throw error("x/y is greater than 1. Values should be 0 - 1");
//    }
//    return image.getColor((int) (width * x), (int) (height * y));
//}


//bool TriangleShape::inside(glm::vec3 p0) {
//
////    glm::vec3 p = glm::inverse(getTransform()) * glm::vec4(p0, 1);
////    glm::vec3 v1 = glm::normalize(verts[0] - p);
////    glm::vec3 v2 = glm::normalize(verts[1] - p);
////    glm::vec3 v3 = glm::normalize(verts[2] - p);
////    float a1 = glm::orientedAngle(v1, v2, glm::vec3(0, 0, 1));
////    float a2 = glm::orientedAngle(v2, v3, glm::vec3(0, 0, 1));
////    float a3 = glm::orientedAngle(v3, v1, glm::vec3(0, 0, 1));
//////    cout << getTransform() << endl;
//////    glm::mat temp = getTransform();
//////    glm::mat temp1 = glm::inverse(getTransform());
//////    cout << temp1 << endl;
//////    cout << glm::inverseTranspose(getTransform()) << endl;
//////    cout << p0 << " " << verts[0] << " " << verts[1] << " " << verts[2] << endl;
//////    cout << p << " " << v1 << " " << v2 << " " << v3 << endl;
//////    cout << a1 << " " << a2 << " " << a3 << endl;
////    if (a1 < 0 && a2 < 0 && a3 < 0) return true;
////    else return false;
//
////    glm::vec3 mousePosition = p0;
////    float isAcuteAngle0 = std::atan2(verts[0].y - mousePosition.y, verts[0].x - mousePosition.x) -
////                  std::atan2(verts[1].y - mousePosition.y, verts[1].x - mousePosition.x);
////    float isAcuteAngle1 = std::atan2(verts[1].y - mousePosition.y, verts[1].x - mousePosition.x) -
////                  std::atan2(verts[2].y - mousePosition.y, verts[2].x - mousePosition.x);
////    float isAcuteAngle2 = std::atan2(verts[2].y - mousePosition.y, verts[2].x - mousePosition.x) -
////                  std::atan2(verts[0].y - mousePosition.y, verts[0].x - mousePosition.x);
////    float alpha = ((verts[1].y - verts[2].y) * (mousePosition.x - verts[2].x) + (verts[2].x - verts[1].x) * (mousePosition.y - verts[2].y)) /
////            ((verts[1].y - verts[2].y) * (verts[0].x - verts[2].x) + (verts[2].x - verts[1].x) * (verts[0].y - verts[2].y));
////    float beta = ((verts[2].y - verts[0].y) * (mousePosition.x - verts[2].x) + (verts[0].x - verts[2].x) * (mousePosition.y - verts[2].y)) /
////           ((verts[1].y - verts[2].y) * (verts[0].x - verts[2].x) + (verts[2].x - verts[1].x) * (verts[0].y - verts[2].y));
////    float gamma = 1.0f - alpha - beta;
////    /* Barycentric coordinates equation: https://stackoverflow.com/questions/13300904/determine-whether-point-lies-inside-triangle */
////    cout << alpha << " " << beta << " " << gamma << endl;
////    return alpha > 0 && beta > 0 && gamma > 0;
//}

void TriangleShape::forward(float t) {
    // Move base on heading vector (glm::vec3(0, n, 0))
    // f(t) = o + dt
    // position += glm::rotate(glm::vec3(0, -1, 0), glm::radians(rotation), glm::vec3(0, 0, 1)) * t;
    position += glm::rotate(headingVector, glm::radians(rotation), glm::vec3(0, 0, 1)) * t;
}

void ImageShape::forward(float t) {
    // Move base on heading vector
    // f(t) = o + dt
    position += glm::rotate(headingVector, glm::radians(rotation), glm::vec3(0, 0, 1)) * scale.y * t;
    // position += glm::rotate(glm::vec3(0, -1, 0), glm::radians(rotation), glm::vec3(0, 0, 1)) * t;
}


TriangleShape::TriangleShape() {
    verts.push_back(glm::vec3(1, 1, 0));
    verts.push_back(glm::vec3(0, -2, 0));
    verts.push_back(glm::vec3(-1, 1, 0));
    scale = glm::vec3(50, 50, 1);
    position = glm::vec3(ofGetWindowWidth() / 2.0, ofGetWindowHeight() / 2.0, 0);
    
    // Heading vector
    // Choose greatest distance from the 3 points
    float distance = 0.0f;
    for (int i = 0; i < verts.size(); i++) {
        glm::vec3 trianglePoint = verts[i] + position;
        float pointDistance = glm::distance(trianglePoint, position);
        distance = (pointDistance > distance) ? pointDistance : distance;
    }
    headingVector = glm::vec3(0, -1 * distance * 3, 0);
}

ImageShape::ImageShape() {
    // Transforms
    scale = glm::vec3(0.25, 0.25, 1);
    position = glm::vec3(ofGetWindowWidth() / 2.0, ofGetWindowHeight() / 2.0, 0);
    
    // Color
    color = ofColor::white;
    
    // Load image
    if (image.load("images/ship.png")) {
        cout << "image loaded" << endl;
    }
    
    // Set height and width and verts
    width = image.getWidth();
    height = image.getHeight();
    
    verts.push_back(glm::vec3(width / -2.0, height / -2.0, 0));
    verts.push_back(glm::vec3(width / 2.0, height / -2.0, 0));
    verts.push_back(glm::vec3(width / 2.0, height / 2.0, 0));
    verts.push_back(glm::vec3(width / -2.0, height / 2.0, 0));
    
    // Heading vector
    headingVector = glm::vec3(0, -1 * height, 0);
}

void ImageShape::draw() {
    // Transformation
    ofPushMatrix();
    ofMultMatrix(getTransform());
    
    // Draw rectangle
    ofNoFill();
    ofSetColor(boundingColor);
    ofDrawRectangle(width / -2.0, height / -2.0, width, height);
    
    
    // Draw image
    ofFill();
    ofSetColor(color);
    image.draw(glm::vec3(width / -2.0, height / -2.0, 0));
    
    // Draw heading vector
    if (showHeadingVector) {
        ofFill();
        ofSetColor(headingVectorColor);
    //    ofDrawLine(position + glm::vec3((width / 2.0), (height / 2.0), 0), glm::rotate(headingVector, glm::radians(rotation), glm::vec3(0, 0, 1)) * scale + position + glm::vec3((width / 2.0), 0, 0));
        ofDrawLine(glm::vec3(0, 0, 0), headingVector);
        
        
    }
    
    // Remove matrix transformation
    ofPopMatrix();
    
}

void TriangleShape::draw() {
    ofPushMatrix();
    ofMultMatrix(getTransform());
    // draw stuff
    //
    ofFill();
    ofSetColor(color);
    ofDrawTriangle(verts[0], verts[1], verts[2]);
    
    // Draw heading vector
    if (showHeadingVector) {
        ofSetColor(headingVectorColor);
        // ofDrawLine(position, glm::rotate(headingVector, glm::radians(rotation), glm::vec3(0, 0, 1)) * scale + position);
        ofDrawLine(glm::vec3(0, 0, 0), headingVector);
    }
    
    
    ofPopMatrix();
}

//--------------------------------------------------------------
void ofApp::setup(){
    circlePosition = glm::vec3(ofGetWindowWidth() / 2.0f, ofGetWindowHeight() / 2.0f, 0);
    
    gui.setup(); // most of the time you don't need a name
    gui.add(headingVectorGUI.setup("Show Heading Vector", true, 125.0, 20.0));
    gui.add(shipGUI.setup("Show Ship / Show Triangle", false, 125.0, 20.0));
    gui.add(scaleGUI.setup("Scale", .33, 0.0, 10.0));
}

//--------------------------------------------------------------
void ofApp::update(){
    float scale = scaleGUI;
    
    ship.scale = glm::vec3(scale, scale, 1);
    triangle.scale = glm::vec3(scale * 100, scale * 100, 1);
    
    ship.showHeadingVector = headingVectorGUI;
    triangle.showHeadingVector = headingVectorGUI;
}

//--------------------------------------------------------------
void ofApp::draw(){
    // ofDrawCircle(circlePosition, radius);
    
    if (shipGUI) {
        if (shipGUI != shipGUISwap) {
            ship.position = triangle.position;
            ship.rotation = triangle.rotation;
            shipGUISwap = shipGUI;
        }
        ship.draw();
    }
    if (!shipGUI) {
        if (shipGUI != shipGUISwap) {
            triangle.position = ship.position;
            triangle.rotation = ship.rotation;
            shipGUISwap = shipGUI;
        }
        triangle.draw();
    }
    
    gui.draw();
    
    // ofDrawTriangle(trianglePoints[0], trianglePoints[1], trianglePoints[2]);
}

//--------------------------------------------------------------
void ofApp::exit(){

}

//--------------------------------------------------------------
void ofApp::keyPressed(int key){
    switch (key) {
        case 'f':
        case 'F':
            ofToggleFullscreen();
            break;
        // Left arrow
        case 57356:
            triangle.rotation -= 1.0f;
            ship.rotation -= 1.0f;
            break;
        // Right arrow
        case 57358:
            triangle.rotation += 1.0f;
            ship.rotation += 1.0f;
            break;
        // Up arrow
        case 57357:
            triangle.forward(1.0f);
            ship.forward(0.1f);
            break;
        // Down arrow
        case 57359:
            triangle.forward(-1.0f);
            ship.forward(-0.1f);
            break;
        default:
            cout << "Unknown Key: " << key << endl;
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
    // Get mouse position
    glm::vec3 mousePosition = glm::vec3(x, y, 0);
    
    // Move the circle when cursor is on the circle
    if (isMouseOnCircle) {
        circlePosition = mousePosition + circleMouseOffsetPosition;
    }
    
    // Move the triangle when cursor is on the triangle
    if (isMouseOnTriangle) {
        glm::vec3 delta = mousePosition - lastMousePosition;
        triangle.position += delta;
//        glm::vec3 delta = mousePosition - lastMousePosition;
//        for (int i = 0; i < (sizeof(trianglePoints)/sizeof(*trianglePoints)); i++) {
//            trianglePoints[i] += delta;
//        }
//        std::cout << delta << std::endl;
    }
    
    if (isMouseOnImage) {
        glm::vec3 delta = mousePosition - lastMousePosition;
        ship.position += delta;
    }
    
    
    lastMousePosition = glm::vec3(x, y, 0);
}

//--------------------------------------------------------------
void ofApp::mousePressed(int x, int y, int button){
    // Get mouse position
    glm::vec3 mousePosition = glm::vec3(x, y, 0);
    lastMousePosition = mousePosition;
    
    
    /* CIRCLE */
    // Detect if cursor is touching the circle
    float distance = glm::distance(circlePosition, mousePosition);
    isMouseOnCircle = distance <= radius;
    
    // Set offset
    circleMouseOffsetPosition = circlePosition - mousePosition;
    
    /* TRIANGLE */
    isMouseOnTriangle = triangle.inside(mousePosition);
    // std::cout << isMouseOnTriangle << std::endl;
    
    /* IMAGE */
    isMouseOnImage = ship.inside(mousePosition);
    cout << isMouseOnImage << endl;
    
    /* TRIANGLE */
    // Detect if cursor is touching the triangle
//    float isAcuteAngle0 = std::atan2(trianglePoints[0].y - mousePosition.y, trianglePoints[0].x - mousePosition.x) -
//                  std::atan2(trianglePoints[1].y - mousePosition.y, trianglePoints[1].x - mousePosition.x);
//    float isAcuteAngle1 = std::atan2(trianglePoints[1].y - mousePosition.y, trianglePoints[1].x - mousePosition.x) -
//                  std::atan2(trianglePoints[2].y - mousePosition.y, trianglePoints[2].x - mousePosition.x);
//    float isAcuteAngle2 = std::atan2(trianglePoints[2].y - mousePosition.y, trianglePoints[2].x - mousePosition.x) -
//                  std::atan2(trianglePoints[0].y - mousePosition.y, trianglePoints[0].x - mousePosition.x);
//        float alpha = ((trianglePoints[1].y - trianglePoints[2].y) * (mousePosition.x - trianglePoints[2].x) + (trianglePoints[2].x - trianglePoints[1].x) * (mousePosition.y - trianglePoints[2].y)) /
//                ((trianglePoints[1].y - trianglePoints[2].y) * (trianglePoints[0].x - trianglePoints[2].x) + (trianglePoints[2].x - trianglePoints[1].x)*(trianglePoints[0].y - trianglePoints[2].y));
//        float beta = ((trianglePoints[2].y - trianglePoints[0].y) * (mousePosition.x - trianglePoints[2].x) + (trianglePoints[0].x - trianglePoints[2].x) * (mousePosition.y - trianglePoints[2].y)) /
//               ((trianglePoints[1].y - trianglePoints[2].y)*(trianglePoints[0].x - trianglePoints[2].x) + (trianglePoints[2].x - trianglePoints[1].x) * (trianglePoints[0].y - trianglePoints[2].y));
//        float gamma = 1.0f - alpha - beta;
//    /* Barycentric coordinates equation: https://stackoverflow.com/questions/13300904/determine-whether-point-lies-inside-triangle */
//
//    isMouseOnTriangle = alpha > 0 && beta > 0 && gamma > 0;
    // isMouseOnTriangle = isAcuteAngle0 && isAcuteAngle1 && isAcuteAngle2;
//    std::cout << isAcuteAngle0 << std::endl;
//    std::cout << isAcuteAngle1 << std::endl;
//    std::cout << isAcuteAngle2 << std::endl << std::endl;
//    std::cout << alpha << std::endl;
//    std::cout << beta << std::endl;
//    std::cout << gamma << std::endl << std::endl;
    
    
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
