A **4x4 matrix** that has:
1. Scale
2. Rotation
3. Translation
## Setup
0. Assuming that:
	1. `scale` is a vector 3
	2. `rotation` is a float
	3. `translation` is a vector 3
1. Convert Scale, Rotation, and Translation into 4x4 matrices
	1. `glm::scale(identityMatrix, this.scale)`
	2. `glm::rotate(identityMatrix, this.rotation, rotationAxis)`
	3. `glm::translate(identityMatrix, this.translation)`
	4. `identityMatrix = glm::mat4(1.0)`
	5. Usually, `rotationAxis = glm::vec3(0, 0, 1)`, since you would want to rotate on the z-axis
2. Multiply 4x4 scale, rotation, and translation matrices
	1. **Order matters!** *(right to left)*
		1. Should do `translationMatrix * rotationMatrix * scaleMatrix`
		2. **Translation should be multiplied last; before rotation**
## Using Transformation Matrix
Can be used to **transform a point**
### Drawing with Transformation Matrix
0. In the `void draw() { ... }` function
1. Push the matrix
	1. `ofPushMatrix()`
2. Add transformation matrix
	1. `ofPushMatrix(transformationMatrix)`
3. Draw the object **in their Object Space**
	1. Object Space should be just their **unchanged vectors**
		1. Don't use `position`
		2. For `ofImage`s, you can use `glm::vec3(width / 2.0, height / 2.0, 0)` for drawing to center the image
	2. Will now use the `transformationMatrix`
4. Pop the matrix
	1. `ofPopMatrix()`
	2. Else, it would use the given `transformationMatrix` for your next drawn objects
### Multiplying With Vectors
Vector should be a vector 4
1. Convert through `glm::vec4(vector3, 0)`

Transformation matrix should be on the **left** of the vector (4x4 * 4x1 = 4x1)
1. `transformationMatrix * vector4`
### Inverse Transformation Matrix
Use inverse transformation matrix to get the **object space** of a moved vector
1. `glm::inverse(transformationMatrix)`
