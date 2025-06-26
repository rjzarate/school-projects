import java.util.ArrayList;
/**
 * Manages an array list of class Frog and the default constructor initializes the list to an empty list.
 *
 * @author  Froilan Zarate
 * @version 10-29-2022
 */
public class FrogList
{
    // instance variables - replace the example below with your own
    private ArrayList<Frog> list;

    /**
     * Constructor for objects of class FrogList
     * 
     */
    public FrogList()
    {
        list = new ArrayList<Frog>();
    }
    
    /**
     * Adds a frog at the beginning of the list.
     *
     * @param  frog  the frog
     */
    public void add(Frog frog)
    {
        list.add(0, frog);
    }
    
    /**
     * Returns the Frog object at position index without changing the list if the index is valid and returns null otherwise.
     *
     * @param  index  the frog index
     * 
     * @return    the index
     */
    public Frog get(int index)
    {
        if (index >= list.size())
        {
            return null;
        }
        return list.get(index);
    }
    
    /**
     * Gets the number of frogs in the list that have a weight in the range between lowLimit and highLimit, inclusive.
     *
     * @param lowLimit   the lowest weight for the frog
     * @param highLimit  the highest weight for the frog
     * 
     * @return   the amount of frogs within the limit
     */
    public int countInRange(int lowLimit, int highLimit)
    {
        int numberOfFrogs = 0;
        for (Frog frog: list)
        {
            if (frog.getWeight() >= lowLimit && frog.getWeight() <= highLimit)
            {
                numberOfFrogs ++;
            }
        }
        
        
        return numberOfFrogs;
    }
    /**
     * Gets a string representation for the list including all 
     * frogs in the list by returning the string from the 
     * toString() method of the list.
     * 
     * @return the list of frogs
     */
    @Override
    public String toString()
    {
        return list.toString();
    }

}
