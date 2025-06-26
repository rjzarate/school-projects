/**
 * Tests the Student class.
 * 
 * @author  Qi Yang
 * @version 2022-09-13
 */
public class StudentTester
{
    public static void main(String[] args)
    {
        Student studentOne = new Student("Maria");       
        Student studentTwo = new Student("Frank");       
        
        // Testing method getName()
        System.out.println(studentOne.getName());
        System.out.println("Expected: Maria");
        System.out.println(studentTwo.getName());
        System.out.println("Expected: Frank");
        
        // Testing method getTotalScore()
        System.out.println(studentOne.getTotalScore());
        System.out.println("Expected: 0");
        System.out.println(studentTwo.getTotalScore());
        System.out.println("Expected: 0");

        // Testing method startAssignment() with parameter Par06
        System.out.println(studentOne.startAssignment("Par06"));
        System.out.println("Expected: Yes, Maria will start Par06 today!");
        System.out.println(studentTwo.startAssignment("Par06"));
        System.out.println("Expected: Yes, Frank will start Par06 today!");

        // Testing method addScore()
        studentOne.addScore(10);
        studentTwo.addScore(8);

        // Testing method getTotalScore()
        System.out.println(studentOne.getTotalScore());
        System.out.println("Expected: 10");
        System.out.println(studentTwo.getTotalScore());
        System.out.println("Expected: 8");
        
        // Testing method startAssignment() with parameter Hw03
        System.out.println(studentOne.startAssignment("Hw03"));
        System.out.println("Expected: Yes, Maria will start Hw03 today!");
        System.out.println(studentTwo.startAssignment("Hw03"));
        System.out.println("Expected: Yes, Frank will start Hw03 today!");

        // Testing method addScore()
        studentOne.addScore(27);
        studentTwo.addScore(30);

        // Testing method getTotalScore()
        System.out.println(studentOne.getTotalScore());
        System.out.println("Expected: 37");
        System.out.println(studentTwo.getTotalScore());
        System.out.println("Expected: 38");
    }
}
