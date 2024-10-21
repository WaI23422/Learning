package BetterCodeAnswer.Hard.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/k-th-smallest-in-lexicographical-order/">440. K-th Smallest in Lexicographical Order</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given two integers <code>n</code> and <code>k</code>, return <em>the</em> <code>k<sup>th</sup></code> <em>lexicographically smallest integer in the range</em> <code>[1, n]</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 13, k = 2
 * <strong>Output:</strong> 10
 * <strong>Explanation:</strong> The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 1, k = 1
 * <strong>Output:</strong> 1
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= k &lt;= n &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div>
 */
public class KthSmallestInLexicographicalOrder {
    public static void main(String[] args) {
        int[][] tests = {
            // {804289384,42641503},
            {13,2},
            {13,8},
            {1,1}
        };

        for (int[] test : tests) {
            int n = test[0],
                k = test[1];

            System.out.println(new KthSmallestInLexicographicalOrder_Solution().findKthNumber(n, k));
        }
    }
}

// 0ms 40.52MB
class KthSmallestInLexicographicalOrder_Solution {

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;

        while (k > 0) {
            int step = countSteps(n, curr, curr + 1);
            // If the steps are less than or equal to k, we skip this prefix's subtree
            if (step <= k) {
                // Move to the next prefix and decrease k by the number of steps we skip
                curr++;
                k -= step;
            } else {
                // Move to the next level of the tree and decrement k by 1
                curr *= 10;
                k--;
            }
        }

        return curr;
    }

    // To count how many numbers exist between prefix1 and prefix2
    private int countSteps(int n, long prefix1, long prefix2) {
        int steps = 0;
        while (prefix1 <= n) {
            steps += Math.min(n + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }
}