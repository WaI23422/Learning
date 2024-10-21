package BetterCodeAnswer.Hard.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/cherry-pickup-ii/">1463.Cherry Pickup II</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a <code>rows x cols</code> matrix <code>grid</code> representing a field of cherries where <code>grid[i][j]</code> represents the number of cherries that you can collect from the <code>(i, j)</code> cell.</p>

<p>You have two robots that can collect cherries for you:</p>

<ul>
	<li><strong>Robot #1</strong> is located at the <strong>top-left corner</strong> <code>(0, 0)</code>, and</li>
	<li><strong>Robot #2</strong> is located at the <strong>top-right corner</strong> <code>(0, cols - 1)</code>.</li>
</ul>

<p>Return <em>the maximum number of cherries collection using both robots by following the rules below</em>:</p>

<ul>
	<li>From a cell <code>(i, j)</code>, robots can move to cell <code>(i + 1, j - 1)</code>, <code>(i + 1, j)</code>, or <code>(i + 1, j + 1)</code>.</li>
	<li>When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.</li>
	<li>When both robots stay in the same cell, only one takes the cherries.</li>
	<li>Both robots cannot move outside of the grid at any moment.</li>
	<li>Both robots should reach the bottom row in <code>grid</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/04/29/sample_1_1802.png" style="width: 374px; height: 501px;">
<pre><strong>Input:</strong> grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
<strong>Output:</strong> 24
<strong>Explanation:</strong> Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
Total of cherries: 12 + 12 = 24.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/04/23/sample_2_1802.png" style="width: 500px; height: 452px;">
<pre><strong>Input:</strong> grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
<strong>Output:</strong> 28
<strong>Explanation:</strong> Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
Total of cherries: 17 + 11 = 28.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>rows == grid.length</code></li>
	<li><code>cols == grid[i].length</code></li>
	<li><code>2 &lt;= rows, cols &lt;= 70</code></li>
	<li><code>0 &lt;= grid[i][j] &lt;= 100</code></li>
</ul>
</div>
 */
public class CherryPickupII {
    public static void main(String[] args) {
        int[][][] tests = {
            {{3,1,1},{2,5,1},{1,5,5},{2,1,1}}
        };

        for (int[][] grid : tests) {
            System.out.println(new CherryPickupII_Solution().cherryPickup(grid));
        }
    }
}

// 16 ms 44.8 MB
class CherryPickupII_Solution {
    
    Integer memo[][][];
    
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        memo = new Integer[rows+1][cols+1][cols+1];
        return helper(grid, 0, 0, cols-1);
    }
    
    public int helper(int[][] grid, int currRow, int robotACol, int robotBCol) {
        
        if(robotACol < 0 || robotBCol < 0 || robotACol >= grid[0].length || robotBCol >= grid[0].length) return 0;
        
        if(currRow == grid.length) return 0;
        
        if(memo[currRow][robotACol][robotBCol] != null)
            return memo[currRow][robotACol][robotBCol];
        
        int result = 0;
        result += grid[currRow][robotACol];
        result += grid[currRow][robotBCol];
        
        int max = 0;
        for(int x=robotACol-1;x<=robotACol+1;x++) {
            for(int y=robotBCol-1;y<=robotBCol+1;y++) {
                if(x < y) { // they should not cross
                    max = Math.max(max, helper(grid, currRow+1, x, y));
                }
            }
        }
        
        result += max;
        return memo[currRow][robotACol][robotBCol] = result;
    }
}

// 16 ms 44.42 MB
class CherryPickupII_Solution2 {
    public int cherryPickup(int[][] grid) {
    int C = grid[0].length;
    int[][] dp = new int[C][C], old = new int[C][C];
    for(int r = grid.length - 1; r >= 0; r--) {
        for(int c1 = Math.min(r, C - 1); c1 >= 0; c1--) {
            for(int c2 = Math.max(c1, C - 1 - r); c2 < C; c2++) {
                int max = 0;
                for(int i = c1 - 1; i <= c1 + 1; i++) {
                    for(int j = c2 - 1; j <= c2 + 1; j++) {
                        if(i >= 0 && i < C && j >= 0 && j < C && i <= j) max = Math.max(max, old[i][j]);
                    }
                }
                dp[c1][c2] = max + grid[r][c1] + (c1 == c2 ? 0 : grid[r][c2]);
            }
        }
        int[][] temp = dp; dp = old; old = temp;
    }
    return old[0][C - 1];
}
}