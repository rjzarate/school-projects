
/**
 * Write a description of class RobotDemo here.
 *
 * @author (your name) Froilan Zarate & Alan Xiao
 * @version (a version number or a date) 09-02-2022
 */
public class RobotDemo
{
    public static void main (String[] args)
    {
        Robot roomba = new Robot(0, 0, "roomba.png");
        roomba.moveForward();
        String name = "Roomba Robot";
        roomba.moveForward();
        roomba.turnRight();
        roomba.moveForward();
        roomba.moveForward();
        roomba.turnRight();
        roomba.moveForward();
        roomba.turnRight();
        roomba.turnRight();
        roomba.moveForward();
        roomba.turnRight();
        roomba.moveForward();
        roomba.moveForward();
        roomba.turnRight();
        roomba.moveForward();
        roomba.moveForward();
    }
}
