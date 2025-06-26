#include "rendering/SceneObject.h"

bool SceneObject::intersect(const Ray& ray, glm::vec3& point, glm::vec3& normal) {
    return false;
}

glm::vec3 SceneObject::getNormal(const glm::vec3& p) {
    return glm::vec3(1, 0, 0);
}

glm::mat4 SceneObject::getMatrix() {
    glm::mat4 T = glm::translate(glm::mat4(1.0), glm::vec3(position));
    glm::mat4 R = glm::eulerAngleYXZ(glm::radians(rotation.y), glm::radians(rotation.x), glm::radians(rotation.z));   // yaw, pitch, roll 
    glm::mat4 S = glm::scale(glm::mat4(1.0), scale);      // added this scale if you want to change size of object
    return T * R * S;
}

void SceneObject::setPosition(glm::vec3 p) {
    position = p;
    transform = getMatrix();
}

glm::vec3 SceneObject::getPosition() {
    return position;
}

void SceneObject::resetTransform() {
    transform = getMatrix();
}

glm::vec2 SceneObject::getTileUV(const glm::vec3 & p) {
    cout << "GetTileUV unimplemented" << endl;
    return glm::vec2(0, 0);
}

ofColor SceneObject::getDiffuseTexturePixel(float u, float v) {
    // Edge case: has no texture, return material diffuse
    if (diffuseTexture == NULL) {
        return diffuseColor;
    }
    int x = diffuseTexture->getWidth() * ofWrap(u, 0.0, 1.0);
    int y = diffuseTexture->getHeight() * ofWrap(v, 0.0, 1.0);
    return diffuseTexture->getColor(x, y);
}

ofColor SceneObject::getSpecularTexturePixel(float u, float v)
{
    // Edge case: has no texture, return material specular
    if (specularTexture == NULL) {
        return specularColor;
    }
    int x = specularTexture->getWidth() * ofWrap(u, 0.0, 1.0);
    int y = specularTexture->getHeight() * ofWrap(v, 0.0, 1.0);
    return specularTexture->getColor(x, y);
}

ofColor SceneObject::getNormalTexturePixel(float u, float v)
{
    // Edge case: has no texture, return normal
    if (normalTexture == NULL) {
        return normal;
    }
    int x = normalTexture->getWidth() * ofWrap(u, 0.0, 1.0);
    int y = normalTexture->getHeight() * ofWrap(v, 0.0, 1.0);
    return normalTexture->getColor(x, y);
}

ofColor SceneObject::getDisplacementTexturePixel(float u, float v)
{
    // Edge case: has no texture, return 0 (black)
    if (displacementTexture == NULL) {
        return ofColor(0, 0, 0);
    }
    int x = displacementTexture->getWidth() * ofWrap(u, 0.0, 1.0);
    int y = displacementTexture->getHeight() * ofWrap(v, 0.0, 1.0);
    return displacementTexture->getColor(x, y);
}

ofColor SceneObject::getAmbientOcclusionTexturePixel(float u, float v)
{
    // Edge case: has no texture, return 0 (black)
    if (ambientOcclusionTexture == NULL) {
        return ofColor(0, 0, 0);
    }
    int x = ambientOcclusionTexture->getWidth() * ofWrap(u, 0.0, 1.0);
    int y = ambientOcclusionTexture->getHeight() * ofWrap(v, 0.0, 1.0);
    return ambientOcclusionTexture->getColor(x, y);
}

glm::vec3 SceneObject::getTangent(const glm::vec3 & p) {
    cout << "unimplemented getTangent" << endl;
    return glm::vec3(0, 0, 0);
}