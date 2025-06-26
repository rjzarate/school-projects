
/**
 * Write a description of class SnowmanViewer here.
 *
 * @author Froilan Zarate
 * @version 09-06-2022
 */
public class SnowmanViewer
{
    public static void main(String[] args)
    {
        Rectangle rec1 = new Rectangle(50, 10, 20, 20);
        rec1.fill();
        Line line1 = new Line(40, 30, 80, 30);
        line1.draw();
        Ellipse circle1 = new Ellipse(50, 30, 20, 20);
        circle1.draw();
        Ellipse circle2 = new Ellipse(40, 50, 40, 40);
        circle2.draw();
        Ellipse circle3 = new Ellipse(30, 90, 60, 60);
        circle3.draw();
    }
}
