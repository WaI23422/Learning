package BetterCodeAnswer.Medium.ListNode;

import Medium.ListNode.Class.ListNode;
import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/spiral-matrix-iv/">2326. Spiral Matrix IV</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given two integers <code>m</code> and <code>n</code>, which represent the dimensions of a matrix.</p>
 *
 *<p>You are also given the <code>head</code> of a linked list of integers.</p>
 *
 *<p>Generate an <code>m x n</code> matrix that contains the integers in the linked list presented in <strong>spiral</strong> order <strong>(clockwise)</strong>, starting from the <strong>top-left</strong> of the matrix. If there are remaining empty spaces, fill them with <code>-1</code>.</p>
 *
 *<p>Return <em>the generated matrix</em>.</p>
 *
 *<p>&nbsp;</p>
 *<p><strong class="example">Example 1:</strong></p>
 *<img alt="" src="https://assets.leetcode.com/uploads/2022/05/09/ex1new.jpg" style="width: 240px; height: 150px;">
 *<pre><strong>Input:</strong> m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
 *<strong>Output:</strong> [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
 *<strong>Explanation:</strong> The diagram above shows how the values are printed in the matrix.
 *Note that the remaining spaces in the matrix are filled with -1.
 *</pre>
 *
 *<p><strong class="example">Example 2:</strong></p>
 *<img alt="" src="https://assets.leetcode.com/uploads/2022/05/11/ex2.jpg" style="width: 221px; height: 60px;">
 *<pre><strong>Input:</strong> m = 1, n = 4, head = [0,1,2]
 *<strong>Output:</strong> [[0,1,2,-1]]
 *<strong>Explanation:</strong> The diagram above shows how the values are printed from left to right in the matrix.
 *The last space in the matrix is set to -1.</pre>
 *
 *<p>&nbsp;</p>
 *<p><strong>Constraints:</strong></p>
 *
 *<ul>
 *	<li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
 *	<li><code>1 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
 *	<li>The number of nodes in the list is in the range <code>[1, m * n]</code>.</li>
 *	<li><code>0 &lt;= Node.val &lt;= 1000</code></li>
 *</ul>
 *</div>
 */
public class SpiralMatrixIV {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {3,5},
                {3,0,2,6,8,1,7,9,4,2,5,5,0}
            }
        };

        for (int[][] test : tests) {
            int m = test[0][0],
                n = test[0][1];
            ListNode head = ListNode.addNode(test[1]);

            int[][] ans = new SpiralMatrixIV_Solution().spiralMatrix(m, n, head);

            for (int[] row : ans) {
                System.out.println(Arrays.toString(row));
            }
        }
    }
}

// 5ms 56.80MB
class SpiralMatrixIV_Solution {
    public int[][] spiralMatrix(int rows, int columns, ListNode head) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = new int [columns];
            Arrays.fill(matrix[i], -1);
        }

        int topRow = 0, bottomRow = rows - 1, leftColumn = 0, rightColumn = columns - 1;
        while (head != null) {
        
            for (int col = leftColumn; col <= rightColumn && head != null; col++) {
                matrix[topRow][col] = head.val;
                head = head.next;
            }
            topRow++;

        
            for (int row = topRow; row <= bottomRow && head != null; row++) {
                matrix[row][rightColumn] = head.val;
                head = head.next;
            }
            rightColumn--;

 
            for (int col = rightColumn; col >= leftColumn && head != null; col--) {
                matrix[bottomRow][col] = head.val;
                head = head.next;
            }
            bottomRow--;

       
            for (int row = bottomRow; row >= topRow && head != null; row--) {
                matrix[row][leftColumn] = head.val;
                head = head.next;
            }
            leftColumn++;
        }

        return matrix;
    }
}

// 13ms 56.81MB
class SpiralMatrixIV_Solution2 {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        // Store the east, south, west, north movements in a matrix.
        int i = 0, j = 0, cur_d = 0, movement[][] = {
            { 0, 1 },
            { 1, 0 },
            { 0, -1 },
            { -1, 0 },
        };
        int[][] res = new int[m][n];
        for (int[] row : res) {
            Arrays.fill(row, -1);
        }

        while (head != null) {
            res[i][j] = head.val;
            int newi = i + movement[cur_d][0], newj = j + movement[cur_d][1];

            // If we bump into an edge or an already filled cell, change the
            // direction.
            if (
                Math.min(newi, newj) < 0 ||
                newi >= m ||
                newj >= n ||
                res[newi][newj] != -1
            ) cur_d = (cur_d + 1) % 4;
            i += movement[cur_d][0];
            j += movement[cur_d][1];

            head = head.next;
        }

        return res;
    }
}