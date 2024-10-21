package BetterCodeAnswer.Easy.String;

import java.util.Arrays;

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

// 0ms 41.22 MB
class KeyboardRow_Solution { 
    public String[] findWords(String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++){
            if(keyboard(words[i])){
                //strarr[count]=words[i];
                count++;

            }
        }
        String[] strarr=new String[count];
        count=0;
        for(int i=0;i<words.length;i++){
            if(keyboard(words[i])){
                strarr[count]=words[i];
                count++;

            }
        }
return strarr;
        
    }
    public static boolean keyboard(String s){
        String row1="qwertyuiopQWERTYUIOP";
        String row2="asdfghjklASDFGHJKL";
        String row3="zxcvbnmZXCVBNM";
        if(row1.contains(String.valueOf(s.charAt(0)))){
            for (int i = 1; i < s.length(); i++) {
                if(!(row1.contains(String.valueOf(s.charAt(i))))) {
                    return false;
                }
            }
        }
        if(row2.contains(String.valueOf(s.charAt(0)))){
            for (int i = 1; i < s.length(); i++) {
                if(!row2.contains(String.valueOf(s.charAt(i)))) {
                    return false;
                }
            }
        }
        if(row3.contains(String.valueOf(s.charAt(0)))){
            for (int i = 1; i < s.length(); i++) {
                if(!row3.contains(String.valueOf(s.charAt(i)))) {
                    return false;
                }
            }
        }
        return true;
    }
    
}