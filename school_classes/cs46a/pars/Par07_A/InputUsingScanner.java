import java.util.Scanner;
/**
 * Examples to use class Scanner to read input
 * from the keyboard.
 *
 * @author  Qi Yang
 * @version 2022-09-15
 */
public class InputUsingScanner
{
   public static void main(String[] args)     
   {
       // System.in: the keyboard
       Scanner in = new Scanner(System.in);
       
       // Read an integer and store it in 
       // an int variable
       int intNum = in.nextInt(); 

       // Calculate the square of intNum and store it in 
       // an int variable square
       int square = intNum * intNum;
           
       // Display the square of intNum      
       System.out.println("The square of " + intNum + 
                          " is " + square + ".");

   }
}
