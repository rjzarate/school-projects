import java.util.ArrayList;
/**
 * Write a description of class Orchard here.
 *
 * @author  Froilan Zarate
 * @version 10-22-2022
 */
public class Orchard
{
    // instance variables - replace the example below with your own
    private ArrayList<Tree> list;

    /**
     * Constructor for objects of class Orchard
     */
    public Orchard()
    {
        list = new ArrayList<Tree>();
    }
    /**
     * Adds tree if the index is vaild
     *
     * @param  tree  the tree
     * @param  index the index
     */
    public void add(Tree tree, int index)
    {
        if (index >= 0 && index <= list.size())
        {
            list.add(index, tree);
        }
    }
    /**
     * Finds the first tallest tree. Returns null if list is empty.
     *
     * @return  the tallest tree.
     */
    public Tree tallest()
    {
        if (list.size() == 0)
        return null;
        
        Tree tallest = list.get(0);
        
        for (Tree tree: list)
        {
            if (tree.getHeight() > tallest.getHeight())
            tallest = tree;
        }
        return tallest;
    }
    /**
     * Determines if the array list contains a tree object of a given type.
     * 
     * @param theType the type
     *
     * @return  true if tree type is found.
     */
    public boolean contains(String theType)
    {
        for (Tree tree: list)
        {
            if (tree.getType().equals(theType))
            return true;
        }
        return false;
    }
    /**
     * Turns array into string and returns it.
     *
     * @return  the list
     */
    public String treeList()
    {
        String str = "[";
        for (Tree tree: list)
        {
            str += tree.getType() + ", ";
        }
        str += "]";
        return str.replace(", ]", "]");
    }
}
