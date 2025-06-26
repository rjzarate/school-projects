import java.util.ArrayList;
/**
 * A tester program for UtilClass.
 * 
 * @author  Qi Yang
 * @version 2022-11-22
 */
public class UtilClassTester
{
    public static void main(String[] args)
    {
        System.out.println("Testing BankAccount");
        
        ArrayList<Qualifiable> bankList = new ArrayList<Qualifiable>();
        bankList.add(new BankAccount(999.99, "xyz999"));
        bankList.add(new BankAccount(1000.0, "abc123"));
        bankList.add(new BankAccount(2000.0, "xyz789"));
        bankList.add(new BankAccount(1500.0, "xyz456"));
        bankList.add(new BankAccount(1500.01, "xyz099"));

        System.out.println(UtilClass.numOfQualified(bankList));
        System.out.println("Expected: 2");
        
        System.out.println("Testing Student");
        ArrayList<Qualifiable> studentList = new ArrayList<Qualifiable>();
        
        studentList.add(new Student("Sam", 3.449));
        studentList.add(new Student("Amy", 3.45));
        studentList.add(new Student("Aruna", 3.51));
        studentList.add(new Student("John", 3.6));
        
        System.out.println(UtilClass.numOfQualified(studentList));
        System.out.println("Expected: 3");  
        
        System.out.println("Testing Student and BankAccount");
        ArrayList<Qualifiable> qualifiableList = new ArrayList<Qualifiable>();
        qualifiableList.add(new Student("Sam", 3.449));
        qualifiableList.add(new Student("Amy", 3.45));
        qualifiableList.add(new BankAccount(999.99, "xyz999"));
        qualifiableList.add(new BankAccount(1000.0, "abc123"));
        qualifiableList.add(new Student("Aruna", 3.51));
        qualifiableList.add(new BankAccount(2000.0, "xyz789"));
        qualifiableList.add(new BankAccount(1500.0, "xyz456"));
        qualifiableList.add(new BankAccount(1500.01, "xyz099"));
        qualifiableList.add(new Student("John", 3.6));

        System.out.println(UtilClass.numOfQualified(qualifiableList));
        System.out.println("Expected: 5");
    }
}