#include "ofApp.h"
#include <limits>
#include <typeinfo>
#include <string>


ofColor ofApp::lambert(const glm::vec3 &p, const glm::vec3 &norm, const ofColor diffuse) {
    
    glm::vec3 diffuseMultiplier = glm::vec3(0);

    // Go through all the lights
    for (auto &light : lights) {
        // Case: check if the light blocked it (shadows)
        glm::vec3 point = p;
        if (enableCastingShadowsGUI && !isIlluminated(*light, point)) continue;

        // Light vars
        glm::vec3 lightPosition = light->getPosition();
        float lightIntensity = light->lightIntensity;
        ofFloatColor lightColor = ofFloatColor(light->color); // Convert to uv

        // Calculate light Lamberts //
        // Calculate light normal (l)
        glm::vec3 lightNormal = glm::normalize(lightPosition - p);
        // Calculate light per unit (l . n)
        float lightPerUnit = (glm::dot(lightNormal, norm) > 0) ? glm::dot(lightNormal, norm) : 0;
        // Calculate light falloff (I / r^2)
        float lightFalloff = lightIntensity / (glm::distance2(lightPosition, p));
        // Calculate diffusely reflected light L_d = k_d * (I / r^2) * max(0, l . n)
        float diffuselyReflectedLight = diffuseCoefficient * lightFalloff * lightPerUnit;
        
        // Add to diffuse multiplier
        diffuseMultiplier += glm::vec3(lightColor.r / 255.0f, lightColor.g, lightColor.b) * diffuselyReflectedLight;
    }

    // Add ambient; diffuse multiplier cannot be greater than 1
    diffuseMultiplier += glm::vec3((float) ambientLightCoefficientGUI, (float) ambientLightCoefficientGUI, (float) ambientLightCoefficientGUI);
    diffuseMultiplier.r = (diffuseMultiplier.r < 1) ? diffuseMultiplier.r : 1;
    diffuseMultiplier.g = (diffuseMultiplier.g < 1) ? diffuseMultiplier.g : 1;
    diffuseMultiplier.b = (diffuseMultiplier.b < 1) ? diffuseMultiplier.b : 1;

    // Adjust diffuse color to the multiplier
    ofColor pixelColor = ofColor(diffuse.r * diffuseMultiplier.r, diffuse.g * diffuseMultiplier.g, diffuse.b * diffuseMultiplier.b);
    return pixelColor;
}

