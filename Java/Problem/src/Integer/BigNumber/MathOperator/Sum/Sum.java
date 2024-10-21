package Integer.BigNumber.MathOperator.Sum;
import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class Sum{
    // String Sum method:
    public static String NumberStringSum(String Str_inp1, String Str_inp2) {
        // Convert Input to Integer to perform sum:
        long Int_inp1 = Long.parseLong(Str_inp1);
        long Int_inp2 = Long.parseLong(Str_inp2);
        Long sum = Int_inp1 + Int_inp2;
        // Convert back to String:
        String res = Long.toString(sum);
        return res;
    }

    public static String Factorial(int number){
        // Calculate Factorial
        BigInteger factorial = BigInteger.ONE; /*Factorial of large number cause Integer overflow. */ 
        if (number > 1 ) {
            for(int i = 1; i <= number; ++i){
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            
        }
        return factorial.toString(); /*A method always return value so return inside if is not enough (because if the "if" condition not happend there are no value to return)*/ 
    }

    // Running File - Scanner will throws Exception if there is a problem with opening the file for reading, so use throw Exception in main method instead of try-catch method.
    public static void main(String[] args) throws Exception {
        // Declare file and Scanner:
        Scanner myReader = new Scanner(new File("bai1a.inp"));
        Scanner myInput = new Scanner(System.in);
        // Declare Input
        String Str_inp1 = myReader.nextLine();
        String Str_inp2 = myReader.nextLine();
        myReader.close();
        // Create bai1a.out Output file:
        File myFileOutput = new File("bai1a.out");
        myFileOutput.createNewFile();
        // Write Output to bai1a.out file:
        FileWriter myWriter = new FileWriter(myFileOutput,false);
        myWriter.write(NumberStringSum(Str_inp1, Str_inp2)+"\n");
        
        // Take input from user:
        System.out.println("Please enter a number in range 0 to 500:");
        int number = myInput.nextInt();
        myInput.close();
        // Write Output to bai1a.out file
        myWriter.write(Factorial(number));
        myWriter.close();
    }   
}