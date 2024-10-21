package Hard.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-number-of-days-to-disconnect-island/">1568. Minimum Number of Days to Disconnect Island</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an <code>m x n</code> binary grid <code>grid</code> where <code>1</code> represents land and <code>0</code> represents water. An <strong>island</strong> is a maximal <strong>4-directionally</strong> (horizontal or vertical) connected group of <code>1</code>'s.</p>
 * 
 * <p>The grid is said to be <strong>connected</strong> if we have <strong>exactly one island</strong>, otherwise is said <strong>disconnected</strong>.</p>
 * 
 * <p>In one day, we are allowed to change <strong>any </strong>single land cell <code>(1)</code> into a water cell <code>(0)</code>.</p>
 * 
 * <p>Return <em>the minimum number of days to disconnect the grid</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/12/24/land1.jpg" style="width: 500px; height: 169px;">
 * <pre><strong>Input:</strong> grid = [[0,1,1,0],[0,1,1,0],[0,0,0,0]]
 * 
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> We need at least 2 days to get a disconnected grid.
 * Change land grid[1][1] and grid[0][2] to water and get 2 disconnected island.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/12/24/land2.jpg" style="width: 404px; height: 85px;">
 * <pre><strong>Input:</strong> grid = [[1,1]]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> Grid of full water is also disconnected ([[1,1]] -&gt; [[0,0]]), 0 islands.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>m == grid.length</code></li>
 * 	<li><code>n == grid[i].length</code></li>
 * 	<li><code>1 &lt;= m, n &lt;= 30</code></li>
 * 	<li><code>grid[i][j]</code> is either <code>0</code> or <code>1</code>.</li>
 * </ul>
 * </div>
 */
public class MinimumNumberOfDaysToDisconnectIsland {
    public static void main(String[] args) {
        int[][][] tests = {
            {{0,1,1},{1,1,1},{1,1,0}},
            {{1,1,1,0},{1,1,1,1},{1,0,1,1},{1,1,1,1},{0,1,1,1}},
            {{1,1,0,1,1},{1,1,1,1,1},{1,1,0,1,1},{1,1,1,1,1}},
            {{1,1,1,1,0,1,1,1,1},{1,1,1,1,0,1,1,1,1},{0,0,0,1,0,1,0,0,0},{1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1}},
            {{1,1}},
            {{0,1,1,0},{0,1,1,0},{0,0,0,0}},
        };
    
        for (int[][] grid : tests) {
            for (int[] land  : grid) {
                System.out.println(Arrays.toString(land));
            }
            System.out.println(new MinimumNumberOfDaysToDisconnectIsland_Solution().minDays(grid));
        }
    }
}

// 49ms 45.07MB
class MinimumNumberOfDaysToDisconnectIsland_Solution {
    public int minDays(int[][] grid) {
        if (countIslands(grid) != 1) return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (countIslands(grid) != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    private int countIslands(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !seen[i][j]) {
                    islands++;
                    dfs(grid, i, j, seen);
                }
            }
        }
        return islands;
    }

    private void dfs(int[][] grid, int r, int c, boolean[][] seen) {
        seen[r][c] = true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1 && !seen[nr][nc]) {
                dfs(grid, nr, nc, seen);
            }
        }
    }
}