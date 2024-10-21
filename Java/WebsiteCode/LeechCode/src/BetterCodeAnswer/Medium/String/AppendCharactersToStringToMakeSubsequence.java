package BetterCodeAnswer.Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/append-characters-to-string-to-make-subsequence/">2486. Append Characters to String to Make Subsequence</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given two strings <code>s</code> and <code>t</code> consisting of only lowercase English letters.</p>
 * 
 * <p>Return <em>the minimum number of characters that need to be appended to the end of </em><code>s</code><em> so that </em><code>t</code><em> becomes a <strong>subsequence</strong> of </em><code>s</code>.</p>
 * 
 * <p>A <strong>subsequence</strong> is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "coaching", t = "coding"
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> Append the characters "ding" to the end of s so that s = "coachingding".
 * Now, t is a subsequence of s ("<u><strong>co</strong></u>aching<u><strong>ding</strong></u>").
 * It can be shown that appending any 3 characters to the end of s will never make t a subsequence.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "abcde", t = "a"
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> t is already a subsequence of s ("<u><strong>a</strong></u>bcde").
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "z", t = "abcde"
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> Append the characters "abcde" to the end of s so that s = "zabcde".
 * Now, t is a subsequence of s ("z<u><strong>abcde</strong></u>").
 * It can be shown that appending any 4 characters to the end of s will never make t a subsequence.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length, t.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>s</code> and <code>t</code> consist only of lowercase English letters.</li>
 * </ul>
 * </div>
 */
public class AppendCharactersToStringToMakeSubsequence {
    public static void main(String[] args) {
        String[][] tests = {
            {"coaching","coding"},
            {"memtmmet","metoo"}
        };

        for (String[] test : tests) {
            String s = test[0],
                   t = test[1];

            System.out.println(new AppendCharactersToStringToMakeSubsequence_Solution().appendCharacters(s, t));
        }
    }
}

// 3 ms 45.4 MB
class AppendCharactersToStringToMakeSubsequence_Solution {
    public int appendCharacters(String s, String t) {
        if(s.equals(t))
            return 0;
        char chS[] = s.toCharArray();
        char chT[] = t.toCharArray();

        int i = 0, j = 0;
        int m = chS.length, n = chT.length;
        for(; i < m; i++)
        {
            if(chS[i] == chT[j])
                j++;
            
            if(j == n)
                return 0;
        }

        return n - j;
    }
}