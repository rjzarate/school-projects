/**
 * This class models circles.
 * 
 * @author  Qi Yang 
 * @version 2022-11-10
 */
public class Circle
{
    private double radius;
    
    /**
     * Constructs a Circle object with the given radius.
     * 
     * @param theRadius the radius of this circle
     */
    public Circle(double theRadius)
    {
        radius = theRadius;
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
     * Sets the radius of this circle.
     * 
     * @param newRadius the new radius of this circle
     */
    public void setRadius(double newRadius)
    {
        radius = newRadius;
    }
    
    /**
     * Gets the area of this circle.
     * 
     * @return the area of this circle
     */
    public double area()
    {
        double area = Math.PI * radius * radius;
        return area;
    }
}
