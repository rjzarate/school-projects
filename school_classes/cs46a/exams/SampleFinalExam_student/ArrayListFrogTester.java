import java.util.ArrayList;
/**
 * A tester program for class ArrayListFrog.
 *
 * @author Qi Yang
 * @version 2022-11-27
 */
public class ArrayListFrogTester
{
    public static void main(String[] args)
    {
        // Create an object of ArrayListFrog without any elements
        ArrayListFrog listOne = new ArrayListFrog();
        
        // Create an array list of Frog and add 3 frogs to it
        ArrayList<Frog> list = new ArrayList<Frog>();
        list.add(new Frog("54321", 15.1));
        list.add(new Frog("55555", 4.6));
        list.add(new Frog("66666", 20.7));
        
        // Create another object of ArrayListFrog with 3 elements
        ArrayListFrog listTwo = new ArrayListFrog(list);

        // Testing method toString()
        System.out.println(listOne.toString());
        System.out.println("Expected: []");
        System.out.println(listTwo.toString());
        System.out.println("Expected: [Frog[ID=54321,Weight=15.1,Legs=2], " +
                                      "Frog[ID=55555,Weight=4.6,Legs=0], " +
                                      "Frog[ID=66666,Weight=20.7,Legs=4]]");
        
        // Testing method firstInTheRange()
        System.out.println(listOne.firstInTheRange(15.1, 20.7));
        System.out.println("Expected: null");
        System.out.println(listTwo.firstInTheRange(15.1, 20.7));
        System.out.println("Expected: Frog[ID=54321,Weight=15.1,Legs=2]");
        System.out.println(listTwo.firstInTheRange(15.2, 20.7));
        System.out.println("Expected: Frog[ID=66666,Weight=20.7,Legs=4]");
        System.out.println(listTwo.firstInTheRange(5.0, 15.0));
        System.out.println("Expected: null");

        // Testing method add()
        listTwo.add(3, new Frog("77777", 22.9));
        listTwo.add(0, new Frog("88888", 15.0));
        System.out.println(listTwo.toString());
        System.out.println("Expected: [Frog[ID=88888,Weight=15.0,Legs=2], " +
                                      "Frog[ID=54321,Weight=15.1,Legs=2], " +
                                      "Frog[ID=55555,Weight=4.6,Legs=0], " +
                                      "Frog[ID=66666,Weight=20.7,Legs=4], " +
                                      "Frog[ID=77777,Weight=22.9,Legs=4]]");
        System.out.println(listTwo.firstInTheRange(15.0, 21.0));
        System.out.println("Expected: Frog[ID=88888,Weight=15.0,Legs=2]");


        // Testing method swap()
        listTwo.swap(4, 3);
        listTwo.swap(0, 2);
        System.out.println(listTwo.toString());
        System.out.println("Expected: [Frog[ID=55555,Weight=4.6,Legs=0], " +
                                      "Frog[ID=54321,Weight=15.1,Legs=2], " +
                                      "Frog[ID=88888,Weight=15.0,Legs=2], " +
                                      "Frog[ID=77777,Weight=22.9,Legs=4], " +
                                      "Frog[ID=66666,Weight=20.7,Legs=4]]");
        System.out.println(listTwo.firstInTheRange(15.0, 21.0));
        System.out.println("Expected: Frog[ID=54321,Weight=15.1,Legs=2]");
        
        listTwo.swap(1, 4);
        listTwo.swap(3, 0);
        System.out.println(listTwo.toString());
        System.out.println("Expected: [Frog[ID=77777,Weight=22.9,Legs=4], " +
                                      "Frog[ID=66666,Weight=20.7,Legs=4], " +
                                      "Frog[ID=88888,Weight=15.0,Legs=2], " +
                                      "Frog[ID=55555,Weight=4.6,Legs=0], " +
                                      "Frog[ID=54321,Weight=15.1,Legs=2]]");

        // Testing invalid swapping
        listTwo.swap(5, 0);
        listTwo.swap(-1, 2);
        listTwo.swap(0, -1);
        listTwo.swap(1, 5);
        System.out.println(listTwo.toString());
        System.out.println("Expected: [Frog[ID=77777,Weight=22.9,Legs=4], " +
                                      "Frog[ID=66666,Weight=20.7,Legs=4], " +
                                      "Frog[ID=88888,Weight=15.0,Legs=2], " +
                                      "Frog[ID=55555,Weight=4.6,Legs=0], " +
                                      "Frog[ID=54321,Weight=15.1,Legs=2]]");

        // Testing method sort()
        listTwo.sort();
        System.out.println(listTwo.toString());
        System.out.println("Expected: [Frog[ID=55555,Weight=4.6,Legs=0], " +
                                      "Frog[ID=88888,Weight=15.0,Legs=2], " +
                                      "Frog[ID=54321,Weight=15.1,Legs=2], " +
                                      "Frog[ID=66666,Weight=20.7,Legs=4], " +
                                      "Frog[ID=77777,Weight=22.9,Legs=4]]");
        
        listTwo.add(5, new Frog("22222", 15.1));
        listTwo.add(0, new Frog("98765", 4.6));
        System.out.println(listTwo.toString());
        System.out.println("Expected: [Frog[ID=98765,Weight=4.6,Legs=0], " +
                                      "Frog[ID=55555,Weight=4.6,Legs=0], " +
                                      "Frog[ID=88888,Weight=15.0,Legs=2], " +
                                      "Frog[ID=54321,Weight=15.1,Legs=2], " +
                                      "Frog[ID=66666,Weight=20.7,Legs=4], " +
                                      "Frog[ID=77777,Weight=22.9,Legs=4], " +
                                      "Frog[ID=22222,Weight=15.1,Legs=2]]");

        listTwo.sort();
        System.out.println(listTwo.toString());
        System.out.println("Expected: [Frog[ID=55555,Weight=4.6,Legs=0], " +
                                      "Frog[ID=98765,Weight=4.6,Legs=0], " +
                                      "Frog[ID=88888,Weight=15.0,Legs=2], " +
                                      "Frog[ID=22222,Weight=15.1,Legs=2], " +
                                      "Frog[ID=54321,Weight=15.1,Legs=2], " +
                                      "Frog[ID=66666,Weight=20.7,Legs=4], " +
                                      "Frog[ID=77777,Weight=22.9,Legs=4]]");

        // Testing method delete()
        Frog frog = listTwo.delete(0);        
        System.out.println(frog);
        System.out.println("Expected: Frog[ID=55555,Weight=4.6,Legs=0]");

        frog = listTwo.delete(5);        
        System.out.println(frog);
        System.out.println("Expected: Frog[ID=77777,Weight=22.9,Legs=4]");
        
        frog = listTwo.delete(1);        
        System.out.println(frog);
        System.out.println("Expected: Frog[ID=88888,Weight=15.0,Legs=2]");

        System.out.println(listTwo.toString());
        System.out.println("Expected: [Frog[ID=98765,Weight=4.6,Legs=0], " +
                                      "Frog[ID=22222,Weight=15.1,Legs=2], " +
                                      "Frog[ID=54321,Weight=15.1,Legs=2], " +
                                      "Frog[ID=66666,Weight=20.7,Legs=4]]");


        // Invalid deleting
        frog = listTwo.delete(4);
        System.out.println(frog);
        System.out.println("Expected: null");

        frog = listTwo.delete(-1);        
        System.out.println(frog);
        System.out.println("Expected: null");

        System.out.println(listTwo.toString());
        System.out.println("Expected: [Frog[ID=98765,Weight=4.6,Legs=0], " +
                                      "Frog[ID=22222,Weight=15.1,Legs=2], " +
                                      "Frog[ID=54321,Weight=15.1,Legs=2], " +
                                      "Frog[ID=66666,Weight=20.7,Legs=4]]");
    }
}
