
/**
 * A tree with a type and height.
 *
 * @author  Froilan Zarate
 * @version 11-22-2022
 */
public class Tree
{
    // instance variables - replace the example below with your own
    private String type;
    private double height;

    /**
     * Constructor for objects of class Tree
     * 
     * @param thisType  the type of tree
     * @param thisHeight  the height of the tree
     */
    public Tree(String thisType, double thisHeight)
    {
        type = thisType;
        height = thisHeight;
    }
    /**
     * Gets the type of the tree.
     *
     * @return    the type
     */
    public String getType()
    {
        return type;
    }
    /**
     * Gets the height of the tree.
     *
     * @return    the height
     */
    public double getHeight()
    {
        return height;
    }
    /**
     * Sets the type of the tree.
     *
     * @param theType  the new type of tree
     */
    public void setType(String theType)
    {
        type = theType;
    }
    /**
     * Sets the height of the tree.
     *
     * @param theHeight  the new height of tree
     */
    public void setHeight(double theHeight)
    {
        height = theHeight;
    }
    /**
     * Turns the tree into a string.
     *
     * @return the tree in a string
     */
    @Override
    public String toString()
    {
        return "Tree[Type:" + type + ",Height:" + height + "]";
    }
}
