// Step 1: Import the Java Scanner class
import java.util.Scanner;
/**
 * The Java program inputs the original cost for a sale,
 * calculates the surcharge, and displays the original
 * cost, the surcharge, and the new cost.
 *
 * Step 2: Enter your name for @author and the password for @version.
 * @author  Froilan Zarate
 * @version SampleExamTwo
 */
public class Surcharge
{
    public static void main(String[] args)
    {
        final double SURCHARGE_PERCENT = 0.05;
    
        // Step 3: Create a Scanner object to get input 
        //         from the keyboard
        Scanner in = new Scanner(System.in);
        
        // Step 4: Ask for the original cost using prompt
        //              "Enter the original cost: "
        //         While the next input is not a double value
        //              Get the input token
        //              Display a message on one line
        //                  Sample message assuming input "amazon"
        //                  "Invalid original cost: amazon"
        //              Ask for the original cost using the same prompt
        // Note: You could only ask for the original cost and 
        //       skip the loop if you have issues with the loop
        System.out.print("Enter the original cost: ");
        
        while (!in.hasNextDouble())
        {
            System.out.println("Invalid original cost: " + in.next());
            System.out.print("Enter the original cost: ");
        }
    
        // Step 5: Input the original cost and save it in a double variable
        double originalCost = in.nextDouble();
        
        // Step 6: If the input cost is not positive
        //             Display a message on one line
        //                  Sample message assuming the input is -46.5
        //                  "Cost must be positive: -46.5!"
        //             Terminate the program
        if (originalCost <= 0)
        {
            System.out.print("Cost must be positive: " + originalCost);
            return;
        }


        // Step 7: Calculate the surcharge and store it in a variable.
        //         The surcharge is the product of the original cost
        //         and SURCHARGE_PERCENT.
        double surcharge = originalCost * SURCHARGE_PERCENT;

        
        // Step 8: Display the original cost, surcharge, and the new cost
        //              on 3 lines
        //                  Sample message assuming the input is 46.5
        //                  "The original cost: $46.50."
        //                  "The surcharge: $2.33."
        //                  "The new cost: $48.83."
        //         The new cost is the sum of the original cost and
        //         the calculated surcharge.
        System.out.printf("The original cost: $%.2f.%n", originalCost);
        System.out.printf("The surcharge: $%.2f.%n", surcharge);
        System.out.printf("The new cost: $%.2f.%n", originalCost + surcharge);

        
    }
}
