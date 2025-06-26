import java.util.ArrayList;
/**
 * A utility class providing one static method
 * for interface Qualifiable.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 11-22-2022
 */
public class UtilClass
{
    // Step 2: Complete method numOfQualified()
    /**
     * Gets the number of objects that are qualified.
     * You must use the enhanced for loop.
     * 
     * @param list an array list of Qualifiable
     * @return the number of objects in the list that are qualified
     */
    public static int numOfQualified(ArrayList<Qualifiable> list)
    {
        int count = 0;
        for (Qualifiable object: list)
        {
            if (object.qualifies() == true)
            {
                count ++;
            }
        }
        return count;
    }
}
