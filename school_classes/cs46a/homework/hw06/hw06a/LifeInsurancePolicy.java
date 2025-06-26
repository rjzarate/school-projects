
/**
 * Automates the calculation of yearly life insurance premiums for individuals based on their gender and age and whether they live in a high crime area.
 *
 * @author Froilan Zarate
 * @version 10-15-2022
 */
public class LifeInsurancePolicy
{
    // instance variables - replace the example below with your own
    public static final double SURCHARGE = 0.1;
    public static final double MALE_L21 = 20;
    public static final double MALE_21_L60 = 50;
    public static final double MALE_60_L80 = 110;
    public static final double FEMALE_L21 = 18.5;
    public static final double FEMALE_21_L60 = 45;
    public static final double FEMALE_60_L80 = 100;
    public static final int AGE_21 = 21;
    public static final int AGE_60 = 60;
    public static final int AGE_80 = 80;
    
    
    private Person individual;
    private boolean highCrime;

    /**
     * Constructor for LifeInsurancePolicy
     * 
     * @param theIndividual   the person
     * @param theHighCrime if they are in a high crime area
     */
    public LifeInsurancePolicy(Person theIndividual, boolean theHighCrime)
    {
        individual = theIndividual;
        highCrime = theHighCrime;
    }
    /**
     * Gets the age of the insured person
     *
     * @return  the age of the individual
     */
    public int policyHolderAge()
    {
        return individual.getAge();
    }
    /**
     * Gets the gender of the insured person
     *
     * @return  the gender of the individual
     */
    public String policyHolderGender()
    {
        return "" + individual.getGender();
    }
    /**
     * Increments the age of the insured person
     */
    public void incrementAge()
    {
        individual.birthday();
    }
    /**
     * Gets the yearly premium for the insured person or -1 if the age is greater than or equal to 80.
     *
     * @return  the yearly premium
     */
    public double premium()
    {
        int age = individual.getAge();
        String gender = "" + individual.getGender();
        double premium = (double) age;
        if (age >= AGE_80)
        {
            return -1;
        }
        if (gender.contains("m"))
        {
            if (age < AGE_21)
            {
                premium = premium * MALE_L21;
            } else if (age >= AGE_21 && age < AGE_60)
            {
                premium = premium * MALE_21_L60;
            } else if (age >= AGE_60)
            {
                premium = premium * MALE_60_L80;
            }
        }
        if (gender.contains("f"))
        {
            if (age < AGE_21)
            {
                premium = premium * FEMALE_L21;
            } else if (age >= AGE_21 && age < AGE_60)
            {
                premium = premium * FEMALE_21_L60;
            } else if (age >= AGE_60)
            {
                premium = premium * FEMALE_60_L80;
            }
        }
        if (highCrime)
        {
            return premium = premium + (premium * SURCHARGE);
        }
        return premium;
        
        
    }
}
