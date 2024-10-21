package Medium.String;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/palindrome-partitioning/">131. Palindrome Partitioning</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code>, partition <code>s</code> such that every <span data-keyword="substring-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:r11:"><div>substring</div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(334px, 183px);"></div></div></div></span> of the partition is a <span data-keyword="palindrome-string" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:r13:"><div><strong>palindrome</strong></div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(525px, 183px);"></div></div></div></span>. Return <em>all possible palindrome partitioning of </em><code>s</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> s = "aab"
 * <strong>Output:</strong> [["a","a","b"],["aa","b"]]
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> s = "a"
 * <strong>Output:</strong> [["a"]]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 16</code></li>
 * 	<li><code>s</code> contains only lowercase English letters.</li>
 * </ul>
 * </div>
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        String[] tests= {
            "adaad",
            "adaadaa",
            "aab",
            "a",
        };

        for (String s : tests) {
            System.out.println(new PalindromePartitioning_Solution().partition(s));
        }
    }
}

// 7 ms 57 MB
class PalindromePartitioning_Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        int lenS = s.length();

        explore(0, s, curr, result, lenS);
        return result;
    }

    private void explore(int index, String s, List<String> curr, List<List<String>> result, int lenS) {
        if (index >= lenS) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < lenS; ++i) {
            String subStr = s.substring(index, i + 1);
            if (isPalindrome(subStr)) {
                curr.add(subStr);
                explore(i + 1, s, curr, result, lenS);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {return false;}
            left++;
            right--;
        }

        return true;
    }
}