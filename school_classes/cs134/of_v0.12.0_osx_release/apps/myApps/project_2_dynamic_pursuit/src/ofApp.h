#pragma once

#include "ofMain.h"
#include "ofxGui.h"
#include <vector>
#include <random>

// Scene Object folder
#include "scene_objects/main.h"


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
    void windowResized(int w, int h);
    void dragEvent(ofDragInfo dragInfo);
    void gotMessage(ofMessage msg);
    

    // Emitter and player
    vector<Emitter *> emitters;
    Player player;
    AgentEmitter *emitter = NULL;
    RayEmitter *rayEmitter = NULL;
    ParticleEmitter *particleEmitter = NULL;
    int nEnergy = 3;

    ofImage defaultImage;
    ofImage playerImage;
    ofImage backgroundImage;
    ofVec3f lastMousePosition;
    bool imageLoaded;

    // Some basic UI
    //
    bool bHide;
    ofxFloatSlider rate;
    ofxFloatSlider life;
    ofxFloatSlider speed;
    ofxVec3Slider velocity;
    ofxLabel screenSize;
    ofxFloatSlider scale;
    ofxFloatSlider rotationSpeed;
    ofxIntSlider nAgents;

    ofxFloatSlider playerSpeed;
    ofxFloatSlider playerSize;
    ofxFloatSlider playerRotationSpeed;
    ofxIntSlider playerEnergy;
    ofxToggle showImages;

    ofxFloatSlider thrustGUI;
    ofxPanel gui;


    // Time
    bool firstLoaded = true;
    float startedTime;
    float endedTime;
    
    // Keys
    bool isDownArrowKeyPressed;
    bool isUpArrowKeyPressed;
    bool isLeftArrowKeyPressed;
    bool isRightArrowKeyPressed;
};
