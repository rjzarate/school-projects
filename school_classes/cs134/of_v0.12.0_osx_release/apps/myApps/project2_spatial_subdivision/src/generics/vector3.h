#ifndef _VECTOR3_H_
#define _VECTOR3_H_

#include <math.h>

class Vector3 {
  public:
    Vector3();
    Vector3(float x, float y, float z);
    Vector3(const Vector3 &v);

    float x() const;
    float y() const;
    float z() const;

    float operator[](int i) const;
    
    float length() const;
    void normalize();

    /////////////////////////////////////////////////////////
    // Overloaded operators
    /////////////////////////////////////////////////////////
  
    Vector3 operator+(const Vector3 &op2) const;
    Vector3 operator-(const Vector3 &op2) const;
    Vector3 operator-() const;
    Vector3 operator*(float s) const;
    void operator*=(float s);
    Vector3 operator/(float s) const;
    float operator*(const Vector3 &op2) const;
    Vector3 operator^(const Vector3 &op2) const;
    bool operator==(const Vector3 &op2) const;
    bool operator!=(const Vector3 &op2) const;
    bool operator<(const Vector3 &op2) const;
    bool operator<=(const Vector3 &op2) const;
  
  private:
    float d[3];
};

#endif // _VECTOR3_H_
