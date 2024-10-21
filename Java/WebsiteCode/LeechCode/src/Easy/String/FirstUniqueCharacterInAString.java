package Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/first-unique-character-in-a-string/">387.First Unique Character in a String</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code>, <em>find the first non-repeating character in it and return its index</em>. If it does not exist, return <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "leetcode"
<strong>Output:</strong> 0
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "loveleetcode"
<strong>Output:</strong> 2
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> s = "aabb"
<strong>Output:</strong> -1
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists of only lowercase English letters.</li>
</ul>
</div>
 */
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        String[] tests = {
            "leetcode",
            "loveleetcode",
            "aabb",
            "dddccdbba"
        };

        for (String s : tests) {
            System.out.println(new FirstUniqueCharacterInAString_Solution().firstUniqChar(s));
        }
    }
}

// 4 ms 45.6 MB
class FirstUniqueCharacterInAString_Solution {
    public int firstUniqChar(String s) {
        int index = 0, indexUniqueChar = Integer.MAX_VALUE;
        int[] charArr = new int[26], indexArr = new int[26];

        for (char i : s.toCharArray()) {
            charArr[i-'a']++;
            indexArr[i-'a'] = index++;
        }

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == 1 && indexUniqueChar > indexArr[i]) { indexUniqueChar = indexArr[i];}
        }
        
        return indexUniqueChar==Integer.MAX_VALUE?-1:indexUniqueChar;
    }
}