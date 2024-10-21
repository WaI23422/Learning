package BetterCodeAnswer.Hard.Array;

import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/painting-the-walls/">2742.Painting the Walls</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given two <strong>0-indexed</strong> integer arrays,&nbsp;<code>cost</code> and <code>time</code>, of size <code>n</code> representing the costs and the time taken to paint <code>n</code> different walls respectively. There are two painters available:</p>

<ul>
	<li>A<strong>&nbsp;paid painter</strong>&nbsp;that paints the <code>i<sup>th</sup></code> wall in <code>time[i]</code> units of time and takes <code>cost[i]</code> units of money.</li>
	<li>A<strong>&nbsp;free painter</strong> that paints&nbsp;<strong>any</strong> wall in <code>1</code> unit of time at a cost of <code>0</code>. But the&nbsp;free painter can only be used if the paid painter is already <strong>occupied</strong>.</li>
</ul>

<p>Return <em>the minimum amount of money required to paint the </em><code>n</code><em>&nbsp;walls.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> cost = [1,2,3,2], time = [1,2,3,2]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The walls at index 0 and 1 will be painted by the paid painter, and it will take 3 units of time; meanwhile, the free painter will paint the walls at index 2 and 3, free of cost in 2 units of time. Thus, the total cost is 1 + 2 = 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> cost = [2,3,4,2], time = [1,1,1,1]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The walls at index 0 and 3 will be painted by the paid painter, and it will take 2 units of time; meanwhile, the free painter will paint the walls at index 1 and 2, free of cost in 2 units of time. Thus, the total cost is 2 + 2 = 4.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= cost.length &lt;= 500</code></li>
	<li><code>cost.length == time.length</code></li>
	<li><code>1 &lt;= cost[i] &lt;= 10<sup>6</sup></code></li>
	<li><code>1 &lt;= time[i] &lt;= 500</code></li>
</ul>
</div></div>
 */
public class PaintingTheWalls {
    public static void main(String[] args) {
        int[] cost = {1,3,2,2};
        int[] time = {1,3,0,1};
        PaintingTheWalls_Solution result = new PaintingTheWalls_Solution();

        System.out.println(result.paintWalls(cost, time));
    }
}

