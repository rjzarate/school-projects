/**
 * This is a tester program for class CircleManager.
 * It creates three CircleManager objects to test 
 * each method of class CircleManager.
 * 
 * @author  Qi Yang
 * @version 2022-04-07
 */
public class CircleManagerTester
{
    public static void main(String[] args)
    {
        CircleManager emptyList = new CircleManager();
        
        CircleManager twoCirclesList = new CircleManager();
        twoCirclesList.add(new Circle(2, 5, 5.0));
        twoCirclesList.add(new Circle(2, 7, 10.0)); 
        
        CircleManager fiveCirclesList = new CircleManager();
        fiveCirclesList.add(new Circle(190, 100, 5.0));
        fiveCirclesList.add(new Circle(20, 7, 10.0));
        fiveCirclesList.add(new Circle(50, 13, 100.0));
        fiveCirclesList.add(new Circle(15, 8, 5.0));
        fiveCirclesList.add(new Circle(250, 200, 100.0));
        
        // Testing method firstSmallestCircle
        System.out.println("\nTesting method firstSmallestCircle");
        System.out.println("Smallest circle: " + emptyList.firstSmallestCircle());
        System.out.println("Expected: null");
        System.out.println("Smallest circle: " + twoCirclesList.firstSmallestCircle());
        System.out.println("Expected: Circle[x=2,y=5,radius=5.0]");
        System.out.println("Smallest circle: " + fiveCirclesList.firstSmallestCircle());
        System.out.println("Expected: Circle[x=15,y=8,radius=5.0]");
 
        // Testing method hasCircleWithRadiusGreaterThan10
        System.out.println("\nTesting method hasCircleWithRadiusGreaterThan10");
        System.out.println("hasCircleWithRadiusGreaterThan10: " 
               + emptyList.hasCircleWithRadiusGreaterThan10());
        System.out.println("Expected: false");
        System.out.println("hasCircleWithRadiusGreaterThan10: " 
                + twoCirclesList.hasCircleWithRadiusGreaterThan10());        
        System.out.println("Expected: false");
        System.out.println("hasCircleWithRadiusGreaterThan10: " 
               + fiveCirclesList.hasCircleWithRadiusGreaterThan10());
        System.out.println("Expected: true");
        
        // Testing method toStrong
        System.out.println("\nTesting method toStrong");
        System.out.println("All circles: " + emptyList.toString());
        System.out.println("Expected: CircleManager[]");
        System.out.println("All circles: " + twoCirclesList.toString());
        System.out.println("Expected: CircleManager[Circle[x=2,y=7,radius=10.0], Circle[x=2,y=5,radius=5.0]]");
        System.out.println("All circles: " + fiveCirclesList.toString());
        System.out.println("Expected: CircleManager[Circle[x=250,y=200,radius=100.0], Circle[x=15,y=8,radius=5.0], " +
                    "Circle[x=50,y=13,radius=100.0], Circle[x=20,y=7,radius=10.0], Circle[x=190,y=100,radius=5.0]]");
    }
}
