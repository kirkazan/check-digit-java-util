package ru.kirkazan.checkdigit.ru;

import ru.kirkazan.checkdigit.NumberValidator;

import java.math.BigInteger;

public class PrimaryStateRegistrationNumber implements NumberValidator {


    @Override
    public boolean validate(String number) {

        if (number == null)
            return false;

       BigInteger tempLong = new BigInteger(number);
       BigInteger lastSymbol = tempLong.mod(BigInteger.TEN);
       BigInteger step0 = tempLong.divide(BigInteger.TEN);
       BigInteger eleven = BigInteger.TEN.add(BigInteger.ONE);

        if(number.length() == 13){

            BigInteger step1 =  step0.divide(eleven);
            BigInteger step2 = step1.multiply(eleven);
            BigInteger step3 = step0.subtract(step2);

            if(!(lastSymbol.equals(step3)))
                return false;
        }
        return true;
    }

    public static void main(String[] args){

        String number = "1035006110083";

        PrimaryStateRegistrationNumber p = new PrimaryStateRegistrationNumber();

        System.out.print(p.validate(number));
    }
}
