// Step 1: import Java classes Scanner, Random, and Arrays
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
/**
 * Use a full array to store a number of frogs, swap
 * the first and the last frogs, and use the
 * enhanced for loop and method Arrays.toString()
 * to print out all frogs before and after swapping.
 *
 * Step 2: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 10-27-2022
 */
public class FrogArrayProg
{
    public static void main(String[] args)
    {
        final int MIN_WEIGHT = 1;
        final int MAX_WEIGHT = 25;
        
        Scanner in = new Scanner(System.in);
        
        // Step 3: Read an integer as the number of frogs
        //         using prompt "Enter the number of frogs: "
        System.out.print("Enter the number of frogs: ");
        int numberOfFrogs = in.nextInt();
        
        // Step 4: Create an array of the specified length
        //         to store the frogs
        Frog[] frogArray = new Frog[numberOfFrogs];
        
        // Step 5: Read an integer as the random generator seed
        //         using prompt 
        //         "Enter an integer as the random generator seed: "
        System.out.print("Enter an integer as the random generator seed: ");
        int seed = in.nextInt();

        // Step 6: Create a Random object using the input seed
        Random random = new Random(seed);
        
        // Step 7: Use a for loop to create the specified number
        //         of frogs and add them to the array.
        //         The weights of the frogs must be in the range
        //         [MIN_WEIGHT, MAX_WEIGHT] and be generated by
        //         the Random object created in Step 7
        for (int i = 0; i < numberOfFrogs; i ++)
        {
            frogArray[i] = new Frog(random.nextInt(MAX_WEIGHT - MIN_WEIGHT + 1) + MIN_WEIGHT);
        }
        
        
        System.out.println("All frogs before swapping:");

        // Step 8: Use the enhanced for loop to print out
        //         all frogs in the array, one per line
        for (Frog frog: frogArray)
        {
            System.out.println(frog);
        }
            
        // Step 9: Call method Arrays.toString() to print
        //         out all frogs in the aray
        System.out.println(Arrays.toString(frogArray));
        
        // Step 10: Calculate the index of the last frog 
        //          in the array and store it in a variable
        int frogArrayLength = frogArray.length - 1;
        
        // Step 11: Swap the first and the last frogs in the array
        Frog frogTemp = frogArray[0];
        frogArray[0] = frogArray[frogArrayLength];
        frogArray[frogArrayLength] = frogTemp;
        
        System.out.println("All frogs after swapping:");
        
        // Step 12: Use the enhanced for loop to print out
        //          all frogs in the array, one per line
        for (Frog frog: frogArray)
        {
            System.out.println(frog);
        }
            
        // Step 13: Call method Arrays.toString() to print
        //          out all frogs in the aray
        System.out.print(Arrays.toString(frogArray));
    }
}
