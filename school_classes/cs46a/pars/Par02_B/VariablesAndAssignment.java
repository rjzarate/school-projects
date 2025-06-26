/**
 * A Java program for practicing variables,
 * assignments and basic operators.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version August 31, 2022
 */
public class VariablesAndAssignment
{
    public static void main(String[] args)
    {
        // Step 2: Declare an integer variable called firstNum 
        //         with an initial value of 17.
        int firstNum = 17;

        
        // Step 3: Declare an integer variable called secondNum 
        //         with an initial value of 23.
        int secondNum = 23;
    
        // Step 4: Declare an integer variable called total 
        //         without any initial value.
        int total;
        
        // Step 5: Add firstNum and secondNum and assign the sum
        //         to total.
        total = firstNum + secondNum;
        
        // Step 6: Assign the difference of firstNum minus 
        //         secondNum to an integer variable called diff.
        int diff = firstNum - secondNum;
        
        // Step 7: Assign the product of firstNum and secondNum
        //         to an integer variable called prod. 
        int prod = firstNum * secondNum;
        
        // Step 8: Assign the quotient of firstNum divided by
        //         secondNum to an integer variable called intQ.
        int intQ = firstNum / secondNum;

        
        // Step 9: Assign the value of firstNum to a double
        //         variable called dblNum. 
        double dblNum = firstNum;
        
        // Step 10: Assign the quotient of dblNum divided by
        //         secondNum to a double variable called dblQ.
        double dblQ = dblNum / secondNum;

        
        // Step 11: Display firstNum, secondNum, total, diff,
        //          prod, intQ, and dblQ, one per line.
        //          Start each line with a short message:
        //             "First Number: "
        //             "Second Number: " 
        //             "The total: " 
        //             "The difference: " 
        //             "The product: "
        //             "The integer quotient: "
        //             "The double quotient: "
        System.out.println("First Number: " + firstNum);
        System.out.println("Second Number: " + secondNum);
        System.out.println("The total: " + total);
        System.out.println("The difference: " + diff);
        System.out.println("The product: " + prod);
        System.out.println("The integer quotient: " + intQ);
        System.out.println("The double quotient: " + dblQ);
    }
}
