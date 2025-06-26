
/**
 * A Java tester program for class Frog2DArray.
 *
 * @author  Qi Yang
 * @version 2022-11-03
 */
public class Frog2DArrayTester
{
    public static void main(String[] args)
    {
        Frog[][] arrayOne = 
            { {new Frog(2), new Frog(15), new Frog(20), new Frog(27)},
              {new Frog(20), new Frog(5), new Frog(10), new Frog(7)},
              {new Frog(8), new Frog(25), new Frog(4), new Frog(17)},
              {new Frog(12), new Frog(14), new Frog(11), new Frog(23)},
              {new Frog(19), new Frog(22), new Frog(19), new Frog(26)} };
              
        Frog2DArray testerOne = new Frog2DArray(arrayOne);
        Frog2DArray testerTwo = new Frog2DArray(5, 7, 12345, 25 );
        
        // Show all frogs in the 2-D arrays
        System.out.println("All frogs in testerOne:");
        System.out.println(testerOne.toString());
        System.out.println("All frogs in testerTwo:");
        System.out.println(testerTwo.toString());

        // Testing method averageWeight()
        System.out.printf("%.3f%n", testerOne.averageWeight());
        System.out.println("Expected: 15.300");
        System.out.printf("%.3f%n", testerTwo.averageWeight());
        System.out.println("Expected: 9.029");
              
        // Testing method countOfFrogsInRange()
        System.out.printf("%d%n", testerOne.countOfFrogsInRange(10, 20));
        System.out.println("Expected: 8");
        System.out.printf("%d%n", testerTwo.countOfFrogsInRange(10, 20));
        System.out.println("Expected: 13");
              
        // Testing method firstFrogInRangeInARow()
        System.out.printf("%s%n", testerOne.firstFrogInRangeInARow(0, 10, 20));
        System.out.println("Expected: Frog[Weight:15,Legs:2]");
        System.out.printf("%s%n", testerOne.firstFrogInRangeInARow(3, 5, 11));
        System.out.println("Expected: null");
        System.out.printf("%s%n", testerTwo.firstFrogInRangeInARow(0, 10, 20));
        System.out.println("Expected: Frog[Weight:17,Legs:2]");
        System.out.printf("%s%n", testerTwo.firstFrogInRangeInARow(3, 5, 11));
        System.out.println("Expected: Frog[Weight:7,Legs:2]");
              
        // Testing method lastFrogInRangeInAColumn()
        System.out.printf("%s%n", testerOne.lastFrogInRangeInAColumn(1, 10, 20));
        System.out.println("Expected: Frog[Weight:14,Legs:2]");
        System.out.printf("%s%n", testerOne.lastFrogInRangeInAColumn(3, 5, 11));
        System.out.println("Expected: Frog[Weight:7,Legs:2]");
        System.out.printf("%s%n", testerTwo.lastFrogInRangeInAColumn(1, 10, 20));
        System.out.println("Expected: Frog[Weight:15,Legs:2]");
        System.out.printf("%s%n", testerTwo.lastFrogInRangeInAColumn(3, 5, 11));
        System.out.println("Expected: null");
    }
}
