package Sort;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ascending sort of million elements in a file, output to a file.
 * 
 * @see Generated.Number.RandomIntToFile
 */
public class MilionSort {
    static long[] arr = new long[(int) 1e8];
    
    public static void main(String[] args) throws Exception {
        long n = 0;
        File myFile = new File("Inp.txt");
        Scanner myScanner = new Scanner(myFile);

        while (myScanner.hasNextInt()){
            // Use Insertion Sort to sort every number that is being scanned:
            arr[(int) n] = myScanner.nextInt();
            n++;
        }
        
        myScanner.close();

        Arrays.sort(arr);

        // Write sort array to output file: 
        File outFile = new File("Out.txt");
        if (!outFile.exists()) {
            outFile.createNewFile();
        }
        FileWriter myWriter = new FileWriter(outFile);

        for (long number : arr) {
            myWriter.write(number + "\n");
        }

        myWriter.close();
    }
}