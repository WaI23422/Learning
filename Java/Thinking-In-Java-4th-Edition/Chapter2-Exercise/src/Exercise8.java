// Show that hex and octal notations work with long values. Use
// Long.toBinaryString( ) to display the results. 

public class Exercise8 {
    public static void main(String[] args) {
        System.out.println("Exercise 8 Result: ");
        // Hex and octal notations : 0xaaaa (a from 0-9 or from a-f)
        long hexValue = 0x234; 
        long octalValue = 0311;

        System.out.println("Long hex: " + Long.toBinaryString(hexValue));
        System.out.println("Long octal: "+ Long.toBinaryString(octalValue));
        System.out.println("----------------------------------------------------");
    }
}
