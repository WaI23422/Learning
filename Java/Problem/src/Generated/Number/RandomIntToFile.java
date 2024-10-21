package Generated.Number;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class RandomIntToFile {
    public static void main(String[] args) throws Exception {
        Random myRan = new Random();
        File myFile = new File("Inp.txt");
        
        if (!myFile.exists()) {
            myFile.createNewFile();
        }

        FileWriter myWriter = new FileWriter(myFile,false);

        for (int i = 0; i < 1e8; i++) {
            myWriter.write(myRan.nextInt(1,(int) 1e8+1) + "\n") ;
        }

        myWriter.close();
    }
}
