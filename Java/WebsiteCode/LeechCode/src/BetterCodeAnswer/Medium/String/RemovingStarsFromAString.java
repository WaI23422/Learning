package BetterCodeAnswer.Medium.String;

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

// 6ms 46.55MB -> 8ms 45.84MB
class RemovingStarsFromAString_Solution {
    public String removeStars(String s) {
        int len = s.length();
        byte[] res = s.getBytes();
        // The method getBytes(int, int, byte[], int) from the type String is deprecated since version 1.1
        // 6ms 46.55MB
        // s.getBytes(0,len,res,0);
        int countStars = 0;
        for(int i = 0; i<len; i++)
        {
            if(res[i] == '*') countStars++;
            else res[i-countStars*2] = res[i];
        }
        return new String(res, 0, len-countStars*2);
    }
}

// 14ms 45.16MB
class RemovingStarsFromAString_Solution2 {
    public String removeStars(String s) {
        char arr[] = new char[s.length()];
        int ind = 0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == '*'){
                ind--;
            }
            else{
                arr[ind++] = s.charAt(i);
            }
        }
        return new String(arr,0,ind);
    }
}