package Medium.Array;

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

// Memory Limit Exceeded
class SubarrayProductLessThanK_Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length, count = 0;
        int[][] productArr = new int[len][len];
        productArr[0] = nums;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                count++;
            } else {
                nums[i] = 0;
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                if (productArr[i-1][j] == 0) {continue;}

                int product = productArr[i-1][j]*nums[i+j];
                if (product < k) {
                    productArr[i][j] = product;
                    count++;
                }
            }
        }

        return count;
    }
}