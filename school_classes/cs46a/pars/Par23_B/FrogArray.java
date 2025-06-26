// Step 1: Import Java class Arrays
import java.util.Arrays;
import java.util.Collections;
/**
 * Manages a partial array of class Frog.
 *
 * Step 2: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 11-29-2022
 */
public class FrogArray
{
    private Frog[] theArray;
    private int currentSize;

    /**
     * Constructs an object of class FrogArray
     * by creating an empty array of Frog of the 
     * specified length.
     * 
     * @param length the length of the array
     */
    public FrogArray(int length)
    {
        theArray = new Frog[length];
        currentSize = 0;
    }

    /**
     * Constructs an object of class FrogArray
     * by initializing the instance variables
     * with the parameters.
     * 
     * @param array an array of class Frog
     * @param count the number of frogs in array
     */
    public FrogArray(Frog[] array, int count)
    {
        theArray = array;
        currentSize = count;
    }

    /**
     * Adds a frog at the end of the array if the array
     * is not full. Do nothing otherwise.
     *
     * @param frog the frog to add
     */
    public void add(Frog frog)
    {
        if (currentSize < theArray.length)
        {
            theArray[currentSize] = frog;
            currentSize ++;
        }
    }
    
    /**
     * Gets a string for the array.
     * 
     * @return a string for the array
     */
    @Override
    public String toString()
    {
       String s = "[";
       if (currentSize > 0)
       {
           s += theArray[0].toString();
           for (int i = 1; i < currentSize; i ++)
            s += ", " + theArray[i].toString();
       }
       
       return s + "]";
    }
    
    // Step 3: Write method sort()
    //         Do not copy the array in any way.
    /**
     * Calls a static to sort the array based on interface Comparable.
     */
    public void sort()
    {
        Arrays.sort(theArray, 0, currentSize);
    }
}