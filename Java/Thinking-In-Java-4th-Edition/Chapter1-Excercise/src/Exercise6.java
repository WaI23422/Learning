// Write a program that includes and calls the storage( ) method defined
// as a code fragment in this chapter. 

/**
* Insert a list:
* <ol>
* <li> Item six
* </ol>
*/

import java.util.Scanner;

public class Exercise6 {
    
    static int SumRangeNumber(int number ) {
        int res = 0;

        int[] rangeNumber = new int[number+1]; // The Stack storage
        
        for (int i = 0; i < number+1; i++) {
            rangeNumber[i] = i;
        }

        for (int i : rangeNumber) {
            res += i;    
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println("// Exercise 6 Result //");
        System.out.println("Sum number from 0 to :");
        Scanner myScanner = new Scanner(System.in);
        int number = myScanner.nextInt();
        
        System.out.println("Sum of 0 to "+ number + " equal:");
        System.out.println(SumRangeNumber(number));;

        myScanner.close();
        System.out.println("----------------------------------------------------");
    }
}
