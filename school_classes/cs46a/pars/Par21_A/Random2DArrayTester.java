/**
 * Input an odd integer as the seed to create a Random 
 * object and fill a 2-D array of integers with random
 * values in a specified range, then compute the average 
 * value of all elements and the max value of a column.
 *
 * @author  Qi Yang
 * @version 2022-11-17
 */
public class Random2DArrayTester
{
    public static void main(String[] args)
    {
        int[][] array123 = { {1, 2, 3, 4, 5, 6, 7},
                             {2, 3, 4, 5, 6, 7, 8},
                             {3, 4, 5, 6, 7, 8, 9} };
                             
                            
        Random2DArray arrayOne = new Random2DArray(array123);
        
        Random2DArray arrayTwo = new Random2DArray(5, 11, 123);
        
        Random2DArray arrayThree = new Random2DArray(11, 5, -123);

        int rowIndex = 0;
        
        double average = arrayOne.rowAverage(rowIndex);
        System.out.printf("The row average: %.2f.%n", average);
        System.out.println("Expected: 4.00.");
        
        average = arrayTwo.rowAverage(rowIndex);
        System.out.printf("The row average: %.2f.%n", average);
        System.out.println("Expected: -0.36.");
        
        average = arrayThree.rowAverage(rowIndex);
        System.out.printf("The row average: %.2f.%n", average);
        System.out.println("Expected: -7.40.");

        int colIndex = 2;
        average = arrayOne.colAverage(colIndex);
        System.out.printf("The column average: %.2f.%n", average);
        System.out.println("Expected: 4.00.");
        
        average = arrayTwo.colAverage(colIndex);
        System.out.printf("The column average: %.2f.%n", average);
        System.out.println("Expected: 1.00.");
        
        average = arrayThree.colAverage(colIndex);
        System.out.printf("The column average: %.2f.%n", average);
        System.out.println("Expected: -2.00.");

        average = arrayOne.arrayAverage();
        System.out.printf("The average of the 2-D array: %.2f.%n", average);
        System.out.println("Expected: 5.00.");
        
        average = arrayTwo.arrayAverage();
        System.out.printf("The average of the 2-D array: %.2f.%n", average);
        System.out.println("Expected: -1.31.");
        
        average = arrayThree.arrayAverage();
        System.out.printf("The average of the 2-D array: %.2f.%n", average);
        System.out.println("Expected: -0.27.");

    }
}
