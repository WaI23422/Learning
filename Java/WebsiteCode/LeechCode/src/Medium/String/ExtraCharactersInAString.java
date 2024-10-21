package Medium.String;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/extra-characters-in-a-string/">2707. Extra Characters in a String</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> string <code>s</code> and a dictionary of words <code>dictionary</code>. You have to break <code>s</code> into one or more <strong>non-overlapping</strong> substrings such that each substring is present in <code>dictionary</code>. There may be some <strong>extra characters</strong> in <code>s</code> which are not present in any of the substrings.</p>
 * 
 * <p>Return <em>the <strong>minimum</strong> number of extra characters left over if you break up </em><code>s</code><em> optimally.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "leetscode", dictionary = ["leet","code","leetcode"]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1.
 * 
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "sayhelloworld", dictionary = ["hello","world"]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters. Hence, we return 3.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 50</code></li>
 * 	<li><code>1 &lt;= dictionary.length &lt;= 50</code></li>
 * 	<li><code>1 &lt;= dictionary[i].length &lt;= 50</code></li>
 * 	<li><code>dictionary[i]</code>&nbsp;and <code>s</code> consists of only lowercase English letters</li>
 * 	<li><code>dictionary</code> contains distinct words</li>
 * </ul>
 * </div>
 */
public class ExtraCharactersInAString {
    public static void main(String[] args) {
        String[][][] tests = {
            {
                {"hlello"},
                {"hello"}
            },
            {
                {"leetscode"},
                {"leet","code","leetcode"}
            }
        };

        for (String[][] test : tests) {
            String s = test[0][0],
                   dictionary[] = test[1];

            System.out.println(new ExtraCharactersInAString_Solution().minExtraChar(s, dictionary));
        }
    }
}

// Brute-Force: Time Limit Exceeded
class ExtraCharactersInAString_Solution1 {
    int left = Integer.MAX_VALUE;
    public int minExtraChar(String s, String[] dictionary) {
        List<String> dic_list = new ArrayList<>();

        for (String str : dictionary) {
            dic_list.add(str);
        }

        if (dic_list.contains(s)) {
            return 0;
        }
        
        for (int i = 1; i < s.length(); i++) {
            String first_half = s.substring(0, i),
                   second_half = s.substring(i);

            if (dic_list.contains(first_half)) {
                left = Math.min(left, checkString(second_half,dic_list));
            } else {
                left = Math.min(left, first_half.length() + checkString(second_half, dic_list));
            }
        }

        return left;
    }

    private int checkString(String s, List<String> dic_list) {
        if (dic_list.contains(s)) {return 0;};

        int temp_left = s.length();
        for (int i = 1; i < s.length(); i++) {
            String first_half = s.substring(0, i),
                   second_half = s.substring(i);

            if (dic_list.contains(first_half)) {
                temp_left = Math.min(temp_left, checkString(second_half,dic_list));
            } else {
                temp_left = Math.min(temp_left, first_half.length() + checkString(second_half, dic_list));
            }
        }

        return temp_left;
    }
}

// Time Limit Exceeded
class ExtraCharactersInAString_Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int left = Integer.MAX_VALUE;

        for (String str : dictionary) {
            if (s.contains(str)) {
                left = Math.min(left, checkString(s.split(str), dictionary));
            }
        }
        
        return Math.min(left, s.length());
    }

    private int checkString(String[] s_str, String[] dictionary) {
        int temp_left = 0;  

        for (String str : s_str) {
            if (str.length() == 0) {continue;}
            temp_left += minExtraChar(str, dictionary);
        }

        return temp_left;
    }
}
