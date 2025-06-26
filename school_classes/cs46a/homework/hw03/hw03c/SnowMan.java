
/**
 * Models a snowman at a given location.
 *
 * @author Froilan Zarate
 * @version 09-13-2022
 */
public class SnowMan
{
    // instance variables - replace the example below with your own
    public static final int HAT_SIZE = 20; 
    public static final int HAT_BRIM_SIDE_SIZE = 10; 
    public static final int SMALL_DIAMETER = 20; 
    public static final int DIAMETER_INCREMENT = 20; 
    public static final int RADIUS_INCREMENT = 10; 
    private int x, y;

    /**
     * Constructs the x position and y position for the top left corner
     * 
     * @param  xPos the x posiiton for the top left corner.
     * @param  yPos the y posiiton for the top left corner.
     */
    public SnowMan(int xPos, int yPos)
    {
        // initialise instance variables
        x = xPos;
        y = yPos;
    }

    /**
     * Draws the snowman.
     *
     */
    public void draw()
    {
        Rectangle hat = new Rectangle(x, y, HAT_SIZE, HAT_SIZE);
        Line brim = new Line(x - HAT_BRIM_SIDE_SIZE, y + HAT_SIZE, 
                            x + HAT_SIZE + HAT_BRIM_SIDE_SIZE, y + HAT_SIZE);
        Ellipse circle1 = new Ellipse(x, y + HAT_SIZE,
                                    SMALL_DIAMETER, SMALL_DIAMETER);
        Ellipse circle2 = new Ellipse(x - RADIUS_INCREMENT, y + HAT_SIZE + DIAMETER_INCREMENT,
                                    SMALL_DIAMETER + DIAMETER_INCREMENT, SMALL_DIAMETER + DIAMETER_INCREMENT);
        Ellipse circle3 = new Ellipse(x - RADIUS_INCREMENT * 2, y + HAT_SIZE + DIAMETER_INCREMENT + DIAMETER_INCREMENT * 2,
                                    SMALL_DIAMETER + DIAMETER_INCREMENT * 2, SMALL_DIAMETER + DIAMETER_INCREMENT * 2);
        hat.fill();
        brim.draw();
        circle1.draw();
        circle2.draw();
        circle3.draw();
    }
}
