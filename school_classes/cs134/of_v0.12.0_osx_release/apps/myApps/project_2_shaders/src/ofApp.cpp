#include "ofApp.h"
#include <limits>
#include <typeinfo>
#include <string>

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

ofColor ofApp::lambert(const glm::vec3 &p, const glm::vec3 &norm, const ofColor diffuse) {
    
    float diffuseMultiplier = 0;

    // Go through all the lights
    for (auto &light : lights) {
        // Light vars
        glm::vec3 lightPosition = light->p;
        float lightIntensity = light->lightIntensity;

        // Case: check if the light blocked it (shadows)
        glm::vec3 point = p;
        if (enableCastingShadowsGUI && !isIlluminated(*light, point)) continue;

        // Calculate light Lamberts //
        // Calculate light normal (l)
        glm::vec3 lightNormal = glm::normalize(lightPosition - p);
        // Calculate light per unit (l . n)
        float lightPerUnit = (glm::dot(lightNormal, norm) > 0) ? glm::dot(lightNormal, norm) : 0;
        // Calculate light falloff (I / r^2)
        float lightFalloff = lightIntensity / (glm::distance(lightPosition, p) * glm::distance(lightPosition, p));
        // Calculate diffusely reflected light L_d = k_d * (I / r^2) * max(0, l . n)
        float diffuselyReflectedLight = diffuseCoefficient * lightFalloff * lightPerUnit;
        
        // Add to diffuse multiplier
        diffuseMultiplier += diffuselyReflectedLight;
    }

    // Add ambient; diffuse multiplier cannot be greater than 1
    diffuseMultiplier = (diffuseMultiplier + ambientLightCoefficientGUI < 1) ? diffuseMultiplier + ambientLightCoefficientGUI : 1;

    // Adjust diffuse color to the multiplier
    ofColor pixelColor = ofColor(diffuse.r * diffuseMultiplier, diffuse.g * diffuseMultiplier, diffuse.b * diffuseMultiplier);
    return pixelColor;
}

ofColor ofApp::phong(const glm::vec3 &p, const glm::vec3 &norm, const ofColor diffuse, const ofColor specular, float power) {


    float diffuseMultiplier = 0;
    float specularMultiplier = 0;
    // Go through all the lights
    for (auto &light : lights) {
        // Light vars
        glm::vec3 lightPosition = light->p;
        float lightIntensity = light->lightIntensity;

        // Case: check if the light blocked it (shadows)
        glm::vec3 point = p;
        if (enableCastingShadowsGUI && !isIlluminated(*light, point)) continue;

        // Calculate light Lamberts //
        // Calculate light normal (l)
        glm::vec3 lightNormal = glm::normalize(lightPosition - p);
        // Calculate light per unit (l . n)
        float lightPerUnit = (glm::dot(lightNormal, norm) > 0) ? glm::dot(lightNormal, norm) : 0;
        // Calculate light falloff (I / r^2)
        float lightFalloff = lightIntensity / (glm::distance(lightPosition, p) * glm::distance(lightPosition, p));
        // Calculate diffusely reflected light L_d = k_d * (I / r^2) * max(0, l . n)
        float diffuselyReflectedLight = diffuseCoefficient * lightFalloff * lightPerUnit;
        
        // Add to diffuse multiplier
        diffuseMultiplier += diffuselyReflectedLight;


        // Calculate light Specular
        // Calculate v
        glm::vec3 viewPoint = glm::normalize(previewCam.getPosition() - p);

        // Calculate half vector (h = (v + l) / (||v + l||)
        glm::vec3 halfVector = normalize((lightNormal + viewPoint) / glm::distance(lightNormal, viewPoint));

        // Calculate light per unit max(0, n . h)
        float lightPerUnit1 = (glm::dot(norm, halfVector) > 0) ? glm::dot(norm, halfVector) : 0;
        
        // Calculate specular reflected light L_s =  k_s * (I / r^2) * max(0, n . h) ^ p
        float specularReflectLight = specularCoefficient * lightFalloff * glm::pow(lightPerUnit1, power);

        // add to specular multiplier
        specularMultiplier += specularReflectLight;
    }

    // Add ambient; diffuse multiplier & specular multiplier cannot be greater than 1
    diffuseMultiplier = (diffuseMultiplier + ambientLightCoefficientGUI < 1) ? diffuseMultiplier + ambientLightCoefficientGUI : 1;
    specularMultiplier = (specularMultiplier < 1) ? specularMultiplier : 1;

    // Adjust diffuse color to the multiplier
    ofColor pixelColor = ofColor(diffuse.r * diffuseMultiplier, diffuse.g * diffuseMultiplier, diffuse.b * diffuseMultiplier);
    // Add specular 
    pixelColor += ofColor(specular.r * specularMultiplier, specular.g * specularMultiplier, specular.b * specularMultiplier);

    return pixelColor;
}