ofColor ofApp::phong(const glm::vec3 &p, const glm::vec3 &norm, const ofColor diffuse, const ofColor specular, float power) {


    glm::vec3 diffuseMultiplier = glm::vec3(0);
    float specularMultiplier = 0;
    // Go through all the lights
    for (auto &light : lights) {
        // Case: check if the light blocked it (shadows)
        glm::vec3 point = p;
        if (enableCastingShadowsGUI && !isIlluminated(*light, point)) continue;

        // Light vars
        glm::vec3 lightPosition = light->getPosition();
        float lightIntensity = light->lightIntensity;
        ofFloatColor lightColor = ofFloatColor(light->color); // Convert to uv

        // Calculate light Lamberts //
        // Calculate light normal (l)
        glm::vec3 lightNormal = glm::normalize(lightPosition - p);
        // Calculate light per unit (l . n)
        float lightPerUnit = (glm::dot(lightNormal, norm) > 0) ? glm::dot(lightNormal, norm) : 0;
        // Calculate light falloff (I / r^2)
        float lightFalloff = lightIntensity / (glm::distance2(lightPosition, p));
        // Calculate diffusely reflected light L_d = k_d * (I / r^2) * max(0, l . n)
        float diffuselyReflectedLight = diffuseCoefficient * lightFalloff * lightPerUnit;
        
        // Add to diffuse multiplier
        diffuseMultiplier += glm::vec3(lightColor.r, lightColor.g, lightColor.b) * diffuselyReflectedLight;


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
    diffuseMultiplier += glm::vec3((float) ambientLightCoefficientGUI, (float) ambientLightCoefficientGUI, (float) ambientLightCoefficientGUI);
    diffuseMultiplier.r = (diffuseMultiplier.r < 1) ? diffuseMultiplier.r : 1;
    diffuseMultiplier.g = (diffuseMultiplier.g < 1) ? diffuseMultiplier.g : 1;
    diffuseMultiplier.b = (diffuseMultiplier.b < 1) ? diffuseMultiplier.b : 1;
    specularMultiplier = (specularMultiplier < 1) ? specularMultiplier : 1;

    // Adjust diffuse color to the multiplier
    ofColor pixelColor = ofColor(diffuse.r * diffuseMultiplier.r, diffuse.g * diffuseMultiplier.g, diffuse.b * diffuseMultiplier.b);
    // Add specular 
    pixelColor += ofColor(specular.r * specularMultiplier, specular.g * specularMultiplier, specular.b * specularMultiplier);

    return pixelColor;
}


bool ofApp::isIlluminated(Light &light, glm::vec3 &p) {
    // Light vars
    glm::vec3 lightPosition = light.getPosition();
    
    // Get squared distance (faster), small offset
    float distance = glm::distance2(lightPosition, p) - 0.01f;
    
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

        // Get intersection of the object, if it's closer (shorter distance (squared)), then the light is being blocked at that point
        glm::vec3 intersectionPoint1, normal;
        if (sceneObject->intersect(ray, intersectionPoint1, normal) && distance > glm::distance2(intersectionPoint1, lightPosition)) {
            return false;
        }
    }

    // Run light function to check if point is being illuminated
    return light.isIlluminating(p);
}

SceneObject* ofApp::getClosestSceneObject(Ray &ray, bool addLights, bool isSelectable) {
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

        // Edge case: Scene object isn't selectable
        if (isSelectable && !sceneObject->isSelectable) continue;

        bool isIntersect = sceneObject->intersect(ray, intersectionPoint, normal);
        float currentDistance = glm::distance2(previewCam.getPosition(), intersectionPoint);
        bool isClosestObject = distance > currentDistance;
        if (isIntersect && isClosestObject) {
            distance = currentDistance;
            closestSceneObject = sceneObject;
        }
    }


    if (!addLights) return closestSceneObject;

    // Go through scene and pick the scene object with the closest distance
    for (auto &light : lights) {
        // Edge case: light isn't selectable
        if (isSelectable && !light->isSelectable) continue;

        bool isIntersect = light->intersect(ray, intersectionPoint, normal);
        float currentDistance = glm::distance2(previewCam.getPosition(), intersectionPoint);
        bool isClosestObject = distance > currentDistance;
        if (isIntersect && isClosestObject) {
            distance = currentDistance;
            closestSceneObject = light;
        }
    }

    return closestSceneObject;
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

