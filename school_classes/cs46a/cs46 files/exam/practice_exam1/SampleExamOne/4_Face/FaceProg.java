/**
 * A Java program using class Face to draws faces 
 * at different location.
 *
 * @author  Qi Yang
 * @version 2022-09-24
 */
public class FaceProg
{
    public static void main(String[] args)
    {
        Face face = new Face(0, 0);
        face.draw();
        face = new Face(100, 50);
        face.draw();
        face = new Face(200, 200);
        face.draw();
    }
}
