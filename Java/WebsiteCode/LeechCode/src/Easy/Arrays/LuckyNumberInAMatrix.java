package Easy.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/lucky-numbers-in-a-matrix/">1380. Lucky Numbers in a Matrix</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an <code>m x n</code> matrix of <strong>distinct </strong>numbers, return <em>all <strong>lucky numbers</strong> in the matrix in <strong>any </strong>order</em>.</p>
 * 
 * <p>A <strong>lucky number</strong> is an element of the matrix such that it is the minimum element in its row and maximum in its column.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * <strong>Output:</strong> [15]
 * <strong>Explanation:</strong> 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * <strong>Output:</strong> [12]
 * <strong>Explanation:</strong> 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> matrix = [[7,8],[1,2]]
 * <strong>Output:</strong> [7]
 * <strong>Explanation:</strong> 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>m == mat.length</code></li>
 * 	<li><code>n == mat[i].length</code></li>
 * 	<li><code>1 &lt;= n, m &lt;= 50</code></li>
 * 	<li><code>1 &lt;= matrix[i][j] &lt;= 10<sup>5</sup></code>.</li>
 * 	<li>All elements in the matrix are distinct.</li>
 * </ul>
 * </div>
 */
public class LuckyNumberInAMatrix {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {3,7,8},
                {9,11,13},
                {15,16,17}
            },
            {
                {1,10,4,2},
                {9,3,8,7},
                {15,16,17,12}
            },
        };

        for (int[][] matrix : tests) {
            System.out.println(new LuckyNumberInAMatrix_Solution().luckyNumbers(matrix));
        }
    }
}

// Brute-Force: 2ms 45.13MB
class LuckyNumberInAMatrix_Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int minCol[] = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int temp_idx = 0,
                min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                int num = matrix[i][j];
                if (min > num) {
                    min = num;
                    temp_idx = j;
                }
            }
            minCol[temp_idx] = (minCol[temp_idx] > min) && (minCol[temp_idx] != 0) ? minCol[temp_idx] : min;
        }

        for (int i = 0; i < matrix[0].length; i++) {
            int num = minCol[i];
            if (num == 0) {continue;}
            
            for (int j = 0; j < matrix.length; j++) {
                int matrix_num = matrix[j][i];
                if (num < matrix_num) {
                    minCol[i] = 0;
                }    
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int num : minCol) {
            if (num!=0) {
                res.add(num);
            }
        }

        return res;
    }
}

// 3ms 45.20MB -> 3ms 45.10MB
class LuckyNumberInAMatrix_Solution2 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int minCol[] = new int[matrix[0].length],
            maxCol[] = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int temp_idx = 0,
                min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                int num = matrix[i][j];
                if (min > num) {
                    min = num;
                    temp_idx = j;
                }
                maxCol[j] = Math.max(maxCol[j], num);
            }
            minCol[temp_idx] = (minCol[temp_idx] > min) && (minCol[temp_idx] != 0) ? minCol[temp_idx] : min;
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < maxCol.length; i++) {
            if (minCol[i] == 0) {continue;} // Add
            if (minCol[i] == maxCol[i]) {
                res.add(minCol[i]);
            }
        }

        return res;
    }
}