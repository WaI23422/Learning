package Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/longest-ideal-subsequence/">2370. Longest Ideal Subsequence</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code> consisting of lowercase letters and an integer <code>k</code>. We call a string <code>t</code> <strong>ideal</strong> if the following conditions are satisfied:</p>

<ul>
	<li><code>t</code> is a <strong>subsequence</strong> of the string <code>s</code>.</li>
	<li>The absolute difference in the alphabet order of every two <strong>adjacent</strong> letters in <code>t</code> is less than or equal to <code>k</code>.</li>
</ul>

<p>Return <em>the length of the <strong>longest</strong> ideal string</em>.</p>

<p>A <strong>subsequence</strong> is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.</p>

<p><strong>Note</strong> that the alphabet order is not cyclic. For example, the absolute difference in the alphabet order of <code>'a'</code> and <code>'z'</code> is <code>25</code>, not <code>1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "acfgbd", k = 2
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest ideal string is "acbd". The length of this string is 4, so 4 is returned.
Note that "acfgbd" is not ideal because 'c' and 'f' have a difference of 3 in alphabet order.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "abcd", k = 3
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest ideal string is "abcd". The length of this string is 4, so 4 is returned.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= k &lt;= 25</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>
</div>
 */
public class LongestIdealSubsequence {
    public static void main(String[] args) {
        String[][] tests = {
            {"acfgbd","2"},
            {"abcd","3"},
        };

        for (String[] test : tests) {
            String s = test[0];
            int k = Integer.parseInt(test[1]);

            System.out.println(new LongestIdealSubsequence_Solution().longestIdealString(s, k));
        }
    }
}

// 399 ms 201.48 MB
class LongestIdealSubsequence_Solution {
    Integer dp[][];
    String s;
    int k;
    public int longestIdealString(String s, int k) {
        this.s = s;
        this.k = k;
        dp = new Integer[s.length()][128];
        return solve(0, 0);
    }

    public int solve(int lastChar, int idx) {
        if(idx == s.length()){
            return 0;
        }
        if(dp[idx][lastChar] != null){
            return dp[idx][lastChar];
        }
        int val;
        if(lastChar != 0 && Math.abs(lastChar - (s.charAt(idx))) > k){
            val = solve(lastChar, idx+1);
        } else {
            val = Math.max(solve(lastChar, idx+1), 1 + solve(s.charAt(idx), idx+1));
        }
        return dp[idx][lastChar] = val;
    }
}
