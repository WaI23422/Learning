package BetterCodeAnswer.Hard.Array;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/max-dot-product-of-two-subsequences/">1458.Max Dot Product of Two Subsequences</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given two arrays <code>nums1</code>&nbsp;and <code><font face="monospace">nums2</font></code><font face="monospace">.</font></p>

<p>Return the maximum dot product&nbsp;between&nbsp;<strong>non-empty</strong> subsequences of nums1 and nums2 with the same length.</p>

<p>A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie,&nbsp;<code>[2,3,5]</code>&nbsp;is a subsequence of&nbsp;<code>[1,2,3,4,5]</code>&nbsp;while <code>[1,5,3]</code>&nbsp;is not).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums1 = [2,1,-2,5], nums2 = [3,0,-6]
<strong>Output:</strong> 18
<strong>Explanation:</strong> Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
Their dot product is (2*3 + (-2)*(-6)) = 18.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums1 = [3,-2], nums2 = [2,-6,7]
<strong>Output:</strong> 21
<strong>Explanation:</strong> Take subsequence [3] from nums1 and subsequence [7] from nums2.
Their dot product is (3*7) = 21.</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums1 = [-1,-1], nums2 = [1,1]
<strong>Output:</strong> -1
<strong>Explanation: </strong>Take subsequence [-1] from nums1 and subsequence [1] from nums2.
Their dot product is -1.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 500</code></li>
	<li><code>-1000 &lt;= nums1[i], nums2[i] &lt;= 1000</code></li>
</ul>
</div></div>
 */
public class MaxDotProductOfTwoSubsequences {
    public static void main(String[] args) {
        int[] nums1 = {2,1,-2,5};
        int[] nums2 = {3,0,-6};

        MaxDotProductOfTwoSubsequences_Solution result = new MaxDotProductOfTwoSubsequences_Solution();

        System.out.println(result.maxDotProduct(nums1, nums2));
    }
}

