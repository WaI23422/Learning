package Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-score-of-an-array-after-marking-all-elements/">2593. Find Score of an Array After Marking All Elements</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given an array <code>nums</code> consisting of positive integers.</p>
 * 
 * <p>Starting with <code>score = 0</code>, apply the following algorithm:</p>
 * 
 * <ul>
 * 	<li>Choose the smallest integer of the array that is not marked. If there is a tie, choose the one with the smallest index.</li>
 * 	<li>Add the value of the chosen integer to <code>score</code>.</li>
 * 	<li>Mark <strong>the chosen element and its two adjacent elements if they exist</strong>.</li>
 * 	<li>Repeat until all the array elements are marked.</li>
 * </ul>
 * 
 * <p>Return <em>the score you get after applying the above algorithm</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,1,3,4,5,2]
 * <strong>Output:</strong> 7
 * <strong>Explanation:</strong> We mark the elements as follows:
 * - 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [<u>2</u>,<u>1</u>,<u>3</u>,4,5,2].
 * - 2 is the smallest unmarked element, so we mark it and its left adjacent element: [<u>2</u>,<u>1</u>,<u>3</u>,4,<u>5</u>,<u>2</u>].
 * - 4 is the only remaining unmarked element, so we mark it: [<u>2</u>,<u>1</u>,<u>3</u>,<u>4</u>,<u>5</u>,<u>2</u>].
 * Our score is 1 + 2 + 4 = 7.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,3,5,1,3,2]
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> We mark the elements as follows:
 * - 1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,3,<u>5</u>,<u>1</u>,<u>3</u>,2].
 * - 2 is the smallest unmarked element, since there are two of them, we choose the left-most one, so we mark the one at index 0 and its right adjacent element: [<u>2</u>,<u>3</u>,<u>5</u>,<u>1</u>,<u>3</u>,2].
 * - 2 is the only remaining unmarked element, so we mark it: [<u>2</u>,<u>3</u>,<u>5</u>,<u>1</u>,<u>3</u>,<u>2</u>].
 * Our score is 1 + 2 + 2 = 5.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
 * </ul>
 * </div></div>
 */
public class FindScoreOfAnArrayAfterMarkingAllElements {
    public static void main(String[] args) {
    }
}

// 109ms 59.14MB
class FindScoreOfAnArrayAfterMarkingAllElements_Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = nums[i];
            dp[i][1] = i;
        }

        Arrays.sort(dp, (a, b) -> a[0] - b[0]);

        boolean[] marked = new boolean[n];
        long result = 0;

        for (int[] arr : dp) {
            int val = arr[0];
            int ind = arr[1];

            if (!marked[ind]) {
                result += val;

                marked[ind] = true;
                if (ind > 0)
                    marked[ind - 1] = true;
                if (ind < n - 1) 
                    marked[ind + 1] = true;
            }
        }

        return result;
    }
}