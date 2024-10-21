// Write a method that displays char values in binary form. Demonstrate
// it using several different characters. 

public class Exercise13 {
    public static void displayCharInBinary(char c) {
        String binaryString = Integer.toBinaryString(c);

        System.out.println(binaryString);
      }
    public static void main(String[] args) {
        System.out.println("Exercise 13 Result: ");
        
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (char c : alphabet) {
            displayCharInBinary(c);
        }

        System.out.println("----------------------------------------------------");
    }
}
