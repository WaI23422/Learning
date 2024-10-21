package Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/detect-capital/">520. Detect Capital</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>We define the usage of capitals in a word to be right when one of the following cases holds:</p>
 * 
 * <ul>
 * 	<li>All letters in this word are capitals, like <code>"USA"</code>.</li>
 * 	<li>All letters in this word are not capitals, like <code>"leetcode"</code>.</li>
 * 	<li>Only the first letter in this word is capital, like <code>"Google"</code>.</li>
 * </ul>
 * 
 * <p>Given a string <code>word</code>, return <code>true</code> if the usage of capitals in it is right.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> word = "USA"
 * <strong>Output:</strong> true
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> word = "FlaG"
 * <strong>Output:</strong> false
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= word.length &lt;= 100</code></li>
 * 	<li><code>word</code> consists of lowercase and uppercase English letters.</li>
 * </ul>
 * </div>
 */
public class DetectCapital {
    public static void main(String[] args) {
        String[] tests = {
            "USA",
            "FlaG"
        };

        for (String word : tests) {
            System.out.println(new DetectCapital_Solution().detectCapitalUse(word));
        }
    }
}

// 2 ms 41.8 MB
class DetectCapital_Solution {
    public boolean detectCapitalUse(String word) {
        return word.toUpperCase().equals(word) | 
               word.toLowerCase().equals(word) |
               (
                word.charAt(0) == Character.toUpperCase(word.charAt(0)) &&
                word.substring(1).equals(word.substring(1).toLowerCase())
               );
    }
}