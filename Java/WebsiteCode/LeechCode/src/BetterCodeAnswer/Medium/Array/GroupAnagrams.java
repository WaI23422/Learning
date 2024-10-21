package BetterCodeAnswer.Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.AbstractList;
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

// 7ms 47.6 MB
class GroupAnagrams_Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

// 12 ms 48 MB
class GroupAnagrams_Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        // for each word
        for (String s : strs) {
            // count the freq of char
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            // calc the key 
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    sb.append('a' + i);
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();
            // put in map
            map.computeIfAbsent(key, k -> new ArrayList<String>()).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}


// 0ms 48.3 MB
class GroupAnagrams_Solution {
    private List<List<String>> res;

    public List<List<String>> groupAnagrams(String[] strs) {        
        return new AbstractList<List<String>>() {
            @Override
            public List<String> get(int index) {
                if (res == null) init();
                return res.get(index);
            }
            
            @Override
            public int size() {
                if (res == null) init();
                return res.size();
            }
            
            private void init() {
                Map<String, List<String>> map = new HashMap<>();
                for (String s : strs) {
                    int[] count = new int[26];
                    for (char c : s.toCharArray()) {
                        count[c - 'a']++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 26; i++) {
                        if (count[i] != 0) {
                            sb.append('a' + i);
                            sb.append(count[i]);
                        }
                    }
                    String key = sb.toString();
                    map.computeIfAbsent(key, k -> new ArrayList<String>()).add(s);
                    res = new ArrayList<>(map.values());
                }
            }
        };
    }
}