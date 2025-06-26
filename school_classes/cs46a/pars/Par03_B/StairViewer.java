/**
 * Draws a staircase with three rectangles.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 09-01-2022
 */
public class StairViewer
{

    public static void main(String[] args) 
    {
        // Step 2: Create a rectangle and draw it as the 
        //         top step of the stair 
        // location: (20, 10)
        // size: (20, 20)
        Rectangle rec1 = new Rectangle(20.0, 10.0, 20.0, 20.0);
        rec1.draw();

        // Step 3: Create a rectangle and draw it as the 
        //         middle step of the stair 
        // location: below the top step, aligned on left
        // size: (40, 20)
        Rectangle rec2 = new Rectangle(20.0, 30.0, 40.0, 20.0);
        rec2.draw();

        // Step 4: Create a rectangle and draw it as the 
        //         bottom step of the stair 
        // location: below the middle step, aligned on left
        // size: (60, 20)
        Rectangle rec3 = new Rectangle(20.0, 50.0, 60.0, 20.0);
        rec3.draw();

    }
}
