/**
 * Tests the StockArray class.
 *
 * @author  Qi Yang
 * @version 2022-10-21
 */
public class StockArrayTester
{
    public static void main(String[] args)
    {
        StockArray market = new StockArray(6); 
        
        System.out.println(market);
        System.out.println("Expected: []");

        //test quote
        System.out.printf("Stock quote: %.2f%n", market.quote("FB"));
        System.out.println("Expected: -1.00");

        market.insert(new Stock("FB", 276.78), 0);   //facebook
        market.insert(new Stock("MSFT", 224.15), 0);   //microsoft
        market.insert(new Stock("AMZN", 3322.00), 2);  //amazon
        market.insert(new Stock("GOOGL", 1757.76), 2);  //google
        
        System.out.println(market);
        System.out.println("Expected: [Stock[symbol=MSFT,price=224.15], Stock[symbol=FB,price=276.78], " +
                                      "Stock[symbol=GOOGL,price=1757.76], Stock[symbol=AMZN,price=3322.0]]");

        //test quote
        System.out.printf("Stock quote: %.2f%n", market.quote("FB"));
        System.out.println("Expected: 276.78");
        
        System.out.printf("Stock quote: %.2f%n", market.quote("AMZN"));
        System.out.println("Expected: 3322.0");

        System.out.printf("Stock quote: %.2f%n", market.quote("AAPL"));
        System.out.println("Expected: -1.00");

        market.insert(new Stock("AAPL", 134.87), 1); //apple
        
        System.out.println(market);
        System.out.println("Expected: [Stock[symbol=MSFT,price=224.15], Stock[symbol=AAPL,price=134.87], " +
                                      "Stock[symbol=FB,price=276.78], Stock[symbol=GOOGL,price=1757.76], " +
                                      "Stock[symbol=AMZN,price=3322.0]]");

        System.out.printf("Stock quote: %.2f%n", market.quote("AAPL"));
        System.out.println("Expected: 134.87");

        //test swap
        market.swap(0, 3);
        market.swap(2, 4);
        System.out.println(market);
        System.out.println("Expected: [Stock[symbol=GOOGL,price=1757.76], Stock[symbol=AAPL,price=134.87], " +
                                      "Stock[symbol=AMZN,price=3322.0], Stock[symbol=MSFT,price=224.15], " +
                                      "Stock[symbol=FB,price=276.78]]");
        
        //swap bad index. Should have no effect
        market.swap(-1, 1);
        market.swap(2, -1);
        market.swap(1, 5);
        market.swap(5, 2);
        System.out.println(market);
        System.out.println("Expected: [Stock[symbol=GOOGL,price=1757.76], Stock[symbol=AAPL,price=134.87], " +
                                      "Stock[symbol=AMZN,price=3322.0], Stock[symbol=MSFT,price=224.15], " +
                                      "Stock[symbol=FB,price=276.78]]");
        
        market.insert(new Stock("TSLA", 694.78), 0); //Tesla
        market.insert(new Stock("EA", 142.05), 0);

        System.out.println(market);
        System.out.println("Expected: [Stock[symbol=TSLA,price=694.78], Stock[symbol=GOOGL,price=1757.76], " +
                                      "Stock[symbol=AAPL,price=134.87], Stock[symbol=AMZN,price=3322.0], " +
                                      "Stock[symbol=MSFT,price=224.15], Stock[symbol=FB,price=276.78]]");
    }
}