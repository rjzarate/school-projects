## Image/Sprite Sharing (Instancing)
When creating multiple objects that uses the same image/sprite, you should just have **one instance** rather than always loading (I/O) the file every time you create an object
- Maybe do this with HashMap/Dictionary and load the image at the beginning?