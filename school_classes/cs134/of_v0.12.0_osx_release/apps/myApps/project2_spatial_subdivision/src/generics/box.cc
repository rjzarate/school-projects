#include "vector3.h"
#include "ray.h"
#include "box.h"
#include <algorithm>
  
/*
 * Ray-box intersection using IEEE numerical properties to ensure that the
 * test is both robust and efficient, as described in:
 *
 *      Amy Williams, Steve Barrus, R. Keith Morley, and Peter Shirley
 *      "An Efficient and Robust Ray-Box Intersection Algorithm"
 *      Journal of graphics tools, 10(1):49-54, 2005
 *
 */

Box::Box() { }
Box::Box(const Vector3 &min, const Vector3 &max) {
  //     assert(min < max);
  parameters[0] = min;
  parameters[1] = max;
}


bool Box::intersect(const Ray &r, float t0, float t1) const {
  float tmin, tmax, tymin, tymax, tzmin, tzmax;

  tmin = (parameters[r.sign[0]].x() - r.origin.x()) * r.inv_direction.x();
  tmax = (parameters[1-r.sign[0]].x() - r.origin.x()) * r.inv_direction.x();
  tymin = (parameters[r.sign[1]].y() - r.origin.y()) * r.inv_direction.y();
  tymax = (parameters[1-r.sign[1]].y() - r.origin.y()) * r.inv_direction.y();
  if ( (tmin > tymax) || (tymin > tmax) ) 
    return false;
  if (tymin > tmin)
    tmin = tymin;
  if (tymax < tmax)
    tmax = tymax;
  tzmin = (parameters[r.sign[2]].z() - r.origin.z()) * r.inv_direction.z();
  tzmax = (parameters[1-r.sign[2]].z() - r.origin.z()) * r.inv_direction.z();
  if ( (tmin > tzmax) || (tzmin > tmax) ) 
    return false;
  if (tzmin > tmin)
    tmin = tzmin;
  if (tzmax < tmax)
    tmax = tzmax;
  return ( (tmin < t1) && (tmax > t0) );
}


Vector3 Box::min() const { return parameters[0]; }
Vector3 Box::max() const { return parameters[1]; }

const bool Box::inside(const Vector3 &p) {
  return ((p.x() >= parameters[0].x() && p.x() <= parameters[1].x()) &&
        (p.y() >= parameters[0].y() && p.y() <= parameters[1].y()) &&
        (p.z() >= parameters[0].z() && p.z() <= parameters[1].z()));
}

const bool Box::inside(Vector3 *points, int size) {
  bool allInside = true;
  for (int i = 0; i < size; i++) {
    if (!inside(points[i])) allInside = false;
    break;
  }
  return allInside;
}

const bool Box::intersects(Vector3 *points, int size) {
  // Check if any vertex is inside the box
  for (int i = 0; i < size; i++) {
      if (inside(points[i])) { // contains() checks if a point is inside the box
          return true;
      }
  }

  /* CHATGPT CODE TO CHECK LINE SEGMENT INTERSECTION */
  // Check if any edge intersects the box
  for (int i = 0; i < size; i++) {
      int next = (i + 1) % size; // Next vertex in the triangle
      if (intersectsEdge(points[i], points[next])) { // Line-box intersection
          return true;
      }
  }

  // No intersection found
  return false; 
}

bool Box::overlap(const Box &box) {
  // Easy of use variables
  float xMin0 = parameters[0].x();
  float xMax0 = parameters[1].x();
  float yMin0 = parameters[0].y();
  float yMax0 = parameters[1].y();
  float zMin0 = parameters[0].z();
  float zMax0 = parameters[1].z();

  float xMin1 = box.parameters[0].x();
  float xMax1 = box.parameters[1].x();
  float yMin1 = box.parameters[0].y();
  float yMax1 = box.parameters[1].y();
  float zMin1 = box.parameters[0].z();
  float zMax1 = box.parameters[1].z();


  // Check xyz bounds
  bool xCheck = (xMax0 >= xMin1) && (xMax1 >= xMin0);
  bool yCheck = (yMax0 >= yMin1) && (yMax1 >= yMin0);
  bool zCheck = (zMax0 >= zMin1) && (zMax1 >= zMin0);

  return xCheck && yCheck && zCheck;
}


Vector3 Box::center() const {
  return ((max() - min()) / 2 + min());
}

/* CHATGPT CODE TO CHECK LINE SEGMENT INTERSECTION */
const bool Box::intersectsEdge(const Vector3 &start, const Vector3 &end) {
  // Box boundaries (min and max corners)
  float xMin = parameters[0].x();
  float xMax = parameters[1].x();
  float yMin = parameters[0].y();
  float yMax = parameters[1].y();
  float zMin = parameters[0].z();
  float zMax = parameters[1].z();

  // Direction vector of the segment
  Vector3 dir = end - start;

  // Start and end of the segment in terms of t (0 <= t <= 1)
  float tMin = 0.0f, tMax = 1.0f;

  // Check intersection with each slab
  if (!intersectSlab(start.x(), dir.x(), xMin, xMax, tMin, tMax)) return false;
  if (!intersectSlab(start.y(), dir.y(), yMin, yMax, tMin, tMax)) return false;
  if (!intersectSlab(start.z(), dir.z(), zMin, zMax, tMin, tMax)) return false;

  // If we pass all tests, the segment intersects the box
  return true;
}

/* CHATGPT CODE TO CHECK LINE SEGMENT INTERSECTION */
// Helper function to check slab intersection
const bool Box::intersectSlab(float start, float dir, float min, float max, 
                      float &tMin, float &tMax) {
  if (fabs(dir) < 1e-6) { // Line is parallel to the slab
      if (start < min || start > max) return false; // Outside the slab
      return true; // Inside the slab
  }

  // Compute intersection points with the slab planes
  float t1 = (min - start) / dir;
  float t2 = (max - start) / dir;

  // Ensure t1 is the nearer intersection
  if (t1 > t2) std::swap(t1, t2);

  // Update tMin and tMax
  tMin = std::max(tMin, t1);
  tMax = std::min(tMax, t2);

  // If tMin > tMax, the segment does not intersect the box
  return tMin <= tMax;
}