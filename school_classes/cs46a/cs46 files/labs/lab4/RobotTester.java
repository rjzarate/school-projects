/**
 * A Java tester program for class Robot.
 *
 * @author  Qi Yang
 * @version 2022-09-15
 */
public class RobotTester
{
    public static void main(String [] args)
    {
        Robot robot1 = new Robot(10, 20, "myrobot.jpeg"); 
        Robot robot2 = new Robot(100, 300, "smartRobot.jfif"); 

        robot1.draw();
        robot2.draw();
        
        System.out.println(robot1.getX());
        System.out.println("Expected: 10.0");
        System.out.println(robot1.getY());
        System.out.println("Expected: 20.0");
        System.out.println(robot2.getX());
        System.out.println("Expected: 100.0");
        System.out.println(robot2.getY());
        System.out.println("Expected: 300.0");
        
        robot1.moveRight();
        System.out.println(robot1.getX());
        System.out.println("Expected: 112.0");

        robot1.moveHorizontally(100);
        System.out.println(robot1.getX());
        System.out.println("Expected: 212.0");

        robot1.moveVertically(200);
        System.out.println(robot1.getY());
        System.out.println("Expected: 220.0");

        robot1.moveVertically(-100);
        System.out.println(robot1.getY());
        System.out.println("Expected: 120.0");

        robot1.moveHorizontally(-50);
        System.out.println(robot1.getX());
        System.out.println("Expected: 162.0");

        robot1.moveVertically(-100);
        System.out.println(robot1.getY());
        System.out.println("Expected: 20.0");

        robot1.moveHorizontally(-152);
        System.out.println(robot1.getX());
        System.out.println("Expected: 10.0");
    }
}
