package Medium.String;

import java.util.HashSet;
import java.util.Set;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/longest-substring-without-repeating-characters/">3. Longest Substring Without Repeating Characters</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code>, find the length of the <strong>longest</strong> <span data-keyword="substring-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:rt:"><div><strong>substring</strong></div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(354px, 183px);"></div></div></div></span> without repeating characters.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "abcabcbb"
<strong>Output:</strong> 3
<strong>Explanation:</strong> The answer is "abc", with the length of 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "bbbbb"
<strong>Output:</strong> 1
<strong>Explanation:</strong> The answer is "b", with the length of 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "pwwkew"
<strong>Output:</strong> 3
<strong>Explanation:</strong> The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code> consists of English letters, digits, symbols and spaces.</li>
</ul>
</div>
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String[] tests = {
            "aabaab!bb",
            "pwwkew",
            "abcabcbb",
            "bbbbb",
            "tmmzuxt",
            ""
        };

        for (String s : tests) {
            System.out.println(new LongestSubstringWithoutRepeatingCharacters_Solution().lengthOfLongestSubstring(s));
        }
    }
}

// Just for Alphebet's case
class LongestSubstringWithoutRepeatingCharacters_Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {return 1;}

        int[] chars = new int[26];
        char[] charsS = s.toCharArray();

        int count = 0,
            j = 0,
            max = Integer.MIN_VALUE;
        for (int i = 0; i < charsS.length; i++) {
            if (chars[charsS[i]-'a']++ < 1) {count++;}
            else {
                while (chars[charsS[i]-'a'] > 1) {
                    chars[charsS[j++]-'a']--;
                    count--;
                }
                count++;
            }

            if (max < count) { max = count; }
        }

        return max;
    }
}

// 7 ms 44.5 MB
class LongestSubstringWithoutRepeatingCharacters_Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }
        
        return maxLength;
    }
}