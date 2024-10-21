package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-the-student-that-will-replace-the-chalk/">1894. Find the Student that Will Replace the Chalk</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There are <code>n</code> students in a class numbered from <code>0</code> to <code>n - 1</code>. The teacher will give each student a problem starting with the student number <code>0</code>, then the student number <code>1</code>, and so on until the teacher reaches the student number <code>n - 1</code>. After that, the teacher will restart the process, starting with the student number <code>0</code> again.</p>
 * 
 * <p>You are given a <strong>0-indexed</strong> integer array <code>chalk</code> and an integer <code>k</code>. There are initially <code>k</code> pieces of chalk. When the student number <code>i</code> is given a problem to solve, they will use <code>chalk[i]</code> pieces of chalk to solve that problem. However, if the current number of chalk pieces is <strong>strictly less</strong> than <code>chalk[i]</code>, then the student number <code>i</code> will be asked to <strong>replace</strong> the chalk.</p>
 * 
 * <p>Return <em>the <strong>index</strong> of the student that will <strong>replace</strong> the chalk pieces</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> chalk = [5,1,5], k = 22
 * <strong>Output:</strong> 0
 * <strong>Explanation: </strong>The students go in turns as follows:
 * - Student number 0 uses 5 chalk, so k = 17.
 * - Student number 1 uses 1 chalk, so k = 16.
 * - Student number 2 uses 5 chalk, so k = 11.
 * - Student number 0 uses 5 chalk, so k = 6.
 * - Student number 1 uses 1 chalk, so k = 5.
 * - Student number 2 uses 5 chalk, so k = 0.
 * Student number 0 does not have enough chalk, so they will have to replace it.</pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> chalk = [3,4,1,2], k = 25
 * <strong>Output:</strong> 1
 * <strong>Explanation: </strong>The students go in turns as follows:
 * - Student number 0 uses 3 chalk so k = 22.
 * - Student number 1 uses 4 chalk so k = 18.
 * - Student number 2 uses 1 chalk so k = 17.
 * - Student number 3 uses 2 chalk so k = 15.
 * - Student number 0 uses 3 chalk so k = 12.
 * - Student number 1 uses 4 chalk so k = 8.
 * - Student number 2 uses 1 chalk so k = 7.
 * - Student number 3 uses 2 chalk so k = 5.
 * - Student number 0 uses 3 chalk so k = 2.
 * Student number 1 does not have enough chalk, so they will have to replace it.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>chalk.length == n</code></li>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= chalk[i] &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div>
 */
public class FindTheStudentThatWillReplaceTheChalk {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {5,1,5},
                {22}
            }
        };

        for (int[][] test : tests) {
            int chalk[] = test[0],
                k = test[1][0];

            System.out.println(new FindTheStudentThatWillReplaceTheChalk_Solution().chalkReplacer(chalk, k));
        }
    }   
}

// Brute-Force: Time Limit Exceed
class FindTheStudentThatWillReplaceTheChalk_Solution1 {
    public int chalkReplacer(int[] chalk, int k) {
        int student = chalk[0],
            i = 0,
            len = chalk.length;
        while (student <= k) {
            k -= student;
            i = (i+1)%len;
            student = chalk[i];
        }

        return i;
    }
}

// Wrong: sum bypass Integer limit. -> 2ms 59.84MB
class FindTheStudentThatWillReplaceTheChalk_Solution {

    public int chalkReplacer(int[] chalk, int k) {
        // int sum = Arrays.stream(chalk).sum(),
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
            if (sum > k) {
                break;
            }
        }

        k = k % (int) sum;
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k = k - chalk[i];
        }
        return 0;
    }
}