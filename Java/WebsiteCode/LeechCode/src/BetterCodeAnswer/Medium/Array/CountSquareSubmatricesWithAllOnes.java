package BetterCodeAnswer.Medium.Array;

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

// 5ms 56.36MB
class CountSquareSubmatricesWithAllOnes_Solution {
    public int countSquares(int[][] matrix) {
        int rowSize  = matrix.length;
        int colSize = matrix[0].length;

        for(int i = 1; i < rowSize; i++)
        {
            for(int j = 1; j < colSize; j++)
            {
                if(matrix[i][j] == 1)
                    matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i][j - 1]));
            }
        }

        int total = 0;
        for(int i = 0; i < rowSize; i++)
        {
            for(int j = 0; j < colSize; j++)
            {
                total += matrix[i][j];
            }
        }

        return total;
    }
}

// 6ms 56.36MB
class CountSquareSubmatricesWithAllOnes_Solution2 {

    public int countSquares(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    dp[i + 1][j + 1] = Math.min(
                        Math.min(dp[i][j + 1], dp[i + 1][j]),
                        dp[i][j]
                    ) +
                    1;
                    ans += dp[i + 1][j + 1];
                }
            }
        }
        return ans;
    }
}