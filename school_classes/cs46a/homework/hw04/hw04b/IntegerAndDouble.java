import java.util.Scanner;
import java.lang.Math;
/**
 * Displays int and double values from the given inputs.
 *
 * @author Froilan Zarate
 * @version 09-22-2022
 */
public class IntegerAndDouble
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int intNumber = in.nextInt();
        
        System.out.println("The integer number is " + intNumber + ".");
        
        System.out.print("Enter a double number: ");
        double doubleNumber = in.nextDouble();
        
        System.out.println("The double number is " + doubleNumber + ".");
        
        System.out.println("The square root of the double number is " + Math.sqrt(doubleNumber) + ".");
        
        int doubleNumberAsInteger = (int) doubleNumber;
        System.out.println("The integer part of the double number is " + doubleNumberAsInteger + ".");
        
        System.out.println("The quotient of the integer number divided by the double number is " 
                            + ((double) intNumber / doubleNumber) + ".");
        
        System.out.println("The double quotient of the integer number divided by the integer part of the double number is " 
                            + ((double) intNumber / (double) doubleNumberAsInteger)  + ".");
                            
        System.out.println("The integer quotient of the integer number divided by the integer part of the double number is "
                            + (intNumber / doubleNumberAsInteger) + ".");
        
        System.out.println("The remainder of the integer number divided by the integer part of the double number is "
                            + (intNumber % doubleNumberAsInteger) + ".");
    }
}