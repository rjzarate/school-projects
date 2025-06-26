import java.util.Scanner;
/**
 * The program reads in an integer as the count of valus 
 * then reads in the specified count of double values 
 * and find the largest and smallest values among all 
 * input values. 
 * You can assume there is at least one input value.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 10-13-2022
 */
public class MaxMinAtLeastOneValue
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        // Step 2: Read in an integer as the count of double values
        //         with an input prompt "Enter the count of values: "
        //         and store it in a variable
        System.out.print("Enter the count of values: ");
        int count = in.nextInt();

        
        // Step 3: Read in a double value with an input prompt 
        //         "Enter the first value: "
        //         and store it in a variable max
        System.out.print("Enter the first value: ");
        double max = in.nextDouble();

        
        // Step 4: Assign the value of max to another  
        //         variable min
        double min = max;

        
        // Step 5: Use a for loop to read all remaining
        //         double values with an input prompt
        //          "Enter the next value: "
        //         and update max and min
        double value;
        for (int i = count; i > 1; i --)
        {
            System.out.print("Enter the next value: ");
            value = in.nextDouble();
            if (value > max)
            {
                max = value;
            } else if (value < min)
            {
                min = value;
            }
        }

        
        // Step 6: Display the count, the max and min values
        //         with 6 decimal digits
        //              Sample output
        //              Count of values: 3.
        //              Largest value  : 8.001240.
        //              Smallest value : 5.230000.
        System.out.printf("Count of values: %d.%nLargest value  : %.6f.%nSmallest value : %.6f.", count, max, min);

    }
}
