package Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximum-score-from-removing-substrings/">1717. Maximum Score From Removing Substrings</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code> and two integers <code>x</code> and <code>y</code>. You can perform two types of operations any number of times.</p>
 * 
 * <ul>
 * 	<li>Remove substring <code>"ab"</code> and gain <code>x</code> points.
 * 
 * 	<ul>
 * 		<li>For example, when removing <code>"ab"</code> from <code>"c<u>ab</u>xbae"</code> it becomes <code>"cxbae"</code>.</li>
 * 	</ul>
 * 	</li>
 * 	<li>Remove substring <code>"ba"</code> and gain <code>y</code> points.
 * 	<ul>
 * 		<li>For example, when removing <code>"ba"</code> from <code>"cabx<u>ba</u>e"</code> it becomes <code>"cabxe"</code>.</li>
 * 	</ul>
 * 	</li>
 * </ul>
 * 
 * <p>Return <em>the maximum points you can gain after applying the above operations on</em> <code>s</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "cdbcbbaaabab", x = 4, y = 5
 * <strong>Output:</strong> 19
 * <strong>Explanation:</strong>
 * - Remove the "ba" underlined in "cdbcbbaaa<u>ba</u>b". Now, s = "cdbcbbaaab" and 5 points are added to the score.
 * - Remove the "ab" underlined in "cdbcbbaa<u>ab</u>". Now, s = "cdbcbbaa" and 4 points are added to the score.
 * - Remove the "ba" underlined in "cdbcb<u>ba</u>a". Now, s = "cdbcba" and 5 points are added to the score.
 * - Remove the "ba" underlined in "cdbc<u>ba</u>". Now, s = "cdbc" and 5 points are added to the score.
 * Total score = 5 + 4 + 5 + 5 = 19.</pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "aabbaaxybbaabb", x = 5, y = 4
 * <strong>Output:</strong> 20
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= x, y &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>s</code> consists of lowercase English letters.</li>
 * </ul>
 * </div>
 */
public class MaximumScoreFromRemovingSubstrings {
    public static void main(String[] args) {
        Object[][] tests = {
            {"cdbcbbaaabab",4,5},
        };

        for (Object[] test : tests) {
            String s = (String) test[0];
            int x = (int) test[1],
                y = (int) test[2];

            System.out.println(new MaximumScoreFromRemovingSubstrings_Solution().maximumGain(s, x, y));
        }
    }
}

// 20ms 44.9MB
class MaximumScoreFromRemovingSubstrings_Solution {
    public int maximumGain(String s, int x, int y) {
        
        int aCount = 0;
        int bCount = 0;
        int lesser = Math.min(x, y);
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > 'b') {
                result += Math.min(aCount, bCount) * lesser;
                aCount = 0;
                bCount = 0;
            } else if (c == 'a') {
                if (x < y && bCount > 0) {
                    bCount--;
                    result += y;
                } else {
                    aCount++;
                }
            } else {
                if (x > y && aCount > 0) {
                    aCount--;
                    result += x;
                } else {
                    bCount++;
                };
            }
        }
        
        result += Math.min(aCount, bCount) * lesser;
        
        return result;
    }
}