package Hard.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/number-of-submatrices-that-sum-to-target/">1074.Number of Submatrices That Sum to Target</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a <code>matrix</code>&nbsp;and a <code>target</code>, return the number of non-empty submatrices that sum to <font face="monospace">target</font>.</p>

<p>A submatrix <code>x1, y1, x2, y2</code> is the set of all cells <code>matrix[x][y]</code> with <code>x1 &lt;= x &lt;= x2</code> and <code>y1 &lt;= y &lt;= y2</code>.</p>

<p>Two submatrices <code>(x1, y1, x2, y2)</code> and <code>(x1', y1', x2', y2')</code> are different if they have some coordinate&nbsp;that is different: for example, if <code>x1 != x1'</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/02/mate1.jpg" style="width: 242px; height: 242px;">
<pre><strong>Input:</strong> matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
<strong>Output:</strong> 4
<strong>Explanation:</strong> The four 1x1 submatrices that only contain 0.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> matrix = [[1,-1],[-1,1]], target = 0
<strong>Output:</strong> 5
<strong>Explanation:</strong> The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> matrix = [[904]], target = 0
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= matrix.length &lt;= 100</code></li>
	<li><code>1 &lt;= matrix[0].length &lt;= 100</code></li>
	<li><code>-1000 &lt;= matrix[i] &lt;= 1000</code></li>
	<li><code>-10^8 &lt;= target &lt;= 10^8</code></li>
</ul>
</div>
 */
public class NumberOfSubmatricesThatSumToTarget {
    public static void main(String[] args) {
        int[][][][] tests = {
            {{{0,1,0},{1,1,1},{0,1,0}},{{0}}},
            {{{1,-1},{-1,1}},{{0}}},
            {{{904}},{{0}}},
        };

        for (int[][][] test : tests) {
            int[][] matrix = test[0];
            int target = test[1][0][0];

            System.out.println(new NumberOfSubmatricesThatSumToTarget_Solution().numSubmatrixSumTarget(matrix, target));
        }
    }
}

// 150 ms 45.6 MB
class NumberOfSubmatricesThatSumToTarget_Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 1; col < n; col++) {
                matrix[row][col] += matrix[row][col - 1];
            }
        }

        int count = 0;

        for (int c1 = 0; c1 < n; c1++) {
            for (int c2 = c1; c2 < n; c2++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;

                for (int row = 0; row < m; row++) {
                    sum += matrix[row][c2] - (c1 > 0 ? matrix[row][c1 - 1] : 0);
                    count += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return count;
    }
}