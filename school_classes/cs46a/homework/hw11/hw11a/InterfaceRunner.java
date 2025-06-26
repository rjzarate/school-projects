import java.util.Scanner;
/**
 * The Java tester program for interface HasArea.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 12-01-2022
 */
public class InterfaceRunner
{
   public static void main(String[] args)
   {
       final int MAX_SIZE = 5;
       
       Scanner in = new Scanner(System.in);
       HasArea[] allArea = new HasArea[MAX_SIZE];
       int count = 0;
       
       System.out.print("Enter 0 for circle, 1 for a Square, Q to Quit: ");
       
       // Step 2: Complete the while condition
       while (in.hasNextInt() && count < MAX_SIZE)
       {
           int type = in.nextInt();
           System.out.print("Enter the size: ");
           double size = in.nextDouble();
           if (type == 0)
           {
               allArea[count] = new Circle(size);
           }
           else
               allArea[count] = new Square(size);
               
           count ++;           
           System.out.print("Enter 0 for circle, 1 for a Square, Q to Quit: ");
       }
      
       int minIndex = 0, maxIndex = 0;
       double minArea = allArea[0].area(), maxArea = allArea[0].area();
       double sum = allArea[0].area();
       for (int i = 1; i < count; i ++)
       {
           double area = allArea[i].area();
           sum += area;
           
           // Step 3: Complete the if condition
           if (minArea > area)
           {
                minArea = area;
                minIndex = i;
           }
           // Step 4: Complete the else if condition
           else if (maxArea < area)
           {
                maxArea = area;
                maxIndex = i;
           }
       }
       
       System.out.println("Smallest Area: " + (Object)allArea[minIndex].toString());
       System.out.println("Largest Area : " + (Object)allArea[maxIndex].toString());
       System.out.println("Average Area : " + sum / count);
   }
}