package Integer.BigNumber.MathOperator.Multiply;
import java.util.Scanner;

class Remove {
    /**
     * Remove character '0' in front of a String.
     * @param str String number with number zero infront.
     * @return String with out number zero infront.
     */
    public static String ZeroInfront(String str){
        String res = "";

        if (str.charAt(0) != '0' || str.length() == 1) {
            return res = str;
        } else {
            res = str.substring(1, str.length());
            return ZeroInfront(res);
        }
    }
}

class Sum {
    /**
     * The sum of the string containing only numbers
     * @param num1 String number.
     * @param num2 String number.
     * @return Sum of two string.
     */
    public static String TwoNumber(String num1, String num2){
        String res = "";
        int hold = 0;
        int remainder = 0;

        if (num1.length() > num2.length()) {
            int len = num1.length()-num2.length();
            for (int i = 0; i < len; i++) {
                num2 = "0" + num2;
            }
        } else if (num2.length() > num1.length()) {
            int len = num2.length()-num1.length();
            for (int i = 0; i < len; i++) {
                num1 = "0" + num1;
            }
        }
        
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        for (int i = chars1.length-1; i >= 0; i--) {
            hold = Integer.parseInt(String.valueOf(chars1[i])) + Integer.parseInt(String.valueOf(chars2[i])) + remainder;
            if (hold > 9) {
                res = String.valueOf(String.valueOf(hold).toCharArray()[1]) + res;
                remainder = 1;
            } else {
                res = String.valueOf(hold) + res;
                remainder = 0;
            }
        }

        if (remainder == 1) {
            res = "1" + res; 
        }

        return Remove.ZeroInfront(res);
    }
}

public class Multiply2{
    public static String TwoNumberMultiply(String numb1, String numb2){
        String res = "0";
        String Counter = "0";

        while (!Counter.equals(numb2)) {
            res = Sum.TwoNumber(res,numb1);
            Counter = Sum.TwoNumber(Counter,"1");
        } 

        return res;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Input two numbers:");
        String[] numb = {myScanner.nextLine(),myScanner.nextLine()};

        System.out.println("Result:");
        System.out.println(Multiply2.TwoNumberMultiply(numb[0], numb[1]));

        myScanner.close();
    }
}