// float ofApp::calculateShade(Light &light, glm::vec3 &intersectionPoint, glm::vec3 &normal) {
//     // Light vars
//     glm::vec3 lightPosition = light.p;
//     float lightIntensity = light.lightIntensity;
    
//     // Calculate light Lamberts //
//     // Calculate light normal (l)
//     glm::vec3 lightNormal = glm::normalize(lightPosition - intersectionPoint);
//     // Calculate light per unit (l . n)
//     float lightPerUnit = (glm::dot(lightNormal, normal) > 0) ? glm::dot(lightNormal, normal) : 0;
//     // Calculate light falloff (I / r^2)
//     float lightFalloff = lightIntensity / (glm::distance(lightPosition, intersectionPoint) * glm::distance(lightPosition, intersectionPoint));
//     // Calculate diffusely reflected light L_d = k_d * (I / r^2) * max(0, l . n)
//     float diffuselyReflectedLight = diffuseCoefficient * lightIntensity * lightPerUnit;
    
//     // Shade multiplier (can't be greater than 1)
//     return (diffuselyReflectedLight < 1) ? diffuselyReflectedLight : 1;
// }

bool ofApp::isIlluminated(Light &light, glm::vec3 &p) {
    // Light vars
    glm::vec3 lightPosition = light.p;
    
    // Get distance
    float distance = glm::distance(lightPosition, p) -0.1f;
    
    // Create ray to check other objects
    Ray ray = Ray(lightPosition, glm::normalize(p - lightPosition));
    
    // Go through all the objects and get the closest object
    for (auto &sceneObject : scene) {
        // Edge case: GUI mesh
        if (!showMeshesGUI) {
            string s = typeid(*sceneObject).name();
            if (s.find("Mesh") != std::string::npos) {
                continue;
            }
        }

        // Get intersection of the object, if it's closer (shorter distance), then the light is being blocked at that point
        glm::vec3 intersectionPoint1, normal;
        if (sceneObject->intersect(ray, intersectionPoint1, normal) && distance > glm::distance(intersectionPoint1, lightPosition)) {
            return false;
        }
        
    }
    return true;
}

// bool ofApp::isIlluminated(SceneObject &sceneObject, Light &light, glm::vec3 &intersectionPoint) {
//     // Light vars
//     glm::vec3 lightPosition = light.p;
    
//     // Get distance
//     float distance = glm::distance(lightPosition, intersectionPoint);
    
//     // Create ray to check other objects
//     Ray ray = Ray(lightPosition, glm::normalize(intersectionPoint - lightPosition));
    
//     // Go through all the objects, and check if it is blocking that object
//     for (int i = 0; i < scene.size(); i++) {
//         // Edge case: it is that object
//         if (&sceneObject == scene[i]) continue;
        
//         // Get intersection of the object, if it's closer (shorter distance), then the light is being blocked
//         glm::vec3 intersectionPoint1, normal;
//         if (scene[i]->intersect(ray, intersectionPoint1, normal) && distance > glm::distance(intersectionPoint1, lightPosition)) {
//             return false;
//         }
        
//     }
//     return true;
// }

