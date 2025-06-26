/**
 * The class models Frog objects with one int variable for weight.
 * A frog has no legs if its weight is at most 5, 4 legs if its
 * weight is more than 20, and 2 legs otherwise.
 * The minimum value for weight is 1.
 *
 * Step 1: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version SampleExamOne
 */
public class Frog
{
    // Notice: You should use the defined constants.
    //         No Magic Numbers, even 1 or 0!
    public static final int MIN_FROG_WEIGHT = 1;
    public static final int LIGHT_FROG_MAX_WEIGHT = 5;
    public static final int MED_FROG_MAX_WEIGHT = 20;
    public static final int LIGHT_FROG_LEGS = 0;
    public static final int MED_FROG_LEGS = 2;
    public static final int HEAVY_FROG_LEGS = 4;
    
    // Step 2: Declare an int instance variable for weight 
    private int weight;
    
    // Step 3: Write the constructor according to the description,
    //         including possible Javadoc tags
    /**
     * The constructor has one parameter and creates a frog 
     * object by initializing the weight to the parameter, 
     * but sets the weight to MIN_FROG_WEIGHT if the 
     * parameter is less than MIN_FROG_WEIGHT.
     * 
     * @param theWeight the weight of the frog
     */
    public Frog (int theWeight)
    {
        if (theWeight < MIN_FROG_WEIGHT)
        {
            weight = MIN_FROG_WEIGHT;
        } else
        {
            weight = theWeight;
        }
    }


    // Step 4: Write method getWeight() according to the description,
    //         including possible Javadoc tags
    /**
     * Gets the weight of this Frog object.
     * 
     * @return the weight of the frog
     */
    public int getWeight()
    {
        return weight;
    }

    
    // Step 5: Write method getLegs() according to the description,
    //         including possible Javadoc tags
    /**
     * Calculates and returns the number of legs of this Frog object. 
     * The number of legs is determined as below:
     *       number of legs                  weight          
     *    0 (LIGHT_FROG_LEGS)      at most 5 (LIGHT_FROG_MAX_WEIGHT)
     *    4 (HEAVY_FROG_LEGS)      more than 20 (MED_FROG_MAX_WEIGHT)
     *    2 (MED_FROG_LEGS)             otherwise
     * 
     * @return the number of legs the frog has depending on the weight
     */
    public int getLegs()
    {
        if (weight <= 5)
        {
            return LIGHT_FROG_LEGS;
        } else if (weight > 20)
        {
            return HEAVY_FROG_LEGS;
        } else
        {
            return MED_FROG_LEGS;
        }
    }

    
    // Step 6: Write method grow() according to the description,
    //         including possible Javadoc tags
    /**
     * Increases the weight of this frog by the amount 
     * of the parameter if the parameter is positive.
     * The method does nothing otherwise.
     * 
     * @param increase  adds to the weight of the frog
     */
    public void grow(int increase)
    {
        if (increase >= 1)
        {
            weight = increase + weight;
        }
    }

    
    // Step 7: Override method toString() according to the description,
    //         including possible Javadoc tags
    /**
     * Gets a string for this Frog object in the following format:
     *      "Frog[Weight:10,Legs:2]"
     * 
     * @return the weight and legs of the frog
     */
    public String toString()
    {
        String frogDetails = "Frog[Weight:" + weight + ",Legs:" + getLegs() + "]";
        
        return frogDetails;
    }

}
