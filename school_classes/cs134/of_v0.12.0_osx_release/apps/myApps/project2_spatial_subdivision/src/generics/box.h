#ifndef _BOX_H_
#define _BOX_H_

#include <assert.h>
#include "generics/vector3.h"
#include "generics/ray.h"

/*
 * Axis-aligned bounding box class, for use with the optimized ray-box
 * intersection test described in:
 *
 *      Amy Williams, Steve Barrus, R. Keith Morley, and Peter Shirley
 *      "An Efficient and Robust Ray-Box Intersection Algorithm"
 *      Journal of graphics tools, 10(1):49-54, 2005
 *
 */

class Box {
  public:
    Box();
    Box(const Vector3 &min, const Vector3 &max);
    // (t0, t1) is the interval for valid hits
    bool intersect(const Ray &, float t0, float t1) const;

    // corners
    Vector3 parameters[2];

	Vector3 min() const;
	Vector3 max() const;
	const bool inside(const Vector3 &p);
	const bool inside(Vector3 *points, int size);
	const bool intersects(Vector3 *points, int size);
	const bool intersectsEdge(const Vector3 &start, const Vector3 &end);
	const bool intersectSlab(float start, float dir, float min, float max, float &tMin, float &tMax);

	// implement for Homework Project
	//
	bool overlap(const Box &box);

	Vector3 center() const;
};

#endif // _BOX_H_
