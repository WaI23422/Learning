package Integer.BigNumber;

public class Compare {
    /**
     * Comparing two big number.
     * @param num1 First Number to compare.
     * @param num2 Seconde Number to compare.
     * @return <code> 1 </code> if number 1 greater than number 2, <code> -1 </code> if number 2 greater than number 1 and <code> 0 </code> if number 2 equal number 1.
     */
    public static int TwoBigNumber(String num1, String num2){
        num1 = num1.replaceAll("^0+", "");
        num2 = num2.replaceAll("^0+", "");

        int len1 = num1.length();
        int len2 = num2.length();

        if (len1 < len2) {
            return -1;
        } else if (len1 > len2) {
            return 1;
        } else {
            for (int i = 0; i < len1; i++) {
                int num1Char = num1.charAt(i) - '0';
                int num2Char = num2.charAt(i) - '0';

                if (num1Char > num2Char) {
                    return 1;
                } else if (num1Char < num2Char) {
                    return -1;
                }
            }
        }

        return 0;
    }
}