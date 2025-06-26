import java.util.Random;
import java.util.Arrays;
/**
 * Manages a 2-D array of Frog.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 11-03-2022
 */
public class Frog2DArray
{
    // Step 2: Declare one instance variable for the 2-D array of Frog
    private Frog[][] frog2D;

    // Step 3: Complete the constructor
    /**
     * Constructs an object of class Frog2DArray by initializing
     * the instance variable to the passed in parameter.
     * 
     * @param array a 2-D array filled with frog objects
     */
    public Frog2DArray(Frog[][] array)
    {
        frog2D = array;
    }

    /**
     * Constructs a new object of class Frog2DArray by creating
     * a 2-D array of Frog of the specified rows and cols, then
     * creating a Random object using the specified seed and 
     * filling the array with frogs of random weight in the range
     * of [1, maxWeight] generated using the random generator.
     * 
     * @param rows the number of rols of the 2-D array
     * @param cols the columns of the 2-D array
     * @param seed the seed of the random fenerator
     * @param maxWeight the max weight of the frogs to generate
     */
    public Frog2DArray(int rows, int cols, int seed, int maxWeight)
    {
        frog2D = new Frog[rows][cols];
        Random generator = new Random(seed);
        for (int row = 0; row < rows; row ++)
            for (int col = 0; col < cols; col ++)
            {
                int weight = generator.nextInt(maxWeight) + 1;
                frog2D[row][col] = new Frog(weight);
            }
    }

    // Step 4: Complete method averageWeight() according to
    //         the comment
    /**
     * Gets the average weight of all frogs in the array.
     * 
     * You should use nexted enhanced for loops
     *
     * @return the average weight of all frogs in the array
     */
    public double averageWeight()
    {
        double weight = 0;
        double frogs = 0;
        for (Frog[] row: frog2D)
        {
            for (Frog col: row)
            {
                weight += col.getWeight();
                frogs ++;
            }
        }
        if (frogs != 0)
        {
            return weight /= frogs;
        } else
        {
            return 0;
        }
    }
    
    // Step 5: Complete method countOfFrogsInRange() according to
    //         the comment
    /**
     * Gets the number of frogs in the array with a weight in
     * the specified range.
     * 
     * You should use nexted enhanced for loops
     *
     * @param lowLimit the low limit of the range
     * @param highLimit the high limit of the range
     * @return the number of frogs with a weight in the range
     */
    public int countOfFrogsInRange(int lowLimit, int highLimit)
    {
        int frogs = 0;
        for (Frog[] row: frog2D)
        {
            for (Frog col: row)
            {
                if (col.getWeight() >= lowLimit && col.getWeight() < highLimit)
                {
                    frogs ++;
                }
            }
        }
        return frogs;
    }
    
    // Step 6: Complete method firstFrogInRangeInARow according to
    //         the comment
    /**
     * Gets the first frog in the specified row with a weight
     * in the specified range.
     * 
     * You should use the enhanced for loop
     *
     * @param rowIndex the index of the specified row
     *        (Assuming the index is valid)
     * @param lowLimit the low limit of the range
     * @param highLimit the high limit of the range
     * @return the first frog in the row with a weight in the range
     *         null if the row has no frogs with a weight in the range
     */
    public Frog firstFrogInRangeInARow(int rowIndex, int lowLimit, int highLimit)
    {
        
        for (Frog col: frog2D[rowIndex])
        {
            if (col.getWeight() >= lowLimit && col.getWeight() < highLimit)
            {
                return col;
            }
        }
        return null;
    }
    
    // Step 7: Complete method lastFrogInRangeInAColumn according to
    //         the comment
    /**
     * Gets the last frog in the specified column with a weight
     * in the specified range.
     * 
     * @param colIndex the index of the specified column
     *        (Assuming the index is valid)
     * @param lowLimit the low limit of the range
     * @param highLimit the high limit of the range
     * @return the last frog in the column with a weight in the range
     *         null if the column has no frogs with a weight in the range
     */
    public Frog lastFrogInRangeInAColumn(int colIndex, int lowLimit, int highLimit)
    {
        boolean foundFrog = false;
        Frog frog = new Frog(0);
        for (Frog[] row: frog2D)
        {
            if (row[colIndex].getWeight() > lowLimit && row[colIndex].getWeight() < highLimit)
            {
                frog = row[colIndex];
                foundFrog = true;
            }
        }
        
        if (foundFrog == true)
        {
            return frog;
        } else
        {
            return null;
        }
    }
    
    /**
     * Gets a string representation for the 2-D array of frogs.
     * 
     * @return a string for the 2-D array in the following format:
     * [Rows:3, Cols:2]
     * [Frog[Weight:2,Legs:0], Frog[Weight:6,Legs:2]]
     * [Frog[Weight:7,Legs:2], Frog[Weight:26,Legs:4]]
     * [Frog[Weight:21,Legs:4], Frog[Weight:16,Legs:2]]
     */
    @Override
    public String toString()
    {
        int rows = frog2D.length;
        int cols = frog2D[0].length;
        String s = "[Rows:" + rows + ", Cols:" + cols + "]\n";
        for (Frog[] row: frog2D)
            s += Arrays.toString(row) + "\n";
            
        return s;
     }
}
