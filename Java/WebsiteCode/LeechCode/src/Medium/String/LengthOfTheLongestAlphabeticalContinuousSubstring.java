package Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/length-of-the-longest-alphabetical-continuous-substring/">2414. Length of the Longest Alphabetical Continuous Substring</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>An <strong>alphabetical continuous string</strong> is a string consisting of consecutive letters in the alphabet. In other words, it is any substring of the string <code>"abcdefghijklmnopqrstuvwxyz"</code>.</p>
 * 
 * <ul>
 * 	<li>For example, <code>"abc"</code> is an alphabetical continuous string, while <code>"acb"</code> and <code>"za"</code> are not.</li>
 * </ul>
 * 
 * <p>Given a string <code>s</code> consisting of lowercase letters only, return the <em>length of the <strong>longest</strong> alphabetical continuous substring.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "abacaba"
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> There are 4 distinct continuous substrings: "a", "b", "c" and "ab".
 * "ab" is the longest continuous substring.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "abcde"
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> "abcde" is the longest continuous substring.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>s</code> consists of only English lowercase letters.</li>
 * </ul>
 * </div>
 */
public class LengthOfTheLongestAlphabeticalContinuousSubstring {
    public static void main(String[] args) {
        String[] tests = {
            "abaca"
        };

        for (String s : tests) {
            System.out.println(new LengthOfTheLongestAlphabeticalContinuousSubstring_Solution().longestContinuousSubstring(s));
        }
    }
}

// 7ms 45.3MB
class LengthOfTheLongestAlphabeticalContinuousSubstring_Solution {
    public int longestContinuousSubstring(String s) {
        char[] s_chars = s.toCharArray();
        int len = s_chars.length,
            temp = 1,
            max =1,
            start =0;
        
        for (int end =1; end < len; end++){
            if (s_chars[end] - s_chars[start] == 1){
                temp++;
                start++;
                if (temp>max){
                    max = temp;
                }
                
            }  else {
                temp =1;
                start = end;
            }
        }
        
        return max;
    }
}