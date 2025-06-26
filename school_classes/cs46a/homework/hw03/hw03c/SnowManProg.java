/**
 * Draws four snowman objects of the same size
 * at different locations.
 *
 * @author Qi Yang
 * @version 2022-09-02
 */
public class SnowManProg
{
    public static void main(String[] args)
    {
        SnowMan snowman = new SnowMan(50, 10);
        snowman.draw();
        
        snowman = new SnowMan(120, 10);
        snowman.draw();
        
        snowman = new SnowMan(150, 150);
        snowman.draw();
        
        snowman = new SnowMan(-10, -10);
        snowman.draw();
    }
}