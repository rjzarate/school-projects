import java.util.ArrayList;
/**
 * Tester for the Orchard class.
 *
 * @author  Qi Yang
 * @version 2022-11-04
 */
public class OrchardTester
{
    public static void main(String[] args)
    {
        Orchard trees = new Orchard();
        System.out.println(trees.treeList());
        System.out.println("Expected: []" ); 
        System.out.println(trees.tallest());
        System.out.println("Expected: null");
        
        trees.add(new Tree("lemon",12.5 ), 0);
        trees.add(new Tree("apple", 20.0), 0);
        trees.add(new Tree("cherry", 13.5), 2);
        trees.add(new Tree("peach",10.5), 1);
        trees.add(new Tree("apricot", 20.0), 4);
        
        System.out.println(trees.treeList());
        System.out.println("Expected: [apple, peach, lemon, cherry, apricot]" ); 
        
        System.out.println(trees.tallest());
        System.out.println("Expected: Tree[Type:apple,Height:20.0]");
        
        System.out.println(trees.contains("cherry"));
        System.out.println("Expected: true");
        System.out.println(trees.contains("avocado"));
        System.out.println("Expected: false");
        
        trees.add(new Tree("avocado", 35.0), 1);
        
        System.out.println(trees.treeList());
        System.out.println("Expected: [apple, avocado, peach, lemon, cherry, apricot]" ); 

        System.out.println(trees.contains("avocado"));
        System.out.println("Expected: true");

        System.out.println(trees.tallest());
        System.out.println("Expected: Tree[Type:avocado,Height:35.0]");
        
        trees.add(new Tree("walnut", 25.0), -1);
        trees.add(new Tree("walnut", 25.0), 10);
        
        System.out.println(trees.treeList());
        System.out.println("Expected: [apple, avocado, peach, lemon, cherry, apricot]" ); 
    }
}