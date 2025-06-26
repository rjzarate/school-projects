// Step 1: Import Java class Scanner
import java.util.Scanner;
/**
 * A program to input, process, and output strings.
 * 
 * Note: Codecheck will use different input strings to test
 * the program, and you must use the specified variables in 
 * your program.
 *
 * Step 2: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 09-21-2022
 */
public class StringProg
{
    public static void main(String[] args)
    {
        // Step 3: Create a new Scanner object
        Scanner in = new Scanner(System.in);
        
        // Step 4: Display a prompt "Enter multiple words on one line separated by single spaces: "
        System.out.print("Enter multiple words on one line separated by single spaces: ");
    
        // Step 5: Read in one line of input and store it in a variable line
        String line = in.nextLine();
    
        // Step 6: Ask for a word with prompt "Enter a single word: "
        System.out.print("Enter a single word: ");

        // Step 7: Read in a single string and store it in variable word
        String word = in.next();
        
        // Step 8: Display line on one line within double quotes
        //         with message "The original line: "
        System.out.print("The original line: \"");
        System.out.println(line + "\"");
        
        // Step 9: Display word on one line within double quotes
        //         with message "The original word: "
        System.out.print("The original word: \"");
        System.out.println(word + "\"");
        
        // Step 10: Trime spaces from both ends of line and save it back to line
        String lineTrimmed = line.trim();
        
        // Step 11: Display line on one line within double quotes
        //         with message "The line with spaces trimmed from both ends: "
        System.out.print("The line with spaces trimmed from both ends: \"");
        System.out.println(lineTrimmed + "\"");
        
        // Step 12: Trime spaces from both ends of word and save it back to word
        String wordTrimmed = word.trim();
        
        // Step 13: Display word on one line within double quotes
        //          with message "The word with spaces trimmed from both ends: "
        System.out.print("The word with spaces trimmed from both ends: \"");
        System.out.println(wordTrimmed + "\"");
        
        // Step 14: Find out if line contains word and assign 
        //          the result to a variable trueOrFalse 
        boolean trueOrFalse = line.contains(word);
        
        // Step 15: Display the value of trueOrFalse on one line
        //          with message "The line contains the word: "
        System.out.print("The line contains the word: ");
        System.out.println(trueOrFalse);

        // Step 16: Find out the index of word within line and assign
        //          the result to an integer variable pos
        int pos = line.indexOf(word);
        
        // Step 17: Display the value of pos on one line
        //          with message "The index of word in line: "
        System.out.print("The index of word in line: ");
        System.out.println(pos);

        // Step 18: Find out the index of the first space 
        //          within line and assign it to pos
        pos = lineTrimmed.indexOf(' ');
        
        // Step 19: Display the first word of line on one line
        //          within double quotes with message
        //          "First word of line: "
        System.out.print("First word of line: \"");
        System.out.println(lineTrimmed.substring(0, pos) + "\"");

        // Step 20: Find out the index of the second space within
        //          line and assign it to another int variable
        int pos2 = lineTrimmed.indexOf(" ", pos + 1);
        
        // Step 21: Display the second word of line 
        //          within double quotes with message
        //          "Second word of line: "
        System.out.print("Second word of line: \"");
        System.out.println(lineTrimmed.substring(pos + 1, pos2) + "\"");
        
    }
}
