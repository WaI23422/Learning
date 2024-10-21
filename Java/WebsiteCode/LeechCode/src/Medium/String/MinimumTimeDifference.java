package Medium.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-time-difference/">539. Minimum Time Difference</a>
 * 
 * <div class="elfjS" data-track-load="description_content">Given a list of 24-hour clock time points in <strong>"HH:MM"</strong> format, return <em>the minimum <b>minutes</b> difference between any two time-points in the list</em>.
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> timePoints = ["23:59","00:00"]
 * <strong>Output:</strong> 1
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> timePoints = ["00:00","23:59","00:00"]
 * <strong>Output:</strong> 0
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= timePoints.length &lt;= 2 * 10<sup>4</sup></code></li>
 * 	<li><code>timePoints[i]</code> is in the format <strong>"HH:MM"</strong>.</li>
 * </ul>
 * </div>
 */
public class MinimumTimeDifference {
    public static void main(String[] args) {
        String[][] tests = {
            {"01:00","13:00"},
            {"23:59","00:00"}
        };

        for (String[] test : tests) {
            List<String> timePoints = new ArrayList<>();
            for (String s : test) {
                timePoints.add(s);
            }

            System.out.println(new MinimumTimeDifference_Solution().findMinDifference(timePoints));
        }
    }
}

// 4ms 45.67MB -> 3ms 45.38MB
class MinimumTimeDifference_Solution {
    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size(),
            minutes[] = new int[len],
            min_times = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            minutes[i] = convertToMinutes(timePoints.get(i));
        }
        Arrays.sort(minutes);

        for (int i = 1; i < minutes.length; i++) {
            min_times = Math.min(min_times, Math.abs(minutes[i-1]-minutes[i]));
        }

        return Math.min(min_times, Math.abs(minutes[0] + (720-(minutes[len-1] > 720 ?minutes[len-1] -720 :minutes[len-1])))); // minutes[0] + 1440 - minutes[len-1]
    }

    private int convertToMinutes(String str) {
        return (str.charAt(0)-'0')*600 + (str.charAt(1)-'0')*60 + (str.charAt(3)-'0')*10 + str.charAt(4)-'0';
    }
}