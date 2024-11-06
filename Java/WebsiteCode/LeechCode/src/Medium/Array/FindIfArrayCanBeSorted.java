package Medium.Array;

import java.util.Arrays;

public class FindIfArrayCanBeSorted {
    public static void main(String[] args) {
        int[][] tests = {
            {8,4,2,30,15}
        };

        for (int[] nums : tests) {
            System.out.println(new FindIfArrayCanBeSorted_Solution().canSortArray(nums));
        }
    }
}

// 5ms 44.67MB
class FindIfArrayCanBeSorted_Solution {

    public boolean canSortArray(int[] nums) {
        int[] values = Arrays.copyOf(nums, nums.length);

        int n = values.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (values[j] <= values[j + 1]) {
                    continue;
                } else {
                    if (
                        Integer.bitCount(values[j]) ==
                        Integer.bitCount(values[j + 1])
                    ) {
                        int temp = values[j];
                        values[j] = values[j + 1];
                        values[j + 1] = temp;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
