/**
 * Use a for loop to print all characters at odd index
 * positions of a string, one per line. 
 * You should use str.length() as the length of the string, since
 * Codecheck will use another string to test your program.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 10-04-2022
 */
public class OddIndexChars
{
    public static void main(String[] args)
    {
        String str = "Introduction to Programming"; 

        // Step 2: Use a for loop to print all chars at the odd
        //         index positions, one per line
        String oddStr;
        for (int oddLength = 1; oddLength < str.length(); oddLength += 2)
        {
            System.out.println(str.substring(oddLength, oddLength + 1));
        }
    }
}
