// Step 1: Import the Scanner class for input
import java.util.Scanner;
/**
 * A Java program to computer the double average of three integers.
 * 
 * Step 2: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 09-15-2022
 */
public class AverageOfThreeIntegers
{
    public static void main(String[] args)
    {
        final int COUNT_OF_NUMBERS = 3;
        
        // Step 3: Declare an int variable sum with an initial value of zero
        int sum = 0;


        // Step 4: Declare a Scanner object to read input from the keyboard
        Scanner in = new Scanner(System.in);
        
        // Step 5: Display an input prompt "Enter the first integer: "
        System.out.print("Enter the first integer: ");
        
        // Step 6: Read in an integer and store it in an int variable intNum
        int intNum = in.nextInt();

        // Step 7: Add the input integer to sum
        sum = sum + intNum;
        
        // Step 8: Display an input prompt "Enter the second integer: "
        System.out.print("Enter the second integer: ");

        // Step 9: Read in an integer and store it in intNum
        intNum = in.nextInt();

        // Step 10: Add the input integer to sum
        sum = sum + intNum;
        
        // Step 11: Display an input prompt "Enter the third integer: "
        System.out.print("Enter the third integer: ");
        
        // Step 12: Read in an integer and store it in intNum
        intNum = in.nextInt();

        // Step 13: Add the input integer to sum
        sum = sum + intNum;
        
        // Step 14: display the integer sum of the three integers
        // Sample output assuming the sum is 10
        //     "The sum of the three integers is 10."
        System.out.println("The sum of the three integers is " + sum + ".");
       
        // Step 15: Compute and display the double average of the three integers
        // Sample output assuming the average is 3.3333333333333335
        //     "The average of the three integers is 3.3333333333333335."
        System.out.println("The average of the three integers is " 
                            + (double) (sum / 3.0) + ".");
    }
}
