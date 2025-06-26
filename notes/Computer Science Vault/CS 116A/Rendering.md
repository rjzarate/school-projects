Two types:
1. Object Order / Rasterization
2. Image Order / Ray Tracing
## Ray Tracing
**Viewing ray** is casted until it hits a **visible point**, then that ray will be used for a certain pixel
- Each pixel will have 1 viewing ray
- Illumination (light) will also need to be calculated

Will have a **viewing window**, which is what is displayed on the screen
### Pseudo code
for each pixel:
1. compute a viewing ray
2. intersect ray with scene
3. compute illumination at visible point
4. put result into image