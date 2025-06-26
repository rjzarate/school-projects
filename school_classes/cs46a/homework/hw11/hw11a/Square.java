/**
 * The Java class models square objects.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 12-01-2022
 */
// Step 2: Implement interface HasArea
public class Square implements HasArea
{
    private double sideLength;

    /**
     * Constructor for objects of class Square.
     * 
     * @param size the size of this Square
     */
    public Square(double size)
    {
        sideLength =  size;
    }
    
    /**
     * Gets the sideLength of this Square
     * 
     * @return the sideLength of this Square
     */
    public double getSideLength()
    {
        return sideLength;
    }
    
    /**
     * Sets the the sideLength of this Square.
     * 
     * @param newLength the new side length of this Square
     */
    public void setSideLength(double newLength)
    {
        sideLength = newLength;
    }
            
    /**
     * Gets a string representation for the Square.
     * 
     * @return a string for this Square in the format
     *         Square[Length=12.45]
     */
    @Override
    public String toString()
    {
        return"Square[SideLength=" + sideLength + "]";
    }
    
    // Step 3: Implement the method for interface HasArea
    /**
     * Gets the area of the square.
     * 
     * @return the area
     */
    public double area()
    {
        return sideLength * sideLength;
    }
}