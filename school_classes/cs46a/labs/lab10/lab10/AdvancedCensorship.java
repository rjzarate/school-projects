import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class AdvancedCensorship here.
 *
 * @author  Froilan Zarate
 * @version 10-28-2022
 */
public class AdvancedCensorship
{
    // instance variables - replace the example below with your own
    private List<String> badWords = new ArrayList<String>();
    
    /**
     * Constructor for objects of class AdvancedCensorship
     */
    public AdvancedCensorship()
    {
        // initialise instance variables
        badWords = new ArrayList<String>();
    }
    
    public boolean addBadWord(String str)
    {
        badWords.add(str.toLowerCase());
        return true;
    }
    
    public boolean addBadWords(List<String> manyBadWords)
    {
        for (String bW: manyBadWords)
        {
            badWords.add(bW.toLowerCase());
        }
        return true;
    }
    
    public boolean containsBadWord(String str)
    {
        for(String badWord: badWords)
        {
            if(str.toLowerCase().contains(badWord))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     */
    public boolean isBadWord(String str)
    {
        for(String badWord: badWords)
        {
            if(str.toLowerCase().equals(badWord))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     */
    public void listBadWords()
    {
        for(String aWord: badWords)
        {
            System.out.println(aWord);
        }
    }
    
    /**
     * 
     */
    public String censorBadWord(String str)
    {
        for(String badWord: badWords)
        {
            str = str.replaceAll("(?i)" + badWord, "****");
        }
        return str;
    }
    
    /**
     * 
     */
    public boolean removeBadWord(String str)
    {
        for(String badWord: badWords)
        {
            if(badWord.equals(str))
            {
                badWords.remove(str.toLowerCase());
                System.out.println("Removed " + str);
                return true;
            }
            else
            {
                System.out.println("No " + str + " in list");
            }
        }
        return false;
    }
    
    /**
     * 
     */
    public boolean removeBadWords(List<String> manyBadWords)
    {
        for(String badWord: badWords)
        {
            for (String bW: manyBadWords)
            {
                if(badWord.equals(bW))
                {
                    badWords.remove(bW.toLowerCase());
                    System.out.println("Removed " + bW);
                    return true;
                }
                else
                {
                    System.out.println("No " + bW + " in list");
                }
            }
            return true;
        }
        return false;
    }
    
    /**
     * 
     */
    public boolean onlyBadWords(String str)
    {
        String substring = "";
        int badWordsInTheString = 0;
        
        for (String badWord: badWords)
        {
            if (str.contains(badWord))
            {
                badWordsInTheString ++;
            }
        }
        if (badWordsInTheString == 0)
        {
            System.out.print("No bad words in String" + str);
            return false;
        }
        
        for(String badWord: badWords)
        {
            while (str.contains(badWord))
            {
                substring = substring + badWord + " ";
                str.replaceFirst(badWord, "");
            }
        }
        System.out.print(substring);
        return true;
        
    }
    
    /**
     * 
     */
    public boolean badWordsFirst(String str)
    {
        String substring = "";
        int badWordsInTheString = 0;
        
        for (String badWord: badWords)
        {
            if (str.contains(badWord))
            {
                badWordsInTheString ++;
            }
        }
        if (badWordsInTheString == 0)
        {
            System.out.print("No bad words in String" + str);
            return false;
        }
        
        for(String badWord: badWords)
        {
            while (str.contains(badWord))
            {
                substring = substring + badWord + " ";
                str.replaceFirst(badWord, "");
            }
        }
        System.out.println(substring);
        System.out.print(str);
        return true;
        
    }
}


