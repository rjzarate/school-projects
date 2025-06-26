
/**
 * Edit a book title
 *
 * @author Froilan Zarate
 * @version 10-13-2022
 */
public class BookTitle
{
    private String title;

    /**
     * Constructor for objects of class BookTitle
     * 
     * @param thisTitle the title of the book
     */
    public BookTitle(String thisTitle)
    {
        title = thisTitle;
    }
    /**
     * Returns a string consisting of the first character of every word in the title.
     *
     * @return    the first character of every word on the string
     */
    public String firstLetters()
    {
        String subTitle = title.trim() + " ";
        String firstLetters = "";
        
        while (subTitle.contains(" "))
        {
            firstLetters = firstLetters + subTitle.substring(0, 1);
            subTitle = subTitle.substring(subTitle.indexOf(' ') + 1);
        }
        return firstLetters;
    }
    /**
     * Returns a string consisting of the last character of every word in the title.
     *
     * @return    the last character of every word on the string
     */
    public String lastLetters()
    {
        String subTitle = title.trim() + " ";
        String lastLetters = "";
        
        subTitle = subTitle.replaceAll(":", "");
        subTitle = subTitle.replaceAll("1", "");
        subTitle = subTitle.replaceAll("2", "");
        subTitle = subTitle.replaceAll(",", "");
        subTitle = subTitle.replaceAll("!", "");
        
        while (subTitle.contains(" "))
        {
            lastLetters = lastLetters + subTitle.substring(subTitle.indexOf(' ') - 1, subTitle.indexOf(' '));
            subTitle = subTitle.substring(subTitle.indexOf(' ') + 1);
        }
        return lastLetters;
    }
}
