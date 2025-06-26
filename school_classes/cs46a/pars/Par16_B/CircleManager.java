// Step 1: import Java class ArrayList
import java.util.ArrayList;
/**
 * The class manages an array list of Circle objects.
 * 
 * Step 2: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 10-27-2022
 */
public class CircleManager
{
    public static final double TARGET_RADIUS = 10.0;
    
    // Step 3: Declare an instance variable of
    //         an array list of class Circle
    private ArrayList<Circle> list;

    // Step 4: Complete the default constructor according
    //         to the comment.
    /**
     * Constructs an object of CircleList by initializing the
     * instance variable to an empty array list of Circle.
     */
    public CircleManager()
    {
        list = new ArrayList<Circle>();
    }

    // Step 5: Complete method add() according to the comment
    /**
     * Adds a Circle object at the beginning of the list.
     * 
     * @param circle the circle to add
     */
    public void add(Circle circle)
    {
        list.add(0, circle);
    }

    // Step 6: Complete method smallestCircle() according to the comment
    /**
     * Gets the circle in the list with the smallest area.
     * If multiple circles have the same smallest area,
     * return the first one with the smallest area.
     * If the list is empty, return null.
     * 
     * You must use the enhanced for loop.
     * 
     * @return the first circle with the smallest area
     *         null if the list is empty
     */
    public Circle firstSmallestCircle()
    {
        if (list.size() == 0)
        {
            return null;
        }
        int index = -1;
        int smallestIndex = 0;
        Circle firstCircle = list.get(0);
        double area = firstCircle.getArea();
        for (Circle circle: list)
        {
            index ++;
            if (circle.getArea() < area)
            {
                area = circle.getArea();
                smallestIndex = index;
            }
        }
        return list.get(smallestIndex);
    }
    
    // Step 7: Complete method hasCircleWithRadiusGreaterThan10() 
    //         according to the comment
    /**
     * Returns true if the list has a circle with radius larger
     * that TARGET_RADIUS (10.0), false otherwise.
     * You should use the while loop and exit the loop right 
     * after such a circle is found.
     * 
     * @return true if the list has a circle with radius > TARGET_RADIUS
     *         false otherwise
     */
    public boolean hasCircleWithRadiusGreaterThan10()
    {
        for (Circle circle: list)
        {
            if (circle.getRadius() > TARGET_RADIUS)
            {
                return true;
            }
        }
        return false;
    }
    
    // Step 8: Override method toString() according to the comment
    /**
     * Gets a string representation for this CircleManager object.
     * 
     * @return a string including all circles in theList in the format
     *         "CircleManager" + CircleArrayList_toString
     *         where CircleArrayList_toString is the string returned from  
     *         the toString() method of theList
     */
    @Override
    public String toString()
    {
        return "CircleManager" + list.toString();
    }
}
