/**
 * A tester program for class ArrayFrog.
 *
 * @author Qi Yang
 * @version 2022-11-27
 */
public class ArrayFrogTester
{
    public static void main(String[] args)
    {
        Frog[] arrayOne = new Frog[5];
        int count = 3;
        arrayOne[0] = new Frog("12345", 15.5);
        arrayOne[1] = new Frog("66666", 20.0);
        arrayOne[2] = new Frog("55555", 16.6);
        
        ArrayFrog managedArrayOne = new ArrayFrog(arrayOne, count);
        ArrayFrog managedArrayTwo = new ArrayFrog(5);
        
        // Testing method toString()
        System.out.println(managedArrayOne.toString());
        System.out.println("Expected: [Frog[ID=12345,Weight=15.5,Legs=2], " +
            "Frog[ID=66666,Weight=20.0,Legs=2], Frog[ID=55555,Weight=16.6,Legs=2]]");
        System.out.println(managedArrayTwo.toString());
        System.out.println("Expected: []");
                   
        // Testing method sort()
        managedArrayOne.sort();
        System.out.println(managedArrayOne.toString());
        System.out.println("Expected: [Frog[ID=12345,Weight=15.5,Legs=2], " +
            "Frog[ID=55555,Weight=16.6,Legs=2], Frog[ID=66666,Weight=20.0,Legs=2]]");
        managedArrayTwo.sort();
        System.out.println(managedArrayTwo.toString());
        System.out.println("Expected: []");
        
        // Testing method add()
        managedArrayOne.add(new Frog("88888", 15.5));
        managedArrayOne.add(new Frog("44444", 16.6));
        System.out.println(managedArrayOne.toString());
        System.out.println("Expected: [Frog[ID=12345,Weight=15.5,Legs=2], " +
            "Frog[ID=55555,Weight=16.6,Legs=2], Frog[ID=66666,Weight=20.0,Legs=2], " +
            "Frog[ID=88888,Weight=15.5,Legs=2], Frog[ID=44444,Weight=16.6,Legs=2]]");
        managedArrayTwo.add(new Frog("99999", 4.5));
        System.out.println(managedArrayTwo.toString());
        System.out.println("Expected: [Frog[ID=99999,Weight=4.5,Legs=0]]");

        // Testing method sort()
        managedArrayOne.sort();
        System.out.println(managedArrayOne.toString());
        System.out.println("Expected: [Frog[ID=12345,Weight=15.5,Legs=2], " +
            "Frog[ID=88888,Weight=15.5,Legs=2], Frog[ID=44444,Weight=16.6,Legs=2], " +
            "Frog[ID=55555,Weight=16.6,Legs=2], Frog[ID=66666,Weight=20.0,Legs=2]]");
            
        // Testing invalid adding
        managedArrayOne.add(new Frog("99999", 14.4));
        managedArrayOne.add(new Frog("00000", 14.4));
        System.out.println(managedArrayOne.toString());
        System.out.println("Expected: [Frog[ID=12345,Weight=15.5,Legs=2], " +
            "Frog[ID=88888,Weight=15.5,Legs=2], Frog[ID=44444,Weight=16.6,Legs=2], " +
            "Frog[ID=55555,Weight=16.6,Legs=2], Frog[ID=66666,Weight=20.0,Legs=2]]");

        // Testing valid deleting
        Frog frog = managedArrayOne.delete(4);
        System.out.println(frog);
        System.out.println("Expected: Frog[ID=66666,Weight=20.0,Legs=2]");
        frog = managedArrayOne.delete(0);
        System.out.println(frog);
        System.out.println("Expected: Frog[ID=12345,Weight=15.5,Legs=2]");
        System.out.println(managedArrayOne.toString());
        System.out.println("Expected: [Frog[ID=88888,Weight=15.5,Legs=2], " +
            "Frog[ID=44444,Weight=16.6,Legs=2], Frog[ID=55555,Weight=16.6,Legs=2]]");
        
        // Testing invalid deleting
        frog = managedArrayOne.delete(3);
        System.out.println(frog);
        System.out.println("Expected: null");
        frog = managedArrayOne.delete(-1);
        System.out.println(frog);
        System.out.println("Expected: null");
        System.out.println(managedArrayOne.toString());
        System.out.println("Expected: [Frog[ID=88888,Weight=15.5,Legs=2], " +
            "Frog[ID=44444,Weight=16.6,Legs=2], Frog[ID=55555,Weight=16.6,Legs=2]]");
            
        // Testing the second add() method with invalid index 
        managedArrayOne.add(-1, new Frog("99999", 14.4));
        managedArrayOne.add(4, new Frog("66666", 20.4));
        System.out.println(managedArrayOne.toString());
        System.out.println("Expected: [Frog[ID=88888,Weight=15.5,Legs=2], " +
            "Frog[ID=44444,Weight=16.6,Legs=2], Frog[ID=55555,Weight=16.6,Legs=2]]");
            
        // Testing the second add() method with valid index 
        managedArrayOne.add(0, new Frog("99999", 14.4));
        managedArrayOne.add(4, new Frog("66666", 20.4));
        System.out.println(managedArrayOne.toString());
        System.out.println("Expected: [Frog[ID=99999,Weight=14.4,Legs=2], " +
            "Frog[ID=88888,Weight=15.5,Legs=2], Frog[ID=44444,Weight=16.6,Legs=2], " + 
            "Frog[ID=55555,Weight=16.6,Legs=2], Frog[ID=66666,Weight=20.4,Legs=4]]");
            
        // Testing the second add() method when the array is full
        managedArrayOne.add(0, new Frog("abcde", 14.4));
        System.out.println(managedArrayOne.toString());
        System.out.println("Expected: [Frog[ID=99999,Weight=14.4,Legs=2], " +
            "Frog[ID=88888,Weight=15.5,Legs=2], Frog[ID=44444,Weight=16.6,Legs=2], " + 
            "Frog[ID=55555,Weight=16.6,Legs=2], Frog[ID=66666,Weight=20.4,Legs=4]]");
    }
}
