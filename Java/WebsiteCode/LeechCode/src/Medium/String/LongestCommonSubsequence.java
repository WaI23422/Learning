package Medium.String;

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

// 10 ms 50.7 MB
class LongestCommonSubsequence_Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] string1 = text1.toCharArray();
        char[] string2 = text2.toCharArray();
        int[][] memo = new int[string1.length + 1][string2.length + 1];

        for (int i=1; i<string1.length + 1; i++) {
            for (int j=1; j<string2.length + 1; j++) {
                if (string1[i - 1] == string2[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }

        return memo[string1.length][string2.length];
    }
}