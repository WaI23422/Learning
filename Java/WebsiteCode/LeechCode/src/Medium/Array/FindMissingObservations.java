package Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-missing-observations/">2028. Find Missing Observations</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You have observations of <code>n + m</code> <strong>6-sided</strong> dice rolls with each face numbered from <code>1</code> to <code>6</code>. <code>n</code> of the observations went missing, and you only have the observations of <code>m</code> rolls. Fortunately, you have also calculated the <strong>average value</strong> of the <code>n + m</code> rolls.</p>
 * 
 * <p>You are given an integer array <code>rolls</code> of length <code>m</code> where <code>rolls[i]</code> is the value of the <code>i<sup>th</sup></code> observation. You are also given the two integers <code>mean</code> and <code>n</code>.</p>
 * 
 * <p>Return <em>an array of length </em><code>n</code><em> containing the missing observations such that the <strong>average value </strong>of the </em><code>n + m</code><em> rolls is <strong>exactly</strong> </em><code>mean</code>. If there are multiple valid answers, return <em>any of them</em>. If no such array exists, return <em>an empty array</em>.</p>
 * 
 * <p>The <strong>average value</strong> of a set of <code>k</code> numbers is the sum of the numbers divided by <code>k</code>.</p>
 * 
 * <p>Note that <code>mean</code> is an integer, so the sum of the <code>n + m</code> rolls should be divisible by <code>n + m</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> rolls = [3,2,4,3], mean = 4, n = 2
 * <strong>Output:</strong> [6,6]
 * <strong>Explanation:</strong> The mean of all n + m rolls is (3 + 2 + 4 + 3 + 6 + 6) / 6 = 4.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> rolls = [1,5,6], mean = 3, n = 4
 * <strong>Output:</strong> [2,3,2,2]
 * <strong>Explanation:</strong> The mean of all n + m rolls is (1 + 5 + 6 + 2 + 3 + 2 + 2) / 7 = 3.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> rolls = [1,2,3,4], mean = 6, n = 4
 * <strong>Output:</strong> []
 * <strong>Explanation:</strong> It is impossible for the mean to be 6 no matter what the 4 missing rolls are.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>m == rolls.length</code></li>
 * 	<li><code>1 &lt;= n, m &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= rolls[i], mean &lt;= 6</code></li>
 * </ul>
 * </div>
 */
public class FindMissingObservations {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {3,2,4,3},
                {4},
                {2}
            }
        };

        for (int[][] test : tests) {
            int rolls[] = test[0],
                mean = test[1][0],
                n = test[2][0];

            System.out.println(new FindMissingObservations_Solution().missingRolls(rolls, mean, n));
        }
    }
}

// 4ms 62.10 MB
class FindMissingObservations_Solution {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int roll : rolls) {
            sum = sum + roll;
        }
        // Find the remaining sum.
        int remainingSum = mean * (n + rolls.length) - sum;
        // Check if sum is valid or not.
        if (remainingSum > 6 * n || remainingSum < n) {
            return new int[0];
        }
        int distributeMean = remainingSum / n;
        int mod = remainingSum % n;
        // Distribute the remaining mod elements in nElements array.
        int[] nElements = new int[n];
        Arrays.fill(nElements, distributeMean);
        for (int i = 0; i < mod; i++) {
            nElements[i]++;
        }
        return nElements;
    }
}