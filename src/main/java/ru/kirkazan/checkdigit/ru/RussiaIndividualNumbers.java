package ru.kirkazan.checkdigit.ru;

import ru.kirkazan.checkdigit.NumberValidator;

/**
 * @author esadykov
 * @since 19.10.13 20:54
 */
public enum RussiaIndividualNumbers {

    INN(new IndividualTaxIdentificationNumber()),
    ENP(new SingleMedicalHealthInsurancePolicyNumber()),
    SNILS(new InsuranceNumberOfIndividualAccount());

    private NumberValidator validator;

    public boolean validate(String number)
    {
        return validator.validate(number);
    }

    RussiaIndividualNumbers(NumberValidator validator) {
        this.validator = validator;
    }
}
