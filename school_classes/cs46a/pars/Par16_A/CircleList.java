// Step 1: import Java class ArrayList
import java.util.ArrayList;
/**
 * The class manages a list of circles. 
 * 
 * Step 2: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 10-27-2022
 */
public class CircleList
{
    // Step 3: Declare an instance variable of
    //         an array list of class Circle
    private ArrayList<Circle> list;

    // Step 4: Complete the default constructor according
    //         to the comment.
    /**
     * Constructs an object of CircleList by initializing the
     * instance variable to an empty array list of Circle.
     */
    public CircleList()
    {
        list = new ArrayList<Circle>();
    }

    // Step 5: Complete method count() according to the comment,
    //         including Javadoc tags
    /**
     * Gets the number of circles in the list.
     * 
     * @return the cardinality of the set.
     */
    public int count()
    {
        return list.size();
    }
    
    // Step 6: Complete method add() according to the comment,
    //         including Javadoc tags
    /**
     * Adds a Circle object at the end of the list.
     * 
     * @param circle  the circle added
     */
    public void add(Circle circle)
    {
        list.add(circle);
    }

    // Step 7: Complete method averageArea() according to the comment,
    //         including Javadoc tags
    /**
     * Gets the average area of all circles in the list.
     * Returns 0 if the list is empty. Use the ehanced
     * for loop to calculate the sum of areas of all
     * circles in the list.
     * 
     * @return the area of the circles averaged
     */
    public double averageArea()
    {
        double total = 0;
        for (Circle circle: list)
        {
            total += circle.getArea();
        }
        if (list.size() == 0)
        {
            return 0.0;
        } else
        {
            return total / list.size();
        }
    }   
    
    // Step 8: Complete method largestArea() according to the comment,
    //         including Javadoc tags
    /**
     * Gets the largest area among all circles in the list.
     * Returns 0.0 if the list is empty.
     * 
     * @return the largest area
     */
    public double largestArea()
    {
        double largest = 0;
        for (Circle circle: list)
        {
            if (largest < circle.getArea())
            {
                largest = circle.getArea();
            }
        }
        if (list.size() == 0)
        {
            return 0.0;
        } else
        {
            return largest;
        }
    }
    
    // Step 9: Complete method updatingRadius() according to the comment,
    //         including Javadoc tags
    /**
     * Sets the radius of the circle at the specified index to
     * newRadius if index is valid, but do nothing otherwise.
     * 
     * @param index  what circle is changed
     * @param newRadius  the new radius
     */
    public void updatingRadius(int index, double newRadius)
    {
        if (index < list.size() && index >= 0)
        {
            Circle circle = new Circle(0, 0, 0);
            circle = list.get(index);
            circle.setRadius(newRadius);
            list.set(index, circle);
        }
        
    }
    
    // Step 10: Override method toString() according to the comment,
    //          including Javadoc tags
    /**
     * Gets a string representation for the list including all 
     * circles in the list by returning the string from the 
     * toString() method of the list.
     * 
     * @return the list of circles
     */
    @Override
    public String toString()
    {
        return list.toString();
    }

}
