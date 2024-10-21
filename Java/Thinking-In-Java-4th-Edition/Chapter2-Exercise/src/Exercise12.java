// Start with a number that is all binary ones. Left shift it, then use the
// unsigned right-shift operator to right shift through all of its binary positions, each time
// displaying the result using Integer.toBinaryString( ). 
public class Exercise12 {
    public static void rightShift(int numb) {
        System.out.println("Number: " + numb);

        numb <<= 1;
        System.out.println("<<: " + Integer.toBinaryString(numb));

        int loop = numb;
        for (int i = 0; i < Integer.toBinaryString(loop).length(); i++) {
            System.out.println("Loop: "+ i );
            System.out.println(">>: " + Integer.toBinaryString(numb));
            numb >>= 1;
        }
    }
    public static void main(String[] args) {
        System.out.println("Exercise 12 Result: ");
        int numb = 0xFFFF;

        rightShift(numb);

        System.out.println("----------------------------------------------------");
    }
}
