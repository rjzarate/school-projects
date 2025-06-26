/**
 * Models a child climbing a pole.
 * 
 * @author  Froilan Zarate
 * @version 09-13-2022
 * 
 */
public class Climber
{
    // Instance variables 
    private String name;
    private int position;
    
    /**
     * Constructs a new climber with the given name and position. 
     * 
     * @param theName the name of this climber
     * @param thePosition the starting potition on the pole
     */
    public Climber (String theName, int thePosition)
    {
        name = theName;
        position = thePosition;
        
    }
    
    /**
     * Gets the name of this climber.
     * 
     * @return the name of this climber
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the position on the pole of this climber.
     * 
     * @return the position on the pole of this climber
     */
    public int getPosition()
    {
        return position;
    }
    
    /**
     * Sets a new name for this climber.
     * 
     * @param newName the new name for this climber
     */
    public void setName(String newName)
    {
        name = newName;
        
    }
    
    /**
     * Climbs one unit on the pole.
     */
    public void climb()
    {
        position = position + 1;
        
    }

    /**
     * Sets this climber to the bottom of the pole.
     */
    public void slide()
    {
        position = 0;
        
    }  
}