package BetterCodeAnswer.Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate
 * cursor-text whitespace-normal hover:!text-[inherit]" href=
 * "/problems/rotate-string/">796. Rotate String</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content">
 * <p>
 * Given two strings <code>s</code> and <code>goal</code>, return
 * <code>true</code> <em>if and only if</em> <code>s</code> <em>can become</em>
 * <code>goal</code> <em>after some number of <strong>shifts</strong> on</em>
 * <code>s</code>.
 * </p>
 * 
 * <p>
 * A <strong>shift</strong> on <code>s</code> consists of moving the leftmost
 * character of <code>s</code> to the rightmost position.
 * </p>
 * 
 * <ul>
 * <li>For example, if <code>s = "abcde"</code>, then it will be
 * <code>"bcdea"</code> after one shift.</li>
 * </ul>
 * 
 * <p>
 * &nbsp;
 * </p>
 * <p>
 * <strong class="example">Example 1:</strong>
 * </p>
 * 
 * <pre>
 * <strong>Input:</strong> s = "abcde", goal = "cdeab"
 * <strong>Output:</strong> true
 * </pre>
 * <p>
 * <strong class="example">Example 2:</strong>
 * </p>
 * 
 * <pre>
 * <strong>Input:</strong> s = "abcde", goal = "abced"
 * <strong>Output:</strong> false
 * </pre>
 * <p>
 * &nbsp;
 * </p>
 * <p>
 * <strong>Constraints:</strong>
 * </p>
 * 
 * <ul>
 * <li><code>1 &lt;= s.length, goal.length &lt;= 100</code></li>
 * <li><code>s</code> and <code>goal</code> consist of lowercase English
 * letters.</li>
 * </ul>
 * </div></div>
 */
public class RotateString {
    public static void main(String[] args) {
        String[][] tests = {
            {
                    "abcde",
                    "cdeab"
            },
            {
                    "abcde",
                    "abced"
            },
        };

        for (String[] test : tests) {
            String s = test[0],
                    goal = test[1];

            System.out.println(new RotateString_Solution().rotateString(s, goal));
        }
    }
}

// 0ms 41.26MB
class RotateString_Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        String str = s + s;
        if (str.contains(goal))
            return true;
        return false;
    }

}