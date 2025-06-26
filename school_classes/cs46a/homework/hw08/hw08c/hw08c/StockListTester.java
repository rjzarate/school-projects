/**
 * Tests the StockList class.
 *
 * @author  Qi Yang
 * @version 2022-10-14
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

        //test cheapest
        System.out.println("Cheapest: " + market.cheapest());
        System.out.println("Expected: MSFT");
        
        market.add(new Stock("AAPL", 134.87)); //apple
        System.out.println(market);
        System.out.println("Expected: [Stock[symbol=FB,price=276.78], Stock[symbol=MSFT,price=224.15], " +
                                      "Stock[symbol=AMZN,price=3322.0], Stock[symbol=GOOGL,price=1757.76], " +
                                      "Stock[symbol=AAPL,price=134.87]]");
        
        System.out.println("Cheapest: " + market.cheapest());
        System.out.println("Expected: AAPL");

        //test swap
        market.swap(0, 3);
        market.swap(2, 4);
        System.out.println(market);
        System.out.println("Expected: [Stock[symbol=GOOGL,price=1757.76], Stock[symbol=MSFT,price=224.15], " +
                                      "Stock[symbol=AAPL,price=134.87], Stock[symbol=FB,price=276.78], " +
                                      "Stock[symbol=AMZN,price=3322.0]]");
        
        //swap bad index. Should have no effect
        market.swap(-1, 1);
        market.swap(2, -1);
        market.swap(1, 5);
        market.swap(5, 2);
        System.out.println(market);
        System.out.println("Expected: [Stock[symbol=GOOGL,price=1757.76], Stock[symbol=MSFT,price=224.15], " +
                                      "Stock[symbol=AAPL,price=134.87], Stock[symbol=FB,price=276.78], " +
                                      "Stock[symbol=AMZN,price=3322.0]]");
        
        //test with empty object
        market = new StockList();
        System.out.println(market);
        System.out.println("Expected: []");
        
        System.out.println("Cheapest: " + market.cheapest());
        System.out.println("Expected: null");      

        market.swap(1, 3);
        System.out.println(market);
        System.out.println("Expected: []");
    }
}