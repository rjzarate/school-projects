import java.util.ArrayList;
/**
 * Houses static methods.
 *
 * @author Froilan Zarate
 * @version 11-22-2022
 */
public class StaticPractice
{
    
    /**
     * Constructor for objects of class StaticPractice
     */
    public StaticPractice()
    {
        
    }

    /**
     * Gets the 
     * average value of all positive elements in the array. The array has size values, and, if the 
     * array has no positive elements, returns 0. 
     *
     * @param  numbers  the integers in the array
     * @param  size     the size of the array
     * @return          the average of positive numbers
     */
    public static double averageOfPositive (int[] numbers, int size)
    {
        double average = 0;
        double count = 0;
        for (int i = 0; i < size; i ++)
        {
            if (numbers[i] > 0)
            {
                average += numbers[i];
                count ++;
            }
        }
        if (count == 0)
        return 0;
        return average / count;
    }
    /**
     * Gets the average value of all positive elements in the array list. If the array list has no 
     * positive elements, returns 0. You should use the enhanced for loop. 
     *
     * @param  numbers  the integers in the array
     * @return          the average of positive numbers
     */
    public static double averageOfPositive (ArrayList<Integer> numbers)
    {
        double average = 0;
        double count = 0;
        for (int integer: numbers)
        {
            if (integer > 0)
            {
                average += integer;
                count ++;
            }
        }
        if (count == 0)
        return 0;
        return average / count;
    }
    /**
     * Gets the count of occurrences of target in the array. The array has size values. 
     *
     * @param  list   the string array
     * @param  size   the size of the array
     * @param  target the check
     * @return          the count
     */
    public static int targetCount(String[] list, int size, String target)
    {
        int count = 0;
        for (int i = 0; i < size; i ++)
        {
            if (list[i].equals(target))
            {
                count ++;
            }
        }
        return count;
    }
    /**
     * Gets the count of occurrences of target in the array list. You should use the enhanced for loop. 
     *
     * @param  list   the string array
     * @param  target the check
     * @return          the count
     */
    public static int targetCount(ArrayList<String> list, String target)
    {
        int count = 0;
        for (String str: list)
        {
            if (str.equals(target))
            {
                count ++;
            }
        }
        return count;
    }
}
