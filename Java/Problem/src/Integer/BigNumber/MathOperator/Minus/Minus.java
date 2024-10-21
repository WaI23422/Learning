package Integer.BigNumber.MathOperator.Minus;

import Integer.BigNumber.Compare;

public class Minus {
    /**
     * Subtract two numbers with the same length.
     * @param minuend the number from which another number is subtracted.
     * @param subtrahend the number that is subtracted from another number.
     * @param times The number of times the subtrahend has already been subtracted from the minuend.
     * @return The number of times the subtrahend has been subtracted from the minuend and the resut after minued.
     */
    public static Object[] timesRepeat(String minuend, String subtrahend, int times){
        int len = minuend.length(), len2 = subtrahend.length(), remainder = 0;
        int difference;
        Object[]  res = new Object[2];
        String minuendCopy = "";
        
        if (Compare.TwoBigNumber(minuend, subtrahend) == -1) {
            res[1] = minuend.replaceAll("^0+", "");
            res[0] = times; 
            return res;
        }

        if (len > len2) {
            for (int i = 0; i < len - len2; i++) {
                subtrahend = "0" + subtrahend; 
            }
        } else if (len2 > len ) {
            for (int i = 0; i < len2 - len; i++) {
                minuend = "0" + minuend;
            }
        }

        if (minuend.charAt(0) - subtrahend.charAt(0) < 0) {
            res[1] = minuend.toString().replaceAll("^0+", "");
            res[0] = times;
            return res;
        }

        for (int i = len-1; i >= 0; i--) {
            if (remainder > 0) {
                difference = minuend.charAt(i)- subtrahend.charAt(i)-remainder;
                remainder = 0;
            } else {
                difference = minuend.charAt(i)- subtrahend.charAt(i);
            }

            if (i == 0 && difference < 0) {
                res[1] = minuend.toString().replaceAll("^0+", "");
                res[0] = times;
                return res;
            }

            if (difference < 0 ) {
                difference = 10 + difference;   
                remainder++;
            } 

            minuendCopy = difference + minuendCopy;
        }

        return timesRepeat(minuendCopy, subtrahend, times+1);
    }
}
