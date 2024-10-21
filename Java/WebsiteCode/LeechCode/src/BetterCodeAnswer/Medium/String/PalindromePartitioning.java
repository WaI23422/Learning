package BetterCodeAnswer.Medium.String;

import java.util.ArrayList;
import java.util.List;
import java.util.AbstractList; 

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

// 0 ms 56.9 MB
class PalindromePartitioning_Solution {

    private StringBuilder givenStr;
    private int givenStrLength;

    private List<List<String>> result;
    private List<String> subsResult;

    public List<List<String>> partition(String s) {

        // result = new ArrayList<List<String>>();
        givenStr = new StringBuilder(s);
        givenStrLength = s.length();
        subsResult = new ArrayList<String>();

        // dfs(0);
        // return result;     

        return new AbstractList<List<String>>() {
            @Override
            public int size() {
                init();
                return result.size();
            }

            @Override
            public List<String> get(int index) {
                init();
                return result.get(index);
            }

            private void init() {
                if (result != null) return;
                result = new ArrayList<List<String>>();
                dfs(0);
            }
        };
        
    }

     private void dfs(int startIndex) {
        if (startIndex == givenStrLength) {
            result.add(new ArrayList<String>(subsResult));
            return;
        }

        for (int i = startIndex; i < givenStrLength; i++) {
            // we do not need to process further
            // if the first part of the string (startIndex to i) is not palindrome
            if (!isPalindrome(givenStr, startIndex, i)) continue;

            // It means that first part (startIndex to i) is palindrome.
            // Let add into the subResult
            subsResult.add(givenStr.substring(startIndex, i + 1));

            // Now let process the second part (i+1 to string length)
            dfs(i + 1);

            // Repeat the for (startIndex to i+1), so let remove from the list
            subsResult.remove(subsResult.size() - 1);
        }

    }

    private boolean isPalindrome(StringBuilder s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }

}

// 4 ms 55.5 MB
class PalindromePartitioning_Solution2 {
    int n;
    boolean[][] is_palindrome;
    String[][] substrings;

    List<List<String>> ans;

    void FindSubstrings(int ind, ArrayList<String> list) {
        if (ind == n) {
            ans.add(new ArrayList<String>(list));
            return;
        }

        for (int i = ind + 1; i <= n; i++) {
            if (!is_palindrome[ind][i]) continue;
            list.add(substrings[ind][i]);
            FindSubstrings(i, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        n = s.length();
        is_palindrome = new boolean[n + 1][n + 1];
        substrings = new String[n + 1][n + 1];
        for (int i = 0; i < n; i++) for (int j = i + 1; j <= n; j++) {
            substrings[i][j] = s.substring(i, j);
            is_palindrome[i][j] = IsPalindrome(substrings[i][j]);
        }

        ans = new ArrayList<List<String>>();
        FindSubstrings(0, new ArrayList<String>());
        return ans;
    }

    boolean IsPalindrome(String s) {
        int lower = 0;
        int higher = s.length() - 1;
        while (lower < higher) {
            if (s.charAt(lower) != s.charAt(higher)) return false;
            lower++;
            higher--;
        }
        return true;
    }
}