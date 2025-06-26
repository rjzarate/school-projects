import java.util.Scanner;
/**
 * A Java program to calculate the payment for an ice cream shop.
 * There are two types of ice cream, Plain and Waffle, and each
 * type is sold for one or two scoops.
 * 
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 09-27-2022
 */
public class IceCreamShop
{
    public static final double ONE_SCOOP_PLAIN_CONE = 1.75;
    public static final double ONE_SCOOP_WAFFLE_CONE = 2.50;  
    public static final double TWO_SCOOP_PLAIN_CONE = 2.25;
    public static final double TWO_SCOOP_WAFFLE_CONE = 2.75;
    public static final int PLAIN_CONE = 1;
    public static final int WAFFLE_CONE = 2;
      
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter 1 for Plain or 2 for Waffle: ");
        
        // Step 2: Fill in the if condition that the next
        //         input token is not an integer
        if (!in.hasNextInt())
        {
            // Step 3: Read in the next input to a string variable
            String failed1 = in.nextLine();
            failed1 = failed1.trim();
            // Step 4: Display a message on one line
            // Sample message (assuming the input was "two")
            // Invalid type: two
            System.out.println("Invalid type: " + failed1);
            // Step 5: Display the following meesage on one line
            // Program terminated.
            
            System.out.println("Program terminated.");
            
            // Step 6: Terminate the program
            return;
        }
        
        // Step 7: Read in the next integer to an int variable
        int int1 = in.nextInt();

        // Step 8: Fill in the condition that the input
        //         number is less than 1 or larger than 2
        if (int1 < 1 || int1 > 2)   
        {
            // Step 9: Display a message on one line
            // Sample message (assuming the input was 3)
            // Invalid type: 3
            System.out.println("Invalid type: " + int1);
            
            // Step 10: Display the following meesage on one line
            // Program terminated.
            System.out.println("Program terminated.");
            
            // Step 11: Terminate the program
            return;
        }
        
        System.out.print("How many scoops (1 or 2): ");
        
        // Step 12: Fill in the if condition that the next
        //          input token is not an integer
        if (!in.hasNextInt())
        {
            // Step 13: Read in the next input to a string variable
            String failed2 = in.nextLine();
            
            // Step 14: Display a message on one line
            // Sample message (assuming the input was "two")
            // Invalid scoops: two
            System.out.println("Invalid scoops: " + failed2);
            
            // Step 15: Display the following meesage on one line
            // Program terminated.
            System.out.println("Program terminated.");
            
            // Step 16: Terminate the program
            return;
        }
        
        // Step 17: Read in the next integer to an int variable
        int int2 = in.nextInt();

        // Step 18: Fill in the condition that the input
        //          number is less than 1 or larger than 2
        if (int2 < 1 || int2 > 2)
        {
            // Step 19: Display a message on one line
            // Sample message (assuming the input was 3)
            // Invalid type: 3
            System.out.println("Invalid scoops: " + int2);
            
            // Step 20: Display the following meesage on one line
            // Program terminated.
            System.out.println("Program terminated.");
            
            // Step 21: Terminate the program
            return;
        }
        
        double payment = 0;

        // Step 22: Use nested if statements to calculate 
        //          the payment using the defined constants.
        // ONE_SCOOP_PLAIN_CONE = 1.75;
        // ONE_SCOOP_WAFFLE_CONE = 2.50;  
        // TWO_SCOOP_PLAIN_CONE = 2.25;
        // TWO_SCOOP_WAFFLE_CONE = 2.75;
        // PLAIN_CONE = 1
        // WAFFLE_CONE = 2
        if (int1 == 1)
        {
            if (int2 == 1)
            {
                payment = ONE_SCOOP_PLAIN_CONE;
            }
            else
            {
                payment = TWO_SCOOP_PLAIN_CONE;
            }
        }
        if (int1 == 2)
        {
            if (int2 == 1)
            {
                payment = ONE_SCOOP_WAFFLE_CONE;
            }
            else
            {
                payment = TWO_SCOOP_WAFFLE_CONE;
            }
        }

        
                
        // Step 23: Display the payment with a dollar sign and
        //          two decimal digits
        System.out.printf("Your payment is $%.2f.", payment);

    }
}
