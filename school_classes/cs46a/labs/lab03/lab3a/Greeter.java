/**
 * A class whose objects emit personalized greetings.
 *
 * @author  Qi Yang
 * @version 2022-02-10
 */
public class Greeter
{
    // The instance variable
    private String name;
    public static void main(String[] args)
    {
        Greeter object = new Greeter();
    }

    /**
     * Constructs a greeter that greets the world.
     */
    public Greeter()
    {
        name = "World";
    }

    /**
     * Constructs a greeter by initializing the instance
     * variable to the passed in name.
     * 
     * @param  aName the name of the person to be greeted
     */
    public Greeter(String aName)
    {
        name = aName;
    }
   
    /**
     * Makes a "Hello" greeting.
     * 
     * @return the greeting
     */
    public String sayHello()
    {
        String message = "Hello, " + name + "!";
        return message;
    }

    /**
     * Makes a "Goodbye" greeting.
     * 
     * @return the greeting
     */
    public String sayGoodbye()
    {
        String message = "Goodbye, " + name + "!";
        return message;
    }   
}