
/**
 * An array of integers
 *
 * @author  Froilan Zarate
 * @version 11-01-2022
 */
public class IntArray
{
    // instance variables - replace the example below with your own
    private int[] intArray;
    private int currentSize;
    
    /**
     * Constructor for objects of class IntArray
     * 
     * @param theIntArray  the array
     * @param size  the size
     */
    public IntArray(int[] theIntArray, int size)
    {
        intArray = theIntArray;
        currentSize = size;
    }

    /**
     * Adds value to the end of the array if the array is not full and does nothing otherwise
     *
     * @param  value  the integer
     */
    public void add(int value)
    {
        if (currentSize != intArray.length)
        {
            intArray[currentSize] = value;
            currentSize ++;
        }
    }
    
    /**
     * Removes the value at the specified index position from the array and shifts any subsequent elements to the left (subtracts one from their indices) if the index is valid. The method does nothing if the index is invalid.
     *
     * @param  index  the index
     */
    public void remove(int index)
    {
        if (index >= 0 && index < currentSize)
        {
            //let i be the index
            for (int i = index; i < currentSize - 1; i ++)
            {
                intArray[i] = intArray[i + 1];
            }
            
            currentSize --;
        }
    }
    
    /**
     * Gets the count of the array elements that are not in the specified range [low, high].
     * 
     * @param  low  the lowest the integer can be
     * @param  high  the highest the integer can be
     * 
     * @return  the count of integers thar are not within the low and high value
     */
    public int countOfOutRange(int low, int high)
    {
        int count = 0;
        
        //let i be the starting index
        for (int i = 0; i < currentSize; i ++)
        {
            if (intArray[i] < low || intArray[i] > high)
            {
                count ++;
            }
        }
        
        return count;
    }
    
    /**
     * Returns the last negative value in the array and 0 if no negative values in the array.
     * 
     * 
     * @return  the last negative value
     */
    public int lastNegative()
    {
        int value = 0;
        //let i be the starting index
        for (int i = 0; i < currentSize; i ++)
        {
            if (intArray[i] < 0)
            {
                value = intArray[i];
            }
        }
        
        return value;
    }
    
    /**
     * Returns a string listing all values in the array separated by a comma and a space and enclosed in a pair of "[" and "]". For example, [3, 56, 23, -2].
     * 
     * 
     * @return  the last negative value
     */
    public String toString()
    {
        String string = "[";
        
        if (currentSize > 0)
        {
            string = string + intArray[0];
        }
        //let i be the starting index
        for (int i = 1; i < currentSize; i ++)
        {
            string = string + ", " + intArray[i];
        }
        
        return string + "]";
    }
}
