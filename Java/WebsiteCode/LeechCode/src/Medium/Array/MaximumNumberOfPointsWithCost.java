package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximum-number-of-points-with-cost/">1937. Maximum Number of Points with Cost</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an <code>m x n</code> integer matrix <code>points</code> (<strong>0-indexed</strong>). Starting with <code>0</code> points, you want to <strong>maximize</strong> the number of points you can get from the matrix.</p>
 * 
 * <p>To gain points, you must pick one cell in <strong>each row</strong>. Picking the cell at coordinates <code>(r, c)</code> will <strong>add</strong> <code>points[r][c]</code> to your score.</p>
 * 
 * <p>However, you will lose points if you pick a cell too far from the cell that you picked in the previous row. For every two adjacent rows <code>r</code> and <code>r + 1</code> (where <code>0 &lt;= r &lt; m - 1</code>), picking cells at coordinates <code>(r, c<sub>1</sub>)</code> and <code>(r + 1, c<sub>2</sub>)</code> will <strong>subtract</strong> <code>abs(c<sub>1</sub> - c<sub>2</sub>)</code> from your score.</p>
 * 
 * <p>Return <em>the <strong>maximum</strong> number of points you can achieve</em>.</p>
 * 
 * <p><code>abs(x)</code> is defined as:</p>
 * 
 * <ul>
 * 	<li><code>x</code> for <code>x &gt;= 0</code>.</li>
 * 	<li><code>-x</code> for <code>x &lt; 0</code>.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong><strong> </strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/07/12/screenshot-2021-07-12-at-13-40-26-diagram-drawio-diagrams-net.png" style="width: 300px; height: 300px;">
 * <pre><strong>Input:</strong> points = [[1,2,3],[1,5,1],[3,1,1]]
 * <strong>Output:</strong> 9
 * <strong>Explanation:</strong>
 * The blue cells denote the optimal cells to pick, which have coordinates (0, 2), (1, 1), and (2, 0).
 * You add 3 + 5 + 3 = 11 to your score.
 * However, you must subtract abs(2 - 1) + abs(1 - 0) = 2 from your score.
 * Your final score is 11 - 2 = 9.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/07/12/screenshot-2021-07-12-at-13-42-14-diagram-drawio-diagrams-net.png" style="width: 200px; height: 299px;">
 * <pre><strong>Input:</strong> points = [[1,5],[2,3],[4,2]]
 * <strong>Output:</strong> 11
 * <strong>Explanation:</strong>
 * The blue cells denote the optimal cells to pick, which have coordinates (0, 1), (1, 1), and (2, 0).
 * You add 5 + 3 + 4 = 12 to your score.
 * However, you must subtract abs(1 - 1) + abs(1 - 0) = 1 from your score.
 * Your final score is 12 - 1 = 11.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>m == points.length</code></li>
 * 	<li><code>n == points[r].length</code></li>
 * 	<li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>0 &lt;= points[r][c] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * </div>
 */
public class MaximumNumberOfPointsWithCost {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {1,5},
                {3,2},
                {4,2}
            },
            {
                {1,2,3},
                {1,5,1},
                {3,1,1}
            }
        };

        for (int[][] points : tests) {
            System.out.println(new MaximumNumberOfPointsWithCost_Solution().maxPoints(points));
        }
    }
}

// 5ms 83.45MB
class MaximumNumberOfPointsWithCost_Solution {
    public long maxPoints(int[][] points) {
        int row_len = points.length,
            col_len = points[0].length;
        long[] current = new long[col_len], 
               previous = new long[col_len];

        for (int i = 0; i < row_len; i++) {
            long peak = 0;
            for (int j = 0; j < col_len; j++) {
                peak = Math.max(peak - 1, previous[j]);
                current[j] = peak;
            }

            peak = 0;
            for (int j = col_len - 1; j >= 0; j--) {
                peak = Math.max(peak - 1, previous[j]);
                current[j] = Math.max(current[j], peak) + points[i][j];
            }
            previous = current;
        }

        long max = 0;
        for (long nums : previous) {
            max = Math.max(max, nums);
        }
            
        return max;
    }
}