bool ofApp::mouseToDragPlane(int x, int y, glm::vec3& point) {
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

bool ofApp::objSelected() {
    return (selected.size() ? true : false);
}

void ofApp::clearSelectionList() {
    for (int i = 0; i < selected.size(); i++) {
        selected[i]->isSelected = false;
    }
    selected.clear();
}


//--------------------------------------------------------------
void ofApp::setup(){
	// set camera parameters
	//
    ofSetBackgroundColor(ofColor::black);
//    ofEnableDepthTest();
    mainCam.setDistance(15);
    mainCam.setNearClip(.1);
    mainCam.disableMouseInput();
    
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
    lights.push_back(&spotlight);
    lights.push_back(spotlight.pointer);
    lights.push_back(&spotlight1);
    lights.push_back(spotlight1.pointer);
    
    // GUI
    gui.setup();
    gui.add(showMeshesGUI.setup("Show Meshes", true, 125.0, 20.0));
    gui.add(enableLambertGUI.setup("Enable Lambert", true, 125.0, 20.0));
    gui.add(enablePhongGUI.setup("Enable Phong", true, 125.0, 20.0));
    gui.add(enableCastingShadowsGUI.setup("Enable Casting Shadows", true, 125.0, 20.0));
    
    gui.add(ambientLightCoefficientGUI.setup("Ambient Light Multiplier", 0.2, 0.0, 1.0));
    gui.add(lightIntensityGUI.setup("Light0 Intensity", lights[0]->lightIntensity, 0.0, 250.0));
    gui.add(light1IntensityGUI.setup("Light1 Intensity", lights[1]->lightIntensity, 0.0, 250.0));
    gui.add(spotlightIntensityGUI.setup("Spotlight0 Intensity", lights[2]->lightIntensity, 0.0, 250.0));
    gui.add(spotlight1IntensityGUI.setup("Spotlight1 Intensity", lights[4]->lightIntensity, 0.0, 250.0));

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
    lights[1]->lightIntensity = light1IntensityGUI;
    lights[2]->lightIntensity = spotlightIntensityGUI;
    lights[4]->lightIntensity = spotlight1IntensityGUI;
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
    for (auto &light : lights) {
        light->draw();
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
        ofScale((float) viewPlane.getWidth() / imageWidth,(float) viewPlane.getHeight() / imageHeight, 1);
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
    case OF_KEY_ALT:
		bAltKeyDown = true;
        // Invert 
		if (mainCam.getMouseInputEnabled()) {
            mainCam.disableMouseInput();
        } else {
            mainCam.enableMouseInput();
        }
		break;
	case OF_KEY_SHIFT:
		bSftKeyDown = true;
		break;
	case OF_KEY_CONTROL:
		bCtrlKeyDown = true;
		break;
	default:
		break;

	}

}

//--------------------------------------------------------------
void ofApp::keyReleased(int key){
    switch (key) {
		case OF_KEY_ALT:
			bAltKeyDown = false;
			// mainCam.disableMouseInput();
			break;
		case OF_KEY_CONTROL:
			bCtrlKeyDown = false;
			break;

		default:
			break;
	}
}

//--------------------------------------------------------------
void ofApp::mouseMoved(int x, int y ){

}

//--------------------------------------------------------------
void ofApp::mouseDragged(int x, int y, int button){
	if (objSelected() && bDrag) {
		glm::vec3 point;
		mouseToDragPlane(x, y, point);
		selected[0]->position += (point - lastPoint);
		lastPoint = point;
	}
}

//--------------------------------------------------------------
void ofApp::mousePressed(int x, int y, int button) {
    // if we are moving the camera around, don't allow selection
	//
	if (mainCam.getMouseInputEnabled()) return;

	// clear selection list
	//
	if (!bSftKeyDown) clearSelectionList();


	glm::vec3 p = theCam->screenToWorld(glm::vec3(x, y, 0));
	glm::vec3 d = p - theCam->getPosition();
	glm::vec3 dn = glm::normalize(d);

	// check for selection of scene objects
	//
    Ray ray = Ray(p, dn);
	SceneObject* selectedObj = getClosestSceneObject(ray, true, true);

	if (selectedObj != NULL) {
		selectedObj->isSelected = true;
		selected.push_back(selectedObj);
		bDrag = true;
		mouseToDragPlane(x, y, lastPoint);
	}
	else {
		clearSelectionList();
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

void ofApp::mouseScrolled(int x, int y, float scrollX, float scrollY) {
    // cout << "x : " << x << endl;
    // cout << "y : " << y << endl;
    // cout << "sx: " << scrollX << endl;
    // cout << "sy: " << scrollY << endl;

    if (mainCam.getMouseInputEnabled()) return;

    // Increase size of spotlight when selected
    if (spotlight.isSelected) {
        spotlight.addRadius(scrollY * 0.1f);
    }
    // Increase size of spotlight when selected
    if (spotlight1.isSelected) {
        spotlight1.addRadius(scrollY * 0.1f);
    }
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
