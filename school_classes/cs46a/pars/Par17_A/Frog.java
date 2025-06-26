/**
 * The class models Frog objects with one int variable for weight.
 * A frog has no legs if its weight is at most 5 
 * (MAX_WEIGHT_FOR_LIGHT_WEIGHT_FROG), 4 legs if
 * its weight is more than 20 (MAX_WEIGHT_FOR_MED_WEIGHT_FROG), 
 * and 2 legs otherwise.
 * The minimum value for weight is 1 (MIN_WEIGHT_FOR_FROG).
 *
 * @author  Qi Yang
 * @version 2022-10-27
 */
public class Frog
{
    public static final int MIN_WEIGHT_FOR_FROG = 1;
    public static final int MAX_WEIGHT_FOR_LIGHT_WEIGHT_FROG = 5;
    public static final int MAX_WEIGHT_FOR_MED_WEIGHT_FROG = 20;
    public static final int LEGS_FOR_LIGHT_WEIGHT_FROG = 0;
    public static final int LEGS_FOR_MED_WEIGHT_FROG = 2;
    public static final int LEGS_FOR_HEAVY_WEIGHT_FROG = 4;
    
    private int weight;
    
    /**
     * Creates a frog object with the given weight but sets
     * the weight to MIN_WEIGHT_FOR_FROG if the parameter 
     * is less than MIN_WEIGHT_FOR_FROG.
     * 
     * @param weightParam the weight of this Frog object
     */
    public Frog(int weightParam)
    {
        if (weightParam < MIN_WEIGHT_FOR_FROG)
            weight = MIN_WEIGHT_FOR_FROG;
        else
            weight = weightParam;
    }

    /**
     * Gets the weight of this Frog object.
     * 
     * @return the weight of this Frog object
     */
    public int getWeight()
    {
        return weight;
    }
    
    /**
     * Calculates and returns the number of legs 
     * of this Frog object.
     * 
     * @return the number of legs of this Frog object
     */
    public int getLegs()
    {
        int numLegs;
        
        if (weight <= MAX_WEIGHT_FOR_LIGHT_WEIGHT_FROG)
            numLegs = LEGS_FOR_LIGHT_WEIGHT_FROG;
        else if (weight > MAX_WEIGHT_FOR_MED_WEIGHT_FROG)
            numLegs = LEGS_FOR_HEAVY_WEIGHT_FROG;
        else
            numLegs = LEGS_FOR_MED_WEIGHT_FROG;

        return numLegs;
    }
    
    /**
     * Increases the weight of this frog by amount if amount 
     * is positive; do nothing otherwise.
     *
     * @param amount the amount to grow this Frog's weight
     */
    public void grow (int amount)
    {
        if (amount >= MIN_WEIGHT_FOR_FROG)
        {
            weight += amount;
        }
    }
    
    /**
     * Gets a string for this Frog object with its weight and legs.
     * 
     * @return a string for this Frog object such as
     *         "Frog[Weight:10,Legs:2]"
     */
    @Override
    public String toString()
    {
       String s = "";
       s = "Frog[Weight:" + weight + ",Legs:" + getLegs() + "]";
       
       return s;
    }
}