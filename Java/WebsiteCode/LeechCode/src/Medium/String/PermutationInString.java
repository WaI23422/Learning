package Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/permutation-in-string/">567. Permutation in String</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given two strings <code>s1</code> and <code>s2</code>, return <code>true</code> if <code>s2</code> contains a <span data-keyword="permutation-string" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:r11:"><div>permutation</div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(64px, 204px);"></div></div></div></span> of <code>s1</code>, or <code>false</code> otherwise.</p>
 * 
 * <p>In other words, return <code>true</code> if one of <code>s1</code>'s permutations is the substring of <code>s2</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s1 = "ab", s2 = "eidbaooo"
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> s2 contains one permutation of s1 ("ba").
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s1 = "ab", s2 = "eidboaoo"
 * <strong>Output:</strong> false
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s1.length, s2.length &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>s1</code> and <code>s2</code> consist of lowercase English letters.</li>
 * </ul>
 * </div></div>
 */
public class PermutationInString {
    public static void main(String[] args) {
        String[][] tests = { 
            {
                "adc",
                "dcda"
            },
            {
                "ab",
                "eidbaooo"
            },
            {
                "ab",
                "eidboaoo"
            },
        };     

        for (String[] test : tests) {
            String s1 = test[0],
                   s2 = test[1];

            System.out.println(new PermutationInString_Solution().checkInclusion(s1, s2));
        }
    }
}

// 4ms 42.86MB
class PermutationInString_Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1_len = s1.length(),
            s2_len = s2.length();

        if (s1_len > s2_len) {return false;}

        int s1_alp[] = new int[26],
            start = 0,
            end = 0;

        char[] s1_chars = s1.toCharArray();
        for (char c : s1_chars) {
            s1_alp[c-'a']++;
        }
        
        int total = 0;
        while (end < s2_len) {
            char c = s2.charAt(end++);
            s1_alp[c-'a']--;
            total++;
            if (s1_alp[c-'a'] < 0) {
                while (s1_alp[c-'a'] < 0) {
                    s1_alp[s2.charAt(start++)-'a']++;
                    total--;
                }
            }
            if (total == s1_len) {return true;}
        }

        return false;
    }
}