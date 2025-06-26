#pragma once

#include "rendering/SceneObject.h"
#include "rendering/camera/ViewPlane.h"

//  render camera  - currently must be z axis aligned (we will improve this in project 4)
//
class RenderCam: public SceneObject {
public:
    RenderCam();
    Ray getRay(float u, float v);
    void draw();
    void drawFrustum();

    glm::vec3 aim;
    ViewPlane view;          // The camera viewplane, this is the view that we will render
};
