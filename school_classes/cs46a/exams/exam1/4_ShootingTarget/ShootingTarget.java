/**
 * A class models shooting targets with five concentric 
 * rings in alternating black and white colors.
 * 
 * Step 1: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version MyExamOne
 */
public class ShootingTarget
{
    // Step 2: Declare two instance variables of int
    //         to store the (x, y) coordinates of the 
    //         center of the shooting target
    private int x, y;
    
    // Step 3: Complete the constructor
    //         Do not draw the shooting target inside
    //         the constructor
    /**
     * Constructor of class ShootingTarget.
     * 
     * @param xPos the x-coordinate of the center
     * @param yPos the y-coordinate of the center
     */
    public ShootingTarget(int xPos, int yPos)
    {
        x = xPos;
        y = yPos;
    }
        
    // Step 4: Complete method draw()
    //         You can use magic numbers inside the method
    /**
     * Creates five circles at the same center with black and 
     * white colors to make the shooting target.
     * Starting from the outside, 
     *    the 1st circle is black with a radius of 50
     *    the 2nd circle is white with a radius of 40
     *    the 3rd circle is black with a radius of 30
     *    the 4th circle is while with a radius of 20
     *    the 5th circle is black with a radius of 10
     * 
     * Remember the instance vatiable stores the center position, 
     * but you need the (x, y) coordinates for the top-left corner 
     * to draw the circles.
     */
    public void draw()
    {
        Ellipse circle1 = new Ellipse(x - 50, y - 50, 100, 100);
        Ellipse circle2 = new Ellipse(x + 10 - 50, y + 10 - 50, 80, 80);
        Ellipse circle3 = new Ellipse(x + 20 - 50, y + 20 - 50, 60, 60);
        Ellipse circle4 = new Ellipse(x + 30 - 50, y + 30 - 50, 40, 40);
        Ellipse circle5 = new Ellipse(x + 40 - 50, y + 40 - 50, 20, 20);       
        
        circle1.setColor(Color.BLACK);
        circle2.setColor(Color.WHITE);
        circle3.setColor(Color.BLACK);
        circle4.setColor(Color.WHITE);
        circle5.setColor(Color.BLACK);
        
        circle1.fill();
        circle2.fill();
        circle3.fill();
        circle4.fill();
        circle5.fill();
    }
}
