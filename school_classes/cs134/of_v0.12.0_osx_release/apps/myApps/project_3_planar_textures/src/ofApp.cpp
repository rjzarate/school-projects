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
        diffuseMultiplier += glm::vec3(lightColor.r, lightColor.g, lightColor.b) * diffuselyReflectedLight;
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

SceneObject* ofApp::getClosestSceneObject(Ray &ray, glm::vec3 &point, glm::vec3 &normal, bool addLights, bool isSelectable) {
    SceneObject* closestSceneObject = NULL;
    float distance = std::numeric_limits<float>::max();
    glm::vec3 _intersectionPoint, _normal;
    
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

        bool isIntersect = sceneObject->intersect(ray, _intersectionPoint, _normal);
        float currentDistance = glm::distance2(previewCam.getPosition(), _intersectionPoint);
        bool isClosestObject = distance > currentDistance;
        if (isIntersect && isClosestObject) {
            distance = currentDistance;
            closestSceneObject = sceneObject;
            point = _intersectionPoint;
            normal = _normal;
        }
    }


    if (!addLights) return closestSceneObject;

    // Go through scene and pick the scene object with the closest distance
    for (auto &light : lights) {
        // Edge case: light isn't selectable
        if (isSelectable && !light->isSelectable) continue;

        bool isIntersect = light->intersect(ray, _intersectionPoint, _normal);
        float currentDistance = glm::distance2(previewCam.getPosition(), _intersectionPoint);
        bool isClosestObject = distance > currentDistance;
        if (isIntersect && isClosestObject) {
            distance = currentDistance;
            closestSceneObject = light;
            point = _intersectionPoint;
            normal = _normal;
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
    // Update image width and height (if changed)
    image.allocate(imageWidth, imageHeight, OF_IMAGE_COLOR);

    for (int y = 0; y < imageHeight; y++) {
        for (int x = 0; x < imageWidth; x++) {
            // Get u, v
            float u = (float) x / (imageWidth - 1);
            float v = (float) y / (imageHeight - 1);
            
            // Get world position of view plane
            glm::vec3 viewPlanePoint = viewPlane.toWorld(u, v);
            
            // Create ray
            Ray ray = Ray(previewCam.getPosition(), glm::normalize(viewPlanePoint - previewCam.getPosition()));

            // Default background color; set everything to skyBlue
            image.setColor(x, imageHeight - y - 1, ofColor::lightSkyBlue);

            // Get closest scene object
            glm::vec3 intersectionPoint, normal;
            SceneObject* closestSceneObject = getClosestSceneObject(ray, intersectionPoint, normal);
            
            // Edge case: no intersection, set to skyblue
            if (closestSceneObject == NULL) {
                image.setColor(x, imageHeight - y - 1, ofColor::lightSkyBlue);
                continue;
            }

            // Edge case: Lambert not enabled, set to ambient
            if (!enableLambertGUI) image.setColor(x, imageHeight - y - 1, closestSceneObject->diffuseColor);

            // Get diffuse color and run lamberts
            ofColor diffuseColor = closestSceneObject->diffuseColor;
            ofColor specularColor = closestSceneObject->specularColor;
            ofColor imagePixelColor = ofColor::lightSkyBlue;

            // Case: swap diffuse color with texture
            if (enableTexturesGUI && closestSceneObject->diffuseTexture != NULL) {
                glm::vec2 uv = closestSceneObject->getTileUV(intersectionPoint);
                if (closestSceneObject->diffuseTexture != NULL) diffuseColor = closestSceneObject->getDiffuseTexturePixel(uv.x, uv.y);
                if (closestSceneObject->specularTexture != NULL) specularColor = closestSceneObject->getSpecularTexturePixel(uv.x, uv.y);
                if (closestSceneObject->displacementTexture != NULL) {
                    // Get displacement color, convert to float
                    ofColor displacementColor = closestSceneObject->getDisplacementTexturePixel(uv.x, uv.y);
                    float displacement = displacementColor.r / 255.0f;

                    // Scale displacement with scale
                    displacement *= closestSceneObject->displacementScale;

                    // Update intersection point
                    intersectionPoint += normal * displacement;
                }
                if (closestSceneObject->normalTexture != NULL) {
                    // Get normal color, convert to vec 3
                    ofColor normalColor = closestSceneObject->getNormalTexturePixel(uv.x, uv.y);
                    glm::vec3 sampledNormal = glm::vec3(
                        ofLerp(-1, 1, normalColor.r / 255),
                        ofLerp(-1, 1, normalColor.g / 255),
                        -1 * ofLerp(0, 1, (normalColor.b - 128) / 128)
                    );

                    // Get tangent, bitangent, and TBN
                    glm::vec3 tangent = closestSceneObject->getTangent(intersectionPoint);
                    glm::vec3 bitangent = glm::cross(normal, tangent);
                    glm::mat3 TBN = glm::mat3(tangent, bitangent, normal);

                    // Calculate world normal
                    glm::vec3 worldNormal = glm::normalize(TBN * sampledNormal);

                    glm::vec3 normal = glm::normalize(glm::mix(normal, worldNormal, 0.5f));
                }
            }
            

            // Run phong or lambert
            if (enablePhongGUI) {
                imagePixelColor = phong(intersectionPoint, normal, diffuseColor, specularColor, phongPower);
            } else if (enableLambertGUI) {
                imagePixelColor = lambert(intersectionPoint, normal, diffuseColor);
            }
        
            // Change color of the image
            image.setColor(x, imageHeight - y - 1, imagePixelColor);
        }
    }
    
    // Update image
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

    // Load textures
    if (!floorDiffuseTexture.load("images/wood_texture.jpg")) {
        cout << "failed to load floor texture" << endl;
        exit();
    }
    if (!floorSpecularTexture.load("images/wood_specular_texture.jpg")) {
        cout << "failed to load floor texture" << endl;
        exit();
    }
    if (!floorNormalTexture.load("images/wood_normal_texture.jpg")) {
        cout << "failed to load floor texture" << endl;
        exit();
    }
    if (!floorDisplacementTexture.load("images/wood_displacement_texture.jpg")) {
        cout << "failed to load floor texture" << endl;
        exit();
    }

    if (!wallDiffuseTexture.load("images/brick_texture.jpg")) {
        cout << "failed to load wall texture" << endl;
        exit();
    }
    if (!wallSpecularTexture.load("images/brick_specular_texture.jpg")) {
        cout << "failed to load wall texture" << endl;
        exit();
    }
    if (!wallNormalTexture.load("images/brick_normal_texture.jpg")) {
        cout << "failed to load wall texture" << endl;
        exit();
    }
    if (!wallDisplacementTexture.load("images/brick_displacement_texture.jpg")) {
        cout << "failed to load wall texture" << endl;
        exit();
    }

    if (!sphereDiffuseTexture.load("images/garage_texture.jpg")) {
        cout << "failed to load sphere texture" << endl;
        exit();
    }
    if (!sphereSpecularTexture.load("images/garage_specular_texture.jpg")) {
        cout << "failed to load sphere texture" << endl;
        exit();
    }
    if (!sphereNormalTexture.load("images/garage_normal_texture.jpg")) {
        cout << "failed to load sphere texture" << endl;
        exit();
    }
    if (!sphereDisplacementTexture.load("images/garage_displacement_texture.jpg")) {
        cout << "failed to load sphere texture" << endl;
        exit();
    }

    // Add scene objects into scene
    scene.push_back(&sphere);
    scene.push_back(&sphere1);
    scene.push_back(&sphere2);
    scene.push_back(&plane);
    scene.push_back(&plane1);
    scene.push_back(&mesh);

    // Attach texture to scene objects
    SceneObject *s = &plane;
    s->diffuseTexture = &floorDiffuseTexture;
    s->specularTexture = &floorSpecularTexture;
    s->normalTexture = &floorNormalTexture;
    s->displacementTexture = &floorDisplacementTexture;
    s = &plane1;
    s->diffuseTexture = &wallDiffuseTexture;
    s->specularTexture = &wallSpecularTexture;
    s->normalTexture = &wallNormalTexture;
    s->displacementTexture = &wallDisplacementTexture;
    s = &sphere;
    s->diffuseTexture = &sphereDiffuseTexture;
    s->specularTexture = &sphereSpecularTexture;
    s->normalTexture = &sphereNormalTexture;
    s->displacementTexture = &sphereDisplacementTexture;

    // Add lights into vector
    lights.push_back(&light);
    lights.push_back(&light1);
    lights.push_back(&spotlight);
    lights.push_back(spotlight.pointer);
    lights.push_back(&spotlight1);
    lights.push_back(spotlight1.pointer);
    
    // GUI
    gui.setup();
    gui.add(showMeshesGUI.setup("Show Meshes", false, 125.0, 20.0));
    gui.add(enableTexturesGUI.setup("Enable Textures", true, 125.0, 20.0));
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

    gui.add(floorTileCountGUI.setup("Floor Tile Count", ofVec2f(1, 1), ofVec2f(1, 1), ofVec2f(20, 20)));
    gui.add(wallTileCountGUI.setup("Wall Tile Count", ofVec2f(1, 1), ofVec2f(1, 1), ofVec2f(20, 20)));
    gui.add(floorDisplacementMultiplierGUI.setup("Floor Displacment Multiplier", 1.0, 0.0, 10.0));
    gui.add(wallDisplacementMultiplierGUI.setup("Wall Displacment Multiplier", 1.0, 0.0, 10.0));
    gui.add(sphereDisplacementMultiplierGUI.setup("Sphere Displacment Multiplier", 1.0, 0.0, 10.0));

    gui.add(imageWidthGUI.setup("Image Width", imageWidth, 1, 1200));
    gui.add(imageHeightGUI.setup("Image Height", imageHeight, 1, 800));
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

    SceneObject *s = &plane;
    s->tileSize = (glm::vec2) floorTileCountGUI;
    s->displacementScale = floorDisplacementMultiplierGUI;
    s = &plane1;
    s->tileSize = (glm::vec2) wallTileCountGUI;
    s->displacementScale = wallDisplacementMultiplierGUI;
    s = &sphere;
    s->displacementScale = sphereDisplacementMultiplierGUI;

    imageWidth = imageWidthGUI;
    imageHeight = imageHeightGUI;
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
    ofDisableDepthTest();
    if (showGUI) gui.draw();
    ofEnableDepthTest();

}

//--------------------------------------------------------------
void ofApp::keyPressed(int key){
	switch (key) {
    case '1': {
        Sphere* s = new Sphere(glm::vec3(0, 0, 0), 1);
        scene.push_back(s);
        break;
    }
    case 'o':
    case 'O':
        createObj();
        break;
    case 's':
        // Update image and save it in bin
        image.allocate(imageWidth, imageHeight, OF_IMAGE_COLOR);
        image.update();
        image.save("images/raytrace.png");
        break;
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
    glm::vec3 point, normal;
	SceneObject* selectedObj = getClosestSceneObject(ray, point, normal, true, true);

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

void ofApp::createObj(string fileName) {
    // Create file obj
    ofFile objFile(fileName, ofFile::WriteOnly);
    if (!objFile.is_open()) {
        cout << "Error opening file for writing: " << fileName << endl;
        return;
    }

    // Create an associated material file
    string baseName = fileName.substr(0, fileName.find_last_of("."));
    string mtlFileName = baseName + ".mtl";
    ofFile mtlFile(mtlFileName, ofFile::WriteOnly);
    if (!mtlFile.is_open()) {
        cout << "Error opening material file for writing: " << mtlFileName << endl;
        return;
    }

    // Write material file header
    mtlFile << "# Material file generated by ofApp::createObj\n";

    // Write obj file header
    objFile << "# OBJ file generated by ofApp::createObj\n";
    objFile << "mtllib " << objFile.getBaseName() << ".mtl\n";

    // Go through each scene object in scene
    int sphereMaterialCount = 0, planeMaterialCount = 0;
    int latitudeSegments = 20; // Number of horizontal segments
    int longitudeSegments = 40; // Number of vertical segments
    int vertexOffset = (latitudeSegments + 1) * (longitudeSegments + 1);
    for (auto& sceneObject : scene) {
        // Run function for specific Shapes
        string s = typeid(*sceneObject).name();

        // Mesh (.obj); no need to make an obj of it
        if (s.find("Mesh") != std::string::npos) {
            continue;
        }

        // Sphere
        if (s.find("Sphere") != std::string::npos) {
            Sphere sphere = *dynamic_cast<Sphere*>(sceneObject);
            createObj_Sphere(objFile, mtlFile, sphere, to_string(sphereMaterialCount), (sphereMaterialCount * vertexOffset) + planeMaterialCount * 4);
            sphereMaterialCount++;
            continue;
        }

        // Plane
        if (s.find("Plane") != std::string::npos) {
            Plane plane = *dynamic_cast<Plane*>(sceneObject);
            createObj_Plane(objFile, mtlFile, plane, to_string(planeMaterialCount), (sphereMaterialCount * vertexOffset) + planeMaterialCount * 4);
            planeMaterialCount++;
            continue;
        }
    }

    // Close files
    mtlFile.close();
    objFile.close();
    cout << "OBJ file written: " << fileName << endl;
    cout << "Material file written: " << mtlFileName << endl;
}

void ofApp::createObj_Sphere(ofFile &objFile, ofFile &mtlFile, const Sphere &sphere, string uniqueAppendString, int offset) {
    // Fill mtl file
    mtlFile << "newmtl SphereMaterial" + uniqueAppendString + "\n";

    bool useTextures = sphere.diffuseTexture != NULL;

    // For textures, keep 1
    if (useTextures) {
        mtlFile << "Ka 0.0 0.0 0.0\n"; // Ambient color
        mtlFile << "Kd 0.0 0.0 0.0\n"; // Diffuse color (black)
        mtlFile << "Ks 0.0 0.0 0.0\n"; // Specular color

        // Get image paths
        // cout << mtlFile.getBaseName() << endl;
        // cout << mtlFile.getFileName() << endl;
        // cout << mtlFile.getExtension() << endl;
        // cout << mtlFile.getEnclosingDirectory() << endl;
        
        string baseName = mtlFile.getEnclosingDirectory().substr(18) + "textures/";
        string diffuseName = baseName + "diffuse_sphere" + uniqueAppendString + ".jpg";
        string normalName = baseName + "normal_sphere" + uniqueAppendString + ".jpg";
        // string displacementName = baseName + "displacement_sphere" + uniqueAppendString + ".jpg";
        string specularName = baseName + "specular_sphere" + uniqueAppendString + ".jpg";
        string ambientOcclusionName = baseName + "ambient_occlusion_sphere" + uniqueAppendString + ".jpg";

        // Save new image files and add to mtl
        if (sphere.diffuseTexture != NULL) {
            sphere.diffuseTexture->save("obj/" + diffuseName);
            mtlFile << "map_Kd " + diffuseName + "\n";
        }
        if (sphere.normalTexture != NULL) {
            sphere.normalTexture->save("obj/" + normalName);
            mtlFile << "map_bump " + normalName + "\n";
        }
        // if (sphere.displacementTexture != NULL) {
        //     sphere.displacementTexture->save("obj/" + displacementName);
        //     mtlFile << "disp " + displacementName + "\n";
        // }
        if (sphere.specularTexture != NULL) {
            sphere.specularTexture->save("obj/" + specularName);
            mtlFile << "map_Ks " + specularName + "\n";
        }
        if (sphere.ambientOcclusionTexture != NULL) {
            sphere.ambientOcclusionTexture->save("obj/" + ambientOcclusionName);
            mtlFile << "map_Ka " + ambientOcclusionName + "\n";
        }

    } else {
        mtlFile << "Ka " +
                   to_string(sphere.diffuseColor.r / 255.0) + " " +
                   to_string(sphere.diffuseColor.g / 255.0) + " " +
                   to_string(sphere.diffuseColor.b / 255.0) + " \n";
        mtlFile << "Kd " +
                   to_string(sphere.diffuseColor.r / 255.0) + " " +
                   to_string(sphere.diffuseColor.g / 255.0) + " " +
                   to_string(sphere.diffuseColor.b / 255.0) + " \n";
        mtlFile << "Ks " +
                   to_string(sphere.specularColor.r / 255.0) + " " +
                   to_string(sphere.specularColor.g / 255.0) + " " +
                   to_string(sphere.specularColor.b / 255.0) + " \n";
    }
    mtlFile << "d 1.0\n";          // Transparency (1.0 = opaque)
    mtlFile << "illum 1\n";         // Illumination model
    mtlFile << "\n";


    int latitudeSegments = 20; // Number of horizontal segments
    int longitudeSegments = 40; // Number of vertical segments
    
    // Generate vertices, texture coordinates, and faces for first sphere
    objFile << "usemtl SphereMaterial" + uniqueAppendString + "\n";
    for (int lat = 0; lat <= latitudeSegments; ++lat) {
        float theta = lat * PI / latitudeSegments; // Latitude angle (0 to PI)
        float sinTheta = sin(theta);
        float cosTheta = cos(theta);

        for (int lon = 0; lon <= longitudeSegments; ++lon) {
            float phi = lon * TWO_PI / longitudeSegments; // Longitude angle (0 to 2*PI)
            float sinPhi = sin(phi);
            float cosPhi = cos(phi);

            // Calculate vertex position
            float x = sphere.position.x + sphere.radius * sinTheta * cosPhi;
            float y = sphere.position.y + sphere.radius * sinTheta * sinPhi;
            float z = sphere.position.z + sphere.radius * cosTheta;

            // Calculate texture coordinates; Cylindrical UV mapping
            float u = 0.5f - 2.0f * ((float)lon / longitudeSegments); // Horizontal wrapping (0 to 2)
            float v = ((float)lat / latitudeSegments);         // Vertical stretching (0 to 1)

            // Write vertex and texture coordinate to file
            objFile << "v " << x << " " << y << " " << z << "\n";
            objFile << "vt " << u << " " << v << "\n";
        }
    }

    for (int lat = 0; lat < latitudeSegments; ++lat) {
        for (int lon = 0; lon < longitudeSegments; ++lon) {
            int first = offset + lat * (longitudeSegments + 1) + lon + 1;
            int second = first + longitudeSegments + 1;

            // Write two faces (triangles) for each quad
            objFile << "f " << first << "/" << first << " " << second << "/" << second << " " << first + 1 << "/" << first + 1 << "\n";
            objFile << "f " << second << "/" << second << " " << second + 1 << "/" << second + 1 << " " << first + 1 << "/" << first + 1 << "\n";
        }
    }

    objFile << "\n";
}

void ofApp::createObj_Plane(ofFile &objFile, ofFile &mtlFile, const Plane &plane, string uniqueAppendString, int offset) {
    // Fill mtl file
    mtlFile << "newmtl PlaneMaterial" + uniqueAppendString + "\n";

    bool useTextures = plane.diffuseTexture != NULL;

    // For textures, keep 0
    if (useTextures) {
        mtlFile << "Ka 0.0 0.0 0.0\n"; // Ambient color
        mtlFile << "Kd 0.0 0.0 0.0\n"; // Diffuse color (black)
        mtlFile << "Ks 0.0 0.0 0.0\n"; // Specular color

        // Get image paths
        // cout << mtlFile.getBaseName() << endl;
        // cout << mtlFile.getFileName() << endl;
        // cout << mtlFile.getExtension() << endl;
        // cout << mtlFile.getEnclosingDirectory() << endl;
        
        string baseName = mtlFile.getEnclosingDirectory().substr(18) + "textures/";
        string diffuseName = baseName + "diffuse_plane" + uniqueAppendString + ".jpg";
        string normalName = baseName + "normal_plane" + uniqueAppendString + ".jpg";
        string displacementName = baseName + "displacement_plane" + uniqueAppendString + ".jpg";
        string specularName = baseName + "specular_plane" + uniqueAppendString + ".jpg";
        string ambientOcclusionName = baseName + "ambient_occlusion_plane" + uniqueAppendString + ".jpg";

        // Save new image files and add to mtl
        if (plane.diffuseTexture != NULL) {
            plane.diffuseTexture->save("obj/" + diffuseName);
            mtlFile << "map_Kd " + diffuseName + "\n";
        }
        if (plane.normalTexture != NULL) {
            plane.normalTexture->save("obj/" + normalName);
            mtlFile << "map_bump " + normalName + "\n";
        }
        if (plane.displacementTexture != NULL) {
            plane.displacementTexture->save("obj/" + displacementName);
            mtlFile << "disp " + displacementName + "\n";
        }
        if (plane.specularTexture != NULL) {
            plane.specularTexture->save("obj/" + specularName);
            mtlFile << "map_Ks " + specularName + "\n";
        }
        if (plane.ambientOcclusionTexture != NULL) {
            plane.ambientOcclusionTexture->save("obj/" + ambientOcclusionName);
            mtlFile << "map_Ka " + ambientOcclusionName + "\n";
        }

    } else {
        mtlFile << "Ka " +
                   to_string(plane.diffuseColor.r / 255.0) + " " +
                   to_string(plane.diffuseColor.g / 255.0) + " " +
                   to_string(plane.diffuseColor.b / 255.0) + " \n";
        mtlFile << "Kd " +
                   to_string(plane.diffuseColor.r / 255.0) + " " +
                   to_string(plane.diffuseColor.g / 255.0) + " " +
                   to_string(plane.diffuseColor.b / 255.0) + " \n";
        mtlFile << "Ks " +
                   to_string(plane.specularColor.r / 255.0) + " " +
                   to_string(plane.specularColor.g / 255.0) + " " +
                   to_string(plane.specularColor.b / 255.0) + " \n";
    }
    mtlFile << "d 1.0\n";          // Transparency (1.0 = opaque)
    mtlFile << "illum 1\n";         // Illumination model
    mtlFile << "\n";


    // Get edges
    vector<glm::vec3> vertices = plane.getEdges();

    // Use material
    objFile << "usemtl PlaneMaterial" + uniqueAppendString + "\n";
    // Write vertices to file
    int i = 0;
    for (auto& vertex : vertices) {
        objFile << "v " << vertex.x << " " << vertex.y << " " << vertex.z << endl;
        switch (i) {
            case 0:
                objFile << "vt " << to_string(0) << " " << to_string(0) << endl;
                break;
            case 1:
                objFile << "vt " << to_string(1) << " " << to_string(0) << endl;
                break;
            case 2:
                objFile << "vt " << to_string(1) << " " << to_string(1) << endl;
                break;
            case 3:
                objFile << "vt " << to_string(0) << " " << to_string(1) << endl;
                break;
        }
        i++;
    }

    // Write faces to file
    if (plane.normal == glm::vec3(0, 1, 0)) {
        objFile << "f " << to_string(offset + 4) << "/" + to_string(offset + 4) << " "
                        << to_string(offset + 3) << "/" + to_string(offset + 3) << " "
                        << to_string(offset + 2) << "/" + to_string(offset + 2) << " "
                        << to_string(offset + 1) << "/" + to_string(offset + 1) << endl;

    } else {
        objFile << "f " << to_string(offset + 1) << "/" + to_string(offset + 1) << " "
                        << to_string(offset + 2) << "/" + to_string(offset + 2) << " "
                        << to_string(offset + 3) << "/" + to_string(offset + 3) << " "
                        << to_string(offset + 4) << "/" + to_string(offset + 4) << endl;

    }

    objFile << "\n";
}