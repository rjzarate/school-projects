import java.util.Arrays;
/**
 * The class manages an array of Student for a department.
 * It provides some operations on the array. The actual 
 * number of students in the array needs to be maintained 
 * for the operations to perform their tasks.
 *
 * Step 1: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version MyLastExam
 */
public class Department
{
    public static final double DEANS_LIST_GPA = 3.5;

    private Student[] studentArray;
    private int numOfStudents;

    // Step 2: Complete the constructor
    /**
     * Initializes the managed array, studentArray, to an array
     * of a specified length and numOfStudents to zero.
     *         
     * @param length the length of the array to be managed
     */
    public Department(int length)
    {
        studentArray = new Student[length];
        numOfStudents = 0;
    }
    
    // Step 3: Complete method add()
    // Do not use the try-catch statement
    /**
     * Adds a student at the end of the array if
     * the array is not full, and does nothing
     * otherwise.
     *
     * @param student the student to be added
     */
    public void add(Student student)
    {
        if (numOfStudents < studentArray.length)
        {
            studentArray[numOfStudents] = student;
            numOfStudents ++;
        }
    }

    // Step 4: Complete method remove()
    /**
     * Deletes and returns the student at a specified 
     * index position and shfts all students after the 
     * deleted student (if any) to the left if the 
     * specified index is valid.
     * The method does nothing otherwise.
     * 
     * @param index the specified index position
     * @return the deleted student if index is valid
     *         null otherwise
     */
    public Student remove(int index)
    {
        if (index >= 0 && index < numOfStudents)
        {
            Student removedStudent = studentArray[index];
            
            for (int i = index; i < numOfStudents - 1; i ++)
            {
                studentArray[i] = studentArray[i + 1];
            }
            numOfStudents --;
            return removedStudent;
        }
        return null;
    }
    
    // Step 5: Complete method lastNotInDeansList()
    /**
     * Returns the last student in the array whose
     * GPA is less than DEANS_LIST_GPA.
     * 
     * The method should stop execution and return after
     * a student is found satisfying the condition.
     * 
     * @return the last student whose GPA is less than 
     *             DEANS_LIST_GPA
     *         null if no students with a GPA less than
     *             DEANS_LIST_GPA
     */
    public Student lastNotInDeansList()
    {
        for (int i = numOfStudents - 1; i >= 0; i --)
        {
            if (studentArray[i].getGpa() < DEANS_LIST_GPA)
                return studentArray[i];
        }
        return null;
    }
    
    // Step 6: Complete method sort()
    /**
     * Calls a static method to sort the array.
     */
    public void sort()
    {
        Arrays.sort(studentArray, 0, numOfStudents);
    }

    /**
     * Gets a string representation for the array in 
     * the following format:
     *    [Student[Name=Tom,GPA=3.4], ..., Student[Name=Joe,GPA=3.9]]
     * 
     * @return a string consisting all students in the array
     */
    @Override
    public String toString()
    {
        if (numOfStudents == 0)
            return "[]";
        
        String s = "[" + studentArray[0];
        for (int i = 1; i < numOfStudents; i ++)
            s += ", " + studentArray[i];
            
        return s + "]";
    }
}