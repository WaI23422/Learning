package BetterCodeAnswer.Easy.Number;

/**
 * 
 */
public class NumberOfOneBits {
    public static void main(String[] args) {
        int[] tests = {
            1, 
            2,
            3,
            16,
            120
        };

        for (int n : tests) {
            System.out.println(new NumberOfOneBits_Solution().hammingWeight(n));
        }
    }
}

class NumberOfOneBits_Solution {
    // 0 ms 39.8 MB
    public int hammingWeight(int n) {
        int cnt = 0;
         while(n != 0){
             n = n & (n-1);
            cnt++;
        }
 
        return cnt;
    }
}