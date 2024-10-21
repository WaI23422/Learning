package Medium.String;

import java.util.Stack;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/removing-stars-from-a-string/">2390. Removing Stars From a String</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code>, which contains stars <code>*</code>.</p>
 * 
 * <p>In one operation, you can:</p>
 * 
 * <ul>
 * 	<li>Choose a star in <code>s</code>.</li>
 * 	<li>Remove the closest <strong>non-star</strong> character to its <strong>left</strong>, as well as remove the star itself.</li>
 * </ul>
 * 
 * <p>Return <em>the string after <strong>all</strong> stars have been removed</em>.</p>
 * 
 * <p><strong>Note:</strong></p>
 * 
 * <ul>
 * 	<li>The input will be generated such that the operation is always possible.</li>
 * 	<li>It can be shown that the resulting string will always be unique.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "leet**cod*e"
 * <strong>Output:</strong> "lecoe"
 * <strong>Explanation:</strong> Performing the removals from left to right:
 * - The closest character to the 1<sup>st</sup> star is 't' in "lee<strong><u>t</u></strong>**cod*e". s becomes "lee*cod*e".
 * - The closest character to the 2<sup>nd</sup> star is 'e' in "le<strong><u>e</u></strong>*cod*e". s becomes "lecod*e".
 * - The closest character to the 3<sup>rd</sup> star is 'd' in "leco<strong><u>d</u></strong>*e". s becomes "lecoe".
 * There are no more stars, so we return "lecoe".</pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "erase*****"
 * <strong>Output:</strong> ""
 * <strong>Explanation:</strong> The entire string is removed, so we return an empty string.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>s</code> consists of lowercase English letters and stars <code>*</code>.</li>
 * 	<li>The operation above can be performed on <code>s</code>.</li>
 * </ul>
 * </div>
 */
public class RemovingStarsFromAString {
    public static void main(String[] args) {
        String[] tests = {
            "erase*****a",
            "erase*****",
            "leet**cod*e",
            "leetcode",
        };

        for (String s : tests) {
            System.out.println(new RemovingStarsFromAString_Solution().removeStars(s));
        }

    }
}

// 66ms 46.55MB
class RemovingStarsFromAString_Solution1 {
    public String removeStars(String s) {
        char[] sChars = s.toCharArray();

        Stack<Character> charStack = new Stack<>();
        
        for (char c : sChars) {
            if (c == '*') {
                charStack.pop();
            } else {
                charStack.add(c);
            }
        }

        StringBuffer str = new StringBuffer();
        for (Character c : charStack) {
            str.append(c);
        }
        // 511ms 49.97 MB
        // s = "";
        // for (Character c : charStack) {
        //     s+=c;
        // }

        return str.toString();
    }
}

// 72ms 54.84MB -> 32ms 45.60MB
class RemovingStarsFromAString_Solution {
    public String removeStars(String s) {
        // String[] nonStarString = s.split("\\*");
        // int len = nonStarString.length;

        // if (len == 1 && len == s.length()) { return s; }

        
        // StringBuffer ans = new StringBuffer();
        // int totalLen = 0;
        // for (String str : nonStarString) {
        //     if (!str.equals("")) {
        //         ans.append(str);
        //         totalLen += str.length()+1;
        //     } else {
        //         totalLen += 1;
        //     }
        //     ans.deleteCharAt(ans.length()-1);
        // }
        // ans.append(nonStarString[len-1].charAt(nonStarString[len-1].length()-1));
        // for (int i = totalLen-1; i < s.length(); i++) {
        //     ans.deleteCharAt(ans.length()-1);
        // }

        // return ans.toString();

        StringBuilder sb=new StringBuilder();
        for(char c :s.toCharArray()){
            if(c=='*'){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(c);
            }
        }
            return sb.toString();
    }
}