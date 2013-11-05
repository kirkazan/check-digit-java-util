package ru.kirkazan.checkdigit.ru;

import ru.kirkazan.checkdigit.NumberValidator;

import static ru.kirkazan.checkdigit.Utils.DIGITS_OFFSET;
import static ru.kirkazan.checkdigit.Utils.removeSalt;

/**
 * СНИЛС
 *
 * @author esadykov
 * @since 19.10.13 20:42
 */
public class InsuranceNumberOfIndividualAccount implements NumberValidator {

    private static final byte LENGTH = 11;

    /**
     * http://www.rostov-tfoms.ru/services/rab-group/erp/pravila-rascheta-kontrolnoj-summy-snils
     *
     * @param number String with only numeric characters
     * @return true if control sum is valid
     */
    @Override
    public boolean validate(String number) {
        String clearNumber = removeSalt(number);

        if (clearNumber == null)
            return false;

        if (clearNumber.length() != LENGTH)
            return false;

        int checkSum = 0;
        char[] chars = clearNumber.toCharArray();
        for (int i = LENGTH-3; i >= 0; i--) {
            checkSum += (chars[i] - DIGITS_OFFSET) * (9 - i);
        }

        int checkDigits = (chars[9] - DIGITS_OFFSET) * 10 + (chars[10] - DIGITS_OFFSET);

        if (checkSum > 101)
            checkSum = checkSum % 101;

        return ((checkSum == checkDigits) || (checkDigits == 0 && (checkSum == 100 || checkSum == 101)));
    }
}
