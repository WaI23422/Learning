package BetterCodeAnswer.Hard.Array;

import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/">1420.Build Array Where You Can Find The Maximum Exactly K Comparisons</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given three integers <code>n</code>, <code>m</code> and <code>k</code>. Consider the following algorithm to find the maximum element of an array of positive integers:</p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/04/02/e.png" style="width: 424px; height: 372px;">
<p>You should build the array arr which has the following properties:</p>

<ul>
	<li><code>arr</code> has exactly <code>n</code> integers.</li>
	<li><code>1 &lt;= arr[i] &lt;= m</code> where <code>(0 &lt;= i &lt; n)</code>.</li>
	<li>After applying the mentioned algorithm to <code>arr</code>, the value <code>search_cost</code> is equal to <code>k</code>.</li>
</ul>

<p>Return <em>the number of ways</em> to build the array <code>arr</code> under the mentioned conditions. As the answer may grow large, the answer <strong>must be</strong> computed modulo <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 2, m = 3, k = 1
<strong>Output:</strong> 6
<strong>Explanation:</strong> The possible arrays are [1, 1], [2, 1], [2, 2], [3, 1], [3, 2] [3, 3]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 5, m = 2, k = 3
<strong>Output:</strong> 0
<strong>Explanation:</strong> There are no possible arrays that satisify the mentioned conditions.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> n = 9, m = 1, k = 1
<strong>Output:</strong> 1
<strong>Explanation:</strong> The only possible array is [1, 1, 1, 1, 1, 1, 1, 1, 1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 50</code></li>
	<li><code>1 &lt;= m &lt;= 100</code></li>
	<li><code>0 &lt;= k &lt;= n</code></li>
</ul>
</div></div>
 */
public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons {
    public static void main(String[] args) {
        int n = 2, m=3,k= 1 ;
        BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons_Solution answer = new BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons_Solution();
 
        System.out.println(answer.numOfArrays(n, m, k));
    }
}

/**
 * <div class="FN9Jv WRmCx"><h1 id="approach">Approach</h1>

<ul>
<li>We are given three integers <code>n, m, and k</code>.</li>
<li>We need to find the number of ways to build an array <code>arr</code> of <code>n</code> positive integers, each ranging from 1 to <code>m</code>, such that the "search_cost" of the array is equal to <code>k</code>.</li>
<li>"Search_cost" is defined as the number of elements in the array that are greater than all the elements to their left.</li>
<li>We use dynamic programming to solve this problem, creating a 3D array <code>dp</code> to store intermediate results.</li>
<li><code>dp[i][cost][max_val]</code> represents the number of ways to build an array of length i+1 with a maximum value of <code>max_val+1</code> and a search cost of cost+1.</li>
<li>We initialize the base case where <code>i = 0</code>, and <code>cost = 0</code>, setting <code>dp[0][0][max_val]</code> to 1 for all possible <code>max_val</code>.</li>
<li>We iterate through the remaining values of <code>i</code>, <code>cost</code>, and <code>max_val</code>, calculating the number of ways to build the array based on the previous values in <code>dp</code>.</li>
<li>To calculate <code>dp[i][cost][max_val]</code>, we consider two cases:</li>
</ul>
<ol>
<li>Adding <code>max_val+1</code> as the maximum element to the array.</li>
<li>Not adding max_val+1 as the maximum element to the array.</li>
</ol>
<ul>
<li>We update <code>dp[i][cost][max_val]</code> accordingly and take care of the modulo operation to prevent overflow.</li>
<li>Finally, we sum up the values of <code>dp[n-1][k-1][max_val]</code> for all possible <code>max_val</code> to get the total number of arrays with the desired properties.</li>
<li>The result is returned as <code>(int) ans</code> after taking the modulo <code>10^9 + 7</code>.</li>
</ul>
<h1 id="complexity">Complexity</h1>
<ul>
<li>Time complexity: <code>O(n * m * k)</code></li>
</ul>

<ul>
<li>Space complexity: <code>O(n * k * m)</code></li>
</ul>  
 */
class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons_Solution {
    // 8 ms
    // 42.4 MB
    public int numOfArrays(int n, int m, int k) {
        long[][][] dp =new long[n][k][m];
        long mod = 1000000007;
        Arrays.fill(dp[0][0], 1);
        for (int i = 1;i<n;i++) {
            for (int cost = 0;cost <Math.min(i+1, k);cost++) {
                for (int max = 0;max < m;max++){
                    long sum = 0;
                    sum += dp[i-1][cost][max] * (max+1);
                    
                    if (cost != 0) {
                        long[] arr = dp[i-1][cost-1];
                        for (int prevMax = 0;prevMax < max; prevMax++) {
                            sum += arr[prevMax];
                        }
                    }
                    dp[i][cost][max] = sum %mod;
                }
            }
        }
        long ans = 0;
        for (int max = 0;max < m;max++) {
            ans += dp[n-1][k-1][max];
            ans %= mod;
        }
        return (int) ans;
    }
}

/**
 * <h1 id="intuition">Intuition</h1>
 * 
 * <p>Upon reading the problem, we're tasked with finding the number of arrays of length <code>n</code> with values in the range <code>[1, m]</code> such that the array has exactly <code>k</code>  cost. The challenge is not only in understanding what constitutes this cost but also in devising an efficient algorithm to count these arrays given the constraints.</p>
 * <h1 id="approach">Approach</h1>
 * <p>The problem can be tackled with dynamic programming, where we try to build the solution incrementally. We can break down the problem into sub-problems where we consider smaller arrays and try to determine the number of valid arrays we can form given a certain cost and maximum value.</p>
 * <p>We use the following states:</p>
 * <ul>
<li><code>i</code>: the length of the array.</li>
<li><code>maxNum</code>: the maximum number in the array.</li>
<li><code>cost</code>: the cost of the array.</li>
</ul>
<p>We define <code>dp[i][maxNum][cost]</code> as the number of arrays of length <code>i</code> with a maximum value of <code>maxNum</code> and a cost of <code>cost</code>. To compute this, we consider two cases:</p>
<ol>
<li>The last number added to the array isn't a new maximum. In this case, it can be any number from 1 to <code>maxNum</code>, and the cost remains unchanged.</li>
<li>The last number added is a new maximum. Here, the previous maximum could be any number from 1 to <code>maxNum - 1</code>, and the cost decreases by 1 since we've added a new maximum.</li>
</ol>
<p>However, summing over possible maximums for each state would be inefficient. To accelerate this, we introduce a prefix sum array that keeps track of the sum of valid arrays for a given cost up to the current maximum.</p>
<h1 id="complexity">Complexity</h1>
<ul>
<li>
<p><strong>Time complexity:</strong> <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n×m×k)O(n \times m \times k)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">×</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6667em; vertical-align: -0.0833em;"></span><span class="mord mathnormal">m</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">×</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.03148em;">k</span><span class="mclose">)</span></span></span></span></span><br>
The main loop iterates <code>n</code> times. For each iteration, we consider <code>m</code> possible maximum values and <code>k</code> possible costs, making the time complexity cubic.</p>
</li>
<li>
<p><strong>Space complexity:</strong> <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(m×k)O(m \times k)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">m</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">×</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.03148em;">k</span><span class="mclose">)</span></span></span></span></span><br>
We use two 2D arrays, <code>dp</code> and <code>prefix</code>, each of size <span class="math math-inline"><span class="katex"><span class="katex-mathml">m×km \times k</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6667em; vertical-align: -0.0833em;"></span><span class="mord mathnormal">m</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">×</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6944em;"></span><span class="mord mathnormal" style="margin-right: 0.03148em;">k</span></span></span></span></span>, and two other arrays, <code>prevDp</code> and <code>prevPrefix</code>, for storing the previous state. Hence, the space complexity is quadratic.</p>
</li>
</ul>
<h1 id="why-does-it-work">Why does it work?</h1>
<p>The approach works because at each stage we're considering all possible ways an array can be formed based on its last element. We're effectively breaking down the problem into smaller subproblems (smaller arrays) and using solutions to these subproblems to build solutions to larger ones.</p>
<h1 id="logic-behind-the-solution">Logic behind the solution</h1>
<p>The logic is rooted in dynamic programming, where we leverage previously computed results to avoid redundant computations. The introduction of the prefix sum array is a common optimization technique in dynamic programming to quickly sum up results from prior states.</p>
<h1 id="naive-vs-optimized-version">Naive vs. Optimized version</h1>
<p>The naive approach would involve brute-forcing every possible array, calculating the cost for each one, and checking if it matches the desired cost. This approach would be factorial in time complexity and thus infeasible.</p>
<p>Our current solution, on the other hand, is much more optimized. It avoids redundant calculations by storing and reusing prior results in the <code>dp</code> and <code>prefix</code> tables.</p>
<h1 id="what-we-learned">What we learned?</h1>
<ul>
<li>
<p><strong>Problem Decomposition:</strong> We learned how to break down a seemingly complex problem into smaller, more manageable subproblems.</p>
</li>
<li>
<p><strong>Dynamic Programming:</strong> This problem reinforced the utility of dynamic programming in solving problems where subproblems overlap.</p>
</li>
<li>
<p><strong>Optimization:</strong> The use of prefix sums showcased how to optimize certain operations in dynamic programming to improve efficiency.</p>
</li>
</ul>
 */
class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons_Solution2 {
    public int numOfArrays(int n, int m, int k) {
        final int mod = 1000000007;

        int[][] dp = new int[m+1][k+1];
        int[][] prefix = new int[m+1][k+1];
        int[][] prevDp = new int[m+1][k+1];
        int[][] prevPrefix = new int[m+1][k+1];

        for (int j = 1; j <= m; j++) {
            prevDp[j][1] = 1;
            prevPrefix[j][1] = j;
        }

        for (int i = 2; i <= n; i++) {
            for (int maxNum = 1; maxNum <= m; maxNum++) {
                for (int cost = 1; cost <= k; cost++) {
                    dp[maxNum][cost] = (int)(((long)maxNum * prevDp[maxNum][cost]) % mod);

                    if (maxNum > 1 && cost > 1) {
                        dp[maxNum][cost] = (dp[maxNum][cost] + prevPrefix[maxNum - 1][cost - 1]) % mod;
                    }

                    prefix[maxNum][cost] = (prefix[maxNum - 1][cost] + dp[maxNum][cost]) % mod;
                }
            }

            for (int j = 1; j <= m; j++) {
                System.arraycopy(dp[j], 0, prevDp[j], 0, k+1);
                System.arraycopy(prefix[j], 0, prevPrefix[j], 0, k+1);
            }
        }

        return prefix[m][k];
    }
}