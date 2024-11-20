package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/take-k-of-each-character-from-left-and-right/">2516. Take K of Each Character From Left and Right</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code> consisting of the characters <code>'a'</code>, <code>'b'</code>, and <code>'c'</code> and a non-negative integer <code>k</code>. Each minute, you may take either the <strong>leftmost</strong> character of <code>s</code>, or the <strong>rightmost</strong> character of <code>s</code>.</p>
 * 
 * <p>Return<em> the <strong>minimum</strong> number of minutes needed for you to take <strong>at least</strong> </em><code>k</code><em> of each character, or return </em><code>-1</code><em> if it is not possible to take </em><code>k</code><em> of each character.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "aabaaaacaabc", k = 2
 * <strong>Output:</strong> 8
 * <strong>Explanation:</strong> 
 * Take three characters from the left of s. You now have two 'a' characters, and one 'b' character.
 * Take five characters from the right of s. You now have four 'a' characters, two 'b' characters, and two 'c' characters.
 * A total of 3 + 5 = 8 minutes is needed.
 * It can be proven that 8 is the minimum number of minutes needed.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "a", k = 1
 * <strong>Output:</strong> -1
 * <strong>Explanation:</strong> It is not possible to take one 'b' or 'c' so return -1.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>s</code> consists of only the letters <code>'a'</code>, <code>'b'</code>, and <code>'c'</code>.</li>
 * 	<li><code>0 &lt;= k &lt;= s.length</code></li>
 * </ul>
 * </div></div>
 */
public class TakeKOfEachCharacterFromLeftAndRight {
    public static void main(String[] args) {
        String[][] tests = {
            {
                "a",
                "0"
            },
            {
                "aaccbba",
                "2"
            },
            {
                "aabaaaacaabc",
                "2"
            }
        };

        for (String[] test : tests) {
            String s = test[0];
            int k = Integer.parseInt(test[1]);

            System.out.println(new TakeKOfEachCharacterFromLeftAndRight_Solution().takeCharacters(s, k));
        }
    }
}

// 7ms 45.18MB
class TakeKOfEachCharacterFromLeftAndRight_Solution {
    public int takeCharacters(String s, int k) {
        int[] arr = new int[3];
        char[] c = s.toCharArray();
        int cur,len = c.length;
        for(cur = 0; cur < len; cur++){
            arr[c[cur] - 'a']++;
            if(arr[0] >= k && arr[1] >= k && arr[2] >= k) break;
        }
        if(cur == len) return -1;
        int count = cur + 1,min = count,end = len - 1;
        while(cur >= 0){
            if(arr[c[cur] - 'a'] == k){
                while(c[cur] != c[end]){
                    arr[c[end] - 'a']++;
                    end--;
                    count++;
                }
                end--;
            }else{
                arr[c[cur] - 'a']--;
                count--;
                min = Math.min(count, min);
            }
            cur--; 
        }
        return min;
    }
}