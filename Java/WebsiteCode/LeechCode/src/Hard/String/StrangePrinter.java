package Hard.String;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/strange-printer/">664. Strange Printer</a>
 * <div class="elfjS" data-track-load="description_content"><p>There is a strange printer with the following two special properties:</p>
 * 
 * <ul>
 * 	<li>The printer can only print a sequence of <strong>the same character</strong> each time.</li>
 * 	<li>At each turn, the printer can print new characters starting from and ending at any place and will cover the original existing characters.</li>
 * </ul>
 * 
 * <p>Given a string <code>s</code>, return <em>the minimum number of turns the printer needed to print it</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "aaabbb"
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> Print "aaa" first and then print "bbb".
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "aba"
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 100</code></li>
 * 	<li><code>s</code> consists of lowercase English letters.</li>
 * </ul>
 * </div>
 */
public class StrangePrinter {
    public static void main(String[] args) {
        String[] tests = {
            "abbbcbcccbcbca",
            "abcdabbca",
            "abbcbad",
            "aba",
        };

        for (String s : tests) {
            System.out.println(new StrangePrinter_Solution().strangePrinter(s));
        }

    }
}

// 9ms 43.02MB
class StrangePrinter_Solution {
    private int[][] memo;
    private char[] array;
    
    public int strangePrinter(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        array = squash(s);
        int N = array.length;
        memo = new int[N][];

        for (int i = 0; i < N; i++) {
            memo[i] = new int[N];
            memo[i][i] = 1;
            if (i != N - 1) {
                int next = i + 1;
                memo[i][next] = array[i] == array[next] ? 1 : 2;
            }
        }
        return strangePrinter(0, array.length - 1);
    }
    public int strangePrinter(int i, int j) {
        if (i > j) {
            return 0;
        }
        if (memo[i][j] == 0) {

            int nextIdx = i + 1;
            int letter = array[i];

            int answer = 1 + strangePrinter(nextIdx, j);

            for (int k = nextIdx; k <= j; k++) {
                if (array[k] == letter) {

                    int betterAnswer = strangePrinter(i, k - 1) + strangePrinter(k + 1, j);
                    answer = Math.min(answer, betterAnswer);
                }
            }
            memo[i][j] = answer;
        }
        return memo[i][j];
    }
    char[] squash(String s) {
        char[] chars = s.toCharArray();
        int last = 0;
        int fullLength = chars.length;
        for (int i = 1; i < fullLength; i++) {
            if (chars[i] != chars[last]) {
                chars[++last] = chars[i];
            }
        }
        return Arrays.copyOf(chars, last + 1);
    }
}