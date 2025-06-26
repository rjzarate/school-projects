
/**
 * Scrambles a string.
 *
 * @author Froilan Zarate, Alan Xiao
 * @version 09-30-2022
 */
public class StringScrambler
{
    private String word;
    /**
     * The constructor of StringScrambler
     * 
     * @param thisWord  the word
     */
    public StringScrambler(String thisWord)
    {
        word = thisWord;
    }

    /**
     * Swaps the first letter and the last letter
     * 
     * @return  null if the word is 1 character, else return the edited string
     */
    public String scrambleFirstLast()
    {
        if (word.length() <= 1)
        {
            return null;
        }
        char firstLetter = word.charAt(0);
        char lastLetter = word.charAt(word.length() - 1);
        
        String subWord = word.substring(1, word.length() - 1);
        subWord = lastLetter + subWord + firstLetter;
        
        
        return subWord;
    }
    /**
     * Swaps the second and third character
     * 
     * @return  scrambled word
     */
    public String scrambleSecondThird()
    {
        if (word.length() <= 2)
        {
            return null;
        }
        char firstLetter = word.charAt(0);
        char secondLetter = word.charAt(1);
        char thirdLetter = word.charAt(2);
        
        
        
        String scramble2 = word.substring(3, word.length());
        scramble2 = firstLetter + "" + thirdLetter + "" + secondLetter + scramble2; 
        
        
        return scramble2;

    }
    /**
     * Swaps the two adjacent characters with the given index
     * 
     * @param index  the index
     * @return  scrambled word
     */
    public String scrambleAdjacentTwo(int index)
    {
        int x = index;
        if (word.length() <= x + 2 || x <= 0 || word.length() <= 1)
        {
            return null;
        }
        
        char firstLetter = word.charAt(x);
        char secondLetter = word.charAt(x + 1);
        
        
        
        String subWord1 = word.substring(0, x);
        String subWord2 = word.substring(x + 2, word.length());
         
        String subWord = subWord1 + secondLetter + "" + firstLetter + subWord2;
        
        return subWord;
    }
    /**
     * Swaps two characters with the given index
     * 
     * @param index  the index
     * @return  the scrambled word
     */
    public String scrambleNotAdjacentTwo(int index)
    {
        int x = index;
        if (word.length() <= x + 3 || x <= 0 || word.length() <= 1)
        {
            return null;
        }
        
        char firstLetter = word.charAt(x);
        char secondLetter = word.charAt(x + 2);
        
        
        
        String subWord1 = word.substring(0, x);
        String subWord2 = word.substring(x + 1, x + 2);
        String subWord3 = word.substring(x + 3, word.length());
         
        String subWord = subWord1 + secondLetter + "" + subWord2 + "" + firstLetter + subWord3;
        
        return subWord;
    }
}
