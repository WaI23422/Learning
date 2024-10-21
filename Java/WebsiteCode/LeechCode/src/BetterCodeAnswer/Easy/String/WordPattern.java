package BetterCodeAnswer.Easy.String;

import java.util.HashMap;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/word-pattern/">290. Word Pattern</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a <code>pattern</code> and a string <code>s</code>, find if <code>s</code>&nbsp;follows the same pattern.</p>

<p>Here <b>follow</b> means a full match, such that there is a bijection between a letter in <code>pattern</code> and a <b>non-empty</b> word in <code>s</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> pattern = "abba", s = "dog cat cat dog"
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> pattern = "abba", s = "dog cat cat fish"
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> pattern = "aaaa", s = "dog cat cat dog"
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= pattern.length &lt;= 300</code></li>
	<li><code>pattern</code> contains only lower-case English letters.</li>
	<li><code>1 &lt;= s.length &lt;= 3000</code></li>
	<li><code>s</code> contains only lowercase English letters and spaces <code>' '</code>.</li>
	<li><code>s</code> <strong>does not contain</strong> any leading or trailing spaces.</li>
	<li>All the words in <code>s</code> are separated by a <strong>single space</strong>.</li>
</ul>
</div>
 */
public class WordPattern {
    public static void main(String[] args) {
        String[][] tests = {
            {"e","eukera"},
            {"abba","dog dog dog dog"},
            {"abba", "dog cat cat dog"},
            {"abba","dog cat cat fish"},
        };

        for (String[] test : tests) {
            String pattern = test[0],
                   s = test[1];
            
            System.out.println(new WordPattern_Solution().wordPattern(pattern, s));
        }
    }
}

// 0 ms 41.8 MB
class WordPattern_Solution {
    public boolean wordPattern(String pattern, String s) {
        
        HashMap<Character, String> map = new HashMap<>();

        String[] words = s.split(" ");

        if(words.length != pattern.length()){
            return false;
        }

        for(int i = 0; i < pattern.length(); i++){
            
            char org = pattern.charAt(i);
            String rep = words[i];

            if(map.containsKey(org)){
                if(!map.get(org).equals(rep)){
                    return false;
                }
            }
            else{
                if(map.containsValue(rep)){
                    return false;
                }
                map.put(org, rep);
            }
        }
        return true;
    }
}