/**
 * <h4 id="approach-1-top-down-dynamic-programming">Approach 1: Top-Down Dynamic Programming</h4>
 * 
 * <p><strong>Intuition</strong></p>
 * <blockquote>
<p><strong>Note.</strong> For this approach, we assume that you already know the fundamentals of dynamic programming and are figuring out how to apply it to a wide range of problems, such as this one. If you are not yet at this stage, we recommend checking out our relevant <a href="https://leetcode.com/explore/featured/card/dynamic-programming/" target="_blank">Explore Card content on dynamic programming</a> before coming back to this problem.</p>
</blockquote>
<p>Intuitively, we want to put the paid painter on walls that cost less and take longer to paint. The longer the paid painter paints, the more we can make use of the free painter. It seems extremely difficult to formulate a greedy approach since decisions will cascade on top of each other. Which walls do we pay for? Which walls do we have the free painter paint?</p>
<p>Given the constraints <span class="math math-inline"><span class="katex"><span class="katex-mathml">n≤500n \leq 500</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.7719em; vertical-align: -0.136em;"></span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">≤</span><span class="mspace" style="margin-right: 0.2778em;"></span></span><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">500</span></span></span></span></span>, we should try a dynamic programming approach, which will consider all possible decisions.</p>
<p>This is a variation of the classic knapsack problem. The <span class="math math-inline"><span class="katex"><span class="katex-mathml">ithi^{th}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8491em;"></span><span class="mord"><span class="mord mathnormal">i</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8491em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">t</span><span class="mord mathnormal mtight">h</span></span></span></span></span></span></span></span></span></span></span></span></span> item costs <span class="math math-inline"><span class="katex"><span class="katex-mathml">cost[i]\text{cost[i]}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord text"><span class="mord">cost[i]</span></span></span></span></span></span> and paints <span class="math math-inline"><span class="katex"><span class="katex-mathml">1+time[i]1 + \text{time[i]}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.7278em; vertical-align: -0.0833em;"></span><span class="mord">1</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord text"><span class="mord">time[i]</span></span></span></span></span></span> walls. We need to paint <span class="math math-inline"><span class="katex"><span class="katex-mathml">nn</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">n</span></span></span></span></span> walls while minimizing the total cost.</p>
<p>Let <code>dp(i, remain)</code> be a function that returns the minimum cost to paint <code>remain</code> walls when considering index <code>i</code> and beyond. We have two base cases here.</p>
<ol>
<li>If <code>remain &lt;= 0</code>, we have painted all the walls. We can <code>return 0</code>.</li>
<li>If <code>i == n</code>, we have run out of walls to put the paid painter on and the task is impossible. We return a large value like infinity.</li>
</ol>
<p>Now, how do we calculate a given state <code>(i, remain)</code>? For the <span class="math math-inline"><span class="katex"><span class="katex-mathml">ithi^{th}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8491em;"></span><span class="mord"><span class="mord mathnormal">i</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8491em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">t</span><span class="mord mathnormal mtight">h</span></span></span></span></span></span></span></span></span></span></span></span></span> wall, we have two options. We can either hire the paid painter for this wall or not hire them.</p>
<ol>
<li>If we hire them, as mentioned above, we spend <code>cost[i]</code> and paint <code>1 + time[i]</code> walls. Then, we move to the next index. Thus, the cost of this option is <code>cost[i] + dp(i + 1, remain - 1 - time[i])</code>.</li>
<li>If we don't hire them, we simply move to the next index. The cost of this option is <code>dp(i + 1, remain)</code>.</li>
</ol><p>Let's call the first option <code>paint</code> and the second option <code>dontPaint</code>. Then, <code>dp(i, remain) = min(paint, dontPaint)</code>.</p>
<p>This recursive approach is correct, but has an exponential time complexity because each <code>dp</code> call creates two more <code>dp</code> calls, some of which may have already been calculated. We must memoize our function to avoid repeated computation:</p>
<p><img src="../Figures/2742/1.png" alt="memoization"><br>
<br></p>
<p>In the above image, states in color are calculated multiple times. In Java/C++, we will use a <code>memo</code> table to cache results. In Python, we will use <a href="https://docs.python.org/3/library/functools.html#functools.cache" target="_blank">@functools.cache</a> to memoize our function.</p>
<p>The solution to the original problem will be <code>dp(0, n)</code>. We consider all walls starting from index <code>0</code> and beyond, and we need to paint a total of <code>n</code> walls.</p>
<p><strong>Algorithm</strong></p><ol>
<li>Let <code>n = cost.length</code>.</li>
<li>Define a memoized function <code>dp(i, remain)</code>:
<ul>
<li>If <code>remain &lt;= 0</code>, then <code>return 0</code>.</li>
<li>If <code>i == n</code>, then return a very large value.</li>
<li>Set <code>paint = cost[i] + dp(i + 1, remain - 1 - time[i])</code>.</li>
<li>Set <code>dontPaint = dp(i + 1, remain)</code>.</li>
<li>Return <code>min(paint, dontPaint)</code>.</li>
</ul>
</li>
<li>Return <code>dp(0, n)</code>.</li>
</ol>
 */
class PaintingTheWalls_Solution {
    int[][] memo;
    int n;
    
    // 44 ms
    // 44.8 MB
    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        memo = new int[n][n + 1];
        return dp(0, n, cost, time);
    }
    
    public int dp(int i, int remain, int[] cost, int[] time) {
        if (remain <= 0) {
            return 0;
        }
        
        if (i == n) {
            return (int) 1e9;
        }
        
        if (memo[i][remain] != 0) {
            return memo[i][remain];
        }
        
        int paint = cost[i] + dp(i + 1, remain - 1 - time[i], cost, time);
        int dontPaint = dp(i + 1, remain, cost, time);
        memo[i][remain] = Math.min(paint, dontPaint);
        return memo[i][remain];
    }
}

