package BetterCodeAnswer.Medium.Number;


/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/integer-break/">343.Integer Break</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an integer <code>n</code>, break it into the sum of <code>k</code> <strong>positive integers</strong>, where <code>k &gt;= 2</code>, and maximize the product of those integers.</p>

<p>Return <em>the maximum product you can get</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 2
<strong>Output:</strong> 1
<strong>Explanation:</strong> 2 = 1 + 1, 1 × 1 = 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 10
<strong>Output:</strong> 36
<strong>Explanation:</strong> 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n &lt;= 58</code></li>
</ul>
</div></div>
 */
public class IntegerBreak {
    public static void main(String[] args) {
        int n = 7;

        IntegerBreak_Solution result = new IntegerBreak_Solution();

        System.out.println(result.integerBreak(n));
    }
}   

/**
 * <h4 id="approach-1-top-down-dynamic-programming">Approach 1: Top-Down Dynamic Programming</h4>
 * 
 * <p><strong>Intuition</strong></p>
 * <blockquote>
<p><strong>Note.</strong> For this problem, we assume that you already know the fundamentals of dynamic programming and are figuring out how to apply it to a wide range of problems, such as this one. If you are not yet at this stage, we recommend checking out our relevant <a href="https://leetcode.com/explore/featured/card/dynamic-programming/" target="_blank">Explore Card content on dynamic programming</a> before coming back to this article.</p>
</blockquote>
<p>Let's say we have an integer <code>num</code> and split it into two integers: <code>i</code> and <code>num - i</code>. The highest product possible would be <code>i * BEST</code>, where <code>BEST</code> is the highest product possible from splitting up <code>num - i</code>.</p>
<p>Notice that the variable <code>BEST</code> represents the original problem with a different input (<code>num - i</code>). This allows us to think in terms of dynamic programming. Let's define a function <code>dp(num)</code> that returns the highest possible product from splitting <code>num</code> up.</p>
<p>We have the following base cases for this function:</p>
<ol>
<li>If <code>num == 1</code>, then it isn't possible to split the number up, so we just <code>return 1</code>.</li>
<li>If <code>num == 2</code>, then it would be better to not split the number at all, since the only possible split <code>1 * 1</code> is less than <code>2</code>, so just <code>return 2</code>. The exact same argument can be made for <code>num == 3</code>: the only possible split <code>1 * 2</code> is less than <code>3</code> itself, so just <code>return 3</code>.</li>
</ol>
<p>Otherwise, we have two options:</p>
<ol>
<li>Don't split the number up at all. We can initialize the answer as <code>ans = num</code>.</li>
<li>Split the number. We can try all possible splits. Iterate <code>i</code> from <code>2</code> until <code>num</code>. For each value of <code>i</code>, try to update <code>ans</code> with <code>i * dp(num - i)</code> if it is larger.</li>
</ol>
<p>You may be thinking: what about the constraint where we need to have at least <code>2</code> integers? We need to check for 2 separate cases before performing the recursion.</p>
<ol>
<li>If <code>n == 2</code>, we immediately return <code>1</code>. The only possible split is <code>1 * 1</code>.</li>
<li>If <code>n == 3</code>, we immediately return <code>2</code>. The only possible split is <code>1 * 2</code>.</li>
</ol>
<p>We need to explicitly check for these cases before going into the recursion, otherwise, we would incorrectly return a larger answer since we initialize <code>ans = num</code>.</p>
<p>For all other values of <code>n</code>, the recursion will work. Take a look at the first few numbers:</p>
<ul>
<li>For <code>num = 4</code>, we can do <code>2 * 2 = 4</code>, which is not less than <code>4</code> itself.</li>
<li>For <code>num = 5</code>, we can do <code>2 * 3 = 6</code>, which is not less than <code>5</code> itself.</li>
<li>For <code>num = 6</code>, we can do <code>3 * 3 = 9</code>, which is not less than <code>6</code> itself.</li>
</ul>
<p>As you can see, as <code>n</code> increases, the product from splitting becomes larger and larger, and thus we will always satisfy the requirement of needing to perform at least one split. The only cases where performing a split results in a lower product is <code>2, 3</code>.</p>
<p>This solution will work, but you may notice that it will end up in a lot of duplicated computation. We will end up calculating many states multiple times. For example, if we called <code>dp(15)</code>, it would make a call to <code>dp(12)</code> when calculating <code>3 * dp(12)</code>. If we later call <code>dp(14)</code>, it will also make a call to <code>dp(12)</code> when calculating <code>2 * dp(12)</code>. To avoid computing the same states multiple times, we will use a technique called memoization. The first time we calculate <code>dp(num)</code>, we will store the result. In the future, we can reference this result for <code>num</code> instead of having to recalculate it.</p>
<p><strong>Algorithm</strong></p>
<ol>
<li>If <code>n &lt;= 3</code>, then <code>return n - 1</code>.</li>
<li>Define a memoized function <code>dp(num)</code>:
<ul>
<li>Base case: if <code>num &lt;= 3</code>, then <code>return num</code>.</li>
<li>Initialize <code>ans = num</code>. This is the case of not splitting the number at all.</li>
<li>Iterate <code>i</code> from <code>2</code> until <code>num</code>:
<ul>
<li>Try to update <code>ans</code> with <code>i * dp(num - i)</code> if it is larger.</li>
</ul>
</li>
<li>Return <code>ans</code>.</li>
</ul>
</li>
<li>Return <code>dp(n)</code>.</li>
</ol>
 */
