package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/count-submatrices-with-top-left-element-and-sum-less-than-k/">3070. Count Submatrices with Top-Left Element and Sum Less Than k</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> integer matrix <code>grid</code> and an integer <code>k</code>.</p>
 * 
 * <p>Return <em>the <strong>number</strong> of <span data-keyword="submatrix" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:rp:"><div>submatrices</div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(199px, 252px);"></div></div></div></span> that contain the top-left element of the</em> <code>grid</code>, <em>and have a sum less than or equal to </em><code>k</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2024/01/01/example1.png" style="padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem;">
 * <pre><strong>Input:</strong> grid = [[7,6,3],[6,6,1]], k = 18
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> There are only 4 submatrices, shown in the image above, that contain the top-left element of grid, and have a sum less than or equal to 18.</pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2024/01/01/example21.png" style="padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem;">
 * <pre><strong>Input:</strong> grid = [[7,2,9],[1,5,0],[2,6,6]], k = 20
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> There are only 6 submatrices, shown in the image above, that contain the top-left element of grid, and have a sum less than or equal to 20.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>m == grid.length </code></li>
 * 	<li><code>n == grid[i].length</code></li>
 * 	<li><code>1 &lt;= n, m &lt;= 1000 </code></li>
 * 	<li><code>0 &lt;= grid[i][j] &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div>
 */
public class CountSubmatricesWithTopLeftElementAndSumLessThanK {
    public static void main(String[] args) {
        int[][][][] tests = {
            {
                {
                    {7,2,9},
                    {1,5,0},
                    {2,6,6}
                },
                {{20}}
            }
            ,
            {
                {
                    {7,6,3},
                    {6,6,1}
                }
                ,
                {{18}}
            }
        };

        for (int[][][] test : tests) {
            int grid[][] = test[0],
                k = test[1][0][0];

            System.out.println(new CountSubmatricesWithTopLeftElementAndSumLessThanK_Solution().countSubmatrices(grid, k));
        }
    }
}

// 4ms 142.76MB
class CountSubmatricesWithTopLeftElementAndSumLessThanK_Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int cnt = 0, n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        
        for(int i = 1; i < n; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        
        for(int i = 1; i < m; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + grid[i][j];                
            }    
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dp[i][j] <= k)
                    cnt++;
            }    
        }
        
        //System.out.println(Arrays.deepToString(dp));
        
        return cnt;
    }
}

// 2ms 117.76MB
class CountSubmatricesWithTopLeftElementAndSumLessThanK_Solution2 {
    public int countSubmatrices(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int[] u=new int[m];
        int c=0;
        for(int i=0;i<n;i++){
            int s=0;
            for(int j=0;j<m;j++){
               s+=grid[i][j];
               u[j]+=s;
               if(u[j]<=k) c++;
            }
        }
        return c;
    }
}