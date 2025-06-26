/**
 * The class models different products with a name and a price.
 *
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 09-08-2022
 */
public class Product
{
    // Step 2: Declare instance variables
    private String name;
    private double price;


    // Step 3: Complete the constructor according to the description
    /**
     * Creates a product object by initializing the name and price.
     *
     * @param nameParam the name of the product 
     * @param priceParam the price of the product 
     */
    public Product(String nameParam, double priceParam)
    {
        name = nameParam;
        price = priceParam;

    }
    
    // Step 4: Complete method getName() according to the description
    /**
     * Gets the name of the product.
     *
     * @return the name of the product 
     */
    public String getName()
    {
        return name;
    }

    // Step 5: Complete method getPrice() according to the description
    /**
     * Gets the price of the product.
     *
     * @return the price of the product 
     */
    public double getPrice()
    {
        return price;
    }

    // Step 6: Complete method setPrice() according to the description
    /**
     * Sets a new price for this product.
     *
     * @param newPrice the new price for this product 
     */
    public void setPrice(double newPrice)
    {
        price = newPrice;
    }
}