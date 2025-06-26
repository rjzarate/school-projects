/**
 * A Java tester program for class College.
 *
 * @author  Qi Yang
 * @version 2022-12-12
 */
public class CollegeTester
{
    public static void main(String[] args)
    {
        College cos = new College();
        College coe = new College();

        System.out.println("All students: " + cos.toString());
        System.out.println("Expected: []");
        System.out.println("Number of students on the Dean's List: " + cos.countOfDeansList());
        System.out.println("Expected: 0");
        
        cos.add(new Student("Joe", 3.9));
        cos.add(new Student("Mike", 3.5));
        cos.add(new Student("Tom", 3.4));
        
        System.out.println("All students: " + cos.toString());
        System.out.println("Expected: [Student[Name=Joe,GPA=3.9], Student[Name=Mike,GPA=3.5], " +
                                      "Student[Name=Tom,GPA=3.4]]");
        System.out.println("Number of students on the Dean's List: " + cos.countOfDeansList());
        System.out.println("Expected: 2");
        
        System.out.println("All students: " + coe.toString());
        System.out.println("Expected: []");
        System.out.println("Number of students on the Dean's List: " + coe.countOfDeansList());
        System.out.println("Expected: 0");

        cos.add(new Student("Qi", 3.51));
        cos.add(new Student("Jason", 2.5));
        cos.add(new Student("Jon", 3.45));
        
        System.out.println("All students: " + cos.toString());
        System.out.println("Expected: [Student[Name=Joe,GPA=3.9], Student[Name=Mike,GPA=3.5], " +
                                      "Student[Name=Tom,GPA=3.4], Student[Name=Qi,GPA=3.51], " +
                                      "Student[Name=Jason,GPA=2.5], Student[Name=Jon,GPA=3.45]]");
        System.out.println("Number of students on the Dean's List: " + cos.countOfDeansList());
        System.out.println("Expected: 3");

        cos.swap(0, 5);
        cos.swap(5, 4);
        cos.swap(1, 0);
        System.out.println("All students: " + cos.toString());
        System.out.println("Expected: [Student[Name=Mike,GPA=3.5], Student[Name=Jon,GPA=3.45], " +
                                      "Student[Name=Tom,GPA=3.4], Student[Name=Qi,GPA=3.51], " +
                                      "Student[Name=Joe,GPA=3.9], Student[Name=Jason,GPA=2.5]]");

        cos.swap(-1, 3);
        cos.swap(6, 3);
        cos.swap(2, -2);
        cos.swap(2, 6);
        System.out.println("All students: " + cos.toString());
        System.out.println("Expected: [Student[Name=Mike,GPA=3.5], Student[Name=Jon,GPA=3.45], " +
                                      "Student[Name=Tom,GPA=3.4], Student[Name=Qi,GPA=3.51], " +
                                      "Student[Name=Joe,GPA=3.9], Student[Name=Jason,GPA=2.5]]");
    }
}
