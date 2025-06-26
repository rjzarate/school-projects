/**
 * Models stock objects managed by a financial company.
 * 
 * @author  Froilan Zarate
 * @version 12-01-2022
 */
public class Stock implements Comparable
{
    private String symbol;
    private double price;

    /**
     * Constructs a Stock object with the given symbol and price.
     * 
     * @param theSymbol this stock's symbol
     * @param thePrice this stock's price
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
    
    /**
     * Compares the stock value depending on price.
     * 
     * @param obj the other stock compared
     * 
     * @return a positive or negative integer depending on the price. If 0, returns a positive
     * or negative integer depending on the symbol.
     */
    public int compareTo(Object obj)
    {
        Stock anotherStock = (Stock) obj;
        int value = Double.compare(this.price, anotherStock.price);
        if (value == 0)
        {
            value = this.symbol.compareTo(anotherStock.symbol);
        }
        return value;
    }
}