/**
 * <h4 id="approach-1-top-down-dynamic-programming">Approach 1: Top-Down Dynamic Programming</h4>
 * 
 * <p><strong>Intuition</strong></p>
 * <blockquote>
<p><strong>Note.</strong> For this approach, we assume that you already know the fundamentals of dynamic programming and are figuring out how to apply it to a wide range of problems, such as this one. If you are not yet at this stage, we recommend checking out our relevant <a href="https://leetcode.com/explore/featured/card/dynamic-programming/" target="_blank">Explore Card content on dynamic programming</a> before coming back to this problem.</p>
</blockquote>
<p>In this problem, we need to make decisions regarding which numbers to multiply with each other. If we use a pair of numbers, we cannot use them anymore in the future. We also must make the operations in a certain order. This is a perfect problem for dynamic programming because every decision we make will affect future decisions.</p>
<p>Let's define a function <code>dp(i, j)</code>. It will return the maximum dot product possible when considering:</p>
<ul>
<li>the suffix of <code>nums1</code> starting at index <code>i</code>.</li>
<li>the suffix of <code>nums2</code> starting at index <code>j</code>.</li>
</ul>
<p>The base case to this function is when <code>i == nums1.length</code> or <code>j == nums2.length</code>. In this case, one of the arrays has been exhausted and it is impossible to have any dot product. Thus, we will <code>return 0</code>.</p>
<p>Now, how do we calculate a given state <code>dp(i, j)</code>? There are 3 options at each state.</p>
<ol>
<li>We can multiply the numbers at <code>nums[i]</code> and <code>nums[j]</code> together. This will give us <code>nums1[i] * nums2[j]</code>, and then we move to the next indices. Thus, this option gives us a dot product of <code>nums1[i] * nums2[j] + dp(i + 1, j + 1)</code>.</li>
<li>We can move forward in <code>nums1</code>. This gives us a dot product of <code>dp(i + 1, j)</code>.</li>
<li>We can move forward in <code>nums2</code>. This gives us a dot product of <code>dp(i, j + 1)</code>.</li>
</ol>
<p>We should take the maximum of these three options.</p>
<blockquote>
<p>You may recognize this process - this problem is very similar to <a href="https://leetcode.com/problems/longest-common-subsequence/" target="_blank">Longest Common Subsequence</a>!</p>
</blockquote>
<p>This recursive solution will work, but it is inefficient because each call to <code>dp</code> generates 3 more calls to <code>dp</code>, resulting in an exponential time complexity. In the following image, each node represents a function call, and nodes of the same color denote repeated computation.</p>
<p><img src="https://leetcode.com/problems/max-dot-product-of-two-subsequences/Figures/1458/1.png" alt="memoization"><br>
<br></p>
<p>To solve this, we will use <strong>memoization</strong>. The first time we calculate a given state <code>(i, j)</code>, we will store the result. In the future, we can simply refer to this stored value instead of having to re-calculate the state.</p>
<p>We are still missing something! Notice that in the problem description, it states that we must have <strong>non-empty</strong> subsequences. What would happen if we had an input like this:</p>
<ul>
<li><code>nums1 = [-1, -4, -7]</code></li>
<li><code>nums2 = [6, 2, 52]</code></li>
</ul><p>When all the elements in <code>nums1</code> are negative and all the elements in <code>nums2</code> are positive (or vice-versa), and no matter what operation is performed we get a negative value, then we would prefer to not perform any operation and get 0! However, the problem forces us to do at least one operation. We should try to minimize the "damage" (maximize this negative value) by choosing the largest negative value and the smallest positive value (choose the element with the smallest absolute value from each array).</p>
<p><strong>Algorithm</strong></p>
<ol>
<li>Check the following special cases:
<ul>
<li>If <code>max(nums1) &lt; 0</code> and <code>min(nums2) &gt; 0</code>, then <code>return max(nums1) * min(nums2)</code>.</li>
<li>If <code>min(nums1) &gt; 0</code> and <code>max(nums2) &lt; 0</code>, then <code>return min(nums1) * max(nums2)</code>.</li>
</ul>
</li>
<li>Define a memoized function <code>dp(i, j)</code>:
<ul>
<li>If <code>i == nums1.length</code> or <code>j == nums2.length</code>, then <code>return 0</code>.</li>
<li>Set <code>use = nums1[i] * nums2[j] + dp(i + 1, j + 1)</code>. This is the dot product from using the current numbers.</li>
<li>Return the maximum of <code>use, dp(i + 1, j), dp(i, j + 1)</code>.</li>
</ul>
</li>
<li>Return <code>dp(0, 0)</code>, the answer to the original problem.</li>
</ol>
<p><strong>Complexity Analysis</strong></p>
<p>Given <span class="math math-inline"><span class="katex"><span class="katex-mathml">nn</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">n</span></span></span></span></span> as the length of <code>nums1</code> and <span class="math math-inline"><span class="katex"><span class="katex-mathml">mm</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">m</span></span></span></span></span> as the length of <code>nums2</code>,</p>
<ul>
<li>
<p>Time complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n⋅m)O(n \cdot m)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal">m</span><span class="mclose">)</span></span></span></span></span></p>
<p>Due to memoization, we only calculate each state <code>(i, j)</code> once. There are <span class="math math-inline"><span class="katex"><span class="katex-mathml">n⋅mn \cdot m</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4445em;"></span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">m</span></span></span></span></span> states of <code>(i, j)</code>. To calculate a state, we simply take the maximum of three options, which costs <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(1)O(1)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord">1</span><span class="mclose">)</span></span></span></span></span>.</p>
</li>
<li>
<p>Space complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n⋅m)O(n \cdot m)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal">m</span><span class="mclose">)</span></span></span></span></span></p>
<p>We memoize <code>dp</code>, which requires us to store the answer to <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n⋅m)O(n \cdot m)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal">m</span><span class="mclose">)</span></span></span></span></span> states.</p>
</li>
</ul>
 */
class MaxDotProductOfTwoSubsequences_Solution {
    int[][] memo;
    
