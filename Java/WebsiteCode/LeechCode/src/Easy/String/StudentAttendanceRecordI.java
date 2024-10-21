package Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/student-attendance-record-i/">551. Student Attendance Record I</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code> representing an attendance record for a student where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:</p>
 * 
 * <ul>
 * 	<li><code>'A'</code>: Absent.</li>
 * 	<li><code>'L'</code>: Late.</li>
 * 	<li><code>'P'</code>: Present.</li>
 * </ul>
 * 
 * <p>The student is eligible for an attendance award if they meet <strong>both</strong> of the following criteria:</p>
 * 
 * <ul>
 * 	<li>The student was absent (<code>'A'</code>) for <strong>strictly</strong> fewer than 2 days <strong>total</strong>.</li>
 * 	<li>The student was <strong>never</strong> late (<code>'L'</code>) for 3 or more <strong>consecutive</strong> days.</li>
 * </ul>
 * 
 * <p>Return <code>true</code><em> if the student is eligible for an attendance award, or </em><code>false</code><em> otherwise</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "PPALLP"
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> The student has fewer than 2 absences and was never late 3 or more consecutive days.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "PPALLL"
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> The student was late 3 consecutive days in the last 3 days, so is not eligible for the award.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
 * 	<li><code>s[i]</code> is either <code>'A'</code>, <code>'L'</code>, or <code>'P'</code>.</li>
 * </ul>
 * </div>
 */
public class StudentAttendanceRecordI {
    public static void main(String[] args) {
        String[] tests = {
            "PPALLP",
            "PPAALLP",
            "PPALLLP",
            "PPLALLP",
        };

        for (String s : tests) {
            System.out.println(new StudentAttendanceRecordI_Solution().checkRecord(s));
        }
    }
}

// 0 ms 41.2 MB
class StudentAttendanceRecordI_Solution {
    public boolean checkRecord(String s) {
        int late = 0,
            absent = 0;
        char[] sChars = s.toCharArray();
        
        for (char c : sChars) {
            if (c == 'L') {
                if (++late == 3) {return false;}
            } else {
                late = 0;
                if (c == 'A') {
                    if (++absent > 1) {
                        return false;
                    }
                }
            }  
        }

        return true;
    }
}