import java.util.Scanner;
/**
 * Separate parts of a book title.
 *
 * @author  Froilan Zarate
 * @version 09-22-2022
 */
public class StringApplication
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a book title: ");

        String line = in.nextLine();
        String lineTrimmed = line.trim();
        

        
        System.out.print("The first character is '");
        System.out.println(lineTrimmed.substring(0,1) + "'.");
        
        int pos = lineTrimmed.indexOf(' ');
        System.out.print("The first word is \"");
        System.out.println(lineTrimmed.substring(0, pos) + "\".");
        
        System.out.print("The rest of title is \"");
        System.out.println(lineTrimmed.substring(pos + 1) + "\".");
        
        System.out.print("Enter the starting position for a substring: ");
        int startingPos = in.nextInt();
        System.out.print("Enter the length for the substring: ");
        int lengthPos = in.nextInt();
        
        System.out.print("The " + lengthPos + "-char substring starting at index " + startingPos + " is \"" + lineTrimmed.substring(startingPos, startingPos + lengthPos) + "\".");
    }
}
