package BetterCodeAnswer.Medium.Array;

public class MinimumNumberOfOperationsToMakeArrayXOREqualToK {
    public static void main(String[] args) {
        int[][][] tests = {
            {{2,1,3,4},{1}},
            {{2,0,2,0},{0}}
        };

        for (int[][] test : tests) {
            int[] nums = test[0];
            int k = test[1][0];

            System.out.println(new MinimumNumberOfOperationsToMakeArrayXOREqualToK_Solution().minOperations(nums, k));
        }
    }
}

// 1 ms 56.5 MB
class MinimumNumberOfOperationsToMakeArrayXOREqualToK_Solution {
    public int minOperations(int[] nums, int k) {
        int finalXor = 0;
        // XOR of all integers in the array.
        for (int n : nums) {
            finalXor = finalXor ^ n;
        }
        
        int count = 0;
        // Keep iterating until any of k or finalXor becomes zero.
        while (k > 0 || finalXor > 0) {
            // k % 2 returns the rightmost bit in k,
            // finalXor % 2 returns the rightmost bit in finalXor.
            // Increment counter, if the bits don't match.
            if ((k % 2) != (finalXor % 2)) {
                count++;
            }
            
            // Remove the last bit from both integers.
            k /= 2;
            finalXor /= 2;
        }
        
        return count;
    }
}