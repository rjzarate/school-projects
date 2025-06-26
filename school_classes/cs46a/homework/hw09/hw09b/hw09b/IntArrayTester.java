import java.util.Arrays;
/**
 * A Java tester program for class IntArray.
 * 
 * @author  Qi Yang
 * @version 2022-10-21
 */
public class IntArrayTester
{
    public static void main(String[] args)
    {
        IntArray tester1 = new IntArray(new int[10], 0);
        
        int[] array2 = new int[7];     
        array2[0] = -5;
        array2[1] = -3;
        IntArray tester2 = new IntArray(array2, 2);
        
        int[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        IntArray tester3 = new IntArray(array3, 10);

        // Testing method toString()
        System.out.println(tester1.toString());
        System.out.println("Expected: []");
        System.out.println(tester2.toString());
        System.out.println("Expected: [-5, -3]");
        System.out.println(tester3.toString());
        System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]");
        
        // Testing method lastNegative()
        System.out.println(tester1.lastNegative());
        System.out.println("Expected: 0");
        System.out.println(tester2.lastNegative());
        System.out.println("Expected: -3");
        System.out.println(tester3.lastNegative());
        System.out.println("Expected: 0");

        // Testing method countOfOutRange()
        System.out.println(tester1.countOfOutRange(2, 5));
        System.out.println("Expected: 0");
        System.out.println(tester2.countOfOutRange(2, 5));
        System.out.println("Expected: 2");
        System.out.println(tester3.countOfOutRange(2, 5));
        System.out.println("Expected: 6");
        
        System.out.println(tester1.countOfOutRange(-3, 1));
        System.out.println("Expected: 0");
        System.out.println(tester2.countOfOutRange(-3, 1));
        System.out.println("Expected: 1");
        System.out.println(tester3.countOfOutRange(-3, 1));
        System.out.println("Expected: 8");
        
        // Testing method add 
        tester1.add(5);
        tester1.add(-4);
        tester2.add(5);
        tester2.add(-4);
        tester3.add(5);
        tester3.add(-4);

        // Testing method toString()
        System.out.println(tester1.toString());
        System.out.println("Expected: [5, -4]");
        System.out.println(tester2.toString());
        System.out.println("Expected: [-5, -3, 5, -4]");
        System.out.println(tester3.toString());
        System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]");

        // Testing method remove 
        tester1.remove(2);
        tester1.remove(-1);
        tester1.remove(0);
        tester2.remove(4);
        tester2.remove(-1);
        tester2.remove(3);
        tester3.remove(10);
        tester3.remove(-4);
        tester3.remove(1);

        // Testing method toString()
        System.out.println(tester1.toString());
        System.out.println("Expected: [-4]");
        System.out.println(tester2.toString());
        System.out.println("Expected: [-5, -3, 5]");
        System.out.println(tester3.toString());
        System.out.println("Expected: [1, 3, 4, 5, 6, 7, 8, 9, 0]");
    }
}