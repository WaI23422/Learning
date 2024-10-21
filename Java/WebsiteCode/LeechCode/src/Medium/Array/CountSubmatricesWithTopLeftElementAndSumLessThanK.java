package Medium.Array;

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

// 5ms 117.76MB
class CountSubmatricesWithTopLeftElementAndSumLessThanK_Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int count = 0,
            rowLen = grid.length,
            colLen = grid[0].length;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int above = i - 1 < 0 ? 0 : grid[i-1][j],
                    left = j - 1 < 0 ? 0 : grid[i][j-1],
                    dig = i-1 < 0 || j-1 < 0 ? 0 : grid[i-1][j-1];
                
                grid[i][j] += above + left - dig;
                
                if (grid[i][j] <= k) {
                    count++;
                } else { 
                    break; // 6ms 117.76MB -> 5ms 117.76MB
                }
            }
        }

        return count;
    }
}