/**
 * A Java class to manage a partial array of Circle.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 11-01-2022
 */
public class CircleArray
{
    // Step 2: Declare two instance variables
    //         to manage a partial array of Circle
    private Circle[] circleArray;
    private int currentSize;
    
   
    // Step 3: Complete the default constructor according to the comment
    /**
     * Constructs a CircleArray object by creating an
     * array of Circle of the specified length and setting
     * the number of circles in the array to zero.
     * 
     * @param length the length of the array to manage
     */
    public CircleArray(int length)
    {
        circleArray = new Circle[length];
        currentSize = 0;
    }

    // Step 4: Complete method add() according to the comment
    /**
     * Inserts the specified circle to the specified index
     * position in the array and shifts the element currently 
     * at that position and any subsequent elements (if any) 
     * to the right (adds one to their indices) if the array 
     * is not full and the index is valid.
     * The method does nothing otherwise.
     * 
     * @param index the position to insert the circle
     * @param circle the circle to insert
     */
    public void add(int index, Circle circle)
    {
        if (index < circleArray.length && index >= 0 && index <= currentSize && currentSize != circleArray.length)
        {
            for (int i = currentSize; i > index; i--)
            {
                circleArray[i] = circleArray[i - 1];
            }
            
            
            circleArray[index] = circle;
            currentSize ++;
        }
    }
    
    // Step 5: Complete method remove() according to the comment
    /**
     * Deletes and returns the circle at the specified index 
     * position and shifts all subsequent elements (if any) to 
     * the left (subtracts one from their indices) if the 
     * index is valid. The method returns null and does not  
     * change the array if the index is invalid.
     * 
     * @param  index the index position of the circle to delete 
     * @return the circle at the specified index position
     *         null if index is invalid
     */
    public Circle remove(int index)
    {
        boolean foundCircle = false;
        Circle removedCircle = new Circle (0, 0, 0);
        if (index < circleArray.length && index >= 0 && index < currentSize)
        {
            removedCircle = circleArray[index];
            foundCircle = true;
            for (int i = index; i < currentSize; i ++)
            {
                if (currentSize == circleArray.length && i == currentSize - 1)
                {
                    circleArray[i] = null;
                } else
                {
                    circleArray[i] = circleArray[i + 1];
                }
            }
            currentSize --;
        }
        
        if (foundCircle == true)
        {
            return removedCircle;
        } else
        {
            return null;
        }
    }

    // Step 6: Complete method lastCircleLargerThanLimit() according to the comment
    /**
     * Gets the last circle in the array whose 
     * area is larger than the specified limit.
     * The method returns null if the array
     * does not have such circles.
     * 
     * @param limit the specified limit value
     * @return the last circle in the array whose area
     *             is larger than the specified limit
     *         null if the array does not have such circles
     */
    public Circle lastCircleLargerThanLimit(double limit)
    {
        boolean foundCircle = false;
        Circle circleLargerThanLimit = new Circle(0, 0, 0);
        
        for (int i = 0; i < currentSize; i ++)
        {
            if (circleArray[i].getArea() > limit)
            {
                circleLargerThanLimit = circleArray[i];
                foundCircle = true;
            }
            
        }
        
        if (foundCircle == true)
        {
            return circleLargerThanLimit;
        } else
        {
            return null;
        }
        
    }
    
    // Step 7: Override method toString() according to the comment,
    /**
     * Gets a string representation including the length of the
     * array, the number of circles in the array, and all circles
     * in the array.
     * 
     * Use a for loop to go over all circles in the array,
     * but do not use any if statements inside the loop.
     * 
     * @return a string in the format
     *         [Circle[], Circle[], . . ., Circle[]]
     *         where each Circle[] is the string from the toString() 
     *         method on a circle in the array.
     */
    @Override
    public String toString()
    {
        String string;
        string = "[";
        
        for (int i = 0; i < currentSize; i ++)
        {
            if (currentSize >= 1)
            {
                string = string + circleArray[i].toString();
                if (i < currentSize - 1)
                {
                    string = string + ", ";
                }
            }
        }
        
        return string + "]";
    }
}