SceneObject* ofApp::getClosestSceneObject(Ray &ray) {
    SceneObject* closestSceneObject = NULL;
    float distance = std::numeric_limits<float>::max();
    glm::vec3 intersectionPoint, normal;
    
    // Go through scene and pick the scene object with the closest distance
    for (auto &sceneObject : scene) {
        // Edge case: GUI mesh
        if (!showMeshesGUI) {
            string s = typeid(*sceneObject).name();
            if (s.find("Mesh") != std::string::npos) {
                continue;
            }
        }

        bool isIntersect = sceneObject->intersect(ray, intersectionPoint, normal);
        bool isClosestObject = distance > glm::distance(previewCam.getPosition(), intersectionPoint);
        if (isIntersect && isClosestObject) {
            distance = glm::distance(previewCam.getPosition(), intersectionPoint);
            closestSceneObject = sceneObject;
        }
    }

    return closestSceneObject;
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
            
            // Get closest scene object
            SceneObject* closestSceneObject = getClosestSceneObject(ray);
            
            // Edge case: no intersection, set to background color
            if (closestSceneObject == NULL) {
                image.setColor(x, imageHeight - y, backgroundColor);
                continue;
            }

            // Edge case: Lambert not enabled, set to ambient
            if (!enableLambertGUI) image.setColor(x, imageHeight - y, closestSceneObject->diffuseColor);

            // Grab point of intersection
            glm::vec3 intersectionPoint, normal;
            closestSceneObject->intersect(ray, intersectionPoint, normal);

            // Get diffuse color and run lamberts
            ofColor pixelColor = closestSceneObject->diffuseColor;

            // Run phong or lambert
            if (enablePhongGUI) {
                pixelColor = phong(intersectionPoint, normal, closestSceneObject->diffuseColor, closestSceneObject->specularColor, phongPower);
            } else if (enableLambertGUI) {
                pixelColor = lambert(intersectionPoint, normal, closestSceneObject->diffuseColor);
            }



        
            // Change color of the image
            image.setColor(x, imageHeight - y, pixelColor);
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
    
    scene.push_back(&sphere);
    scene.push_back(&sphere1);
    scene.push_back(&sphere2);
    scene.push_back(&plane);
    scene.push_back(&plane1);
    scene.push_back(&mesh);

    // Add lights into vector
    lights.push_back(&light);
    lights.push_back(&light1);
    
    // GUI
    gui.setup();
    gui.add(showMeshesGUI.setup("Show Meshes", true, 125.0, 20.0));
    gui.add(enableLambertGUI.setup("Enable Lambert", true, 125.0, 20.0));
    gui.add(enablePhongGUI.setup("Enable Phong", true, 125.0, 20.0));
    gui.add(enableCastingShadowsGUI.setup("Enable Casting Shadows", true, 125.0, 20.0));
    
    gui.add(ambientLightCoefficientGUI.setup("Ambient Light Multiplier", 0.2, 0.0, 1.0));
    gui.add(lightPositionZGUI.setup("Light0 Position Z", lights[0]->p.z, -20, 20.0));
    gui.add(lightIntensityGUI.setup("Light0 Intensity", lights[0]->lightIntensity, 0.0, 1000.0));
    gui.add(light1PositionZGUI.setup("Light1 Position Z", lights[1]->p.z, -20, 20.0));
    gui.add(light1IntensityGUI.setup("Light1 Intensity", lights[1]->lightIntensity, 0.0, 1000.0));
    
    gui.add(diffuseCoefficientGUI.setup("Diffuse Coefficient", diffuseCoefficient, 0.0, 1.0));
    gui.add(specularCoefficientGUI.setup("Specular Coefficient", specularCoefficient, 0.0, 1.0));
    gui.add(phongPowerGUI.setup("Phong Power", phongPower, 10.0, 10000.0));

}

//--------------------------------------------------------------
void ofApp::update(){
    // GUI //
    diffuseCoefficient = diffuseCoefficientGUI;
    phongPower = phongPowerGUI;
    specularCoefficient = specularCoefficientGUI;
    lights[0]->lightIntensity = lightIntensityGUI;
    lights[0]->p = glm::vec3(lights[0]->p.x, lights[0]->p.y, (float) lightPositionZGUI);
    lights[1]->lightIntensity = light1IntensityGUI;
    lights[1]->p = glm::vec3(lights[1]->p.x, lights[1]->p.y, (float) light1PositionZGUI);
    if (enablePhongGUI) enableLambertGUI = true; // If phong is enabled, enable lambert
}

//--------------------------------------------------------------
void ofApp::draw(){
    
    
    theCam->begin();
    
    // Draw scene objects
    ofSetColor(255, 255, 255);
    for (auto &sceneObject : scene) {
        // Edge case: GUI mesh
        if (!showMeshesGUI) {
            string s = typeid(*sceneObject).name();
            if (s.find("Mesh") != std::string::npos) {
                continue;
            }
        }

        ofSetColor(sceneObject->diffuseColor);
        sceneObject->draw();
    }
    
    // Draw lights
    for (int i = 0; i < lights.size(); i++) {
        lights[i]->draw();
    }
    
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
