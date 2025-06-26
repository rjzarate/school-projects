// Step 1: import Java class Scanner
import java.util.Scanner;
/**
 * A Java program to input a payment for the membership of a golf club
 * then calculate the bonus and the total balance based on the payment.
 *
 * Step 2: Enter your name for @author and the password for @version.
 * @author  Froilan Zarate
 * @version MyLastExam
 */
public class MembershipBalance
{
    public static void main(String[] args)
    {
        final double HIGH_BONUS_AMOUNT = 200.0;
        final double HIGH_BONUS_RATE = 0.15;    // for 15%
        final double REG_BONUS_RATE = 0.1;      // for 10%
    
        // Step 3: Create a Scanner object to get input from the screen
        Scanner in = new Scanner(System.in);
        
        // Step 4: Ask for the payment using prompt "Enter your payment: "
        System.out.print("Enter your payment: ");

        // Step 5: While the next input token is not a double number
        //              Read the input 
        //              Display a message on one line: Invalid payment: Exam
        //                  (assuming the input is Exam)
        //              Ask for the payment again using the same prompt
        // You should call a method on the Scanner object to check the input
        while (!in.hasNextDouble())
        {
            System.out.println("Invalid payment: " + in.next());
            System.out.print("Enter your payment: ");
        }
        
        // Step 6: Read in the payment and save it in a variable
        double payment = in.nextDouble();

        // Step 7: If the payment is not positive
        //              Display a message on one line: Invalid payment: 0.0
        //                  (assuming the payment is 0)
        //              Terminate the program
        if (payment <= 0)
        {
            System.out.println("Invalid payment: " + payment);
            return;
        }
    
        // Step 8: Declare a double variable then calculate 
        //         the bonus and save it in the variable
        // The bonus is REG_BONUS_RATE (10%) of the payment if 
        // the payment is less than HIGH_BONUS_AMOUNT and 
        // HIGH_BONUS_RATE (15%) of the payment otherwise.
        // No magic numbers!
        double bonus = 0;
        if (payment < HIGH_BONUS_AMOUNT)
        {
            bonus = payment * REG_BONUS_RATE;
        } else
        {
            bonus = payment * HIGH_BONUS_RATE;
        }

        // Step 9: Display the payment, bonus, and total balance
        //         on separate lines. The total balance is the
        //         sum of the payment and the bonus.
        // Sample output:
        // Your Payment is $200.00.
        // Your Bonus is $30.00.
        // Your Total Balance is $230.00.
        System.out.printf("Your Payment is $%.2f.%n", payment);
        System.out.printf("Your Bonus is $%.2f.%n", bonus);
        System.out.printf("Your Total Balance is $%.2f.%n", payment + bonus);
        
    }
}
