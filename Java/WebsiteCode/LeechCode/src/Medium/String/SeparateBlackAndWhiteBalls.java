package Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/separate-black-and-white-balls/">2938. Separate Black and White Balls</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>There are <code>n</code> balls on a table, each ball has a color black or white.</p>
 * 
 * <p>You are given a <strong>0-indexed</strong> binary string <code>s</code> of length <code>n</code>, where <code>1</code> and <code>0</code> represent black and white balls, respectively.</p>
 * 
 * <p>In each step, you can choose two adjacent balls and swap them.</p>
 * 
 * <p>Return <em>the <strong>minimum</strong> number of steps to group all the black balls to the right and all the white balls to the left</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "101"
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> We can group all the black balls to the right in the following way:
 * - Swap s[0] and s[1], s = "011".
 * Initially, 1s are not grouped together, requiring at least 1 step to group them to the right.</pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "100"
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> We can group all the black balls to the right in the following way:
 * - Swap s[0] and s[1], s = "010".
 * - Swap s[1] and s[2], s = "001".
 * It can be proven that the minimum number of steps needed is 2.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "0111"
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> All the black balls are already grouped to the right.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n == s.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>s[i]</code> is either <code>'0'</code> or <code>'1'</code>.</li>
 * </ul>
 * </div></div>
 */
public class SeparateBlackAndWhiteBalls {
    public static void main(String[] args) {
        String[] tests = {
            "111",
            "11000111",
            "101",
            "100",
        };

        for (String s : tests) {
            System.out.println(new SeparateBlackAndWhiteBalls_Solution().minimumSteps(s));
        }
    }
}

// 8ms 45.72MB
class SeparateBlackAndWhiteBalls_Solution {
    public long minimumSteps(String s) {
        byte[] s_chars = s.getBytes();
        long count = 0;
        int left,
            right = s.length()-1;

        while (right > 0 && s_chars[right] == '1') {right--;}
        left = right-1;

        while (left >= 0) {
            if (s_chars[left] == '1') {
                while (s_chars[right] == '1') {right--;}
                if (right >= 0) {
                    count += right-- -left;
                }
                s_chars[left] = '0';
            }
            left--;
        }

        return count;
    }
}