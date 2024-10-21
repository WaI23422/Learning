package BetterCodeAnswer.Easy.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/largest-substring-between-two-equal-characters/">1624.Largest Substring Between Two Equal Characters</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given a string <code>s</code>, return <em>the length of the longest substring between two equal characters, excluding the two characters.</em> If there is no such substring return <code>-1</code>.</p>

<p>A <strong>substring</strong> is a contiguous sequence of characters within a string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "aa"
<strong>Output:</strong> 0
<strong>Explanation:</strong> The optimal substring here is an empty substring between the two <code>'a's</code>.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "abca"
<strong>Output:</strong> 2
<strong>Explanation:</strong> The optimal substring here is "bc".
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "cbzxy"
<strong>Output:</strong> -1
<strong>Explanation:</strong> There are no characters that appear twice in s.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 300</code></li>
	<li><code>s</code> contains only lowercase English letters.</li>
</ul>
</div></div>
 */
public class LargestSubstringBetweenTwoEqualCharacters {
    public static void main(String[] args) {
        String[] tests = {
            "aa",
            "abca",
            "cbzxy"
        };

        for (String s : tests) {
            System.out.println(new LargestSubstringBetweenTwoEqualCharacters_Solution().maxLengthBetweenEqualCharacters(s));
        }
    }
}

// 0 ms 41.1 MB
class LargestSubstringBetweenTwoEqualCharacters_Solution {                
    public int maxLengthBetweenEqualCharacters(String s) {
        for (int i=s.length()-1; i>0;i--){
            for (int j=0; j+i<s.length(); j++){
                if (s.charAt(j) == s.charAt(j+i)) return i-1;
            }
        }
        return -1;
    }
}
