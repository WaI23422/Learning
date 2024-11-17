package BetterCodeAnswer.Hard.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/shortest-subarray-with-sum-at-least-k/">862. Shortest Subarray with Sum at Least K</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <em>the length of the shortest non-empty <strong>subarray</strong> of </em><code>nums</code><em> with a sum of at least </em><code>k</code>. If there is no such <strong>subarray</strong>, return <code>-1</code>.</p>
 * 
 * <p>A <strong>subarray</strong> is a <strong>contiguous</strong> part of an array.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> nums = [1], k = 1
 * <strong>Output:</strong> 1
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> nums = [1,2], k = 4
 * <strong>Output:</strong> -1
 * </pre><p><strong class="example">Example 3:</strong></p>
 * <pre><strong>Input:</strong> nums = [2,-1,2], k = 3
 * <strong>Output:</strong> 3
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div></div>
 */
public class ShortestSubarrayWithSumAtLeastK {
    public static void main(String[] args) {
        int[][][] tests = {
            // 2
            {
                {56,-21,56,35,-9},
                {61}
            },
            // 3
            {
                {84,-37,32,40,95},
                {167}
            },
            // 1
            {
                {1},
                {1}
            },
            //  2
            {
                {48,99,37,4,-31},
                {140}
            },
            // 3
            {
                {2,-1,2},
                {3}
            }
        };

        for (int[][] test : tests) {
            int nums[] = test[0],
                k = test[1][0];

            System.out.println(new ShortestSubarrayWithSumAtLeastK_Solution().shortestSubarray(nums, k));
        }
    }
}

// 12ms 62.94Mb
class ShortestSubarrayWithSumAtLeastK_Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[] q = new int[n + 1];
        int l = 0, r = 0;
        int ans = n + 1;
        for (int i = 0; i < sum.length; i++) {
            while (r > l && sum[i] >= sum[q[l]] + k)
                ans = Math.min(ans, i - q[l++]);
            while (r > l && sum[i] <= sum[q[r - 1]])
                r--;
            q[r++] = i;
        }
        return ans <= n ? ans : -1;
    }
}