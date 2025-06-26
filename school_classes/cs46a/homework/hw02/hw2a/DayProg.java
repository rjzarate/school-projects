
/**
 * Write a description of class DayProg here.
 *
 * @author Froilan Zarate
 * @version 09-01-2022
 */
public class DayProg
{
    public static void main(String[] args)
    {
        Day today = new Day();
        Day columbusDay = new Day(2022, 10, 10);
        int daysAway = columbusDay.daysFrom(today);
        
        System.out.println("Today is " + today + ".");
        System.out.println("The Columbus Day is " + columbusDay + ".");
        
        today.addDays(-23);
        
        System.out.println("There are " + daysAway + " days until the Columbus Day.");
        System.out.println("The date of 23 days ago is:");
        System.out.println("   Year : " + today.getYear());
        System.out.println("   Month: " + today.getMonth());
        System.out.println("   Day  : " + today.getDayOfMonth());
    }
}
