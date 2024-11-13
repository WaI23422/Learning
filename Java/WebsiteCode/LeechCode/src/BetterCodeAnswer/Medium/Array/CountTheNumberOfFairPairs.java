package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;


/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/count-the-number-of-fair-pairs/">2563. Count the Number of Fair Pairs</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given a <strong>0-indexed</strong> integer array <code>nums</code> of size <code>n</code> and two integers <code>lower</code> and <code>upper</code>, return <em>the number of fair pairs</em>.</p>
 * 
 * <p>A pair <code>(i, j)</code> is <b>fair </b>if:</p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= i &lt; j &lt; n</code>, and</li>
 * 	<li><code>lower &lt;= nums[i] + nums[j] &lt;= upper</code></li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [0,1,7,4,4,5], lower = 3, upper = 6
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,7,9,2,5], lower = 11, upper = 11
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> There is a single fair pair: (2,3).
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>nums.length == n</code></li>
 * 	<li><code><font face="monospace">-10<sup>9</sup></font>&nbsp;&lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li><code><font face="monospace">-10<sup>9</sup>&nbsp;&lt;= lower &lt;= upper &lt;= 10<sup>9</sup></font></code></li>
 * </ul>
 * </div></div>
 */
public class CountTheNumberOfFairPairs {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {0,1,7,4,4,5},
                {3},
                {6}
            },
            {
                {1,7,9,2,5},
                {11},
                {11}
            },
            {
                {0,5},
                {0},
                {5}
            },
            {
                {0,3},
                {3},
                {6}
            },
            {
                {0,7},
                {3},
                {6}
            },
        };

        for (int[][] test : tests) {
            int nums[] = test[0],
                lower = test[1][0],
                upper = test[2][0];

            System.out.println(new CountTheNumberOfFairPairs_Solution().countFairPairs(nums, lower, upper));
        }
    }
}

// 23ms 57.96MB
class CountTheNumberOfFairPairs_Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums); 
        long pairsWithUpper = findLessThanEqualTo(nums, upper);
        long pairsWithLowerMinus1 = findLessThanEqualTo(nums, lower - 1);
        return pairsWithUpper - pairsWithLowerMinus1;
    }

    private long findLessThanEqualTo(int[] nums, int targetSum) {
        int n = nums.length;
        long pairs = 0;
        int left = 0;
        int right = n - 1;


        while (left < right) {
            if (nums[left] + nums[right] <= targetSum) {
                pairs += (right - left);
                left++; 
            } else {
                right--; 
            }
        }

        return pairs;
    }
}