package Medium.Array;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[][] tests ={
            {1,2,3},
        };

        for (int[] nums : tests) {
            List<List<Integer>> subsets = new Subsets_Solution().subsets(nums);
            String ans = "[";
            for (List<Integer> subset : subsets) {
                ans += subset.toString();
            }
        
            System.out.println(ans+"]");
        }
    }
}

// 1 ms 42.7 MB
class Subsets_Solution {
    List<List<Integer>> output = new ArrayList<>();
    int n, k;

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        if (curr.size() == k) {
            output.add(new ArrayList<>(curr));
            return;
        }
        for (int i = first; i < n; ++i) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }
}