#pragma once

#include "ofMain.h"
#include "ofxGui.h"
#include <glm/gtx/intersect.hpp>
#include <glm/gtx/euler_angles.hpp>

// Rendering folder
#include "rendering/main.h"


class ofApp : public ofBaseApp{

	public:
    void setup();
    void update();
    void draw();

    void keyPressed(int key);
    void keyReleased(int key);
    void mouseMoved(int x, int y );
    void mouseDragged(int x, int y, int button);
    void mousePressed(int x, int y, int button);
    void mouseReleased(int x, int y, int button);
    void mouseEntered(int x, int y);
    void mouseExited(int x, int y);
    void mouseScrolled(int x, int y, float scrollX, float scrollY);
    void windowResized(int w, int h);
    void dragEvent(ofDragInfo dragInfo);
    void gotMessage(ofMessage msg);

    void rayTrace();
    void drawGrid();
    // float calculateShade(Light &light, glm::vec3 &intersectionPoint, glm::vec3 &normal);
    bool isIlluminated(Light &light, glm::vec3 &p);
    // bool isIlluminated(SceneObject &sceneObject, Light &light, glm::vec3 &intersectionPoint);
    ofColor lambert(const glm::vec3 &p, const glm::vec3 &norm, const ofColor diffuse);
    ofColor phong(const glm::vec3 &p, const glm::vec3 &norm, const ofColor diffuse, const ofColor specular, float power);
    SceneObject *getClosestSceneObject(Ray &ray, glm::vec3 &point, glm::vec3 &normal, bool addLights = false, bool isSelectable = false);

    // Generating files
    void createObj(string directory = "obj/new_model.obj");
    void createObj_Sphere(ofFile &objFile, ofFile &mtlFile, const Sphere &sphere, string uniqueAppendString = "", int offset = 0);
    void createObj_Plane(ofFile &objFile, ofFile &mtlFile, const Plane &plane, string uniqueAppendString = "", int offset = 0);

    // Dragging
    bool mouseToDragPlane(int x, int y, glm::vec3 & point);
    bool objSelected();
    void clearSelectionList();
    bool bDrag = false;
    bool bAltKeyDown = false;
    bool bSftKeyDown = false;
    bool bCtrlKeyDown = false;
    glm::vec3 lastPoint;
    vector<SceneObject*> selected;
    
    bool bHide = true;
    bool bShowImage = false;

    ofEasyCam  mainCam;
    ofCamera topCam;
    ofCamera sideCam;
    ofCamera previewCam;
    ofCamera* theCam;    // set to current camera either mainCam or sideCam

    // set up one render camera to render image throughn
    //
    RenderCam renderCam;
    ofImage image;
    int imageWidth = 600;
    int imageHeight = 400;
    bool showImage = false;

    vector<SceneObject *> scene;

    // Textures
    ofImage wallDiffuseTexture;
    ofImage wallSpecularTexture;
    ofImage wallNormalTexture;
    ofImage wallDisplacementTexture;

    ofImage floorDiffuseTexture;
    ofImage floorSpecularTexture;
    ofImage floorNormalTexture;
    ofImage floorDisplacementTexture;

    ofImage sphereDiffuseTexture;
    ofImage sphereSpecularTexture;
    ofImage sphereNormalTexture;
    ofImage sphereDisplacementTexture;
    
    // Objects
    Plane plane = Plane(glm::vec3(0, -1, 0), glm::vec3(0, 1, 0));
    Plane plane1 = Plane(glm::vec3(0, 9, -10), glm::vec3(0, 0, 1), ofColor::green);
    Sphere sphere = Sphere(glm::vec3(2, 0, -3), 1.0f, ofColor::white);
    Sphere sphere1 = Sphere(glm::vec3(-1, 0.5, 1.5), 0.5f, ofColor::red);
    Sphere sphere2 = Sphere(glm::vec3(-2, 0, -2), 1.0f, ofColor::blue);
    Mesh mesh = Mesh(glm::vec3(0, 0, 0), "cube.obj", ofColor::yellow);
    ViewPlane viewPlane = ViewPlane();
    
    // Light and lambert stuff
    ofColor backgroundColor = ofColor::black;
    Light light = Light(glm::vec3(3, 5, 7), 50.0f);
    Light light1 = Light(glm::vec3(-4, 1, 7), 10.0f);
    Spotlight spotlight = Spotlight(glm::vec3(3, 5, -1), 100.0f, ofColor::blue);
    Spotlight spotlight1 = Spotlight(glm::vec3(3, 5, 1), 100.0f, ofColor::white);
    vector<Light *> lights;
    float diffuseCoefficient = 1.0f;
    float specularCoefficient = 1.0f;
    float phongPower = 100.0f;
    
    // Gui
    ofxPanel gui;
    ofxToggle enableTexturesGUI;
    ofxToggle enableLambertGUI;
    ofxToggle enablePhongGUI;
    ofxToggle enableCastingShadowsGUI;
    
    ofxFloatSlider ambientLightCoefficientGUI;
    ofxFloatSlider lightIntensityGUI;
    ofxFloatSlider light1IntensityGUI;
    ofxFloatSlider spotlightIntensityGUI;
    ofxFloatSlider spotlight1IntensityGUI;

    ofxFloatSlider diffuseCoefficientGUI;
    ofxFloatSlider specularCoefficientGUI;
    ofxFloatSlider phongPowerGUI;

    ofxVec2Slider floorTileCountGUI;
    ofxVec2Slider wallTileCountGUI;
    ofxFloatSlider floorDisplacementMultiplierGUI;
    ofxFloatSlider wallDisplacementMultiplierGUI;
    ofxFloatSlider sphereDisplacementMultiplierGUI;
    ofxIntSlider imageWidthGUI;
    ofxIntSlider imageHeightGUI;

    ofxToggle showMeshesGUI;
    
    bool showGUI = true;
    
};
