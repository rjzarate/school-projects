import java.util.Scanner;
/**
 * Evaluate the creepiness of a date.
 *
 * @author Froilan Zarate
 * @version 09-29-2022
 */
public class DatingCreepy
{
    public static void main(String[] args)
    {
        final int YOUNGEST_AGE = 18;
        final int OLDEST_AGE = 50;
        final int DIVISION_EQUATION_NUMBER = 2;
        final int ADDITION_EQUATION_NUMBER = 7;
        Scanner in = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = in.nextLine();
        name = name.trim();
        System.out.print("What is your age? ");
        int age = in.nextInt();
        if (age < YOUNGEST_AGE || age > OLDEST_AGE)
        {
            System.out.printf("You are too young or too old for our dating program.%nGoodbye, " + name + "!%n");
            return;
        }
        System.out.print("What is your date's age? ");
        int ageDate = in.nextInt();
        if (ageDate >= YOUNGEST_AGE && ageDate <= OLDEST_AGE)
        {
            int creepAge = age / DIVISION_EQUATION_NUMBER + ADDITION_EQUATION_NUMBER;
            int creepDateAge = ageDate / DIVISION_EQUATION_NUMBER + ADDITION_EQUATION_NUMBER;
            System.out.printf("Your creepy age is " + creepAge + ".%nYour date's creepy age is " + creepDateAge + ".%n");
            if  (age < creepDateAge)
            {
                System.out.print("Creepy alert, " + name + "! You are too young for your date!");
            }
            if (ageDate < creepAge)
            {
                System.out.print("Creepy alert, " + name + "! Your date is too young for you!");
            }
            if (age >= creepDateAge && ageDate >= creepAge)
            {
                System.out.print("Have a good time, " + name + "!");
            }
        } else
        {
            System.out.printf("Your date is too young or too old for our dating program.%nGoodbye, "
                                + name + "!");
        }
        
    }
}
