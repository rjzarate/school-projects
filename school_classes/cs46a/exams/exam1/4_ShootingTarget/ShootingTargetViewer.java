/**
 * A Java tester program for class ShootingTarget.
 * 
 * @author  Qi Yang
 * @version 2022-10-06
 */
public class ShootingTargetViewer
{
    public static void main(String[] args)
    {
        ShootingTarget target1 = new ShootingTarget(50, 50);
        target1.draw();

        ShootingTarget target2 = new ShootingTarget(150, 50);
        target2.draw();

        ShootingTarget target3 = new ShootingTarget(50, 200);
        target3.draw();    

        ShootingTarget target4 = new ShootingTarget(0, 0);
        target4.draw();
    }
}
