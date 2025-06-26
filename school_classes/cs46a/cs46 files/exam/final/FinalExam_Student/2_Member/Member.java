// Step 1: import Java class Random
import java.util.Random;
/**
 * The class models golf club members with a name and a balance.
 *
 * Step 2: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version MyLastExam
 */
public class Member
{
    public static final double MIN_INITIAL_BALANCE = 100.0;

    // Step 3: Declare two instance variables
    //              a string for the name
    //              a double for the balance 
    private String name;
    private double balance;
    
    // Step 4: Complete the constructor
    /**
     * Initializes the name and the balance to the parameters,
     * but sets balance to MIN_INITIAL_BALANCE if the balance 
     * parameter is smaller than MIN_INITIAL_BALANCE.
     * 
     * @param nameParam the name of this member
     * @param balanceParam the balance of this member
     */
    public Member(String nameParam, double balanceParam)
    {
        name = nameParam;
        if (balanceParam > MIN_INITIAL_BALANCE)
        {
            balance = balanceParam;
        } else
            balance = MIN_INITIAL_BALANCE;
    }

    // Step 5: Override method toString()
    /**
     * Gets a string representation for this member.
     *
     * @return a string in the following format:
     *           Member[Name=Joe Clifton,Balance=150.0]
     */
    @Override
    public String toString()
    {
        return "Member[Name=" + name + ",Balance=" + balance + "]";
    }
    
    // Step 6: Complete method getBalance()
    /**
     * Gets the balance of this member
     * 
     * @return the balance of this member
     */
    public double getBalance()
    {
        return balance;
    }
    
    // Step 7: Complete method updateBalance
    /**
     * Updates the balance of this member by adding amount
     * to the balance.
     * 
     * @param amount the amount to update the balance
     */
    public void updateBalance(double amount)
    {
        balance += amount;
    }
    
    // Step 8: Complete method randomChar()
    /**
     * Creates a random generator with a given seed,
     * then generate a random integer in the range of 
     * [0, length - 1], where length is the length of 
     * the name of this member, and returns the char
     * in the name at that index position.
     * For example, if the name is "Joe Clifton" and
     * the random integer is 4, then the return char
     * is 'C'.
     *
     * @param  seed the seed used to create the random generator
     * @return the character at the random index position
     */
    public char randomChar(int seed)
    {
        Random random = new Random(seed);
        int index = random.nextInt(name.length());
        return name.charAt(index);
    }
}