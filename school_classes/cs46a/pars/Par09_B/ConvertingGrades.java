import java.util.Scanner;
/**
 * The Java program converts letter grades to numeric grades.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 09-22-2022
 */
public class ConvertingGrades
{
    public static void main(String[] args)
    {
        final double NUMERIC_GRADE_A = 4.0;
        final double NUMERIC_GRADE_B = 3.0;
        final double NUMERIC_GRADE_C = 2.0;
        final double NUMERIC_GRADE_D = 1.0;
        final double NUMERIC_GRADE_F = 0.0;
        final double INVALID_GRADE = -1.0;
        
        // Step 2: Create a Scanner object to read input
        //         from the key board
        Scanner in = new Scanner(System.in);
        
        // Step 3: Display an input prompt 
        //         "Enter the letter grade: " 
        System.out.print("Enter the letter grade: ");

        // Step 4: Read in a single string and assign
        //         it to a string variable gradeStr
        String gradeStr = in.nextLine();
        
        // Step 5: Convert all chars of gradeStr to upper case
        gradeStr = gradeStr.toUpperCase();
        
        // Step 6: Get the first char of gradeStr
        //         and assign it to a char variable grade
        char grade = gradeStr.charAt(0);
        
        double numGrade = 0;

        // Step 7: Use one if statement with multiple alternatives
        //         to calculate the numeric grade according to the 
        //         following table:
        //          Letter Grade        Numeric Grade
        //              A                   4.0
        //              B                   3.0
        //              C                   2.0
        //              D                   1.0
        //              F                   0.0
        //         Others (errors)         -1.0
        // You can use 'A', 'B', 'C', 'D', and 'F' in your code
        // but you cannot use any magic numbers, even 0.0 or -1.0.
        if (grade == 'A')
        {
            numGrade = NUMERIC_GRADE_A;
        }
        else if (grade == 'B')
        {
            numGrade = NUMERIC_GRADE_B;
        }
        else if (grade == 'C')
        {
            numGrade = NUMERIC_GRADE_C;
        }
        else if (grade == 'D')
        {
            numGrade = NUMERIC_GRADE_D;
        }
        else if (grade == 'F')
        {
            numGrade = NUMERIC_GRADE_F;
        }
        else 
        {
            numGrade = INVALID_GRADE;
        }


        // Step 8: Display the numeric grade with one decimal digit
        //         and the letter grade within single quotes
        // Sample output
        // The numeric grade for letter grade 'B' is 3.0.
        System.out.print("The numeric grade for letter grade '" + grade + "' is " + numGrade + ".");

    }
}
