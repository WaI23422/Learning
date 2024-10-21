package Medium.Array;

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

// 7ms 63.23MB
class WaysToSplitArrayIntoGoodSubarrays_Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        final int mod = 1_000_000_007;
        int start = 0,
            zero_track = 0;
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                start = i;
                count++; 
                break;
            }
        }

        for (int i = start+1; i < nums.length; i++) {
            if (nums[i] == 1) {
                count *= zero_track + 1;
                count %= mod;
                zero_track = 0;
            } else {
                zero_track++;
            }
        }

        return (int) count;
    }
}