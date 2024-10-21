package BetterCodeAnswer.Easy.Arrays;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public static void main(String[] args) {
        int[][] tests = {
            {3,5}
        };

        for (int[] nums : tests) {
            System.out.println(new SpecialArrayWithXElementsGreaterThanOrEqualX_Solution().specialArray(nums));
        }
    }
}

// 2 ms 41.2 MB
class SpecialArrayWithXElementsGreaterThanOrEqualX_Solution {
    private int getFirstGreaterOrEqual(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;

        int index = nums.length;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] >= val) {
                index = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return index;
    }

    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int N = nums.length;
        for (int i = 1; i <= N; i++) {
            int k = getFirstGreaterOrEqual(nums, i);

            if (N - k == i) {
                return i;
            }
        }

        return -1;
    }
}

// 0 ms 41.5 MB
class SpecialArrayWithXElementsGreaterThanOrEqualX_Solution2 {
    public int specialArray(int[] nums) {
        int N = nums.length;
        int[] freq = new int[N + 1];

        for (int i = 0; i < N; i++) {
            freq[Math.min(N, nums[i])]++;
        }
        
        int numGreaterThanOrEqual = 0;
        for (int i = N; i >= 1; i--) {
            numGreaterThanOrEqual += freq[i];
            if (i == numGreaterThanOrEqual) {
                return i;
            }
        }
        
        return -1;
    }
}