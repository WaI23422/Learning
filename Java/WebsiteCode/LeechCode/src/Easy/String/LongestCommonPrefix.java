package Easy.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/longest-common-prefix/">14.Longest Common Prefix</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Write a function to find the longest common prefix string amongst an array of strings.</p>

<p>If there is no common prefix, return an empty string <code>""</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> strs = ["flower","flow","flight"]
<strong>Output:</strong> "fl"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> strs = ["dog","racecar","car"]
<strong>Output:</strong> ""
<strong>Explanation:</strong> There is no common prefix among the input strings.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 200</code></li>
	<li><code>0 &lt;= strs[i].length &lt;= 200</code></li>
	<li><code>strs[i]</code> consists of only lowercase English letters.</li>
</ul>
</div></div>
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[][] tests = {
            {"flower","flow","flight"},
            {"dog","racecar","car"},
            {"flower","flow","fl"},
            {"aa","aa"}
        };

        for (String[] strings : tests) {
            System.out.println(new LongestCommonPrefix_Solution().longestCommonPrefix(strings));    
        }
    }
}

class LongestCommonPrefix_Solution {
    // 8 ms 40.8 MB
    public String longestCommonPrefix(String[] strs) {
        String ans = "", consider = strs[0];
        int state = 0, pos = 0;

        for (int i = 0; i < consider.length(); i++) {
            state = 0;

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].indexOf(consider.charAt(i),pos) != pos) {state--;}
            }

            if (state == 0 ) {ans += consider.charAt(i); pos++;}
            else{return ans;}
        }

        return ans;
    }
}

class LongestCommonPrefix_Solution2 {
    // 8 ms 41.2 MB
    public String longestCommonPrefix(String[] strs) {
        String ans = "", consider = strs[0];
        int state = 0, pos = 0;

        for (String string : strs) {
            if (string.length() < consider.length()) {
                consider = string;
            }
        }

        char[] considerChars = consider.toCharArray();

        for (char c : considerChars) {
            for (String string : strs) {
                if (string.charAt(pos) != c) {state--;}
            }

            if (state == 0) {ans += c; pos++;}
            else {return ans;}
        }

        return ans;
    }
}
