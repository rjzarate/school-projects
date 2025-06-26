
/**
 * The censored words
 *
 * @author Froilan Zarate & Alan Xiao
 * @version 07-10-2022
 */
public class Censorship
{
    private String bannedWordOne, bannedWordTwo, bannedWordThree;
    /**
     * The constructor for censorship
     * 
     * @param firstWord  the first censored word
     * @param secondWord  the second censored word
     * @param third  the third censored word
     */
    public Censorship(String firstWord, String secondWord, String thirdWord)
    {
           bannedWordOne = firstWord;
           bannedWordTwo = secondWord;
           bannedWordThree = thirdWord;
    }
    /**
     * Checks if the string contains a bad word
     * 
     * @param str  the string
     * @return a true or false if there is a bad word
     */
    private boolean containsBadWord(String str)
    {
        return (str.toLowerCase().contains(bannedWordOne.toLowerCase()) || str.toLowerCase().contains(bannedWordTwo.toLowerCase()) || str.toLowerCase().contains(bannedWordThree.toLowerCase()));
    }
    /**
     * Checks if the string is a bad word
     * 
     * @param str  the string
     * @return a true or false if the string is a bad word
     */
    public boolean isBadWord(String str)
    {
        return (str.toLowerCase().equals(bannedWordOne.toLowerCase()) || str.toLowerCase().equals(bannedWordTwo.toLowerCase()) || str.toLowerCase().equals(bannedWordThree.toLowerCase()));
    }
    /**
     * Replaces the string with censored bad words
     * 
     * @param str  the string
     * @return the censored string
     */
    public String censorBadWords(String str)
    {
        str = str.replaceAll("(?i)" + bannedWordOne, "****");
        str = str.replaceAll("(?i)" + bannedWordTwo, "****");
        str = str.replaceAll("(?i)" + bannedWordThree, "****");
        return str;
    }
}
