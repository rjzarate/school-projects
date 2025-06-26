import java.util.Scanner;
/**
 * Use a while loop to read in integers until an 
 * integer of -500 is read, then display the 
 * count of input values and the double average 
 * of all input values.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 10-11-2022
 */
public class AverageWithSentinel
{
    public static final int END_OF_INPUT = -500;
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        // Step 2: Declare an int variable with an initial value
        //         as the count of input integers
        int countIntegers = 0;
        
        // Step 3: Declare a double variable with an initial value
        //         as the total of all input integers
        double addedIntegers = 0;
        
        // Step 4: Display an input prompt 
        //         "Enter an integer, -500 to stop: "
        System.out.print("Enter an integer, -500 to stop: ");

        // Step 5: Read an integer and store it in an int variable
        int input = in.nextInt();
        
        // Step 6: Use a while loop to update count and total as long as
        //         the input value is not -500.
        //         Then display the same prompt and read the next integer
        while (input != END_OF_INPUT)
        {
            countIntegers ++;
            addedIntegers = addedIntegers + input;
            System.out.print("Enter an integer, -500 to stop: ");
            input = in.nextInt();
        }
        

        // Step 7: If count is zero 
        //             Display the following message 
        //                  "No integers were entered."
        //         Otherwise 
        //             Display the count and the double average of
        //                  all input integers with 4 decimal digits
        //                  Sample output
        //                  "The average of the 3 integers is 8.3333."
        if (countIntegers == 0)
        {
            System.out.print("No integers were entered.");
        } else
        {
            System.out.printf("The average of the %d integers is %.4f.", countIntegers, addedIntegers / (double) countIntegers);
        }
        
    }
}
