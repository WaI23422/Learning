package BetterCodeAnswer.Medium.String;

import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/decode-ways/">91.Decode Ways</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>A message containing letters from <code>A-Z</code> can be <strong>encoded</strong> into numbers using the following mapping:</p>

<pre>'A' -&gt; "1"
'B' -&gt; "2"
...
'Z' -&gt; "26"
</pre>

<p>To <strong>decode</strong> an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, <code>"11106"</code> can be mapped into:</p>

<ul>
	<li><code>"AAJF"</code> with the grouping <code>(1 1 10 6)</code></li>
	<li><code>"KJF"</code> with the grouping <code>(11 10 6)</code></li>
</ul>

<p>Note that the grouping <code>(1 11 06)</code> is invalid because <code>"06"</code> cannot be mapped into <code>'F'</code> since <code>"6"</code> is different from <code>"06"</code>.</p>

<p>Given a string <code>s</code> containing only digits, return <em>the <strong>number</strong> of ways to <strong>decode</strong> it</em>.</p>

<p>The test cases are generated so that the answer fits in a <strong>32-bit</strong> integer.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "12"
<strong>Output:</strong> 2
<strong>Explanation:</strong> "12" could be decoded as "AB" (1 2) or "L" (12).
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "226"
<strong>Output:</strong> 3
<strong>Explanation:</strong> "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "06"
<strong>Output:</strong> 0
<strong>Explanation:</strong> "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> contains only digits and may contain leading zero(s).</li>
</ul>
</div></div>
 */
public class DecodeWays {
    public static void main(String[] args) {
        String[] tests = {
            "12",
            "05",
            "226"
        };

        for (String s : tests) {
            System.out.println(new DecodeWays_Solution().numDecodings(s));
        }
    }
}

// 0 ms 41.1 MB
class DecodeWays_Solution {
    public int numDecodings(String s) {
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1); 
        return numDecodings(s, 0, cache);
    }

    public int numDecodings(String s, int i, int[] cache) {
        if(i == s.length()) return 1;
        if (cache[i] != -1)return cache[i];

        int ways = 0;
        if (i < s.length() - 1) {
            int ch1 = s.charAt(i) - '0';
            int ch2 = s.charAt(i + 1) - '0';
            if (ch1 == 0 || ch1 >2 || (ch1 == 2 && ch2 > 6)) 
                ways = 0;
            else 
                ways += numDecodings(s, i + 2, cache);
        }
        if (s.charAt(i) != '0')
            ways += numDecodings(s, i + 1, cache);
        cache[i] = ways;
        return cache[i];

    }
}

// 1 ms 41.6 MB
/**
 * <h1 id="approach">Approach</h1>
 * <h4 id="1-check-if-the-input-string-s-is-empty-or-starts-with-0-if-so-return-0-because-a-valid-decoding-is-not-possible">1. Check if the input string <code>s</code> is empty or starts with '0'. If so, return 0 because a valid decoding is not possible.</h4>
 * <h4 id="2-initialize-a-dynamic-programming-array-dp-of-size-n--1-where-n-is-the-length-of-the-input-string-set-dp0-and-dp1-to-1-as-there-is-one-way-to-decode-an-empty-string-and-a-string-of-length-1">2. Initialize a dynamic programming array <code>dp</code> of size <code>n + 1</code>, where <code>n</code> is the length of the input string. Set <code>dp[0]</code> and <code>dp[1]</code> to 1, as there is one way to decode an empty string and a string of length 1.</h4>
 * <h4 id="3-iterate-through-the-string-starting-from-index-2-up-to-n--1">3. Iterate through the string starting from index 2 up to <code>n + 1</code>.</h4>
 * <ul>
<li>Convert the current one-digit and two-digit substrings to integers.</li>
<li>If the one-digit substring is not '0', update <code>dp[i]</code> by adding <code>dp[i - 1]</code> because we can consider the current digit as a single character.</li>
<li>If the two-digit substring is between 10 and 26 (inclusive), update <code>dp[i]</code> by adding <code>dp[i - 2]</code> because we can consider the current two digits as a single character.</li>
</ul>
<h4 id="4the-final-result-is-stored-in-dpn-where-n-is-the-length-of-the-input-string">4.The final result is stored in <code>dp[n]</code>, where n is the length of the input string.</h4>
 */
class DecodeWays_Solution2 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            int oneDigit = s.charAt(i - 1) - '0';
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit != 0) {
                dp[i] += dp[i - 1];
            }

            if (10 <= twoDigits && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
