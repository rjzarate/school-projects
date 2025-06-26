/**
 * A utility class to provide some static methods to generate 
 * the USPS bar encodings for 5-digit zip codes.
 *
 * Step 1: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version MyLastExam
 */
public class EncodingUtil
{
    public static final int[][] DIGIT_CODE_TABLE = { {1, 1, 0, 0, 0},
                                                     {0, 0, 0, 1, 1},
                                                     {0, 0, 1, 0, 1},
                                                     {0, 0, 1, 1, 0},
                                                     {0, 1, 0, 0, 1},
                                                     {0, 1, 0, 1, 0},
                                                     {0, 1, 1, 0, 0},
                                                     {1, 0, 0, 0, 1},
                                                     {1, 0, 0, 1, 0},
                                                     {1, 0, 1, 0, 0} };

    public static final int DECIMAL_BASE = 10;
        
    // Step 2: Write static method digitEncoding() according 
    //         to the comment
    //         Javadoc is required
    /**
     * The method has one int parameter in range [0, 9] and 
     * returns the bar encoding for the digit. 
     * You can assume the parameter is a one digit integer
     * and don't need to check if it is out of the range.
     * 
     * The bar encodings for all digits are specified in the 
     * 2-D array DIGIT_CODE_TABLE. The encoding for a digit
     * is the row whose row index is the digit. For example, 
     * the encoding for digit '5' is the row at index 5 of 
     * DIGIT_CODE_TABLE.
     * All elements of DIGIT_CODE_TABLE are 1s or 0s, 
     * representing a full bar "|" or a half bar ":". 
     * Example:
     *  digit   DIGIT_CODE_TABLE[digit]     Bar Encoding
     *    5        {0, 1, 0, 1, 0}             ":|:|:"
     *    9        {1, 0, 1, 0, 0}             "|:|::"
     *    
     * You should use the enhanced for loop.
     * 
     * @param index  the row index
     * @return the bars as a string with the given row index for
     */
    public static String digitEncoding(int index)
    {
        String str = "";
        for (int binary: DIGIT_CODE_TABLE[index])
        {
            if (binary == 0)
                str += ":";
            else
                str += "|";
        }
        return str;
    }


    // Step 3: Write static method zipEncoding() according to 
    //         the comment
    //         Javadoc is required
    /**
     * The method has one String parameter representing a 
     * 5-digit zip code and returns its bar encoding, which
     * is the concatenation of the bar encodings of the
     * five digits of the zip code.
     * 
     * The method should call method digitEncoding() to get 
     * the encoding for each digit of the zip code. 
     * You may need to convert a digit character ch to an int  
     * value, and one way to do it is 
     *     ch – ‘0’
     * since all digits are listed in the ASCII (and the Unicode) 
     * table together starting with '0'.
     * 
     * Do not use method split().
     * You can sssume the parameter is valid.
     *
     * @param zipCode the zip code
     * @return the bars as a string for the zip code
     */
    public static String zipEncoding(String zipCode)
    {
        String str = "";
        for (int i = 0; i < zipCode.length(); i ++)
        {
            str += digitEncoding(zipCode.charAt(i) - '0');
        }
        return str;
        
    }

    
    // Step 4: Write static method checksumDigitEncoding() according 
    //         to the comment
    //         Javadoc is required
    /**
     * The method has one String parameter representing a 
     * 5-digit zip code and returns the bar encoding for
     * its checksum digit.
     * 
     * The checksum digit for a zip code is generated as follows:
     *     Get the sum of the five digits as the checksum 
     *     The checksum digit is the smallest non-negative integer
     *         that, after being added to the checksum, makes the 
     *         checksum a multiple of 10 (DECIMAL_BASE).
     * Notice that if the checksum is a multiple of 10 already,
     * then the checksum digit will be a zero.
     * Examples:
     *    zipcode   checksum    checksum digit 
     *    "95014"       19              1
     *    "95015"       20              0
     *
     * You may need to convert a digit character ch to an int value:
     *     ch – ‘0’
     *     
     * The method should call method digitEncoding() to get the
     * encoding for the checksum digit of the zip code. 
     * You can sssume the parameter is valid.
     * 
     * @param zipCode the zip code
     * @return the bars as a string for checksum digit encoding
     */
    public static String checksumDigitEncoding(String zipCode)
    {
        String str = "";
        int checksum = 0;
        for (int i = 0; i < zipCode.length(); i ++)
        {
            checksum += (zipCode.charAt(i)) - '0';
        }
        int checksumDigit = (checksum % DECIMAL_BASE) - 10;
        if (checksumDigit == -10)
        {
            checksumDigit = 0;
        } else if (checksumDigit < 0)
            checksumDigit *= -1;
        
        return digitEncoding(checksumDigit);
    }

    
    // Step 5: Write static method getEncoding() according to 
    //         the comment
    //         Javadoc is required
    /**
     * The method has one String parameter representing a 
     * 5-digit zip code and returns the complete bar encoding 
     * for the zip code, which is the concatenation of a full 
     * bar ("|"), the encoding of the five digits of the zip 
     * code, the encoding of the checksum digit, and a full 
     * bar ("|").
     * 
     * @param zipCode the zip code
     * @return the bars as a string for the zip encoding and check sum digit encoding
     */
    public static String getEncoding(String zipCode)
    {
        return "|" + zipEncoding(zipCode) + checksumDigitEncoding(zipCode) + "|";
    }

}
