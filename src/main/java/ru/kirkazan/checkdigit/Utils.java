package ru.kirkazan.checkdigit;

/**
 * @author esadykov
 * @since 19.10.13 19:40
 */
public final class Utils {


    /**
     * Offset for set of digits in character code table
     */
    public static final byte DIGITS_OFFSET = 48;

    /**
     * Remove char used for formatting: spaces and minuses
     * @param dirtyNumber number with formatting chars
     * @return number without formatting chars
     */
    public static String removeSalt(String dirtyNumber)
    {
        if (dirtyNumber == null)
            return null;

        StringBuilder sb = new StringBuilder();

        for (char c : dirtyNumber.toCharArray())
        {
            if (c >= '0' && c <= '9')
                sb.append(c);
            else if (c != ' ' && c != '-')
                return null;
        }
        return sb.toString();
    }

    /**
     * https://www.azcode.com/Mod10/
     * Luhn algorithm
     *
     * @param number String with only numeric characters
     * @param addLeadingZero if true when check sums calculates with leading zero
     * @return control sum
     */
    public static int luhn(String number, boolean addLeadingZero)
    {
        int sum = 0;
        int leadingZero = (addLeadingZero && number.length() % 2 != 0) ? 1 : 0;
        for (int i = number.length(); i > 0; i--)
        {
            int m = (i + leadingZero) % 2 + 1;
            int s = (number.charAt(i - 1) - DIGITS_OFFSET) * m;
            if (s >= 10)
                s = s - 10 + 1;
            sum = sum + s;
        }
        return sum;
    }

    /**
     * https://www.azcode.com/Mod10/
     * Luhn algorithm
     *
     * @param number String with only numeric characters
     * @return control sum
     */
    public static int luhn(String number)
    {
        return luhn(number, true);
    }

}
