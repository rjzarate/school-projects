import java.util.Scanner;
/**
 * Checks multiple inputed temperatures and outputs values according to the input(s).
 *
 * @author Froilan Zarate
 * @version 10-22-2022
 */
public class Temperatures
{
    public static final double FREEZE_POINT = 32.0;
    public static void main(String[] args)
    {
        double high;
        double secondHigh;
        double temp;
        int negativeTempAmt = 0;
        int belowFreezingTempAmt = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first temperature Fahrenheit: ");
        high = in.nextDouble();
        if (high < FREEZE_POINT)
        {
            belowFreezingTempAmt ++;
            if (high < 0)
            {
                negativeTempAmt ++;
            }
        }
        System.out.print("Enter the second temperature Fahrenheit: ");
        secondHigh = in.nextDouble();
        if (secondHigh < FREEZE_POINT)
        {
            belowFreezingTempAmt ++;
            if (secondHigh < 0)
            {
                negativeTempAmt ++;
            }
        }
        if (secondHigh > high)
        {
            temp = high;
            high = secondHigh;
            secondHigh = temp;
        }
        System.out.print("Enter another temperature Fahrenheit or Q to quit: ");
        while (in.hasNextDouble())
        {
            System.out.print("Enter another temperature Fahrenheit or Q to quit: ");
            temp = in.nextDouble();
            if (temp < FREEZE_POINT)
            {
                belowFreezingTempAmt ++;
                if (temp < 0)
                {
                    negativeTempAmt ++;
                }
            }
            
            if (temp > secondHigh)
            {
                secondHigh = temp;
                if (secondHigh > high)
                {
                    temp = high;
                    high = secondHigh;
                    secondHigh = temp;
                }
            }
        }
        System.out.println("Number of negative temperatures: " + negativeTempAmt);
        System.out.println("Number of below freezing point temperatures: " + belowFreezingTempAmt);
        System.out.printf("The highest temperature: %.1f%n", high);
        System.out.printf("The second highest temperature: %.1f", secondHigh);
    }
}
