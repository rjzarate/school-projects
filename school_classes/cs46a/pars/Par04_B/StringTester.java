/**
 * A Java application using class String.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 09-06-2022
 */
public class StringTester
{
    public static void main(String[] args)
    {
        // Step 2: Declare three String variables str1, str2, and str
        String str1;
        String str2;
        String str;
        
        // Step 3: Create a new String object with "Java" and
        //         assign it to str1
        str1 = "Java";

        // Step 4: Create a new String object with "CS 46A" and
        //         assign it to str2
        str2 = "CS 46A";
        
        // Step 5: Display str1 on a line
        System.out.println(str1);

        System.out.println("Expected: Java");
        
        // Step 6: Display str2 on a line
        System.out.println(str2);

        System.out.println("Expected: CS 46A");
        
        // Step 7: Get the number of characters of str1 and
        //         assign it to an integer variable numOfChars
        int numOfChars = str1.length();
        
        // Step 8: Display numOfChars on a line
        System.out.println(numOfChars);
        
        System.out.println("Expected: 4");

        // Step 9: Display the number of characters of str2 on a line 
        System.out.println(str2.length());
        
        System.out.println("Expected: 6");

        // Step 10: Call method toUpperCase() on str1 and assign the
        //          return value to str
        str = str1.toUpperCase();
        
        // Step 11: Display str on a line
        System.out.println(str);

        System.out.println("Expected: JAVA");
        
        // Step 12: Call method toLowerCase() on str2 and assign the
        //          return value to str         
        str = str2.toLowerCase();

        // Step 13: Display str on a line
        System.out.println(str);

        System.out.println("Expected: cs 46a");
                
        // Step 14: Call method replace() on str2 to replace "CS" with
        //          "SE" and assign the return value to str
        str = str2.replace("CS", "SE");
        
        // Step 15: Display str on a line
        System.out.println(str);

        System.out.println("Expected: SE 46A");
        
        // Step 16: Call method replace() on str2 to replace " " with
        //          "" and assign the return value to str
        str = str2.replace(" ", "");
        
        // Step 17: Display str on a line
        System.out.println(str);

        System.out.println("Expected: CS46A");

        // Step 18: Display str1 on a line
        System.out.println(str1);
        
        System.out.println("Expected: Java");

        // Step 19: Display str2 on a line
        System.out.println(str2);
        
        System.out.println("Expected: CS 46A");
    }
}
