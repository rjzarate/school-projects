// Step 1: Import Java class ArrayList
import java.util.ArrayList;
/**
 * The class manages an array list of Rectangle objects.
 * 
 * Step 2: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version F2022ExamTwo
 */
public class RectangleArrayList
{
    // Step 3: Declare an array list of Rectangle 
    //         as the instance variable 
    private ArrayList<Rectangle> rectangleList;

    // Step 4: Complete the constructor
    /**
     * Initializes the array list to the parameter passed in.
     * 
     * @param theList the array list of Rectangle to manage
     */
    public RectangleArrayList(ArrayList<Rectangle> theList)
    {
        rectangleList = theList;
    }

    // Step 5: Complete method add()
    /**
     * Adds a Rectangle object at the end of the array list.
     *
     * @param rectangle the rectangle to be added
     */
    public void add(Rectangle rectangle)
    {
        rectangleList.add(rectangle);
    }
    
    // Step 6: Complete method delete()
    /**
     * Deletes and returns the rectangle at the specified 
     * position if the index is valid. 
     * Otherwise, returns null without changing the array list.
     *
     * @param index the position of the rectangle to be deleted
     * @return the rectangle at the specified position or null
     */
    public Rectangle delete(int index)
    {
        if (index < rectangleList.size() && index >= 0)
        {
            Rectangle rectangle = rectangleList.get(index);
            rectangleList.remove(index);
            return rectangle;
        } else
        return null;
    }
    
    // Step 7: Complete method countOfPerfectRectangles()
    /**
     * Gets the count of perfect rectangles in this array list. 
     * A rectangle is perfect if the product of its x and y 
     * coordinates equals its area.
     * 
     * You should use the enhanced for loop.
     *    
     * @return the count of perfect rectangles in this array list
     */    
    public int countOfPerfectRectangles()
    {
        int count = 0;
        for (Rectangle rectangle: rectangleList)
        {
            if (rectangle.area() == (rectangle.getX() * rectangle.getY()))
            {
                count ++;
            }
        }
        return count;
    }
    
    // Step 8: Complete method toString()
    /**
     * Gets a string representation for this array list.
     * 
     * @return the string returned by the toString() method 
     *         of this array list.
     */
     @Override
    public String toString()
    {
        return rectangleList.toString();
    }
}
