package BetterCodeAnswer.Hard.Number;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/minimum-one-bit-operations-to-make-integers-zero/">1611.Minimum One Bit Operations to Make Integers Zero</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an integer <code>n</code>, you must transform it into <code>0</code> using the following operations any number of times:</p>

<ul>
	<li>Change the rightmost (<code>0<sup>th</sup></code>) bit in the binary representation of <code>n</code>.</li>
	<li>Change the <code>i<sup>th</sup></code> bit in the binary representation of <code>n</code> if the <code>(i-1)<sup>th</sup></code> bit is set to <code>1</code> and the <code>(i-2)<sup>th</sup></code> through <code>0<sup>th</sup></code> bits are set to <code>0</code>.</li>
</ul>

<p>Return <em>the minimum number of operations to transform </em><code>n</code><em> into </em><code>0</code><em>.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> 2
<strong>Explanation:</strong> The binary representation of 3 is "11".
"<u>1</u>1" -&gt; "<u>0</u>1" with the 2<sup>nd</sup> operation since the 0<sup>th</sup> bit is 1.
"0<u>1</u>" -&gt; "0<u>0</u>" with the 1<sup>st</sup> operation.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 6
<strong>Output:</strong> 4
<strong>Explanation:</strong> The binary representation of 6 is "110".
"<u>1</u>10" -&gt; "<u>0</u>10" with the 2<sup>nd</sup> operation since the 1<sup>st</sup> bit is 1 and 0<sup>th</sup> through 0<sup>th</sup> bits are 0.
"01<u>0</u>" -&gt; "01<u>1</u>" with the 1<sup>st</sup> operation.
"0<u>1</u>1" -&gt; "0<u>0</u>1" with the 2<sup>nd</sup> operation since the 0<sup>th</sup> bit is 1.
"00<u>1</u>" -&gt; "00<u>0</u>" with the 1<sup>st</sup> operation.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 10<sup>9</sup></code></li>
</ul>
</div></div>
 */
public class MinimumOneBitOperationsToMakeIntegersZero {
    public static void main(String[] args) {
        int[] tests =  {
            0,
            1,
            3,
            6
        };

        for (int n : tests) {
            System.out.println(new MinimumOneBitOperationsToMakeIntegersZero_Solution().minimumOneBitOperations(n));
        }
    }
}

/**
 * <h1 id="intuition">Intuition</h1>
 * <p>Assume a number <code>1101001</code><br>
Starting from left to right to save number of operations<br>
<code>1000000-&gt;0</code> takes 2^7-1 = 127 steps<br>
<code>0100000-&gt;0</code> takes 2^6-1 = 63 steps<br>
<code>0001000-&gt;0</code> takes 2^4-1 = 15 steps<br>
<code>0000001-&gt;0</code> takes 2^1-1 = 1 step</p>
<p>Hence Can be said<br>
<code>1 -&gt; 0</code> needs <code>1</code> operation,<br>
<code>2 -&gt; 0</code> needs <code>3</code> operations,<br>
<code>4 -&gt; 0</code> needs <code>7</code> operations,<br>
<code>2^k</code> needs <code>2^(k+1)-1</code> operations.</p>
<h1 id="approach">Approach</h1>
<p><code>1101001</code> : Required steps  = 127-63+15-1 = 78</p>
<ul>
<li>Let steps <code>x</code> to convert <code>000000</code> to <code>100000</code>.</li>
<li>But, since <code>1101001</code> already has 1 in the 5th bit from right, some steps will be saved.</li>
<li>Saved steps <code>y = Number of steps needed to convert 000000 to 100000</code></li>
<li>Hence not all the <code>2^(6+1) - 1</code> steps to convert <code>1000000 -&gt; 0</code> as <code>0100000</code> can be obtained in less number of steps.</li>
</ul>
<p>For <code>0100000 -&gt; 0</code>, we need to add its <code>2^6-1</code> steps<br>
For <code>0001000 -&gt; 0</code>, we need to add its <code>2^4-1</code> steps<br>
For <code>0000001 -&gt; 0</code>, we need to add its <code>2^1-1</code> steps</p>
<p>Result = <code>2^(7)-1</code> - <code>2^6-1</code> - <code>2^4-1</code> - <code>2^1-1</code></p>
 */
class MinimumOneBitOperationsToMakeIntegersZero_Solution {
    // 0 ms 39.2 MB
    public int minimumOneBitOperations(int n) {
        int multiplier = 1;
        int res = 0;
        while (n > 0) {
            res += n ^ (n - 1) * multiplier;
            multiplier = -1 * multiplier;
            n &= n - 1;
        }
        return Math.abs(res);
    }
}

/**
 * <h4 id="approach-3-gray-code">Approach 3: Gray Code</h4>
 * <p><strong>Intuition</strong></p>
 * <blockquote>
<p>Note: this approach is very advanced. You would not be expected to derive this approach in an interview. We have included it for the sake of completeness.</p>
</blockquote>
<p>A <a href="https://en.wikipedia.org/wiki/Gray_code" target="_blank">Gray code</a>, named after Frank Gray, is an ordering of the binary numbers such that every successive number in the ordering differs by only one bit.</p>
<p>You may notice that the two operations given in the problem are capable only of changing exactly one bit at a time. Thus, any sequence of numbers generated by these operations <strong>must</strong> also be a Gray code!</p>
<p>Although there can be many Gray codes, the standard encoding actually follows the exact same ordering as one that would be produced by the operations given in this problem.</p>
<p>Thus, this problem is actually equivalent to finding the index of <span class="math math-inline"><span class="katex"><span class="katex-mathml">nn</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">n</span></span></span></span></span> in the standard Gray code sequence that starts from <code>0</code>, since reducing <code>n</code> to <code>0</code> is equivalent to converting <code>0</code> to <code>n</code>.</p>
<p>The <a href="https://en.wikipedia.org/wiki/Gray_code#Converting_to_and_from_Gray_code" target="_blank">Wikipedia article</a> provides a very efficient algorithm to do this. As this approach (and certainly the derivation) is outside the scope of an interview, we will not discuss it in detail here. Interested users are encouraged to read through the Wikipedia article to learn more.</p>
<p><strong>Algorithm</strong></p>
<ol>
<li>Initialize <code>ans = n</code>.</li>
<li>XOR <code>ans</code> with <code>ans &gt;&gt; 16</code>.</li>
<li>XOR <code>ans</code> with <code>ans &gt;&gt; 8</code>.</li>
<li>XOR <code>ans</code> with <code>ans &gt;&gt; 4</code>.</li>
<li>XOR <code>ans</code> with <code>ans &gt;&gt; 2</code>.</li>
<li>XOR <code>ans</code> with <code>ans &gt;&gt; 1</code>.</li>
<li>Return <code>ans</code>.</li>
</ol>
 */
class MinimumOneBitOperationsToMakeIntegersZero_Solution2 {
    public int minimumOneBitOperations(int n) {
        int ans = n;
        ans ^= ans >> 16;
        ans ^= ans >> 8;
        ans ^= ans >> 4;
        ans ^= ans >> 2;
        ans ^= ans >> 1;
        return ans;
    }
}