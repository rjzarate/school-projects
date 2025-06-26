import java.util.ArrayList;
/**
 * A utility class that provides some useful static methods.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 11-10-2022
 */
public class UtilClass
{
    /**
     * Computes and returns the area of a circle.
     *
     * @param  circle the circle whose area is to be calculated
     * @return the area of the circle
     */
    public static double area(Circle circle)
    {
        double radius = circle.getRadius();
        return Math.PI * radius * radius;
    }
    
    // Step 2: Complete method max() 
    /**
     * Computes and returns the maximum value of an array list
     * of integers. 
     * 
     * You should use the enhanced for loop.
     *
     * @param  list an array list of Integer
     * @return the maximum value of the list
     *         Integer.MIN_VALUE if the list is empty
     */
    public static int max(ArrayList<Integer> list)
    {
        int max = Integer.MIN_VALUE;
        for (int integer: list)
        {
            if (max < integer)
            max = integer;
        }
        return max;
    }
    
    // Step 3: Write method lastLongest()
    /** 
     * Gets and returns the last longest word in an array of String.
     * 
     * @param  words an array of String 
     * @param  count the number of strings in the array
     * @return the last longest word in words
     *         the empty string if words is empty
     */
    public static String lastLongest(String[] words, int count)
    {
        String longestWord = "";
        for (int i = 0; i < count; i ++)
        {
            if (words[i].length() >= longestWord.length())
            {
                longestWord = words[i];
            }
        }
        
        return longestWord;
    }
}
