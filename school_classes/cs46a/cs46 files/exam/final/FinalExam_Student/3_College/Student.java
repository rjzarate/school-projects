/**
 * The class models students with a name and a gpa.
 *
 * @author  Qi Yang
 * @version 2022-12-12
 */
public class Student
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
}
