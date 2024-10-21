package Hard.String;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/word-break-ii/">140. Word Break II</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code> and a dictionary of strings <code>wordDict</code>, add spaces in <code>s</code> to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in <strong>any order</strong>.</p>
 * 
 * <p><strong>Note</strong> that the same word in the dictionary may be reused multiple times in the segmentation.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * <strong>Output:</strong> ["cats and dog","cat sand dog"]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * <strong>Output:</strong> ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * <strong>Explanation:</strong> Note that you are allowed to reuse a dictionary word.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * <strong>Output:</strong> []
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 20</code></li>
 * 	<li><code>1 &lt;= wordDict.length &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= wordDict[i].length &lt;= 10</code></li>
 * 	<li><code>s</code> and <code>wordDict[i]</code> consist of only lowercase English letters.</li>
 * 	<li>All the strings of <code>wordDict</code> are <strong>unique</strong>.</li>
 * 	<li>Input is generated in a way that the length of the answer doesn't exceed&nbsp;10<sup>5</sup>.</li>
 * </ul>
 * </div>
 */
public class WordBreakII {
    public static void main(String[] args) {
        String[][][] tests = {
            {
                {"pineapplepenapple"},
                {"apple","pen","applepen","pine","pineapple"}
            },
            {
                {"catsanddog"},
                {"cat","cats","and","sand","dog"}
            },
        };

        for (String[][] test : tests) {
            String s = test[0][0];

            List<String> wordDict = new ArrayList<>();
            for (String word : test[1]) {
                wordDict.add(word);
            }

            System.out.println(new WordBreakII_Solution().wordBreak(s, wordDict));
        }
    }
}

// 1 ms 41.5 MB
class WordBreakII_Solution {
    List<String> listValidString = new ArrayList<>();
    int len;
    public List<String> wordBreak(String s, List<String> wordDict) {
        len = s.length();

        createValidString(s, new StringBuffer(), wordDict, 0);

        return listValidString;
    }

    private void createValidString(String s,StringBuffer str, List<String> wordDict, int idx) {
        StringBuffer word = new StringBuffer();

        for (int i = idx; i < len; i++) {
            word.append(s.charAt(i));
            if (wordDict.contains(word.toString())) {
                if (i == len - 1) {
                    listValidString.add(str.append(word).toString());
                } else {
                    createValidString(s, new StringBuffer(str).append(word).append(" "), wordDict, i+1);
                }
            }
        }
    }
}