package BetterCodeAnswer.Easy.Arrays;

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

// @see Easy.Arrays
class SumOfAllSubsetXORTotals_Solution {
    public int subsetXORSum(int[] nums) {
        return 0;
    }
}