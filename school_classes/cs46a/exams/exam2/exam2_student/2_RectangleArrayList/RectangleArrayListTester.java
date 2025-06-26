import java.util.ArrayList;
/**
 * A Java tester program for class RectangleArrayList.
 *
 * @author  Qi Yang
 * @version 2022-11-11
 */
public class RectangleArrayListTester
{
    public static void main(String[] args)
    {
        ArrayList<Rectangle> list = new ArrayList<Rectangle>();
        
        RectangleArrayList rectangleList = new RectangleArrayList(list);
        
        System.out.println("All Rectangles: " + rectangleList.toString());
        System.out.println("Expected: []");

        System.out.println("Count of Perfect Rectangle: " + rectangleList.countOfPerfectRectangles());
        System.out.println("Expected: 0");
        
        rectangleList.add(new Rectangle(5, 2, 1, 10));
        rectangleList.add(new Rectangle(1, 2, 3, 3));
        
        System.out.println("All Rectangles: " + rectangleList.toString());
        System.out.println("Expected: [Rectangle[x=5,y=2,widht=1,height=10], Rectangle[x=1,y=2,widht=3,height=3]]");

        System.out.println("Count of Perfect Rectangle: " + rectangleList.countOfPerfectRectangles());
        System.out.println("Expected: 1");
        
        rectangleList.add(new Rectangle(2, 8, 4, 4));
        rectangleList.add(new Rectangle(0, 2, 1, 10));
        rectangleList.add(new Rectangle(10, 20, 40, 5));
        
        System.out.println("All Rectangles: " + rectangleList.toString());
        System.out.println("Expected: [Rectangle[x=5,y=2,widht=1,height=10], Rectangle[x=1,y=2,widht=3,height=3], " +
                                      "Rectangle[x=2,y=8,widht=4,height=4], Rectangle[x=0,y=2,widht=1,height=10], " +
                                      "Rectangle[x=10,y=20,widht=40,height=5]]");

        System.out.println("Count of Perfect Rectangle: " + rectangleList.countOfPerfectRectangles());
        System.out.println("Expected: 3");
        
        Rectangle rectangle = rectangleList.delete(0);
        
        System.out.println(rectangle.toString());
        System.out.println("Expected: Rectangle[x=5,y=2,widht=1,height=10]");

        System.out.println("All Rectangles: " + rectangleList.toString());
        System.out.println("Expected: [Rectangle[x=1,y=2,widht=3,height=3], Rectangle[x=2,y=8,widht=4,height=4], " +
                                      "Rectangle[x=0,y=2,widht=1,height=10], Rectangle[x=10,y=20,widht=40,height=5]]");

        System.out.println("Count of Perfect Rectangle: " + rectangleList.countOfPerfectRectangles());
        System.out.println("Expected: 2");
        
        rectangle = rectangleList.delete(1);
        
        System.out.println(rectangle.toString());
        System.out.println("Expected: Rectangle[x=2,y=8,widht=4,height=4]");

        System.out.println("All Rectangles: " + rectangleList.toString());
        System.out.println("Expected: [Rectangle[x=1,y=2,widht=3,height=3], Rectangle[x=0,y=2,widht=1,height=10], " +
                                      "Rectangle[x=10,y=20,widht=40,height=5]]");

        System.out.println("Count of Perfect Rectangle: " + rectangleList.countOfPerfectRectangles());
        System.out.println("Expected: 1");
        
        rectangle = rectangleList.delete(-1);
        System.out.println(rectangle);
        System.out.println("Expected: null");

        rectangle = rectangleList.delete(4);
        System.out.println(rectangle);
        System.out.println("Expected: null");

        rectangle = rectangleList.delete(3);
        System.out.println(rectangle);
        System.out.println("Expected: null");
        
        rectangle = rectangleList.delete(2);
        System.out.println(rectangle);
        System.out.println("Expected: Rectangle[x=10,y=20,widht=40,height=5]");
        
        System.out.println("All Rectangles: " + rectangleList.toString());
        System.out.println("Expected: [Rectangle[x=1,y=2,widht=3,height=3], Rectangle[x=0,y=2,widht=1,height=10]]");

        System.out.println("Count of Perfect Rectangle: " + rectangleList.countOfPerfectRectangles());
        System.out.println("Expected: 0");
    }
}