class IntegerBreak_Solution {
    int[] memo;
    
    // 0 ms
    // 38.9 MB
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        
        memo = new int[n + 1];
        return dp(n);
    }
    
    public int dp(int num) {
        if (num <= 3) {
            return num;
        }
        
        if (memo[num] != 0) {
            return memo[num];
        }
        
        int ans = num;
        for (int i = 2; i < num; i++) {
            ans = Math.max(ans, i * dp(num - i));
        }
        
        memo[num] = ans;
        return ans;
    }
}

/**
 * <h4 id="approach-2-bottom-up-dynamic-programming">Approach 2: Bottom-Up Dynamic Programming</h4>
 * 
 * <p><strong>Intuition</strong></p>
 * <p>We can implement the same algorithm iteratively. In top-down, we start at the answer <code>(num = n)</code> and work our way down to the base cases (<code>if num &lt;= 3, return num</code>).</p>
 * <p>In bottom-up, we will start from these base cases and iterate toward the answer. We will use a table <code>dp</code> which is equivalent to the function from the previous approach. Here, <code>dp[num]</code> is equal to <code>dp(num)</code> from the previous approach.</p>
 * <p>We have a for loop for <code>num</code> starting from <code>4</code> and iterating to <code>n</code>. Each iteration of this loop represents a state, like a function call. We can calculate this state the same way we did in the previous approach, by checking all possible splits with a for loop over <code>i</code>.</p>
 * <p><strong>Algorithm</strong></p>
 * <ol>
<li>If <code>n &lt;= 3</code>, then <code>return n - 1</code>.</li>
<li>Create an array <code>dp</code> of length <code>n + 1</code>.</li>
<li>Set the base cases. For <code>i = 1, 2, 3</code>, set <code>dp[i] = i</code>.</li>
<li>Iterate <code>num</code> from <code>4</code> to <code>n</code>:
<ul>
<li>Initialize <code>ans = num</code>. This is the case of not splitting the number at all.</li>
<li>Iterate <code>i</code> from <code>2</code> until <code>num</code>:
<ul>
<li>Try to update <code>ans</code> with <code>i * dp[num - i]</code> if it is larger.</li>
</ul>
</li>
<li>Set <code>dp[num] = ans</code>.</li>
</ul>
</li>
<li>Return <code>dp[n]</code>.</li>
</ol>
 */
class IntegerBreak_Solution2 {
    // 1 ms
    // 38.7 MB
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        
        int[] dp = new int[n + 1];

        // Set base cases
        for (int i = 1; i <= 3; i++) {
            dp[i] = i;
        }
        
        for (int num = 4; num <= n; num++) {
            int ans = num;
            for (int i = 2; i < num; i++) {
                ans = Math.max(ans, i * dp[num - i]);
            }
            
            dp[num] = ans;
        }
        
        return dp[n];
    }
}

