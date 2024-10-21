package Hard.String;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sum-of-prefix-scores-of-strings/">2416. Sum of Prefix Scores of Strings</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an array <code>words</code> of size <code>n</code> consisting of <strong>non-empty</strong> strings.</p>
 * 
 * <p>We define the <strong>score</strong> of a string <code>word</code> as the <strong>number</strong> of strings <code>words[i]</code> such that <code>word</code> is a <strong>prefix</strong> of <code>words[i]</code>.</p>
 * 
 * <ul>
 * 	<li>For example, if <code>words = ["a", "ab", "abc", "cab"]</code>, then the score of <code>"ab"</code> is <code>2</code>, since <code>"ab"</code> is a prefix of both <code>"ab"</code> and <code>"abc"</code>.</li>
 * </ul>
 * 
 * <p>Return <em>an array </em><code>answer</code><em> of size </em><code>n</code><em> where </em><code>answer[i]</code><em> is the <strong>sum</strong> of scores of every <strong>non-empty</strong> prefix of </em><code>words[i]</code>.</p>
 * 
 * <p><strong>Note</strong> that a string is considered as a prefix of itself.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> words = ["abc","ab","bc","b"]
 * <strong>Output:</strong> [5,4,3,2]
 * <strong>Explanation:</strong> The answer for each string is the following:
 * - "abc" has 3 prefixes: "a", "ab", and "abc".
 * - There are 2 strings with the prefix "a", 2 strings with the prefix "ab", and 1 string with the prefix "abc".
 * The total is answer[0] = 2 + 2 + 1 = 5.
 * - "ab" has 2 prefixes: "a" and "ab".
 * - There are 2 strings with the prefix "a", and 2 strings with the prefix "ab".
 * The total is answer[1] = 2 + 2 = 4.
 * - "bc" has 2 prefixes: "b" and "bc".
 * - There are 2 strings with the prefix "b", and 1 string with the prefix "bc".
 * The total is answer[2] = 2 + 1 = 3.
 * - "b" has 1 prefix: "b".
 * - There are 2 strings with the prefix "b".
 * The total is answer[3] = 2.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> words = ["abcd"]
 * <strong>Output:</strong> [4]
 * <strong>Explanation:</strong>
 * "abcd" has 4 prefixes: "a", "ab", "abc", and "abcd".
 * Each prefix has a score of one, so the total is answer[0] = 1 + 1 + 1 + 1 = 4.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= words.length &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= words[i].length &lt;= 1000</code></li>
 * 	<li><code>words[i]</code> consists of lowercase English letters.</li>
 * </ul>
 * </div>
 */
public class SumOfPrefixScoresOfStrings {
    public static void main(String[] args) {
        String[][] tests = {
            {"abc","ab","bc","b"}
        };

        for (String[] words : tests) {
            System.out.println(Arrays.toString(new SumOfPrefixScoresOfStrings_Solution().sumPrefixScores(words)));
        }
    }
}

class TrieChar {
    TrieChar[] child = new TrieChar[26];
    int num = 0;
}

// 308ms 187.06MB
class SumOfPrefixScoresOfStrings_Solution {
    public int[] sumPrefixScores(String[] words) {
        TrieChar words_score = addScore(words);
        int len = words.length,
            sum_prefix[] = new int[len];

        for (int i = 0; i < len; i++) {
            TrieChar temp = words_score;
            char[] str_chars = words[i].toCharArray();
            int score = 0;

            for (char c : str_chars) {
                score += temp.child[c-'a'].num;
                temp = temp.child[c-'a'];
            }

            sum_prefix[i] = score;
        }

        return sum_prefix;
    }

    private TrieChar addScore(String[] words) {
        TrieChar scores = new TrieChar();

        for (String str : words) {
            char[] str_chars = str.toCharArray();
            TrieChar trie_temp = scores;

            for (char c : str_chars) {
                if (trie_temp.child[c-'a'] == null) {
                    trie_temp.child[c-'a'] = new TrieChar();
                }

                trie_temp.child[c-'a'].num++;
                trie_temp = trie_temp.child[c-'a'];
            }
        }

        return scores;
    }
}