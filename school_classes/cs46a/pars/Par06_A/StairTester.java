/**
 * A Java tester program for class Stair.
 *
 * @author  Qi Yang
 * @version 2022-09-13
 */
public class StairTester
{
    public static void main(String[] args)
    {
        Stair stairOne = new Stair(20, 10);
        Stair stairTwo = new Stair(140, 10);
        Stair stairThree = new Stair(80, 110, Color.GREEN);
        Stair stairFour = new Stair(-20, 110, Color.ORANGE);

        // Testing method draw()
        stairOne.draw();
        stairTwo.draw();
        stairThree.draw();
        stairFour.draw();
        
        // Testing method getX()
        System.out.println("The x-coordinate of stair one: " + stairOne.getX());
        System.out.println("Expected: 20.0");
        System.out.println("The x-coordinate of stair two: " + stairTwo.getX());
        System.out.println("Expected: 140.0");
        System.out.println("The x-coordinate of stair three: " + stairThree.getX());
        System.out.println("Expected: 80.0");
        System.out.println("The x-coordinate of stair four: " + stairFour.getX());
        System.out.println("Expected: -20.0");
        
        // Testing method toString()
        System.out.println(stairOne.toString());
        System.out.println("Expected: Stair[X:20.0,Y:10.0,Color:0,0,0]");
        System.out.println(stairTwo.toString());
        System.out.println("Expected: Stair[X:140.0,Y:10.0,Color:0,0,0]");
        System.out.println(stairThree.toString());
        System.out.println("Expected: Stair[X:80.0,Y:110.0,Color:0,255,0]");
        System.out.println(stairFour);
        System.out.println("Expected: Stair[X:-20.0,Y:110.0,Color:255,200,0]");
        
        // Testing method setColor()
        stairThree.setColor(Color.BLUE);
        System.out.println(stairThree.toString());
        System.out.println("Expected: Stair[X:80.0,Y:110.0,Color:0,0,255]");
        
        stairThree.draw();
    }
}
