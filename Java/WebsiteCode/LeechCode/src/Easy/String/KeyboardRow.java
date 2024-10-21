package Easy.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/keyboard-row/">500. Keyboard Row</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of strings <code>words</code>, return <em>the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below</em>.</p>
 * 
 * <p>In the <strong>American keyboard</strong>:</p>
 * 
 * <ul>
 * 	<li>the first row consists of the characters <code>"qwertyuiop"</code>,</li>
 * 	<li>the second row consists of the characters <code>"asdfghjkl"</code>, and</li>
 * 	<li>the third row consists of the characters <code>"zxcvbnm"</code>.</li>
 * </ul>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/10/12/keyboard.png" style="width: 800px; max-width: 600px; height: 267px;">
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> words = ["Hello","Alaska","Dad","Peace"]
 * <strong>Output:</strong> ["Alaska","Dad"]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> words = ["omk"]
 * <strong>Output:</strong> []
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> words = ["adsdf","sfd"]
 * <strong>Output:</strong> ["adsdf","sfd"]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= words.length &lt;= 20</code></li>
 * 	<li><code>1 &lt;= words[i].length &lt;= 100</code></li>
 * 	<li><code>words[i]</code> consists of English letters (both lowercase and uppercase).&nbsp;</li>
 * </ul>
 * </div>
 * 
 */
public class KeyboardRow {
    public static void main(String[] args) {
        String[][] tests = {
            {"Hello","Alaska","Dad","Peace"}
        };

        for (String[] words : tests) {
            System.out.println(Arrays.toString(
                new KeyboardRow_Solution().findWords(words)
            ));
        }
    }
}

// 0ms 41MB
class KeyboardRow_Solution {
    int[][] keyboardCharsRow = {
        {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0},
        {1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
    };

    public String[] findWords(String[] words) {
        List<String> store = new ArrayList<>();

        for (String word : words) {
            if (charsCotain(word.toCharArray())) {
                store.add(word);
            }
        }

        return store.toArray(new String[0]); // store.toArray(String[]::new); 1ms -> 0ms
    }

    private boolean charsCotain(char[] word) {
        int row = rowAt(Character.toLowerCase(word[0]));

        for (char c : word) {
            if (keyboardCharsRow[row][Character.toLowerCase(c)-'a'] == 0) {
                return false;
            }
        }

        return true;
    }

    private int rowAt(char c) {
        for (int i = 0; i < 3; i++) {
            if (keyboardCharsRow[i][c-'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}