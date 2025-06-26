import java.util.Scanner;
/**
 * Input three integers and perform some arithmetic
 * operations.
 *
 * @author  Qi Yang
 * @version 2022-09-15
 */
public class OperatorPrecedence
{
   public static void main(String[] args)     
   {
        // System.in: the keyboard
        Scanner in = new Scanner(System.in);

        // Display an input prompt to get three integers
        System.out.print("Enter three integers: ");
        
        // Read three integers and store them in 
        // three int variables num1, num2, and num3
        int num1 = in.nextInt(); 
        int num2 = in.nextInt(); 
        int num3 = in.nextInt(); 
        
        int result = num1 / num2 * num3;
        
        // Display the result      
        System.out.println("The result is " + result + ".");
   }
}
