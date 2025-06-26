import java.util.ArrayList;
/**
 * A Java tester program for class FrogList.
 *
 * @author  Qi Yang
 * @version 2022-10-28
 */
public class FrogListTester
{
    public static void main(String[] args)
    {
        ArrayList<Frog> listTwo = new ArrayList<Frog>();
        listTwo.add(new Frog(5));
        listTwo.add(new Frog(10));

        ArrayList<Frog> listFive = new ArrayList<Frog>();
        listFive.add(new Frog(15));
        listFive.add(new Frog(25));
        listFive.add(new Frog(20));
        listFive.add(new Frog(6));
        listFive.add(new Frog(21));
        
        FrogList frogListEmpty = new FrogList();
        FrogList frogListTwo = new FrogList(listTwo);
        FrogList frogListFive = new FrogList(listFive);
        
        // Testing method toString()
        System.out.println(frogListEmpty.toString());
        System.out.println("Expected: []");
        System.out.println(frogListTwo.toString());
        System.out.println("Expected: [Frog[Weight:5,Legs:0], Frog[Weight:10,Legs:2]]");
        System.out.println(frogListFive.toString());
        System.out.println("Expected: [Frog[Weight:15,Legs:2], Frog[Weight:25,Legs:4], " +
                                      "Frog[Weight:20,Legs:2], Frog[Weight:6,Legs:2], " +
                                      "Frog[Weight:21,Legs:4]]");
        
        // Testing method countOfOutOfRange() on frogListFive
        System.out.println(frogListFive.countOfOutOfRange(6, 25));
        System.out.println("Expected: 0");
        System.out.println(frogListFive.countOfOutOfRange(6, 19));
        System.out.println("Expected: 3");
        System.out.println(frogListFive.countOfOutOfRange(7, 14));
        System.out.println("Expected: 5");

        // Testing method swap() on frogListFive
        frogListFive.swap(1, 4);
        frogListFive.swap(2, 3);
        System.out.println(frogListFive.toString());
        System.out.println("Expected: [Frog[Weight:15,Legs:2], Frog[Weight:21,Legs:4], " +
                                      "Frog[Weight:6,Legs:2], Frog[Weight:20,Legs:2], " +
                                      "Frog[Weight:25,Legs:4]]");
        
        // Testing method swap() on frogListFive with invalid indexes
        frogListFive.swap(-1, 4);
        frogListFive.swap(5, 3);
        frogListFive.swap(2, -2);
        frogListFive.swap(0, 6);
        System.out.println(frogListFive.toString());
        System.out.println("Expected: [Frog[Weight:15,Legs:2], Frog[Weight:21,Legs:4], " +
                                      "Frog[Weight:6,Legs:2], Frog[Weight:20,Legs:2], " +
                                      "Frog[Weight:25,Legs:4]]");

        // Testing method delete() on frogListFive
        System.out.println(frogListFive.delete(4));
        System.out.println("Expected: Frog[Weight:25,Legs:4]");
        
        System.out.println(frogListFive.delete(1));
        System.out.println("Expected: Frog[Weight:21,Legs:4]");
        
        System.out.println(frogListFive.delete(0));
        System.out.println("Expected: Frog[Weight:15,Legs:2]");
        
        System.out.println(frogListFive.toString());
        System.out.println("Expected: [Frog[Weight:6,Legs:2], Frog[Weight:20,Legs:2]]");
        
        System.out.println(frogListFive.delete(-1));
        System.out.println("Expected: null");
        
        System.out.println(frogListFive.delete(2));
        System.out.println("Expected: null");
        
        System.out.println(frogListFive.toString());
        System.out.println("Expected: [Frog[Weight:6,Legs:2], Frog[Weight:20,Legs:2]]");
        
        // Testing method add() on frogListFive
        frogListFive.addLast(new Frog(1));
        frogListFive.addFirst(new Frog(3));
        frogListFive.addLast(new Frog(2));
        System.out.println(frogListFive.toString());
        System.out.println("Expected: [Frog[Weight:3,Legs:0], Frog[Weight:6,Legs:2], " +
                                      "Frog[Weight:20,Legs:2], Frog[Weight:1,Legs:0], " +
                                      "Frog[Weight:2,Legs:0]]");
        frogListFive.swap(0, 4);
        System.out.println(frogListFive.toString());
        System.out.println("Expected: [Frog[Weight:2,Legs:0], Frog[Weight:6,Legs:2], " +
                                      "Frog[Weight:20,Legs:2], Frog[Weight:1,Legs:0], " +
                                      "Frog[Weight:3,Legs:0]]");
        frogListFive.swap(4, 0);
        System.out.println(frogListFive.toString());
        System.out.println("Expected: [Frog[Weight:3,Legs:0], Frog[Weight:6,Legs:2], " +
                                      "Frog[Weight:20,Legs:2], Frog[Weight:1,Legs:0], " +
                                      "Frog[Weight:2,Legs:0]]");
    }
}
