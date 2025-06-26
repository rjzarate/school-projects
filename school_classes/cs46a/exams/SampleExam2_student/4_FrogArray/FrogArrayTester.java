/**
 * A Java tester program for class FrogArray.
 *
 * @author  Qi Yang
 * @version 2022-10-28
 */
public class FrogArrayTester
{
    public static void main(String[] args)
    {
        Frog[] arrayOne = new Frog[4];
        FrogArray frgoArrayOne = new FrogArray(arrayOne, 0);
        
        Frog[] arrayTwo = new Frog[5];
        arrayTwo[0] = new Frog(5);
        arrayTwo[1] = new Frog(25);
        arrayTwo[2] = new Frog(12);
        FrogArray frgoArrayTwo = new FrogArray(arrayTwo, 3);

        // Testing method toString()
        System.out.println(frgoArrayOne.toString());
        System.out.println("Expected: []");
        System.out.println(frgoArrayTwo.toString());
        System.out.println("Expected: [Frog[Weight:5,Legs:0], Frog[Weight:25,Legs:4], " +
                                      "Frog[Weight:12,Legs:2]]");
        
        // Testing method lastOutOfRange()
        System.out.println(frgoArrayOne.lastOutOfRange(6, 24));
        System.out.println("Expected: null");

        System.out.println(frgoArrayTwo.lastOutOfRange(6, 24));
        System.out.println("Expected: Frog[Weight:25,Legs:4]");
        
        System.out.println(frgoArrayTwo.lastOutOfRange(6, 25));
        System.out.println("Expected: Frog[Weight:5,Legs:0]");
        
        System.out.println(frgoArrayTwo.lastOutOfRange(5, 25));
        System.out.println("Expected: null");
        
        // Testing method add()
        frgoArrayTwo.add(new Frog(10));
        frgoArrayTwo.add(new Frog(15));
        frgoArrayTwo.add(new Frog(20));
        
        System.out.println(frgoArrayTwo.toString());
        System.out.println("Expected: [Frog[Weight:5,Legs:0], Frog[Weight:25,Legs:4], " +
                                      "Frog[Weight:12,Legs:2], Frog[Weight:10,Legs:2], " +
                                      "Frog[Weight:15,Legs:2]]");

        // Testing method delete()
        System.out.println(frgoArrayTwo.delete(1));
        System.out.println("Expected: Frog[Weight:25,Legs:4]");
        
        System.out.println(frgoArrayTwo.delete(3));
        System.out.println("Expected: Frog[Weight:15,Legs:2]");

        System.out.println(frgoArrayTwo.delete(0));
        System.out.println("Expected: Frog[Weight:5,Legs:0]");
        
        System.out.println(frgoArrayTwo.toString());
        System.out.println("Expected: [Frog[Weight:12,Legs:2], Frog[Weight:10,Legs:2]]");
                                      
        // Testing method delete() with invalid index
        System.out.println(frgoArrayTwo.delete(-1));
        System.out.println("Expected: null");

        System.out.println(frgoArrayTwo.delete(3));
        System.out.println("Expected: null");
        
        System.out.println(frgoArrayTwo.toString());
        System.out.println("Expected: [Frog[Weight:12,Legs:2], Frog[Weight:10,Legs:2]]");
    }
}
