// Start with a number that has a binary one in the most significant
// position (hint: Use a hexadecimal constant). Using the signed right-shift operator, right shift
// it all the way through all of its binary positions, each time displaying the result using
// Integer.toBinaryString( ).

public class Exercise11 {
    public static void rightShift(int numb) {
        int loop = numb;
        
        System.out.println("Number: " + numb);
        for (int i = 0; i < Integer.toBinaryString(loop).length(); i++) {
            System.out.println("Loop: "+ i );
            System.out.println(">>: " + Integer.toBinaryString(numb));
            numb >>= 1;
        }
    }
    public static void main(String[] args) {
        System.out.println("Exercise 11 Result: ");
        
        int numb = 0x800;
        
        rightShift(numb);

        System.out.println("----------------------------------------------------");
    }
}
