/**
 * A Java application using class Day.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 09-01-2022
 */
public class DayProg
{
    public static void main(String[] args)
    {
        // Step 2: Construct a Day object representing today
        //         and assign it to a variable called aDay
        Day aDay = new Day();
        
        // Step 3: Construct a Day object representing the day 
        //         for our Exam1 on October 6, 2022, and assign 
        //         it to a variable called examOne
        Day examOne = new Day(2022, 10, 6);

        // Step 4: Declare three integer variables called
        //         year, month and day with initial values
        //         of 2022, 11, 15.
        int year = 2022;
        int month = 11;
        int day = 15;
        
        // Step 5: Construct a Day object using the three variables
        //         and assign it to a variable called examTwo
        Day examTwo = new Day(year, month, day);
        
        // Step 6: Display the three days on separate lines
        //         without any messages
        System.out.println(aDay);
        System.out.println(examOne);
        System.out.println(examTwo);

        // Step 7: Display the number of days as a positive integer
        //         between the two exams with a message
        //          "Number of days between the two exams: "
        System.out.println("Number of days between the two exams: " + examTwo.daysFrom(examOne));
        
        // Step 8: Declare an int variable numOfDays with an initial value of 2
        // Codecheck will use a different value to test your program.
        int numOfDays = 2;
        

        // Step 9: Call method addDays() on aDay using numOfDays as parameter
        aDay.addDays(numOfDays);
        
        // Step 10: Print the year, month, and day of aDay, 
        //          one value per line without any messages
        // You must call methods on aDay to get the values.
        System.out.println(aDay.getYear());
        System.out.println(aDay.getMonth());
        System.out.println(aDay.getDayOfMonth());

    }
}
