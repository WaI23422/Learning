package Integer.BigNumber.MathOperator.Multiply;
// Do multiply big number without using Library (Except java.util.Scanner for input).
import java.util.InputMismatchException;
import java.util.Scanner;

public class Multiply {
    /**
     * Method for calculating the product of a string and 10 raised to a power
     * @param numb number multiply wiht power of 10.
     * @param pow power of String number. 
     * @return a String number power of 10.
     */
    public static String Power(String numb,int pow){
        String res = numb;

        for (int i = 0; i < pow; i++) {
            res += "0";
        }

        return res;
    }
    /**
     * Remove zero infront of a string number.
     * @param str a string number.
     * @return String number.
     */
    public static String removeZeroInfront(String str){
        String res = "";

        if (str.charAt(0) != '0' || str.length() == 1) {
            return res = str;
        } else {
            res = str.substring(1, str.length());
            return removeZeroInfront(res);
        }
    }
    /**
     * Continue summing until there is no remainder.
     * @param res string result.
     * @param str1 string longer.
     * @param remainder remainder in equation.
     * @param str2_Len Length of string shorter.
     * @return a String number.
     */
    public static String remainderSumCheck(String res,String str1, int remainder, int str2_Len){
        if (remainder == 0) {
            res = str1.substring(0, str1.length() - str2_Len) + res;
            return res;
        } else {
            int sum = Integer.valueOf(String.valueOf(str1.charAt(str1.length() - str2_Len -1))) + remainder; 
            
            if (sum < 10) {
                remainder = 0;
                res = str1.substring(0, str1.length() - str2_Len-1) + Integer.toString(sum) + res;
            } else {
                res = Integer.toString(sum).charAt(1) + res;
                return remainderSumCheck(res, str1, remainder, str2_Len+1);
            } 

            return res;
        }
    }
    /**
     * 
     * @param str1 First String.
     * @param str2 Second String.
     * @return Sum of two strings.
     */
    public static String SumStringChar(String str1, String str2){
        String res = "";
        
        str1 = removeZeroInfront(str1); 
        str2 = removeZeroInfront(str2);

        int len1 = str1.length();
        int len2 = str2.length();

        if (len1 > len2) {
            int remainder = 0;
            
            for (int i = len2 - 1; i >= 0 ; i--) {
                int sum = Integer.valueOf(String.valueOf(str1.charAt(len1 + i - len2))) + Integer.valueOf(String.valueOf(str2.charAt(i))) + remainder;
                
                remainder = 0; // reset remainder
             
                if (sum > 9) {
                    remainder += 1;
                    res = String.valueOf(sum).charAt(1) + res;
                } else {
                    res = String.valueOf(sum) + res;
                }
            }

            res = remainderSumCheck(res, str1, remainder, len2);
            
        } else {
            int remainder = 0;
            
            for (int i = len1 - 1; i >= 0 ; i--) {
                int sum = Integer.valueOf(String.valueOf(str2.charAt(len2 + i - len1))) + Integer.valueOf(String.valueOf(str1.charAt(i))) + remainder;
                
                remainder = 0; // reset remainder

                if (sum > 9) {
                    remainder += 1;
                    res = String.valueOf(sum).charAt(1) + res;
                } else {
                    res = String.valueOf(sum) + res;
                }
            }

            if (len2 > len1) {
                res = remainderSumCheck(res, str2, remainder, len1);
            }

            if (len2 == len1 && remainder == 1){
                res = "1" + res;
            }
            
        }

        return res;
    }
    /**
     * Convert a String to Characters and do multiply on single .
     * @param str : String input.
     * @return String Characters.
     */
    public static String MultiplyStringChar(String str1, String str2){
        String res = "0";

        str1 = removeZeroInfront(str1);
        str2 = removeZeroInfront(str2);

        // convert abc*ab to abc*a*10^1 + abc*b*10^0 
        // ( can convert multiplication to addition to 10^n as n approaches infinity. )
        int len1 = str1.length();
        int len2 = str2.length();
        int numb1 = 0, numb2 = 0;
        int Pow = 0;
        String numbHold = "0";

        for (int i = len1-1; i >= 0; i--) {
            int Pow1 = 0;
            numb1 = Integer.parseInt(String.valueOf(str1.charAt(i)));

            for (int j = len2-1; j >= 0; j--) {
                numb2 = Integer.parseInt(String.valueOf(str2.charAt(j))); 
                    
                numbHold = SumStringChar(numbHold, Power(Integer.toString(numb1*numb2), Pow1));
                Pow1 +=1;
            }    
                
            res = SumStringChar(res, Power(numbHold, Pow));
            numbHold = "0";
            Pow +=1;
        }

        return res;
    }

    public static void main(String[] args) {
        try {
            Scanner myScanner = new Scanner(System.in);

            System.out.println("Enter First Number:");
            String firstNumber = myScanner.nextLine();

            System.out.println("Enter Second Number:");
            String secondNumber = myScanner.nextLine();

            System.out.println(MultiplyStringChar(firstNumber, secondNumber));

            myScanner.close();
        } catch (InputMismatchException e) {
            System.out.println("Input number mismatch. Error: " + e.toString());
        }
    }
}
