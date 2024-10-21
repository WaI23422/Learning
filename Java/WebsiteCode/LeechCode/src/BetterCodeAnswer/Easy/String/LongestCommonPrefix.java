package BetterCodeAnswer.Easy.String;

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
            {"dog","racecar","car"}
        };

        for (String[] strings : tests) {
            System.out.println(new LongestCommonPrefix_Solution().longestCommonPrefix(strings));    
        }
    }
}

/**
 * <h1 id="approach">Approach</h1>
 * <ul>
<li>
<p>If the input array strs is empty, return an empty string because there is no common prefix.</p>
</li>
<li>
<p>Initialize a variable prefix with an initial value equal to the first string in the array strs[0].</p>
</li>
<li>
<p>Iterate through the rest of the strings in the array strs starting from the second string (index 1).</p>
</li>
<li>
<p>For each string in the array, compare its characters with the characters of the prefix string.</p>
</li>
<li>
<p>While comparing, if we find a mismatch between the characters or if the prefix becomes empty, return the current value of prefix as the longest common prefix.</p>
</li>
<li>
<p>After iterating through all strings, return the final value of prefix as the longest common prefix.</p>
</li>
</ul>
 */
class LongestCommonPrefix_Solution {
    // 0 ms 40.8 MB
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (String s : strs){
            while (s.indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
                
        return prefix;
    }
}
