import java.util.Scanner;
/**
 * A Java program to test class CircleArray.
 *
 * @author  Qi Yang
 * @version 2022-11-01
 */
public class CircleArrayTester
{
    public static void main(String[] args)
    {
        CircleArray manager10 = new CircleArray(10);
        CircleArray manager5 = new CircleArray(5);
              
        // Testing method toString()
        System.out.println(manager10.toString());
        System.out.println("Expected: []");
        System.out.println(manager5.toString());
        System.out.println("Expected: []");

        // Testing method lastCircleLargerThanLimit()
        System.out.println(manager10.lastCircleLargerThanLimit(5));
        System.out.println("Expected: null");
        System.out.println(manager5.lastCircleLargerThanLimit(5));
        System.out.println("Expected: null");
        
        // Add 3 circle to manager10
        for (int i = 1; i <= 3; i ++)
             manager10.add(0, new Circle((int)Math.pow(i + 2, 2), i * 5, i));

        // Add 2 circle to manager5
        manager5.add(0, new Circle(5, 4, 3.5));
        manager5.add(1, new Circle(4, 5, 2.5));

        // Testing method toString()
        System.out.println(manager10.toString());
        System.out.println("Expected: [Circle[x=25,y=15,radius=3.0], " +
                           "Circle[x=16,y=10,radius=2.0], Circle[x=9,y=5,radius=1.0]]");
        System.out.println(manager5.toString());
        System.out.println("Expected: [Circle[x=5,y=4,radius=3.5], Circle[x=4,y=5,radius=2.5]]");
        
        // Testing method lastCircleLargerThanLimit() with limit 10
        System.out.println(manager10.lastCircleLargerThanLimit(10));
        System.out.println("Expected: Circle[x=16,y=10,radius=2.0]");
        System.out.println(manager5.lastCircleLargerThanLimit(10));
        System.out.println("Expected: Circle[x=4,y=5,radius=2.5]");
        
        // Testing method lastCircleLargerThanLimit() with limit 20
        System.out.println(manager10.lastCircleLargerThanLimit(20));
        System.out.println("Expected: Circle[x=25,y=15,radius=3.0]");
        System.out.println(manager5.lastCircleLargerThanLimit(20));
        System.out.println("Expected: Circle[x=5,y=4,radius=3.5]");
        
        // Testing method lastCircleLargerThanLimit() with limit 2000
        System.out.println(manager10.lastCircleLargerThanLimit(2000));
        System.out.println("Expected: null");
        System.out.println(manager5.lastCircleLargerThanLimit(2000));
        System.out.println("Expected: null");
        
        // Adding with invalid index
        manager5.add(-1, new Circle(50, 4, 3.5));
        manager5.add(3, new Circle(40, 5, 2.5));
        
        // Testing method toString()
        System.out.println(manager5.toString());
        System.out.println("Expected: [Circle[x=5,y=4,radius=3.5], Circle[x=4,y=5,radius=2.5]]");

        // Adding 3 more to manager5
        manager5.add(2, new Circle(50, 4, 3.5));
        manager5.add(3, new Circle(40, 5, 2.5));
        manager5.add(3, new Circle(40, 50, 2.5));
        
        // Testing method toString()
        System.out.println(manager5.toString());
        System.out.println("Expected: [Circle[x=5,y=4,radius=3.5], Circle[x=4,y=5,radius=2.5], " +
                           "Circle[x=50,y=4,radius=3.5], Circle[x=40,y=50,radius=2.5], Circle[x=40,y=5,radius=2.5]]");

        // Adding one more to manager5
        manager5.add(2, new Circle(500, 400, 3.5));
        
        // Testing method toString()
        System.out.println(manager5.toString());
        System.out.println("Expected: [Circle[x=5,y=4,radius=3.5], Circle[x=4,y=5,radius=2.5], " +
                           "Circle[x=50,y=4,radius=3.5], Circle[x=40,y=50,radius=2.5], Circle[x=40,y=5,radius=2.5]]");
                           
        // Removing one from manager5
        System.out.println(manager5.remove(1));
        System.out.println("Expected: Circle[x=4,y=5,radius=2.5]");
        
        // Removing another from manager5
        System.out.println(manager5.remove(3));
        System.out.println("Expected: Circle[x=40,y=5,radius=2.5]");
        
        // Testing method toString()
        System.out.println(manager5.toString());
        System.out.println("Expected: [Circle[x=5,y=4,radius=3.5], " +
                           "Circle[x=50,y=4,radius=3.5], Circle[x=40,y=50,radius=2.5]]");

        // Removing with invalid index
        System.out.println(manager5.remove(-1));
        System.out.println("Expected: null");
        
        System.out.println(manager5.remove(3));
        System.out.println("Expected: null");

        // Testing method toString()
        System.out.println(manager5.toString());
        System.out.println("Expected: [Circle[x=5,y=4,radius=3.5], " +
                           "Circle[x=50,y=4,radius=3.5], Circle[x=40,y=50,radius=2.5]]");

    }
}
