/**
 * A Java application program for class ZipCodeEncoding.
 * 
 * Step 1: Enter your name for @author and the password for @version
 * @author  Qi Yang
 * @version 2022-12-12
 */
public class EncodingUtilTester
{
    public static void main(String[] args)
    {
        // Testing method digitEncoding()
        System.out.println(EncodingUtil.digitEncoding(0));
        System.out.println("Expected: ||:::");
        System.out.println(EncodingUtil.digitEncoding(3));
        System.out.println("Expected: ::||:");
        System.out.println(EncodingUtil.digitEncoding(6));
        System.out.println("Expected: :||::");
        System.out.println(EncodingUtil.digitEncoding(8));
        System.out.println("Expected: |::|:");
        
        // Testing method zipEncoding()
        System.out.println(EncodingUtil.zipEncoding("95014"));
        System.out.println("Expected: |:|:::|:|:||::::::||:|::|");
        System.out.println(EncodingUtil.zipEncoding("94539"));
        System.out.println("Expected: |:|:::|::|:|:|:::||:|:|::");
        System.out.println(EncodingUtil.zipEncoding("53818"));
        System.out.println("Expected: :|:|:::||:|::|::::|||::|:");
        System.out.println(EncodingUtil.zipEncoding("02138"));
        System.out.println("Expected: ||:::::|:|:::||::||:|::|:");
        
        // Testing method checksumDigitEncoding()
        System.out.println(EncodingUtil.checksumDigitEncoding("95014"));
        System.out.println("Expected: :::||");
        System.out.println(EncodingUtil.checksumDigitEncoding("94539"));
        System.out.println("Expected: ||:::");
        System.out.println(EncodingUtil.checksumDigitEncoding("53818"));
        System.out.println("Expected: :|:|:");
        System.out.println(EncodingUtil.checksumDigitEncoding("02138"));
        System.out.println("Expected: :||::");

        // Testing method getEncoding()
        System.out.println(EncodingUtil.getEncoding("95014"));
        System.out.println("Expected: ||:|:::|:|:||::::::||:|::|:::|||");
        System.out.println(EncodingUtil.getEncoding("94539"));
        System.out.println("Expected: ||:|:::|::|:|:|:::||:|:|::||:::|");
        System.out.println(EncodingUtil.getEncoding("53818"));
        System.out.println("Expected: |:|:|:::||:|::|::::|||::|::|:|:|");
        System.out.println(EncodingUtil.getEncoding("02138"));
        System.out.println("Expected: |||:::::|:|:::||::||:|::|::||::|");
    }
}
