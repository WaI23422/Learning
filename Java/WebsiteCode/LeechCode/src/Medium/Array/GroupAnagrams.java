package Medium.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/group-anagrams/">49.Group Anagrams</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of strings <code>strs</code>, group <strong>the anagrams</strong> together. You can return the answer in <strong>any order</strong>.</p>

<p>An <strong>Anagram</strong> is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> strs = ["eat","tea","tan","ate","nat","bat"]
<strong>Output:</strong> [["bat"],["nat","tan"],["ate","eat","tea"]]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> strs = [""]
<strong>Output:</strong> [[""]]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> strs = ["a"]
<strong>Output:</strong> [["a"]]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= strs[i].length &lt;= 100</code></li>
	<li><code>strs[i]</code> consists of lowercase English letters.</li>
</ul>
</div>
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[][] tests = {
            {"eat","tea","tan","ate","nat","bat"},
            {""},
            {"a"}
        };

        for (String[] strs : tests) {
            System.out.println(new GroupAnagrams_Solution().groupAnagrams(strs).toString());
        }
    }
}

// 971 ms 47.1 MB
class GroupAnagrams_Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>  ans = new ArrayList<>();

        for (String string : strs) {
            boolean listExist = false;
            In:
            for (int i = 0; i < ans.size(); i++) {
                if (isAnagrams(ans.get(i).get(0), string)) {
                    ans.get(i).add(string);
                    listExist = true;
                    break In;
                };
            }

            if (!listExist) {
                List<String> listAnagram = new ArrayList<>();
                listAnagram.add(string);
                ans.add(listAnagram);    
            }
        }

        return ans;
    }

    public boolean isAnagrams(String s, String t) {
        int[] arrChars = new int[26];

        if (s.length() != t.length()) {return false;}

        char[] sChars = s.toCharArray(), tChars = t.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            arrChars[sChars[i]-'a']++;
            arrChars[tChars[i]-'a']--;
        }

        for (int i : arrChars) {
            if (i != 0) {return false;}
        }

        return true;
    }
}