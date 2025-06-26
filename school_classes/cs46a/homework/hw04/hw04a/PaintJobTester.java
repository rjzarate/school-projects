/**
 * A tester program for the PaintJob class.
 *
 * @author  Qi Yang
 * @version 2022-09-09
 */
public class PaintJobTester
{
    public static void main(String[] args)
    {
        PaintJob job = new PaintJob(10.5, 9.0);
        
        System.out.printf("Room length: %.1f%n", job.getLength());
        System.out.println("Expected: 10.5");
        System.out.printf("Room width: %.1f%n", job.getWidth());
        System.out.println("Expected: 9.0");
        System.out.printf("Surface area: %.2f%n", job.surfaceArea());
        System.out.println("Expected: 368.72");
        System.out.printf("Paint cost: %.2f%n", job.costOfPaint());
        System.out.println("Expected: 39.27");
        System.out.printf("Total cost: %.2f%n", job.totalJobCost());
        System.out.println("Expected: 139.27");
        
        job.setDimensions(15, 12);
        System.out.printf("Room length: %.1f%n", job.getLength());
        System.out.println("Expected: 15.0");
        System.out.printf("Room width: %.1f%n", job.getWidth());
        System.out.println("Expected: 12.0");
        System.out.printf("Surface area: %.2f%n", job.surfaceArea());
        System.out.println("Expected: 574.22");
        System.out.printf("Paint cost: %.2f%n", job.costOfPaint());
        System.out.println("Expected: 61.15");
        System.out.printf("Total cost: %.2f%n", job.totalJobCost());
        System.out.println("Expected: 161.15");
    }
}