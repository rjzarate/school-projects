import java.util.ArrayList;
/**
 * The array list for stocks
 *
 * @author  Froilan Zarate
 * @version 10-29-2022
 */
public class StockList
{
    // instance variables - replace the example below with your own
    private ArrayList<Stock> list;

    /**
     * Constructor for objects of class StockList
     */
    public StockList()
    {
        list = new ArrayList<Stock>();
    }

    /**
     * Adds a stock to the end of the list.
     *
     * @param  s  the stock
     */
    public void add(Stock s)
    {
        list.add(s);
    }
    
    /**
     * Swaps the element at index1 with the element at index2. If either index is out of bounds, do not changing anything.
     *
     * @param  index1  first index
     * @param  index2  second index
     */
    public void swap(int index1, int index2)
    {
        if (list.size() == 0 || index1 >= list.size() || index2 >= list.size() || index1 < 0 || index2 < 0)
        {
            return;
        }
        Stock stockTemp = list.get(index1);
        
        list.set(index1, list.get(index2));
        list.set(index2, stockTemp);
    }
    
    /**
     * Gets the symbol for the Stock with the lowest price per share. If more than one Stock has the same price, return the symbol for the first. If the list is empty, return null.
     *
     * @return the cheapest stock or null if stock array list is empty
     */
    public String cheapest()
    {
        if (list.size() == 0)
        {
            return null;
        }
        Stock cheapestStock = new Stock("temp", Double.MAX_VALUE);
        for (Stock stock: list)
        {
            if (stock.getPrice() < cheapestStock.getPrice())
            {
                cheapestStock = stock;
            }
        }
        return cheapestStock.getSymbol();
    }
    /**
     * Gets a string representation for the list including all 
     * stocks in the list by returning the string from the 
     * toString() method of the list.
     * 
     * @return the list of stocks
     */
    @Override
    public String toString()
    {
        return list.toString();
    }
}
