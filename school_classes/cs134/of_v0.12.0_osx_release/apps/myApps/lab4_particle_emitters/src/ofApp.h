#pragma once

#include "ofMain.h"
#include "ofxGui.h"
#include "Particle.h"
#include "ParticleEmitter.h"



class ofApp : public ofBaseApp{

	public:
		void setup();
        void exit();
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

		ofEasyCam    cam;

		// some simple sliders to play with parameters
		//
		bool bHide;
		ofxFloatSlider gravity;
		ofxFloatSlider damping;
		ofxFloatSlider radius;
		ofxVec3Slider velocity;
		ofxFloatSlider lifespan;
		ofxFloatSlider rate;
		ofxPanel gui;

		// Emitters
		ParticleEmitter *particleEmitter = NULL;

		// Gravity
		GravityForce* gravityForce = NULL;

		// Turbulence
		ofxVec3Slider turbulenceForceMinimumGUI;
		ofxVec3Slider turbulenceForceMaximumGUI;
		float const maximumTurbulence = 10.0f;
		TurbulenceForce* turbulenceForce = NULL;

		// BONUS: Noise
		ofxVec3Slider noiseForceMinimumGUI;
		ofxVec3Slider noiseForceMaximumGUI;
		ofxFloatSlider noiseForceOffsetGUI;
		float const maximumNoise = 10.0f;
		NoiseForce* noiseForce = NULL;

		// Extra
		ofxToggle enableTurbulenceForceGUI;
		ofxToggle enableGravityForceGUI;
		ofxToggle enableNoiseForceGUI;
};
