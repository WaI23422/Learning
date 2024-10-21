package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/magic-squares-in-grid/">840. Magic Squares In Grid</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>A <code>3 x 3</code> <strong>magic square</strong> is a <code>3 x 3</code> grid filled with distinct numbers <strong>from </strong>1<strong> to </strong>9 such that each row, column, and both diagonals all have the same sum.</p>
 * 
 * <p>Given a <code>row x col</code> <code>grid</code> of integers, how many <code>3 x 3</code> contiguous magic square subgrids are there?</p>
 * 
 * <p>Note: while a magic square can only contain numbers from 1 to 9, <code>grid</code> may contain numbers up to 15.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/11/magic_main.jpg" style="width: 322px; height: 242px;">
 * <pre><strong>Input:</strong> grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
 * <strong>Output:</strong> 1
 * <strong>Explanation: </strong>
 * The following subgrid is a 3 x 3 magic square:
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/11/magic_valid.jpg" style="width: 242px; height: 242px;">
 * while this one is not:
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/11/magic_invalid.jpg" style="width: 242px; height: 242px;">
 * In total, there is only one magic square inside the given grid.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> grid = [[8]]
 * <strong>Output:</strong> 0
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>row == grid.length</code></li>
 * 	<li><code>col == grid[i].length</code></li>
 * 	<li><code>1 &lt;= row, col &lt;= 10</code></li>
 * 	<li><code>0 &lt;= grid[i][j] &lt;= 15</code></li>
 * </ul>
 * </div>
 */
public class MagicSquaresInGrid {
    public static void main(String[] args) {
        int[][][] tests = {
            {{4,3,8,4},{9,5,1,9},{2,7,6,2}}
        };

        for (int[][] grid : tests) {
            System.out.println(new MagicSquaresInGrid_Solution().numMagicSquaresInside(grid));
        }
    }
}

// 0ms 41.40MB
class MagicSquaresInGrid_Solution {

    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int row = 0; row + 2 < m; row++) {
            for (int col = 0; col + 2 < n; col++) {
                if (isMagicSquare(grid, row, col)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];
                if (num < 1 || num > 9) return false;
                if (seen[num]) return false;
                seen[num] = true;
            }
        }

        // check if diagonal sums are same value
        int diagonal1 =
            grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int diagonal2 =
            grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2];

        if (diagonal1 != diagonal2) return false;

        // check if all row sums share the same value as the diagonal sums
        int row1 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        int row2 =
            grid[row + 1][col] +
            grid[row + 1][col + 1] +
            grid[row + 1][col + 2];
        int row3 =
            grid[row + 2][col] +
            grid[row + 2][col + 1] +
            grid[row + 2][col + 2];

        if (!(row1 == diagonal1 && row2 == diagonal1 && row3 == diagonal1)) {
            return false;
        }

        // check if all column sums share same value as the diagonal sums
        int col1 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
        int col2 =
            grid[row][col + 1] +
            grid[row + 1][col + 1] +
            grid[row + 2][col + 1];
        int col3 =
            grid[row][col + 2] +
            grid[row + 1][col + 2] +
            grid[row + 2][col + 2];

        if (!(col1 == diagonal1 && col2 == diagonal1 && col3 == diagonal2)) {
            return false;
        }

        return true;
    }
}