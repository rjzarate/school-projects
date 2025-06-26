/**
 * A Java application using class Day.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 09-06-2022
 */
public class DayTester
{
    public static void main(String[] args)
    {
        // Step 2: Declare three int variables called
        //         year, month, and day with initial values
        //         of 2022, 10, 6.
        int year = 2022;
        int month = 10;
        int day = 6;

        
        // Step 3: Construct a Day object using the three int
        //         variables and assign it to a variable 
        //         called examOne
        Day examOne = new Day(year, month, day);


        // Step 4: Display examOne on a line
        System.out.println(examOne);


        // This is the date for our exam1
        System.out.println("Expected: 2022-10-06");
        
        // Step 5: Reset month to 11 and day to 15
        month = 11;
        day = 15;

        
        // Step 6: Construct a Day object using the same 
        //         three variables and assign it to a 
        //         variable called examTwo
        Day examTwo = new Day(year, month, day);
        

        
        // Step 7: Display examTwo on a line
        System.out.println(examTwo);


        // This is the date for our exam2
        System.out.println("Expected: 2022-11-15");

        // Step 8: Display the number of days between 
        //         the two exams as a positive integer
        System.out.println(examTwo.daysFrom(examOne));

        
        // This is the number of days between our exam1
        // and our exam2
        System.out.println("Expected: 40");

        // Step 9: Update examOne to the day 69 days later
        examOne.addDays(69);

        
        // Step 10: Display examOne on a line
        System.out.println(examOne);


        // This is the date for our final exam
        System.out.println("Expected: 2022-12-14");
        
        // Step 11: Display the number of days between 
        //          examOne and examTwo as a positive integer
        // Note: examOne now holds the date for our final exam
        System.out.println(examOne.daysFrom(examTwo));

        
        // This is the number of days between our exam2 and
        // our final exam.
        System.out.println("Expected: 29");
    }
}
