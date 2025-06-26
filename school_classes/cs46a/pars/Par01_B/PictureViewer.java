// Keep the step instructions and add your code below them.
/**
 * Load and draw a picture.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 2022-08-25
 */
public class PictureViewer
{
    public static void main(String[] args)
    {
        // Step 2: Create a picture object pic and load
        //         picture "dogcat.png"
        Picture pic = new Picture("dogcat.png");

        // Step 3: Draw the picture
        pic.draw();

        // Step 4: Display the (x, y) coordnates of the picture
        System.out.println("X-coordinate: " + pic.getX());
        System.out.println("Y-coordinate: " + pic.getY());

        // Step 5: Display the size of the picture
        System.out.println("Width : " + pic.getWidth());
        System.out.println("Height: " + pic.getHeight());
    }
}
