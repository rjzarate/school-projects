#ifndef _RAY_H_
#define _RAY_H_

#include "generics/vector3.h"

/*
 * Ray class, for use with the optimized ray-box intersection test
 * described in:
 *
 *      Amy Williams, Steve Barrus, R. Keith Morley, and Peter Shirley
 *      "An Efficient and Robust Ray-Box Intersection Algorithm"
 *      Journal of graphics tools, 10(1):49-54, 2005
 * 
 */

class Ray {
  public:
    Ray();
    Ray(Vector3 o, Vector3 d);
    Ray(const Ray &r);

    Vector3 origin;
    Vector3 direction;
    Vector3 inv_direction;
    int sign[3];
};

#endif // _RAY_H_
