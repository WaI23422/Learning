package BetterCodeAnswer.Medium.Array;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[][][] tests = {
            {{10,9,10,4,3,8,3,3,6,2,10,10,9,3},{19}},
            {{10,10,5,2,6},{100}},
            {{10,5,2,6},{100}},
            {{1,2,3},{0}}
        };

        for (int[][] test : tests) {
            int[] nums = test[0];
            int k = test[1][0];

            System.out.println(new SubarrayProductLessThanK_Solution().numSubarrayProductLessThanK(nums, k));
        }
    }
}

// 4 ms 47.4 MB
class SubarrayProductLessThanK_Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int left = 0, right = 0, product = 1, count = 0;
        int n = nums.length;

        while (right < n) {
            product *= nums[right];
            while (product >= k) product /= nums[left++];
            count += 1 + (right - left);
            right++;
        }

        return count;
    }
}