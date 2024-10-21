package Medium.Array;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,2,2},{1}},
            {{1,2,3,1,2,3,1,2},{2}},
            {{1,2,1,2,1,2,1,2},{1}},
            {{5,5,5,5,5,5,5},{4}},
            {{1},{1}},
            {{1,2},{1}},
        };

        for (int[][] test : tests) {
            int[] nums = test[0];
            int k = test[1][0];

            System.out.println(new LengthOfLongestSubarrayWithAtMostKFrequency_Solution().maxSubarrayLength(nums, k));
        }
    }
}

// 66 ms 61.7 MB
class LengthOfLongestSubarrayWithAtMostKFrequency_Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0, right = 0, len = nums.length, max = 0;
        // int[] storeNumAppears = new int[1000_000_001]; // Memory Limit Exceeded
        Map<Integer,Integer> storeNumAppears = new HashMap<>();

        while (right < len) {
            int num = nums[right];
            storeNumAppears.put(num,storeNumAppears.getOrDefault(num, 0) + 1);
            if (storeNumAppears.get(nums[right]) <= k) {
                max = Math.max(max, right-left+1);
                right++;
            } else {
                while (storeNumAppears.get(num) > k) {
                    int numLeft = nums[left++];
                    storeNumAppears.put(numLeft,storeNumAppears.get(numLeft) - 1);
                }
                right++;
            }
        }

        return max;
    }
}
