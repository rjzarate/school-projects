#include "rendering/shapes/Mesh.h"

Mesh::Mesh(glm::vec3 p, string fileName, ofColor diffuse) {
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
    
bool Mesh::intersect(const Ray &ray, glm::vec3 &point, glm::vec3 &normal) {
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

void Mesh::draw() {
            
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