/**
 * <h4 id="approach-3-mathematics">Approach 3: Mathematics</h4>
 * 
 * <p><strong>Intuition</strong></p>
 * <p>Interestingly, it is optimal to only split <code>n</code> into <code>2</code> and <code>3</code>! Why is this the case? The following is not a strict mathematical proof, but gives an intuition as to why we should only split <code>n</code> into <code>2</code> and <code>3</code>.</p>
 * <p>The <a href="https://en.wikipedia.org/wiki/AM-GM_Inequality" target="_blank">inequality of arithmetic and geometric means</a> shows that to maximize the product of a set of numbers with a fixed sum, the numbers should all be equal. This means that we should split <code>n</code> into <code>a</code> copies of <code>x</code>. We have:</p>
 * <p><span class="math math-inline"><span class="katex"><span class="katex-mathml">n=axn = ax</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span></span><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">a</span><span class="mord mathnormal">x</span></span></span></span></span></p>
 * <p>So,</p>
 * <p><span class="math math-inline"><span class="katex"><span class="katex-mathml">a=nxa = \frac{n}{x}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">a</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span></span><span class="base"><span class="strut" style="height: 1.0404em; vertical-align: -0.345em;"></span><span class="mord"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.6954em;"><span style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">x</span></span></span></span><span style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line" style="border-bottom-width: 0.04em;"></span></span><span style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">n</span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.345em;"><span></span></span></span></span></span><span class="mclose nulldelimiter"></span></span></span></span></span></span></p>
 * <p>The product of these copies will be <span class="math math-inline"><span class="katex"><span class="katex-mathml">xax^a</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6644em;"></span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.6644em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mathnormal mtight">a</span></span></span></span></span></span></span></span></span></span></span></span>, we will substitute <span class="math math-inline"><span class="katex"><span class="katex-mathml">a=nxa = \frac{n}{x}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">a</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span></span><span class="base"><span class="strut" style="height: 1.0404em; vertical-align: -0.345em;"></span><span class="mord"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.6954em;"><span style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">x</span></span></span></span><span style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line" style="border-bottom-width: 0.04em;"></span></span><span style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">n</span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.345em;"><span></span></span></span></span></span><span class="mclose nulldelimiter"></span></span></span></span></span></span> and represent this function as <span class="math math-inline"><span class="katex"><span class="katex-mathml">ff</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8889em; vertical-align: -0.1944em;"></span><span class="mord mathnormal" style="margin-right: 0.10764em;">f</span></span></span></span></span>.</p>
 * <p><span class="math math-inline"><span class="katex"><span class="katex-mathml">f(x)=xnx\Large{f(x) = x ^ \frac{n}{x}}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.5781em; vertical-align: -0.36em;"></span><span class="mord sizing reset-size6 size8"><span class="mord mathnormal" style="margin-right: 0.10764em;">f</span><span class="mopen">(</span><span class="mord mathnormal">x</span><span class="mclose">)</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8459em;"><span style="top: -3.363em; margin-right: 0.0347em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size8 size6 mtight"><span class="mord mtight"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.6954em;"><span style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">x</span></span></span></span><span style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line mtight" style="border-bottom-width: 0.04em;"></span></span><span style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">n</span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.345em;"><span></span></span></span></span></span><span class="mclose nulldelimiter"></span></span></span></span></span></span></span></span></span></span></span></span></span></span>.</p>
 * <p>We need to maximize this function. Let's start by taking the derivative of <span class="math math-inline"><span class="katex"><span class="katex-mathml">ff</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8889em; vertical-align: -0.1944em;"></span><span class="mord mathnormal" style="margin-right: 0.10764em;">f</span></span></span></span></span> with respect to <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span> (here, <span class="math math-inline"><span class="katex"><span class="katex-mathml">log⁡\log</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8889em; vertical-align: -0.1944em;"></span><span class="mop">lo<span style="margin-right: 0.01389em;">g</span></span></span></span></span></span> is the natural logarithm).</p>
 * <p><span class="math math-inline"><span class="katex"><span class="katex-mathml">f′(x)=−nxnx−2⋅(log⁡x−1)\Large{f'(x) = -nx ^ {\frac{n}{x} - 2} \cdot (\log{}x - 1)}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.5781em; vertical-align: -0.36em;"></span><span class="mord sizing reset-size6 size8"><span class="mord"><span class="mord mathnormal" style="margin-right: 0.10764em;">f</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.7488em;"><span style="top: -3.363em; margin-right: 0.0347em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size8 size6 mtight"><span class="mord mtight"><span class="mord mtight">′</span></span></span></span></span></span></span></span></span><span class="mopen">(</span><span class="mord mathnormal">x</span><span class="mclose">)</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mord">−</span><span class="mord mathnormal">n</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8459em;"><span style="top: -3.363em; margin-right: 0.0347em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size8 size6 mtight"><span class="mord mtight"><span class="mord mtight"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.6954em;"><span style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">x</span></span></span></span><span style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line mtight" style="border-bottom-width: 0.04em;"></span></span><span style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">n</span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.345em;"><span></span></span></span></span></span><span class="mclose nulldelimiter"></span></span><span class="mbin mtight">−</span><span class="mord mtight">2</span></span></span></span></span></span></span></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mopen">(</span><span class="mop">lo<span style="margin-right: 0.01389em;">g</span></span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord"></span><span class="mord mathnormal">x</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">−</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mord">1</span><span class="mclose">)</span></span></span></span></span></span></p>
 * <p>Now, we set this equal to <code>0</code> and solve for <code>x</code> to find a critical point.</p>
 * <p><span class="math math-inline"><span class="katex"><span class="katex-mathml">−nxnx−2⋅(log⁡x−1)=0\Large{-nx ^ {\frac{n}{x} - 2} \cdot (\log{}x - 1) = 0}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.5781em; vertical-align: -0.36em;"></span><span class="mord sizing reset-size6 size8"><span class="mord">−</span><span class="mord mathnormal">n</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8459em;"><span style="top: -3.363em; margin-right: 0.0347em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size8 size6 mtight"><span class="mord mtight"><span class="mord mtight"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.6954em;"><span style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">x</span></span></span></span><span style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line mtight" style="border-bottom-width: 0.04em;"></span></span><span style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">n</span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.345em;"><span></span></span></span></span></span><span class="mclose nulldelimiter"></span></span><span class="mbin mtight">−</span><span class="mord mtight">2</span></span></span></span></span></span></span></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mopen">(</span><span class="mop">lo<span style="margin-right: 0.01389em;">g</span></span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord"></span><span class="mord mathnormal">x</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">−</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mord">1</span><span class="mclose">)</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mord">0</span></span></span></span></span></span></p>
 * <p>The term <span class="math math-inline"><span class="katex"><span class="katex-mathml">xnx−2\Large{x ^ {\frac{n}{x} - 2}}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.2181em;"></span><span class="mord sizing reset-size6 size8"><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8459em;"><span style="top: -3.363em; margin-right: 0.0347em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size8 size6 mtight"><span class="mord mtight"><span class="mord mtight"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.6954em;"><span style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">x</span></span></span></span><span style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line mtight" style="border-bottom-width: 0.04em;"></span></span><span style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">n</span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.345em;"><span></span></span></span></span></span><span class="mclose nulldelimiter"></span></span><span class="mbin mtight">−</span><span class="mord mtight">2</span></span></span></span></span></span></span></span></span></span></span></span></span></span> converges to <code>0</code> as <code>x</code> tends to <code>0</code>. However, we are clearly not interested in values of <code>x</code> less than <code>1</code>, as that would lead to a product less than <code>1</code>.</p>
 * <p>This means <span class="math math-inline"><span class="katex"><span class="katex-mathml">f=0f = 0</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8889em; vertical-align: -0.1944em;"></span><span class="mord mathnormal" style="margin-right: 0.10764em;">f</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span></span><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">0</span></span></span></span></span> when <span class="math math-inline"><span class="katex"><span class="katex-mathml">(log⁡x−1)=0(\log{}x - 1) = 0</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">(</span><span class="mop">lo<span style="margin-right: 0.01389em;">g</span></span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord"></span><span class="mord mathnormal">x</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">−</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord">1</span><span class="mclose">)</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span></span><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">0</span></span></span></span></span>. This is the case when <span class="math math-inline"><span class="katex"><span class="katex-mathml">x=e=2.71828...x = e = 2.71828...</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span></span><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">e</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span></span><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">2.71828...</span></span></span></span></span>.</p>
 * <p><span class="math math-inline"><span class="katex"><span class="katex-mathml">ff</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8889em; vertical-align: -0.1944em;"></span><span class="mord mathnormal" style="margin-right: 0.10764em;">f</span></span></span></span></span> is maximized at <span class="math math-inline"><span class="katex"><span class="katex-mathml">ee</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">e</span></span></span></span></span>. Unfortunately, <span class="math math-inline"><span class="katex"><span class="katex-mathml">ee</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">e</span></span></span></span></span> is not an integer, and this problem is called Integer Break. The nearest integer is <span class="math math-inline"><span class="katex"><span class="katex-mathml">33</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">3</span></span></span></span></span>, which suggests that we should try to use <span class="math math-inline"><span class="katex"><span class="katex-mathml">33</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">3</span></span></span></span></span> as much as we can.</p>
 * <p>For numbers that are not divisible by <span class="math math-inline"><span class="katex"><span class="katex-mathml">33</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">3</span></span></span></span></span>, we will have remainders. This is where <span class="math math-inline"><span class="katex"><span class="katex-mathml">22</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">2</span></span></span></span></span> comes in. For example, when <code>n = 11</code>, the maximum product is <code>54 = 3 * 3 * 3 * 2</code>.</p>
 * <p>When we have <code>n = 4</code>, it is better to split it into <code>2 * 2</code> versus <code>3 * 1</code>. Thus, the strategy of splitting into as many 3s as we can only applies when <code>n &gt; 4</code>. This brings us to our algorithm. As long as <code>n &gt; 4</code>, keep splitting 3s. Once <code>n &lt;= 4</code>, we can just multiply it directly with whatever product we have built up to that point.</p>
 * <p>Note that due to the constraint of needing to perform at least one split, we still need to account for the special cases when <code>n &lt;= 3</code>.</p>
 * <p><strong>Algorithm</strong></p>
 * <ol>
<li>If <code>n &lt;= 3</code>, then <code>return n - 1</code>.</li>
<li>Initialize <code>ans = 1</code>.</li>
<li>While <code>n &gt; 4</code>:
<ul>
<li>Multiply <code>ans</code> by 3.</li>
<li>Subtract <code>3</code> from <code>n</code>.</li>
</ul>
</li>
<li>Return <code>ans * n</code>.</li>
</ol>
 */
