Compute light (vector) reflected toward the camera
- Can calculate light vector by getting the points of:
	1. Where the light is
	2. Where the specific object pixel is

Brighter when the light is directly overhead the mesh triangle (normal)
- Use Lambert's cosine law 🤷‍♂

### Light Falloff
When light is further away, it's less powerful
- `intensity / distance ^ 2`