package ru.kirkazan.checkdigit.ru;

import ru.kirkazan.checkdigit.NumberValidator;
import ru.kirkazan.checkdigit.Utils;

import static ru.kirkazan.checkdigit.Utils.DIGITS_OFFSET;

/**
 * ИНН физического лица
 *
 * @author esadykov
 * @since 19.10.13 20:09
 */
public class IndividualTaxIdentificationNumber implements NumberValidator {

    private static final byte LENGTH = 12;

    /**
     * http://ru.wikipedia.org/wiki/%D0%98%D0%9D%D0%9D
     * Check inn for individuals;
     *
     * @param number String to validate, spaces and minuses allowed
     * @return true if control sum checked
     */
    @Override
    public boolean validate(String number)
    {
        String clearNumber = Utils.removeSalt(number);

        if (clearNumber == null)
            return false;

        if (clearNumber.length() != LENGTH)
            return false;

        int n11 = 0;
        int n12 = 0;

        char[] chars = clearNumber.toCharArray();
        for (byte i = 0; i < LENGTH-2; i++)
        {
            int c = chars[i] - DIGITS_OFFSET;
            n11 += factors[i + 1] * c;
            n12 += factors[i] * c;
        }
        n11 = (n11 % 11) % 10;
        n12 += factors[10] * n11;
        n12 = (n12 % 11) % 10;

        return n11 == (chars[10] - DIGITS_OFFSET) && n12 == (chars[11] - DIGITS_OFFSET);
    }

    private static byte[] factors = {3,7,2,4,10,3,5,9,4,6,8};

}
