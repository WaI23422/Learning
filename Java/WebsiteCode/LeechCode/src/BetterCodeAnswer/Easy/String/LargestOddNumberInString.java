package BetterCodeAnswer.Easy.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/largest-odd-number-in-string/">1903.Largest Odd Number in String</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given a string <code>num</code>, representing a large integer. Return <em>the <strong>largest-valued odd</strong> integer (as a string) that is a <strong>non-empty substring</strong> of </em><code>num</code><em>, or an empty string </em><code>""</code><em> if no odd integer exists</em>.</p>

<p>A <strong>substring</strong> is a contiguous sequence of characters within a string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> num = "52"
<strong>Output:</strong> "5"
<strong>Explanation:</strong> The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> num = "4206"
<strong>Output:</strong> ""
<strong>Explanation:</strong> There are no odd numbers in "4206".
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> num = "35427"
<strong>Output:</strong> "35427"
<strong>Explanation:</strong> "35427" is already an odd number.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num.length &lt;= 10<sup>5</sup></code></li>
	<li><code>num</code> only consists of digits and does not contain any leading zeros.</li>
</ul>
</div></div>
 */
public class LargestOddNumberInString {
    public static void main(String[] args) {
        String[] tests = {
            "52",
            "4206",
            "35427"
        };

        for (String num : tests) {
            System.out.println(new LargestOddNumberInString_Solution().largestOddNumber(num));
        }
    }
}

// @see BetterCodeAnswer.Easy.String.LargestOddNumberInString.java
class LargestOddNumberInString_Solution {
    public String largestOddNumber(String num) {
        return "";
    }
}