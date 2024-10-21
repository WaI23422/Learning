package Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/reverse-string-ii/">541. Reverse String II</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code> and an integer <code>k</code>, reverse the first <code>k</code> characters for every <code>2k</code> characters counting from the start of the string.</p>
 * 
 * <p>If there are fewer than <code>k</code> characters left, reverse all of them. If there are less than <code>2k</code> but greater than or equal to <code>k</code> characters, then reverse the first <code>k</code> characters and leave the other as original.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> s = "abcdefg", k = 2
 * <strong>Output:</strong> "bacdfeg"
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> s = "abcd", k = 2
 * <strong>Output:</strong> "bacd"
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>s</code> consists of only lowercase English letters.</li>
 * 	<li><code>1 &lt;= k &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * </div>
 */
public class ReverseStringII {
    public static void main(String[] args) {
        Object[][] tests = {
            {"abcdefg", 2}
        };

        for (Object[] test : tests) {
            String s = (String) test[0];
            int k = (int) test[1];

            System.out.println(new ReverseStringII_Solution().reverseStr(s, k));
        }
    }
}

// 4 ms 43.7 MB
class ReverseStringII_Solution {
    public String reverseStr(String s, int k) {
        if (k > s.length()) {return new StringBuffer(s).reverse().toString();}
        StringBuffer reverse = new StringBuffer();
        int turn = 0,
            len = s.length();

        for (int i = 0; i < len; i+=k) {
            if (turn%2 == 0) {
                int startRe = i+k-1;
                while (startRe >= i) {
                    reverse.append(s.charAt(startRe--));
                }
            } else {
                for (int j = i; j < i+k && j < len; j++) {
                    reverse.append(s.charAt(j));
                }
            }
            turn++;
        }

        return reverse.toString();
    }
}