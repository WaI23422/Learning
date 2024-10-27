package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/count-square-submatrices-with-all-ones/">1277. Count Square Submatrices with All Ones</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given a <code>m * n</code> matrix of ones and zeros, return how many <strong>square</strong> submatrices have all ones.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> matrix =
 * [
 * &nbsp; [0,1,1,1],
 * &nbsp; [1,1,1,1],
 * &nbsp; [0,1,1,1]
 * ]
 * <strong>Output:</strong> 15
 * <strong>Explanation:</strong> 
 * There are <strong>10</strong> squares of side 1.
 * There are <strong>4</strong> squares of side 2.
 * There is  <strong>1</strong> square of side 3.
 * Total number of squares = 10 + 4 + 1 = <strong>15</strong>.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> matrix = 
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * <strong>Output:</strong> 7
 * <strong>Explanation:</strong> 
 * There are <b>6</b> squares of side 1.  
 * There is <strong>1</strong> square of side 2. 
 * Total number of squares = 6 + 1 = <b>7</b>.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= arr.length&nbsp;&lt;= 300</code></li>
 * 	<li><code>1 &lt;= arr[0].length&nbsp;&lt;= 300</code></li>
 * 	<li><code>0 &lt;= arr[i][j] &lt;= 1</code></li>
 * </ul>
 * </div></div>
 */
public class CountSquareSubmatricesWithAllOnes {
    public static void main(String[] args) {
        int[][][] tests = {
            {{0,1,1,1},{1,1,1,1},{0,1,1,1}},
            {
                {1,0,1},
                {1,1,0},
                {1,1,0}
            }
        };

        for (int[][] matrix : tests) {
            System.out.println(new CountSquareSubmatricesWithAllOnes_Solution().countSquares(matrix));
        }
    }
}

// 6ms 56.36MB
class CountSquareSubmatricesWithAllOnes_Solution {
    int count;

    public int countSquares(int[][] matrix) {
        final int ROW_LEN = matrix.length,
                  COL_LEN = matrix[0].length;
        count = 0; 

        for (int i = 0; i < ROW_LEN; i++) {
            for (int j = 0; j < COL_LEN; j++) {
                if (matrix[i][j] == 1) {
                    count += maxSquare(matrix,ROW_LEN,COL_LEN,i,j,1);
                }
            }
        }

        return count;
    }

    private int maxSquare(int[][] matrix, int ROW_LEN, int COL_LEN, int row_idx, int col_idx, int size) {
        int row_limit = row_idx+size,
            col_limit = col_idx+size;
        if (row_limit >= ROW_LEN || col_limit >= COL_LEN) {
            return size;
        }
        for (int i = row_idx; i <= row_limit; i++) {
            for (int j = col_idx; j <= col_limit; j++) {
                if (matrix[i][j] == 0) {return size;}
                count++;
            }
        }

        return maxSquare(matrix, ROW_LEN, COL_LEN, row_idx, col_idx, size+1);
    }
}