// Step 1: import Java class ArrayList
import java.util.ArrayList;
/**
 * The class manages an array list of class Student.
 *
 * Step 2: Enter your name for @author and the password for @version.
 * @author  Froilan Zarate
 * @version MyLastExam
 */
public class College
{
    public static final double DEANS_LIST_GPA = 3.5;
    
    // Step 3: Declare an array list of Student as
    //         the instance variable
    private ArrayList<Student> list;
    
    // Step 4: Complete the constructor
    /**
     * Initializes the instance variable to an empty 
     * ArrayList of class Student.
     */
    public College()
    {
        list = new ArrayList<Student>();
    }

    // Step 5: Complete method add()
    /**
     * Adds an object of class Student to the end of the list.
     *
     * @param student the student to be added
     */
    public void add(Student student)
    {
        list.add(student);
    }
    
    // Step 6: Complete method countOfDeansList().
    /**
     * Gets the number of students who should be on the Dean's
     * list, i.e., their gpa is at least DEANS_LIST_GPA.
     * 
     * You should use the enhanced for loop.
     *
     * @return the number of students who should be on the 
     *         Dean's list
     */
    public int countOfDeansList()
    {
        int count = 0;
        for (Student student: list)
        {
            if (student.getGpa() >= DEANS_LIST_GPA)
            count ++;
        }
        return count;
    }
    
    // Step 7: Complete method swap()
    /**
     * Swaps two students in the list if both index values
     * are valid. The method does nothing otherwise.
     * 
     * Do not use try-catch statement.
     * Do not use more than one temporary variable.
     * 
     * @param index1 the index of the first student
     * @param index2 the index of the second student
     * 
     */
    public void swap(int index1, int index2)
    {
        if (index1 >= 0 && index2 >= 0 && index1 < list.size() && index2 < list.size())
        {
            Student temp = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, temp);
        }
    }
    
    // Step 8: Complete method toString()
    /**
     * Gets a string representation for the list.
     * 
     * @return the string returned by method toString()
     *         on the list
     */
    @Override
    public String toString()
    {
        return list.toString();
    }
}