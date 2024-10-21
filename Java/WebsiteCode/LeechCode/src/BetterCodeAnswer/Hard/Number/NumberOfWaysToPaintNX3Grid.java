package BetterCodeAnswer.Hard.Number;

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

// 2ms 40.54MB
/**
 * <strong>Explanation</strong>
 * <h1 id="explanation"><strong>Explanation</strong></h1>
 * <p>Two pattern for each row, 121 and 123.<br>
 * 121, the first color same as the third in a row.<br>
 * 123, one row has three different colors.</p>
 * <p>We consider the state of the first row,<br>
 * pattern 121: 121, 131, 212, 232, 313, 323.<br>
 * pattern 123: 123, 132, 213, 231, 312, 321.<br>
 * So we initialize <code>a121 = 6, a123 = 6</code>.</p>
 * <p>We consider the next possible for each pattern:<br>
 * Patter 121 can be followed by: 212, 213, 232, 312, 313<br>
 * Patter 123 can be followed by: 212, 231, 312, 232</p>
 * <p>121 =&gt; three 121, two 123<br>
 * 123 =&gt; two 121, two 123</p>
 * <p>So we can write this dynamic programming transform equation:<br>
 * <code>b121 = a121 * 3 + a123 * 2</code><br>
 * <code>b123 = a121 * 2 + a123 * 2</code></p>
 * <p>We calculate the result iteratively<br>
 * and finally return the sum of both pattern <code>a121 + a123</code><br>
 * <br></p>
 */
class NumberOfWaysToPaintNX3Grid_Solution {
    public int numOfWays(int n) {
        long a121 = 6, a123 = 6, b121, b123, mod = (long)1e9 + 7;
        for (int i = 1; i < n; ++i) {
            b121 = a121 * 3 + a123 * 2;
            b123 = a121 * 2 + a123 * 2;
            a121 = b121 % mod;
            a123 = b123 % mod;
        }
        return (int)((a121 + a123) % mod);
    }
}

// 0ms 40.6MB
class NumberOfWaysToPaintNX3Grid_Solution2 {
    public static int[] a = new int[5001];
    public static int[] b = new int[5001];
    public static int cur = 2;
    public static final int mod = 1000000007;
    static {
        a[1] = 6;
        b[1] = 6;
    }
    public int numOfWays(int n) {
        if (a[n] != 0) return (a[n] + b[n]) % mod;
        while (cur <= n) {
            a[cur] = ((2 * a[cur -1]) % mod + (2 * b[cur -1]) % mod) % mod;
            b[cur] = (a[cur] + b[cur -1]) % mod;
            cur++;
        } 
        return (a[n] + b[n]) % mod;     
    }
}