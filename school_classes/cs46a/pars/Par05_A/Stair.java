/**
 * The class models 3-step stairs at any locations.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 09-08-2022
 */
public class Stair
{
    // Static constants
    public static final int STEP_HEIGHT = 20;
    public static final int STEP1_WIDTH = 20;
    public static final int WIDTH_INCREMENT = 20;
    
    // Step 2: Declare two instance variables for 
    //         the location (x, y) of this stair 
    private double x, y;


    /**
     * Initializes the instance variables to create an object
     * of class Stair.
     * 
     * @param  xPos the x-coordinate of the upper-left corner
     * @param  yPos the y-coordinate of the upper-left corner
     */
    public Stair(double xPos, double yPos)
    {
        // Step 3: Complete the constructor
        x = xPos;
        y = yPos;
    }

    /**
     * Gets the x coordinate of the upper-left corner
     * of this stair.
     *
     * @return the x coordinate of the upper-left corner
     */
    public double getX()
    {
        // Step 4: Complete method getX()
        return x;
    }

    /**
     * Draws this stair at the specified location (x, y).
     */
    public void draw()
    {
        // Step 5: Complete method draw()
        Rectangle step1 = new Rectangle(x, y, STEP1_WIDTH, STEP_HEIGHT);
        step1.draw();
        Rectangle step2 = new Rectangle(x, y + STEP_HEIGHT, STEP1_WIDTH + WIDTH_INCREMENT, STEP_HEIGHT);
        step2.draw();
        Rectangle step3 = new Rectangle(x, y + 2 * STEP_HEIGHT, STEP1_WIDTH + 2 * WIDTH_INCREMENT, STEP_HEIGHT);
        

    }
}