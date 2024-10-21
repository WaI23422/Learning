package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/number-of-islands/">200. Number of Islands</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an <code>m x n</code> 2D binary grid <code>grid</code> which represents a map of <code>'1'</code>s (land) and <code>'0'</code>s (water), return <em>the number of islands</em>.</p>

<p>An <strong>island</strong> is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
<strong>Output:</strong> 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 300</code></li>
	<li><code>grid[i][j]</code> is <code>'0'</code> or <code>'1'</code>.</li>
</ul>
</div>
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][][] tests = {
            {{'1'},
            {'1'}},
            {{'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','0'}},
            {{'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}},
            {{'1','1','1'},
            {'0','1','0'},
            {'1','1','1'},},
        };

        for (char[][] grid : tests) {
            System.out.println(new NumberOfIslands_Solution().numIslands(grid));
        }
    }
}

// 1 ms 49.5 MB
// Defines a class named Solution.
class NumberOfIslands_Solution {
    // Fields to store the number of rows and columns of the grid, and the count of islands.
    int rows;
    int cols;
    int islands = 0;
    
    // Method to count the number of islands in a 2D grid.
    public int numIslands(char[][] grid) {
        // Initialize rows and cols with the dimensions of the grid.
        rows = grid.length;
        cols = grid[0].length;
        // Loop through each row of the grid to perform check.
        for (int row = 0; row < rows; row++)
            check(grid, row);
        // Return the total count of islands found.
        return islands;
    }

    // Helper method to check each row of the grid.
    public void check(final char[][] grid, int row) {
        // Fetches the current row from the grid.
        final char[] finalRow = grid[row];
        // Iterate over each column in the row.
        for (int col = 0; col < cols; ++col)
            // If the current cell contains '1', it's part of an island.
            if (finalRow[col] == '1') {
                // Perform breadth-first search to mark all parts of the island.
                bfs(grid, row, col);
                // Increment the islands counter after marking a complete island.
                ++islands;
            }
    }

    // Method to perform breadth-first search to explore all parts of the island.
    public void bfs(char[][] grid, int row, int col) {
        // Mark the current cell so it won't be revisited.
        grid[row][col] = '*';
        // Recursively visit all adjacent cells that are part of the island ('1').
        if (row > 0 && grid[row - 1][col] == '1')
            bfs(grid, row - 1, col);
        if (row + 1 < rows && grid[row + 1][col] == '1')
            bfs(grid, row + 1, col);
        if (col > 0 && grid[row][col - 1] == '1')
            bfs(grid, row, col - 1);
        if (col + 1 < cols && grid[row][col + 1] == '1')
            bfs(grid, row, col + 1);
    }
}