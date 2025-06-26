/**
 * A Java tester program for class Frog2DArray.
 *
 * @author  Qi Yang
 * @version 2022-10-28
 */
public class Frog2DArrayTester
{
    public static void main(String[] args)
    {
        Frog[][] array1 = { {new Frog(15), new Frog(25), new Frog(20)},
                            {new Frog(16), new Frog(10), new Frog(21)},
                            {new Frog(14), new Frog(13), new Frog(15)},
                            {new Frog(29), new Frog(17), new Frog(13)} };
        Frog2DArray twoDArray1 = new Frog2DArray(array1);
        
        Frog[][] array2 = { {new Frog(1), new Frog(7), new Frog(19), new Frog(21), new Frog(31)},
                            {new Frog(2), new Frog(30), new Frog(18), new Frog(30), new Frog(30)},
                            {new Frog(6), new Frog(13), new Frog(17), new Frog(23), new Frog(32)},
                            {new Frog(4), new Frog(12), new Frog(16), new Frog(24), new Frog(33)},
                            {new Frog(9), new Frog(19), new Frog(15), new Frog(25), new Frog(34)},
                            {new Frog(20), new Frog(15), new Frog(14), new Frog(20), new Frog(20)} };
        Frog2DArray twoDArray2 = new Frog2DArray(array2);
        
        // Testing method rowMaxFrog()
        System.out.println(twoDArray1.rowMaxFrog(0).toString());
        System.out.println("Expected: Frog[Weight:25,Legs:4]");
        System.out.println(twoDArray1.rowMaxFrog(2).toString());
        System.out.println("Expected: Frog[Weight:15,Legs:2]");
        
        System.out.println(twoDArray2.rowMaxFrog(5).toString());
        System.out.println("Expected: Frog[Weight:20,Legs:2]");
        System.out.println(twoDArray2.rowMaxFrog(4).toString());
        System.out.println("Expected: Frog[Weight:34,Legs:4]");
        
        // Testing method colAverage()
        System.out.println(twoDArray1.colAverage(0));
        System.out.println("Expected: 18.5");
        System.out.println(twoDArray1.colAverage(2));
        System.out.println("Expected: 17.25");
        
        System.out.println(twoDArray2.colAverage(1));
        System.out.println("Expected: 16.0");
        System.out.println(twoDArray2.colAverage(3));
        System.out.println("Expected: 23.833333333333332");
        
        // Testing method totalCount()
        System.out.println(twoDArray1.totalCount(0));
        System.out.println("Expected: 0");
        System.out.println(twoDArray1.totalCount(2));
        System.out.println("Expected: 9");
        System.out.println(twoDArray1.totalCount(4));
        System.out.println("Expected: 3");
        
        System.out.println(twoDArray2.totalCount(0));
        System.out.println("Expected: 3");
        System.out.println(twoDArray2.totalCount(2));
        System.out.println("Expected: 16");
        System.out.println(twoDArray2.totalCount(4));
        System.out.println("Expected: 11");
    }
}
