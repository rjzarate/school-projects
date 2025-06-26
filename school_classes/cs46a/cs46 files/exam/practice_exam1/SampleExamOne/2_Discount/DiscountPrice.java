// Step 1: import Java class Scanner
import java.util.Scanner;
/**
 * Ask the user for product name, its original price,
 * and the discount rate, then calculate and display
 * the discount price for the product.
 *
 * Step 2: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version SampleExamOne
 */
public class DiscountPrice
{
    public static void main(String[] args)
    {
        // Step 3: Create a Scanner object to get
        //         input from the keyboard
        Scanner in = new Scanner(System.in);


        // Step 4: Ask for the product name using prompt 
        //                 "Enter the product name: " 
        //         Read in the product name and store it in a
        //            variable after removing spaces from both ends
        //         Note: The product name could have multiple words
        //               such as "iPad Pro"
        System.out.print("Enter the product name: ");
        String productName = in.nextLine();
        String productNameTrimmed = productName.trim();

        
        // Step 5: Ask for the original price using prompt
        //                 "Enter the original price: "
        //         If the next input token is not a double number
        //            Read in the input
        //            Display a message on one line 
        //                   Sample message assuming the input is "Apple"
        //                  "Invalid price: Apple."
        //            Display a message on one line
        //                  "Program terminated."
        //            Terminate the program
        System.out.print("Enter the original price: ");
        if (!in.hasNextDouble())
        {
            String notDouble = in.nextLine();
            String notDoubleTrimmed = notDouble.trim();
            System.out.println("Invalid price: " + notDoubleTrimmed + ".");
            System.out.println("Program terminated.");
            return;
        }

        
        // Step 6: Read in the price and store it in a double variable
        double price = in.nextDouble();


        // Step 7: Ask for the discount rate using prompt 
        //             "Enter the discount rate: "
        //         Read in the discount rate and store it in a double variable
        //         If the discount rate is not positive
        //             Display a message on one line 
        //                   Sample message assuming the input is "-0.05"
        //                  "Discount rate must be positive: -0.05."
        //             Display a message on one line
        //                  "Program terminated."
        //             Terminate the program
        System.out.print("Enter the discount rate: ");
        double discount = in.nextDouble();
        if (discount <= 0)
        {
            System.out.println("Discount rate must be positive: " + discount + ".");
            System.out.println("Program terminated.");
            return;
        }
        
        // Step 8: Calculate the discount price
        //    discount price = price * (1 - discount rate)
        double discountPrice = price * (1 - discount);
        
        // Step 9: Display the product name within double quotes 
        //         and the discount price with a dollar sign and
        //         two decimal digits
        // Sample output: 
        // The discount price for "iPad Pro" is $343.99.
        System.out.print("The discount price for \"" + productNameTrimmed + "\" is $");
        System.out.printf("%.2f.", discountPrice);
        
    }
}
