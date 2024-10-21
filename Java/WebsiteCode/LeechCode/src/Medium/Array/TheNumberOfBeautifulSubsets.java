package Medium.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/the-number-of-beautiful-subsets/">2597. The Number of Beautiful Subsets</a>
 * <div class="elfjS" data-track-load="description_content"><p>You are given an array <code>nums</code> of positive integers and a <strong>positive</strong> integer <code>k</code>.</p>
 * 
 * <p>A subset of <code>nums</code> is <strong>beautiful</strong> if it does not contain two integers with an absolute difference equal to <code>k</code>.</p>
 * 
 * <p>Return <em>the number of <strong>non-empty beautiful </strong>subsets of the array</em> <code>nums</code>.</p>
 * 
 * <p>A <strong>subset</strong> of <code>nums</code> is an array that can be obtained by deleting some (possibly none) elements from <code>nums</code>. Two subsets are different if and only if the chosen indices to delete are different.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,4,6], k = 2
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The beautiful subsets of the array nums are: [2], [4], [6], [2, 6].
 * It can be proved that there are only 4 beautiful subsets in the array [2,4,6].
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1], k = 1
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The beautiful subset of the array nums is [1].
 * It can be proved that there is only 1 beautiful subset in the array [1].
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 20</code></li>
 * 	<li><code>1 &lt;= nums[i], k &lt;= 1000</code></li>
 * </ul>
 * </div>
 */
public class TheNumberOfBeautifulSubsets {
    public static void main(String[] args) {
        int[][][] tests = {
            {{2,4,6},{2}},
        };

        for (int[][] test : tests) {
            int[] nums = test[0];
            int k = test[1][0];

            System.out.println(new TheNumberOfBeautifulSubsets_Solution().beautifulSubsets(nums, k));
        }
    }
}

// 395 ms 45 MB
class TheNumberOfBeautifulSubsets_Solution {
    private int dfs(int[] nums, int k, int i, Set<Integer> set) {
      if (i == nums.length){return set.isEmpty() ? 0 : 1;}
  
      int cnt = dfs(nums, k, i+1, set);
      
      if (set.contains(nums[i] - k)) return cnt;
  
      set.add(nums[i]);
      cnt += dfs(nums, k, i+1 ,set);
      set.remove(nums[i]);
  
      return cnt;
    }
  
    public int beautifulSubsets(int[] nums, int k) {
      Arrays.sort(nums);
  
      return dfs(nums, k, 0, new HashSet<Integer>());
    }
  }