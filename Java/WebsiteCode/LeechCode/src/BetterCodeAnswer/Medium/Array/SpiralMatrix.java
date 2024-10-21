package BetterCodeAnswer.Medium.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/spiral-matrix/">54.Spiral Matrix</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an <code>m x n</code> <code>matrix</code>, return <em>all elements of the</em> <code>matrix</code> <em>in spiral order</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiral1.jpg" style="width: 242px; height: 242px;">
<pre><strong>Input:</strong> matrix = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> [1,2,3,6,9,8,7,4,5]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiral.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
<strong>Output:</strong> [1,2,3,4,8,12,11,10,9,5,6,7]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 10</code></li>
	<li><code>-100 &lt;= matrix[i][j] &lt;= 100</code></li>
</ul>
</div></div>
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,3},
            {4,5,6},
            {7,8,9}},
            {{1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}},
            {{1,2},
            {4,3}},
            {{1}},
            {{1,2}},
            {{3},
            {2}}
        };
        
        SpiralMatrix_Solution res = new SpiralMatrix_Solution();

        for (int[][] matrix : tests) {
            System.out.println(res.spiralOrder(matrix).toString());
        }
    }
}

class SpiralMatrix_Solution {
    // 0 ms 
    // 40.1 MB
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix[0] == null) {
            throw new IllegalArgumentException("Invalid matrix");
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxLayer = Math.min(rows / 2, cols / 2);
        List<Integer> order = new ArrayList<>();

        for (int layer = 0; layer < maxLayer; layer++) {
            int top = layer;
            int bottom = rows - 1 - layer;
            int left = layer;
            int right = cols - 1 - layer;

            // add top elements
            for (int c = left; c < right; c++) {
                order.add(matrix[top][c]);
            }

            // add right elements
            for (int r = top; r < bottom; r++) {
                order.add(matrix[r][right]);
            }

            // add bottom elements
            for (int c =  right; c > left; c--) {
                order.add(matrix[bottom][c]);
            }

            // add left elements
            for (int r = bottom; r > top; r--) {
                order.add(matrix[r][left]);
            }
        }

        if (cols >= rows && rows % 2 == 1) {
            int left = maxLayer;
            int right = cols - 1 - maxLayer;
            int r = rows / 2;
            for (int c = left; c <= right; c++) {
                order.add(matrix[r][c]);
            }
        } else if (rows > cols && cols % 2 == 1) {
            int top = maxLayer;
            int bottom = rows - 1 - maxLayer;
            int c = cols / 2;
            for (int r = top; r <= bottom; r++) {
                order.add(matrix[r][c]);
            }
        }

        return order;
    }
}