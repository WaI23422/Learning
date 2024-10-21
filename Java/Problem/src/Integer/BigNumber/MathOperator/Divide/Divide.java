package Integer.BigNumber.MathOperator.Divide;

import Integer.BigNumber.MathOperator.Minus.*;
import Integer.BigNumber.Compare;

public class Divide {
    /**
     * Divide two big numbers.
     * @param dividend the number that is being divided by another number.
     * @param divisor the number by which the dividend is being divided.
     * @param digit the number displayed after comma.
     * @return return the quotient (result of the division) of two numbers. 
     * 
     * @see Minus.java
     */
    public static String BigNumber(String dividend, String divisor){
        dividend = dividend.replaceAll("^0+", "");
        divisor = divisor.replaceAll("^0+", "");

        if (dividend == "") {dividend = "0";}
        if (divisor == "") {divisor = "0";}
        
        int len1 = dividend.length(),len2 = divisor.length(), CompVal = Compare.TwoBigNumber(dividend, divisor);

        // Check if it is divisible:
        if (len2 == 1 && divisor.charAt(0) == '0') { throw new Error("Error: Can't divive by 0");} 
        // 0 is the dividend:
        if (len1 == 1 && dividend.charAt(0) == '0') { return "0"; }
        // 1 is the divisor:
        if (len2 == 1 && divisor.charAt(0) == '1') { return dividend; }
        // Check if the dividend is less than the divisor.:
        if (CompVal == -1) {
            return "0";
        } else if (CompVal == 0) {
            return "1";
        }
        
        int start = 0, end = len2;
        int timesMinus;
        String res = "", remainder = "";
        String subdividend;
        Object[] numbHold;

        if (len1 >= len2) {
            while (end <= len1) {
                subdividend = remainder + dividend.substring(start, end);

                numbHold = Minus.timesRepeat(subdividend, divisor, 0);

                remainder = (String) numbHold[1];
                timesMinus = (int) numbHold[0];

                res += timesMinus;

                if (remainder == "") {
                    start = end;
                    end += len2;
                } else {
                    start = end;
                    end += len2 + 1 -remainder.length();
                }
            }

            if (start < len1) {
                res += 0 ;
            }
        }

        return res.replaceAll("^0+", "");
    }
    
    // Check
    public static void main(String[] args) {
        String dividens = "1234567892111256978123156489156126156415648951212315489";
        String divisors = "123457984515213126345648911354156478974565164574898455";

        System.out.println(BigNumber(dividens, divisors));
    }
}


