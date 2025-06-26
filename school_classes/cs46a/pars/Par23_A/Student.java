/**
 * Models a student with a name and a grade point average.
 * 
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 11-29-2022
 */
// Step 2: Implement the Comparable interface
public class Student implements Comparable
{
    private String name;
    private double gpa;
    
    /**
     * Creates a student.
     * 
     * @param name the name of this student
     * @param gpa the gpa of this student
     */
    public Student(String name, double gpa)
    {
        this.name = name;
        this.gpa = gpa;
    }
    
    /**
     * Gets the name of this student.
     * 
     * @return the name of this student
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the GPA of this student.
     * 
     * @return the GPA of this student
     */
    public double getGPA()
    {
        return gpa;
    }

    /**
     * Gets a string representation for this student.
     * 
     * @return a string for this student with name and GPA
     */
    @Override
    public String toString()
    {
        return "Student[name=" + name + ";GPA=" + gpa + "]";
    }
    
    // Step 3: Write method compareTo() to implement
    //         the Comparable interface
    /**
     * Compares this student with another student, first 
     * based on GPA then based on name.
     * 
     * @param anotherObj the student object to compare to
     * @return an integer representing the comparing result
     *         positive if this student has higher GPA
     *         negative if this student has lower GPA
     *         otherwise return the result from comparing
     *              the names of the two students 
     */
    public int compareTo(Object anotherObj)
    {
        Student anotherStudent = (Student)anotherObj;
        
        if (this.gpa > anotherStudent.gpa)
        {
            return 1;
        } else if (gpa < anotherStudent.gpa)
        {
            return -1;
        } else
        return name.compareTo(anotherStudent.name);
    }

}