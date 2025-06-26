import java.util.Scanner;
/**
 * The Java program tries to read a positive integer
 * and stays in a loop if the input is invalid; then
 * uses nested for loops to draw a triangle of the 
 * specified size.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 10-18-2022
 */
public class DrawingATriangle
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        // Step 2: Asking for a positive integer using prompt 
        //              "Enter a positive integer: "
        //         Read the input and save it in an int variable size 
        System.out.print("Enter a positive integer: ");
        int size = in.nextInt();


        // Step 3: While size is not positive
        //             Display a message with the integer 
        //                  sample message assuming the input is -3
        //                  "Not a positive integer: 3"
        //             Asking for a positive integer using the same prompt 
        //             Read the input and save it in size
        while (size < 1)
        {
            System.out.printf("Not a positive integer: %d%n", size);
            System.out.print("Enter a positive integer: ");
            size = in.nextInt();
        }

        
        // Step 4: Use nested for loops to draw a triangle
        // Sample output (assuming the input size is 5)
        // *
        // **
        // ***
        // ****
        // *****
        int row = 0;
        for (int col = 1; col <= size; col ++)
        {
            row = col;
            while (row >= 1)
            {
                System.out.print("*");
                row --;
            }
            System.out.printf("%n");
        }

        
    }
}
