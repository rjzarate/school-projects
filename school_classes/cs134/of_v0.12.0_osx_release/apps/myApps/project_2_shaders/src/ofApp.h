#pragma once

#include "ofMain.h"
#include "ofxGui.h"
#include <glm/gtx/intersect.hpp>

// Light class
class Light {
    public:
    Light(glm::vec3 p, float lightIntensity, ofColor color = ofColor::white) { 
        this->p = p; 
        this->lightIntensity = lightIntensity;
        this->color = color;
    }
    void draw() {
        ofSetColor(255, 255, 0);
        ofDrawSphere(p, 0.2f);
    }

    glm::vec3 p;
    float lightIntensity;
    ofColor color;
};

//  General Purpose Ray class
//
class Ray {
public:
    Ray(glm::vec3 p, glm::vec3 d) { this->p = p; this->d = d; }
    void draw(float t) { ofDrawLine(p, p + t * d); }

    glm::vec3 evalPoint(float t) {
        return (p + t * d);
    }

    glm::vec3 p, d;
};

//  Base class for any renderable object in the scene
//
class SceneObject {
public:
    virtual void draw() = 0;    // pure virtual funcs - must be overloaded
    virtual bool intersect(const Ray &ray, glm::vec3 &point, glm::vec3 &normal) { cout << "SceneObject::intersect" << endl; return false; }
    
    // any data common to all scene objects goes here
    glm::vec3 position = glm::vec3(0, 0, 0);

    // material properties (we will ultimately replace this with a Material class - TBD)
    //
    ofColor diffuseColor = ofColor::grey;    // default colors - can be changed.
    ofColor specularColor = ofColor::lightGray;
};

//  General purpose sphere  (assume parametric)
//
class Sphere: public SceneObject {
public:
    Sphere(glm::vec3 p, float r, ofColor diffuse = ofColor::lightGray) { position = p; radius = r; diffuseColor = diffuse; }
    Sphere() {}
    bool intersect(const Ray &ray, glm::vec3 &point, glm::vec3 &normal) {
        return (glm::intersectRaySphere(ray.p, ray.d, position, radius, point, normal));
    }
    void draw()  {
        ofDrawSphere(position, radius);
    }

    float radius = 1.0;
};

//  Mesh class (will complete later- this will be a refinement of Mesh from Project 1)
//
class Mesh : public SceneObject {
    public:
    Mesh(glm::vec3 p, string fileName, ofColor diffuse = ofColor::lightGray) {
    // Set vars
    this->position = p;
    this->diffuseColor = diffuse;
    
    // Load obj
    ofBuffer objBuffer = ofBufferFromFile(fileName);
    
    // Grab each line
    for (auto line : objBuffer.getLines()) {
        
        
        // Split line via whitespaces
        stringstream ss(line);
        string word;
        int i = 0;
        bool isVertex = false;
        float f1, f2, f3;
        while (ss >> word) {
            bool isVertexOrFace = true;
            switch (i) {
            // First line, check if vertex or face
            case 0:
                    if (word.size() > 1) {
                        isVertexOrFace = false;
                        break;
                    }
                    if (word[0] == 'v') {
                        isVertex = true;
                        break;
                    }
                    if (word[0] == 'f') {
                        isVertex = false;
                        break;
                    }
                    isVertexOrFace = false;
                    break;
            case 1:
                    f1 = stof(word);
                    break;
            case 2:
                    f2 = stof(word);
                    break;
            case 3:
                    f3 = stof(word);
                    break;
            }
            if (!isVertexOrFace) {
                break;
            }
            i++;
        }
        
        // Put in vector array
        if (isVertex) {
            vertices.push_back(glm::vec3(f1, f2, f3));
        }
        if (!isVertex) {
            faces.push_back(glm::vec3(f1, f2, f3));
        }
    }
    
    cout << "File Byte Size: " << objBuffer.size() << endl;
    cout << "Vertices Size : " << vertices.size() << endl;
    cout << "Faces Size    : " << faces.size() << endl;
    cout << "initialize mesh" << endl;
}
    
    bool intersect(const Ray &ray, glm::vec3 &point, glm::vec3 &normal) {
        
        // Vars for intersection
        float t = std::numeric_limits<float>::max();
        float t0;
        glm::vec2 baryPosition;
        bool hitTriangle = false;

        // Go through each face
        for (auto face : faces) {
            // Get intersection
            bool hit = glm::intersectRayTriangle(
            ray.p, ray.d, 
            vertices[face.x - 1], vertices[face.y - 1], vertices[face.z - 1],
            baryPosition, t0
            );

            // Has hit, adjust t value if smaller and get new normal
            if (hit) {
                hitTriangle = true;
                if (t0 < t) {
                    t = t0;

                    // Get normal
                    // glm::vec3 centroid = (vertices[face.x - 1] + vertices[face.y - 1] + vertices[face.z - 1]) / 3;
                    glm::vec3 AB = vertices[face.y - 1] - vertices[face.x - 1];
                    glm::vec3 AC = vertices[face.z - 1] - vertices[face.x - 1];
                    
                    normal = glm::cross(AB, AC);
                }
            }
        }
        
        // Triangle was hit, calculate point
        if (hitTriangle) {
            point = ray.p + (t * ray.d); // r(t) = p + td

            

        }

        return hitTriangle;
    
    }
    void draw() {
            
    for (auto face : faces) {
        // Draw each face
        // if (fill) ofFill();
        // if (!fill) ofNoFill();
        
        ofSetColor(diffuseColor);
        ofDrawTriangle(vertices[face.x - 1], vertices[face.y - 1], vertices[face.z - 1]);
        
        
        // if (showNormal) {
        //     // Get centroid and normal
        //     glm::vec3 centroid = (vertices[face.x - 1] + vertices[face.y - 1] + vertices[face.z - 1]) / 3;
        //     glm::vec3 AB = vertices[face.y - 1] - vertices[face.x - 1];
        //     glm::vec3 AC = vertices[face.z - 1] - vertices[face.x - 1];
            
        //     glm::vec3 normal = glm::cross(AB, AC);
            
        //     // Draw line (Start from Centroid, extend out with normal)
        //     ofSetColor(ofColor::red);
        //     ofDrawLine(centroid, centroid + (glm::normalize(normal) * normalLength));
        // }
    }
    }