    public int dp(int i, int j, int[] nums1, int[] nums2) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }
        
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        
        int use = nums1[i] * nums2[j] + dp(i + 1, j + 1, nums1, nums2);
        memo[i][j] = Math.max(use, Math.max(dp(i + 1, j, nums1, nums2), dp(i, j + 1, nums1, nums2)));
        return memo[i][j];
    }
    
    // 9 ms
    // 42.3 MB
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for (int num: nums1) {
            firstMax = Math.max(firstMax, num);
            firstMin = Math.min(firstMin, num);
        }
        
        for (int num: nums2) {
            secondMax = Math.max(secondMax, num);
            secondMin = Math.min(secondMin, num);
        }
        
        if (firstMax < 0 && secondMin > 0) {
            return firstMax * secondMin;
        }
        
        if (firstMin > 0 && secondMax < 0) {
            return firstMin * secondMax;
        }
        
        memo = new int[nums1.length][nums2.length];
        return dp(0, 0, nums1, nums2);
    }
}

/**
 * <h4 id="approach-2-bottom-up-dynamic-programming">Approach 2: Bottom-Up Dynamic Programming</h4>
 * 
 * <p><strong>Intuition</strong></p>
 * <p>In the previous approach, we used recursion to start at the answer state <code>(0, 0)</code> and we made calls toward the base cases. The same algorithm can be implemented iteratively.</p>
 * <p>In bottom-up, we will start at the base cases and iterate toward the answer state. We do this by using a nested for loop over the state variables. We will start iterating <code>i</code> from the base case (<code>i = nums1.length - 1</code>) and within that loop, we will iterate <code>j</code> starting from <code>nums2.length - 1</code>.</p>
 * <p>Each inner loop iteration represents a state, and we can calculate the state the same way we did in the previous approach. We keep a 2d array called <code>dp</code>. Note that here, <code>dp[i][j]</code> is equal to <code>dp(i, j)</code> from the previous approach.</p>
 * <p>We first consider using both the current numbers, resulting in <code>use = nums1[i] * nums2[j] + dp[i + 1][j + 1]</code>. Then, we consider skipping in both ways, resulting in <code>dp[i + 1][j]</code> and <code>dp[i][j + 1]</code>. We set <code>dp[i][j]</code> to the maximum of these three choices.</p>
 * <p>At the end, we simply return the value in <code>dp[0][0]</code>.</p>
 * <p><strong>Algorithm</strong></p>
 * <ol>
<li>Check the following special cases:
<ul>
<li>If <code>max(nums1) &lt; 0</code> and <code>min(nums2) &gt; 0</code>, then <code>return max(nums1) * min(nums2)</code>.</li>
<li>If <code>min(nums1) &gt; 0</code> and <code>max(nums2) &lt; 0</code>, then <code>return min(nums1) * max(nums2)</code>.</li>
</ul>
</li>
<li>Create a 2d table <code>dp</code> of size <code>(nums1.length + 1) * (nums2.length + 1)</code>.</li>
<li>Iterate <code>i</code> from <code>nums1.length - 1</code> until <code>0</code>:
<ul>
<li>Iterate <code>j</code> from <code>nums2.length - 1</code> until <code>0</code>:
<ul>
<li>Set <code>use = nums1[i] * nums2[j] + dp[i + 1][j + 1]</code>. This is the dot product from using the current numbers.</li>
<li>Find maximum of <code>use, dp[i + 1][j], dp[i][j + 1]</code>. Store it in <code>dp[i][j]</code>.</li>
</ul>
</li>
</ul>
</li>
<li>Return <code>dp[0][0]</code>, the answer to the original problem.</li>
</ol>
<p><strong>Complexity Analysis</strong></p>
<p>Given <span class="math math-inline"><span class="katex"><span class="katex-mathml">nn</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">n</span></span></span></span></span> as the length of <code>nums1</code> and <span class="math math-inline"><span class="katex"><span class="katex-mathml">mm</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">m</span></span></span></span></span> as the length of <code>nums2</code>,</p>
<ul>
<li>
<p>Time complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n⋅m)O(n \cdot m)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal">m</span><span class="mclose">)</span></span></span></span></span></p>
<p>We only calculate each state <code>(i, j)</code> once - one state per inner for loop iteration. There are <span class="math math-inline"><span class="katex"><span class="katex-mathml">n⋅mn \cdot m</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4445em;"></span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">m</span></span></span></span></span> states of <code>(i, j)</code>. To calculate a state, we simply take the maximum of three options, which costs <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(1)O(1)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord">1</span><span class="mclose">)</span></span></span></span></span>.</p>
</li>
<li>
<p>Space complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n⋅m)O(n \cdot m)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal">m</span><span class="mclose">)</span></span></span></span></span></p>
<p>The table <code>dp</code> takes <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n⋅m)O(n \cdot m)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal">m</span><span class="mclose">)</span></span></span></span></span> space.</p>
</li>
</ul>
 */
