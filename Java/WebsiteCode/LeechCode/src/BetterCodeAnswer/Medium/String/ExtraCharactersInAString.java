package BetterCodeAnswer.Medium.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/extra-characters-in-a-string/">2707. Extra Characters in a String</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> string <code>s</code> and a dictionary of words <code>dictionary</code>. You have to break <code>s</code> into one or more <strong>non-overlapping</strong> substrings such that each substring is present in <code>dictionary</code>. There may be some <strong>extra characters</strong> in <code>s</code> which are not present in any of the substrings.</p>
 * 
 * <p>Return <em>the <strong>minimum</strong> number of extra characters left over if you break up </em><code>s</code><em> optimally.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "leetscode", dictionary = ["leet","code","leetcode"]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1.
 * 
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "sayhelloworld", dictionary = ["hello","world"]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters. Hence, we return 3.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 50</code></li>
 * 	<li><code>1 &lt;= dictionary.length &lt;= 50</code></li>
 * 	<li><code>1 &lt;= dictionary[i].length &lt;= 50</code></li>
 * 	<li><code>dictionary[i]</code>&nbsp;and <code>s</code> consists of only lowercase English letters</li>
 * 	<li><code>dictionary</code> contains distinct words</li>
 * </ul>
 * </div>
 */
public class ExtraCharactersInAString {
    public static void main(String[] args) {
        String[][][] tests = {
            {
                {"hlello"},
                {"hello"}
            },
            {
                {"leetscode"},
                {"leet","code","leetcode"}
            }
        };

        for (String[][] test : tests) {
            String s = test[0][0],
                   dictionary[] = test[1];

            System.out.println(new ExtraCharactersInAString_Solution().minExtraChar(s, dictionary));
        }
    }
}

// Top-Down DP: 44ms 45.26MB
class ExtraCharactersInAString_Solution {
    Integer[] memo;
    HashSet<String> dictionarySet;
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        memo = new Integer[n];
        dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        return dp(0, n, s);
    }
    private int dp(int start, int n, String s) {
        if (start == n) {
            return 0;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        // To count this character as a left over character 
        // move to index 'start + 1'
        int ans = dp(start + 1, n, s) + 1;
        for (int end = start; end < n; end++) {
            var curr = s.substring(start, end + 1);
            if (dictionarySet.contains(curr)) {
                ans = Math.min(ans, dp(end + 1, n, s));
            }
        }

        return memo[start] = ans;
    }
}

// Bottom-Up DP: 45ms 45.06MB
class ExtraCharactersInAString_Solution2 {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        var dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        var dp = new int[n + 1];

        for (int start = n - 1; start >= 0; start--) {
            dp[start] = dp[start + 1] + 1;
            for (int end = start; end < n; end++) {
                var curr = s.substring(start, end + 1);
                if (dictionarySet.contains(curr)) {
                    dp[start] = Math.min(dp[start], dp[end + 1]);
                }
            }
        }

        return dp[0];
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean is_word = false;
}

// Top-Down Trie: 15ms 45.64MB
class ExtraCharactersInAString_Solution3 {
    TrieNode root;
    Integer[] memo;
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        root = buildTrie(dictionary);
        memo = new Integer[n + 1];
        return dp(0, n, s);
    }
    
    private int dp(int start, int n, String s) {
        if (start == n) {
            return 0;
        }
        if (memo[start] != null) {
            return memo[start];
        }

        TrieNode node = root;
        // To count this character as a left over character 
        // move to index 'start + 1'
        int ans = dp(start + 1, n, s) + 1;
        for (int end = start; end < n; end++) {
            char c = s.charAt(end);
            if (!node.children.containsKey(c)) {
                break;
            }
            node = node.children.get(c);
            if (node.is_word) {
                ans = Math.min(ans, dp(end + 1, n, s));
            }
        }
        
        return memo[start] = ans;
    }
    
    private TrieNode buildTrie(String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.is_word = true;
        }
        return root;
    }
}

// Bottom-Up Trie: 13ms 45.64MB
class ExtraCharactersInAString_Solution4 {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        var root = buildTrie(dictionary);
        var dp = new int[n + 1];

        for (int start = n - 1; start >= 0; start--) {
            dp[start] = dp[start + 1] + 1;
            var node = root;
            for (int end = start; end < n; end++) {
                if (!node.children.containsKey(s.charAt(end))) {
                    break;
                }
                node = node.children.get(s.charAt(end));
                if (node.is_word) {
                    dp[start] = Math.min(dp[start], dp[end + 1]);
                }
            }
        }

        return dp[0];
    }

    private TrieNode buildTrie(String[] dictionary) {
        var root = new TrieNode();
        for (var word : dictionary) {
            var node = root;
            for (var c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.is_word = true;
        }
        return root;
    }
}