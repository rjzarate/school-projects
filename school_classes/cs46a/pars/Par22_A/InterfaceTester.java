/** 
 * A tester program for interface Qualifiable.
 * 
 * @author  Qi Yang
 * @version 2022-11-22
 */
public class InterfaceTester
{
    public static void main(String[] args)
    {
        System.out.println("Testing BankAccount");
        BankAccount account = new BankAccount(1000.0, "abc123");
        BankAccount account1 = new BankAccount(2000.0, "xyz789");
        Qualifiable qualifiedAccount = account1; 
        
        System.out.println(account.qualifies());
        System.out.println("Expected: true");
        System.out.println(account1.qualifies());
        System.out.println("Expected: false");
        
        account1.withdraw(499.90);
        System.out.println(account1.qualifies());
        System.out.println("Expected: false");
        
        account1.withdraw(0.10);
        System.out.println(account1.qualifies());
        System.out.println("Expected: true");
        
        System.out.println("Testing Students");
        Qualifiable student = new Student("Sam", 3.449);
        Qualifiable student1 = new Student("Amy", 3.45);
        Qualifiable student2 = new Student("Aruna", 3.51);

        System.out.println(student.qualifies());
        System.out.println("Expected: false");
        System.out.println(student1.qualifies());
        System.out.println("Expected: true");
        System.out.println(student2.qualifies());
        System.out.println("Expected: true");        
    }
}