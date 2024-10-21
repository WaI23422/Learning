package Easy.Arrays;

public class SumOfAllSubsetXORTotals {
    public static void main(String[] args) {
        int[][] tests = {
            {1,2,3},
            {1,3},
            {5,1,6},
        };

        for (int[] nums : tests) {
            System.out.println(new SumOfAllSubsetXORTotals_Solution().subsetXORSum(nums));
        }
    }
}

// 0 ms 40.7 MB
class SumOfAllSubsetXORTotals_Solution {
    int sum = 0;
    public int subsetXORSum(int[] nums) {
        return XORsum(nums,0,0);
    }

    private int XORsum(int[] nums,int idx, int currentXOR) {
        if (idx == nums.length) {return currentXOR;}

        int include = XORsum(nums, idx + 1, currentXOR ^ nums[idx]);
        int exclude = XORsum(nums, idx + 1, currentXOR);
        return include + exclude;
    }
}