package BetterCodeAnswer.Hard.Array;

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

// 14ms 43.02MB
class StrangePrinter_Solution {

    public int strangePrinter(String s) {
        // Preprocess the string to remove consecutive duplicate characters
        s = removeDuplicates(s);
        int n = s.length();
        // Initialize memoization array
        Integer[][] memo = new Integer[n][n];
        // Start the recursive process
        return minimumTurns(0, n - 1, s, memo);
    }

    private int minimumTurns(int start, int end, String s, Integer[][] memo) {
        // Base case: empty string requires 0 turns
        if (start > end) {
            return 0;
        }

        // If result is memoized, return it
        if (memo[start][end] != null) {
            return memo[start][end];
        }

        // Initialize with worst case: print each character separately
        int minTurns = 1 + minimumTurns(start + 1, end, s, memo);

        // Try to optimize by finding matching characters
        for (int k = start + 1; k <= end; k++) {
            if (s.charAt(k) == s.charAt(start)) {
                // If match found, try splitting the problem
                int turnsWithMatch =
                    minimumTurns(start, k - 1, s, memo) +
                    minimumTurns(k + 1, end, s, memo);
                minTurns = Math.min(minTurns, turnsWithMatch);
            }
        }

        // Memoize and return the result
        return memo[start][end] = minTurns;
    }

    private String removeDuplicates(String s) {
        StringBuilder uniqueChars = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char currentChar = s.charAt(i);
            uniqueChars.append(currentChar);
            // Skip all consecutive occurrences of the current character
            while (i < s.length() && s.charAt(i) == currentChar) {
                i++;
            }
        }
        return uniqueChars.toString();
    }
}

// 30ms 42.81MB
class StrangePrinter_Solution2 {

    public int strangePrinter(String s) {
        // Preprocess the string to remove consecutive duplicate characters
        s = removeDuplicates(s);

        int n = s.length();

        // dp[i][j] represents the minimum number of turns to print s[i] to s[j]
        int[][] minTurns = new int[n][n];

        // Initialize base case
        for (int i = 0; i < n; i++) {
            // It takes 1 turn to print a single character
            minTurns[i][i] = 1;
        }

        // Fill the dp table
        for (int length = 2; length <= n; length++) {
            for (int start = 0; start + length - 1 < n; start++) {
                int end = start + length - 1;

                // Initialize with worst case: print each character separately
                minTurns[start][end] = length;

                // Try all possible splits and find the minimum
                for (int split = 0; split < length - 1; split++) {
                    int totalTurns =
                        minTurns[start][start + split] +
                        minTurns[start + split + 1][end];

                    // If the characters at the split and end match, we can save one turn
                    if (s.charAt(start + split) == s.charAt(end)) {
                        totalTurns--;
                    }

                    minTurns[start][end] = Math.min(
                        minTurns[start][end],
                        totalTurns
                    );
                }
            }
        }

        // Return the minimum turns needed to print the entire string
        return minTurns[0][n - 1];
    }

    private String removeDuplicates(String s) {
        StringBuilder uniqueChars = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char currentChar = s.charAt(i);
            uniqueChars.append(currentChar);
            // Skip all consecutive occurrences of the current character
            while (i < s.length() && s.charAt(i) == currentChar) {
                i++;
            }
        }
        return uniqueChars.toString();
    }
}

// 7ms 42.94MB
class StrangePrinter_Solution3 {
    public int strangePrinter(String s) {
        char[] sc = s.toCharArray();
        final int n = removeDuplicates(sc);
        if (n <= 1)  return n;
        return dfs(0, n - 1, sc, new int[n][n]);
    }
    
    
    private int dfs(int left, int right, char[] sc, int[][] memo) {
        if (left >= right)  return (left == right) ? 1 : 0;
        if (memo[left][right] != 0)  return memo[left][right];
        int letter = sc[left];
        int answer = 1 + dfs(left + 1, right, sc, memo);
        for (int k = left + 1; k <= right; k++) 
            if (sc[k] == letter) 
                answer = Math.min(answer, dfs(left+1, k - 1, sc, memo) + dfs(k, right, sc, memo));
        return memo[left][right] = answer;
    }
    
    
    private int removeDuplicates(char[] sc) {
        int scOutIdx = 0;
        char prev = 0;
        for (char c : sc) {
            if (c != prev) {
                sc[scOutIdx++] = c;
                prev = c;
            }
        }
        return scOutIdx;
    }
}