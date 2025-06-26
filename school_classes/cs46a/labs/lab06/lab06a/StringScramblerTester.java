/**
 * Write a description of class StringScramblerTester here.
 *
 * @author  Qi Yang
 * @version 2022-03-01
 */
public class StringScramblerTester
{
    public static void main(String[] args)
    {
        StringScrambler scramble0 = new StringScrambler("received");
        StringScrambler scramble1 = new StringScrambler("A");
        StringScrambler scramble2 = new StringScrambler("CS");
        StringScrambler scramble3 = new StringScrambler("Java");
        StringScrambler scramble4 = new StringScrambler("Programming");
        StringScrambler scramble5 = new StringScrambler("Introduction");
        
        // Testing method scrambleFirstLast()
        System.out.println(scramble0.scrambleFirstLast());
        System.out.println("Expected: deceiver");
        System.out.println(scramble1.scrambleFirstLast());
        System.out.println("Expected: null");
        System.out.println(scramble2.scrambleFirstLast());
        System.out.println("Expected: SC");
        System.out.println(scramble3.scrambleFirstLast());
        System.out.println("Expected: aavJ");
        System.out.println(scramble4.scrambleFirstLast());
        System.out.println("Expected: grogramminP");
        System.out.println(scramble5.scrambleFirstLast());
        System.out.println("Expected: nntroductioI");

        // Testing method scrambleSecondThird()
        System.out.println(scramble0.scrambleSecondThird());
        System.out.println("Expected: rceeived");
        System.out.println(scramble1.scrambleSecondThird());
        System.out.println("Expected: null");
        System.out.println(scramble2.scrambleSecondThird());
        System.out.println("Expected: null");
        System.out.println(scramble3.scrambleSecondThird());
        System.out.println("Expected: Jvaa");
        System.out.println(scramble4.scrambleSecondThird());
        System.out.println("Expected: Porgramming");
        System.out.println(scramble5.scrambleSecondThird());
        System.out.println("Expected: Itnroduction");

        // Testing method scrambleAdjacentTwo()
        System.out.println(scramble0.scrambleAdjacentTwo(3));
        System.out.println("Expected: recieved");
        System.out.println(scramble1.scrambleAdjacentTwo(0));
        System.out.println("Expected: null");
        System.out.println(scramble2.scrambleAdjacentTwo(1));
        System.out.println("Expected: null");
        System.out.println(scramble3.scrambleAdjacentTwo(0));
        System.out.println("Expected: null");
        System.out.println(scramble3.scrambleAdjacentTwo(1));
        System.out.println("Expected: Jvaa");
        System.out.println(scramble3.scrambleAdjacentTwo(2));
        System.out.println("Expected: null");
        System.out.println(scramble3.scrambleAdjacentTwo(3));
        System.out.println("Expected: null");
        System.out.println(scramble4.scrambleAdjacentTwo(5));
        System.out.println("Expected: Progrmaming");
        System.out.println(scramble5.scrambleAdjacentTwo(9));
        System.out.println("Expected: Introductoin");

        // Testing method scrambleNotAdjacentTwo()
        System.out.println(scramble0.scrambleNotAdjacentTwo(3));
        System.out.println("Expected: recvieed");
        System.out.println(scramble1.scrambleNotAdjacentTwo(0));
        System.out.println("Expected: null");
        System.out.println(scramble2.scrambleNotAdjacentTwo(1));
        System.out.println("Expected: null");
        System.out.println(scramble3.scrambleNotAdjacentTwo(0));
        System.out.println("Expected: null");
        System.out.println(scramble3.scrambleNotAdjacentTwo(1));
        System.out.println("Expected: null");
        System.out.println(scramble4.scrambleNotAdjacentTwo(0));
        System.out.println("Expected: null");
        System.out.println(scramble4.scrambleNotAdjacentTwo(5));
        System.out.println("Expected: Progrmmaing");
        System.out.println(scramble5.scrambleNotAdjacentTwo(9));
        System.out.println("Expected: null");
        System.out.println(scramble5.scrambleNotAdjacentTwo(8));
        System.out.println("Expected: Introducoitn");
    }
}