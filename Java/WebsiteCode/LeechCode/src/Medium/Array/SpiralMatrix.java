package Medium.Array;

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
    // 40.18 MB
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> mat = new ArrayList<>();  
        int track = 0, dir =0, row = 0, col = 0, 
        rowAbove = 0,rowBelow= matrix.length-1, colLeft=0, colRight = matrix[0].length-1;

        if (colRight == 0) {
            for (int i = 0; i < matrix.length; i++) {
                mat.add(matrix[i][0]);
            }

            return mat;
        }

        while (track < matrix.length*matrix[0].length) {
            mat.add(matrix[row][col]);

            if (dir%4 == 0) {
                col++;
                if (col == colRight) {rowAbove++; dir++;}
            } else if (dir%4 == 1) {
                row++;
                if (row == rowBelow) {colRight--; dir++;}
            } else if (dir%4 == 2) {
                col--;
                if (col == colLeft) {rowBelow--; dir++;}
            } else {
                row--;
                if (row == rowAbove) {colLeft++; dir++;}
            }

            track++;
        }

        return mat;
    }
}