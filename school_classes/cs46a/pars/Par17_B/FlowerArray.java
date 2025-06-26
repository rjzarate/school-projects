import java.util.Scanner;
/**
 * Woring with a partial array of strings.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 10-27-2022
 */
public class FlowerArray
{
    public static final int MAX_SIZE = 10;
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        // Step 2: Create an array of String of length
        //         MAX_SIZE (10) called garden
        String[] arrayString = new String[MAX_SIZE];
        
        
        // Step 3: Declare an int variable currentSize with
        //         initial value of 0
        int currentSize = 0;
        
        // Step 4: Read in an integer using prompt
        //         "Number of flowers: "
        System.out.print("Number of flowers: ");
        int numberOfFlowers = in.nextInt();

        // Step 5: Use a for loop to read in the specified number
        //         of strings as flower names, add them at the end 
        //         of the array, and increment currentSize.
        //         Use prompt "Enter a flower: " 
        String flower;
        for (int i = 0; i < numberOfFlowers; i ++)
        {
            System.out.print("Enter a flower: ");
            flower = in.next();
            flower = flower.trim();
            arrayString[i] = flower;
            currentSize ++;
        }
        
        // Step 6: Use a for loop to print all flowers in garden 
        //         on one line separated by single spaces
        for (int i = 0; i < currentSize; i ++)
        {
            System.out.print(arrayString[i] + " ");
        }
        
        System.out.println();
        
        // Step 7: Read in a string as a flower name 
        //         using prompt "Enter a flower: " 
        System.out.print("Enter a flower: ");
        flower = in.next();
        flower = flower.trim();
        
        // Step 8: Add the input flower at the end of 
        //         the array and update currentSize
        arrayString[currentSize] = flower;
        currentSize ++;
        
        // Step 9: Use a for loop to print all flowers in garden 
        //         on one line separated by single spaces
        for (int i = 0; i < currentSize; i ++)
        {
            System.out.print(arrayString[i] + " ");
        }
        
        System.out.println();
        
        // Step 10: Read in a string as a flower name 
        //          using prompt "Enter a flower: " 
        System.out.print("Enter a flower: ");
        flower = in.next();
        flower = flower.trim();

        // Step 11: Replace the last element with 
        //          the input flower
        arrayString[currentSize - 1] = flower;

        // Step 12: Read in a string as a flower name 
        //          using prompt "Enter a flower: " 
        System.out.print("Enter a flower: ");
        flower = in.next();
        flower = flower.trim();

        // Step 13: Replace the second flower with 
        //          the input flower
        arrayString[1] = flower;
        
        // Step 14: Use a for loop to print all flowers in garden 
        //          on one line separated by single spaces
        for (int i = 0; i < currentSize; i ++)
        {
            System.out.print(arrayString[i] + " ");
        }
        
    }
}