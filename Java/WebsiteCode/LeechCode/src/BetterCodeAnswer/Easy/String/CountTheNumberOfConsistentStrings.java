package BetterCodeAnswer.Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/count-the-number-of-consistent-strings/">1684. Count the Number of Consistent Strings</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a string <code>allowed</code> consisting of <strong>distinct</strong> characters and an array of strings <code>words</code>. A string is <strong>consistent </strong>if all characters in the string appear in the string <code>allowed</code>.</p>
 * 
 * <p>Return<em> the number of <strong>consistent</strong> strings in the array </em><code>words</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * <strong>Output:</strong> 7
 * <strong>Explanation:</strong> All strings are consistent.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> Strings "cc", "acd", "ac", and "d" are consistent.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= words.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>1 &lt;= allowed.length &lt;=<sup> </sup>26</code></li>
 * 	<li><code>1 &lt;= words[i].length &lt;= 10</code></li>
 * 	<li>The characters in <code>allowed</code> are <strong>distinct</strong>.</li>
 * 	<li><code>words[i]</code> and <code>allowed</code> contain only lowercase English letters.</li>
 * </ul>
 * </div>
 */
public class CountTheNumberOfConsistentStrings {
    public static void main(String[] args) {
        String[][][] tests = {
            {
                {"abz"},
                {"ad","bd","aaab","baa","badab","az"}
            }
        };

        for (String[][] test : tests) {
            String allowed = test[0][0],
                   words[] = test[1];

            System.out.println(new CountTheNumberOfConsistentStrings_Solution().countConsistentStrings(allowed, words));
        }
    } 
}

// 4ms 44.60MB
class CountTheNumberOfConsistentStrings_Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] s = new boolean[26];
        for (char c : allowed.toCharArray()) {
            s[c - 'a'] = true;
        }
        int ans = 0;
        for (String w : words) {
            if (check(w, s)) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean check(String w, boolean[] s) {
        for (int i = 0; i < w.length(); ++i) {
            if (!s[w.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }
}