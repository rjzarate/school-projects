/**
 * A Java program to test class Member.
 *
 * @author  Qi Yang
 * @version 2022-12-12
 */
public class MemberTester
{
    public static void main(String[] args)
    {
        Member memberOne = new Member("Qi", 150.0);
        Member memberTwo = new Member("Joe Clifton", 500.0);
        Member memberThree = new Member("Jason W. Clifton", 99.9);
        
        // Testing method toString()
        System.out.println(memberOne.toString());
        System.out.println("Expected: Member[Name=Qi,Balance=150.0]");
        System.out.println(memberTwo.toString());
        System.out.println("Expected: Member[Name=Joe Clifton,Balance=500.0]");
        System.out.println(memberThree.toString());
        System.out.println("Expected: Member[Name=Jason W. Clifton,Balance=100.0]");

        // Testing method getBalance()
        System.out.println(memberOne.getBalance());
        System.out.println("Expected: 150.0");
        System.out.println(memberTwo.getBalance());
        System.out.println("Expected: 500.0");
        System.out.println(memberThree.getBalance());
        System.out.println("Expected: 100.0");

        // Testing methods randomChar() 
        System.out.println(memberOne.randomChar(202212));
        System.out.println("Expected: i");
        System.out.println(memberTwo.randomChar(1214));
        System.out.println("Expected: C");
        System.out.println(memberThree.randomChar(20221214));
        System.out.println("Expected: W");

        // Testing methods updateBalance() and getBalance()
        memberOne.updateBalance(99.5);
        memberTwo.updateBalance(-199.5);
        memberThree.updateBalance(50.0);
        
        System.out.println(memberOne.getBalance());
        System.out.println("Expected: 249.5");
        System.out.println(memberTwo.getBalance());
        System.out.println("Expected: 300.5");
        System.out.println(memberThree.getBalance());
        System.out.println("Expected: 150.0");
    }
}
