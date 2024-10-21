package BetterCodeAnswer.Medium.String;

import java.util.ArrayList;
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

// 1ms 45.38MB
class MinimumTimeDifference_Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) return 0; 

        boolean[] seen = new boolean[1440]; 
        
        for (String time : timePoints) {
            int minutes = convertToMinutes(time);
            if (seen[minutes]) return 0; 
            seen[minutes] = true;
        }
        
        int first = Integer.MAX_VALUE, prev = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        
        for (int i = 0; i < 1440; i++) {
            if (seen[i]) {
                if (first == Integer.MAX_VALUE) {
                    first = i;
                } else {
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
            }
        }
        

        minDiff = Math.min(minDiff, 1440 - prev + first);
        
        return minDiff;
    }
    
    private int convertToMinutes(String time) {
        return ((time.charAt(0) - '0') * 10 + (time.charAt(1) - '0')) * 60 
             + (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
    }
}
//Kartikdevsharmaa