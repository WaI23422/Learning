package BetterCodeAnswer.Hard.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/word-break-ii/">140. Word Break II</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code> and a dictionary of strings <code>wordDict</code>, add spaces in <code>s</code> to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in <strong>any order</strong>.</p>
 * 
 * <p><strong>Note</strong> that the same word in the dictionary may be reused multiple times in the segmentation.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * <strong>Output:</strong> ["cats and dog","cat sand dog"]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * <strong>Output:</strong> ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * <strong>Explanation:</strong> Note that you are allowed to reuse a dictionary word.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * <strong>Output:</strong> []
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 20</code></li>
 * 	<li><code>1 &lt;= wordDict.length &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= wordDict[i].length &lt;= 10</code></li>
 * 	<li><code>s</code> and <code>wordDict[i]</code> consist of only lowercase English letters.</li>
 * 	<li>All the strings of <code>wordDict</code> are <strong>unique</strong>.</li>
 * 	<li>Input is generated in a way that the length of the answer doesn't exceed&nbsp;10<sup>5</sup>.</li>
 * </ul>
 * </div>
 */
public class WordBreakII {
    public static void main(String[] args) {
        String[][][] tests = {
            {
                {"pineapplepenapple"},
                {"apple","pen","applepen","pine","pineapple"}
            },
            {
                {"catsanddog"},
                {"cat","cats","and","sand","dog"}
            },
        };

        for (String[][] test : tests) {
            String s = test[0][0];

            List<String> wordDict = new ArrayList<>();
            for (String word : test[1]) {
                wordDict.add(word);
            }

            System.out.println(new WordBreakII_Solution().wordBreak(s, wordDict));
        }
    }
}

// 1 ms 41.5 MB
class WordBreakII_Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> results = new ArrayList<>();
        backtrack(s, wordSet, new StringBuilder(), results, 0);
        return results;
    }

    private static void backtrack(String s, Set<String> wordSet, StringBuilder currentSentence, List<String> results, int startIndex) {
        if (startIndex == s.length()) {
            results.add(currentSentence.toString().trim());
            return;
        }

        for (int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {
            String word = s.substring(startIndex, endIndex);
            if (wordSet.contains(word)) {
                int currentLength = currentSentence.length();
                currentSentence.append(word).append(" ");
                backtrack(s, wordSet, currentSentence, results, endIndex);
                currentSentence.setLength(currentLength);
            }
        }
    }
}

class TrieNode {

    boolean isEnd;
    TrieNode[] children;

    TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
    }
}

class Trie {

    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
}

// 5 ms 42.3 MB
class WordBreakII_Solution2 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        // Build the Trie from the word dictionary
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }

        // Map to store results of subproblems
        Map<Integer, List<String>> dp = new HashMap<>();

        // Iterate from the end of the string to the beginning
        for (int startIdx = s.length(); startIdx >= 0; startIdx--) {
            // List to store valid sentences starting from startIdx
            List<String> validSentences = new ArrayList<>();

            // Initialize current node to the root of the trie
            TrieNode currentNode = trie.root;

            // Iterate from startIdx to the end of the string
            for (int endIdx = startIdx; endIdx < s.length(); endIdx++) {
                char c = s.charAt(endIdx);
                int index = c - 'a';

                // Check if the current character exists in the trie
                if (currentNode.children[index] == null) {
                    break;
                }

                // Move to the next node in the trie
                currentNode = currentNode.children[index];

                // Check if we have found a valid word
                if (currentNode.isEnd) {
                    String currentWord = s.substring(startIdx, endIdx + 1);

                    // If it's the last word, add it as a valid sentence
                    if (endIdx == s.length() - 1) {
                        validSentences.add(currentWord);
                    } else {
                        // If it's not the last word, append it to each sentence formed by the remaining substring
                        List<String> sentencesFromNextIndex = dp.get(
                            endIdx + 1
                        );
                        if (sentencesFromNextIndex != null) {
                            for (String sentence : sentencesFromNextIndex) {
                                validSentences.add(
                                    currentWord + " " + sentence
                                );
                            }
                        }
                    }
                }
            }

            // Store the valid sentences in dp
            dp.put(startIdx, validSentences);
        }

        // Return the sentences formed from the entire string
        return dp.getOrDefault(0, new ArrayList<>());
    }
}


// 5 ms 42 MB
class WordBreakII_Solution3 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        // Map to store results of subproblems
        Map<Integer, List<String>> dp = new HashMap<>();

        // Iterate from the end of the string to the beginning
        for (int startIdx = s.length(); startIdx >= 0; startIdx--) {
            // List to store valid sentences starting from startIdx
            List<String> validSentences = new ArrayList<>();

            // Iterate from startIdx to the end of the string
            for (int endIdx = startIdx; endIdx < s.length(); endIdx++) {
                // Extract substring from startIdx to endIdx
                String currentWord = s.substring(startIdx, endIdx + 1);

                // Check if the current substring is a valid word
                if (isWordInDict(currentWord, wordDict)) {
                    // If it's the last word, add it as a valid sentence
                    if (endIdx == s.length() - 1) {
                        validSentences.add(currentWord);
                    } else {
                        // If it's not the last word, append it to each sentence formed by the remaining substring
                        List<String> sentencesFromNextIndex = dp.get(
                            endIdx + 1
                        );
                        for (String sentence : sentencesFromNextIndex) {
                            validSentences.add(currentWord + " " + sentence);
                        }
                    }
                }
            }
            // Store the valid sentences in dp
            dp.put(startIdx, validSentences);
        }
        // Return the sentences formed from the entire string
        return dp.getOrDefault(0, new ArrayList<>());
    }

    // Helper function to check if a word is in the word dictionary
    private boolean isWordInDict(String word, List<String> wordDict) {
        return wordDict.contains(word);
    }
}