class MaxDotProductOfTwoSubsequences_Solution2 {    
    // 7 ms 
    // 43.1 MB
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for (int num: nums1) {
            firstMax = Math.max(firstMax, num);
            firstMin = Math.min(firstMin, num);
        }
        
        for (int num: nums2) {
            secondMax = Math.max(secondMax, num);
            secondMin = Math.min(secondMin, num);
        }
        
        if (firstMax < 0 && secondMin > 0) {
            return firstMax * secondMin;
        }
        
        if (firstMin > 0 && secondMax < 0) {
            return firstMin * secondMax;
        }
        
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                int use = nums1[i] * nums2[j] + dp[i + 1][j + 1];
                dp[i][j] = Math.max(use, Math.max(dp[i + 1][j], dp[i][j + 1]));
            }
        }
        
        return dp[0][0];
    }
}

/**
 * <h4 id="approach-3-space-optimized-dynamic-programming">Approach 3: Space Optimized Dynamic Programming</h4>
 * 
 * <p><strong>Intuition</strong></p>
 * <p>Notice that in the previous approach, each outer loop iteration focuses on calculating all values for <code>dp[i]</code>. However, we only rely on the values of <code>dp[i + 1]</code> in this calculation. For example, let's say we have <code>i = 4</code>. We only reference <code>dp[4][...]</code> and <code>dp[5][...]</code>, while the values in <code>dp[6]</code>, <code>dp[7]</code>, <code>dp[8]</code> and so forth, become irrelevant to the current calculation.</p>
 * <p>Thus, we can save some space since we only need the results of the current and previous rows. We will flatten <code>dp</code> so it is a 1d array of length <code>nums2.length + 1</code>. We will also use a similarly sized array <code>prevDp</code>.</p>
 * <p>Here, <code>dp</code> is analogous to <code>dp[i]</code>, and <code>prevDp</code> is analogous to <code>dp[i + 1]</code>, since <code>prevDp</code> represents the previous row. In each outer loop iteration, we start by resetting <code>dp</code> to a clean state. Then, we calculate <code>dp</code> (like we would calculate <code>dp[i]</code> in the previous approach) using the exact same process.</p>
 * <ol>
<li>If we <code>use</code> the current numbers, the dot product is <code>nums1[i] * nums2[j] + prevDp[j + 1]</code>, since <code>prevDp[j + 1]</code> is analogous to <code>dp[i + 1][j + 1]</code> from the previous approach.</li>
<li>If we move forward in <code>nums1</code>, the dot product is <code>prevDp[j]</code>, analogous to <code>dp[i + 1][j]</code> from the previous approach.</li>
<li>If we move forward in <code>nums2</code>, the dot product is <code>dp[j + 1]</code>, analogous to <code>dp[i][j + 1]</code> from the previous approach.</li>
</ol>
<p>After we finish calculating <code>dp</code>, we set <code>prevDp = dp</code> so that in the next iteration, <code>prevDp</code> correctly represents <code>dp[i + 1]</code>.</p>
<p><strong>Algorithm</strong></p>
<ol>
<li>Check the following special cases:
<ul>
<li>If <code>max(nums1) &lt; 0</code> and <code>min(nums2) &gt; 0</code>, then <code>return max(nums1) * min(nums2)</code>.</li>
<li>If <code>min(nums1) &gt; 0</code> and <code>max(nums2) &lt; 0</code>, then <code>return min(nums1) * max(nums2)</code>.</li>
</ul>
</li>
<li>Create an array <code>dp</code> and an array <code>prevDp</code>, both of size <code>m = (nums2.length + 1)</code>.</li>
<li>Iterate <code>i</code> from <code>nums1.length - 1</code> until <code>0</code>:
<ul>
<li>Reset <code>dp</code>.</li>
<li>Iterate <code>j</code> from <code>nums2.length - 1</code> until <code>0</code>:
<ul>
<li>Set <code>use = nums1[i] * nums2[j] + prevDp[j + 1]</code>. This is the dot product from using the current numbers.</li>
<li>Find maximum of <code>use, prevDp[j], dp[j + 1]</code>. Store it in <code>dp[j]</code>.</li>
</ul>
</li>
<li>Update <code>prevDp = dp</code>.</li>
</ul>
</li>
<li>Return <code>dp[0]</code>, the answer to the original problem.</li>
</ol>
<p><strong>Complexity Analysis</strong></p>
<p>Given <span class="math math-inline"><span class="katex"><span class="katex-mathml">nn</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">n</span></span></span></span></span> as the length of <code>nums1</code> and <span class="math math-inline"><span class="katex"><span class="katex-mathml">mm</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">m</span></span></span></span></span> as the length of <code>nums2</code>,</p>
<ul>
<li>
<p>Time complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n⋅m)O(n \cdot m)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal">m</span><span class="mclose">)</span></span></span></span></span></p>
<p>We only calculate each state <code>(i, j)</code> once - one state per inner for loop iteration. There are <span class="math math-inline"><span class="katex"><span class="katex-mathml">n⋅mn \cdot m</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4445em;"></span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">m</span></span></span></span></span> states of <code>(i, j)</code>. To calculate a state, we simply take the maximum of three options, which costs <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(1)O(1)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord">1</span><span class="mclose">)</span></span></span></span></span>.</p>
</li>
<li>
<p>Space complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(m)O(m)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">m</span><span class="mclose">)</span></span></span></span></span></p>
<p>We reduced space complexity by only requiring two 1d arrays of length <span class="math math-inline"><span class="katex"><span class="katex-mathml">mm</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">m</span></span></span></span></span>. Note that you could further improve it to <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(min⁡(n,m))O(\min(n, m))</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mop">min</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mpunct">,</span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord mathnormal">m</span><span class="mclose">))</span></span></span></span></span> if you were to compare the lengths of <code>nums1</code> and <code>nums2</code> before starting the algorithm, and then build <code>dp</code> along the shorter edge.</p>
</li>
</ul>
 */
class MaxDotProductOfTwoSubsequences_Solution3 {  
    // 6 ms
    // 43.2 MB  
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for (int num: nums1) {
            firstMax = Math.max(firstMax, num);
            firstMin = Math.min(firstMin, num);
        }
        
        for (int num: nums2) {
            secondMax = Math.max(secondMax, num);
            secondMin = Math.min(secondMin, num);
        }
        
        if (firstMax < 0 && secondMin > 0) {
            return firstMax * secondMin;
        }
        
        if (firstMin > 0 && secondMax < 0) {
            return firstMin * secondMax;
        }
        
        int m = nums2.length + 1;
        int[] dp = new int[m];
        int[] prevDp = new int[m];
        
        for (int i = nums1.length - 1; i >= 0; i--) {
            dp = new int[m];
            for (int j = nums2.length - 1; j >= 0; j--) {
                int use = nums1[i] * nums2[j] + prevDp[j + 1];
                dp[j] = Math.max(use, Math.max(prevDp[j], dp[j + 1]));
            }
            
            prevDp = dp;
        }
        
        return dp[0];
    }
}