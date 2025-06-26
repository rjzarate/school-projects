/**
 * This is a tester program for class CircleList.
 * It creates three CircleList objects to test 
 * each method of the class.
 * 
 * @author  Qi Yang
 * @version 2022-10-25
 */
public class CircleListTester
{
    public static void main(String[] args)
    {
        CircleList emptyList = new CircleList();
        CircleList twoCirclesList = new CircleList();
        CircleList fiveCirclesList = new CircleList();

        // Testing method add()
        twoCirclesList.add(new Circle(2, 5, 5.51));
        twoCirclesList.add(new Circle(-2, -7, 10.92)); 
        
        fiveCirclesList.add(new Circle(190, 100, -5.25));
        fiveCirclesList.add(new Circle(20, 7, 10.55));
        fiveCirclesList.add(new Circle(50, 13, 100.08));
        fiveCirclesList.add(new Circle(15, 8, 0));
        fiveCirclesList.add(new Circle(250, 200, 100.09));
        
        // Testing method average()       
        System.out.printf("Average area: %.4f.%n", emptyList.averageArea());
        System.out.println("Expected: 0.0000.");
        System.out.printf("Average area: %.4f.%n", twoCirclesList.averageArea());
        System.out.println("Expected: 235.0013.");
        System.out.printf("Average area: %.4f.%n", fiveCirclesList.averageArea());
        System.out.println("Expected: 12658.9326.");
        
        // Testing method count()
        System.out.printf("Number of circles: %d.%n", emptyList.count());
        System.out.println("Expected: 0.");
        System.out.printf("Number of circles: %d.%n", twoCirclesList.count());
        System.out.println("Expected: 2.");
        System.out.printf("Number of circles: %d.%n", fiveCirclesList.count());
        System.out.println("Expected: 5.");
        
        // Testing method toString()        
        System.out.println(emptyList.toString());
        System.out.println("Expected: []");
        System.out.println(twoCirclesList.toString());
        System.out.println("Expected: [Circle[x=2,y=5,radius=5.51], Circle[x=-2,y=-7,radius=10.92]]");
        System.out.println(fiveCirclesList.toString());
        System.out.println("Expected: [Circle[x=190,y=100,radius=1.0], Circle[x=20,y=7,radius=10.55], " +
                                      "Circle[x=50,y=13,radius=100.08], Circle[x=15,y=8,radius=1.0], " +
                                      "Circle[x=250,y=200,radius=100.09]]");

        // Testing method largestArea()
        System.out.printf("Largest area: %.4f.%n", emptyList.largestArea());
        System.out.println("Expected: 0.0000.");
        System.out.printf("Largest area: %.4f.%n", twoCirclesList.largestArea());
        System.out.println("Expected: 374.6236.");
        System.out.printf("Largest area: %.4f.%n", fiveCirclesList.largestArea());
        System.out.println("Expected: 31472.5007.");
        
        // Testing method updatingRadius() with valid indxe
        fiveCirclesList.updatingRadius(0, 9.99);
        fiveCirclesList.updatingRadius(fiveCirclesList.count() - 1, 99.99);
        System.out.println(fiveCirclesList.toString());
        System.out.println("Expected: [Circle[x=190,y=100,radius=9.99], Circle[x=20,y=7,radius=10.55], " +
                                      "Circle[x=50,y=13,radius=100.08], Circle[x=15,y=8,radius=1.0], " +
                                      "Circle[x=250,y=200,radius=99.99]]");
        
        System.out.printf("Average area: %.4f.\n" , fiveCirclesList.averageArea());
        System.out.println("Expected: 12708.4392.");
        
        // Testing method updateRadius() with invalid indxe
        fiveCirclesList.updatingRadius(-1, 29.99);
        fiveCirclesList.updatingRadius(fiveCirclesList.count(), 999.99);
        System.out.println(fiveCirclesList.toString());
        System.out.println("Expected: [Circle[x=190,y=100,radius=9.99], Circle[x=20,y=7,radius=10.55], " +
                                      "Circle[x=50,y=13,radius=100.08], Circle[x=15,y=8,radius=1.0], " +
                                      "Circle[x=250,y=200,radius=99.99]]");
        
        System.out.printf("Average area: %.4f.\n" , fiveCirclesList.averageArea());
        System.out.println("Expected: 12708.4392.");
    }
}