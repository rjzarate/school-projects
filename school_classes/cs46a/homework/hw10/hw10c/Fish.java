
/**
 * The fish class.
 *
 * @author Froilan Zarate
 * @version 11-22-2022
 */
public class Fish
{
    // instance variables - replace the example below with your own
    private int state;
    public static final int NOT_HUNGRY = 1; 
    public static final int SOMEWHAT_HUNGRY = 2; 
    public static final int HUNGRY = 3; 
    public static final int VERY_HUNGRY = 4;
    /**
     * Constructor for objects of class Fish
     */
    public Fish()
    {
        state = NOT_HUNGRY;
    }
    /**
     * Changes the fish state to one level hungrier if not in state VERY_HUNGRY. 
     *
     */
    public void swim()
    {
        if (state != VERY_HUNGRY)
        state ++;
    }
    /**
     * Changes the fish state to one level less hungry if not in state NOT_HUNGRY. 
     *
     */
    public void eat()
    {
        if (state != NOT_HUNGRY)
        state --;
    }
    /**
     * Gets the integer representing the state, an integer 1 through 4.
     *
     * @return the integer state
     */
    public int getState()
    {
        return state;
    }
    /**
     * Gets a string describing the current hunger 
     * state of the Fish: "Not hungry", "Somewhat hungry”, "Hungry", or "Very hungry". Do 
     * not use multiple independent if statements to determine what to return. 
     *
     * @return the hunger level as a string
     */
    public String getHungerLevel()
    {
        if (state == NOT_HUNGRY)
        {
            return "Not hungry";
        } else if (state == SOMEWHAT_HUNGRY)
        {
            return "Somewhat hungry";
        } else if (state == HUNGRY)
        {
            return "Hungry";
        } else
        return "Very hungry";
        
    }
}
