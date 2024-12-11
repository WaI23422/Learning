package BetterCodeAnswer.Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/longest-common-subsequence/">1143.Longest Common Subsequence</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given two strings <code>text1</code> and <code>text2</code>, return <em>the length of their longest <strong>common subsequence</strong>. </em>If there is no <strong>common subsequence</strong>, return <code>0</code>.</p>

<p>A <strong>subsequence</strong> of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.</p>

<ul>
	<li>For example, <code>"ace"</code> is a subsequence of <code>"abcde"</code>.</li>
</ul>

<p>A <strong>common subsequence</strong> of two strings is a subsequence that is common to both strings.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> text1 = "abcde", text2 = "ace" 
<strong>Output:</strong> 3  
<strong>Explanation:</strong> The longest common subsequence is "ace" and its length is 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> text1 = "abc", text2 = "abc"
<strong>Output:</strong> 3
<strong>Explanation:</strong> The longest common subsequence is "abc" and its length is 3.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> text1 = "abc", text2 = "def"
<strong>Output:</strong> 0
<strong>Explanation:</strong> There is no such common subsequence, so the result is 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= text1.length, text2.length &lt;= 1000</code></li>
	<li><code>text1</code> and <code>text2</code> consist of only lowercase English characters.</li>
</ul>
</div>
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String[][] tests = {
            {"abcde","ace" },
            {"abc","abc"},
            {"abc","def"},
            {"ezupkr","ubmrapg"}
        };

        for (String[] strings : tests) {
            String text1 = strings[0], text2 = strings[1];

            System.out.println(new LongestCommonSubsequence_Solution().longestCommonSubsequence(text1, text2));
        }
    }
}

// 6 ms 41.4 MB
class LongestCommonSubsequence_Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.equals(text2))
           return text1.length();
        
        char tb1[] = text1.toCharArray();
        char tb2[] = text2.toCharArray();

        if(tb1.length > tb2.length) {
            int dp[] = new int[tb1.length + 1];
            for(int i = 0; i < tb2.length; i++) {
                int pc = 0, prc;
                for(int j = 0; j < tb1.length; j++) {
                    prc = pc;
                    pc = dp[j + 1];
                    if(tb2[i] == tb1[j]) {
                        dp[j + 1] = prc + 1;
                    } else {
                        dp[j + 1] = Math.max(pc, dp[j]);
                    }
                }
            }

            return dp[tb1.length];
        } else {
            int dp[] = new int[tb2.length + 1];
            for(int i = 0; i < tb1.length; i++) {
                int pc = 0, prc;
                for(int j = 0; j < tb2.length; j++) {
                    prc = pc;
                    pc = dp[j + 1];
                    if(tb1[i] == tb2[j]) {
                        dp[j + 1] = prc + 1;
                    } else {
                        dp[j + 1] = Math.max(pc, dp[j]);
                    }
                }
            }

            return dp[tb2.length];
        }
    }
}

// 20 ms 51 MB
class LongestCommonSubsequence_Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        // Lengths of the input strings
        int length1 = text1.length();
        int length2 = text2.length();
      
        // Create a 2D array to store the lengths of longest common subsequences
        // for all subproblems, initialized with zero
        int[][] dp = new int[length1 + 1][length2 + 1];

        // Build the dp array from the bottom up
        for (int i = 1; i <= length1; ++i) {
            for (int j = 1; j <= length2; ++j) {
                // If characters match, take diagonal value and add 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // If characters do not match, take the maximum value from 
                // the left (dp[i][j-1]) or above (dp[i-1][j])
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // The bottom-right cell contains the length of the longest
        // common subsequence of text1 and text2
        return dp[length1][length2];
    }
}