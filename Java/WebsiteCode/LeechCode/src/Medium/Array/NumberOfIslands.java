package Medium.Array;

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

// 4 ms 49.5 MB
class NumberOfIslands_Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] isHas = new boolean[grid.length][grid[0].length];

        for (int r = 0; r < isHas.length; r++) {
            for (int c = 0; c < isHas[0].length; c++) {
                if (isHas[r][c] == false && grid[r][c] == '1') {
                    count++;
                    nextNum(isHas,grid, r-1, c);
                    nextNum(isHas,grid, r, c-1);
                    nextNum(isHas,grid, r+1, c);
                    nextNum(isHas,grid, r, c+1);
                }
            }
        }
    
        return count;
    }

    private void nextNum(boolean[][] arr,char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= arr.length || c >= arr[0].length || arr[r][c] == true || grid[r][c] == '0') {return;}

        arr[r][c] = true;
        nextNum(arr,grid, r-1, c);
        nextNum(arr,grid, r, c-1);
        nextNum(arr,grid, r+1, c);
        nextNum(arr,grid, r, c+1);
    }
}


