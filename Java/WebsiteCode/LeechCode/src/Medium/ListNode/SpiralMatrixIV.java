package Medium.ListNode;

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

// 6ms 56.80MB
class SpiralMatrixIV_Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        
        int maxR = m-1,
            minR = 0,
            maxC = n-1,
            minC = 0,
            result[][] = new int[m][n];

        while (true) {
            // Right:
            for (int i = minC; i <= maxC; i++) {
                if (head != null) {
                    result[minR][i] = head.val;
                    head = head.next;
                } else {
                    result[minR][i] = -1;
                }
            }
            minR++;
            if (minR > maxR) {break;}

            // Down:
            for (int i = minR; i <= maxR; i++) {
                if (head != null) {
                    result[i][maxC] = head.val;
                    head = head.next;
                } else {
                    result[i][maxC] = -1;
                }
            }
            maxC--;
            if (maxC < minC) {break;}

            // Left:
            for (int i = maxC; i >= minC; i--) {
                if (head != null) {
                    result[maxR][i] = head.val;
                    head = head.next;
                } else {
                    result[maxR][i] = -1;
                }
            }
            maxR--;
            if (minR > maxR) {break;}

            // Up:
            for (int i = maxR; i >= minR; i--) {
                if (head != null) {
                    result[i][minC] = head.val;
                    head = head.next;
                } else {
                    result[i][minC] = -1;
                }
            }
            minC++;
            if (maxC < minC) {break;}
        }

        return result;
    }
}