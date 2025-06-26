// Step 1: Import class ArrayList and Collections
import java.util.ArrayList;
import java.util.Collections;
/**
 * Manages an array list of class Frog.
 *
 * Step 2: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version SampleFinalExam
 */
public class ArrayListFrog
{
    // Step 3: Declare an instance variable for
    //         the array list to be managed
    private ArrayList<Frog> list;
    
    // Step 4: Complete the first constructor
    /**
     * Constructs an ArrayListFrog object by initializing
     * the instance variable to the passed in array list.
     * 
     * @param list the array list of class Frog
     *        to be managed
     */
    public ArrayListFrog(ArrayList<Frog> list)
    {
        this.list = list;
    }

    // Step 5: Complete the second constructor
    /**
     * Constructs an ArrayListFrog object by creating
     * a new empty array list of class Frog.
     */
    public ArrayListFrog()
    {
        list = new ArrayList<Frog>();
    }

    // Step 6: Complete method add()
    /**
     * Adds a frog to the array list at a specified 
     * position if the specified index is valid and 
     * does nothing otherwise.
     *
     * @param index the specified position to add 
     * @param frog the frog to be added
     */
    public void add(int index, Frog frog)
    {
        if (index >= 0);
        list.add(index, frog);
    }
    
    // Step 7: Complete method delete()
    /**
     * Deletes and returns the frog at the specified position
     * if index is valid and does nothing otherwise.
     * 
     * @param index the index of the frog to be deleted 
     *        from the array list
     * @return the frog deleted if index is valid
     *         null if the index is invalid
     */
    public Frog delete(int index)
    {
        if (index >= 0 && index < list.size())
        {
            Frog removedFrog = list.get(index);
            list.remove(index);
            return removedFrog;
        }
        return null;
    }
    
    // Step 8: Complete method swap()
    /**
     * Swaps two frogs at specified positions in the array
     * list if both index1 and index2 are valid and does
     * nothing otherwise.
     * 
     * Use only one temporary variable.
     * 
     * @param index1 the index of the first frog to be swapped
     * @param index2 the index of the second frog to be swapped
     */
    public void swap(int index1, int index2)
    {
        if (index1 >= 0 && index2 >= 0 && index1 < list.size() && index2 < list.size())
        {
            Frog temp = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, temp);
        }
    }

    // Step 9: Override method toString()
    /**
     * Gets a string representation for the array list.
     * 
     * @return the string returned by the toString() method
     *         on the array list
     */
    @Override
    public String toString()
    {
        return list.toString();
    }

    // Step 10: Complete method firstInTheRange()
    /**
     * Gets the first frog in the array list whose weight 
     * is in the range of [lowLimit, highLimit].
     * 
     * You should use the enhanced for loop.
     * You should call method Double.compare() to compare the weights.
     * 
     * @param lowLimit the low limit of the specified range
     * @param highLimit the high limit of the specified range
     * @return the first frog whose weight is in the specified range
     *         null if no such frog in the array list
     */
    public Frog firstInTheRange(double lowLimit, double highLimit)
    {
        for (Frog frog: list)
        {
            if (frog.getWeight() >= lowLimit && frog.getWeight() <= highLimit)
            return frog;
        }
        return null;
    }
    
    // Step 11: Complete method sort()
    /**
     * Calls a static method to sort the array list.
     */
    public void sort()
    {
        Collections.sort(list);
    }
}