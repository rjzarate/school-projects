/**
 * Models stock objects managed by a financial company.
 * 
 * @author  Qi Yang
 * @version 2022-10-21
 */
public class Stock
{
    private String symbol;
    private double price;

    /**
     * Constructs a Stock object with the given symbol and price.
     * 
     * @param theSymbol this stock's symbol
     * @param the Price this stock's price
     */
    public Stock(String theSymbol, double thePrice)
    {
        symbol = theSymbol;
        price = thePrice;
    }

    /**
     * Gets the price of this stock.
     * 
     * @return the current price
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Gets the symbol for this stock.
     * 
     * @return the symbol
     */
    public String getSymbol()
    {
        return symbol;
    }

    /**
     * Returns a string representing this stock.
     * 
     * @return a string in the format
     *         Stock[symbol=AAPL,price=134.87]
     */
    @Override
    public String toString()
    {
        String s = getClass().getName() + "[symbol=" + symbol
          + ",price=" + price + "]";
        return s;
    }
}