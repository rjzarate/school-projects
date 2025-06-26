/**
 * Call methods on string objects.
 * 
 * @author Froilan Zarate
 * @version 09-06-2022
 */
public class ColumbusDay
{
    public static void main(String[] args)
    {
        String word =  "Columbus Day";      
        int index = 0;                      
        int size = 5;                       
        
        System.out.println("The given string: " + word);
        System.out.println("The length: " + word.length());
        System.out.println("The character at index " + index + ": " + word.charAt(index));
        System.out.println("The size " + size + " substring starting at index " + index + ": " + word.substring(index, index + size));
        System.out.println("ALL UPPER CASE: " + word.toUpperCase());
        System.out.println("all lower case: " + word.toLowerCase());
        System.out.println("all lower case with space removed: " + word.toLowerCase().replace(" ", ""));
        System.out.println("The original word with ' ' replaced by '_': " + word.replace(" ", "_"));
        
        
        // Do not change the lines above

        

    }
}