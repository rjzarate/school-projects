// Step 1: Import class Arrays
import java.util.Arrays;
/**
 * Manages a partial array of class Frog. The number of frogs
 * in the array needs to be kept correct at all times.
 *
 * Step 2: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version SampleFinalExam
 */
public class ArrayFrog
{
    // Step 3: Declare two instance variables to
    //         manage a partial array of Frog.
    private Frog[] list;
    private int currentSize;
    
    // Step 4: Complete the first constructor
    /**
     * Constructs an ArrayFrog object with an array of
     * Frog and the number of frogs in the array.
     * 
     * @param array the array of class Frog to be managed
     * @param count the number of frogs in the array
     */
    public ArrayFrog(Frog[] array, int count)
    {
        list = array;
        currentSize = count;
    }

    // Step 5: Complete the second constructor
    /**
     * Constructs an ArrayFrog object by creating an
     * empty array of Frog and setting the number of 
     * frogs to zero.
     * 
     * @param length the length of the array
     */
    public ArrayFrog(int length)
    {
        list = new Frog[length];
        currentSize = 0;
    }
    
    // Step 6: Complete the first add() method
    /**
     * Adds a frog at the end of the array if the array
     * is not full and does nothing otherwise.
     *
     * @param frog the frog to be added
     */
    public void add(Frog frog)
    {
        if (currentSize < list.length)
        {
            list[currentSize] = frog;
            currentSize ++;
        }
    }
    
    // Step 7: Complete the second add() method
    /**
     * Inserts the specified frog at the specified index
     * position in the array and shifts the element currently 
     * at that position and any subsequent elements (if any) 
     * to the right (adds one to their indices) if the array 
     * is not full and the index is valid.
     * The method does nothing otherwise.
     * 
     * @param index the position to insert the frog
     * @param frog the frog to insert
     */
    public void add(int index, Frog frog)
    {
        if (index >= 0 && index <= currentSize && currentSize < list.length)
        {
            for (int i = currentSize - 1; i >= index; i --)
            {
                list[i + 1] = list[i];
            }
            list[index] = frog;
            currentSize ++;
        }
    }
    
    // Step 8: Complete method delete()
    /**
     * Deletes and returns the frog at the specified position 
     * if the specified index is valid. It also shifts the 
     * element at the position and all subsequent elements 
     * (if any) to the left to maintain the element order.
     * The method does nothing otherwise.
     * 
     * @param index the index of the frog to be deleted 
     *        from the array
     * @return the frog deleted from the array if index is valid
     *         null otherwise
     */
    public Frog delete(int index)
    {
        if (index >= 0 && index < currentSize)
        {
            Frog removedFrog = list[index];
            for (int i = index; i < currentSize - 1; i ++)
            {
                list[i] = list[i + 1];
            }
            currentSize --;
            return removedFrog;
        }
        return null;
    }
    
    // Step 9: Complete method toString()
    /**
     * Gets a string representation for the array.
     * 
     * No if statements inside the loop.
     * 
     * @return a String containing all frogs in the array 
     *         in the format 
     *         [Frog[...], Frog[...], ..., Frog[...]]
     *         where each Frog[...] is the string returned
     *         from method toString on a frog in the array
     */
    @Override
    public String toString()
    {
        String str = "[";
        if (currentSize > 0)
        str += list[0].toString();
        for (int i = 1; i < currentSize; i ++)
        {
            str += ", " + list[i].toString();
        }
        return str + "]";
    }

    // Step 10: Complete method sort()
    /**
     * Calls a static method to sort the array.
     */
    public void sort()
    {
        Arrays.sort(list, 0, currentSize);
    }
}