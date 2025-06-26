#include "ofApp.h"
#include <limits>

// Intersect Ray with Plane  (wrapper on glm::intersect*
//
bool Plane::intersect(const Ray &ray, glm::vec3 & point, glm::vec3 & normalAtIntersect) {
    float dist;
    bool hit = glm::intersectRayPlane(ray.p, ray.d, position, this->normal, dist);
    if (hit) {
        Ray r = ray;
        point = r.evalPoint(dist);
        normalAtIntersect = this->normal;
    }
    return (hit);
}


// Convert (u, v) to (x, y, z)
// We assume u,v is in [0, 1]
//
glm::vec3 ViewPlane::toWorld(float u, float v) {
    float w = width();
    float h = height();
    return (glm::vec3((u * w) + min.x, (v * h) + min.y, position.z));
}

// Get a ray from the current camera position to the (u, v) position on
// the ViewPlane
//
Ray RenderCam::getRay(float u, float v) {
    glm::vec3 pointOnPlane = view.toWorld(u, v);
    return(Ray(position, glm::normalize(pointOnPlane - position)));
}


float ofApp::calculateShade(glm::vec3 &lightPosition, glm::vec3 &intersectionPoint, glm::vec3 &normal) {
    // Calculate light Lamberts //
    // Calculate light normal (l)
    glm::vec3 lightNormal = glm::normalize(lightPosition - intersectionPoint);
    // Calculate light per unit (l . n)
    float lightPerUnit = (glm::dot(lightNormal, normal) > 0) ? glm::dot(lightNormal, normal) : 0;
    // Calculate light falloff (I / r^2)
    float lightFalloff = lightIntensity / (glm::distance(lightPosition, intersectionPoint) * glm::distance(lightPosition, intersectionPoint));
    // Calculate diffusely reflected light L_d = k_d * (I / r^2) * max(0, l . n)
    float diffuselyReflectedLight = diffuseCoefficient * lightIntensity * lightPerUnit;
    
    // Shade multiplier (can't be greater than 1)
    return (diffuselyReflectedLight < 1) ? diffuselyReflectedLight : 1;
}

bool ofApp::isIlluminated(SceneObject &sceneObject, glm::vec3 &lightPosition, glm::vec3 &intersectionPoint) {
    // Get distance
    float distance = glm::distance(lightPosition, intersectionPoint);
    
    // Create ray to check other objects
    Ray ray = Ray(lightPosition, glm::normalize(intersectionPoint - lightPosition));
    
    // Go through all the objects, and check if it is blocking that object
    for (int i = 0; i < scene.size(); i++) {
        // Edge case: it is that object
        if (&sceneObject == scene[i]) continue;
        
        // Get intersection of the object, if it's closer (shorter distance), then the light is being blocked
        glm::vec3 intersectionPoint1, normal;
        if (scene[i]->intersect(ray, intersectionPoint1, normal) && distance > glm::distance(intersectionPoint1, lightPosition)) {
            return false;
        }
        
    }
    return true;
}

// This could be drawn a lot simpler but I wanted to use the getRay call
// to test it at the corners.
//
void RenderCam::drawFrustum() {
    Ray r1 = getRay(0, 0);
    Ray r2 = getRay(0, 1);
    Ray r3 = getRay(1, 1);
    Ray r4 = getRay(1, 0);
    float dist = glm::length((view.toWorld(0, 0) - position));
    r1.draw(dist);
    r2.draw(dist);
    r3.draw(dist);
    r4.draw(dist);
}

void ofApp::drawGrid() {

    float u = 0;
    float v = 0;
    float pixelWidth = 1.0 / imageWidth;
    float pixelHeight = 1.0 / imageHeight;
    for (int x = 0; x < imageWidth; x++) {
        glm::vec3 p1 = renderCam.view.toWorld(u, 0);
        glm::vec3 p2 = renderCam.view.toWorld(u, 1);
        ofDrawLine(p1, p2);
        u += pixelWidth;
    }
    for (int y = 0; y < imageHeight; y++) {
        glm::vec3 p1 = renderCam.view.toWorld(0, v);
        glm::vec3 p2 = renderCam.view.toWorld(1, v);
        ofDrawLine(p1, p2);
        v += pixelHeight;
    }
}

