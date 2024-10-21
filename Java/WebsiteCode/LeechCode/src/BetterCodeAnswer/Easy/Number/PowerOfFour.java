package BetterCodeAnswer.Easy.Number;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/power-of-four/">342.Power of Four</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an integer <code>n</code>, return <em><code>true</code> if it is a power of four. Otherwise, return <code>false</code></em>.</p>

<p>An integer <code>n</code> is a power of four, if there exists an integer <code>x</code> such that <code>n == 4<sup>x</sup></code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> n = 16
<strong>Output:</strong> true
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> n = 5
<strong>Output:</strong> false
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> true
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you solve it without loops/recursion?</div></div>
 */
public class PowerOfFour {
    public static void main(String[] args) {
        int[] nArr = {16,5,1, (int) 2e31};

        PowerOfFour_Solution res = new PowerOfFour_Solution();

        for (int n : nArr) {
            System.out.println(res.isPowerOfFour(n));
        }
    }
}

/**
 * <h2 id="first-approach">First Approach:</h2>
 * <ol>
<li><strong>Power of Two Check</strong>: Before checking if a number is a power of four, it is essential to ensure it's a power of two. Why? Because every power of four is a power of two, but not vice versa. This can be checked by the expression <span class="math math-inline"><span class="katex"><span class="katex-mathml">nn</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">n</span></span></span></span></span> AND <span class="math math-inline"><span class="katex"><span class="katex-mathml">(n−1)(n-1)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">−</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord">1</span><span class="mclose">)</span></span></span></span></span> which must be zero. This is because powers of two in binary form have only one set bit, and subtracting one from them inverts all the bits after the rightmost set bit.</li>
<li><strong>Count Zeros</strong>: Since not all powers of two are powers of four, we need to further discern them by checking the position of the set bit. Powers of four have their only set bit at odd positions in binary form. We count the number of trailing zeros, and if the count is even, then it's a power of four.</li>
</ol>
<h2 id="second-approach">Second Approach:</h2>
<ol>
<li><strong>Power of Two Check</strong>: As with the first approach, we need to ensure the number is a power of two.</li>
<li><strong>Masking</strong>: Instead of counting zeros, we can use a mask to check the position of the set bit directly. The mask for 32-bit integers with bits set in odd positions is <code>0x55555555</code>. Powers of four will only have a set bit in one of these positions, so the number AND the mask should yield the number itself.</li>
</ol>
 */
class PowerOfFour_Solution {
    // 1 ms
    // 40 MB
    public boolean isPowerOfFour(int n) {
        if (n > 0 && (n & (n - 1)) == 0) {
            int zero_count = 0;
            while (n > 1) {
                zero_count++;
                n >>= 1;
            }
            return zero_count % 2 == 0;
        }
        return false;
    }
}

class PowerOfFour_Solution2 {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}