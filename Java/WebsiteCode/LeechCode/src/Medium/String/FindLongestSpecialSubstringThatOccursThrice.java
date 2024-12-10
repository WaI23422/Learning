package Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-longest-special-substring-that-occurs-thrice-i/">2981. Find Longest Special Substring That Occurs Thrice I</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code> that consists of lowercase English letters.</p>
 * 
 * <p>A string is called <strong>special</strong> if it is made up of only a single character. For example, the string <code>"abc"</code> is not special, whereas the strings <code>"ddd"</code>, <code>"zz"</code>, and <code>"f"</code> are special.</p>
 * 
 * <p>Return <em>the length of the <strong>longest special substring</strong> of </em><code>s</code> <em>which occurs <strong>at least thrice</strong></em>, <em>or </em><code>-1</code><em> if no special substring occurs at least thrice</em>.</p>
 * 
 * <p>A <strong>substring</strong> is a contiguous <strong>non-empty</strong> sequence of characters within a string.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "aaaa"
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The longest special substring which occurs thrice is "aa": substrings "<u><strong>aa</strong></u>aa", "a<u><strong>aa</strong></u>a", and "aa<u><strong>aa</strong></u>".
 * It can be shown that the maximum length achievable is 2.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "abcdef"
 * <strong>Output:</strong> -1
 * <strong>Explanation:</strong> There exists no special substring which occurs at least thrice. Hence return -1.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "abcaba"
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The longest special substring which occurs thrice is "a": substrings "<u><strong>a</strong></u>bcaba", "abc<u><strong>a</strong></u>ba", and "abcab<u><strong>a</strong></u>".
 * It can be shown that the maximum length achievable is 1.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>3 &lt;= s.length &lt;= 50</code></li>
 * 	<li><code>s</code> consists of only lowercase English letters.</li>
 * </ul>
 * </div></div>
 */
public class FindLongestSpecialSubstringThatOccursThrice {
    public static void main(String[] args) {
        
    }
}

// 2ms 42.50MB
class FindLongestSpecialSubstringThatOccursThrice_Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int l = 1, r = n;

        if (!helper(s, n, l)) return -1;

        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (helper(s, n, mid)) l = mid;
            else r = mid;
        }

        return l;
    }

    private boolean helper(String s, int n, int x) {
        int[] cnt = new int[26];
        int p = 0;

        for (int i = 0; i < n; i++) {
            while (s.charAt(p) != s.charAt(i)) p++;
            if (i - p + 1 >= x) cnt[s.charAt(i) - 'a']++;
            if (cnt[s.charAt(i) - 'a'] > 2) return true;
        }

        return false;
    }
}