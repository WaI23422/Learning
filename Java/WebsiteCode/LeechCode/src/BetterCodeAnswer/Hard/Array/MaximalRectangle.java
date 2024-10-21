package BetterCodeAnswer.Hard.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximal-rectangle/">85. Maximal Rectangle</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a <code>rows x cols</code>&nbsp;binary <code>matrix</code> filled with <code>0</code>'s and <code>1</code>'s, find the largest rectangle containing only <code>1</code>'s and return <em>its area</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/maximal.jpg" style="width: 402px; height: 322px;">
<pre><strong>Input:</strong> matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The maximal rectangle is shown in the above picture.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> matrix = [["0"]]
<strong>Output:</strong> 0
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> matrix = [["1"]]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>rows == matrix.length</code></li>
	<li><code>cols == matrix[i].length</code></li>
	<li><code>1 &lt;= row, cols &lt;= 200</code></li>
	<li><code>matrix[i][j]</code> is <code>'0'</code> or <code>'1'</code>.</li>
</ul>
</div>
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        char[][][] tests = {
            {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','0','1','1','1'},
                {'1','0','1','0','0'},
                {'1','0','1','0','0'},
            }
        };

        for (char[][] matrix : tests) {
            System.out.println(new MaximalRectangle_Solution().maximalRectangle(matrix));
        }
    }
}

class MaximalRectangle_Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        int[] leftBoundaries = new int[n];
        int[] rightBoundaries = new int[n];
        Arrays.fill(rightBoundaries, n);

        int maxRectangle = 0;

        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n;

            updateHeightsAndLeftBoundaries(matrix[i], heights, leftBoundaries, left);

            updateRightBoundaries(matrix[i], rightBoundaries, right);

            maxRectangle = calculateMaxRectangle(heights, leftBoundaries, rightBoundaries, maxRectangle);
        }

        return maxRectangle;
    }

    private void updateHeightsAndLeftBoundaries(char[] row, int[] heights, int[] leftBoundaries, int left) {
        for (int j = 0; j < heights.length; j++) {
            if (row[j] == '1') {
                heights[j]++;
                leftBoundaries[j] = Math.max(leftBoundaries[j], left);
            } else {
                heights[j] = 0;
                leftBoundaries[j] = 0;
                left = j + 1;
            }
        }
    }

    private void updateRightBoundaries(char[] row, int[] rightBoundaries, int right) {
        for (int j = rightBoundaries.length - 1; j >= 0; j--) {
            if (row[j] == '1') {
                rightBoundaries[j] = Math.min(rightBoundaries[j], right);
            } else {
                rightBoundaries[j] = right;
                right = j;
            }
        }
    }

    private int calculateMaxRectangle(int[] heights, int[] leftBoundaries, int[] rightBoundaries, int maxRectangle) {
        for (int j = 0; j < heights.length; j++) {
            int width = rightBoundaries[j] - leftBoundaries[j];
            int area = heights[j] * width;
            maxRectangle = Math.max(maxRectangle, area);
        }
        return maxRectangle;
    }
}