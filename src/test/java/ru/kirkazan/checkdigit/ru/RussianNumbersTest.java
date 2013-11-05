package ru.kirkazan.checkdigit.ru;

import java.math.BigInteger;
import java.text.MessageFormat;

/**
 * @author esadykov
 * @since 19.10.13 20:49
 */
public class RussianNumbersTest {
    //todo


    public void printManyValidSNILS()
    {
        int count = 20;

        int i = count;
        int j = 100;
        BigInteger code = BigInteger.ZERO;
        MessageFormat snilsFormat = new MessageFormat("{0,number,00000000000}");

        Object[] t = new Object[1];
        t[0] = code;
        //System.out.println(snilsFormat.format(t));

        while (j > 0)
        {
            while (i > 0)
            {
                t[0] = code;
                String codeStr = snilsFormat.format(t);

                if (RussiaIndividualNumbers.SNILS.validate(codeStr))
                {
                    i--;
                    System.out.println('|' + codeStr + '|');
                }
                code = code.add(BigInteger.ONE);

            }
            i=count;
            j--;
            code = BigInteger.ZERO;
            code = code.add(new BigInteger("1000000000").multiply(BigInteger.valueOf(100 - j)));
        }

    }

    public void printManyValidINN()
    {
        int count = 20;

        int i = count;
        int j = 100;
        BigInteger code = BigInteger.ZERO;
        MessageFormat innFormat = new MessageFormat("{0,number,000000000000}");

        Object[] t = new Object[1];
        t[0] = code;
        //System.out.println(innFormat.format(t));

        while (j > 0)
        {
            while (i > 0)
            {
                t[0] = code;
                String codeStr = innFormat.format(t);

                if (RussiaIndividualNumbers.INN.validate(codeStr))
                {
                    i--;
                    System.out.println('|' + codeStr + '|');
                }
                code = code.add(BigInteger.ONE);

            }
            i=count;
            j--;
            code = BigInteger.ZERO;
            code = code.add(new BigInteger("10000000000").multiply(BigInteger.valueOf(100 - j)));
        }

    }

    public void printManyValidMHI()
    {
        int count = 20;

        int i = count;
        int j = 100;
        BigInteger code = BigInteger.ZERO;
        MessageFormat mhiFormat = new MessageFormat("{0,number,0000000000000000}");

        Object[] t = new Object[1];
        t[0] = code;
        //System.out.println(mhiFormat.format(t));

        while (j > 0)
        {
            while (i > 0)
            {
                t[0] = code;
                String codeStr = mhiFormat.format(t);

                if (RussiaIndividualNumbers.ENP.validate(codeStr))
                {
                    i--;
                    System.out.println('|' + codeStr + '|');
                }
                code = code.add(BigInteger.ONE);

            }
            i=count;
            j--;
            code = BigInteger.ZERO;
            code = code.add(new BigInteger("100000000000000").multiply(BigInteger.valueOf(100 - j)));
        }

    }

}
