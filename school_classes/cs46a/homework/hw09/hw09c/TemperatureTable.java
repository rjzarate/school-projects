
/**
 * Manages a 2-D array of integers representing these temperature tables
 * 
 * @author  Froilan Zarate
 * @version 11-01-2022
 */
public class TemperatureTable
{
    // instance variables - replace the example below with your own
    private int[][] intArray;

    /**
     * Constructor for objects of class TemperatureTable
     * 
     * @param temperatureTable  the array
     */
    public TemperatureTable(int[][] temperatureTable)
    {
        intArray = temperatureTable;
    }

    /**
     * Gets the average of the specified column.
     *
     * @param  colIndex  the column index
     * @return  the average
     */
    public double columnAverage(int colIndex)
    {
        double average = 0;
        double count = intArray.length;
        for (int[] integer: intArray)
        {
            average += integer[colIndex];
        }
        
        
        
        return average / count;
    }
    
    /**
     * Gets the largest value of the specified row.
     *
     * @param  rowIndex  the row index
     * @return  the largest value
     */
    public int rowMax(int rowIndex)
    {
        int value = intArray[rowIndex][0];
        
        for (int integer: intArray[rowIndex])
        {
            if (value < integer)
            {
                value = integer;
            }
        }
        return value;
    }
    
    /**
     * Gets the value that is
     * larger than the specified limit, has the max row index among all values larger than the
     * specified limit, and has the smallest column index among all such values in the row.
     * Returns the limit if no values in the 2-D array is larger than the limit.
     *
     * @param  limit  the limit
     * @return  the value
     */
    public int largerValueInMaxRowMinColumn(int limit)
    {
        //let i be the index starting at the end
        for (int i = intArray.length - 1; i >= 0; i --)
        {
            for (int integer: intArray[i])
            {
                if (integer > limit)
                {
                    return integer;
                }
            }
        } 
        
        
        return 0;
    }
}
