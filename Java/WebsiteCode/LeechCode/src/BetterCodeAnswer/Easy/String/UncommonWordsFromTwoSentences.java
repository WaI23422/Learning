package BetterCodeAnswer.Easy.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/uncommon-words-from-two-sentences/">884. Uncommon Words from Two Sentences</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>A <strong>sentence</strong> is a string of single-space separated words where each word consists only of lowercase letters.</p>
 * 
 * <p>A word is <strong>uncommon</strong> if it appears exactly once in one of the sentences, and <strong>does not appear</strong> in the other sentence.</p>
 * 
 * <p>Given two <strong>sentences</strong> <code>s1</code> and <code>s2</code>, return <em>a list of all the <strong>uncommon words</strong></em>. You may return the answer in <strong>any order</strong>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">s1 = "this apple is sweet", s2 = "this apple is sour"</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">["sweet","sour"]</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p>The word <code>"sweet"</code> appears only in <code>s1</code>, while the word <code>"sour"</code> appears only in <code>s2</code>.</p>
 * </div>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">s1 = "apple apple", s2 = "banana"</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">["banana"]</span></p>
 * </div>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s1.length, s2.length &lt;= 200</code></li>
 * 	<li><code>s1</code> and <code>s2</code> consist of lowercase English letters and spaces.</li>
 * 	<li><code>s1</code> and <code>s2</code> do not have leading or trailing spaces.</li>
 * 	<li>All the words in <code>s1</code> and <code>s2</code> are separated by a single space.</li>
 * </ul>
 * </div>
 */
public class UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        String[][] tests = {
            {"this apple is sweet","this apple is sour"},
            {"apple apple","banana"}
        };

        for (String[] test : tests) {
            String s1 = test[0],
                   s2 = test[1];

            System.out.println(Arrays.toString(new UncommonWordsFromTwoSentences_Solution().uncommonFromSentences(s1, s2)));
        }
    }
}

// 2ms 42.00MB
class UncommonWordsFromTwoSentences_Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> output = new ArrayList<>(); 
        HashMap<String, Integer> map = new HashMap<>();
        
        String s1Str[] = s1.split(" ");
        for(String word: s1Str) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        String s2Str[] = s2.split(" ");
        for (String word : s2Str) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : map.keySet()) {
            if (map.get(word) == 1) {
                output.add(word);
            }
        }

        return output.toArray(new String[0]);
    }
}