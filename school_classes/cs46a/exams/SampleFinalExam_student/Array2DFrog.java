/**
 * Store a 2-D array of class Frog and retrieve 
 * information from the 2-D array.
 *
 * Step 1: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version SampleFinalExam
 */
public class Array2DFrog
{
    // Step 2: Declare one instance variable to
    //         store a 2-D array of Frog.
    private Frog[][] array;
    
    // Step 3: Complete the constructor
    /**
     * Constructor for objects of class Array2DFrog.
     * 
     * @param array a 2-D array of class Frog 
     */
    public Array2DFrog(Frog[][] array)
    {
        this.array = array;
    }

    // Step 4: Complete method averageWeight()
    /**
     * Gets the average weight of all frogs in the 2-D array.
     * We assume the 2-D array is not empty and not partial.
     *
     * You should use nested enhanced for loops.
     * DO NOT calculate the count in the nested for loops.
     * 
     * @return the average weight of all frogs in the
     *         2-D array
     */
    public double averageWeight()
    {
        double weight = 0;
        double count = 0;
        for (Frog[] frogList: array)
        for (Frog frog: frogList)
        {
            weight += frog.getWeight();
            count ++;
        }
        return weight / count;
    }
    
    // Step 5: Complete method lastInTheRangeOfARow()
    /**
     * Gets the last frog in the specified row whose weight
     * is in the range of [low, high].
     * We assume the 2-D array is not empty and not partial.
     * We also assume the index is valid.
     * 
     * You should stop execution and return the frog after
     * finding the frog satisfying the condition.
     * 
     * @param rowIndex the row index of the specified row
     * @param low the low limit of the range
     * @param high the high limit of the range
     * @return the last frog in the specified row whose weight 
     *             is in the range of [low, high]
     *         null if no such frog in the specified row
     */
    public Frog lastInTheRangeOfARow(int rowIndex, double low, double high)
    {
        for (int i = array[rowIndex].length - 1; i >= 0; i --)
        {
            if (array[rowIndex][i].getWeight() >= low && array[rowIndex][i].getWeight() <= high)
            {
                return array[rowIndex][i];
            }
        }
        return null;
    }
    
    // Step 6: Complete method maxOfACol()
    //         Make sure you compare double values using the
    //         correct approach.
    /**
     * Gets the first frog with the max weight among all frogs 
     * in a specified column.
     * We assume the 2-D array is not empty and not partial.
     * We also assume the index is valid.
     * 
     * @param colIndex the index of the specified column
     * @return the first frog with the max weight among all frogs 
     *             in the specified column
     */
    public Frog maxOfACol(int colIndex)
    {
        Frog frog = array[0][colIndex];
        
        for (Frog[] frogList: array)
        {
            if (frogList[colIndex].getWeight() > frog.getWeight())
            frog = frogList[colIndex];
        }
        return frog;
    }
}