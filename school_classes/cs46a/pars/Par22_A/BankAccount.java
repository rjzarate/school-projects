/**
 * Models BankAccount objects.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 11-22-2022
 */
// Step 2: Implement interface Qualifiable 
public class BankAccount implements Qualifiable
{  
    public static final double LOW_LIMIT = 1000;
    public static final double HIGH_LIMIT = 1500;
    
    private double balance;
    private String accountId;

    /**
     * Constructs a bank account with a given balance
     * and a string as the id.
     * 
     * @param initialBalance the initial balance
     * @param id the account id
     */
    public BankAccount(double initialBalance, String id)
    {   
        balance = initialBalance;
        accountId = id;
    }

    /**
     * Gets the id for this account.
     * 
     * @returns the id for this account
     */
    public String getAccountId()
    {
        return accountId;
    }

    /**
     * Deposits money into the bank account.
     * 
     * @param amount the amount to deposit
     */
    public void deposit(double amount)
    {  
        balance = balance + amount;
    }

    /**
     * Withdraws money from the bank account.
     * 
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {   
        balance = balance - amount;
    }

    /**
     * Gets the current balance of the bank account.
     * 
     * @return the current balance
     */
    public double getBalance()
    {   
        return balance;
    }
    
    // Step 3: Implement method qualifies() of
    //         interface Qualifiable
    /**
     * Determines if this bank account is qualifiable.
     * A bank account qualifies if the balance is in
     * the range [LOW_LIMIT, HIGH_LIMIT].
     *
     * @return true if this bank account is qualifiable
     *         false otherwise
     */
    public boolean qualifies()
    {
        //return qualifies();
        return HIGH_LIMIT >= balance && balance >= LOW_LIMIT;
    }

}
