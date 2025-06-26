/**
 * Draws a circle on a triangle.
 *
 * @author  Qi Yang
 * @version 2022-09-01
 */
public class CircleOnTriangle
{

    public static void main(String[] args) 
    {
        Ellipse circle = new Ellipse(20, 20, 50, 50);
        circle.draw();
        
        Line lineAB = new Line(45, 70, 10, 100);
        Line lineAC = new Line(45, 70, 80, 100);
        Line lineBC = new Line(10, 100, 80, 100);
        
        lineAB.draw();
        lineAC.draw();
        lineBC.draw();
    }
}
