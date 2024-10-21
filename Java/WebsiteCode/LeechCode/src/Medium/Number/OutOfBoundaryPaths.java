package Medium.Number;

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

// Time Limit Exceeded
class OutOfBoundaryPaths_Solution {
    int total = 0, ROW, COLUMN;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        ROW = m-1; COLUMN = n-1;
        
        moves(maxMove, startRow, startColumn);

        return total;
    }

    public void moves(int moveLeft, int startRow, int startColumn) {
        if (startRow < 0 || startRow > ROW || startColumn < 0 || startColumn > COLUMN) {
            if (total == 1000000007) {total = 0 ;}

            total++;
        } else {
            if (moveLeft != 0) {
                moves(moveLeft-1, startRow-1, startColumn);
                moves(moveLeft-1, startRow+1, startColumn);
                moves(moveLeft-1, startRow, startColumn-1);
                moves(moveLeft-1, startRow, startColumn+1);
            }
        }
    }
}

// 11 ms 42.4 MB
class OutOfBoundaryPaths_Solution2 {
    public int findPaths(int m, int n, int N, int x, int y) {
        final int M = 1000000000 + 7;
        int[][] dp = new int[m][n];
        dp[x][y] = 1;
        int count = 0;

        for (int moves = 1; moves <= N; moves++) {
            int[][] temp = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == m - 1) count = (count + dp[i][j]) % M;
                    if (j == n - 1) count = (count + dp[i][j]) % M;
                    if (i == 0) count = (count + dp[i][j]) % M;
                    if (j == 0) count = (count + dp[i][j]) % M;
                    temp[i][j] = (
                            ((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % M +
                            ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) % M
                    ) % M;
                }
            }
            dp = temp;
        }

        return count;
    }
}

