package Hard.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/shortest-palindrome/">214. Shortest Palindrome</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code>. You can convert <code>s</code> to a <span data-keyword="palindrome-string" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:r12:"><div>palindrome</div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(365px, 183px);"></div></div></div></span> by adding characters in front of it.</p>
 * 
 * <p>Return <em>the shortest palindrome you can find by performing this transformation</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> s = "aacecaaa"
 * <strong>Output:</strong> "aaacecaaa"
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> s = "abcd"
 * <strong>Output:</strong> "dcbabcd"
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
 * 	<li><code>s</code> consists of lowercase English letters only.</li>
 * </ul>
 * </div>
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        String[] tests = {
            "aacecaa",
            "aacecaaa",
        };

        for (String s : tests) {
            System.out.println(new ShortestPalindrome_Solution().shortestPalindrome(s));
        }
    }
}

// 177ms 44.40MB
class ShortestPalindrome_Solution {
    public String shortestPalindrome(String s) {
        char[] sChars = s.toCharArray();

        int copyAt = 0;

        for (int i = s.length()-1; i >= 0 ; i--) {
            if (isPalindrome(sChars,i)) {
                copyAt = i;
                break;
            }
        }

        if (copyAt == s.length()-1) { return s; }

        return createPalindrome(copyAt,s);
    }

    private String createPalindrome(int copyAt, String s) {
        StringBuilder left = new StringBuilder(s);
        left.delete(0, copyAt+1);

        return left.reverse().append(s).toString();
    }

    private boolean isPalindrome(char[] sChars,int start) {
        for (int i = 0; i < sChars.length; i++) {
            if (start < i) {break;}
            if (sChars[i] != sChars[start--]) {
                return false;
            }
        }

        return true;
    }
}