/**
 * A Java tester program to test class TwoDArrayDouble.
 * 
 * @author  Qi Yang
 * @version 2022-12-12
 */
public class TwoDArrayDoubleTester
{
    public static void main(String[] args)
    {
        double[][] doubleArray = { {30.0, 27.5, 27.0, 26.5, 25.0, 24.5},
                                   {27.0, 25.5, 17.5, 27.5, 27.0, 25.5},
                                   {-26.0, -26.5, -24.0, -25.0, -27.5, -29.0},
                                   {28.0, 30.0, 26.5, 26.0, 29.5, 26.5},
                                   {27.5, 24.5, 25.0, 26.5, 29.0, 28.0},
                                   {24.5, 25.5, 27.5, 24.5, 26.0, 25.5},
                                   {30.0, 27.5, 26.0, 27.5, 24.5, 26.5},
                                   {16.5, 20.5, 21.5, 22.5, 27.0, 29.5} };
                                   
        double[][] anotherArray = { {1.1, 1.2, 1.3, 1.4},
                                    {-10, -20, -30, -40},
                                    {5.5, 6.6, 7.7, 8.8} };
        
        TwoDArrayDouble tester1 = new TwoDArrayDouble(doubleArray);
        TwoDArrayDouble tester2 = new TwoDArrayDouble(anotherArray);
        
        // Testing method maxRowValue()
        System.out.println(tester1.maxRowValue(0));
        System.out.println("Expected: 30.0");

        System.out.println(tester1.maxRowValue(2));
        System.out.println("Expected: -24.0");
        
        System.out.println(tester1.maxRowValue(7));
        System.out.println("Expected: 29.5");
        
        System.out.println(tester2.maxRowValue(0));
        System.out.println("Expected: 1.4");
        
        System.out.println(tester2.maxRowValue(1));
        System.out.println("Expected: -10.0");

        // Testing method columnCountOfTarget()
        System.out.println(tester1.columnCountOfTarget(0, 30));
        System.out.println("Expected: 2");
       
        System.out.println(tester1.columnCountOfTarget(1, 20.5));
        System.out.println("Expected: 1");
        
        System.out.println(tester1.columnCountOfTarget(5, 11.5));
        System.out.println("Expected: 0");

        System.out.println(tester2.columnCountOfTarget(3, 8.8));
        System.out.println("Expected: 1");

        System.out.println(tester2.columnCountOfTarget(1, 8.8));
        System.out.println("Expected: 0");

        // Testing method averageOfAllValues()
        System.out.printf("%.4f%n", tester1.averageOfAllValues());
        System.out.println("Expected: 19.4271");
        
        System.out.printf("%.4f%n", tester2.averageOfAllValues());
        System.out.println("Expected: -5.5333");        
    }
}
