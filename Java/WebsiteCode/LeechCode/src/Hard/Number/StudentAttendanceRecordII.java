package Hard.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/student-attendance-record-ii/">552. Student Attendance Record II</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>An attendance record for a student can be represented as a string where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:</p>
 * 
 * <ul>
 * 	<li><code>'A'</code>: Absent.</li>
 * 	<li><code>'L'</code>: Late.</li>
 * 	<li><code>'P'</code>: Present.</li>
 * </ul>
 * 
 * <p>Any student is eligible for an attendance award if they meet <strong>both</strong> of the following criteria:</p>
 * 
 * <ul>
 * 	<li>The student was absent (<code>'A'</code>) for <strong>strictly</strong> fewer than 2 days <strong>total</strong>.</li>
 * 	<li>The student was <strong>never</strong> late (<code>'L'</code>) for 3 or more <strong>consecutive</strong> days.</li>
 * </ul>
 * 
 * <p>Given an integer <code>n</code>, return <em>the <strong>number</strong> of possible attendance records of length</em> <code>n</code><em> that make a student eligible for an attendance award. The answer may be very large, so return it <strong>modulo</strong> </em><code>10<sup>9</sup> + 7</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 2
 * <strong>Output:</strong> 8
 * <strong>Explanation:</strong> There are 8 records with length 2 that are eligible for an award:
 * "PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * Only "AA" is not eligible because there are 2 absences (there need to be fewer than 2).
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 1
 * <strong>Output:</strong> 3
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 10101
 * <strong>Output:</strong> 183236316
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * </div>
 */
public class StudentAttendanceRecordII {
    public static void main(String[] args) {
        int[] tests = {
            2,
            1,
        };

        for (int n : tests) {
            System.out.println(new StudentAttendanceRecordII_Solution().checkRecord(n));
        }
    }
}

// Time Limit Exceeded
class StudentAttendanceRecordII_Solution1 {
    int n;
    public int checkRecord(int n) {
        this.n = n;

        return checkForAttendance(0, 0, 0, 0);
    }

    private int checkForAttendance(int absent, int late, int present, int total) {
        if (absent > 1 || late > 2) {return 0;}
        if (total == n) {return 1;}

        return checkForAttendance(absent+1, 0, present, total+1) + 
               checkForAttendance(absent, late+1, present, total+1) +
               checkForAttendance(absent, 0, present+1, total+1);
    }
}

// Time Limit Exceeded
class StudentAttendanceRecordII_Solution2 {
    private static final int MOD = 1000000007;

    public int checkRecord(int n) {
        return checkForAttendance(n, 1, 2);
    }

    private int checkForAttendance(int n, int numAbsensesRemaining, int numLatesRemaining) {
        if(n == 0) {
            return 1;
        }
        int total = 0;

        // Pick P
        total += checkForAttendance(n - 1, numAbsensesRemaining, 2);
        
        if(numAbsensesRemaining > 0) {
            // Pick A
            total += checkForAttendance(n - 1, numAbsensesRemaining - 1, 2);
            total %= MOD;
        }

        if(numLatesRemaining > 0) {
            // Pick L
            total += checkForAttendance(n - 1, numAbsensesRemaining, numLatesRemaining - 1);
            total %= MOD;
        }

        return total;
    }
}

// 268 ms 44.1 MB
class StudentAttendanceRecordII_Solution {

    private static final int MOD = 1000000007;

    public int checkRecord(int n) {
        int prevDP[][] = new int[2][3];
        prevDP[0][0] = 1;
        prevDP[0][1] = 1;
        prevDP[0][2] = 1;
        prevDP[1][0] = 1;
        prevDP[1][1] = 1;
        prevDP[1][2] = 1;
        
        for(int i = 1; i <= n; i++){
            int newDP[][] = new int[2][3];
            for(int a = 0; a < 2; a++){
                for(int l = 0; l < 3; l++){
                    //Pick P
                    newDP[a][l] += prevDP[a][2];
                    if(a > 0){
                        //Pick A
                        newDP[a][l] += prevDP[a - 1][2];
                        newDP[a][l] %= MOD;
                    }
                    if(l > 0){
                        // Pick L
                        newDP[a][l] += prevDP[a][l - 1];
                        newDP[a][l] %= MOD;
                    }
                }
            }
            prevDP = newDP;
        }
        
        return prevDP[1][2];
    }
}