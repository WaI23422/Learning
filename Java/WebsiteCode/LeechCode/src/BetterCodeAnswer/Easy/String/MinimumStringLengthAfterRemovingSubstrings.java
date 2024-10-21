package BetterCodeAnswer.Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-string-length-after-removing-substrings/">2696. Minimum String Length After Removing Substrings</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code> consisting only of <strong>uppercase</strong> English letters.</p>
 * 
 * <p>You can apply some operations to this string where, in one operation, you can remove <strong>any</strong> occurrence of one of the substrings <code>"AB"</code> or <code>"CD"</code> from <code>s</code>.</p>
 * 
 * <p>Return <em>the <strong>minimum</strong> possible length of the resulting string that you can obtain</em>.</p>
 * 
 * <p><strong>Note</strong> that the string concatenates after removing the substring and could produce new <code>"AB"</code> or <code>"CD"</code> substrings.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "ABFCACDB"
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> We can do the following operations:
 * - Remove the substring "<u>AB</u>FCACDB", so s = "FCACDB".
 * - Remove the substring "FCA<u>CD</u>B", so s = "FCAB".
 * - Remove the substring "FC<u>AB</u>", so s = "FC".
 * So the resulting length of the string is 2.
 * It can be shown that it is the minimum length that we can obtain.</pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "ACBBD"
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> We cannot do any operations on the string so the length remains the same.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 100</code></li>
 * 	<li><code>s</code>&nbsp;consists only of uppercase English letters.</li>
 * </ul>
 * </div></div>
 */
public class MinimumStringLengthAfterRemovingSubstrings {
    public static void main(String[] args) {
        String[] tests = {
            "ABFCACDB"
        };

        for (String s : tests) {
            System.out.println(new MinimumStringLengthAfterRemovingSubstrings_Solution().minLength(s));
        }
    }
}

// 2ms 43.25MB
class MinimumStringLengthAfterRemovingSubstrings_Solution {
    public int minLength(String s) {
        char[] stack = new char[s.length()+1];
        int last = -1;
        for (char c : s.toCharArray()) {
            if (
                last > -1 && (c == 'B' && stack[last] == 'A' || 
                c == 'D' && stack[last] == 'C')
            ) {
                last--;
            } else {
                last++;
                stack[last] = c;
            }
        }
        return last+1;
    }
}