package Medium.Array;

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

// 1ms 41.40MB
class MagicSquaresInGrid_Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0,
            height = grid.length,
            width = grid[0].length,
            submatrix_vertical = height - 2, 
            submatrix_horizontal = width - 2;

        if (height < 3 || width < 3) {return 0;}

        for (int i = 0; i < submatrix_vertical; i++) {
            for (int j = 0; j < submatrix_horizontal; j++) {
                if (isMagicSquare(grid, new int[]{i,j})) {
                    count++;
                }
            }
        }

        return count; 
    }

    private boolean isMagicSquare(int[][] grid, int[] start) {
        int arr[] = new int[8],
            row = start[0],
            col = start[1];
        boolean numsAppear[] = new boolean[10];

        numsAppear[0] = true;    
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[i+row][j+col];
                if (num > 9 || numsAppear[num]) {return false;}
                numsAppear[num] = true;

                arr[i] += num;
                arr[j+3] += num; 
                if (i == j) { 
                    arr[6]+= num; 
                    if (i == 1) {arr[7] += num;}
                }
                if (Math.abs(i-j) == 2) { arr[7] += num;}
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                return false;
            }
        }

        return true;
    }
}