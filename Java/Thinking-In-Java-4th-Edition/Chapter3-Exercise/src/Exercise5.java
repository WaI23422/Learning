// Repeat Exercise 10 from the previous chapter, using the ternary operator
// and a bitwise test to display the ones and zeroes, instead of Integer.toBinaryString( ).

class myPrint{
    public static void Bit(int numb, int range){
        String binaryString = "";
            for (int i = range; i >= 0; i--) {
                int bitValue = (numb >> i) & 1;

                binaryString += bitValue == 1 ? "1" : "0";
            }

        System.out.println(binaryString);
    }
}

public class Exercise5 {
    public static void main(String[] args) {
        System.out.println("Exercise 5 Result: ");

        int firstValue = 0x010;
        int secondValue = 0x101;

        int andValue = firstValue & secondValue;
        int orValue = firstValue | secondValue;
        int xorValue = firstValue ^ secondValue;
        int notFirstValue = ~firstValue;
        int notSecondValue = ~secondValue;
        
        int[] Arr = {andValue,orValue,xorValue,notFirstValue,notSecondValue};

        for (int numb : Arr) {
            myPrint.Bit(numb, 10);
        }

        System.out.println("----------------------------------------------------");
    }
}
