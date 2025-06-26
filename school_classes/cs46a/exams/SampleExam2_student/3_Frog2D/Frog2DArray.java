/**
 * A Java class to manage a 2-D array of Frog.
 *
 * Step 1: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version SampleExamTwo
 */
public class Frog2DArray
{
    // Step 2: Declare a 2-D array of Frog as the instance variable
    private Frog[][] frogArray2D;
    
    // Step 3: Complete the constructor
    /**
     * Initializes the instance variable to the passed
     * in parameter.
     * 
     * @param array a 2-D array of Frog
     */
    public Frog2DArray(Frog[][] array)
    {
        frogArray2D = array;
    }

    // Step 4: Complete method rowMaxFrog()
    /**
     * Gets a frog in the specified row that has the 
     * max weight among all frogs in the same row.
     * 
     * You should use the enhanced for loop.
     * 
     * @param  rowIndex the index of the specified row
     * @return a frog with the max weight in the specified row
     */
    public Frog rowMaxFrog(int rowIndex)
    {
        Frog fattestFrog = frogArray2D[rowIndex][0];
        for (Frog frog: frogArray2D[rowIndex])
        {
            if (fattestFrog.getWeight() < frog.getWeight())
            {
                fattestFrog = frog;
            }
        }
        return fattestFrog;
    }

    // Step 5: Complete method colAverage()
    /**
     * Gets the average weight of all frogs in
     * the specified column.
     * 
     * @param  colIndex the index of the specified column
     * @return the average weight of all frogs in the specified column
     */
    public double colAverage(int colIndex)
    {
        double average = 0;
        double count = 0;
        for (Frog[] frogList: frogArray2D)
        {
            average += frogList[colIndex].getWeight();
            count ++;
        }
        return average / count;
    }
    
    // Step 6: Complete method totalCount()
    /**
     * Gets the total count of frogs in the 2-D array
     * that have the specified number of legs.
     * 
     * You should use nested enhanced for loops.
     * 
     * @param  legs the specified number of legs
     * @return the count of frogs with the specified legs
     */
    public int totalCount(int legs)
    {
        int count = 0;
        for (Frog[] frogList: frogArray2D)
        {
            for (Frog frog: frogList)
            {
                if (frog.getLegs() == legs)
                {
                    count ++;
                }
            }
        }
        return count;
    }
}
