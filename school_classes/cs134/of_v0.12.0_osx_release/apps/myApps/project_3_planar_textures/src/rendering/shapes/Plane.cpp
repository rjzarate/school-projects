#include "rendering/shapes/Plane.h"

Plane::Plane(glm::vec3 p, glm::vec3 n, ofColor diffuse, float w, float h) {
    this->position = p;
    this->normal = n;
    this->width = w;
    this->height = h;
    this->diffuseColor = diffuse;
    // plane.rotateDeg(90, 1, 0, 0);
    this->plane.lookAt(n);

    // Dragging
    isSelectable = false;
}
Plane::Plane() { 
    // Dragging
    isSelectable = false;
}

// Intersect Ray with Plane  (wrapper on glm::intersect*)
//
bool Plane::intersect(const Ray& ray, glm::vec3& point, glm::vec3& normalAtIntersect) {
	float dist;
	bool insidePlane = false;
	bool hit = glm::intersectRayPlane(ray.p, ray.d, position, this->normal, dist);
	if (hit) {
		Ray r = ray;
		point = r.evalPoint(dist);
		normalAtIntersect = this->normal;
		glm::vec2 xrange = glm::vec2(position.x - width / 2, position.x + width / 2);
		glm::vec2 yrange = glm::vec2(position.y - width / 2, position.y + width / 2);
		glm::vec2 zrange = glm::vec2(position.z - height / 2, position.z + height / 2);

		// horizontal 
		//
		if (normal == glm::vec3(0, 1, 0) || normal == glm::vec3(0, -1, 0)) {
			if (point.x < xrange[1] && point.x > xrange[0] && point.z < zrange[1] && point.z > zrange[0]) {
				insidePlane = true;
			}
		}
		// front or back
		//
		else if (normal == glm::vec3(0, 0, 1) || normal == glm::vec3(0, 0, -1)) {
			if (point.x < xrange[1] && point.x > xrange[0] && point.y < yrange[1] && point.y > yrange[0]) {
				insidePlane = true;
			}
		}
		// left or right
		//
		else if (normal == glm::vec3(1, 0, 0) || normal == glm::vec3(-1, 0, 0)) {
			if (point.y < yrange[1] && point.y > yrange[0] && point.z < zrange[1] && point.z > zrange[0]) {
				insidePlane = true;
			}
		}
	}

	// ofImage background;
	// float w = background.getWidth();
	// float h = background.getHeight();
	return insidePlane;
}

void Plane::draw() {
    plane.setPosition(position);
    plane.setWidth(width);
    plane.setHeight(height);
    plane.setResolution(4, 4);
    plane.drawWireframe();
    // plane.draw();
}

glm::vec2 Plane::getTileUV(const glm::vec3 & point) {
    // Get ranges of involving width, height, and pos
    glm::vec2 xrange = glm::vec2(position.x - width / 2, position.x + width / 2);
    glm::vec2 yrange = glm::vec2(position.y - width / 2, position.y + width / 2);
    glm::vec2 zrange = glm::vec2(position.z - height / 2, position.z + height / 2);

    float u = 0.0;
    float v = 0.0;

    // horizontal
    if (normal == glm::vec3(0, 1, 0) || normal == glm::vec3(0, -1, 0)) {
        // x = width, z = height
        u = (point.x - xrange[0]) / width * tileSize.x;
        v = (point.z - xrange[0]) / height * tileSize.y;
    }
    // front or back
    else if (normal == glm::vec3(0, 0, 1) || normal == glm::vec3(0, 0, -1)) {
        // x = width, y = height
        u = (point.x - xrange[0]) / width * tileSize.x;
        v = (point.y - xrange[0]) / height * tileSize.y;
    }
    // left or right
    else if (normal == glm::vec3(1, 0, 0) || normal == glm::vec3(-1, 0, 0)) {
        // z = width, y = height
        u = (point.z - xrange[0]) / width * tileSize.x;
        v = (point.y - xrange[0]) / height * tileSize.y;
    }

    return glm::vec2(u, v);
}

glm::vec3 Plane::getTangent(const glm::vec3 & point) {
    // Tangent vector will be vertical or horizontal
    // horizontal
    if (normal == glm::vec3(0, 1, 0) || normal == glm::vec3(0, -1, 0)) {
        return glm::vec3(0, 0, -1);
    }
    // front or back
    else if (normal == glm::vec3(0, 0, 1) || normal == glm::vec3(0, 0, -1)) {
        return glm::vec3(0, 1, 0);
    }
    // left or right
    else if (normal == glm::vec3(1, 0, 0) || normal == glm::vec3(-1, 0, 0)) {
        return glm::vec3(0, 1, 0);
    }

    cout << "error, normal: " << normal << " cannot be converted" << endl;
    return glm::vec3(0, 0, 0);


}

vector<glm::vec3> Plane::getEdges() const {
    std::vector<glm::vec3> edges;
    
    // Create the offset vectors along the two axes
    glm::vec3 offset1, offset2;

    if (normal.x != 0) {
        offset1 = glm::vec3(0, 0.5f, 0) * width;
        offset2 = glm::vec3(0, 0, 0.5f) * height;
    }

    if (normal.y != 0) {
        offset1 = glm::vec3(0.5f, 0, 0) * width;
        offset2 = glm::vec3(0, 0, 0.5f) * height;
    }

    if (normal.z != 0) {
        offset1 = glm::vec3(0.5f, 0, 0) * width;
        offset2 = glm::vec3(0, 0.5f, 0) * height;
    }
    
    edges.push_back(position + offset1 + offset2);  // Top-right corner
    edges.push_back(position - offset1 + offset2);  // Top-left corner
    edges.push_back(position - offset1 - offset2);  // Bottom-left corner
    edges.push_back(position + offset1 - offset2);  // Bottom-right corner
    
    return edges;
}