import java.util.Scanner;
/**
 * Creates an isosceles triangle with the given height.
 *
 * @author Froilan Zarate
 * @version 10-22-2022
 */
public class Triangle
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int height;
        int triangle = -1;
        System.out.print("Enter an integer between 3 and 10 (inclusive): ");
        height = in.nextInt();
        while (height < 3 || height > 10)
        {
            System.out.printf("Out of range: %d.%n", height);
            System.out.print("Enter an integer between 3 and 10 (inclusive): ");
            height = in.nextInt();
        }
        for (int row = 1; row <= height; row ++)
        {
            for (int spaces = 1; spaces <= height - row; spaces ++)
            {
                System.out.print(" ");
            }
            triangle = triangle + 2;
            for (int plus = triangle; plus >= 1; plus --)
            {
                System.out.print("+");
            }
            System.out.printf("%n");
            
        }
    }
}
