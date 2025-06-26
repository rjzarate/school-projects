/**
 * A Java tester program for class FrogArray.
 *
 * @author  Qi Yang
 * @version 2022-11-17
 */
public class FrogArrayTester
{
    public static void main(String[] args)
    {
        Frog[] arrayOne = new Frog[4];
        arrayOne[0] = new Frog(5);
        FrogArray frogArrayOne = new FrogArray(10);
        
        Frog[] arrayTwo = new Frog[5];
        arrayTwo[0] = new Frog(5);
        arrayTwo[1] = new Frog(25);
        arrayTwo[2] = new Frog(12);
        FrogArray frogArrayTwo = new FrogArray(arrayTwo, 3);

        // Testing method firstOutOfRange()
        Frog frog = frogArrayOne.lastInRange(4, 6);
        System.out.println(frog);
        System.out.println("Expected: null");
        
        frog = frogArrayTwo.lastInRange(6, 24);
        System.out.println(frog.toString());
        System.out.println("Expected: Frog[Weight:12,Legs:2]");
        
        frog = frogArrayTwo.lastInRange(5, 10);
        System.out.println(frog);
        System.out.println("Expected: Frog[Weight:5,Legs:0]");
        
        frog = frogArrayTwo.lastInRange(1, 4);
        System.out.println(frog);
        System.out.println("Expected: null");
        
        // Testing method add()
        frogArrayTwo.add(new Frog(10));
        frogArrayTwo.add(new Frog(15));
        frogArrayTwo.add(new Frog(20));
        
        // Testing method firstOutOfRange()
        frog = frogArrayTwo.lastInRange(6, 24);
        System.out.println(frog.toString());
        System.out.println("Expected: Frog[Weight:15,Legs:2]");
        
        frog = frogArrayTwo.lastInRange(4, 5);
        System.out.println(frog.toString());
        System.out.println("Expected: Frog[Weight:5,Legs:0]");
        
        frog = frogArrayTwo.lastInRange(26, 30);
        System.out.println(frog);
        System.out.println("Expected: null");
    }
}
