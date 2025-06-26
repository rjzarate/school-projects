import java.lang.Math;
/**
 * Write a description of class LoopyFun here.
 *
 * @author Froilan Zarate
 * @version 10-15-2022
 */
public class LoopyFun
{
    // instance variables - replace the example below with your own
    private int integer;
    private static final int POWER_OF_TWO = 2;

    /**
     * Constructor for objects of class LoopyFun
     * 
     * @param thisInteger the positive integer
     */
    public LoopyFun(int thisInteger)
    {
        thisInteger = Math.abs(thisInteger);
        if (thisInteger == 0)
        {
            thisInteger = 1;
        }
        integer = thisInteger;
    }
    /**
     * Gets the stored integer
     *
     * @return   the integer
     */
    public int getNum()
    {
        // put your code here
        return integer;
    }
    /**
     * Calculates and returns the factorial of the stored integer
     *
     * @return   the factorial
     */
    public int factorial()
    {
        int factorial = 1;
        for (int i = integer; i > 0; i --)
        {
            factorial = factorial * i;
        }
        return factorial;
    }
    /**
     * Calculates and returns the sum of powers of two
     *
     * @return   the sum of powers of two
     */
    public int sumOfPowersOfTwo()
    {
        int sumOfPowersOfTwo = 1;
        for (int i = integer - 1; i > 0; i --)
        {
            sumOfPowersOfTwo = sumOfPowersOfTwo + (int) Math.pow(POWER_OF_TWO, i);
        }
        return sumOfPowersOfTwo;
    }
}
