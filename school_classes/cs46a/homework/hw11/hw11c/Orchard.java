import java.util.Arrays;
/**
 * The array list for trees.
 *
 * @author  Froilan Zarate
 * @version 12-01-2022
 */
public class Orchard
{
    // instance variables - replace the example below with your own
    private Tree[] list;
    private int currentSize;
    private final static double TALL_TREE = 30;
    /**
     * Constructor for objects of class Orchard
     * 
     * @param size the max length of the array
     */
    public Orchard(int size)
    {
        list = new Tree[size];
        currentSize = 0;
    }
    /**
     * Adds tree if the index is vaild
     *
     * @param  tree  the tree
     * @param  index the index
     */
    public void add(Tree tree, int index)
    {
        if (index >= 0 && index <= currentSize && index < list.length && currentSize < list.length)
        {
            for (int i = currentSize; i > index; i --)
            {
                list[i] = list[i - 1];
            }
            list[index] = tree;
            currentSize ++;
        }
    }
    /**
     * Finds the last tall tree. Returns null if list is empty or cannot find tree.
     *
     * @return  the last tall tree.
     */
    public Tree lastTallTree()
    {
        for (int i = currentSize - 1; i >= 0; i --)
        {
            if (list[i].getHeight() >= TALL_TREE)
            return list[i];
        }
        return null;
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
        for (int i = 0; i < currentSize; i ++)
        {
            if (list[i].getType().equals(theType))
            return true;
        }
        return false;
    }
    
    /**
     * Sorts trees using the comparable interface.
     * 
     */
    public void sort()
    {
        Arrays.sort(list, 0, currentSize);
    }
    
    /**
     * Turns array into string and returns it.
     *
     * @return  the list
     */
    public String treeList()
    {
        String str = "[";
        for (int i = 0; i < currentSize; i ++)
        {
            str += list[i].getType() + ", ";
        }
        str += "]";
        return str.replace(", ]", "]");
    }

}
