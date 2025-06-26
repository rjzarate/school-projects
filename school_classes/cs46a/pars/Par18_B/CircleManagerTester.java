/**
 * This is a tester program for class CircleManager.
 * It creates two CircleManager objects to test 
 * each method of class CircleManager.
 * 
 * @author  Qi Yang
 * @version 2022-11-01
 */
public class CircleManagerTester
{
    public static void main(String[] args)
    {
        Circle[] arrayTwo = {new Circle(3, 5, 5.0), 
                             new Circle(2, 7, 10.0)};
        CircleManager twoCircles = new CircleManager(arrayTwo);
        
        Circle[] arrayFive = {new Circle(190, 100, 5.0),
                              new Circle(20, 7, 10.0),
                              new Circle(50, 13, 100.0),
                              new Circle(15, 8, 5.0),
                              new Circle(250, 200, 100.0)};
        CircleManager fiveCircles = new CircleManager(arrayFive);
        
        // Testing method maxX()
        System.out.println(twoCircles.maxX());
        System.out.println("Expected: 3");
        System.out.println(fiveCircles.maxX());
        System.out.println("Expected: 250");
 
        // Testing method countOfLargerThanLimit() with limit 10
        System.out.println(twoCircles.countOfLargerThanLimit(10));
        System.out.println("Expected: 2");
        System.out.println(fiveCircles.countOfLargerThanLimit(10));
        System.out.println("Expected: 5");

        // Testing method countOfLargerThanLimit() with limit 100
        System.out.println(twoCircles.countOfLargerThanLimit(100));
        System.out.println("Expected: 1");
        System.out.println(fiveCircles.countOfLargerThanLimit(100));
        System.out.println("Expected: 3");
        
        // Testing method averageArea()
        System.out.printf("%.4f%n", twoCircles.averageArea());
        System.out.println("Expected: 196.3495");
        System.out.printf("%.4f%n", fiveCircles.averageArea());
        System.out.println("Expected: 12660.6184");
    }
}
