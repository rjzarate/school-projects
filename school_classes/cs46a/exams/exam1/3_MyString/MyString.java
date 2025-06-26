/**
 * A class to store and process a string of one or two words.
 *
 * Step 1: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version MyExamOne
 */
public class MyString
{
    // Step 2: Declare an instance variable of String
    private String string;
    
    // Step 3: Complete the constructor of class MyString
    //         including the Javadoc
    /**
     * Constructor for objects of class MyString. 
     * The parameter has one word or two words 
     * separated by a single space, and it has
     * no spaces at either end.
     * 
     * @param str  the string
     */
    public MyString(String str)
    {
        string = str;
    }
    
    // Step 4: Complete method getString()
    //         including the Javadoc
    /**
     * Gets the stored string.
     *
     * @return  the string
     */
    public String getString()
    {
        return string;
    }
    
    // Step 5: Complete method setString()
    //         including the Javadoc
    /**
     * Sets the stored string to a new string.
     *
     * @param newStr  the new string
     */
    public void setString(String newStr)
    {
        string = newStr;
    }
    
    // Step 6: Complete method charCount()
    //         including the Javadoc
    /**
     * Gets the number of characters of the stored string.
     *
     * @return the string length
     */
    public int charCount()
    {
        return string.length();
    }

    // Step 7: Complete method camelFormat() including the Javadoc
    // Notice: Make the stub first!
    //
    // For a single word, its camel format is the string with all 
    // characters converted to lower case. For example, the camel 
    // format is "java" for "Java", and "cs46a" for "CS46A".
    //
    // For a phase of two words separated by a single space, its 
    // camel format is the string with the first character of the 
    // second word converted to upper case and all other characters 
    // converted to lower case. The space between the two words is 
    // also removed. For example, the camel format for both  
    // "my variables" and "My VARIABLES" is "myVariables".
    /**
     * Gets the camel format for the stored string.
     * The stored string has either one word or two
     * words separated by a single space and there 
     * are no spaces at either end.
     *
     * @return the camel format for the stored string
     */
    public String camelFormat()
    {
        string.toLowerCase();
        if (string.contains(" "))
        {
        String word1 = string.substring(0, string.indexOf(' '));
        String capitalCharacter = string.substring(string.indexOf(' ') + 1, string.indexOf(' ') + 2);
        String word2 = string.substring(string.indexOf(' ') + 2);
        return word1.toLowerCase() + capitalCharacter.toUpperCase() + word2.toLowerCase();
        }
        return string.toLowerCase();
    }
}
