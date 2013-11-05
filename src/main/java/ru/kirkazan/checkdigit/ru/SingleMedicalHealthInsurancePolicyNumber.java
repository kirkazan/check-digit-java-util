package ru.kirkazan.checkdigit.ru;

import ru.kirkazan.checkdigit.NumberValidator;
import ru.kirkazan.checkdigit.Utils;

/**
 * Единый номер полиса ОМС
 *
 *
 * @author esadykov
 * @since 19.10.13 20:07
 */
public class SingleMedicalHealthInsurancePolicyNumber implements NumberValidator {

    private static final byte LENGTH = 16;

    /**
     * http://www.rostov-tfoms.ru/o-fonde/96-sistema-oms-na-donu/zasedaniya-rabochikh-grupp/zasedaniya-rabochej-gruppy-po-podgotovke-k-formirovaniyu-i-vedeniyu-erp/364-struktura-edinogo-nomera-polisa-enp-obyazatelnogo-meditsinskogo-strakhovaniya
     *
     * @param number String to validate, spaces and minuses allowed
     * @return true if control sum checked
     */
    @Override
    public boolean validate(String number) {
        String clearNumber = Utils.removeSalt(number);

        if (clearNumber == null)
            return false;

        if (clearNumber.length() != LENGTH)
            return false;

        int sum = Utils.luhn(clearNumber.substring(0, LENGTH - 1), false);

        int controlNumber = clearNumber.charAt(LENGTH - 1) - Utils.DIGITS_OFFSET;
        return ((10 - sum % 10) == controlNumber || sum % 10 == controlNumber);
    }

}
