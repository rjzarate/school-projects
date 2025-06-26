import java.text.NumberFormat;
/**
 * Represents a non-negative integer.
 *
 * @author Froilan Zarate
 * @version 09-29-2022
 */
public class MyNumber
{
    // instance variables - replace the example below with your own
    private int number;
    private final int negativeOne = -1;
    private final int oneMillion = 1000000;

    /**
     * Constructor for objects of class MyNumber
     * 
     * @param value  the number given
     */
    public MyNumber(int value)
    {
        // initialise instance variables
        if (value < 0)
        {
            value = value * negativeOne;
        }
        number = value;
    }
    /**
     * Gets this number
     * 
     * @return the number
     */
    public int getNumber()
    {
        return number;
    }
    /**
     * Sets the stored number to a new value. If value is negative, multiply it by -1 so that you do not have a negative number.
     * 
     * @param value  the new number
     */
    public void setNumber(int value)
    {
        if (value < 0)
        {
            value = value * negativeOne;
        }
        number = value;
    }
    /**
     * Gets the number of digits in this number
     * 
     * @return the number of digits
     */
    public int digitCount()
    {
        return String.valueOf(number).length();
    }
    /**
     * a string representing the number in the comma format, if the number is less than 1,000,000. If the number is greater than or equal to 1,000,000, return the string "too big".
     * 
     * @return the number with commas
     */
    public String formatWithComma()
    {
        if (number >= oneMillion)
        {
            return "too big";
        }
        return NumberFormat.getNumberInstance().format(number);
    }
}
