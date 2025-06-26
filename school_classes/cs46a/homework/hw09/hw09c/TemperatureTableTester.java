/**
 * A Java tester program for class TemperatureTable.
 *
 * @author  Qi Yang
 * @version 2022-10-21
 */
public class TemperatureTableTester
{
    public static void main(String[] args)
    {
        int[][] sjTemps = {{57, 58, 40},
                           {62, 60, 45},
                           {66, 65, 65},
                           {70, 72, 68},
                           {75, 73, 72},
                           {80, 81, 83},
                           {83, 84, 90},
                           {82, 82, 87},
                           {81, 80, 81},
                           {74, 75, 71},
                           {65, 66, 68},
                           {58, 58, 59}};
        
        TemperatureTable sj = new TemperatureTable(sjTemps);
        
        int[][] spTemps = {{-17, -16, -15}, 
                           {-58, -60, -63}, 
                           {-65, -74, -80}};
        
        TemperatureTable southPole = new TemperatureTable(spTemps);

        // Testing columnAverage
        System.out.printf("%.6f%n", sj.columnAverage(0));
        System.out.println("Expected: 71.083333");
        System.out.printf("%.6f%n", sj.columnAverage(2));
        System.out.println("Expected: 69.083333");

        System.out.printf("%.6f%n", southPole.columnAverage(0));
        System.out.println("Expected: -46.666667");
        System.out.printf("%.6f%n", southPole.columnAverage(1));
        System.out.println("Expected: -50.000000");
        
        // Testing rowMax
        System.out.println(sj.rowMax(1));
        System.out.println("Expected: 62");
        System.out.println(sj.rowMax(11));
        System.out.println("Expected: 59");
        System.out.println(southPole.rowMax(0));
        System.out.println("Expected: -15");
        System.out.println(southPole.rowMax(1));
        System.out.println("Expected: -58");
        
        // Testing largerValueInMaxRowMinColumn
        System.out.println(sj.largerValueInMaxRowMinColumn(65));
        System.out.println("Expected: 66");
        System.out.println(sj.largerValueInMaxRowMinColumn(85));
        System.out.println("Expected: 87");
        System.out.println(southPole.largerValueInMaxRowMinColumn(-60));
        System.out.println("Expected: -58");
        System.out.println(southPole.largerValueInMaxRowMinColumn(-20));
        System.out.println("Expected: -17");
    }
}