package Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/circular-sentence/">2490. Circular Sentence</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>A <strong>sentence</strong> is a list of words that are separated by a<strong> single</strong> space with no leading or trailing spaces.</p>
 * 
 * <ul>
 * 	<li>For example, <code>"Hello World"</code>, <code>"HELLO"</code>, <code>"hello world hello world"</code> are all sentences.</li>
 * </ul>
 * 
 * <p>Words consist of <strong>only</strong> uppercase and lowercase English letters. Uppercase and lowercase English letters are considered different.</p>
 * 
 * <p>A sentence is <strong>circular </strong>if:</p>
 * 
 * <ul>
 * 	<li>The last character of a word is equal to the first character of the next word.</li>
 * 	<li>The last character of the last word is equal to the first character of the first word.</li>
 * </ul>
 * 
 * <p>For example, <code>"leetcode exercises sound delightful"</code>, <code>"eetcode"</code>, <code>"leetcode eats soul" </code>are all circular sentences. However, <code>"Leetcode is cool"</code>, <code>"happy Leetcode"</code>, <code>"Leetcode"</code> and <code>"I like Leetcode"</code> are <strong>not</strong> circular sentences.</p>
 * 
 * <p>Given a string <code>sentence</code>, return <code>true</code><em> if it is circular</em>. Otherwise, return <code>false</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> sentence = "leetcode exercises sound delightful"
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> The words in sentence are ["leetcode", "exercises", "sound", "delightful"].
 * - leetcod<u>e</u>'s&nbsp;last character is equal to <u>e</u>xercises's first character.
 * - exercise<u>s</u>'s&nbsp;last character is equal to <u>s</u>ound's first character.
 * - soun<u>d</u>'s&nbsp;last character is equal to <u>d</u>elightful's first character.
 * - delightfu<u>l</u>'s&nbsp;last character is equal to <u>l</u>eetcode's first character.
 * The sentence is circular.</pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> sentence = "eetcode"
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> The words in sentence are ["eetcode"].
 * - eetcod<u>e</u>'s&nbsp;last character is equal to <u>e</u>etcode's first character.
 * The sentence is circular.</pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> sentence = "Leetcode is cool"
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> The words in sentence are ["Leetcode", "is", "cool"].
 * - Leetcod<u>e</u>'s&nbsp;last character is <strong>not</strong> equal to <u>i</u>s's first character.
 * The sentence is <strong>not</strong> circular.</pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= sentence.length &lt;= 500</code></li>
 * 	<li><code>sentence</code> consist of only lowercase and uppercase English letters and spaces.</li>
 * 	<li>The words in <code>sentence</code> are separated by a single space.</li>
 * 	<li>There are no leading or trailing spaces.</li>
 * </ul>
 * </div></div>
 */
public class CircularSentence {
    public static void main(String[] args) {
        String[] tests = {
            "leetcode exercises sound delightful"
        };
        
        for (String sentence : tests) {
            System.out.println(new CircularSentence_Solution().isCircularSentence(sentence));
        }
    }
}

// 1ms 42.01MB
class CircularSentence_Solution {
    public boolean isCircularSentence(String sentence) {
        String words[] = sentence.split(" "),
               pre_word = words[0];
        
        for (int i = 1; i < words.length; i++) {
            String temp_word = words[i];
            if (temp_word.charAt(0) != pre_word.charAt(pre_word.length()-1)) {
                return false;
            }
            pre_word = temp_word;
        }

        if (pre_word.charAt(pre_word.length()-1) != words[0].charAt(0)) {
            return false;
        }

        return true;
    }
}