/**
 * <h4 id="approach-3-space-optimized-dynamic-programming">Approach 3: Space-Optimized Dynamic Programming</h4>
 * <p><strong>Intuition</strong></p>
 * <p>Notice that the recurrence relation to calculate <code>dp[i][remain]</code> only depends on <code>dp[i + 1]</code>. For example, when calculating <code>dp[7][remain]</code>, we only need the value from <code>dp[8]</code> and no longer care about values in <code>dp[9], dp[10], dp[11]</code> etc.</p>
 * <p>We only need extra space to track the <code>remain</code> dimension. We can replace our <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n2)O(n^2)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.0641em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord"><span class="mord mathnormal">n</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8141em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">2</span></span></span></span></span></span></span></span><span class="mclose">)</span></span></span></span></span> table with two arrays of length <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n)O(n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span>. One array will represent <code>dp[i]</code> and the other one will represent <code>dp[i + 1]</code>.</p>
 * <p>Let's call the table that represents <code>dp[i + 1]</code> <code>prevDp</code>. When we finish calculating <code>dp[i]</code>, we can set <code>prevDp = dp</code>. Then when we move to the next value of <code>i</code>, <code>prevDp</code> will correctly represent <code>dp[i + 1]</code> for the new value of <code>i</code>. For example:</p>
 * <ul>
<li>When <code>i = 10</code>, <code>prevDp</code> is analogous to <code>dp[11]</code> from the previous approach, and <code>dp</code> is analogous to <code>dp[10]</code>. We calculate <code>dp</code>, then update <code>prevDp = dp</code>.</li>
<li>When <code>i = 9</code>, <code>prevDp</code> is analogous to <code>dp[10]</code> from the previous approach. Notice that we made this happen by updating <code>prevDp</code> in the last step. We calculate <code>dp</code>, analogous to <code>dp[9]</code>, and update <code>prevDp</code> again when finished.</li>
<li>When <code>i = 8</code>, <code>prevDp</code> is analogous to <code>dp[9]</code>, and so on...</li>
</ul>
<p>The first value of <code>i</code> we iterate on is <code>n - 1</code>. Thus, <code>prevDp</code> initially represents <code>dp[n]</code>, which is one of our base cases - all values should be a large value like infinity, except <code>prevDp[0] = 0</code>, which is our other base case (<code>remain = 0</code>).</p>
<p><strong>Algorithm</strong></p>
<ol>
<li>Let <code>n = cost.length</code>.</li>
<li>Initialize arrays:
<ul>
<li><code>dp</code> of length <code>n + 1</code> with values set to <code>0</code>.</li>
<li><code>prevDp</code> of length <code>n + 1</code>. Set <code>prevDp[0] = 0</code> and all other values to a large value.</li>
</ul>
</li>
<li>Iterate <code>i</code> from <code>n - 1</code> until <code>0</code>:
<ul>
<li>Reset the values of <code>dp</code>.</li>
<li>Iterate <code>remain</code> from <code>1</code> until <code>n</code>:
<ul>
<li>Set <code>paint = cost[i] + prevDp[max(0, remain - 1 - time[i])]</code>.</li>
<li>Set <code>dontPaint = prevDp[remain]</code>.</li>
<li>Set <code>dp[remain] = min(paint, dontPaint)</code>.</li>
</ul>
</li>
<li>Set <code>prevDp = dp</code>.</li>
</ul>
</li>
<li>Return <code>dp[n]</code>.</li>
</ol>
 */
class PaintingTheWalls_Solution2 {
    // 10 ms
    // 43.8 MB
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            dp[n][i] = (int) 1e9;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int remain = 1; remain <= n; remain++) {
                int paint = cost[i] + dp[i + 1][Math.max(0, remain - 1 - time[i])];
                int dontPaint = dp[i + 1][remain];
                dp[i][remain] = Math.min(paint, dontPaint);
            }
        }
        
        return dp[0][n];
    }
}

class PaintingTheWalls_Solution3 {
    // 6 ms
    // 43.4 MB
	public static int paintWalls(int[] cost, int[] time) {
		int n = cost.length;
		int[] minMoney = new int[n + 1];
		Arrays.fill(minMoney, 1, n + 1, Integer.MAX_VALUE - (int) 1e6);
		for (int i = 0; i < n; i++) {
			int c = cost[i];
			int t = time[i] + 1;
			int j = n;
			for (; j > t; j--)
				minMoney[j] = Math.min(minMoney[j], c + minMoney[j - t]);
			for (; j > 0; j--)
				minMoney[j] = Math.min(minMoney[j], c);
		}
		return minMoney[n];
	}
}