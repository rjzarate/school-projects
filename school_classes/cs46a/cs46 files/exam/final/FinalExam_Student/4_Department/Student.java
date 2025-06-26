/**
 * The class models students with a name and a gpa.
 *
 * Step 1: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version MyLastExam
 */
// Step 2: Implement interface Comparable
public class Student implements Comparable
{
    private String name;
    private double gpa;

    /**
     * Constructor for objects of class Student
     * 
     * @param nameParam the name of this student
     * @param gpaParam the gpa of this student
     */
    public Student(String nameParam, double gpaParam)
    {
        name = nameParam;
        gpa = gpaParam;
    }

    /**
     * Gets the name of this student
     * 
     * @return the name of this student
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets the gpa of this student
     * 
     * @return the gpa of this student
     */
    public double getGpa()
    {
        return gpa;
    }
    
    /**
     * Sets the gpa of this student
     * 
     * @param newGpa the new gpa of this student
     */
    public void setGpa(double newGpa)
    {
        gpa = newGpa;
    }
    
    /**
     * Gets a string representing this student
     *
     * @return a string representing this student
     */
    public String toString()
    {
        return "Student[Name=" + name + ",GPA=" + gpa + "]";
    }
    
    // Step 3: Complete method compareTo() to implement
    //         interface Comparable
    // DO NOT change the method header.
    // Do not use an if statement to compare two gpa values,
    // since they are double values.
    /**
     * Compares this student to another student. A student
     * comes first if the GPA is smaller, or the name comes
     * first when the GPA is the same.
     * 
     * @param obj another student to compare to
     * @return a negative integer if this student comes first
     *         a positive integer if this student comes later
     *         0 otherwise
     */
    public int compareTo(Object obj)
    {
        Student anotherStudent = (Student) obj;
        if (this.gpa != anotherStudent.gpa)
        {
            return Double.compare(this.gpa, anotherStudent.gpa);
        } else
        {
            return this.name.compareTo(anotherStudent.name);
        }
    }
}
