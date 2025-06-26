// Step 1: Import class Scanner
import java.util.Scanner;
/**
 * A Java program for If practice.
 *
 * Step 2: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 09-22-2022
 */
public class FavoriteColor
{
    public static void main(String[] args)
    {
        // Step 3: Create a Scanner object to read input
        //         from the key board
        Scanner in = new Scanner(System.in);
        
        // Step 4: Display an input prompt 
        //         "Enter your favorite color: "
        System.out.print("Enter your favorite color: ");

        // Step 5: Read in a single string and assign 
        //         it to a String variable color
        String color = in.nextLine();
        
        // Step 6: Convert all chars of color to lower case
        //         and assign it back to color 
        color = color.toLowerCase();
        
        // Step 7: If color equals "blue", display 
        //              "Mine, too."
        //         Otherwise, display 
        //              "That's pretty, too."
        if (color.equals("blue"))
        {
            System.out.print("Mine, too.");
        }
        else
        {
            System.out.print("That's pretty, too.");
        }
    }
}
