/**
 * A Java tester program to test class MyString.
 *
 * @author  Qi Yang
 * @version 2022-10-06
 */
public class MyStringTester
{
    public static void main(String[] args)
    {
        MyString tester1 = new MyString("Variable");
        MyString tester2 = new MyString("variable");
        MyString tester3 = new MyString("my variables");
        MyString tester4 = new MyString("My VARIABLES");
        
        // Testing method getString()
        System.out.println(tester1.getString());
        System.out.println("Expected: Variable");
        System.out.println(tester2.getString());
        System.out.println("Expected: variable");
        System.out.println(tester3.getString());
        System.out.println("Expected: my variables");
        System.out.println(tester4.getString());
        System.out.println("Expected: My VARIABLES");

        // Testing method charCount()
        System.out.println(tester1.charCount());
        System.out.println("Expected: 8");
        System.out.println(tester2.charCount());
        System.out.println("Expected: 8");
        System.out.println(tester3.charCount());
        System.out.println("Expected: 12");
        System.out.println(tester4.charCount());
        System.out.println("Expected: 12");
        
        // Testing method camelFormat()
        System.out.println(tester1.camelFormat());
        System.out.println("Expected: variable");
        System.out.println(tester2.camelFormat());
        System.out.println("Expected: variable");
        System.out.println(tester3.camelFormat());
        System.out.println("Expected: myVariables");
        System.out.println(tester4.camelFormat());
        System.out.println("Expected: myVariables");

        // Testing method setString()
        tester3.setString("two VariaBleS");
        tester4.setString("THREE variables");
        
        // Testing method getString() after calling setString()
        System.out.println(tester3.getString());
        System.out.println("Expected: two VariaBleS");
        System.out.println(tester4.getString());
        System.out.println("Expected: THREE variables");
        
        // Testing method charCount() after calling setString()
        System.out.println(tester3.charCount());
        System.out.println("Expected: 13");
        System.out.println(tester4.charCount());
        System.out.println("Expected: 15");

        // Testing method camelFormat() after calling setString()
        System.out.println(tester3.camelFormat());
        System.out.println("Expected: twoVariables");
        System.out.println(tester4.camelFormat());
        System.out.println("Expected: threeVariables");
    }
}
