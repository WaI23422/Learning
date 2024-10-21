package BetterCodeAnswer.Hard.Number;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/">1269.Number of Ways to Stay in the Same Place After Some Steps</a>
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You have a pointer at index <code>0</code> in an array of size <code>arrLen</code>. At each step, you can move 1 position to the left, 1 position to the right in the array, or stay in the same place (The pointer should not be placed outside the array at any time).</p>

<p>Given two integers <code>steps</code> and <code>arrLen</code>, return the number of ways such that your pointer is still at index <code>0</code> after <strong>exactly</strong> <code>steps</code> steps. Since the answer may be too large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> steps = 3, arrLen = 2
<strong>Output:</strong> 4
<strong>Explanation: </strong>There are 4 differents ways to stay at index 0 after 3 steps.
Right, Left, Stay
Stay, Right, Left
Right, Stay, Left
Stay, Stay, Stay
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> steps = 2, arrLen = 4
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are 2 differents ways to stay at index 0 after 2 steps
Right, Left
Stay, Stay
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> steps = 4, arrLen = 2
<strong>Output:</strong> 8
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= steps &lt;= 500</code></li>
	<li><code>1 &lt;= arrLen &lt;= 10<sup>6</sup></code></li>
</ul>
</div></div>
 */
public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    public static void main(String[] args) {
        int steps = 10,arrLen = 3;

        NumberOfWaysToStayInTheSamePlaceAfterSomeSteps_Solution result = new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps_Solution();

        System.out.println(result.numWays(steps, arrLen));
    } 
}   

/**
 *<h1 id="space-optimized-dynamic-programming-">Space-Optimized Dynamic Programming 🚀</h1>
 <h5 id="in-this-approach-you-can-use-a-2d-dp-array-to-store-the-number-of-ways-to-reach-each-index-at-each-step-since-you-only-need-the-values-for-the-current-step-and-the-previous-step-you-can-maintain-a-2xarrlen-dp-array-and-update-it-iteratively">In this approach, you can use a 2D DP array to store the number of ways to reach each index at each step. Since you only need the values for the current step and the previous step, you can maintain a 2xarrLen DP array and update it iteratively.</h5>
 */
class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps_Solution {
    // 9 ms
    // 39.5 MB
    public int numWays(int steps, int arrLen) {
        final int MOD = 1000000007;

        int maxIndex = Math.min(steps / 2, arrLen - 1);

        int[][] dp = new int[2][maxIndex + 1];
        dp[0][0] = 1;

        for (int step = 1; step <= steps; step++) {
            int current = step % 2;
            int prev = (step - 1) % 2;

            for (int index = 0; index <= maxIndex; index++) {
                dp[current][index] = dp[prev][index] % MOD;

                if (index > 0) {
                    dp[current][index] = (dp[current][index] + dp[prev][index - 1]) % MOD;
                }

                if (index < maxIndex) {
                    dp[current][index] = (dp[current][index] + dp[prev][index + 1]) % MOD;
                }
            }
        }

        return dp[steps % 2][0];
    }
}

/** 
 * <h1 id="bottom-up-dynamic-programming-">Bottom-Up Dynamic Programming 🚀</h1>
 * <h5 id="1-initialize-m-to-be-the-number-of-steps-and-n-to-be-the-minimum-of-steps--2--1-and-arrlen-this-is-done-to-ensure-that-you-dont-go-beyond-the-array-bounds">1. Initialize <code>m</code> to be the number of steps and <code>n</code> to be the minimum of <code>steps // 2 + 1</code> and <code>arrLen</code>. This is done to ensure that you don't go beyond the array bounds.</h5>
 * <h5 id="2--create-a-2d-array-dp-of-size-m--1-x-n-and-initialize-it-with-zeros-this-array-will-store-the-number-of-ways-to-reach-each-index-after-a-certain-number-of-steps">2.  Create a 2D array <code>dp</code> of size <code>(m + 1) x n</code> and initialize it with zeros. This array will store the number of ways to reach each index after a certain number of steps.</h5>
 * <h5 id="3-set-dp00-to-1-which-represents-the-starting-position-of-the-pointer">3. Set <code>dp[0][0]</code> to 1, which represents the starting position of the pointer.</h5>
 * <h5 id="4-iterate-through-i-from-1-to-m-representing-the-number-of-steps-taken-for-each-i-iterate-through-j-from-0-to-n-1-representing-the-current-index">4. Iterate through <code>i</code> from 1 to <code>m</code>, representing the number of steps taken. For each <code>i</code>, iterate through <code>j</code> from 0 to <code>n-1</code>, representing the current index.</h5>
 * <h5 id="5-for-each-i-j-pair-update-dpij-based-on-three-cases">5. For each <code>(i, j)</code> pair, update <code>dp[i][j]</code> based on three cases:</h5>
 * <ul>
<li>
<h6 id="if-j--0-you-can-move-one-position-to-the-left-so-add-dpi-1j-1-to-dpij">If <code>j &gt; 0</code>, you can move one position to the left, so add <code>dp[i-1][j-1]</code> to <code>dp[i][j]</code>.</h6>
</li>
<li>
<h6 id="if-j--n---1-you-can-move-one-position-to-the-right-so-add-dpi-1j1-to-dpij">If <code>j &lt; n - 1</code>, you can move one position to the right, so add <code>dp[i-1][j+1]</code> to <code>dp[i][j]</code>.</h6>
</li>
<li>
<h6 id="you-can-stay-in-the-same-place-so-add-dpi-1j-to-dpij">You can stay in the same place, so add <code>dp[i-1][j]</code> to <code>dp[i][j]</code>.</h6>
</li>
</ul>
<h5 id="6-finally-return-dpm0-modulo-109--7-which-represents-the-number-of-ways-to-stay-at-index-0-after-exactly-steps-steps">6. Finally, return <code>dp[m][0]</code> modulo 10^9 + 7, which represents the number of ways to stay at index 0 after exactly <code>steps</code> steps.</h5>

*/
class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps_Solution2 {
    // 9 ms 
    // 42.6 MB
    public int numWays(int steps, int arrLen) {
        int m = steps;
        int n = Math.min(steps / 2 + 1, arrLen);
        
        int[][] dp = new int[m + 1][n];
        dp[0][0] = 1;
        
        int mod = 1000000007;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
                if (j < n - 1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        
        return dp[m][0];
    }
}