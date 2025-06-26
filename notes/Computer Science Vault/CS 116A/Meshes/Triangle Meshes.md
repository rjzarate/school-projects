## Overview
Also known as **Polygon Geometry**
In essence:
1. Take an object
2. Approximate the object: creates a [[Mesh]]
	1. More triangles (polygons) = closer approximation, but more time and space expensive
	2. Shading can help with making a mesh look "smooth" and closer to the object
## Mesh
A piecewise **planar** **surface** (besides the edges)
- Basically made of a bunch (piecewise) of planes (planar)
Usually to approximate a smooth surface (i.e. sphere)
## Triangles
Mesh is made up of a bunch [[Triangle]]s
## Representation
How to store triangle meshes:
### Separate Triangles
Triangles are stored in a 2D array: `triangles[AMT_OF_TRIANGLES][3]`
- Example:
	- `triangles[0] = triangle_0`
	- `triangle_0` Contains **3 vertices** (points) to make the triangle
Can also be `triangles[AMT_OF_TRIANGLES][3][3]` if `triangle_x` is not a Vector3 class.

**Problems:**
- Redundant vertices; wasting space!!
	- 64 bytes per triangle
- Cracks due to roundoff
- Hard to find nearby neighbors
Estimate Storage Space: 72 Bytes per [[Vertex]]


### Indexed Triangle Set
**Shared vertices**; stores only each vertex **once**
Triangles will point to their 3 vertices

Vertex is a Class that holds 3 floats
Triangle is a Class that holds 3 Vertex's
Mesh will store:
1. Vertex array
2. "Triangle Index" array, where each Triangle only reference the indexes in the Vertex Array

Can also remove the classes, where the mesh will store:
1. 2D array `vertex[AMT_OF_VERTICES][3]`
2. 2D array `triangleIndex[AMT_OF_TRIANGLES][3]`
Estimate Storage Space: 36 Bytes per vertex
#### Geometry & Topology
Separates geometry (Vertices) and topology (triangle connections)
- Changing the geometry will change the structure (vertex positions)
- Changing the topology will change the triangle connections
## Triangle Strips
Common triangle patterns can be made a triangle strip to save data
Also has **Triangle Fans**