package Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/flip-columns-for-maximum-number-of-equal-rows/">1072. Flip Columns For Maximum Number of Equal Rows</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given an <code>m x n</code> binary matrix <code>matrix</code>.</p>
 * 
 * <p>You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from <code>0</code> to <code>1</code> or vice versa).</p>
 * 
 * <p>Return <em>the maximum number of rows that have all values equal after some number of flips</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> matrix = [[0,1],[1,1]]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> After flipping no values, 1 row has all values equal.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> matrix = [[0,1],[1,0]]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> After flipping values in the first column, both rows have equal values.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> matrix = [[0,0,0],[0,0,1],[1,1,0]]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> After flipping values in the first two columns, the last two rows have equal values.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>m == matrix.length</code></li>
 * 	<li><code>n == matrix[i].length</code></li>
 * 	<li><code>1 &lt;= m, n &lt;= 300</code></li>
 * 	<li><code>matrix[i][j]</code> is either&nbsp;<code>0</code> or <code>1</code>.</li>
 * </ul>
 * </div></div>
 */
public class FlipColumnsForMaximumNumberOfEqualRows {
    public static void main(String[] args) {
        
    }
}

// 27ms 60.5MB
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int row_len = matrix.length,
            col_len = matrix[0].length,
            total_same_num_rows[][][] = new int[row_len][2][col_len];
        boolean checked[] = new boolean[row_len];

        for (int row = 0; row < row_len; row++) {
            int zero_totals[] = new int[col_len],
                one_totals[] = new int[col_len];
            for (int col = 0; col < col_len; col++) {
                if (matrix[row][col] == 1) {
                    one_totals[col]++;
                } else {
                    zero_totals[col]++;
                }
            }
            total_same_num_rows[row][0] = zero_totals;
            total_same_num_rows[row][1] = one_totals;
        }

        int max_row_same_value = 0;
        for (int col = 0; col < row_len; col++) {
            int one_totals[] = total_same_num_rows[col][1],
                zero_totals[] = total_same_num_rows[col][0],
                row_same_value = 1;
            for (int col_ = col+1; col_ < checked.length; col_++) {
                if (checked[col_]) {continue;}
                
                if (
                    Arrays.compare(one_totals,total_same_num_rows[col_][0]) == 0 ||
                    (Arrays.compare(zero_totals,total_same_num_rows[col_][0]) == 0 || Arrays.compare(one_totals,total_same_num_rows[col_][1]) == 0)
                ) {
                    row_same_value++;
                    checked[col_] = true;
                } 
            }

            max_row_same_value = Math.max(max_row_same_value, row_same_value);
        }

        return max_row_same_value;
    }
}