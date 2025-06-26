import java.util.Scanner;
import java.util.Random;
/**
 * Prompt for a positive integer then draws that number of random rectangles.
 *
 * @author Froilan Zarate 
 * @version 10-29-2022
 */
public class RandomRectangles
{
    public static final int MAX_X = 100;
    public static final int MAX_Y = 500;
    public static final int MIN_WIDTH = 30;
    public static final int MAX_WIDTH = 100;
    public static final int MIN_HEIGHT = 20;
    public static final int MAX_HEIGHT = 80;
    public static final int GENERATOR_SEED = 202210;
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random random = new Random(GENERATOR_SEED);
        Rectangle rectangle = new Rectangle();
        int smallestArea = 0;
        Rectangle smallestRectangle = new Rectangle();
        
        int numberOfRectangles = 0;
        
        while (!in.hasNextInt())
        {
            in = new Scanner(System.in);
        }
        numberOfRectangles = in.nextInt();
        while (numberOfRectangles < 1)
        {
            if (in.hasNextInt())
            {
                numberOfRectangles = in.nextInt();
            }
            in = new Scanner(System.in);
        }
        
        

        for (int i = 0; i < numberOfRectangles; i ++)
        {
            rectangle = new Rectangle(random.nextInt(MAX_X),
                                        random.nextInt(MAX_Y),
                                        random.nextInt(MAX_WIDTH - MIN_WIDTH) + MIN_WIDTH,
                                        random.nextInt(MAX_HEIGHT - MIN_HEIGHT) + MIN_HEIGHT);
            
            rectangle.setColor(Color.RED);
            rectangle.draw();
            if (i == 0)
            {
                smallestRectangle = rectangle;
                smallestArea = rectangle.getWidth() * rectangle.getHeight();
            }
            if (rectangle.getWidth() * rectangle.getHeight() < smallestArea)
            {
                smallestRectangle = rectangle;
                smallestArea = rectangle.getWidth() * rectangle.getHeight();
            }
        }
        smallestRectangle.setColor(Color.YELLOW);
        smallestRectangle.fill();
    }
}
