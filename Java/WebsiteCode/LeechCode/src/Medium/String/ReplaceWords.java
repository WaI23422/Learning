package Medium.String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/replace-words/">648. Replace Words</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>In English, we have a concept called <strong>root</strong>, which can be followed by some other word to form another longer word - let's call this word <strong>derivative</strong>. For example, when the <strong>root</strong> <code>"help"</code> is followed by the word <code>"ful"</code>, we can form a derivative <code>"helpful"</code>.</p>
 * 
 * <p>Given a <code>dictionary</code> consisting of many <strong>roots</strong> and a <code>sentence</code> consisting of words separated by spaces, replace all the derivatives in the sentence with the <strong>root</strong> forming it. If a derivative can be replaced by more than one <strong>root</strong>, replace it with the <strong>root</strong> that has <strong>the shortest length</strong>.</p>
 * 
 * <p>Return <em>the <code>sentence</code></em> after the replacement.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * <strong>Output:</strong> "the cat was rat by the bat"
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * <strong>Output:</strong> "a a b c"
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= dictionary.length &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= dictionary[i].length &lt;= 100</code></li>
 * 	<li><code>dictionary[i]</code> consists of only lower-case letters.</li>
 * 	<li><code>1 &lt;= sentence.length &lt;= 10<sup>6</sup></code></li>
 * 	<li><code>sentence</code> consists of only lower-case letters and spaces.</li>
 * 	<li>The number of words in <code>sentence</code> is in the range <code>[1, 1000]</code></li>
 * 	<li>The length of each word in <code>sentence</code> is in the range <code>[1, 1000]</code></li>
 * 	<li>Every two consecutive words in <code>sentence</code> will be separated by exactly one space.</li>
 * 	<li><code>sentence</code> does not have leading or trailing spaces.</li>
 * </ul>
 * </div>
 */
public class ReplaceWords {
    public static void main(String[] args) {
        String[][][] tests= {
            {
                {"cat","bat","rat"},
                {"the cattle was rattled by the battery"}
            }
        };

        for (String[][] test : tests) {
            List<String> dictionary = Arrays.asList(test[0]);
            String sentence = test[1][0];

            System.out.println(new ReplaceWords_Solution().replaceWords(dictionary, sentence));
        }
    }
}

// Time Limit Exceeded
class ReplaceWords_Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split("\s");
        StringBuffer str = new StringBuffer();

        for (String word : words) {
            str.append(partOfStringInDic(dictionary,word) + " ");  
        }

        return str.deleteCharAt(str.length()).toString();
    }

    private String partOfStringInDic(List<String> dictionary, String word) {
        int len = word.length();
        
        for (int i = 0; i < len; i++) {
            String subStr = word.substring(0, i);
            if (dictionary.contains(subStr)) {
                return subStr;
            }
        }

        return word;
    }
}

// 699 ms 53.1 MB
class ReplaceWords_Solution2 {

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] wordArray = sentence.split(" ");
        Set<String> dictSet = new HashSet<>(dictionary);

        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = shortestRoot(wordArray[i], dictSet);
        }

        return String.join(" ", wordArray);
    }

    private String shortestRoot(String word, Set<String> dictSet) {
        for (int i = 1; i <= word.length(); i++) {
            String root = word.substring(0, i);
            if (dictSet.contains(root)) {
                return root;
            }
        }
        
        return word;
    }
}