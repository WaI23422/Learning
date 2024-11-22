package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

// 5ms 59.5MB
class FlipColumnsForMaximumNumberOfEqualRows_Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(matrix[i][m-1] ==1){
                for(int j=0; j<m;j++){
                    matrix[i][j] ^=matrix[i][m-1];
                }
            }
            res = Math.max(res, map.merge(Arrays.hashCode(matrix[i]), 1, Integer::sum));
            
        }
        return res;
    }
}