import java.util.Scanner;
/**
 * The Java program uses a loop to read a double value in
 * the range between 0 and 500.0, exclusive, as the radius,
 * then calculates and displays the circumference, area, 
 * sphere surface area and sphere volume.
 * 
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 10-11-2022
 */
public class CircleAndSphereWhileLoop
{
    public static final double MAX_RADIUS = 500.0;
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // Step 2: Read a double value as radius using prompt 
        //         "Enter the radius (between 0.0 and 500.0, exclusive): "
        System.out.print("Enter the radius (between 0.0 and 500.0, exclusive): ");
        double radius = in.nextDouble();


        // Step 3: While the input radius is not in the ragne (0.0, 500.0)
        //            Display a message on one line (ssuming input value -1)
        //               "The input number -1.00 is out of range."
        //            Read a double value as radius using the same promt
        while (radius <= 0.0 || radius >= MAX_RADIUS)
        {
            System.out.printf("The input number %.2f is out of range.%n", radius);
            System.out.print("Enter the radius (between 0.0 and 500.0, exclusive): ");
            radius = in.nextDouble();
        }

        
        double circumference = 2 * Math.PI * radius;
        double area = Math.PI * radius * radius;
        double surfaceArea = 4 * Math.PI * Math.pow(radius, 2);
        double volume = (4 / 3.0) * Math.PI * Math.pow(radius, 3);
        
        // Step 4: Display the radius, circle circumference, circle area,
        //         sphere surface area, and sphere volume on separate 
        //         lines with 6 decimal digits
        // Sample output
        // The radius              : 499.990000.
        // The circle circumference: 3141.529822.
        // The circle area         : 785366.747785.
        // The sphere surface area : 3141466.991100.
        // The sphere volume       : 523567360.300077.
        System.out.printf("The radius              : %.6f.%n", radius);
        System.out.printf("The circle circumference: %.6f.%n", circumference);
        System.out.printf("The circle area         : %.6f.%n", area);
        System.out.printf("The sphere surface area : %.6f.%n", surfaceArea);
        System.out.printf("The sphere volume       : %.6f.", volume);
        


    }
}
