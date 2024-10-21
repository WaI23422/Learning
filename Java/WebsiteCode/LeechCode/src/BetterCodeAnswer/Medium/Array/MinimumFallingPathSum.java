package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-falling-path-sum/">931.Minimum Falling Path Sum</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an <code>n x n</code> array of integers <code>matrix</code>, return <em>the <strong>minimum sum</strong> of any <strong>falling path</strong> through</em> <code>matrix</code>.</p>

<p>A <strong>falling path</strong> starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position <code>(row, col)</code> will be <code>(row + 1, col - 1)</code>, <code>(row + 1, col)</code>, or <code>(row + 1, col + 1)</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/11/03/failing1-grid.jpg" style="width: 499px; height: 500px;">
<pre><strong>Input:</strong> matrix = [[2,1,3],[6,5,4],[7,8,9]]
<strong>Output:</strong> 13
<strong>Explanation:</strong> There are two falling paths with a minimum sum as shown.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/11/03/failing2-grid.jpg" style="width: 164px; height: 365px;">
<pre><strong>Input:</strong> matrix = [[-19,57],[-40,-5]]
<strong>Output:</strong> -59
<strong>Explanation:</strong> The falling path with a minimum sum is shown.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == matrix.length == matrix[i].length</code></li>
	<li><code>1 &lt;= n &lt;= 100</code></li>
	<li><code>-100 &lt;= matrix[i][j] &lt;= 100</code></li>
</ul>
</div>
 */
public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][][] tests = {
            {{2,1,3},{6,5,4},{7,8,9}},
            {{-19,57},{-40,-5}},
        };

        for (int[][] matrix : tests) {
            System.out.println(new MinimumFallingPathSum_Solution().minFallingPathSum(matrix));
        }
    }
}

// 1 ms 45.2 MB
class MinimumFallingPathSum_Solution {
    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        if (m == 1 || n == 1) return A[0][0];

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; ++i) {
            ans = Math.min(ans, minFallingPathSum(A, 0, i, dp));
        }

        return ans;
    }

    private int minFallingPathSum(int[][] A, int row, int col, int[][] dp) {
        int m = A.length;
        int n = A[0].length;

        if (dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        if (row == m - 1)
            return dp[row][col] = A[row][col];

        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

        if (col > 0)
            left = minFallingPathSum(A, row + 1, col - 1, dp);

        int straight = minFallingPathSum(A, row + 1, col, dp);

        if (col < n - 1)
            right = minFallingPathSum(A, row + 1, col + 1, dp);

        dp[row][col] = Math.min(left, Math.min(straight, right)) + A[row][col];

        return dp[row][col];
    }
}

// 0 ms 44.7 MB
class MinimumFallingPathSum_Solution2 {
    public void minSum(int[][] mat, int n, int r)
    {
        if(r < 0)
            return;
        for(int i = 0; i < n; i++)
        {
            int nextMin = mat[r + 1][i] + mat[r][i];
            if(i > 0)
                nextMin = Math.min(nextMin, mat[r + 1][i - 1] + mat[r][i]);
            if(i < n - 1)
                nextMin = Math.min(nextMin, mat[r + 1][i + 1] + mat[r][i]);
            mat[r][i] = nextMin;
        }
        minSum(mat, n, r - 1);
    }
    
    public int minFallingPathSum(int[][] matrix)
    {
        int n = matrix.length;
        minSum(matrix, n, n - 2);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
        {
            if(ans>matrix[0][i])
              ans=matrix[0][i];
        }
        return ans;
    }
}