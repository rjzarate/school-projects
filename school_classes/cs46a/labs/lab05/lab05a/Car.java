
/**
 * Creates a car with two wheels.
 *
 * @author Alan Xiao & Froilan Zarate
 * @version 09-23-2022
 */
public class Car
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private Color carColor;
    
    Rectangle carBody;
    Ellipse backTire;
    Ellipse frontTire;
    /**
     * Constructor for objects of class Car
     * 
     * @param x  the initial starting position of the horizontal position.
     * @param y  the initial starting position of the vertical position.
     * @param bodyColor  the color of the car.
     */
    public Car(int x, int y, Color bodyColor)
    {
        carBody = new Rectangle(x, y, 150, 50);
        backTire = new Ellipse(x + 10 ,y + 40, 30, 30);
        frontTire = new Ellipse(x + 110,y + 40, 30, 30);
        carBody.setColor(bodyColor);
        
        backTire.fill();
        frontTire.fill();
        carBody.fill();
    }
}
