/**
 * The class models 3-step stairs with a color at any locations.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 09-13-2022
 */
public class Stair
{
    public static final int STEP_HEIGHT = 20;
    public static final int STEP1_WIDTH = 20;
    public static final int WIDTH_INCREMENT = 20;
    
    private double x, y;
    // Step 2: Declare a new instance variable for the color
    private Color stairColor;


    // Step 3: Modify the existing constructor if needed
    /**
     * Initializes the instance variables x and y and sets
     * the color to Color.BLACK.
     * 
     * @param  xPos the x-coordinate of the upper-left corner
     * @param  yPos the y-coordinate of the upper-left corner
     */
    public Stair(double xPos, double yPos)
    {
        x = xPos;
        y = yPos;
        stairColor = Color.BLACK;
    }

    // Step 4: Complete the new constrctor,
    //         including the Javadoc tags
    /**
     * Initializes the instance variables including (x, y) and
     * the color to create an object of class Stair.
     * 
     * 
     * @param  xPos the x-coordinate of the upper-left corner
     * @param  yPos the y-coordinate of the upper-left corner
     * @param  theColor the color of the stair
     */
    public Stair(double xPos, double yPos, Color theColor)
    {
        x = xPos;
        y = yPos;
        stairColor = theColor;

    }

    /**
     * Gets the x coordinate of the upper-left corner
     * of this stair.
     *
     * @return the x coordinate of the upper-left corner
     */
    public double getX()
    {
        return x;
    }

    // Step 5: Complete method setColor()
    //         including the Javadoc tags
    /**
     * Sets the stair color to newColor.
     * 
     * @param  newColor the new color of the stair
     */
    public void setColor(Color newColor)
    {
        stairColor = newColor;
    }

    // Step 6: Modify method draw() to fill the stair with
    //         the specified color
    /**
     * Draws this stair at the specified location and fill it
     * with the specified color.
     */
    public void draw()
    {
        Rectangle step1 = new Rectangle(this.x, y, STEP1_WIDTH, 
                        STEP_HEIGHT);
        Rectangle step2 = new Rectangle(x, y + STEP_HEIGHT, 
                        STEP1_WIDTH + WIDTH_INCREMENT, STEP_HEIGHT);
        Rectangle step3 = new Rectangle(x, y + 2 * STEP_HEIGHT, 
                        STEP1_WIDTH + 2 * WIDTH_INCREMENT, STEP_HEIGHT);
        step1.fill();
        step2.fill();
        step3.fill();
    }
    
    // Step 7: Override method toString()
    /**
     * Gets a string representation for this stair in the 
     * following format:
     *         "Stair[X:20.0,Y:10.0,Color:255,0,0]"
     * where "255,0,0" are the red, green and blue
     * values of the color.
     * 
     */
    @Override
    public String toString()
    {
        String s;
        s = "Stair[X:" + x + ",Y:" + y + ",Color:" + 
        stairColor.getRed() + "," + 
        stairColor.getGreen() + "," +
        stairColor.getBlue() + "]";
        return s;
    }

}