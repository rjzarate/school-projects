/**
 * Tests the StockList class.
 *
 * @author  Qi Yang
 * @version 2022-11-15
 */
public class StockListTester
{
    public static void main(String[] args)
    {
        StockList market = new StockList(); 
        
        market.add(new Stock("FB", 276.78));   //facebook
        market.add(new Stock("MSFT", 224.15));   //microsoft
        market.add(new Stock("AMZN", 3322.00));  //amazon
        market.add(new Stock("GOOGL", 1757.76));  //google
        
        System.out.println(market);
        System.out.println("Expected: [Stock[symbol=FB,price=276.78], Stock[symbol=MSFT,price=224.15], " +
                                      "Stock[symbol=AMZN,price=3322.0], Stock[symbol=GOOGL,price=1757.76]]");
                                      
        market.sort();
        System.out.println(market);
        System.out.println("Expected: [Stock[symbol=MSFT,price=224.15], Stock[symbol=FB,price=276.78], " +
                                      "Stock[symbol=GOOGL,price=1757.76], Stock[symbol=AMZN,price=3322.0]]");
        
        market.add(new Stock("ACB", 145.76)); 
        market.add(new Stock("ABC", 145.76));  
        
        System.out.println(market);
        System.out.println("Expected: [Stock[symbol=MSFT,price=224.15], Stock[symbol=FB,price=276.78], " +
                                      "Stock[symbol=GOOGL,price=1757.76], Stock[symbol=AMZN,price=3322.0], " +
                                      "Stock[symbol=ACB,price=145.76], Stock[symbol=ABC,price=145.76]]");
                                      
        market.sort();
        System.out.println(market);
        System.out.println("Expected: [Stock[symbol=ABC,price=145.76], Stock[symbol=ACB,price=145.76], " +
                                      "Stock[symbol=MSFT,price=224.15], Stock[symbol=FB,price=276.78], " +
                                      "Stock[symbol=GOOGL,price=1757.76], Stock[symbol=AMZN,price=3322.0]]");
    }
}