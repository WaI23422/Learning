package BetterCodeAnswer.Hard.Number;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/count-vowels-permutation/">1220.Count Vowels Permutation</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an integer <code>n</code>, your task is to count how many strings of length <code>n</code> can be formed under the following rules:</p>

<ul>
	<li>Each character is a lower case vowel&nbsp;(<code>'a'</code>, <code>'e'</code>, <code>'i'</code>, <code>'o'</code>, <code>'u'</code>)</li>
	<li>Each vowel&nbsp;<code>'a'</code> may only be followed by an <code>'e'</code>.</li>
	<li>Each vowel&nbsp;<code>'e'</code> may only be followed by an <code>'a'</code>&nbsp;or an <code>'i'</code>.</li>
	<li>Each vowel&nbsp;<code>'i'</code> <strong>may not</strong> be followed by another <code>'i'</code>.</li>
	<li>Each vowel&nbsp;<code>'o'</code> may only be followed by an <code>'i'</code> or a&nbsp;<code>'u'</code>.</li>
	<li>Each vowel&nbsp;<code>'u'</code> may only be followed by an <code>'a'.</code></li>
</ul>

<p>Since the answer&nbsp;may be too large,&nbsp;return it modulo <code>10^9 + 7.</code></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> 5
<strong>Explanation:</strong> All possible strings are: "a", "e", "i" , "o" and "u".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 2
<strong>Output:</strong> 10
<strong>Explanation:</strong> All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
</pre>

<p><strong class="example">Example 3:&nbsp;</strong></p>

<pre><strong>Input:</strong> n = 5
<strong>Output:</strong> 68</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 2 * 10^4</code></li>
</ul>
</div></div>
 */
public class CountVowelsPermutation {
    public static void main(String[] args) {
        int[] tests = {1,2,5};

        CountVowelsPermutation_Solution res= new CountVowelsPermutation_Solution();

        for (int numb : tests) {
            System.out.println(res.countVowelPermutation(numb));
        }
    }
}

class CountVowelsPermutation_Solution {
    int MOD = (int) 1e9 + 7;

    // 1 ms 
    // 39.2 MB
    public int countVowelPermutation(int n) {
        // long[][] result = new long[][]{
        //     {1}, {1}, {1}, {1}, {1}
        // };
        long[][] mat = new long[][]{
            // a, e, i, o ,u
            {0, 1, 1, 0, 1},
            {1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 1, 0}
        };

        long[][] ans = new long[][]{
            {1}, {1}, {1}, {1}, {1}
        };
        // long[][] mat = new long[][]{
        //     {0, 1, 0, 0, 0},
        //     {1, 0, 1, 0, 0},
        //     {1, 1, 0, 1, 1},
        //     {0, 0, 1, 0, 1},
        //     {1, 0, 0, 0, 0},
        // };
        int x = n - 1;
        while (x > 0) {
            if ((x & 1) == 1) ans = multiply(mat, ans);
            mat = multiply(mat, mat);
            x >>= 1;
        }
        long sum = 0;
        for (int i = 0; i < 5; i++) sum += ans[i][0];
        return (int)(sum % MOD);
    }

    private long[][] multiply(long[][] a, long[][] b) {
        int r = a.length, c = b[0].length, z = b.length;
        long[][] ans = new long[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < z; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                    ans[i][j] %= MOD;
                }
            }
        }

        return ans;
    }
}

/**
 * <h1 id="approach">Approach</h1>
 * <ol>
<li>
<p><strong>Transition Matrix</strong>: First, we need to understand the transition for each vowel. We can build this based on the rules provided:</p>
<ul>
<li>'a' can only be followed by 'e'</li>
<li>'e' can be followed by 'a' or 'i'</li>
<li>'i' cannot be followed by another 'i'</li>
<li>'o' can be followed by 'i' or 'u'</li>
<li>'u' can only be followed by 'a'</li>
</ul>
</li>
<li>
<p><strong>Dynamic Programming</strong>: We maintain a dynamic programming array for each vowel which will store the count of strings ending with that vowel for a particular length.</p>
<ul>
<li>For <span class="math math-inline"><span class="katex"><span class="katex-mathml">n=1n = 1</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span></span><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">1</span></span></span></span></span>, all vowels have a count of 1.</li>
<li>For each subsequent length, the count for each vowel is updated based on the previous counts of the other vowels.</li>
<li>For example, the count of strings of length <span class="math math-inline"><span class="katex"><span class="katex-mathml">ii</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6595em;"></span><span class="mord mathnormal">i</span></span></span></span></span> ending with 'a' will be equal to the count of strings of length <span class="math math-inline"><span class="katex"><span class="katex-mathml">i−1i-1</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.7429em; vertical-align: -0.0833em;"></span><span class="mord mathnormal">i</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">−</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">1</span></span></span></span></span> ending with 'e', because 'a' can only be followed by 'e'.</li>
</ul>
</li>
<li>
<p><strong>Modulo Operation</strong>: Since the answer can be large, we use modulo <span class="math math-inline"><span class="katex"><span class="katex-mathml">109+710^9 + 7</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8974em; vertical-align: -0.0833em;"></span><span class="mord">1</span><span class="mord"><span class="mord">0</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8141em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">9</span></span></span></span></span></span></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">7</span></span></span></span></span> at each step to keep the numbers manageable.</p>
</li>
<li>
<p><strong>Final Answer</strong>: The final answer will be the sum of counts of all vowels for length <span class="math math-inline"><span class="katex"><span class="katex-mathml">nn</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">n</span></span></span></span></span>.</p>
</li>
</ol>
 */
class CountVowelsPermutation_Solution2 {
    // 5 ms 
    // 39.1 MB
    public int countVowelPermutation(int n) {
        final int MOD = 1000000007;
        
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        
        for (int j = 1; j < n; j++) {
            long a_next = e;
            long e_next = (a + i) % MOD;
            long i_next = (a + e + o + u) % MOD;
            long o_next = (i + u) % MOD;
            long u_next = a;
            
            a = a_next;
            e = e_next;
            i = i_next;
            o = o_next;
            u = u_next;
        }
        
        return (int)((a + e + i + o + u) % MOD);
    }
}
