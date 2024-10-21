package BetterCodeAnswer.Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/make-the-string-great/">1544. Make The String Great</a>
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code> of lower and upper case English letters.</p>

<p>A good string is a string which doesn't have <strong>two adjacent characters</strong> <code>s[i]</code> and <code>s[i + 1]</code> where:</p>

<ul>
	<li><code>0 &lt;= i &lt;= s.length - 2</code></li>
	<li><code>s[i]</code> is a lower-case letter and <code>s[i + 1]</code> is the same letter but in upper-case or <strong>vice-versa</strong>.</li>
</ul>

<p>To make the string good, you can choose <strong>two adjacent</strong> characters that make the string bad and remove them. You can keep doing this until the string becomes good.</p>

<p>Return <em>the string</em> after making it good. The answer is guaranteed to be unique under the given constraints.</p>

<p><strong>Notice</strong> that an empty string is also good.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "leEeetcode"
<strong>Output:</strong> "leetcode"
<strong>Explanation:</strong> In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "abBAcC"
<strong>Output:</strong> ""
<strong>Explanation:</strong> We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --&gt; "aAcC" --&gt; "cC" --&gt; ""
"abBAcC" --&gt; "abBA" --&gt; "aA" --&gt; ""
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "s"
<strong>Output:</strong> "s"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> contains only lower and upper case English letters.</li>
</ul>
</div>
 */
public class MakeTheStringGreat {
    public static void main(String[] args) {
        String[] tests = {
            "NAanorRoOrROwnTNW",
            "hKhHkHjgGJEiBbIe",
            "qFxXfQo",
            "abBAcC",
            "leEeetcode",
            "s"
        };

        for (String s : tests) {
            System.out.println(new MakeTheStringGreat_Solution().makeGood(s));
        }
    }
}

// 1 ms 41.58 MB
class MakeTheStringGreat_Solution {
    public String makeGood(String s) {
        if (s.length() == 0 || s.length() == 1)
            return s;

        StringBuilder sb = new StringBuilder();

        sb.append(s);

        int i = 0;
        while (i < sb.length() - 1){
            if (Math.abs(sb.charAt(i) - sb.charAt(i + 1)) == 32) {
                sb.delete(i, i + 2);
                if (i > 0)
                    i--;
            } else {
                i++;
            } 
        }

        return sb.toString();
    }
}