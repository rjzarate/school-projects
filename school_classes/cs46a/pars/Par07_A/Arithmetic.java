import java.util.Scanner;
/**
 * Examples to use class Scanner to read input 
 * from the keyboard.
 *
 * @author  Qi Yang
 * @version 2022-09-15
 */
public class Arithmetic
{    
    public static void main(String[] args)     
    {
        // Create a Scanner object to get input from the keyboard
        Scanner in = new Scanner(System.in);
    
        // Display an input prompt to get two integers
        System.out.print("Enter two integers: ");
        
        // Read two integers and store them in 
        // two int variables num1 and num2
        int num1 = in.nextInt(); 
        int num2 = in.nextInt(); 
        
        // Display the quotient 
        System.out.println("The quotient is " + num1 / num2);
        
        // Display the remainder 
        System.out.println("The remainder is " + num1 % num2);
    
        // Display the double quotient 
        System.out.println("The double quotient is " + 
                           (double)num1 / num2);
        System.out.println("The double quotient is " + 
                            num1 / (double) num2);
        
        double quotient = (double)(num1 / num2);
        System.out.println("The quotient is " + quotient); 
    
        // Display an input prompt to input a double number
        System.out.print("Enter a double number: ");

        double dblNum = in.nextDouble();

        System.out.println(Math.round(dblNum));

        System.out.println(Math.sqrt(dblNum));
        
        System.out.println(Math.pow(dblNum, 0.5));
        
        System.out.println(Math.pow(2, 3));
        
    }
}
