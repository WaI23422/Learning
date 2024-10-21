package BetterCodeAnswer.Medium.Number;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/out-of-boundary-paths/">576.Out of Boundary Paths</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There is an <code>m x n</code> grid with a ball. The ball is initially at the position <code>[startRow, startColumn]</code>. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply <strong>at most</strong> <code>maxMove</code> moves to the ball.</p>

<p>Given the five integers <code>m</code>, <code>n</code>, <code>maxMove</code>, <code>startRow</code>, <code>startColumn</code>, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/28/out_of_boundary_paths_1.png" style="width: 500px; height: 296px;">
<pre><strong>Input:</strong> m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
<strong>Output:</strong> 6
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/04/28/out_of_boundary_paths_2.png" style="width: 500px; height: 293px;">
<pre><strong>Input:</strong> m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
<strong>Output:</strong> 12
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= m, n &lt;= 50</code></li>
	<li><code>0 &lt;= maxMove &lt;= 50</code></li>
	<li><code>0 &lt;= startRow &lt; m</code></li>
	<li><code>0 &lt;= startColumn &lt; n</code></li>
</ul>
</div>
 */
public class OutOfBoundaryPaths {
    public static void main(String[] args) {
        int[][] tests = {
            {2,2,2,0,0},
            {1,3,3,0,1}
        };

        for (int[] test : tests) {
            int m = test[0], n = test[1], maxMove = test[2], startRow = test[3], startColumn = test[4];

            System.out.println(new OutOfBoundaryPaths_Solution().findPaths(m, n, maxMove, startRow, startColumn));
        }
    }
}

// 2 ms 42.1 MB
class OutOfBoundaryPaths_Solution {
    Integer[][][] dp;
    int mod = 1_000_000_000+7;
    int m, n;
    public int findPaths(int m, int n, int maxMove, int x, int y) {
        dp = new Integer[m][n][maxMove+1];
        this.m=m;
        this.n=n;
        return helper(maxMove, x, y);
    }

    int helper(int maxMove, int x, int y){
        if(x<0 || x>=m || y<0 || y>=n)return 1;
        if(maxMove<=0)return 0;
        if(dp[x][y][maxMove]!=null)return dp[x][y][maxMove];
        int res=0;
        res=(res+helper(maxMove-1, x+1, y))%mod;
        res=(res+helper(maxMove-1, x, y-1))%mod;
        res=(res+helper(maxMove-1, x-1, y))%mod;
        res=(res+helper(maxMove-1, x, y+1))%mod;
        dp[x][y][maxMove]=res;
        return res;

    }
}

// 3 ms 42.1 MB
class OutOfBoundaryPaths_Solution2 {
    
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    int MOD = 1000000007;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove+1];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                Arrays.fill(dp[i][j], - 1);
        int paths = dp(m, n, maxMove, startRow, startColumn, dp);
        return (paths % MOD);
    }
    
    public int dp(int m, int n, int maxMove, int cr, int cc, int[][][] dp){
        if(cr == m || cc == n || cr == -1 || cc == -1)
            return 1;
        
        if(maxMove==0)
            return 0;
        
        if(dp[cr][cc][maxMove] != -1){
            return dp[cr][cc][maxMove];
        }
        
        int paths = 0;
        
        for(int[] d : dir){
            int x = cr+d[0];
            int y = cc+d[1];
            paths += dp(m, n, maxMove-1, x, y, dp)  % MOD;
            paths %= MOD;
        }
        dp[cr][cc][maxMove] = paths ;
        return paths;
    }
}