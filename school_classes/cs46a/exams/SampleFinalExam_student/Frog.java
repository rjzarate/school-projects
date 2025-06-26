/**
 * A class models frog objects with an id,
 * a weight, and a number of legs.
 * A frog has no legs if its weight is at most
 * 5.0, 4 legs if its weight is more than 20.0, 
 * and 2 legs otherwise.
 *
 * Step 1: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version SampleFinalExam
 */
// Step 2: Implement interface Comparable
public class Frog implements Comparable
{
    public static final double MIN_WEIGHT = 0.5;
    public static final double MED_WEIGHT = 5.0;
    public static final double BIG_WEIGHT = 20.0;
    public static final int MED_LEGS = 2;
    public static final int BIG_LEGS = 4;
    
    // Step 3: Declare three instance variables
    //         id of String 
    //         weight of double
    //         number of legs of int
    private String id;
    private double weight;
    private int legs;
    
    // Step 4: Complete the constructor
    //         You should call setLegs() to set the number of legs
    /**
     * Constructor of class Frog.
     * Assuming the id parameter is a good string,
     * the constructor will set the id to the parameter;
     * the weight parameter could be too small, and the
     * the constructor will set weight to the parameter
     * if it is valid but will set weight to MIN_WEIGHT 
     * otherwise; the constructor will also determine 
     * the number of legs by calling method setLegs()
     * 
     * @param id the id of this frog 
     * @param weight the weight of this frog 
     */
    public Frog(String id, double weight)
    {
        this.id = id;
        if (weight > MIN_WEIGHT)
        {
            this.weight = weight;
        } else
        this.weight = MIN_WEIGHT;
        
        setLegs();
    }

    // Step 5: Complete method getID()
    /**
     * Gets the id of this frog.
     * 
     * @return the weight of this frog 
     */
    public String getID()
    {
        return id;
    }
    
    // Step 6: Complete method getWeight()
    /**
     * Gets the weight of this frog.
     * 
     * @return the weight of this Frog 
     */
    public double getWeight()
    {
        return weight;
    }
    
    // Step 7: Complete method grow()
    //         You should call setLegs() to set the number of legs
    /**
     * Grows this frog by increasing its weight and adjusting its
     * number of legs. It does nothing if the parameter is not
     * positive.
     *
     * @param  amount the amount to grow this frog's weight
     */
    public void grow (double amount)
    {
        if (amount > 0)
        weight += amount;
        setLegs();
    }
    
    // Step 8: Override method toString()
    /**
     * Gets a string presentation for this frog.
     * 
     * @return a string for this frog including id, 
     *         weight and number of legs in the format
     *         "Frog[ID=1234,Weight=10.0,Legs=2]"
     */
    @Override 
    public String toString()
    {
        
        return "Frog[ID=" + id + ",Weight=" + weight + ",Legs=" + legs + "]";
    }
    
    // Step 9: Implement method compareTo() for interface
    //         Comparable
    // DO NOT change the given method header!
    // Do not use if statements to compare the weight.
    /**
     * Implements method compareTo() for interface
     * Comparable by comparing the weight first 
     * then the id.
     * 
     * @param  obj the Frog object to compare to
     * @return an integer indicating the comparison result.
     */
    public int compareTo(Object obj)
    {
        Frog anotherFrog = (Frog) obj;
        
        
        return Double.compare(anotherFrog.getWeight(), weight);
    }
    
    // Step 10: Complete method setLegs()
    // Do not use independent if statements.
    /**
     * Sets the number of legs based on the weight.
     * A frog has no legs if its weight is at most
     * MED_WEIGHT (5.0), BIG_LEGS (4) legs if its  
     * weight is more than BIG_WEIGHT (20.0), and 
     * MED_LEGS (2) legs otherwise.
     */
    private void setLegs()
    {
        if (this.weight <= MED_WEIGHT)
        {
            legs = 0;
        } else if (this.weight > BIG_WEIGHT)
        {
            legs = 4;
        } else
        legs = 2;
    }
}
