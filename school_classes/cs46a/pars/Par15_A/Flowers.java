// Step 1: Import Java ArrayList class
import java.util.ArrayList;
/**
 * Create an array list of string and call several methods
 * on the array list.
 *
 * Step 2: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 10-20-2022
 */
public class Flowers
{
    public static void main(String[] args)
    {
        // Step 3: Create an array list of String called garden
        ArrayList<String> garden = new ArrayList<String>();

        
        // Step 4: Print the array list
        System.out.println(garden.toString());

        
        // Step 5: Add "rose", "daisy", and "violet" in that order
        garden.add("rose");
        garden.add("daisy");
        garden.add("violet");


        // Step 6: Print the array list
        System.out.println(garden.toString());


        // Step 7: Add "petunia" at index 0
        garden.add(0, "petunia");


        // Step 8: Add  "pansy" at index 2
        garden.add(2, "pansy");


        // Step 9: Print the array list
        System.out.println(garden.toString());

        
        // Step 10: Replace the element at index 2 with "marigold"
        garden.set(2, "marigold");


        // Step 11: Replace the last element with "zinnia"
        garden.set(garden.size() - 1, "zinnia");


        // Step 12: Print the array list
        System.out.println(garden.toString());


        // Step 13: Remove the second element and store the
        //          removed element in a variable flower
        String flower = garden.get(1);
        garden.remove(1);
        


        // Step 14: Print the removed element on one line
        System.out.println(flower);


        // Step 15: Print the array list
        System.out.print(garden.toString());

    }
}
