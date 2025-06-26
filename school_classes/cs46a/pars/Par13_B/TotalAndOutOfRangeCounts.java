import java.util.Scanner;
/**
 * Read a set of integers and find the count of numbers
 * that are either less than 20 or larger than 40, then
 * display the out of range count with the total count
 * of input integers. 
 * You can assume there is at least one input integer
 * and the input ends with a 'Q' or any token that is 
 * not an integer.
 *
 * Step 1: Enter your name for @author and today's date for @version 
 * @author  Froilan Zarate
 * @version 10-13-2022
 */
public class TotalAndOutOfRangeCounts
{
    public static void main(String[] args)
    {
        final int LOW_LIMIT = 20;
        final int HIGH_LIMIT = 40;
        
        Scanner in = new Scanner(System.in);

        // Step 2: Declare variables for the two counts
        //         with initial values
        int totalCount = 0;
        int outOfRangeCount = 0;

        
        // Step 3: Display the input prompt 
        //         "Enter an integer or Q to quit: "
        System.out.print("Enter an integer or Q to quit: ");

        
        // Step 4: While the input is an integer
        //              Read the integer
        //              Update the total count
        //              If the input integer is out of the range
        //                  Update the out of range count
        //              Prompt for the next input using the same prompt
        int input;
        while (in.hasNextInt())
        {
            System.out.print("Enter an integer or Q to quit: ");
            input = in.nextInt();
            totalCount ++;
            if (input > HIGH_LIMIT || input < LOW_LIMIT)
            {
                outOfRangeCount ++;
            }
        }
        


        // Step 5: Display the two counts on separate lines
        //         starting with three spaces
        // Sample output
        //    The total count: 8.
        //    The out of range count: 4.
        System.out.printf("   The total count: %d.%n   The out of range count: %d.%n", totalCount, outOfRangeCount);

    }
}