    vector<glm::vec3> vertices;
    vector<glm::vec3> faces;
    // bool showNormal;
    // bool fill;
    // float normalLength;
};


//  General purpose plane
//
class Plane: public SceneObject {
public:
    Plane(glm::vec3 p, glm::vec3 n, ofColor diffuse = ofColor::darkOliveGreen, float w = 20, float h = 20 ) {
        position = p;
        normal = n;
        width = w;
        height = h;
        diffuseColor = diffuse;
        // plane.rotateDeg(90, 1, 0, 0);
        plane.lookAt(n);
    }
    Plane() { }
    glm::vec3 normal = glm::vec3(0, 1, 0);
    bool intersect(const Ray &ray, glm::vec3 & point, glm::vec3 & normal);
    void draw() {
        plane.setPosition(position);
        plane.setWidth(width);
        plane.setHeight(height);
        plane.setResolution(4, 4);
        plane.drawWireframe();
    }
    ofPlanePrimitive plane;
    float width = 20;
    float height = 20;
};

// view plane for render camera
//
class  ViewPlane: public Plane {
public:
    ViewPlane(glm::vec2 p0, glm::vec2 p1) { min = p0; max = p1; }

    ViewPlane() {                         // create reasonable defaults (6x4 aspect)
        min = glm::vec2(-3, -2);
        max = glm::vec2(3, 2);
        position = glm::vec3(0, 0, 5);
        normal = glm::vec3(0, 0, 1);      // viewplane currently limited to Z axis orientation
    }

    void setSize(glm::vec2 min, glm::vec2 max) { this->min = min; this->max = max; }
    float getAspect() { return width() / height(); }

    glm::vec3 toWorld(float u, float v);   //   (u, v) --> (x, y, z) [ world space ]

    void draw() {
        ofDrawRectangle(glm::vec3(min.x, min.y, position.z), width(), height());
    }

    
    float width() {
        return (max.x - min.x);
    }
    float height() {
        return (max.y - min.y);
    }

    // some convenience methods for returning the corners
    //
    glm::vec2 topLeft() { return glm::vec2(min.x, max.y); }
    glm::vec2 topRight() { return max; }
    glm::vec2 bottomLeft() { return min;  }
    glm::vec2 bottomRight() { return glm::vec2(max.x, min.y); }

    //  To define an infinite plane, we just need a point and normal.
    //  The ViewPlane is a finite plane so we need to define the boundaries.
    //  We will define this in terms of min, max  in 2D.
    //  (in local 2D space of the plane)
    //  ultimately, will want to locate the ViewPlane with RenderCam anywhere
    //  in the scene, so it is easier to define the View rectangle in a local'
    //  coordinate system.
    //
    glm::vec2 min, max;
};


//  render camera  - currently must be z axis aligned (we will improve this in project 4)
//
class RenderCam: public SceneObject {
public:
    RenderCam() {
        position = glm::vec3(0, 0, 10);
        aim = glm::vec3(0, 0, -1);
    }
    Ray getRay(float u, float v);
    void draw() { ofDrawBox(position, 1.0); };
    void drawFrustum();

    glm::vec3 aim;
    ViewPlane view;          // The camera viewplane, this is the view that we will render
};


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
    
        void rayTrace();
        void drawGrid();
        // float calculateShade(Light &light, glm::vec3 &intersectionPoint, glm::vec3 &normal);
        bool isIlluminated(Light &light, glm::vec3 &p);
        // bool isIlluminated(SceneObject &sceneObject, Light &light, glm::vec3 &intersectionPoint);
        ofColor lambert(const glm::vec3 &p, const glm::vec3 &norm, const ofColor diffuse);
        ofColor phong(const glm::vec3 &p, const glm::vec3 &norm, const ofColor diffuse, const ofColor specular, float power);
        SceneObject * getClosestSceneObject(Ray &ray);
    
    
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

    vector<SceneObject *> scene;

    int imageWidth = 600;
    int imageHeight = 400;
    bool showImage = false;
    
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
    Light light = Light(glm::vec3(3, 5, 7), 100.0f);
    Light light1 = Light(glm::vec3(-4, 1, 7), 10.0f);
    vector<Light *> lights;
    float diffuseCoefficient = 1.0f;
    float specularCoefficient = 1.0f;
    float phongPower = 100.0f;
    
    // Gui
    ofxPanel gui;
    ofxToggle enableLambertGUI;
    ofxToggle enablePhongGUI;
    ofxToggle enableCastingShadowsGUI;
    
    ofxFloatSlider ambientLightCoefficientGUI;
    ofxFloatSlider lightPositionZGUI;
    ofxFloatSlider lightIntensityGUI;
    ofxFloatSlider light1PositionZGUI;
    ofxFloatSlider light1IntensityGUI;
    
    ofxFloatSlider diffuseCoefficientGUI;
    ofxFloatSlider specularCoefficientGUI;
    ofxFloatSlider phongPowerGUI;

    ofxToggle showMeshesGUI;
    
    bool showGUI = true;
    
};
