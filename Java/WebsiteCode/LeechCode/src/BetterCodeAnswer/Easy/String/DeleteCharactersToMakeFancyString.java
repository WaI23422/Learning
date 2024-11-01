package BetterCodeAnswer.Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/delete-characters-to-make-fancy-string/">1957. Delete Characters to Make Fancy String</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>A <strong>fancy string</strong> is a string where no <strong>three</strong> <strong>consecutive</strong> characters are equal.</p>
 * 
 * <p>Given a string <code>s</code>, delete the <strong>minimum</strong> possible number of characters from <code>s</code> to make it <strong>fancy</strong>.</p>
 * 
 * <p>Return <em>the final string after the deletion</em>. It can be shown that the answer will always be <strong>unique</strong>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "le<u>e</u>etcode"
 * <strong>Output:</strong> "leetcode"
 * <strong>Explanation:</strong>
 * Remove an 'e' from the first group of 'e's to create "leetcode".
 * No three consecutive characters are equal, so return "leetcode".
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "<u>a</u>aab<u>aa</u>aa"
 * <strong>Output:</strong> "aabaa"
 * <strong>Explanation:</strong>
 * Remove an 'a' from the first group of 'a's to create "aabaaaa".
 * Remove two 'a's from the second group of 'a's to create "aabaa".
 * No three consecutive characters are equal, so return "aabaa".
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "aab"
 * <strong>Output:</strong> "aab"
 * <strong>Explanation:</strong> No three consecutive characters are equal, so return "aab".
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>s</code> consists only of lowercase English letters.</li>
 * </ul>
 * </div></div>
 */
public class DeleteCharactersToMakeFancyString {
    public static void main(String[] args) {
        String[] tests  = {
            "leeetcode",
            "aaabaaaa"
        };

        for (String s : tests) {
            System.out.println(new DeleteCharactersToMakeFancyString_Solution().makeFancyString(s));
        }
    }
}

// 25ms 45.93MB
class DeleteCharactersToMakeFancyString_Solution {
    public String makeFancyString(String s) {
        int sameCount = 0;
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        for (char cur : s.toCharArray()) {
            if (cur == prev) {
                sameCount++;
            }
            else {
                sameCount = 1;
            }
            if (sameCount < 3) sb.append(cur);
            prev = cur;
        }
        return sb.toString();
    }
}