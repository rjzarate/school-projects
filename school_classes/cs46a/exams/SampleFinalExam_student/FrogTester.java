/**
 * A tester program for class Frog.
 *
 * @author Qi Yang
 * @version 2022-11-27
 */
public class FrogTester
{
    public static void main(String[] args)
    {
        Frog frogOne = new Frog("12345", 0.4);
        Frog frogTwo = new Frog("54321", -15);

        System.out.println(frogOne.getID());
        System.out.println("Expected: 12345");
        System.out.println(frogOne.getWeight());
        System.out.println("Expected: 0.5");
        System.out.println(frogOne.toString());
        System.out.println("Expected: Frog[ID=12345,Weight=0.5,Legs=0]");

        System.out.println(frogTwo.getID());
        System.out.println("Expected: 54321");
        System.out.println(frogTwo.getWeight());
        System.out.println("Expected: 0.5");
        System.out.println(frogTwo.toString());
        System.out.println("Expected: Frog[ID=54321,Weight=0.5,Legs=0]");

        frogTwo = new Frog("55555", 15);
        System.out.println(frogTwo.toString());
        System.out.println("Expected: Frog[ID=55555,Weight=15.0,Legs=2]");
            
        frogOne.grow(4.5);
        System.out.println(frogOne.toString());
        System.out.println("Expected: Frog[ID=12345,Weight=5.0,Legs=0]");
        frogOne.grow(0.1);
        System.out.println(frogOne.toString());
        System.out.println("Expected: Frog[ID=12345,Weight=5.1,Legs=2]");
            
            
        frogTwo.grow(5.0);
        System.out.println(frogTwo.toString());
        System.out.println("Expected: Frog[ID=55555,Weight=20.0,Legs=2]");
        
        frogTwo.grow(-0.1);
        System.out.println(frogTwo.toString());
        System.out.println("Expected: Frog[ID=55555,Weight=20.0,Legs=2]");
            
        frogTwo.grow(0.1);
        System.out.println(frogTwo.toString());
        System.out.println("Expected: Frog[ID=55555,Weight=20.1,Legs=4]");
            
        frogTwo.grow(2);
        System.out.println(frogTwo.toString());
        System.out.println("Expected: Frog[ID=55555,Weight=22.1,Legs=4]");
    }
}
