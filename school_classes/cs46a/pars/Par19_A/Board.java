import java.util.Arrays;
import java.util.Scanner;
/*
 * A Java program to fill out and print a two-dimensional
 * board of 0s and 1s.
 * 
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 11-03-2022
 */
public class Board
{
    public static void main(String[] args)
    {
        // Step 2: Create a Scanner object to input data from the keyboard
        Scanner in = new Scanner(System.in);
        
        
        // Step 3: Read an integer as the number of rows and save it in a variable
        //         Prompt: "Enter an integer as the number of rows: "
        System.out.print("Enter an integer as the number of rows: ");
        int rows = in.nextInt();
        
        // Step 4: Read an integer as the number of columns and save it in a variable
        //         Prompt: "Enter an integer as the number of columns: "
        System.out.print("Enter an integer as the number of columns: ");
        int cols = in.nextInt();

        // Step 5: Create a 2-D array of integers of the specified rows and columns
        int[][] twoDArray = new int[rows][cols];

        // Step 6: For each element of the 2-D array
        //             Compute the sum of the row index and column index
        //             Set the element to 1 if the sum is an odd number
        //                             to 0 otherwise
        // Sample 2-D array
        // [0, 1, 0, 1, 0, 1, 0, 1]
        // [1, 0, 1, 0, 1, 0, 1, 0]
        // [0, 1, 0, 1, 0, 1, 0, 1]
        for (int row = 0; row < rows; row ++)
        {
            for(int col = 0; col < cols; col ++)
            {
                twoDArray[row][col] = (row + col) % (1 + 1);
                //System.out.print((row + col) % (1 + 1));
            }
            //System.out.println("");
        }

        // Step 7: Use the enhanced for loop to print the entire 2-D 
        //         array by calling method Arrays.toString() on each
        //         row of the board 
        for (int[] row: twoDArray)
        {
            System.out.println(Arrays.toString(row));
        }
    }
}