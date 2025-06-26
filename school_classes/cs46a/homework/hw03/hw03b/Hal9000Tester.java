/**
 * Tester for the Hal9000 class
 *
 * @author  Qi Yang
 * @version 2022-09-01
 */
public class Hal9000Tester
{
    public static void main(String[] args)
    {
        Hal9000 hal = new Hal9000("Dave");
        Hal9000 cay = new Hal9000("Cay");

        System.out.println(hal.greet());
        System.out.println("Expected: Greetings, Dave.");
        System.out.println(hal.giveStatus());
        System.out.println("Expected: Everything is a go, Dave.");
        System.out.println(hal.executeCommand("engage drive"));
        System.out.println("Expected: I am sorry, Dave. I can't engage drive.");
        
        hal.setName("Frank");
        System.out.println(hal.greet());
        System.out.println("Expected: Greetings, Frank.");
        System.out.println(hal.giveStatus());
        System.out.println("Expected: Everything is a go, Frank.");
        System.out.println(hal.executeCommand("shut down"));
        System.out.println("Expected: I am sorry, Frank. I can't shut down.");
        
        System.out.println(cay.greet());
        System.out.println("Expected: Greetings, Cay.");
        System.out.println(cay.giveStatus());
        System.out.println("Expected: Everything is a go, Cay.");
        System.out.println(cay.executeCommand("engage drive"));
        System.out.println("Expected: I am sorry, Cay. I can't engage drive.");
    }
}