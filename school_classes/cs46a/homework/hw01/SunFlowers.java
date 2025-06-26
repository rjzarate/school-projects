
/**
 * Write a description of class SunFlowers here.
 *
 * @author Froilan Zarate
 * @version 2022-08-28
 */
public class SunFlowers
{
    public static void main(String[] args)
    {
        Picture pic = new Picture("sunflowers.jpg");

        pic.draw();

        System.out.println("X-coordinate: " + pic.getX());
        System.out.println("Y-coordinate: " + pic.getY());
        System.out.println("Width : " + pic.getWidth());
        System.out.println("Height: " + pic.getHeight());
        
        pic.grow(-400, -500);
        
        System.out.println("X-coordinate: " + pic.getX());
        System.out.println("Y-coordinate: " + pic.getY());
        System.out.println("Width : " + pic.getWidth());
        System.out.println("Height: " + pic.getHeight());
        
        pic.translate(-400, -500);
        
        System.out.println("X-coordinate: " + pic.getX());
        System.out.println("Y-coordinate: " + pic.getY());
        System.out.println("Width : " + pic.getWidth());
        System.out.println("Height: " + pic.getHeight());
    }
}
