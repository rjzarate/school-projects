/**
 * The class manages a full array of circles and provides
 * some methods to retrieve information from it. No adding
 * to or removing from the array, and the array length is the 
 * number of circles in the array.
 * 
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 11-01-2022
 */
public class CircleManager
{
    // Step 2: Declare an array of class Circle
    //         as the instance variable
    private Circle[] circleArray;

    // Step 3: Complete the constructor according to the comment.
    /**
     * Constructs an object of CircleManager by initializing
     * the instance variable to the parameter.
     * 
     * @param circles the array of Circle to be managed
     */
    public CircleManager(Circle[] circles)
    {
        circleArray = circles;
        //circleArray = new Circle[circles.length];
        //for (int i = 0; i < circles.length; i ++)
        //{
        //    circleArray[i] = circles[i];
        //}
    }

    // Step 4: Complete method maxX() according to the
    //         comment 
    /**
     * Gets the largest x value for all circles in the array.
     * 
     * You must use the enhanced for loop.
     * 
     * @return the largest x value for all circles in the array
     */
    public int maxX()
    {
        int largestX = circleArray[0].getX();
        for (Circle circle: circleArray)
        {
            if (largestX < circle.getX())
            {
                largestX = circle.getX();
            }
        }
        
        return largestX;
    }

    // Step 5: Complete method countOfLargerThanLimit() 
    //         according to the comment
    /**
     * Gets the number of circles in the array that
     * have an area larger than the given limit.
     * 
     * You must use the enhanced for loop.
     * 
     * @param  limit the specified limit
     * @return the number of circles in the array with a
     *         area larger than the given limit.
     */
    public int countOfLargerThanLimit(double limit)
    {
        int circleAmount = 0;
        for (Circle circle: circleArray)
        {
            if (circle.getArea() > limit)
            {
                circleAmount ++;
            }
        }
        
        return circleAmount;
    }
    
    // Step 6: Complete method averageArea() according 
    //         to the comment
    /**
     * Gets the average area of all circles in the array.
     * You can assume the length is the number of circles 
     * in the array and not zero.
     * 
     * You must use the enhanced for loop.
     * 
     * @return the average area of all circles in the array 
     */
    public double averageArea()
    {
        double averageArea = 0;
        
        for (Circle circle: circleArray)
        {
            averageArea += circle.getArea();
        }
        averageArea = averageArea / (double) circleArray.length;
        
        return averageArea;
    }
}
