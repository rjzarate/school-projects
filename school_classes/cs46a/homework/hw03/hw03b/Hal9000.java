
/**
 * A fictional character in Arthur C. Clarke's 2001: A Space Odyssey. 
 *
 * @author Froilan Zarate
 * @version 09-13-2022
 */
public class Hal9000
{
    // instance variables - replace the example below with your own
    private String name;

    /**
     * Constructs a new crewmate with the given name
     * 
     * @param  theName the name of the crewmate.
     */
    public Hal9000(String theName)
    {
        name = theName;
    }

    /**
     * Gets the name of this climber.
     *
     * @return the name of the crewmate
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Sets a new name.
     *
     * @param  newName the new name of the crewmate.
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * Returns a string "Greetings, Dave." if the crew name is Dave. 
     *
     * @return a greeting to the crewmate.
     */
    public String greet()
    {
        String s;
        s = "Greetings, " + name + ".";
        return s;
    }
    
    /**
     * Returns a string "Everything is a go, Dave.” if the crew name is Dave.  
     *
     * @return a green light to the crewmate.
     */
    public String giveStatus()
    {
        String s;
        s = "Everything is a go, " + name + ".";
        return s;
    }
    
    /**
     * Returns a string "I am sorry, Dave. I can't engage drive." if the crew name is Dave and the command (the parameter whatToDo) is “engage drive”. 
     *
     * @param  whatToDo what the computer was executed to do.
     * @return the computer could not execute the given command.
     */
    public String executeCommand(String whatToDo)
    {
        String s;
        s = "I am sorry, " + name + ". I can't " + whatToDo + ".";
        return s;
    }
}
