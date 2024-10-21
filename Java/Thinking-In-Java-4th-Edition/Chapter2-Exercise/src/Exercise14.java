// Write a method that takes two String arguments and uses all the
// boolean comparisons to compare the two Strings and print the results. For the == and !=,
// also perform the equals( ) test. In main( ), call your method with some different String
// objects. 

import java.util.Scanner;

public class Exercise14 {
    public static void compareStrings(String string1, String string2) {
        System.out.println("==: " + (string1 == string2));
        System.out.println("!=: " + (string1 != string2));
        System.out.println("equals(): " + string1.equals(string2));
      
        System.out.println("<: " + (string1.compareTo(string2) < 0));
        System.out.println(">: " + (string1.compareTo(string2) > 0));
        System.out.println("<=: " + (string1.compareTo(string2) <= 0));
        System.out.println(">=: " + (string1.compareTo(string2) >= 0));
      }
    public static void main(String[] args) {
        System.out.println("Exercise 14 Result: ");
        
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Input First String: ");
        String str1 = myScanner.nextLine();
        System.out.println("Input Second String: ");
        String str2 = myScanner.nextLine();

        compareStrings(str1, str2);

        myScanner.close();

        System.out.println("----------------------------------------------------");
    }
}
