package BetterCodeAnswer.Easy.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/maximum-score-after-splitting-a-string/">1422.Maximum Score After Splitting a String</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given a&nbsp;string <code>s</code>&nbsp;of zeros and ones, <em>return the maximum score after splitting the string into two <strong>non-empty</strong> substrings</em> (i.e. <strong>left</strong> substring and <strong>right</strong> substring).</p>

<p>The score after splitting a string is the number of <strong>zeros</strong> in the <strong>left</strong> substring plus the number of <strong>ones</strong> in the <strong>right</strong> substring.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "011101"
<strong>Output:</strong> 5 
<strong>Explanation:</strong> 
All possible ways of splitting s into two non-empty substrings are:
left = "0" and right = "11101", score = 1 + 4 = 5 
left = "01" and right = "1101", score = 1 + 3 = 4 
left = "011" and right = "101", score = 1 + 2 = 3 
left = "0111" and right = "01", score = 1 + 1 = 2 
left = "01110" and right = "1", score = 2 + 1 = 3
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "00111"
<strong>Output:</strong> 5
<strong>Explanation:</strong> When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "1111"
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= s.length &lt;= 500</code></li>
	<li>The string <code>s</code> consists of characters <code>'0'</code> and <code>'1'</code> only.</li>
</ul>
</div></div>
 */
public class MaximumScoreAfterSplittingAString {
    public static void main(String[] args) {
        String[] tests = {
            "011101",
            "00111",
            "1111",
            "0100110",
            "011001",
            "000"
        };

        for (String s : tests) {
            System.out.println(new MaximumScoreAfterSplittingAString_Solution().maxScore(s));
        }
    }
}

// @see Easy.String.MaximumScoreAfterSplittingAString.java
class MaximumScoreAfterSplittingAString_Solution {
    public int maxScore(String s) {
        return 0;
    }
}