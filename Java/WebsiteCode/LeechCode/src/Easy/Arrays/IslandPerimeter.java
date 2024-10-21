package Easy.Arrays;


/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/island-perimeter/">463. Island Perimeter</a>
 * <div class="elfjS" data-track-load="description_content"><p>You are given <code>row x col</code> <code>grid</code> representing a map where <code>grid[i][j] = 1</code> represents&nbsp;land and <code>grid[i][j] = 0</code> represents water.</p>

<p>Grid cells are connected <strong>horizontally/vertically</strong> (not diagonally). The <code>grid</code> is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).</p>

<p>The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img src="https://assets.leetcode.com/uploads/2018/10/12/island.png" style="width: 221px; height: 213px;">
<pre><strong>Input:</strong> grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
<strong>Output:</strong> 16
<strong>Explanation:</strong> The perimeter is the 16 yellow stripes in the image above.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> grid = [[1]]
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> grid = [[1,0]]
<strong>Output:</strong> 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>row == grid.length</code></li>
	<li><code>col == grid[i].length</code></li>
	<li><code>1 &lt;= row, col &lt;= 100</code></li>
	<li><code>grid[i][j]</code> is <code>0</code> or <code>1</code>.</li>
	<li>There is exactly one island in <code>grid</code>.</li>
</ul>
</div>
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        int[][][] tests = {
            {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}},
            {{0,1}},
            {{1}}
        };

        for (int[][] grid : tests) {
            System.out.println(new IslandPerimeter_Solution().islandPerimeter(grid));
        }
    }
}

// 4 ms 46 MB
class IslandPerimeter_Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    perimeter += 4 - intersectOf(grid,r,c)*2;
                }
            }
        }

        return perimeter;
    }

    private int intersectOf(int[][] grid, int r, int c) {
        if (r - 1 < 0 && c - 1 < 0) {return 0;}
        
        if (r-1 < 0) {return grid[r][c-1];}
        if (c-1 < 0) {return grid[r-1][c];}

        return grid[r-1][c] + grid[r][c-1];
    }
}
