/**
 * Manages a partial array of class Frog.
 *
 * Step 1: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version SampleExamTwo
 */
public class FrogArray
{
    // Step 2: Declare two instance variables to 
    //         manage a partial array of class Frog
    private Frog[] frogList;
    private int currentSize;

    // Step 3: Write the constructor according to the comment
    //         including possible Javadoc tags
    /**
     * The constructor has two parameters for the two
     * instance variables:
     *      array: an array of Frog
     *      count: the number of frogs in array
     * 
     * @param array  the frog array
     * @param count  the length of the array
     */
    public FrogArray(Frog[] array, int count)
    {
        frogList = array;
        currentSize = count;
    }

    // Step 4: Write method add() according to the comment
    //         including possible Javadoc tags
    /**
     * The method has one parameter of class Frog. If the 
     * array is not full, the method will add the frog at 
     * the end of the array and update the number of frogs 
     * in the array; otherwise, it will not do nothing.
     *
     * @param frog  the added frog
     */
    public void add(Frog frog)
    {
        if (frogList.length > currentSize)
        {
            frogList[currentSize] = frog;
            currentSize ++;
        }
    }

    
    // Step 5: Write method delete() according to the comment
    //         including possible Javadoc tags
    /**
     * The method has one parameter for the index of a frog to
     * be deleted from the array. If the index is valid, the
     * method will remove the frog from the array, shifting 
     * all subsequent elements to the left by one position, 
     * and return the frog. Otherwise, the method will not
     * change the aray at all and return null.
     * 
     * @param index  the index of the frog that will be deleted
     * 
     * @return the deleted frog or null
     */
    public Frog delete(int index)
    {
        if (index < currentSize && index >= 0)
        {
            Frog deletedFrog = frogList[index];
            for (int i = index; i < currentSize - 1; i ++)
            {
                frogList[i] = frogList[i + 1];
            }
            currentSize --;
            return deletedFrog;
        }
        return null;
    }
    
    // Step 6: Write method lastOutOfRange() according to the comment
    //         including possible Javadoc tags
    /**
     * The method has two int parameters for the low and high
     * limits and will return the last frog in the array whose
     * weight is not in the specified range (smaller than the 
     * low limit or larger than the high limit). The method 
     * will return null if no frog is out of the range.
     * 
     * @param low  the low limit
     * @param high the high limit
     * 
     * @return the frog out of limit or null
     */
    public Frog lastOutOfRange(int low, int high)
    {
        Frog frog = frogList[0];
        boolean foundFrog = false;
        
        for (int i = 0; i < currentSize; i ++)
        {
            if (frogList[i].getWeight() < low || frogList[i].getWeight() > high)
            {
                frog = frogList[i];
                foundFrog = true;
            }
        }
        
        if (foundFrog == true)
        {
            return frog;
        } else
        return null;
    }
    
    // Step 7: Override method toString() according to the comment
    //         including possible Javadoc tags
    /**
     * The method has no parameters and will return a string 
     * in the following format:
     *         [Frog[...], Frog[...], ..., Frog[...]]
     * where each Frog[...] is the string returned by method
     * toString() on a frog in the array.
     * 
     * Do not use an if statement inside the loop.
     * @return
     */
    @Override
    public String toString()
    {
        String str = "[";
        
        if (currentSize != 0)
        str += frogList[0];
        
        for (int i = 1; i < currentSize; i ++)
        {
            str += ", " + frogList[i].toString();
        }
        return str + "]";
    }

}