package BetterCodeAnswer.Medium.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

class Trie{
    Trie [] children;
    boolean isEnd;
    public Trie(){
        children = new Trie[26];
        isEnd =false;
    }
} 

// 9 ms 55.6 MB
class ReplaceWords_Solution {
    Trie root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Trie();
        for(String word : dictionary){
            insert(word);
        }
        StringBuilder result = new StringBuilder();
        String []  input = sentence.split(" ");
        for(String i : input){
            result.append(search(i));
            result.append(" ");
        }
        return result.toString().trim();
    }

    public String search(String word){
        Trie node = root;
        int j = 0;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            j++;
            if(node.children[i] == null){
                return word;
            }else if(node.children[i].isEnd){
                return word.substring(0, j);
            }else{
                node = node.children[i];
            }
            
        }
        return word;

    }
    public void insert(String word){
        Trie node = root;
        for(char c: word.toCharArray()){
            int i = c - 'a';
            if(node.children[i] == null){
                node.children[i] = new Trie();
            }
            node = node.children[i];
        }
        node.isEnd = true;
    }
}

// 20 ms 55.2 MB
class ReplaceWords_Solution2 {
    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.forEach(root -> insert(root));

        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split(" ")) {
            sb.append(getRootWord(word)).append(" ");
        }
        return sb.toString().trim();
    }

    class TrieNode {
        Map<Character, TrieNode> links;
        boolean isEndOfWord;

        public TrieNode() {
            links = new HashMap<>();
            isEndOfWord = false;
        }
    }

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            TrieNode charNode = node.links.get(c);
            if (charNode == null) {
                charNode = new TrieNode();
                node.links.put(c, charNode);
            }
            node = charNode;
        }
        node.isEndOfWord = true;
    }

    public String getRootWord(String word) {
        if (root.links.get(word.charAt(0)) == null)
            return word;

        TrieNode node = root;
        StringBuilder rootWord = new StringBuilder();
        for (char c : word.toCharArray()) {
            rootWord.append(c);
            TrieNode charNode = node.links.get(c);
            if (charNode == null)
                return word;
            if (charNode != null && charNode.isEndOfWord)
                return rootWord.toString();
            node = charNode;
        }
        return word;
    }

}