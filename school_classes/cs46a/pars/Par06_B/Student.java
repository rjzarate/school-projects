/**
 * The class represents student objects with a name and a total score.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 09-13-2022
 */
public class Student
{
    // Step 2: Declare two instance variables 
    //         name: String
    //         totalScore: int
    private String name;
    private int totalScore;

    // Step 3: Complete the constructor,
    //         including Javadoc tags if any
    /**
     * Constructs a Student object by setting name to theName 
     * and totalScore to 0.
     *   
     * @param  theName the name of the student
     */
    public Student(String theName)
    {
        name = theName;
        totalScore = 0;
    }
    
    // Step 4: Complete method getName(),
    //         including Javadoc tags if any
    /**
     * Gets the name of this student.
     * 
     * @return the name of the student.
     */
    public String getName()
    {
       return name;
    }
    
    // Step 5: Complete method getTotalScore(),
    //         including Javadoc tags if any
    /**
     * Gets the total score for this student.
     *
     * @return the total score for the student.
     */
    public int getTotalScore()
    {
        return totalScore;
    }

    // Step 6: Complete method addScore(),
    //         including Javadoc tags if any
    /**
     * Adds score to total score for this student.
     * 
     * @param  score the score that will be added to the student's total score
     */    
    public void addScore(int score)
    {
        totalScore = totalScore + score;
    }

    // Step 7: Complete method startAssignment(),
    //         including Javadoc tags if any
    /**
     * Gets a string indicating to start the given assignment
     * today. For example, the return string will be
     *      "Yes, Frank will start Par06 today!";
     * when the student name is "Frank" and the parameter is "Par06"
     *
     * @param  assignment the assignment of the student
     * @return the name of student that the assignment will start today
     */
    public String startAssignment(String assignment)
    {
        String s;
        s = "Yes, " + name + " will start " + assignment + " today!";
        return s;
    
    }
}
