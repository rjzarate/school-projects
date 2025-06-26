/**
 * A Java program loads an image, increases
 * its size, then displays it.
 *
 * Step 1: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version 09-29-2022
 */
public class PictureViewer
{
    public static void main(String[] args)
    {
        // Step 2: Fix the syntax errors and submit it
        //         to Codecheck to pass the test.
        // Note: Do not add or remove any statements
        //       Do not change the semantics of each statement
        //       Do not add or remove any variables
        //       Do not add or remove any objects
        //       Magic numbers are allowed
        
        // Create an object of Picture by loading an image 
        Picture pic = new Picture("starry_night.png");
        
        // Display the width and height
        System.out.println("Width : " + pic.getWidth());
        System.out.println("Height: " + pic.getHeight());

        // Increase the width by 50 on both sides and
        // increase the height by 40 on both sides.
        // Must use dw and dh when calling method grow().
        int dw, dh = 40;
        dw = 50;
        pic.grow(dw, dh);
                        
        // Display the width and height
        System.out.println("Width : " + pic.getWidth());
        System.out.println("Height: " + pic.getHeight());

        // Draw the picture
        pic.draw();
        
        // Display the x and y coordinates of the top-left 
        //         corner of the picture
        System.out.println("X-coordinate: " + pic.getX());
        System.out.println("Y-coordinate: " + pic.getY());
    }
}
