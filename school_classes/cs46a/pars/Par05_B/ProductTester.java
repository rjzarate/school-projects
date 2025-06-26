/**
 * The class is a tester program for class Product.
 *
 * @author  Qi Yang
 * @version 2022-02-15
 */
public class ProductTester
{
    public static void main(String[] args)
    {
        Product product1 = new Product("iPad", 450.0); 
        Product product2 = new Product("iPhone", 949.99); 
        
        // Testing method getName()
        System.out.println(product1.getName()); 
        System.out.println("Expected: iPad");   
        System.out.println(product2.getName()); 
        System.out.println("Expected: iPhone");   
        
        // Testing method getPrice()
        System.out.println(product1.getPrice());
        System.out.println("Expected: 450.0");   
        System.out.println(product2.getPrice());
        System.out.println("Expected: 949.99");   
        
        // Testing method setPrice()
        product1.setPrice(405.0);      
        System.out.println(product1.getPrice());
        System.out.println("Expected: 405.0");   
        product2.setPrice(899.99);      
        System.out.println(product2.getPrice());
        System.out.println("Expected: 899.99");   
    }
}
