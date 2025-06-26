/**
 * A Java tester program for class Stair.
 *
 * @author  Qi Yang
 * @version 2022-09-08
 */
public class StairTester
{
    public static void main(String[] args)
    {
        Stair stairOne = new Stair(0, 10);
        Stair stairTwo = new Stair(140, 10);
        Stair stairThree = new Stair(80, 110);
        Stair stairFour = new Stair(-20, 110);

        // Testing method draw()
        stairOne.draw();
        stairTwo.draw();
        stairThree.draw();
        stairFour.draw();

        // Testing mwthod getX()
        System.out.println(stairOne.getX());
        System.out.println("Expected: 0.0");
        System.out.println(stairTwo.getX());
        System.out.println("Expected: 140.0");
        System.out.println(stairThree.getX());
        System.out.println("Expected: 80.0");
        System.out.println(stairFour.getX());
        System.out.println("Expected: -20.0");
    }
}
