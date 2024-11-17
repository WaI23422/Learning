package Hard.Array;

import java.util.ArrayDeque;
import java.util.Deque;

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

// 39ms 62.94Mb
class ShortestSubarrayWithSumAtLeastK_Solution {

    public int shortestSubarray(int[] nums, int targetSum) {
        int n = nums.length;

        // Size is n+1 to handle subarrays starting from index 0
        long[] prefixSums = new long[n + 1];

        // Calculate prefix sums
        for (int i = 1; i <= n; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }

        Deque<Integer> candidateIndices = new ArrayDeque<>();

        int shortestSubarrayLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            // Remove candidates from front of deque where subarray sum meets target
            while (
                !candidateIndices.isEmpty() &&
                prefixSums[i] - prefixSums[candidateIndices.peekFirst()] >=
                targetSum
            ) {
                // Update shortest subarray length
                shortestSubarrayLength = Math.min(
                    shortestSubarrayLength,
                    i - candidateIndices.pollFirst()
                );
            }

            // Maintain monotonicity by removing indices with larger prefix sums
            while (
                !candidateIndices.isEmpty() &&
                prefixSums[i] <= prefixSums[candidateIndices.peekLast()]
            ) {
                candidateIndices.pollLast();
            }

            // Add current index to candidates
            candidateIndices.offerLast(i);
        }

        // Return -1 if no valid subarray found
        return shortestSubarrayLength == Integer.MAX_VALUE
            ? -1
            : shortestSubarrayLength;
    }
}