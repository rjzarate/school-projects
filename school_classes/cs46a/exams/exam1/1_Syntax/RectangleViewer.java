/**
 * Create a Rectangle object and call some methods on it. 
 *
 * Step 1: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version MyExamOne
 */
public class RectangleViewer
{
    public static void main(String[] args)
    {
        // Step 2: Fix the syntax errors and submit the program
        //         to Codecheck to pass all tests.
        // Note: Do not add or remove any statements
        //       Do not add or remove any variables
        //       Do not add or remove any objects
        //       Do not change the semantics of any statement
        //       Magic numbers are allowed
        
        // Create an object of Rectangle at (50, 50) with 
        // a width of 75 and a height of 45 and assign it
        // to a variable greenRectangle
        Rectangle greenRectangle = new Rectangle(50, 50, 75, 45);
        
        // Set the color to green
        greenRectangle.setColor(Color.GREEN);
        
        // Display the x and y coordinates
        System.out.println("x: " + greenRectangle.getX());
        System.out.println("y: " + greenRectangle.getY());
        
        // Decrease the x-coordinate by 10  
        // Decrease the y-coordinate by 20 
        // Must use dx and dy when calling method translate().
        int dx = -10;
        int dy = -20;
        greenRectangle.translate(dx, dy);
        
        // Display the x and y coordinates
        System.out.println("x: " + greenRectangle.getX());
        System.out.println("y: " + greenRectangle.getY());
        
        // Draw the rectangle
        greenRectangle.draw();
    }
}