class IntegerBreak_Solution3 {
    // 0 ms
    // 39.1 MB
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        
        int ans = 1;
        while (n > 4) {
            ans *= 3;
            n -= 3;
        }
        
        return ans * n;
    }
}

/**
 * <h4 id="approach-4-equation">Approach 4: Equation</h4>
 * 
 * <p><strong>Intuition</strong></p>
 * <p>Instead of manually multiplying by 3 repeatedly, we can use math to figure out how many 3s and 2s will make up the optimal product.</p>
 * <p>Instead of manually multiplying by 3 repeatedly, we can use math to figure out how many 3s and 2s will make up the optimal product.</p>
 * <p>Now, for <code>n &gt; 3</code>, we have three possibilities:</p>
 * <ol>
<li><code>n % 3 == 0</code>. If <code>n</code> is divisible by <code>3</code>, then we can simply just break it into <span class="math math-inline"><span class="katex"><span class="katex-mathml">n3\frac{n}{3}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.0404em; vertical-align: -0.345em;"></span><span class="mord"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.6954em;"><span style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mtight">3</span></span></span></span><span style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line" style="border-bottom-width: 0.04em;"></span></span><span style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">n</span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.345em;"><span></span></span></span></span></span><span class="mclose nulldelimiter"></span></span></span></span></span></span> 3s.</li>
<li><code>n % 3 == 1</code>. If we were to break <code>n</code> into <span class="math math-inline"><span class="katex"><span class="katex-mathml">n3\frac{n}{3}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.0404em; vertical-align: -0.345em;"></span><span class="mord"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.6954em;"><span style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mtight">3</span></span></span></span><span style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line" style="border-bottom-width: 0.04em;"></span></span><span style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">n</span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.345em;"><span></span></span></span></span></span><span class="mclose nulldelimiter"></span></span></span></span></span></span> 3s, we would have a remainder of <code>1</code>. As mentioned in the previous approach, it would be better to combine this <code>1</code> with one of the 3s to form a sum of <code>4</code>, which we can break into <code>2 * 2</code>. In this case, we break <code>n</code> into <span class="math math-inline"><span class="katex"><span class="katex-mathml">n3−1\frac{n}{3} - 1</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.0404em; vertical-align: -0.345em;"></span><span class="mord"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.6954em;"><span style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mtight">3</span></span></span></span><span style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line" style="border-bottom-width: 0.04em;"></span></span><span style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">n</span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.345em;"><span></span></span></span></span></span><span class="mclose nulldelimiter"></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">−</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">1</span></span></span></span></span> 3s, and two 2s.</li>
<li><code>n % 3 == 2</code>. If we were to break <code>n</code> into <span class="math math-inline"><span class="katex"><span class="katex-mathml">n3\frac{n}{3}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.0404em; vertical-align: -0.345em;"></span><span class="mord"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.6954em;"><span style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mtight">3</span></span></span></span><span style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line" style="border-bottom-width: 0.04em;"></span></span><span style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">n</span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.345em;"><span></span></span></span></span></span><span class="mclose nulldelimiter"></span></span></span></span></span></span> 3s, we would have a remainder of <code>2</code>. We simply break <code>n</code> into <span class="math math-inline"><span class="katex"><span class="katex-mathml">n3\frac{n}{3}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.0404em; vertical-align: -0.345em;"></span><span class="mord"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.6954em;"><span style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mtight">3</span></span></span></span><span style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line" style="border-bottom-width: 0.04em;"></span></span><span style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">n</span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.345em;"><span></span></span></span></span></span><span class="mclose nulldelimiter"></span></span></span></span></span></span> 3s and a single 2.</li>
</ol>
<p><img src="https://leetcode.com/problems/integer-break/Figures/343/1.png" alt="math example"><br>
<br></p>
<p><strong>Algorithm</strong></p>
<ol>
<li>If <code>n &lt;= 3</code>, then <code>return n - 1</code>.</li>
<li>If <code>n % 3 == 0</code>, return <span class="math math-inline"><span class="katex"><span class="katex-mathml">3n3\Large{3 ^ \frac{n}{3}}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.2181em;"></span><span class="mord sizing reset-size6 size8"><span class="mord"><span class="mord">3</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8459em;"><span style="top: -3.363em; margin-right: 0.0347em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size8 size6 mtight"><span class="mord mtight"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.6954em;"><span style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mtight">3</span></span></span></span><span style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line mtight" style="border-bottom-width: 0.04em;"></span></span><span style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">n</span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.345em;"><span></span></span></span></span></span><span class="mclose nulldelimiter"></span></span></span></span></span></span></span></span></span></span></span></span></span></span>.</li>
<li>If <code>n % 3 == 1</code>, return <span class="math math-inline"><span class="katex"><span class="katex-mathml">3n3−1⋅4\Large{3 ^ {\frac{n}{3} - 1} \cdot 4}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.2181em;"></span><span class="mord sizing reset-size6 size8"><span class="mord"><span class="mord">3</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8459em;"><span style="top: -3.363em; margin-right: 0.0347em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size8 size6 mtight"><span class="mord mtight"><span class="mord mtight"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.6954em;"><span style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mtight">3</span></span></span></span><span style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line mtight" style="border-bottom-width: 0.04em;"></span></span><span style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">n</span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.345em;"><span></span></span></span></span></span><span class="mclose nulldelimiter"></span></span><span class="mbin mtight">−</span><span class="mord mtight">1</span></span></span></span></span></span></span></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mord">4</span></span></span></span></span></span>.</li>
<li>Otherwise, return <span class="math math-inline"><span class="katex"><span class="katex-mathml">3n3⋅2\Large{3 ^ \frac{n}{3} \cdot 2}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.2181em;"></span><span class="mord sizing reset-size6 size8"><span class="mord"><span class="mord">3</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8459em;"><span style="top: -3.363em; margin-right: 0.0347em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size8 size6 mtight"><span class="mord mtight"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.6954em;"><span style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mtight">3</span></span></span></span><span style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line mtight" style="border-bottom-width: 0.04em;"></span></span><span style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">n</span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.345em;"><span></span></span></span></span></span><span class="mclose nulldelimiter"></span></span></span></span></span></span></span></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mord">2</span></span></span></span></span></span>.</li>
</ol>
 */
class IntegerBreak_Solution4 {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        
        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        }
        
        if (n % 3 == 1) {
            return (int) Math.pow(3, (n / 3 - 1)) * 4;
        }
        
        return (int) Math.pow(3, n / 3) * 2;
    }
}