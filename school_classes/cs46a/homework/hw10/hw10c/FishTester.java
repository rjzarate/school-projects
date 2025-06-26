/**
 * Tester for the Fish class
 *
 * @author  Qi Yang
 * @version 2022-11-04
 */
public class FishTester
{
    public static void main(String[] args)
    {
        Fish fishy = new Fish(); 
        System.out.println("state: " + fishy.getState()
            + " " + fishy.getHungerLevel());
        System.out.println("Expected: 1 Not hungry");
        
        fishy.eat();
        System.out.println("state: " + fishy.getState());
        System.out.println("Expected: 1");
        
        fishy.swim();
        System.out.println("state: " + fishy.getState()
            + " " + fishy.getHungerLevel());
        System.out.println("Expected: 2 Somewhat hungry");
        
        fishy.eat();
        System.out.println("state: " + fishy.getState());
        System.out.println("Expected: 1");
        
        fishy.swim();
        System.out.println("state: " + fishy.getState());
        System.out.println("Expected: 2");
        
        fishy.swim();
        System.out.println("state: " + fishy.getState()
            + " " + fishy.getHungerLevel());
        System.out.println("Expected: 3 Hungry");
        
        fishy.swim();
        System.out.println("state: " + fishy.getState()
            + " " + fishy.getHungerLevel());
        System.out.println("Expected: 4 Very hungry");
        
        fishy.swim();
        System.out.println("state: " + fishy.getState());
        System.out.println("Expected: 4");
        
        fishy.eat();
        System.out.println("state: " + fishy.getState());
        System.out.println("Expected: 3");
        
        fishy.eat();
        System.out.println("state: " + fishy.getState());
        System.out.println("Expected: 2");
        
        fishy.eat();
        System.out.println("state: " + fishy.getState());
        System.out.println("Expected: 1");
        
        fishy.eat();
        System.out.println("state: " + fishy.getState()
            + " " + fishy.getHungerLevel());
        System.out.println("Expected: 1 Not hungry");
    }
}