 import java.util.*;

/**
 * Write a description of class CarTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CarTester
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class CarTester
     */
    public CarTester()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    
    
    
    
    public static void main(String args[]){
        Car automobile = new Car(30,100, new Color(255,0,0));
        Car jalopy = new Car(110,30, new Color(0,255,0));
        
        Car jaguar = new Car(200,100, new Color(0,0,255));
        
        
    }
}