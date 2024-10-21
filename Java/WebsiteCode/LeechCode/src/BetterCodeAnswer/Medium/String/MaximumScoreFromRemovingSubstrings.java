package BetterCodeAnswer.Medium.String;

import java.util.Stack;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximum-score-from-removing-substrings/">1717. Maximum Score From Removing Substrings</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code> and two integers <code>x</code> and <code>y</code>. You can perform two types of operations any number of times.</p>
 * 
 * <ul>
 * 	<li>Remove substring <code>"ab"</code> and gain <code>x</code> points.
 * 
 * 	<ul>
 * 		<li>For example, when removing <code>"ab"</code> from <code>"c<u>ab</u>xbae"</code> it becomes <code>"cxbae"</code>.</li>
 * 	</ul>
 * 	</li>
 * 	<li>Remove substring <code>"ba"</code> and gain <code>y</code> points.
 * 	<ul>
 * 		<li>For example, when removing <code>"ba"</code> from <code>"cabx<u>ba</u>e"</code> it becomes <code>"cabxe"</code>.</li>
 * 	</ul>
 * 	</li>
 * </ul>
 * 
 * <p>Return <em>the maximum points you can gain after applying the above operations on</em> <code>s</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "cdbcbbaaabab", x = 4, y = 5
 * <strong>Output:</strong> 19
 * <strong>Explanation:</strong>
 * - Remove the "ba" underlined in "cdbcbbaaa<u>ba</u>b". Now, s = "cdbcbbaaab" and 5 points are added to the score.
 * - Remove the "ab" underlined in "cdbcbbaa<u>ab</u>". Now, s = "cdbcbbaa" and 4 points are added to the score.
 * - Remove the "ba" underlined in "cdbcb<u>ba</u>a". Now, s = "cdbcba" and 5 points are added to the score.
 * - Remove the "ba" underlined in "cdbc<u>ba</u>". Now, s = "cdbc" and 5 points are added to the score.
 * Total score = 5 + 4 + 5 + 5 = 19.</pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "aabbaaxybbaabb", x = 5, y = 4
 * <strong>Output:</strong> 20
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= x, y &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>s</code> consists of lowercase English letters.</li>
 * </ul>
 * </div>
 */
public class MaximumScoreFromRemovingSubstrings {
    public static void main(String[] args) {
        Object[][] tests = {
            {"cdbcbbaaabab",4,5},
        };

        for (Object[] test : tests) {
            String s = (String) test[0];
            int x = (int) test[1],
                y = (int) test[2];

            System.out.println(new MaximumScoreFromRemovingSubstrings_Solution().maximumGain(s, x, y));
        }
    }
}

// 202ms 47.38MB
class MaximumScoreFromRemovingSubstrings_Solution {

    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        String highPriorityPair = x > y ? "ab" : "ba";
        String lowPriorityPair = highPriorityPair.equals("ab") ? "ba" : "ab";

        // First pass: remove high priority pair
        String stringAfterFirstPass = removeSubstring(s, highPriorityPair);
        int removedPairsCount =
            (s.length() - stringAfterFirstPass.length()) / 2;

        // Calculate score from first pass
        totalScore += removedPairsCount * Math.max(x, y);

        // Second pass: remove low priority pair
        String stringAfterSecondPass = removeSubstring(
            stringAfterFirstPass,
            lowPriorityPair
        );
        removedPairsCount = (stringAfterFirstPass.length() -
            stringAfterSecondPass.length()) /
        2;

        // Calculate score from second pass
        totalScore += removedPairsCount * Math.min(x, y);

        return totalScore;
    }

    private String removeSubstring(String input, String targetPair) {
        Stack<Character> charStack = new Stack<>();

        // Iterate through each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Check if current character forms the target pair with the top of the stack
            if (
                currentChar == targetPair.charAt(1) &&
                !charStack.isEmpty() &&
                charStack.peek() == targetPair.charAt(0)
            ) {
                charStack.pop(); // Remove the matching character from the stack
            } else {
                charStack.push(currentChar);
            }
        }

        // Reconstruct the remaining string after removing target pairs
        StringBuilder remainingChars = new StringBuilder();
        while (!charStack.isEmpty()) {
            remainingChars.append(charStack.pop());
        }
        return remainingChars.reverse().toString();
    }
}

// 65ms 45.37MB
class MaximumScoreFromRemovingSubstrings_Solution2 {

    public int maximumGain(String s, int x, int y) {
        StringBuilder text = new StringBuilder(s);
        int totalPoints = 0;

        if (x > y) {
            // Remove "ab" first (higher points), then "ba"
            totalPoints += removeSubstring(text, "ab", x);
            totalPoints += removeSubstring(text, "ba", y);
        } else {
            // Remove "ba" first (higher or equal points), then "ab"
            totalPoints += removeSubstring(text, "ba", y);
            totalPoints += removeSubstring(text, "ab", x);
        }

        return totalPoints;
    }

    private int removeSubstring(
        StringBuilder inputString,
        String targetSubstring,
        int pointsPerRemoval
    ) {
        int totalPoints = 0;
        int writeIndex = 0;

        // Iterate through the string
        for (int readIndex = 0; readIndex < inputString.length(); readIndex++) {
            // Add the current character
            inputString.setCharAt(writeIndex++, inputString.charAt(readIndex));

            // Check if we've written at least two characters and
            // they match the target substring
            if (
                writeIndex > 1 &&
                inputString.charAt(writeIndex - 2) ==
                    targetSubstring.charAt(0) &&
                inputString.charAt(writeIndex - 1) == targetSubstring.charAt(1)
            ) {
                writeIndex -= 2; // Move write index back to remove the match
                totalPoints += pointsPerRemoval;
            }
        }

        // Trim the StringBuilder to remove any leftover characters
        inputString.setLength(writeIndex);

        return totalPoints;
    }
}

// 23ms 45MB
class MaximumScoreFromRemovingSubstrings_Solution3 {

    public int maximumGain(String s, int x, int y) {
        // Ensure "ab" always has higher points than "ba"
        if (x < y) {
            // Swap points
            int temp = x;
            x = y;
            y = temp;
            // Reverse the string to maintain logic
            s = new StringBuilder(s).reverse().toString();
        }

        int aCount = 0, bCount = 0, totalPoints = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == 'a') {
                aCount++;
            } else if (currentChar == 'b') {
                if (aCount > 0) {
                    // Can form "ab", remove it and add points
                    aCount--;
                    totalPoints += x;
                } else {
                    // Can't form "ab", keep 'b' for potential future "ba"
                    bCount++;
                }
            } else {
                // Non 'a' or 'b' character encountered
                // Calculate points for any remaining "ba" pairs
                totalPoints += Math.min(bCount, aCount) * y;
                // Reset counters for next segment
                aCount = bCount = 0;
            }
        }

        // Calculate points for any remaining "ba" pairs at the end
        totalPoints += Math.min(bCount, aCount) * y;

        return totalPoints;
    }
}