void ofApp::rayTrace() {
    for (int y = 0; y < imageHeight; y++) {
        for (int x = 0; x < imageWidth; x++) {
            // Get u, v
            float u = (float) x / (imageWidth - 1);
            float v = (float) y / (imageHeight - 1);
            
            // Get world position of view plane
            glm::vec3 viewPlanePoint = viewPlane.toWorld(u, v);
            
            // Create ray
            Ray ray = Ray(previewCam.getPosition(), glm::normalize(viewPlanePoint - previewCam.getPosition()));
            
            // Default background color; set everything to black
            image.setColor(x, imageHeight - y, ofColor::black);
            
            // Check for intersections for all scene objects
            glm::vec3 intersectionPoint, normal;
            float distance = std::numeric_limits<float>::max();
            for (int i = 0; i < scene.size(); i++) {
                // Change color when there's an intersection, it's the closest, and it has light
                bool isIntersect = scene[i]->intersect(ray, intersectionPoint, normal);
                bool isClosestObject = distance > glm::distance(previewCam.getPosition(), intersectionPoint);
                bool isLightNotBlocked = isIlluminated(*scene[i], lightPosition, intersectionPoint);
                if (!enableCastingShadowGUI) {
                    isLightNotBlocked = true;
                }
                // Set new distance for which object is in front or view plane
                // if (isClosestObject) distance = glm::distance(previewCam.getPosition(), intersectionPoint);
                
                // Reset it to black in case a farther object was drawn and light is blocked
                if (isIntersect && isClosestObject && !isLightNotBlocked) image.setColor(x, imageHeight - y, ofColor::black);
                
                // Parameters to not calculate shading:
                // Didn't hit the object
                // Computed an object that was closer
                // Has no light
                if (!isIntersect || !isClosestObject || !isLightNotBlocked) continue;

                // Get shade (lambert's) //
                float shade = calculateShade(lightPosition, intersectionPoint, normal);
                
                // Adjust color to the shade
                ofColor pixelColor = ofColor(scene[i]->diffuseColor.r * shade, scene[i]->diffuseColor.g * shade, scene[i]->diffuseColor.b * shade);
                if (!enableLambertGUI) {
                    pixelColor = scene[i]->diffuseColor;
                }
                
                // Change color of the image
                image.setColor(x, imageHeight - y, pixelColor);
                
                // Set new distance
                distance = glm::distance(previewCam.getPosition(), intersectionPoint);
            }
        }
    }
    
    // Update image and draw it
    image.update();
    
}


//--------------------------------------------------------------
void ofApp::setup(){
	// set camera parameters
	//
    ofSetBackgroundColor(ofColor::black);
//    ofEnableDepthTest();
    mainCam.setDistance(15);
    mainCam.setNearClip(.1);
    
    sideCam.setPosition(25, 0, 0);
    sideCam.lookAt(glm::vec3(0, 0, 0));
    topCam.setPosition(0, 25, 0);
    topCam.lookAt(glm::vec3(0, -1, 0));
    previewCam.setPosition(renderCam.position);
    previewCam.setNearClip(.1);
    
    previewCam.lookAt(glm::vec3(0, 0, 0));
    theCam = &mainCam;
    
    
	ofNoFill();
    
    // Load image
    image.allocate(imageWidth, imageHeight, OF_IMAGE_COLOR);
    image.setColor(ofColor::white);
    image.update();
    
    // Add scene objects into scene
    scene.push_back(&plane);
    scene.push_back(&sphere);
    scene.push_back(&sphere1);
    scene.push_back(&sphere2);
    
    // GUI
    gui.setup();
    gui.add(lightPositionZGUI.setup("Light Position Z", lightPosition.z, -20, 20.0));
    gui.add(enableLambertGUI.setup("Enable Lambert", true, 125.0, 20.0));
    gui.add(enableCastingShadowGUI.setup("Enable Casting Shadow", true, 125.0, 20.0));
    gui.add(lightIntensityGUI.setup("Light Intensity", lightIntensity, 0.0, 20.0));
    gui.add(diffuseCoefficientGUI.setup("Diffuse Coefficient", diffuseCoefficient, 0.0, 1.0));

}

//--------------------------------------------------------------
void ofApp::update(){
    // GUI
    lightIntensity = lightIntensityGUI;
    diffuseCoefficient = diffuseCoefficientGUI;
    lightPosition = glm::vec3(lightPosition.x, lightPosition.y, (float) lightPositionZGUI);
}

//--------------------------------------------------------------
void ofApp::draw(){
    
    
    theCam->begin();
    
    // Draw scene objects
    ofSetColor(255, 255, 255);
    for (int i = 0; i < scene.size(); i++) {
        ofSetColor(scene[i]->diffuseColor);
        scene[i]->draw();
    }
    
    // Draw light, don't really need to draw it but it's good to do
    ofSetColor(255, 255, 0);
    ofDrawSphere(lightPosition, 0.2f);
    
    // Render cam stuff
    ofDisableLighting();
    ofSetColor(ofColor::lightSkyBlue);
    renderCam.drawFrustum();
    renderCam.view.draw();
    ofSetColor(ofColor::blue);
    renderCam.draw();

    
    // Show image
    if (showImage) {
        ofSetColor(255, 255, 255);
        ofScale((float) viewPlane.width() / imageWidth,(float) viewPlane.height() / imageHeight, 1);
        image.draw(imageWidth / -2, imageHeight / -2, viewPlane.position.z);
    }
    
    theCam->end();
    
    // Draw GUI
    if (showGUI) gui.draw();

}

//--------------------------------------------------------------
void ofApp::keyPressed(int key){
	switch (key) {
	case 'f':
            ofToggleFullscreen();
            break;
    case 'r':
            rayTrace();
            showImage = true;
            break;
    case 'j':
            showImage = !showImage;
            break;
        case 'h':
            showGUI = !showGUI;
        case OF_KEY_F1:
            theCam = &mainCam;
            break;
        case OF_KEY_F2:
            theCam = &sideCam;
            break;
        case OF_KEY_F3:
            theCam = &previewCam;
            break;
        case OF_KEY_F4:
            theCam = &topCam;
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
