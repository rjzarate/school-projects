/**
 * The class models Frog objects with one int variable for weight.
 * A frog has no legs if its weight is at most 5 
 * (MAX_WEIGHT_FOR_LIGHT_WEIGHT_FROG), 4 legs if
 * its weight is more than 20 (MAX_WEIGHT_FOR_MED_WEIGHT_FROG), 
 * and 2 legs otherwise.
 * The minimum value for weight is 1 (MIN_WEIGHT_FOR_FROG).
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 11-29-2022
 */
// Step 2: Implement interface Camparable
public class Frog implements Comparable
{
    public static final int MIN_WEIGHT_FOR_FROG = 1;
    public static final int MAX_WEIGHT_FOR_LIGHT_WEIGHT_FROG = 5;
    public static final int MAX_WEIGHT_FOR_MED_WEIGHT_FROG = 20;
    public static final int LEGS_FOR_LIGHT_WEIGHT_FROG = 0;
    public static final int LEGS_FOR_MED_WEIGHT_FROG = 2;
    public static final int LEGS_FOR_HEAVY_WEIGHT_FROG = 4;
    
    private int weight;
    private String id;
    
    /**
     * Creates a frog object with the given weight but sets
     * the weight to MIN_WEIGHT_FOR_FROG if the parameter 
     * is less than MIN_WEIGHT_FOR_FROG.
     * 
     * @param id the id of this frog
     * @param weight the weight of this Frog object
     */
    public Frog(String id, int weight)
    {
        this.id = id;
        if (weight < MIN_WEIGHT_FOR_FROG)
            this.weight = MIN_WEIGHT_FOR_FROG;
        else
            this.weight = weight;
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
       s = "Frog[ID:" + id + ",Weight:" + weight + ",Legs:" + getLegs() + "]";
       
       return s;
    }
    
    // Step 3: Implement method compareTo() of interface Comparable
    /**
     * Implements method compareTo() of interface Comparable.
     * This frog comes first if it has a smaller weight, or 
     * its id comes first when the weight is the same.
     * 
     * @param obj the other frog object to compare to
     * @return a negative integer if this frog comes first
     *         a positive integer if this frog comes after
     *         zero otherwise
     */
    public int compareTo(Object obj)
    {
        Frog anotherFrog = (Frog) obj;
        
        if (anotherFrog.weight < this.weight)
        {
            return 1;
        } else if (anotherFrog.id.equals(this.id) && anotherFrog.weight == this.weight)
        {
            return 1;
        } else
        return -1;
    }
}
