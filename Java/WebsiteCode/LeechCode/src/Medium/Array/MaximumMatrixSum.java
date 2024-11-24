package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximum-matrix-sum/">1975. Maximum Matrix Sum</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given an <code>n x n</code> integer <code>matrix</code>. You can do the following operation <strong>any</strong> number of times:</p>
 * 
 * <ul>
 * 	<li>Choose any two <strong>adjacent</strong> elements of <code>matrix</code> and <strong>multiply</strong> each of them by <code>-1</code>.</li>
 * </ul>
 * 
 * <p>Two elements are considered <strong>adjacent</strong> if and only if they share a <strong>border</strong>.</p>
 * 
 * <p>Your goal is to <strong>maximize</strong> the summation of the matrix's elements. Return <em>the <strong>maximum</strong> sum of the matrix's elements using the operation mentioned above.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/07/16/pc79-q2ex1.png" style="width: 401px; height: 81px;">
 * <pre><strong>Input:</strong> matrix = [[1,-1],[-1,1]]
 * <strong>Output:</strong> 4
 * <b>Explanation:</b> We can follow the following steps to reach sum equals 4:
 * - Multiply the 2 elements in the first row by -1.
 * - Multiply the 2 elements in the first column by -1.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/07/16/pc79-q2ex2.png" style="width: 321px; height: 121px;">
 * <pre><strong>Input:</strong> matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
 * <strong>Output:</strong> 16
 * <b>Explanation:</b> We can follow the following step to reach sum equals 16:
 * - Multiply the 2 last elements in the second row by -1.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>n == matrix.length == matrix[i].length</code></li>
 * 	<li><code>2 &lt;= n &lt;= 250</code></li>
 * 	<li><code>-10<sup>5</sup> &lt;= matrix[i][j] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * </div></div>
 */
public class MaximumMatrixSum {
    public static void main(String[] args) {
        int[][][] tests = { 
            {{2,9,3},{5,4,-4},{1,7,1}},
            {{1,-1},{-1,1}},
        };

        for (int[][] matrix : tests) {
            System.out.println(new MaximumMatrixSum_Solution().maxMatrixSum(matrix));
        }
    }
}

// 5ms 55.02MB 
class MaximumMatrixSum_Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;

        int row_len = matrix.length,
            col_len = matrix[0].length,
            min = Integer.MAX_VALUE,
            neg_val = 0;

        for (int row = 0; row < row_len; row++) {
            for (int col = 0; col < col_len; col++) {
                int num = matrix[row][col];

                if (num <= 0) {
                    num = Math.abs(num);
                    neg_val++;
                }

                min = Math.min(num, min);
                sum += num;
            }
        }

        return neg_val%2==0 ? sum : sum - min*2;
    }
}