package BetterCodeAnswer.Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/longest-happy-string/">1405. Longest Happy String</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>A string <code>s</code> is called <strong>happy</strong> if it satisfies the following conditions:</p>
 * 
 * <ul>
 * 	<li><code>s</code> only contains the letters <code>'a'</code>, <code>'b'</code>, and <code>'c'</code>.</li>
 * 	<li><code>s</code> does not contain any of <code>"aaa"</code>, <code>"bbb"</code>, or <code>"ccc"</code> as a substring.</li>
 * 	<li><code>s</code> contains <strong>at most</strong> <code>a</code> occurrences of the letter <code>'a'</code>.</li>
 * 	<li><code>s</code> contains <strong>at most</strong> <code>b</code> occurrences of the letter <code>'b'</code>.</li>
 * 	<li><code>s</code> contains <strong>at most</strong> <code>c</code> occurrences of the letter <code>'c'</code>.</li>
 * </ul>
 * 
 * <p>Given three integers <code>a</code>, <code>b</code>, and <code>c</code>, return <em>the <strong>longest possible happy </strong>string</em>. If there are multiple longest happy strings, return <em>any of them</em>. If there is no such string, return <em>the empty string </em><code>""</code>.</p>
 * 
 * <p>A <strong>substring</strong> is a contiguous sequence of characters within a string.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> a = 1, b = 1, c = 7
 * <strong>Output:</strong> "ccaccbcc"
 * <strong>Explanation:</strong> "ccbccacc" would also be a correct answer.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> a = 7, b = 1, c = 0
 * <strong>Output:</strong> "aabaa"
 * <strong>Explanation:</strong> It is the only correct answer in this case.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= a, b, c &lt;= 100</code></li>
 * 	<li><code>a + b + c &gt; 0</code></li>
 * </ul>
 * </div></div>
 */
public class LongestHappyString {
    public static void main(String[] args) {
        int[][] tests = {
            {1,1,7},
            {7,7,7},
            {2,0,0},
            {0,0,0}
        };

        for (int[] test : tests) {
            int a = test[0],
                b = test[1],
                c = test[2];

            System.out.println(new LongestHappyString_Solution().longestDiverseString(a, b, c));
        }
    }
}

class LongestHappyString_Solution {

    public String longestDiverseString(int a, int b, int c) {
        int curra = 0, currb = 0, currc = 0;
        // Maximum total iterations possible is given by the sum of a, b and c.
        int totalIterations = a + b + c;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < totalIterations; i++) {
            if (
                (a >= b && a >= c && curra != 2) ||
                (a > 0 && (currb == 2 || currc == 2))
            ) {
                // If 'a' is maximum and it's streak is less than 2, or if streak of 'b' or 'c' is 2, then 'a' will be the next character.
                ans.append('a');
                a--;
                curra++;
                currb = 0;
                currc = 0;
            } else if (
                (b >= a && b >= c && currb != 2) ||
                (b > 0 && (currc == 2 || curra == 2))
            ) {
                // If 'b' is maximum and it's streak is less than 2, or if streak of 'a' or 'c' is 2, then 'b' will be the next character.
                ans.append('b');
                b--;
                currb++;
                curra = 0;
                currc = 0;
            } else if (
                (c >= a && c >= b && currc != 2) ||
                (c > 0 && (curra == 2 || currb == 2))
            ) {
                // If 'c' is maximum and it's streak is less than 2, or if streak of 'a' or 'b' is 2, then 'c' will be the next character.
                ans.append('c');
                c--;
                currc++;
                curra = 0;
                currb = 0;
            }
        }
        return ans.toString();
    }
}