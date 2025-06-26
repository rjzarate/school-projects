/**
 * A Java tester program for class BookTitle.
 *
 * @author  Qi Yang
 * @version 2022-09-23
 */
public class BookTitleTester
{
    public static void main(String[] args)
    {
        BookTitle bookTitle1 = new BookTitle("Big Java: Early Objects  ");
        BookTitle bookTitle2 = new BookTitle(" Part1 and Part2");
        BookTitle bookTitle3 = new BookTitle(" Absalom, Absalom! ");
            
        System.out.println("First letters: " + bookTitle1.firstLetters()); 
        System.out.println("Expected: BJEO");
        System.out.println("First letters: " + bookTitle2.firstLetters()); 
        System.out.println("Expected: PaP");
        System.out.println("First letters: " + bookTitle3.firstLetters()); 
        System.out.println("Expected: AA");
        
        System.out.println("Last letters: " + bookTitle1.lastLetters()); 
        System.out.println("Expected: gays");
        System.out.println("Last letters: " + bookTitle2.lastLetters()); 
        System.out.println("Expected: tdt");
        System.out.println("Last letters: " + bookTitle3.lastLetters()); 
        System.out.println("Expected: mm");
    }
}