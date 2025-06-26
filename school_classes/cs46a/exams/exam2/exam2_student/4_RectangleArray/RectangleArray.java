/**
 * The class manages an array of Rectangle. Rectangles can be added
 * into the array and the number of rectangles in the array must be
 * kept correct at all times.
 * 
 * Step 1: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version F2022ExamTwo
 */
public class RectangleArray
{
    // Step 2: Declare two instance variables to manage 
    //         an array of Rectangle
    private Rectangle[] rectangleArray;
    private int currentSize;

    // Step 3: Write the constructor according to the comment.
    //         Javadoc is required.
    /**
     * Initializes the instance variables with two
     * parameters: an array of Rectangle and a count
     * of elements in the array.
     * 
     * @param  theArray the array itself
     * @param  count    the size of the array
     */
    public RectangleArray(Rectangle[] theArray, int count)
    {
        rectangleArray = theArray;
        currentSize = count;
    }

    // Step 4: Write method add() according to the comment.
    //         Javadoc is required.
    /**
     * Adds a rectangle to the specified index position in the  
     * array and shifts the element at the position and all 
     * subsequent elements to the right if the array is not 
     * full and the index is valid. It does nothing otherwise.
     * 
     * @param index      the index
     * @param rectangle  adds a rectangle if index is valid
     */
    public void add(int index, Rectangle rectangle)
    {
        if (index >= 0 && index <= currentSize && index < rectangleArray.length && currentSize != rectangleArray.length)
        {
            for (int i = currentSize - 1; i >= index; i --)
            {
                rectangleArray[i + 1] = rectangleArray[i];
            }
            rectangleArray[index] = rectangle;
            currentSize ++;
        }
    }
    
    // Step 5: Write method lastExcellentRectangle() according 
    //         to the comment. Javadoc is required.
    /**
     * Finds and returns the LAST excellent rectangle in the array.
     * It returns null if the array has no excellent rectangles.
     * A rectangle is excellent if the following conditions are true
     *          y is not 0                                  and 
     *          height is not 0                             and
     *          the remainder of x divided by y equals      
     *              the remainder of width divided by height
     *    
     * The method should stop execution and return the last 
     * perfect rectangle after it is found.
     * 
     * @return  the excellent rectangle
     */    
    public Rectangle lastExcellentRectangle()
    {
        for (int i = currentSize - 1; i >= 0; i --)
        {
            if (rectangleArray[i].getY() != 0 && rectangleArray[i].getHeight() != 0 &&
                (rectangleArray[i].getX() % rectangleArray[i].getY()) ==
                (rectangleArray[i].getWidth() % rectangleArray[i].getHeight()))
                {
                    return rectangleArray[i];
                }
        }
        return null;
    }

    /**
     * Gets a String representation for the array in the following format:
     *    [Rectangle[x=1,y=4,widht=2,height=0], Rectangle[x=5,y=2,widht=11,height=3]]
     * Notie that class Rectangle provides a method toString() that returns
     * a string for a rectangle in the format 
     *      "Rectangle[x=1,y=2,widht=3,height=3]"
     * 
     * @return a String representation for the array 
     */
    @Override
    public String toString()
    {
        String s = "[";
        if (currentSize > 0)
        {
            for (int i = 0; i < currentSize - 1; i ++)
                s += rectangleArray[i].toString() + ", ";
                
            s += rectangleArray[currentSize - 1].toString();
        }
        
        return s + "]";
        
        //String str = "[";
        
        //if (currentSize != 0)
        //str += "Rectangle: [x=" + rectangleArray[0].getX() + "Rectangle: y=" + rectangleArray[0].getY() +
        //        "Rectangle: width=" + rectangleArray[0].getWidth() + "Rectangle: height=" + rectangleArray[0].getHeight();
        
        //for (int i = 1; i < currentSize; i ++)
        //{
        //    str += "Rectangle: [x=" + rectangleArray[i].getX() + "Rectangle: y=" + rectangleArray[i].getY() +
        //            "Rectangle: width=" + rectangleArray[i].getWidth() + "Rectangle: height=" + rectangleArray[i].getHeight();
        //}
        //return str + "]";
    }
}
