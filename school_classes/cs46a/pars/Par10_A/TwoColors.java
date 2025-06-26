import java.util.Scanner;
/**
 * A Java program to input and compare strings.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 09-27-2022
 */
public class TwoColors
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter your first favorite color: ");

        // Step 2: Read in the next line of input and assign 
        //         it to a String variable color1
        String color1 = in.nextLine();

        // Step 3: Trim spaces from both end and convert the 
        //         input to all lowercase and assign it back
        //         to the same variable
        color1 = color1.trim().toLowerCase();
        
        
        System.out.print("Enter your second favorite color: ");
        
        // Step 4: Read in the next line of input and assign 
        //         it to a String variable color2
        String color2 = in.nextLine();

        
        // Step 5: Trim spaces from both end and convert the 
        //         input to all lowercase and assign it back
        //         to the same variable
        color2 = color2.trim().toLowerCase();

        
        // Step 6: Display a message according to the following:
        //     first color      second color       message
        //     light blue           red         That's wonderful!
        //         red          light blue      That's even better!
        //             otherwise                That's also great! 
        if (color1.equals("light blue") && color2.equals("red"))
        {
            System.out.print("That's wonderful!");
        }
        else if (color1.equals("red") && color2.equals("light blue"))
        {
            System.out.print("That's even better!");
        }
        else
        {
            System.out.print("That's also great!");
        }
    }
}
