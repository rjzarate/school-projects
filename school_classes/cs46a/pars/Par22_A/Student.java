/**
 * The class models students with a name and a gpa.
 * 
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 11-22-2022
 */
// Step 2: Implement interface Qualifiable 
public class Student implements Qualifiable
{
    public static final double LOW_LIMIT = 3.45;
    
    private String name;
    private double gpa;

    /**
     * Constructs a Student object.
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
     * Gets the name of this student.
     * 
     * @return the name of this student
     */
    public String getName()
    {
       return name;
    }
    
    /**
     * Gets the gpa of this student.
     * 
     * @return the gpa of this student
     */
    public double getGpa()
    {
        return gpa;
    }
    
    // Step 3: Implement method qualifies() of
    //         interface Qualifiable
    /**
     * Determines if this student is qualifiable.
     * A student qualifies if the gpa is at least 
     * LOW_LIMIT.
     *
     * @return true if this student is qualifiable
     *         false otherwise
     */
    public boolean qualifies()
    {
        //return qualifies();
        return gpa >= LOW_LIMIT;
    }

}