package Medium.Array;

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

// 1 ms 58.7 MB
class MinimumNumberOfOperationsToMakeArrayXOREqualToK_Solution {
    public int minOperations(int[] nums, int k) {
        int flip = 0;

        int xorAllNums = k;
        for (int num : nums) {
            xorAllNums ^= num;
        }

        while (xorAllNums != 0) {
            if (xorAllNums%2 != 0) {flip++;}
            xorAllNums>>=1;
        }

        return flip;
    }
}
