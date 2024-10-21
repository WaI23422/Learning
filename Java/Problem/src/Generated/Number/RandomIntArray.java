package Generated.Number;

import java.util.Random;
 
public class RandomIntArray {
    public static int[] Range(int lowerBound,int upperBound,int requiredNumbers) {
        int[] arr = new int[requiredNumbers];
        Random random = new Random();
        
        for(int i = 0; i < requiredNumbers; i++){
            arr[i] = random.nextInt(upperBound - lowerBound) + lowerBound;
        }

        return arr;
    }
}