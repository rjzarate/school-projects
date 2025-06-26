/**
 * A Java tester program for class FrogList.
 *
 * @author  Qi Yang
 * @version 2022-10-14
 */
public class FrogListTester
{
    public static void main(String[] args)
    {
        FrogList myList = new FrogList();
        
        System.out.println(myList.toString());
        System.out.println("Expected: []");
        System.out.println(myList.countInRange(1, 10));
        System.out.println("Expected: 0");
        
        myList.add(new Frog(0));
        myList.add(new Frog(10));

        System.out.println(myList.toString());
        System.out.println("Expected: [Frog[Weight:10,Legs:2], Frog[Weight:1,Legs:0]]");
        System.out.println(myList.countInRange(1, 10));
        System.out.println("Expected: 2");

        Frog frog = myList.get(0);
        
        System.out.println(frog);
        System.out.println("Expected: Frog[Weight:10,Legs:2]");
        
        frog.grow(1);
        
        System.out.println(myList.toString());
        System.out.println("Expected: [Frog[Weight:11,Legs:2], Frog[Weight:1,Legs:0]]");
        System.out.println(myList.countInRange(1, 10));
        System.out.println("Expected: 1");
        
        frog = myList.get(2);
        
        System.out.println(frog);
        System.out.println("Expected: null");
        
        myList.add(new Frog(21));
        myList.add(new Frog(5));

        System.out.println(myList.toString());
        System.out.println("Expected: [Frog[Weight:5,Legs:0], Frog[Weight:21,Legs:4], Frog[Weight:11,Legs:2], Frog[Weight:1,Legs:0]]");
        System.out.println(myList.countInRange(1, 10));
        System.out.println("Expected: 2");
        
        System.out.println(myList.countInRange(5, 21));
        System.out.println("Expected: 3");
    }
}