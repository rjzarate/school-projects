/**
 * A Java tester program for class LoopyFun.
 *
 * @author  Qi Yang
 * @version 2022-09-23
 */
public class LoopyFunTester
{
    public static void main(String[] args)
    {

        LoopyFun loopyFun0 = new LoopyFun(0);
        LoopyFun loopyFun5 = new LoopyFun(5);
        LoopyFun loopyFun15 = new LoopyFun(15);
        LoopyFun loopyFunNegative = new LoopyFun(-4);
        
        // Testing loopyFun0
        int storedInt = loopyFun0.getNum();
        System.out.printf("The stored integer: %d%n", storedInt); 
        System.out.println("Expected: 1"); 

        System.out.printf("The factorial of %d: %d%n", storedInt, 
                          loopyFun0.factorial());
        System.out.println("Expected: 1"); 

        System.out.printf("The sum of all powers of two (from 0 to %d) of two: %d%n", 
                           storedInt - 1, loopyFun0.sumOfPowersOfTwo());
        System.out.println("Expected: 1"); 
                           
        
        // Testing loopyFun5
        storedInt = loopyFun5.getNum();
        System.out.printf("The stored integer: %d%n", storedInt); 
        System.out.println("Expected: 5"); 

        System.out.printf("The factorial of %d: %d%n", storedInt, 
                          loopyFun5.factorial());
        System.out.println("Expected: 120"); 

        System.out.printf("The sum of all powers of two (from 0 to %d) of two: %d%n", 
                           storedInt - 1, loopyFun5.sumOfPowersOfTwo());
        System.out.println("Expected: 31"); 
        
        // Testing loopyFun15
        storedInt = loopyFun15.getNum();
        System.out.printf("The stored integer: %d%n", storedInt); 
        System.out.println("Expected: 15"); 

        System.out.printf("The factorial of %d: %d%n", storedInt, 
                          loopyFun15.factorial());
        System.out.println("Expected: 2004310016"); 

        System.out.printf("The sum of all powers of two (from 0 to %d) of two: %d%n", 
                           storedInt - 1, loopyFun15.sumOfPowersOfTwo());
        System.out.println("Expected: 32767"); 
        
        // Testing loopyFunNegative
        storedInt = loopyFunNegative.getNum();
        System.out.printf("The stored integer: %d%n", storedInt); 
        System.out.println("Expected: 4"); 

        System.out.printf("The factorial of %d: %d%n", storedInt, 
                          loopyFunNegative.factorial());
        System.out.println("Expected: 24"); 

        System.out.printf("The sum of all powers of two (from 0 to %d) of two: %d%n", 
                           storedInt - 1, loopyFunNegative.sumOfPowersOfTwo());
        System.out.println("Expected: 15"); 
    }
}