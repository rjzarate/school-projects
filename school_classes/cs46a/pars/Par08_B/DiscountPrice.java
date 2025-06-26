// Step 1: Import Java class Scanner
import java.util.Scanner;
/**
 * A Java application to input the name and price of
 * a product, and a discount percentage, then compute 
 * and display the discount price.
 *
 * Step 2: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 09-21-2022
 */
public class DiscountPrice
{
    public static void main(String[] args)
    {
        // Step 3: Create a Scanner object to read input
        //         from the keyboard
        Scanner in = new Scanner(System.in);
        
        
        // Step 4: Ask for the product name with prompt 
        //            "Enter the product name: "
        System.out.print("Enter the product name: ");
        
        // Step 5: Read the name of a product from the keyboard
        //         The product name could have multiple words
        String productName = in.nextLine();
        
        // Step 6: Trim spaces from both ends of the name
        String productNameTrimmed = productName.trim();
        
        // Step 7: Ask for the product price with prompt 
        //            "Enter the price: "
        System.out.print("Enter the price: ");
        
        // Step 8: Read a double number as the price of the product 
        double price = in.nextDouble();
        
        // Step 9: Ask for the discount percentage with prompt 
        //            "Enter a discount percentage: "
        System.out.print("Enter a discount percentage: ");

        // Step 10: Read a double number as the discount percentage 
        // For example, 0.1 for 10% and 0.15 for 15%.
        double discount = in.nextDouble();

        // Step 11: Display the price of the product with a dollar sign 
        //          and two decimal digits
        // Sample output:
        // The price of iPhone 11 is $749.99.
        System.out.println("The price of " + productNameTrimmed + " is $" + price + ".");
        
        // Step 12: Display the discount price of the product with 
        //          a dollar sign and two decimal digits
        // The discount price = price * (1 - discount_percentage)
        // Sample output:
        // The discount price for iPhone 11 is $674.99.
        double discountPrice = price - (discount * price);
        
        
        System.out.printf("The discount price for " + productNameTrimmed + " is $%.2f.", discountPrice);
        
    }
}
