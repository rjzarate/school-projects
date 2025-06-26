// Step 1: Import Java classes Arrays, ArrayList, and Collections
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
/**
 * A tester program for class Student.
 * 
 * Step 2: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 11-29-2022
 */
public class StudentTester
{
    public static void main(String[] args)
    {
        System.out.println("Part I: Sorting an array list of Student: ");
        ArrayList<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("Amy", 3.4));
        studentList.add(new Student("Thong", 3.4));
        studentList.add(new Student("Perdeep", 3.6));
        studentList.add(new Student("Carlos", 3.6));
        studentList.add(new Student("Mica", 3.4));

        System.out.println("Before sorting: " + studentList.toString());
        System.out.println("Expected: [Student[name=Amy;GPA=3.4], Student[name=Thong;GPA=3.4], " +
                                      "Student[name=Perdeep;GPA=3.6], Student[name=Carlos;GPA=3.6], " +
                                      "Student[name=Mica;GPA=3.4]]");
        
        // Step 3: Call a static method to sort the array list 
        Collections.sort(studentList);
        
        System.out.println("After sorting: " + studentList.toString());
        System.out.println("Expected: [Student[name=Amy;GPA=3.4], Student[name=Mica;GPA=3.4], " +
                                      "Student[name=Thong;GPA=3.4], Student[name=Carlos;GPA=3.6], " +
                                      "Student[name=Perdeep;GPA=3.6]]");
        
        System.out.println("Part II: Sorting a partial array of Student: ");
        
        Student[] studentArray = new Student[10];
        int numOfStudents = 5;
        
        studentArray[0] = new Student("Tom", 3.1);
        studentArray[1] = new Student("Lisa", 3.4);
        studentArray[2] = new Student("Mike", 3.1);   
        studentArray[3] = new Student("Joe", 3.4);
        studentArray[4] = new Student("Mary", 3.1);

        String allStudents = "[" + studentArray[0].toString();
        for (int i = 1; i < numOfStudents; i ++)
            allStudents += ", " + studentArray[i].toString();
        allStudents += "]";

        System.out.println("Before sorting: " + allStudents);
        System.out.println("Expected: [Student[name=Tom;GPA=3.1], Student[name=Lisa;GPA=3.4], " +
                                      "Student[name=Mike;GPA=3.1], Student[name=Joe;GPA=3.4], " +
                                      "Student[name=Mary;GPA=3.1]]");

        // Step 4: Call a static method to sort the partial array
        Arrays.sort(studentArray, 0, 5);
        
        allStudents = "[" + studentArray[0].toString();
        for (int i = 1; i < numOfStudents; i ++)
            allStudents += ", " + studentArray[i].toString();
        allStudents += "]";
        System.out.println("After sorting: " + allStudents);
        System.out.println("Expected: [Student[name=Mary;GPA=3.1], Student[name=Mike;GPA=3.1], " +
                                      "Student[name=Tom;GPA=3.1], Student[name=Joe;GPA=3.4], " +
                                      "Student[name=Lisa;GPA=3.4]]");
                                      
        System.out.println("Part III: Sorting a full array of Student: ");
        
        studentArray[5] = new Student("Amy", 3.4);
        studentArray[6] = new Student("Thong", 3.4);
        studentArray[7] = new Student("Perdeep", 3.6);
        studentArray[8] = new Student("Carlos", 3.6);
        studentArray[9] = new Student("Mica", 3.1);
        numOfStudents = 10;
        
        System.out.println("Before sorting: " + Arrays.toString(studentArray));
        System.out.println("Expected: [Student[name=Mary;GPA=3.1], Student[name=Mike;GPA=3.1], " +
                                      "Student[name=Tom;GPA=3.1], Student[name=Joe;GPA=3.4], " +
                                      "Student[name=Lisa;GPA=3.4], Student[name=Amy;GPA=3.4], " +
                                      "Student[name=Thong;GPA=3.4], Student[name=Perdeep;GPA=3.6], " +
                                      "Student[name=Carlos;GPA=3.6], Student[name=Mica;GPA=3.1]]");
                                      
        // Step 5: Call a static method to sort the full array
        Arrays.sort(studentArray);
        
        System.out.println("After sorting: " + Arrays.toString(studentArray));
        System.out.println("Expected: [Student[name=Mary;GPA=3.1], Student[name=Mica;GPA=3.1], " +
                                      "Student[name=Mike;GPA=3.1], Student[name=Tom;GPA=3.1], " +
                                      "Student[name=Amy;GPA=3.4], Student[name=Joe;GPA=3.4], " +
                                      "Student[name=Lisa;GPA=3.4], Student[name=Thong;GPA=3.4], " +
                                      "Student[name=Carlos;GPA=3.6], Student[name=Perdeep;GPA=3.6]]");
    }
}
