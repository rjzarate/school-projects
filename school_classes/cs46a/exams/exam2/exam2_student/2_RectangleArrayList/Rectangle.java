/*
 * The class models objects of rectangles. 
 * 
 * @author  Qi Yang
 * @version 2022-11-11
 */ 
public class Rectangle 
{
    // The width and height of this rectangle
    private int width, height;
    // The x and y coordinates of the upper-left corner of this rectangle
    private int x, y;       

    /**
     * Creates a Rectangle object of the specified size
     *         at the specified location.
     *         
     * @param xPos the x coordinate of this rectangle
     * @param yPos the y coordinate of this rectangle
     * @param theWidth the width of this rectangle
     * @param theHeight the height of this rectangle
     */
    public Rectangle(int xPos, int yPos, int theWidth, int theHeight)
    {
        width = theWidth;
        height = theHeight;
        x = xPos;
        y = yPos;
    }
    
    /**
     * Gets the x coordinate of the upper-left corner of this rectangle.
     * 
     * @return the x coordinate of this rectangle
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * Gets the y coordinate of the upper-left corner of this rectangle.
     * 
     * @return the x coordinate of this rectangle
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * Gets the area of this rectangle.
     * 
     * @return the area of this quare
     */
    public int area()
    {
        return width * height;
    }
    
    /**
     * Builds a string to represent this rectangle.
     * 
     * @return a string in the format 
     *         "Rectangle[x=1,y=2,widht=3,height=3]"
     */
    public String toString()
    {
        return "Rectangle[x=" + x + ",y=" + y + ",widht=" + 
                          width + ",height=" + height + "]";
    }
}
