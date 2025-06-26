// Step 1: Import class Scanner
import java.util.Scanner;
/**
 * A Java program to calculate the discount based on
 * the amount of payment.
 *
 * Step 2: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version MyExamOne
 */
public class FinalPayment
{
    public static double HIGH_DISCOUNT_MIN_AMOUNT = 100.0;
    public static double HIGH_DISCOUNT_PERCENTAGE = 0.20;
    public static double NORMAL_DISCOUNT_PERCENTAGE = 0.10;
    
    public static void main(String[] args)
    {
        // Step 3: Create a Scanner object to input value from the keyboard
        Scanner in = new Scanner(System.in);
        
        // Step 4: Display an input prompt "Enter your payment: "
        System.out.print("Enter your payment: ");
        
        // Step 5: If the next input token is not a double number
        //              Read in the next input token
        //              Display a message on one line
        //                  Sample message assuming the input is "EAGLE"
        //                  "Invalid payment: EAGLE."
        //              Terminate the program
        if (!in.hasNextDouble())
        {
            String failedIn = in.nextLine();
            failedIn = failedIn.trim();
            System.out.print("Invalid payment: " + failedIn + ".");
            return;
        }

        
        // Step 6: Read in the payment and store it in a variable
        
        double payment = in.nextDouble();
        
        // Step 7: If the input payment is not positive
        //              Display a message on one line 
        //                  Sample message assuming the input payment is -100
        //                  "Payment must be positive: -100.0."
        //              Terminated the program
        if (payment <= 0)
        {
            System.out.print("Payment must be positive: " + payment + ".");
            return;
        }

        
        // Step 8: Declare a double variable discount with an initial value of 0
        double discount = 0;

        
        // Step 9: If payment is at least HIGH_DISCOUNT_MIN_AMOUNT 
        //              Set discount to the product of payment and HIGH_DISCOUNT_PERCENTAGE
        //         Otherwise
        //              Set discount to the product of payment and NORMAL_DISCOUNT_PERCENTAGE
        if (payment >= HIGH_DISCOUNT_MIN_AMOUNT)
        {
            discount = payment * HIGH_DISCOUNT_PERCENTAGE;
        } else
        {
            discount = payment * NORMAL_DISCOUNT_PERCENTAGE;
        }
        
        // Step 10: Display the payment, the discount, and the final payment 
        //          The final payment is the difference of the original payment 
        //          and the discount
        //              Sample output 
        //              Your original payment is $99.99.
        //              Your discount is $10.00.
        //              Your final payment is $89.99.
        double finalPayment = payment - discount;
        System.out.printf("Your original payment is $%.2f.%n", payment);
        System.out.printf("Your discount is $%.2f.%n", discount);
        System.out.printf("Your final payment is $%.2f.%n", finalPayment);
    }
}
