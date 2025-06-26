/**
 * Manages an array of class Frog.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 11-17-2022
 */
public class FrogArray
{
    // Step 2: Declare two instance variables to 
    //         manage an array of class Frog
    private Frog[] frogArray;
    private int currentSize;
    
    // Step 3: Write the constructor according
    //         to the comment
    /**
     * Constructs an object of class FrogArray
     * by creating an empty array of Frog of the 
     * specified length.
     * 
     * @param length the length of the array
     */
    public FrogArray(int length)
    {
        frogArray = new Frog[length];
        currentSize = 0;
    }

    // Step 4: Write the constructor according
    //         to the comment
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
        frogArray = array;
        currentSize = count;
    }

    // Step 5: Write method add() according 
    //         to the comment
    /**
     * Adds a frog at the end of the array if the array
     * is not full. Do nothing otherwise.
     *
     * @param frog the frog to add
     */
    public void add(Frog frog)
    {
        if (frogArray.length > currentSize)
        {
            frogArray[currentSize] = frog;
            currentSize ++;
        }
    }
    
    // Step 6: Write method lastInRange() according 
    //         to the comment
    /**
     * Finds the last frog in the array with a weight 
     * in the specified range.
     * 
     * 
     * After the requested frog is found, you should 
     * stop execution and return it.
     * 
     * @param lowLimit the low limit of the specified range
     * @param highLimit the high limit of the specified range
     * @return the last frog in the array whose weight
     *             is in the specified range
     *         null if no frog is in the specified range
     */
    public Frog lastInRange(int lowLimit, int highLimit)
    {
        for (int i = currentSize - 1; i >= 0; i --)
        {
            if (frogArray[i].getWeight() >= lowLimit && frogArray[i].getWeight() <= highLimit)
            return frogArray[i];
        }
        return null;
    }
}