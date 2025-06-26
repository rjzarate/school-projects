/**
 * Write a description of class CensorTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
//HIDE
public class CensorshipTester
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class CensorTester
     */
    public CensorshipTester()
    {
        // initialise instance variables
        x = 0;
    }

    public static void main(String args[]){
        Censorship firstCensor = new Censorship("apple", "pear", "melon");
        
        // System.out.println("addBadWord: apple");
        // System.out.println(firstCensor.addBadWord("apple"));
        // System.out.println("Expected: true");
        
        System.out.println("apple, pear, and melon");
        /*
        System.out.println("containsBadWord: The Apple doesn't fall far from the tree");
        System.out.println(firstCensor.containsBadWord("The Apple doesn't fall far from the tree"));
        System.out.println("Expected: true");

        System.out.println("containsBadWord: The fruit doesn't fall far from the pear");
        System.out.println(firstCensor.containsBadWord("The fruit doesn't fall far from the pear"));
        System.out.println("Expected: true");

        System.out.println("containsBadWord: mElOnS grow really fast!");
        System.out.println(firstCensor.containsBadWord("mElOnS grow really fast!"));
        System.out.println("Expected: true");
        
        System.out.println("containsBadWord: The fruit doesn't fall far from the tree");
        System.out.println(firstCensor.containsBadWord("The fruit doesn't fall far from the tree"));
        System.out.println("Expected: false");
        
        System.out.println("containsBadWord: The appl doesn't fall far from the tree");
        System.out.println(firstCensor.containsBadWord("The appl doesn't fall far from the tree"));
        System.out.println("Expected: false");
        
        System.out.println("containsBadWord: pEAR");
        System.out.println(firstCensor.containsBadWord("pEAR"));
        System.out.println("Expected: true");
        
        System.out.println("containsBadWord: appEARle");
        System.out.println(firstCensor.containsBadWord("appEARle"));
        System.out.println("Expected: true");
        
        System.out.println("containsBadWord: *blank*");
        System.out.println(firstCensor.containsBadWord(""));
        System.out.println("Expected: false"); */
        
        // Going to isBadWord
        System.out.println("isBadWord: The Apple doesn't fall far from the tree");
        System.out.println(firstCensor.isBadWord("The Apple doesn't fall far from the tree"));
        System.out.println("Expected: false");

        System.out.println("isBadWord: The fruit doesn't fall far from the pear");
        System.out.println(firstCensor.isBadWord("The fruit doesn't fall far from the pear"));
        System.out.println("Expected: false");

        System.out.println("isBadWord: mElOnS grow really fast!");
        System.out.println(firstCensor.isBadWord("mElOnS grow really fast!"));
        System.out.println("Expected: false");
        
        System.out.println("isBadWord: The fruit doesn't fall far from the tree");
        System.out.println(firstCensor.isBadWord("The fruit doesn't fall far from the tree"));
        System.out.println("Expected: false");
        
        System.out.println("isBadWord: The appl doesn't fall far from the tree");
        System.out.println(firstCensor.isBadWord("The appl doesn't fall far from the tree"));
        System.out.println("Expected: false");
        
        System.out.println("isBadWord: pEAR");
        System.out.println(firstCensor.isBadWord("pEAR"));
        System.out.println("Expected: true");
        
        System.out.println("isBadWord: appEARle");
        System.out.println(firstCensor.isBadWord("appEARle"));
        System.out.println("Expected: false");
        
        System.out.println("isBadWord: *blank*");
        System.out.println(firstCensor.isBadWord(""));
        System.out.println("Expected: false");
        
        System.out.println("isBadWord: applepearmelon");
        System.out.println(firstCensor.isBadWord("applepearmelon"));
        System.out.println("Expected: false");
        
        System.out.println("isBadWord: MELOn");
        System.out.println(firstCensor.isBadWord("MELOn"));
        System.out.println("Expected: true");
        
        // censorBadWord
        
        System.out.println("censorBadWord: The Apple doesn't fall far from the tree");
        System.out.println(firstCensor.censorBadWords("The Apple doesn't fall far from the tree"));
        System.out.println("Expected: The **** doesn't fall far from the tree");

        System.out.println("censorBadWord: The fruit doesn't fall far from the pear");
        System.out.println(firstCensor.censorBadWords("The fruit doesn't fall far from the pear"));
        System.out.println("Expected: The fruit doesn't fall far from the ****");

        System.out.println("censorBadWord: mElOnS grow really fast!");
        System.out.println(firstCensor.censorBadWords("mElOnS grow really fast!"));
        System.out.println("Expected: ****S grow really fast!");
        
        System.out.println("censorBadWord: The fruit doesn't fall far from the tree");
        System.out.println(firstCensor.censorBadWords("The fruit doesn't fall far from the tree"));
        System.out.println("Expected: The fruit doesn't fall far from the tree");
        
        System.out.println("censorBadWord: The appl doesn't fall far from the tree");
        System.out.println(firstCensor.censorBadWords("The appl doesn't fall far from the tree"));
        System.out.println("Expected: The appl doesn't fall far from the tree");
        
        System.out.println("censorBadWord: pEAR");
        System.out.println(firstCensor.censorBadWords("pEAR"));
        System.out.println("Expected: ****");
        
        System.out.println("censorBadWord: appEARle");
        System.out.println(firstCensor.censorBadWords("appEARle"));
        System.out.println("Expected: ap****le");
        
        System.out.println("censorBadWord: *blank*");
        System.out.println(firstCensor.censorBadWords(""));
        System.out.println("Expected: ");
        
        System.out.println("censorBadWord: applepearmelon");
        System.out.println(firstCensor.censorBadWords("applepearmelon"));
        System.out.println("Expected: ************");
        
        System.out.println("censorBadWord: MELOn");
        System.out.println(firstCensor.censorBadWords("MELOn"));
        System.out.println("Expected: ****");
        
        
        
    }
}