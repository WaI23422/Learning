package BetterCodeAnswer.Hard.Number;

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

// 2 ms 40.4 MB
class StudentAttendanceRecordII_Solution {
    static final int mod = 1000000007;

    public int checkRecord(int n) {
        long[][] mat = new long[][]{
            {1, 1, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0}
        };

        long[][] res = pow(mat, n);
        long ans = 0;

        long[] initial = {1, 0, 0, 0, 0, 0};
        for(int i=0; i<=5; i++){
            long sum = 0;
            for(int j=0; j<=5; j++){
                sum = (sum + res[i][j] * initial[j]) % mod;
            }
            ans = (ans + sum) % mod;
        }
        return (int) (ans);
    }

    public long[][] pow(long[][] mat, int n) {
        long[][] ret = {{1, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}};
        while (n > 0) {
            if ((n % 2) == 1) {
                ret = multiply(ret, mat);
            }
            n /= 2;
            mat = multiply(mat, mat);
        }
        return ret;
    }

    public long[][] multiply(long[][] a, long[][] b) {
        long[][] c = new long[6][6];
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                c[i][j] = 0; 
                for (int k = 0; k <= 5; k++) {
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % mod;
                }
            }
        }
        return c;    
    }


}

// 19 ms 46 MB
class StudentAttendanceRecordII_Solution2 {
    static final int M = 1000000007;

    public int checkRecord(int n) {
        long[] PorL = new long[n + 1]; // ending with P or L, no A
        long[] P = new long[n + 1]; // ending with P, no A
        PorL[0] = P[0] = 1; PorL[1] = 2; P[1] = 1;

        for (int i = 2; i <= n; i++) {
            P[i] = PorL[i - 1];
            PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;
        }
        
        long res = PorL[n];
        for (int i = 0; i < n; i++) { // inserting A into (n-1)-length strings
            long s = (PorL[i] * PorL[n - i - 1]) % M;
            res = (res + s) % M;
        }
        
        return (int) res;
    }
}

// 23 ms 40.2 MB
class StudentAttendanceRecordII_Solution3 {
    public int checkRecord(int n) {
        int mod = 1_000_000_007;
        long[][] DP = new long[2][3];
        DP[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            long prv = 0;
            for (int j = 0; j < 2; j++) {
                long sum = 0;
                for (int k = 2; k > 0; k--) {
                    sum += DP[j][k];
                    DP[j][k] = DP[j][k - 1];
                }
                DP[j][0] = (DP[j][0] + sum + prv) % mod;
                prv = DP[j][0];
            }
        }
        long res = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                res += DP[j][k];
            }
        }
        return (int) (res % mod);
    }
}

// 262 ms 44.3 MB
class StudentAttendanceRecordII_Solution4 {
    public int checkRecord(int n) {
        int MOD = 1000000007;
        // Cache to store current sub-problem results.
        int[][] dpCurrState = new int[2][3];
        // Cache to store next sub-problem results.
        int[][] dpNextState = new int[2][3];

        // Base case: there is 1 string of length 0 with zero 'A' and zero 'L'.
        dpCurrState[0][0] = 1;

        // Iterate on smaller sub-problems and use the current smaller sub-problem 
        // to generate results for bigger sub-problems.
        for (int len = 0; len < n; ++len) {
            for (int totalAbsences = 0; totalAbsences <= 1; ++totalAbsences) {
                for (int consecutiveLates = 0; consecutiveLates <= 2; ++consecutiveLates) {
                    // Store the count when 'P' is chosen.
                    dpNextState[totalAbsences][0] = (
                        dpNextState[totalAbsences][0] + 
                        dpCurrState[totalAbsences][consecutiveLates]
                    ) % MOD;
                    // Store the count when 'A' is chosen.
                    if (totalAbsences < 1) {
                        dpNextState[totalAbsences + 1][0] = (
                            dpNextState[totalAbsences + 1][0] + 
                            dpCurrState[totalAbsences][consecutiveLates]
                        ) % MOD;
                    }
                    // Store the count when 'L' is chosen.
                    if (consecutiveLates < 2) {
                        dpNextState[totalAbsences][consecutiveLates + 1] = (
                            dpNextState[totalAbsences][consecutiveLates + 1] + 
                            dpCurrState[totalAbsences][consecutiveLates]
                        ) % MOD;
                    }
                }
            }

            // Next state sub-problems will become current state sub-problems in the next iteration.
            System.arraycopy(dpNextState, 0, dpCurrState, 0, dpCurrState.length);
            // Next state sub-problem results will reset to zero.
            dpNextState = new int[2][3];
        }

        // Sum up the counts for all combinations of length 'n' with different absent and late counts.
        int count = 0;
        for (int totalAbsences = 0; totalAbsences <= 1; ++totalAbsences) {
            for (int consecutiveLates = 0; consecutiveLates <= 2; ++consecutiveLates) {
                count = (count + dpCurrState[totalAbsences][consecutiveLates]) % MOD;
            }
        }
        return count;
    }
}