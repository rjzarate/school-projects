// Step 1: Import the Scanner class for input
import java.util.Scanner;
import java.lang.Math;
/**
 * A Java program to calculate the circumference, area,
 * surface area, and volume based on an input radius.
 * 
 * Step 2: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 09-15-2022
   */
public class CircleAndSphere
{
    public static void main(String[] args)
    {
        // Step 3: Create a Scanner object to read input from the keyboard
        Scanner in = new Scanner(System.in);

        // Step 4: Display a prompt "Enter the radius: "
        //         and stay on the same line
        System.out.print("Enter the radius: ");
        
        // Step 5: Read a double number for radius and 
        //         store it in a variable
        double radiusNum = in.nextDouble();

        // Step 6: Calculate the circumference using the input radius
        //         and store it in a variable
        double circumferenceNum = 2.0 * Math.PI * radiusNum;

        // Step 7: Calculate the area using the input radius
        //         and store it in a variable
        double areaNum = Math.PI * radiusNum * radiusNum;

        // Step 8: Calculate the surface area using the input radius
        //         and store it in a variable
        double surfaceAreaNum = 4.0 * Math.PI * Math.pow(radiusNum, 2);
        
        // Step 9: Calculate the volume using the input radius
        //         and store it in a variable
        double volumeNum = 4.0 / 3.0 * Math.PI * Math.pow(radiusNum, 3);
        
        // Step 10: Display the radius and calculated values
        // Sample output for radius 5
        // The radius: 5.0
        // The circle circumference: 31.41592653589793
        // The circle area: 78.53981633974483
        // The sphere surface area: 314.1592653589793
        // The sphere volume: 523.5987755982989
        System.out.println("The radius: " + radiusNum);
        System.out.println("The circle circumference: " + circumferenceNum);
        System.out.println("The circle area: " + areaNum);
        System.out.println("The sphere surface area: " + surfaceAreaNum);
        System.out.println("The sphere volume: " + volumeNum);

    }
}
