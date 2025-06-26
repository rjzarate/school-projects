import java.util.Scanner;
import java.lang.Math;
/**
 * The Java program asks for a positive integer from the 
 * user then calculates and displays the sum of square 
 * roots of all positive integers from 1 to the input
 * number, inclusive.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 10-04-2022
 */
public class SumOfSqrt
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = in.nextInt();

        // Step 2: Declare a double variable sum with
        //         an initial value of zero
        double sum = 0;
        
        // Step 3: Use a while loop to add square roots of
        //         all integers from 1 to num, inclusive,
        //         to sum.
        // You can have an additional variable if needed.
        while (num >= 1)
        {
            sum = sum + Math.sqrt(num);
            num --;
        }
            
        // Step 4: Display the sum on one line with 6 decimal digits
        // Sample output for num = 5
        // The sum of square roots: 8.382332.
        System.out.printf("The sum of square roots: %.6f.", sum);
        
    }
}
