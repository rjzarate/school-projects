/**
 * A Java tester program for class RectangleArray.
 *
 * @author  Qi Yang
 * @version 2022-11-11
 */
public class RectangleArrayTester
{
    public static void main(String[] args)
    {
        Rectangle[] array1 = new Rectangle[6];
        
        RectangleArray managedArray = new RectangleArray(array1, 0);
        
        System.out.println("All Rectangles: " + managedArray.toString());
        System.out.println("Expected: []");
        System.out.println("Last excellent Rectangle: " + managedArray.lastExcellentRectangle());
        System.out.println("Expected: null");
        
        managedArray.add(0, new Rectangle(1, 4, 2, 0));
        managedArray.add(1, new Rectangle(5, 2, 11, 3));
        
        System.out.println("Last excellent Rectangle: " + managedArray.lastExcellentRectangle());
        System.out.println("Expected: null");

        managedArray.add(0, new Rectangle(8, 2, 12, 3));
        
        System.out.println("Last excellent Rectangle: " + managedArray.lastExcellentRectangle());
        System.out.println("Expected: Rectangle[x=8,y=2,widht=12,height=3]");
        
        managedArray.add(0, new Rectangle(11, 0, 11, 3));
        managedArray.add(5, new Rectangle(11, 3, 20, 9));
        managedArray.add(-1, new Rectangle(11, 3, 20, 9));
        managedArray.add(3, new Rectangle(11, 3, 20, 9));
        
        System.out.println("All Rectangles: " + managedArray.toString());
        System.out.println("Expected: [Rectangle[x=11,y=0,widht=11,height=3], Rectangle[x=8,y=2,widht=12,height=3], " +
                                      "Rectangle[x=1,y=4,widht=2,height=0], Rectangle[x=11,y=3,widht=20,height=9], " +
                                      "Rectangle[x=5,y=2,widht=11,height=3]]");

        System.out.println("Last excellent Rectangle: " + managedArray.lastExcellentRectangle());
        System.out.println("Expected: Rectangle[x=11,y=3,widht=20,height=9]");
    
        managedArray.add(5, new Rectangle(14, 9, 5, 7));
        System.out.println("All Rectangles: " + managedArray.toString());
        System.out.println("Expected: [Rectangle[x=11,y=0,widht=11,height=3], Rectangle[x=8,y=2,widht=12,height=3], " +
                                      "Rectangle[x=1,y=4,widht=2,height=0], Rectangle[x=11,y=3,widht=20,height=9], " +
                                      "Rectangle[x=5,y=2,widht=11,height=3], Rectangle[x=14,y=9,widht=5,height=7]]");

        System.out.println("Last excellent Rectangle: " + managedArray.lastExcellentRectangle());
        System.out.println("Expected: Rectangle[x=14,y=9,widht=5,height=7]");
    
        managedArray.add(5, new Rectangle(12, 9, 3, 7));
        System.out.println("All Rectangles: " + managedArray.toString());
        System.out.println("Expected: [Rectangle[x=11,y=0,widht=11,height=3], Rectangle[x=8,y=2,widht=12,height=3], " +
                                      "Rectangle[x=1,y=4,widht=2,height=0], Rectangle[x=11,y=3,widht=20,height=9], " +
                                      "Rectangle[x=5,y=2,widht=11,height=3], Rectangle[x=14,y=9,widht=5,height=7]]");
    }
}
