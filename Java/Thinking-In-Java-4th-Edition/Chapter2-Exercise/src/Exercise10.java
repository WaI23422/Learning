// Write a program with two constant values, one with alternating binary
// ones and zeroes, with a zero in the least-significant digit, and the second, also alternating,
// with a one in the least-significant digit (hint: It’s easiest to use hexadecimal constants for
// this). Take these two values and combine them in all possible ways using the bitwise
// operators, and display the results using Integer.toBinaryString( ). 

public class Exercise10 {
    public static void main(String[] args) {
        System.out.println("Exercise 10 Result: ");

        int firstValue = 0x010;
        int secondValue = 0x101;

        int andValue = firstValue & secondValue;
        int orValue = firstValue | secondValue;
        int xorValue = firstValue ^ secondValue;
        int notFirstValue = ~firstValue;
        int notSecondValue = ~secondValue;
        
        System.out.println("The AND value is: " + Integer.toBinaryString(andValue));
        System.out.println("The OR value is: " + Integer.toBinaryString(orValue));
        System.out.println("The XOR value is: " + Integer.toBinaryString(xorValue));
        System.out.println("The NOT first value is: " + Integer.toBinaryString(notFirstValue));
        System.out.println("The NOT second value is: " + Integer.toBinaryString(notSecondValue));

        System.out.println("----------------------------------------------------");
    }
}
