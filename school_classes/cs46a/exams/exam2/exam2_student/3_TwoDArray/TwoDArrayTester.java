/**
 * A Java tester program for class TwoDArray.
 *
 * @author  Qi Yang
 * @version 2022-11-11
 */
public class TwoDArrayTester
{
    public static void main(String[] args)
    {
        int[][] array1 = {{ 1, 15, 11, 19, 20, 21},
                          {30, 31, 32, -9, 10,  0},
                          {-5, 20, -9, 20, 21, 10},
                          {28, 20, 24, 23, 27, 26},
                          {-8, -9, -5, -4, -7, -5}};
            
        int[][] array2 = {{ 1,  5, 11, 19, 20},
                          {30, 31, 33, 20, 10},
                          {-1, -2, -3, -4, -5}};

        TwoDArray tester1 = new TwoDArray(array1);
        TwoDArray tester2 = new TwoDArray(array2);
        
        System.out.println(tester1.rowMax(0));
        System.out.println("Expected: 21");
        System.out.println(tester1.rowMax(3));
        System.out.println("Expected: 28");
        System.out.println(tester1.rowMax(4));
        System.out.println("Expected: -4");

        System.out.println(tester2.rowMax(0));
        System.out.println("Expected: 20");
        System.out.println(tester2.rowMax(1));
        System.out.println("Expected: 33");
        System.out.println(tester2.rowMax(2));
        System.out.println("Expected: -1");
        
        System.out.printf("%.2f%n", tester1.columnAverage(0));
        System.out.println("Expected: 9.20");
        System.out.printf("%.2f%n", tester1.columnAverage(2));
        System.out.println("Expected: 10.60");
        System.out.printf("%.2f%n", tester1.columnAverage(4));
        System.out.println("Expected: 14.20");
        
        System.out.printf("%.2f%n", tester2.columnAverage(1));
        System.out.println("Expected: 11.33");
        System.out.printf("%.2f%n", tester2.columnAverage(3));
        System.out.println("Expected: 11.67");
        System.out.printf("%.2f%n", tester2.columnAverage(4));
        System.out.println("Expected: 8.33");
        
        System.out.printf("%d%n", tester1.countInRange(0, 20));
        System.out.println("Expected: 11");
        System.out.printf("%d%n", tester1.countInRange(-3, -1));
        System.out.println("Expected: 0");
        System.out.printf("%d%n", tester2.countInRange(0, 20));
        System.out.println("Expected: 7");
        System.out.printf("%d%n", tester2.countInRange(-3, -1));
        System.out.println("Expected: 3");
    }
}
