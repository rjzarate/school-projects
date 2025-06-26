// Step 1: Import class Scanner
import java.util.Scanner;
/**
 * A Java program to calculate the total cost
 * for purchasing a vehicle from a dealer in 
 * San Jose, CA.
 *
 * Step 2: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version F2022ExamTwo
 */
public class CostCalculator
{
    public static void main(String[] args)
    {
        final double TAX_RATE = 0.08;
        final double ALL_FEE = 450.70;
    
        // Step 3: Create a Scanner object to read input 
        //         from the keyboard
        Scanner in = new Scanner(System.in);

        
        // Step 4: Ask the user to enter a double value for price
        //             using prompt "Enter the price: "
        //         While the input is not a double number
        //             Read the input 
        //             Display a message on oneline
        //                  Sample message assuming the input is "Ford"
        //                  "Invalid price: Ford"
        //             Prompt for the price again
        System.out.print("Enter the price: ");
        while (!in.hasNextDouble())
        {
            
            System.out.println("Invalid price: " + in.next());
            System.out.print("Enter the price: ");
        }
        
        // Step 5: Read in a double value as price and save it in a variable
        double price = in.nextDouble();


        // Step 6: If the input price is not positive
        //            Display a message on one line
        //                Sample message assuming the input price is -45050
        //                "Price must be positive: -45050.0"
        //            Terminate the program
        if (price <= 0)
        {
            System.out.print("Price must be positive: " + price);
            return;
        }


        // Step 7: Calculate the sales tax and store it in a variable
        //         The sales tax is the product of the price and the
        //         TAX_RATE
        double salesTax = price * TAX_RATE;

        
        // Step 8: Display the price, tax, total fee, and the 
        //         total cost on separate lines, with a dollar 
        //         sign and two decimal digits
        //         The total cost is the sum of the price, tax
        //             and ALL_FEE
        // Sample output
        // The vehicle price is $20000.00.
        // The sales tax is $1600.00.
        // The total fee is $450.70.
        // The total cost is $22050.70.
        System.out.printf("The vehicle price is $%.2f.%n", price);
        System.out.printf("The sale tax is $%.2f.%n", salesTax);
        System.out.printf("The total fee is $%.2f.%n", ALL_FEE);
        System.out.printf("The total cost is $%.2f.", price + salesTax + ALL_FEE);

    }
}
