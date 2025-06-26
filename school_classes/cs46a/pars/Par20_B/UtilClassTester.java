import java.util.ArrayList;
/**
 * A class to test static methods of class UtilClass.
 * 
 * Step 1: Enter your name for @author and today's date for @version
 * @author  Froilan Zarate
 * @version 11-10-2022
 */
public class UtilClassTester
{
   public static void main(String[] args)
   {
      // Create a circle of radius 10
      Circle myCircle = new Circle(10);
      
      // Call the instance method on the object 
      //      to get the area of myCircle
      double instanceArea = myCircle.area();
      
      // Display the area with 4 decimal digits
      System.out.printf("The area is: %.4f\n", instanceArea);
      System.out.println("Expected: 314.1593");

      // Step 2: Call the static method area() of class UtilClass
      //         to get the area of myCircle and assign it to a 
      //         double variable staticArea
      double staticArea = UtilClass.area(myCircle);

      // Display the area with 4 decimal digits
      System.out.printf("The area is: %.4f\n", staticArea);
      System.out.println("Expected: 314.1593");
      
      // Create an array list of Integer called integerList
      ArrayList<Integer> integerList = new ArrayList<Integer>();
      
      // Step 3: Call the static method max() of class UtilClass 
      //         to get the max value of integerList and
      //         assign it to an int variable staticMax
      int staticMax = UtilClass.max(integerList);
      
      // Display the max of integerList
      System.out.println("The max is: " + staticMax);
      System.out.println("Expected: -2147483648");
         
      // Add some values to integerList
      integerList.add(10);
      integerList.add(12);
      integerList.add(18);
      integerList.add(15);
      integerList.add(14);
      
      // Step 4: Call the static method max() of class UtilClass 
      //         to get the max value integerList assign it to 
      //         staticMax
      staticMax = UtilClass.max(integerList);
      
      // Display the max of integerList 
      System.out.println("The max is: " + staticMax);
      System.out.println("Expected: 18");
      

      // Create an array of String called stringArray of length 500
      //    and initialize its currentSize to 0
      String[] stringArray = new String[500];
      int currentSize = 0;

      // Step 5: Call the static method lastLongest() of class UtilClass
      //         and assign the result to a variable longestWord
      String longestWord = UtilClass.lastLongest(stringArray, currentSize);
      
      
      // Display the longest word of stringArray 
      System.out.println("The longest word is: " + longestWord);
      System.out.println("Expected: ");
      
      // Adds some strings to stringArray and incrementes
      //      currentSize by one after each string is added
      // Note: the statement 
      //            stringArray[currentSize ++] = "CS46A";
      //       is equivalent to the following two statements
      //            stringArray[currentSize] = "CS46A";
      //            currentSize ++;
      stringArray[currentSize ++] = "CS46A";
      stringArray[currentSize ++] = "Introduction";
      stringArray[currentSize ++] = "to";
      stringArray[currentSize ++] = "Programming";
      stringArray[currentSize ++] = "Big";
      stringArray[currentSize ++] = "Java";
      stringArray[currentSize ++] = "CayHortsmann";
      
      // Step 6: Call the static method lastLongest of class UtilClass
      //         and assign the result to longestWord
      longestWord = UtilClass.lastLongest(stringArray, currentSize);
      
      // Display the longest word of stringArray
      System.out.println("The longest word is: " + longestWord);
      System.out.println("Expected: CayHortsmann");
   }
}
