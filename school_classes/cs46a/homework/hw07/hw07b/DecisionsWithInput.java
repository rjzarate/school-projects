import java.util.Scanner;
/**
 * Checks multiple inputed numbers and outputs values according to the input(s).
 *
 * @author  Froilan Zarate
 * @version 10-22-2022
 */
public class DecisionsWithInput
{
    public static final int LUCKY_NUMBER = 5;
    public static final int EVEN_NUMBER_BASE = 2;
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean said5 = false;
        int input;
        int sumOfOdds = 0;
        int positiveNumAmt = 0;
        int smallestNum;
        System.out.print("Enter an integer or Q to quit: ");
        input = in.nextInt();
        //smallest number initialized
        smallestNum = input;
        if (input > 0)
        {
            positiveNumAmt ++;
        }
        //odd num
        if ((input % EVEN_NUMBER_BASE) != 0)
        {
            sumOfOdds = sumOfOdds + input;
        }
        //5
        if (input == LUCKY_NUMBER)
        {
            said5 = true;
        }
        
        
        System.out.print("Enter an integer or Q to quit: ");
        while (in.hasNextInt())
        {
            System.out.print("Enter an integer or Q to quit: ");
            input = in.nextInt();
            if (input < smallestNum)
            {
                smallestNum = input;
            }
            if (input > 0)
            {
                positiveNumAmt ++;
            }
            if ((input % EVEN_NUMBER_BASE) != 0)
            {
                sumOfOdds = sumOfOdds + input;
            }
            if (input == LUCKY_NUMBER)
            {
                said5 = true;
            }
        }
        System.out.printf("The sum of all odd numbers: %d.%nThe smallest number: %d.%n", sumOfOdds, smallestNum);
        if (said5 == true)
        {
            System.out.printf("5 is my lucky number!%n");
        } else
        {
            System.out.printf("No fives!%n");
        }
        System.out.printf("The count of positive numbers: %d.", positiveNumAmt);
    }
}
