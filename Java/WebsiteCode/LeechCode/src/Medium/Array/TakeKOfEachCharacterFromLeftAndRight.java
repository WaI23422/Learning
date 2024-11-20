package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/take-k-of-each-character-from-left-and-right/">2516. Take K of Each Character From Left and Right</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code> consisting of the characters <code>'a'</code>, <code>'b'</code>, and <code>'c'</code> and a non-negative integer <code>k</code>. Each minute, you may take either the <strong>leftmost</strong> character of <code>s</code>, or the <strong>rightmost</strong> character of <code>s</code>.</p>
 * 
 * <p>Return<em> the <strong>minimum</strong> number of minutes needed for you to take <strong>at least</strong> </em><code>k</code><em> of each character, or return </em><code>-1</code><em> if it is not possible to take </em><code>k</code><em> of each character.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "aabaaaacaabc", k = 2
 * <strong>Output:</strong> 8
 * <strong>Explanation:</strong> 
 * Take three characters from the left of s. You now have two 'a' characters, and one 'b' character.
 * Take five characters from the right of s. You now have four 'a' characters, two 'b' characters, and two 'c' characters.
 * A total of 3 + 5 = 8 minutes is needed.
 * It can be proven that 8 is the minimum number of minutes needed.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "a", k = 1
 * <strong>Output:</strong> -1
 * <strong>Explanation:</strong> It is not possible to take one 'b' or 'c' so return -1.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>s</code> consists of only the letters <code>'a'</code>, <code>'b'</code>, and <code>'c'</code>.</li>
 * 	<li><code>0 &lt;= k &lt;= s.length</code></li>
 * </ul>
 * </div></div>
 */
public class TakeKOfEachCharacterFromLeftAndRight {
    public static void main(String[] args) {
        String[][] tests = {
            {
                "a",
                "0"
            },
            {
                "aaccbba",
                "2"
            },
            {
                "aabaaaacaabc",
                "2"
            }
        };

        for (String[] test : tests) {
            String s = test[0];
            int k = Integer.parseInt(test[1]);

            System.out.println(new TakeKOfEachCharacterFromLeftAndRight_Solution().takeCharacters(s, k));
        }
    }
}

// 14ms 45.18MB
class TakeKOfEachCharacterFromLeftAndRight_Solution {

    public int takeCharacters(String s, int k) {
        int[] count = new int[3];
        int n = s.length();

        // Count total occurrences
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Check if we have enough characters
        for (int i = 0; i < 3; i++) {
            if (count[i] < k) return -1;
        }

        int[] window = new int[3];
        int left = 0, maxWindow = 0;

        // Find the longest window that leaves k of each character outside
        for (int right = 0; right < n; right++) {
            window[s.charAt(right) - 'a']++;

            // Shrink window if we take too many characters
            while (
                left <= right &&
                (count[0] - window[0] < k ||
                    count[1] - window[1] < k ||
                    count[2] - window[2] < k)
            ) {
                window[s.charAt(left) - 'a']--;
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return n - maxWindow;
    }
}
// Time Limit Exceeded
class TakeKOfEachCharacterFromLeftAndRight_Solution1 {
    public int takeCharacters(String s, int k) {
        int min_total = Integer.MAX_VALUE,
            abc_count[] = new int[3],
            len = s.length();
        byte s_bytes[] = s.getBytes();

        for (byte b : s_bytes) { abc_count[b-97]++; }

        if (
            abc_count[0] < k ||
            abc_count[1] < k ||
            abc_count[2] < k
        ) {
            return -1;
        }

        for (int left = 0; left < len; left++) {
            int a_remain = abc_count[0],b_remain = abc_count[1],c_remain = abc_count[2],
                right = left;
            IN_LOOP:
            while (right < len) {
                switch (s_bytes[right]) {
                    case 97:
                        if (a_remain == k ) {break IN_LOOP;}  
                        a_remain--;  
                        break;
                    
                    case 98:
                        if (b_remain == k) {break IN_LOOP;}
                        b_remain--;  
                        break;

                    default:
                        if (c_remain == k) {break IN_LOOP;}
                        c_remain--;
                        break;
                }
                right++;
            }
            min_total = Math.min(min_total, len-(right-left));
        }

        return min_total;
    }
}