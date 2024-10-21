package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/ways-to-split-array-into-good-subarrays/">2750. Ways to Split Array Into Good Subarrays</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a binary array <code>nums</code>.</p>
 * 
 * <p>A subarray of an array is <strong>good</strong> if it contains <strong>exactly</strong> <strong>one</strong> element with the value <code>1</code>.</p>
 * 
 * <p>Return <em>an integer denoting the number of ways to split the array </em><code>nums</code><em> into <strong>good</strong> subarrays</em>. As the number may be too large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>
 * 
 * <p>A subarray is a contiguous <strong>non-empty</strong> sequence of elements within an array.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [0,1,0,0,1]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> There are 3 ways to split nums into good subarrays:
 * - [0,1] [0,0,1]
 * - [0,1,0] [0,1]
 * - [0,1,0,0] [1]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [0,1,0]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> There is 1 way to split nums into good subarrays:
 * - [0,1,0]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>0 &lt;= nums[i] &lt;= 1</code></li>
 * </ul>
 * </div>
 */
public class WaysToSplitArrayIntoGoodSubarrays {
    public static void main(String[] args) {
        int[][] tests = {
            {0,1,0,0,1,0,1},
            {0},
            {1},
            {0,1,0,0,1}
        };

        for (int[] nums : tests) {
            System.out.println(new WaysToSplitArrayIntoGoodSubarrays_Solution().numberOfGoodSubarraySplits(nums));
        }
    }
}

// 6ms 63.00MB
class WaysToSplitArrayIntoGoodSubarrays_Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int n = nums.length;
        int lhs = 0, rhs = n - 1;
        while (lhs < n && nums[lhs] == 0) {
            lhs++;
        }
        if (lhs == n) {
            return 0;
        }
        while (nums[rhs] == 0) {
            rhs--;
        }
        int index = lhs;
        long tot = 1;
        while (index < rhs) {
            int next = index + 1;
            while (nums[next] == 0) {
                next++;
            }
            tot = (tot * (next - index)) % 1000000007;
            index = next;
        }
        return (int)tot;
    }
}