
/**
 * Manages Stock objects using an array
 *
 * @author  Froilan Zarate
 * @version 11-01-2022
 */
public class StockArray
{
    // instance variables - replace the example below with your own
    private Stock[] stockArray;
    private int numOfStocks;
    
    /**
     * Constructor for objects of class StockArray
     * 
     * @param size  the size of the array
     */
    public StockArray(int size)
    {
        stockArray = new Stock[size];
        numOfStocks = 0;
    }

    /**
     * Adds the stock at the specified index position and maintain the order of all elements in the array and updates numOfStocks if the array is not full and the index is valid. Otherwise, the method does nothing.
     *
     * @param  stock  the added stock
     * @param  index  the index of where the stock will be added
     */
    public void insert(Stock stock, int index)
    {
        if (index >= 0 && index <= numOfStocks && index < stockArray.length && numOfStocks != stockArray.length)
        {
            for (int i = numOfStocks - 1; i >= index; i --)
            {
                stockArray[i + 1] = stockArray[i];
            }
            stockArray[index] = stock;
            numOfStocks ++;
        }
    }
    
    /**
     * Swaps the stock at index1 with the stock at index2. If either index is out of bounds, does not change anything.
     *
     * @param  index1  position of stock
     * @param  index2  position of stock
     */
    public void swap(int index1, int index2)
    {
        Stock tempStock;
        if (index1 != index2 && index1 >= 0 && index2 >= 0 && index1 < numOfStocks && index2 < numOfStocks)
        {
            tempStock = stockArray[index1];
            stockArray[index1] = stockArray[index2];
            stockArray[index2] = tempStock;
        }
    }
    
    /**
     * Gets the price for the stock in the array specified by the parameter symbol. If the stock is not in the array, returns -1.
     *
     * @param  symbol  the symbol of the stock
     * @return  the price, or -1 if it could not find the symbol
     */
    public double quote(String symbol)
    {
        //i will be index
        for (int i = 0; i < numOfStocks; i ++)
        {
            if (symbol.equals(stockArray[i].getSymbol()))
            {
                return stockArray[i].getPrice();
            }
        }
        return -1;
    }
    
    /**
     * Returns a string containing all stocks in the array in the format [Stock[…], Stock[…], . . . Stock[…]], where each item Stock[…] is the string from the toString() method of class Stock for a stock in the array.
     * 
     * @return  the array list
     */
    public String toString() 
    {
        String string = "[";
        if (numOfStocks >= 1)
        {
            string = string + stockArray[0];
        }
        //i will be index
        for (int i = 1; i < numOfStocks; i ++)
        {
            string = string + ", " + stockArray[i].toString();
            
        }
        return string + "]";
    }
}
