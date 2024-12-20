package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/longest-square-streak-in-an-array/">2501. Longest Square Streak in an Array</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given an integer array <code>nums</code>. A subsequence of <code>nums</code> is called a <strong>square streak</strong> if:</p>
 * 
 * <ul>
 * 	<li>The length of the subsequence is at least <code>2</code>, and</li>
 * 	<li><strong>after</strong> sorting the subsequence, each element (except the first element) is the <strong>square</strong> of the previous number.</li>
 * </ul>
 * 
 * <p>Return<em> the length of the <strong>longest square streak</strong> in </em><code>nums</code><em>, or return </em><code>-1</code><em> if there is no <strong>square streak</strong>.</em></p>
 * 
 * <p>A <strong>subsequence</strong> is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [4,3,6,16,8,2]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> Choose the subsequence [4,16,2]. After sorting it, it becomes [2,4,16].
 * - 4 = 2 * 2.
 * - 16 = 4 * 4.
 * Therefore, [4,16,2] is a square streak.
 * It can be shown that every subsequence of length 4 is not a square streak.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,3,5,6,7]
 * <strong>Output:</strong> -1
 * <strong>Explanation:</strong> There is no square streak in nums so return -1.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>2 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * </div></div>
 */
public class LongestSquareStreakInAnArray {
    public static void main(String[] args) {
        int[][] tests = {
            {3,9,81,6561},
            {4,3,6,16,8,2}
        };

        for (int[] nums : tests) {
            System.out.println(new LongestSquareStreakInAnArray_Solution().longestSquareStreak(nums));
        }
    }
}

// 7ms 58.21MB
class LongestSquareStreakInAnArray_Solution {
    public int longestSquareStreak(int[] nums) {
        boolean[] nums_arr = new boolean[100_001];
        
        for (int num : nums) {
            nums_arr[num]=true;
        }
        
        int max = -1;
        for (int num : nums) {
            int pow_num = (int) Math.pow(num, 2);
            if (pow_num < 100_001 && nums_arr[pow_num]) {
                int count = 1;
                do {
                    count++;
                    max = Math.max(max, count);
                    pow_num = (int) Math.pow(pow_num, 2);
                } while (pow_num < 100_001 && nums_arr[pow_num]);
            }
        }

        return max;
    }
}
