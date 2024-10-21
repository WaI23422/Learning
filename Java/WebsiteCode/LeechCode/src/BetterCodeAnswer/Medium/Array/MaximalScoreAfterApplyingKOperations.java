package BetterCodeAnswer.Medium.Array;

import java.util.PriorityQueue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximal-score-after-applying-k-operations/">2530. Maximal Score After Applying K Operations</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> integer array <code>nums</code> and an integer <code>k</code>. You have a <strong>starting score</strong> of <code>0</code>.</p>
 * 
 * <p>In one <strong>operation</strong>:</p>
 * 
 * <ol>
 * 	<li>choose an index <code>i</code> such that <code>0 &lt;= i &lt; nums.length</code>,</li>
 * 	<li>increase your <strong>score</strong> by <code>nums[i]</code>, and</li>
 * 	<li>replace <code>nums[i]</code> with <code>ceil(nums[i] / 3)</code>.</li>
 * </ol>
 * 
 * <p>Return <em>the maximum possible <strong>score</strong> you can attain after applying <strong>exactly</strong></em> <code>k</code> <em>operations</em>.</p>
 * 
 * <p>The ceiling function <code>ceil(val)</code> is the least integer greater than or equal to <code>val</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [10,10,10,10,10], k = 5
 * <strong>Output:</strong> 50
 * <strong>Explanation:</strong> Apply the operation to each array element exactly once. The final score is 10 + 10 + 10 + 10 + 10 = 50.
 * </pre>
 * 
 * <p><strong>Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,10,3,3,3], k = 3
 * <strong>Output:</strong> 17
 * <strong>Explanation: </strong>You can do the following operations:
 * Operation 1: Select i = 1, so nums becomes [1,<strong><u>4</u></strong>,3,3,3]. Your score increases by 10.
 * Operation 2: Select i = 1, so nums becomes [1,<strong><u>2</u></strong>,3,3,3]. Your score increases by 4.
 * Operation 3: Select i = 2, so nums becomes [1,1,<u><strong>1</strong></u>,3,3]. Your score increases by 3.
 * The final score is 10 + 4 + 3 = 17.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length, k &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div></div>
 */
public class MaximalScoreAfterApplyingKOperations {
    public static void main(String[] args) {
        int[][][] tests = { 
            {
                {15,4,2},
                {3}
            },
            {
                {1,10,3,3,3},
                {3}
            },
            {
                {10,10,10,10,10},
                {5}
            }
        };

        for (int[][] test : tests) {
            int nums[] = test[0],
                k = test[1][0];

            System.out.println(new MaximalScoreAfterApplyingKOperations_Solution().maxKelements(nums, k));
        }
    }
}

// 113ms 62.91MB
class MaximalScoreAfterApplyingKOperations_Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int v : nums) {
            pq.offer(v);
        }
        long ans = 0;
        while (k-- > 0) {
            int v = pq.poll();
            ans += v;
            pq.offer((v + 2) / 3);
        }
        return ans;
    }
}