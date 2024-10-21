package BetterCodeAnswer.Easy.Number;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/base-7/">504. Base 7</a>
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer <code>num</code>, return <em>a string of its <strong>base 7</strong> representation</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> num = 100
 * <strong>Output:</strong> "202"
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> num = -7
 * <strong>Output:</strong> "-10"
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>-10<sup>7</sup> &lt;= num &lt;= 10<sup>7</sup></code></li>
 * </ul>
 * </div>
 */
public class BaseSeven {
    public static void main(String[] args) {
        int[] tests = {
            1002,
            100,
            -7
        };

        for (int num : tests) {
            System.out.println(new BaseSeven_Solution().convertToBase7(num));
        }
    }
}

// 1 ms 41.53 MB
class BaseSeven_Solution {
    public String convertToBase7(int num) {
        if (num < 0)
            return "-" + convertToBase7(-num);
        else if (num == 0)
            return "0";
        List<Character> chars = new ArrayList<>();
        while (num > 0) {
            int q = num % 7;
            if (q == 0)
                chars.add('0');
            while (q > 0) {
                chars.add((char) ((q % 10) + '0'));
                q /= 10;
            }
            num /= 7;
        }
        char[] str = new char[chars.size()];
        for(int i = 0; i < chars.size(); i++){
            str[i] = chars.get(chars.size() - 1 - i);
        }
        return new String(str);
    }
}

// 2 ms 40.7 MB
class BaseSeven_Solution2 {
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        StringBuilder res = new StringBuilder("");
        int temp = Math.abs(num);
        while (temp != 0) {
            int remainder = temp % 7;
            temp = temp / 7;
            res.append(String.valueOf(remainder));
        }
        
        return num < 0 ? "-" + res.reverse().toString() : res.reverse().toString();
    }
}