package Easy.String;

/**
 * <div class="flex-1"><div class="flex h-full items-center"><a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/repeated-substring-pattern/">459.Repeated Substring Pattern</a><div class="inline-flex min-h-[20px] items-center space-x-2 align-top mt-1"><div class="inline-flex items-center space-x-2"></div></div></div></div>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given a string <code>s</code>, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "abab"
<strong>Output:</strong> true
<strong>Explanation:</strong> It is the substring "ab" twice.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "aba"
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "abcabcabcabc"
<strong>Output:</strong> true
<strong>Explanation:</strong> It is the substring "abc" four times or the substring "abcabc" twice.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>
</div></div>
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "ababab";

        RepeatedSubstringPattern_Solution repeatedSubstringPattern_Solution = new RepeatedSubstringPattern_Solution();

        System.out.println(repeatedSubstringPattern_Solution.repeatedSubstringPattern(s));;
    }   
}

class RepeatedSubstringPattern_Solution {
    // 112 ms
    // 44.2 MB
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder substr = new StringBuilder();

        if (s.length() < 2) {
            return false;
        }

        Out:
        for (int i = 0; i < s.length()/2; i++) {
            int pos = 0;
            substr.append(s.charAt(i));
            while (pos < s.length()) {
                if (s.regionMatches(substr.length()+pos, substr.toString(), 0, substr.length()) == false) {
                    continue Out;
                } else {
                    pos += substr.length();
                    if (pos == s.length() - substr.length()) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}