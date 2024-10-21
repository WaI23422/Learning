package BetterCodeAnswer.Hard.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-window-substring/">76.Minimum Window Substring</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given two strings <code>s</code> and <code>t</code> of lengths <code>m</code> and <code>n</code> respectively, return <em>the <strong>minimum window</strong></em> <span data-keyword="substring-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:rt:"><div><strong><em>substring</em></strong></div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(56px, 204px);"></div></div></div></span><em> of </em><code>s</code><em> such that every character in </em><code>t</code><em> (<strong>including duplicates</strong>) is included in the window</em>. If there is no such substring, return <em>the empty string </em><code>""</code>.</p>

<p>The testcases will be generated such that the answer is <strong>unique</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "ADOBECODEBANC", t = "ABC"
<strong>Output:</strong> "BANC"
<strong>Explanation:</strong> The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "a", t = "a"
<strong>Output:</strong> "a"
<strong>Explanation:</strong> The entire string s is the minimum window.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "a", t = "aa"
<strong>Output:</strong> ""
<strong>Explanation:</strong> Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == s.length</code></li>
	<li><code>n == t.length</code></li>
	<li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> and <code>t</code> consist of uppercase and lowercase English letters.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you find an algorithm that runs in <code>O(m + n)</code> time?</p>
</div>
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String[][] tests = {
            {"ADOBECODEBANC","ABC"},
            {"a","a"},
            {"a","aa"}
        };

        for (String[] test : tests) {
            String s = test[0], t = test[1];

            System.out.println(new MinimumWindowSubstring_Solution().minWindow(s, t));
        }
    }
}

// 1 ms 44.9 MB
class MinimumWindowSubstring_Solution {
    public String minWindow(String s, String t) {
        int[] map= new int[123];
        int left=0,right=0, count=t.length(),sub_len= Integer.MAX_VALUE,start=0;

        for(char c: t.toCharArray()) 
            map[c]++;

        char[] ch = s.toCharArray();
        while(right<s.length())
        {
            if(map[ch[right++]]-->0) count--;

            while(count==0)
            {
                if((right-left)<sub_len) sub_len= right-(start=left);
                if(map[ch[left++]]++==0) count++;
            }
        }

        return sub_len==Integer.MAX_VALUE? "": s.substring(start,start+sub_len);
    }
}
