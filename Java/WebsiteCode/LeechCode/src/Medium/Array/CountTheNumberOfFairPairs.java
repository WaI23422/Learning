package Medium.Array;

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

// 23ms 56.96MB
class CountTheNumberOfFairPairs_Solution {

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return lower_bound(nums, upper + 1) - lower_bound(nums, lower);
    }

    private long lower_bound(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        long result = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < value) {
                result += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}

// Time Limit Exceed:
class CountTheNumberOfFairPairs_Solution2 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;
        Arrays.sort(nums);

        int len = nums.length;

        for (int i = 0; i < len-1; i++) {
            int left = i+1,
                num = nums[i],   
                right = len-1;         
        
            while (right >= 0 && nums[right] + num > upper) { right--;}
            while (left < len && nums[left]  + num < lower) { left++; }

            if (left > right) {continue;}
            count += right - left + (left > i ? 1 : 0);
        }

        return count;
    }
}

// Time Limit Exceed:
class CountTheNumberOfFairPairs_Solution1 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i +1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (lower <= sum && sum <= upper) {
                    count++;
                }
            }
        }

        return count;
    }
}