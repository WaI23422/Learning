package Hard.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/number-of-ways-to-paint-n-3-grid/">1411. Number of Ways to Paint N × 3 Grid</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You have a <code>grid</code> of size <code>n x 3</code> and you want to paint each cell of the grid with exactly one of the three colors: <strong>Red</strong>, <strong>Yellow,</strong> or <strong>Green</strong> while making sure that no two adjacent cells have the same color (i.e., no two cells that share vertical or horizontal sides have the same color).</p>
 * 
 * <p>Given <code>n</code> the number of rows of the grid, return <em>the number of ways</em> you can paint this <code>grid</code>. As the answer may grow large, the answer <strong>must be</strong> computed modulo <code>10<sup>9</sup> + 7</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/03/26/e1.png" style="width: 400px; height: 257px;">
 * <pre><strong>Input:</strong> n = 1
 * <strong>Output:</strong> 12
 * <strong>Explanation:</strong> There are 12 possible way to paint the grid as shown.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 5000
 * <strong>Output:</strong> 30228214
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>n == grid.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 5000</code></li>
 * </ul>
 * </div>
 */
public class NumberOfWaysToPaintNX3Grid {
    public static void main(String[] args) {
        int[] tests = {
            5000,
            3,
            1,
        };

        for (int n : tests) {
            System.out.println(new NumberOfWaysToPaintNX3Grid_Solution().numOfWays(n));
        }
    }
}

// see BetterCodeAnswer.Hard.Number
class NumberOfWaysToPaintNX3Grid_Solution {
    public int numOfWays(int n) {
        long ans = 3;

        return (int) ans;
    }
}