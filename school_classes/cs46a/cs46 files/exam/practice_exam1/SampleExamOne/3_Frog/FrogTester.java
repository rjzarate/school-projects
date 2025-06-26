/**
 * A Java tester program for class Frog.
 *
 * @author  Qi Yang
 * @version 2022-09-24
 */
public class FrogTester
{
    public static void main(String[] args)
    {
        Frog frogOne = new Frog(0);
        Frog frogTwo = new Frog(-15);
        Frog frogThree = new Frog(10);

        // Testing method getWeight()
        System.out.println(frogOne.getWeight());
        System.out.println("Expected: 1");
        System.out.println(frogTwo.getWeight());
        System.out.println("Expected: 1");
        System.out.println(frogThree.getWeight());
        System.out.println("Expected: 10");
        
        // Testing method getLegs()
        System.out.println(frogOne.getLegs());
        System.out.println("Expected: 0");
        System.out.println(frogTwo.getLegs());
        System.out.println("Expected: 0");
        System.out.println(frogThree.getLegs());
        System.out.println("Expected: 2");

        // Testing method toString()
        System.out.println(frogOne.toString());
        System.out.println("Expected: Frog[Weight:1,Legs:0]");
        System.out.println(frogTwo.toString());
        System.out.println("Expected: Frog[Weight:1,Legs:0]");
        System.out.println(frogThree.toString());
        System.out.println("Expected: Frog[Weight:10,Legs:2]");

        // Testing method grow()
        frogOne.grow(0);
        frogTwo.grow(-4);
        frogThree.grow(10);
        
        // Testing method toString()
        System.out.println(frogOne.toString());
        System.out.println("Expected: Frog[Weight:1,Legs:0]");
        System.out.println(frogTwo.toString());
        System.out.println("Expected: Frog[Weight:1,Legs:0]");
        System.out.println(frogThree.toString());
        System.out.println("Expected: Frog[Weight:20,Legs:2]");

        // Testing method grow()
        frogOne.grow(5);
        frogTwo.grow(4);
        frogThree.grow(1);
        
        // Testing method toString()
        System.out.println(frogOne.toString());
        System.out.println("Expected: Frog[Weight:6,Legs:2]");
        System.out.println(frogTwo.toString());
        System.out.println("Expected: Frog[Weight:5,Legs:0]");
        System.out.println(frogThree.toString());
        System.out.println("Expected: Frog[Weight:21,Legs:4]");
    }
}
