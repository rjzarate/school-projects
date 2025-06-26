/**
 * The Java class stores a 2-D array of int and provides
 * some operations to rectrieve information from it.
 *
 * Step 1: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version F2022ExamTwo
 */
public class TwoDArray
{
    // Step 2: Declare a 2-D array of int as the instance variable
    private int[][] intArray;
    
    // Step 3: Complete the constructor
    /**
     * Constructs an object of class TwoDArray by
     * initializing the instance variable to the
     * parameter 2-D array.
     * 
     * @param theArray the 2-D array of int to store
     */
    public TwoDArray(int[][] theArray)
    {
        intArray = theArray;
    }
    
    // Step 4: Complete method rowMax() 
    /**
     * Gets the largest number in a specified row
     * assuming the row index is valid. 
     * 
     * You should use the enhanced for loop.
     * 
     * @param  rowIndex the index of the specified row
     * @return the largest number in the specified row
     */
    public int rowMax(int rowIndex)
    {
        //if (rowIndex >= 0 && rowIndex < intArray[rowIndex].length)
        //{
        //    return null;
        //}
        
        int rowMax = intArray[rowIndex][0];
        for (int integer: intArray[rowIndex])
        {
            if (rowMax < integer)
            {
                rowMax = integer;
            }
        }
        return rowMax;
    }
    
    // Step 5: Complete method columnAverage()
    /**
     * Calculates the double average of a specified column
     * assuming the given column index is valid. 
     *      
     * @param colIndex the index of the specified column 
     * @return the double average of the specified column
     */
    public double columnAverage(int colIndex)
    {
        double average = 0;
        for (int[] integerRow: intArray)
        {
            average += integerRow[colIndex];
        }
        return average / intArray.length;
    }
    
    // Step 6: Complete method countInRange()
    /**
     * Finds and returns the count of elements of the 
     * array that are within the specified range of
     * [lowLimit, highLimit].
     * 
     * You should use nested enhanced for loops.
     * 
     * @param lowLimit the low limit of the range
     * @param highLimit the high limit of the range
     * @return the count of elements within the range
     */
    public int countInRange(int lowLimit, int highLimit)
    {
        int count = 0;
        for (int[] integerRow: intArray)
        {
            for (int integer: integerRow)
            {
                if (integer >= lowLimit && integer <= highLimit)
                {
                    count ++;
                }
            }
        }
        return count;
    }
}