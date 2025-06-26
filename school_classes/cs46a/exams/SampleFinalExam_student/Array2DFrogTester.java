/**
 * A tester program for class Array2DFrog.
 *
 * @author Qi Yang
 * @version 2022-11-27
 */
public class Array2DFrogTester
{
    public static void main(String[] args)
    {
        Frog[][] arrayOne = {
                {new Frog("11aaa", 19.9), new Frog("12bbb", 6.6), new Frog("13ccc", 14.4)},
                {new Frog("21ddd", 17.7), new Frog("22eee", 5.5), new Frog("23fff", 21.1)},
                {new Frog("31ggg", 22.2), new Frog("32hhh", 1.1), new Frog("33iii", 18.8)},
                {new Frog("41jjj", 20.0), new Frog("42kkk", 2.2), new Frog("43lll", 21.1)},
                {new Frog("51mmm", 26.6), new Frog("52nnn", 4.4), new Frog("53ooo", 11.1)}};
        Array2DFrog stored2DArrayA = new Array2DFrog(arrayOne);
        
        Frog[][] arrayTwo = {
                {new Frog("11aaa", 19.9), new Frog("12bbb", 6.6)},
                {new Frog("13ccc", 14.4), new Frog("23fff", 21.1)},
                {new Frog("21ddd", 17.7), new Frog("22eee", 5.5)},
                {new Frog("31ggg", 22.2), new Frog("32hhh", 1.1)},
                {new Frog("33iii", 18.8), new Frog("43lll", 21.1)},
                {new Frog("41jjj", 20.0), new Frog("42kkk", 2.2)},
                {new Frog("51mmm", 26.6), new Frog("52nnn", 4.4)},
                {new Frog("35ooo", 11.1), new Frog("53ooo", 11.1)} };
        Array2DFrog stored2DArrayB = new Array2DFrog(arrayTwo);

        // Testing method averageWeight()
        System.out.println(stored2DArrayA.averageWeight());
        System.out.println("Expected: 14.179999999999998");
        System.out.println(stored2DArrayB.averageWeight());
        System.out.println("Expected: 13.987499999999999");
           
        // Testing method lastInTheRangeOfARow()
        System.out.println(stored2DArrayA.lastInTheRangeOfARow(0, 14.5, 19.9));
        System.out.println("Expected: Frog[ID=11aaa,Weight=19.9,Legs=2]");
        System.out.println(stored2DArrayA.lastInTheRangeOfARow(2, 1.2, 18.7));
        System.out.println("Expected: null");
        System.out.println(stored2DArrayA.lastInTheRangeOfARow(3, 20.0, 21.1));
        System.out.println("Expected: Frog[ID=43lll,Weight=21.1,Legs=4]");
        
        System.out.println(stored2DArrayB.lastInTheRangeOfARow(7, 11.0, 12.0));
        System.out.println("Expected: Frog[ID=53ooo,Weight=11.1,Legs=2]");
        System.out.println(stored2DArrayB.lastInTheRangeOfARow(7, 10.0, 11.0));
        System.out.println("Expected: null");
        
        // Testing method maxOfACol()
        Frog frog = stored2DArrayA.maxOfACol(0);
        System.out.println(frog);
        System.out.println("Expected: Frog[ID=51mmm,Weight=26.6,Legs=4]");
        
        frog = stored2DArrayA.maxOfACol(1);
        System.out.println(frog);
        System.out.println("Expected: Frog[ID=12bbb,Weight=6.6,Legs=2]");
        
        frog = stored2DArrayA.maxOfACol(2);
        System.out.println(frog);
        System.out.println("Expected: Frog[ID=23fff,Weight=21.1,Legs=4]");
        
        frog = stored2DArrayB.maxOfACol(1);
        System.out.println(frog);
        System.out.println("Expected: Frog[ID=23fff,Weight=21.1,Legs=4]");
    }
}
