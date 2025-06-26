import java.util.Arrays;
/**
 * Tester for the Orchard class.
 *
 * @author  Qi Yang
 * @version 2022-11-15
 */
public class OrchardTester
{
    public static void main(String[] args)
    {
        Orchard trees = new Orchard(7);
        
        trees.add(new Tree("lemon",12 ), 0);
        trees.add(new Tree("apricot", 20), 0);
        trees.add(new Tree("cherry", 13), 2);
        trees.add(new Tree("peach",10), 1);
        trees.add(new Tree("apple", 20), 4);
        
        System.out.println(trees.treeList());
        System.out.println("Expected: [apricot, peach, lemon, cherry, apple]" ); 
        System.out.println(trees.contains("cherry"));
        System.out.println("Expected: true");
        System.out.println(trees.contains("walnut"));
        System.out.println("Expected: false");
        System.out.println(trees.lastTallTree());
        System.out.println("Expected: null");
        
        trees.sort();
        System.out.println(trees.treeList());
        System.out.println("Expected: [peach, lemon, cherry, apple, apricot]" ); 
        
        trees.add(new Tree("walnut", 35), 1);
        System.out.println(trees.treeList());
        System.out.println("Expected: [peach, walnut, lemon, cherry, apple, apricot]" ); 
        System.out.println(trees.contains("walnut"));
        System.out.println("Expected: true");
        System.out.println(trees.lastTallTree());
        System.out.println("Expected: Tree[Type:walnut,Height:35]");

        trees.add(new Tree("avocado", 35), -1);
        trees.add(new Tree("avocado", 35), 7);
        System.out.println(trees.treeList());
        System.out.println("Expected: [peach, walnut, lemon, cherry, apple, apricot]" ); 
        
        trees.add(new Tree("avocado", 35), 6);
        System.out.println(trees.treeList());
        System.out.println("Expected: [peach, walnut, lemon, cherry, apple, apricot, avocado]" ); 
        System.out.println(trees.lastTallTree());
        System.out.println("Expected: Tree[Type:avocado,Height:35]");
        
        trees.sort();
        System.out.println(trees.treeList());
        System.out.println("Expected: [peach, lemon, cherry, apple, apricot, avocado, walnut]" ); 
        System.out.println(trees.lastTallTree());
        System.out.println("Expected: Tree[Type:walnut,Height:35]");

        trees.add(new Tree("olive", 25), 0);
        System.out.println(trees.treeList());
        System.out.println("Expected: [peach, lemon, cherry, apple, apricot, avocado, walnut]" ); 
    }
}