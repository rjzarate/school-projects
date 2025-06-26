/**
 * A Java tester program for class Department.
 *
 * @author  Qi Yang
 * @version 2022-12-12
 */
public class DepartmentTester
{
    public static void main(String[] args)
    {
        Department csDept = new Department(6);
        Department seDept = new Department(500);
        
        System.out.println("All student: " + csDept.toString());
        System.out.println("Expected: []");
        System.out.println("Last student not in Dean'slist: " + csDept.lastNotInDeansList());
        System.out.println("Expected: null");
        System.out.println("All student: " + seDept.toString());
        System.out.println("Expected: []");
        System.out.println("Last student not in Dean'slist: " + seDept.lastNotInDeansList());
        System.out.println("Expected: null");

        csDept.add(new Student("Tom", 3.4));
        csDept.add(new Student("Mike", 3.5));

        System.out.println("All student: " + csDept.toString());
        System.out.println("Expected: [Student[Name=Tom,GPA=3.4], Student[Name=Mike,GPA=3.5]]");
        System.out.println("Last student not in Dean'slist: " + csDept.lastNotInDeansList());
        System.out.println("Expected: Student[Name=Tom,GPA=3.4]");

        csDept.remove(0);
        csDept.add(new Student("Tom", 3.4));

        csDept.add(new Student("Joe", 3.9));
        csDept.add(new Student("Jon", 3.45));
        
        System.out.println("All student: " + csDept.toString());
        System.out.println("Expected: [Student[Name=Mike,GPA=3.5], Student[Name=Tom,GPA=3.4], " +
                                      "Student[Name=Joe,GPA=3.9], Student[Name=Jon,GPA=3.45]]");
        System.out.println("Last student not in Dean'slist: " + csDept.lastNotInDeansList());
        System.out.println("Expected: Student[Name=Jon,GPA=3.45]");

        csDept.add(new Student("Mary", 3.4));

        System.out.println("All student: " + csDept.toString());
        System.out.println("Expected: [Student[Name=Mike,GPA=3.5], Student[Name=Tom,GPA=3.4], " +
                                      "Student[Name=Joe,GPA=3.9], Student[Name=Jon,GPA=3.45], " +
                                      "Student[Name=Mary,GPA=3.4]]");
        System.out.println("Last student not in Dean'slist: " + csDept.lastNotInDeansList());
        System.out.println("Expected: Student[Name=Mary,GPA=3.4]");
        
        csDept.sort();
         
        System.out.println("All student: " + csDept.toString());
        System.out.println("Expected: [Student[Name=Mary,GPA=3.4], Student[Name=Tom,GPA=3.4], " +
                                      "Student[Name=Jon,GPA=3.45], Student[Name=Mike,GPA=3.5], " +
                                      "Student[Name=Joe,GPA=3.9]]");
        System.out.println("Last student not in Dean'slist: " + csDept.lastNotInDeansList());
        System.out.println("Expected: Student[Name=Jon,GPA=3.45]");

        csDept.add(new Student("Jason", 3.45));
        csDept.add(new Student("Lisa", 2.5));

        System.out.println("All student: " + csDept.toString());
        System.out.println("Expected: [Student[Name=Mary,GPA=3.4], Student[Name=Tom,GPA=3.4], " +
                                      "Student[Name=Jon,GPA=3.45], Student[Name=Mike,GPA=3.5], " +
                                      "Student[Name=Joe,GPA=3.9], Student[Name=Jason,GPA=3.45]]");
        System.out.println("Last student not in Dean'slist: " + csDept.lastNotInDeansList());
        System.out.println("Expected: Student[Name=Jason,GPA=3.45]");

        csDept.sort();
        System.out.println("All student: " + csDept.toString());
        System.out.println("Expected: [Student[Name=Mary,GPA=3.4], Student[Name=Tom,GPA=3.4], " +
                                      "Student[Name=Jason,GPA=3.45], Student[Name=Jon,GPA=3.45], " +
                                      "Student[Name=Mike,GPA=3.5], Student[Name=Joe,GPA=3.9]]");
        System.out.println("Last student not in Dean'slist: " + csDept.lastNotInDeansList());
        System.out.println("Expected: Student[Name=Jon,GPA=3.45]");
        
        Student student = csDept.remove(2);
        System.out.println(student);
        System.out.println("Expected: Student[Name=Jason,GPA=3.45]"); 
        
        student = csDept.remove(0);
        System.out.println(student);
        System.out.println("Expected: Student[Name=Mary,GPA=3.4]"); 
        
        student = csDept.remove(3);
        System.out.println(student);
        System.out.println("Expected: Student[Name=Joe,GPA=3.9]"); 

        System.out.println("All student: " + csDept.toString());
        System.out.println("Expected: [Student[Name=Tom,GPA=3.4], " +
                                      "Student[Name=Jon,GPA=3.45], " +
                                      "Student[Name=Mike,GPA=3.5]]");
        System.out.println("Last student not in Dean'slist: " + csDept.lastNotInDeansList());
        System.out.println("Expected: Student[Name=Jon,GPA=3.45]");
        
        student = csDept.remove(-1);
        System.out.println(student);
        System.out.println("Expected: null"); 
        
        student = csDept.remove(3);
        System.out.println(student);
        System.out.println("Expected: null"); 

        System.out.println("All student: " + csDept.toString());
        System.out.println("Expected: [Student[Name=Tom,GPA=3.4], " +
                                      "Student[Name=Jon,GPA=3.45], " +
                                      "Student[Name=Mike,GPA=3.5]]");

        System.out.println("All student: " + seDept.toString());
        System.out.println("Expected: []");
        System.out.println("Last student not in Dean'slist: " + seDept.lastNotInDeansList());
        System.out.println("Expected: null");
    }
}
