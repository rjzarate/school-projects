/*
 * The class models objects of circles. 
 * 
 * @author  Qi Yang
 * @version 2022-10-25
 */ 
public class Circle 
{
    private double radius;
    private int x, y;
    
    /**
     * Constructs a Circle object with the given (x, y) coordinates 
     * and the given radius and sets radius to one if radius is not
     * positive.
     * 
     * @param xCoord the x-coordinate of the center of this circle
     * @param yCoord the y-coordinate of the center of this circle
     * @param theRadius the radius of this circle
     */
    public Circle(int xCoord, int yCoord, double theRadius)
    {
        x = xCoord;
        y = yCoord;
        setRadius(theRadius);
    }
    
    /**
     * Gets the x-coordinate of the center of this circle.
     * 
     * @return the x-coordinate of the center of this circle
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * Gets the y-coordinate of the center of this circle.
     * 
     * @return the y-coordinate of the center of this circle
     */
    public int getY()
    {
        return y;
    }

    /**
     * Gets the radius of this circle.
     * 
     * @return the radius of this circle
     */
    public double getRadius()
    {
        return radius;
    }
    
    /**
     * Sets a new radius for this circle.
     * 
     * @param newRadius the new radius of this circle
     */
    public void setRadius(double newRadius)
    {
        radius = newRadius;
        if (radius <= 0)
            radius = 1;
    }
    
    /**
     * Gets the area of this circle.
     * 
     * @return the area of this circle
     */
    public double getArea()
    {
        return radius * radius * Math.PI;
    }
    
    /**
     * Builds a string to represent this circle.
     * 
     * @return a string in the format "Circle[x=3,y=5,radius=10.50]"
     */
    @Override
    public String toString()
    {
        String s = "Circle[x=" + x + ",y=" + y + ",radius=" + radius + "]";
        return s;
    }
}
