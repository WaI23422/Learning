package Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-the-longest-substring-containing-vowels-in-even-counts/">1371. Find the Longest Substring Containing Vowels in Even Counts</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the string <code>s</code>, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "eleetminicoworoep"
 * <strong>Output:</strong> 13
 * <strong>Explanation: </strong>The longest substring is "leetminicowor" which contains two each of the vowels: <strong>e</strong>, <strong>i</strong> and <strong>o</strong> and zero of the vowels: <strong>a</strong> and <strong>u</strong>.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "leetcodeisgreat"
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> The longest substring is "leetc" which contains two e's.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "bcbcbc"
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> In this case, the given string "bcbcbc" is the longest because all vowels: <strong>a</strong>, <strong>e</strong>, <strong>i</strong>, <strong>o</strong> and <strong>u</strong> appear zero times.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 5 x 10^5</code></li>
 * 	<li><code>s</code>&nbsp;contains only lowercase English letters.</li>
 * </ul>
 * </div>
 */
public class FindTheLongestSubstringContainingVowelsInEvenCounts {
    public static void main(String[] args) {
        String[] tests = {
            "id",
            "leetcodeisgreat",
            "eleetminicoworoep"
        };

        for (String s : tests) {
            System.out.println(new FindTheLongestSubstringContainingVowelsInEvenCounts_Solution().findTheLongestSubstring(s));
        }
    }   
}

// 13ms 45.10MB
class FindTheLongestSubstringContainingVowelsInEvenCounts_Solution {
    private static final int[] VOWEL_MASK = new int[128];
    static {
        VOWEL_MASK['a'] = 1;  // 00001
        VOWEL_MASK['e'] = 2;  // 00010
        VOWEL_MASK['i'] = 4;  // 00100
        VOWEL_MASK['o'] = 8;  // 01000
        VOWEL_MASK['u'] = 16; // 10000
    }

    public int findTheLongestSubstring(String s) {
        // To store the first occurrence of each bitmask (0 to 31)
        int[] firstOccurrence = new int[32];
        java.util.Arrays.fill(firstOccurrence, -1);
        firstOccurrence[0] = 0; // Bitmask 0 occurs at position -1 (before the string starts)

        int maxLength = 0;
        int mask = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Update mask if it's a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                mask ^= VOWEL_MASK[ch];
            }

            // If the current mask was seen before, calculate the length of the substring
            if (firstOccurrence[mask] != -1) {
                maxLength = Math.max(maxLength, i + 1 - firstOccurrence[mask]);
            } else {
                // Store the first occurrence of this bitmask
                firstOccurrence[mask] = i + 1;
            }
        }

        return maxLength;
    }
}