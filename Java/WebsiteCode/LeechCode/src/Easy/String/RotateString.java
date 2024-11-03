package Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/rotate-string/">796. Rotate String</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given two strings <code>s</code> and <code>goal</code>, return <code>true</code> <em>if and only if</em> <code>s</code> <em>can become</em> <code>goal</code> <em>after some number of <strong>shifts</strong> on</em> <code>s</code>.</p>
 * 
 * <p>A <strong>shift</strong> on <code>s</code> consists of moving the leftmost character of <code>s</code> to the rightmost position.</p>
 * 
 * <ul>
 * 	<li>For example, if <code>s = "abcde"</code>, then it will be <code>"bcdea"</code> after one shift.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> s = "abcde", goal = "cdeab"
 * <strong>Output:</strong> true
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> s = "abcde", goal = "abced"
 * <strong>Output:</strong> false
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length, goal.length &lt;= 100</code></li>
 * 	<li><code>s</code> and <code>goal</code> consist of lowercase English letters.</li>
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


// 0ms 41.33MB
class RotateString_Solution {
    public boolean rotateString(String s, String goal) {
        int s_len = s.length(),
            goal_len = goal.length();
        
        if (s_len != goal_len) {return false;}
        
        int idx_first = goal.indexOf(s.charAt(0)),
            idx_at_s = 1;
        while (idx_first >= 0) {
            int idx_track = idx_first+1;
            while (idx_at_s < s_len) {
                if (idx_track == s_len) {idx_track = 0;}
                if (s.charAt(idx_at_s) != goal.charAt(idx_track)) {break;}

                idx_at_s++;
                idx_track++;
            }

            if (idx_at_s == s_len) {return true;}
            
            idx_first = goal.indexOf(s.charAt(0),idx_first+1);
            idx_at_s = 1;
        }

        return false;
    }
}