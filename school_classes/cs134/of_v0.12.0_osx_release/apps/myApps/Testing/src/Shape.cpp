#include <stdio.h>
#include "ofApp.h"
#include "Shape.h"

//// Example on how to use GLM to return a transform based on component matrices
////
//glm::mat4 Shape::getTransform() {
//    glm::mat4 trans = glm::translate(glm::mat4(1.0), glm::vec3(position));
//    glm::mat4 rot = glm::rotate(glm::mat4(1.0), glm::radians(rotation),
//    glm::vec3(0, 0, 1));
//    glm::mat4 scale = glm::scale(glm::mat4(1.0), this->scale);
//    return (trans * rot * scale);
//}
//
//
//bool TriangleShape::inside(glm::vec3 p0) {
//    glm::vec3 p = glm::inverse(getTransform()) * glm::vec4(p0, 1);
//    glm::vec3 v1 = glm::normalize(verts[0] - p);
//    glm::vec3 v2 = glm::normalize(verts[1] - p);
//    glm::vec3 v3 = glm::normalize(verts[2] - p);
//    float a1 = glm::orientedAngle(v1, v2, glm::vec3(0, 0, 1));
//    float a2 = glm::orientedAngle(v2, v3, glm::vec3(0, 0, 1));
//    float a3 = glm::orientedAngle(v3, v1, glm::vec3(0, 0, 1));
//    if (a1 < 0 && a2 < 0 && a3 < 0) return true;
//    else return false;
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
////           ((verts[1].y - verts[2].y)*(verts[0].x - verts[2].x) + (verts[2].x - verts[1].x) * (verts[0].y - verts[2].y));
////    float gamma = 1.0f - alpha - beta;
////    /* Barycentric coordinates equation: https://stackoverflow.com/questions/13300904/determine-whether-point-lies-inside-triangle */
////
////    return alpha > 0 && beta > 0 && gamma > 0;
//    
//}
//TriangleShape::TriangleShape() {
//    verts.push_back(glm::vec3(1, 1, 0));
//    verts.push_back(glm::vec3(0, -2, 0));
//    verts.push_back(glm::vec3(-1, 1, 0));
//    scale = glm::vec3(50, 50, 0);
//    position = glm::vec3(ofGetWindowWidth() / 2.0, ofGetWindowHeight() / 2.0, 0);
//}
//
//void TriangleShape::draw() {
//    ofPushMatrix();
//    ofMultMatrix(getTransform());
//    // draw stuff
//    //
//    ofFill();
//    ofSetColor(color);
//    ofDrawTriangle(verts[0], verts[1], verts[2]);
//    ofPopMatrix();
//}
