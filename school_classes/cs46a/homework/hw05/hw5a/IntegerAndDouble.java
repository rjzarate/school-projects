import java.util.Scanner;
import java.lang.Math;
/**
 * Given the integer and double number provides outputs of remainders, quotients and square roots.
 *
 * @author  Froilan Zarate
 * @version 09-29-2022
 */
public class IntegerAndDouble
{
    // instance variables - replace the example below with your own
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        if (!in.hasNextInt())
        {
            String notInt = in.nextLine();
            notInt = notInt.trim();
            System.out.println(notInt + " is not an integer!");
            System.out.print("Program terminated!");
            return;
        }
        int intNumber = in.nextInt();
        System.out.println("The integer number is " + intNumber + ".");
        System.out.print("Enter a double number: ");
        if (!in.hasNextDouble())
        {
            String notDouble = in.next();
            notDouble = notDouble.trim();
            System.out.println(notDouble + " is not a double number!");
            System.out.print("Program terminated!");
            return;
        }
        double doubleNumber = in.nextDouble();
        System.out.println("The double number is " + doubleNumber + ".");
        if (doubleNumber < 0)
        {
            System.out.println("No square root, since the double number is negative.");
        } else
        {
            System.out.printf("The square root of the double number is %.4f.%n", Math.sqrt(doubleNumber));
        }
        if (doubleNumber == 0)
        {
            System.out.println("No quotient, since the double number is zero.");
        } else
        {
            System.out.print("The quotient of the integer number divided by the double number is ");
            System.out.printf("%.3f.%n", intNumber / doubleNumber);
        }
        int doubleNumberAsInt = (int) doubleNumber;
        System.out.println("The integer part of the double number is " + doubleNumberAsInt + ".");
        if (doubleNumber < 1 && doubleNumber > -1)
        {
            System.out.print("No quotient or remainder, since the integer part of the double number is zero.");
            return;
        }
        System.out.printf("The double quotient of the integer number divided by the integer part of the double number is %.2f.%n", (double) intNumber / (double) doubleNumberAsInt);
        System.out.println("The integer quotient of the integer number divided by the integer part of the double number is " + intNumber / doubleNumberAsInt + ".");
        System.out.println("The remainder of the integer number divided by the integer part of the double number is " + intNumber % doubleNumberAsInt + ".");
    }
}
