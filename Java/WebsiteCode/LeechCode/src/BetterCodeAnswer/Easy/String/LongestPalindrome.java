package BetterCodeAnswer.Easy.String;

import java.util.HashSet;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/longest-palindrome/">409. Longest Palindrome</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code> which consists of lowercase or uppercase letters, return <em>the length of the <strong>longest palindrome</strong></em>&nbsp;that can be built with those letters.</p>

<p>Letters are <strong>case sensitive</strong>, for example,&nbsp;<code>"Aa"</code> is not considered a palindrome here.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "abccccdd"
<strong>Output:</strong> 7
<strong>Explanation:</strong> One longest palindrome that can be built is "dccaccd", whose length is 7.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "a"
<strong>Output:</strong> 1
<strong>Explanation:</strong> The longest palindrome that can be built is "a", whose length is 1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 2000</code></li>
	<li><code>s</code> consists of lowercase <strong>and/or</strong> uppercase English&nbsp;letters only.</li>
</ul>
</div>
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String[] tests = {
            "abccccdd"
        };
    
        for (String s : tests) {
            System.out.println(new LongestPalindrome_Solution().longestPalindrome(s));
        }
    }
}

// 6 ms 42.4 MB
// Time Complexity : O(n)
class LongestPalindrome_Solution {
    public int longestPalindrome(String s) {
        int length = 0;
        // Create a HashSet...
        HashSet<Character> hset = new HashSet<Character>();
        // Traverse every element through the loop...
        for (int idx = 0; idx < s.length(); idx++) {
            // Convert string to character array...
            char character = s.charAt(idx);
            // If hset contains character already, emove that character & adding 2 to length...
            // It means we get pair of character which is used in palindrome...
            if (hset.contains(character)) {
                length += 2;
                hset.remove(character);
            }
            // Otherwise, add the character to the hashset...
            else {
                hset.add(character);
            }
        }
        // If the size of the set is greater than zero, move length forward...
        if (hset.size() > 0) {
            length ++;
        }
        return length;      // Return the length of the longest palindrome...
    }
}

// 1 ms 41.7 MB
class LongestPalindrome_Solution2 {
    public int longestPalindrome(String s) {
        int[] f = new int[128];
        for (char c : s.toCharArray()) {
            f[c]++;
        }
        
        int l = 0;
        boolean o = false;
        
        for (int i : f) {
            if (i % 2 == 0) {
                l += i;
            } else {
                l += i - 1;
                o = true;
            }
        }
        
        if (o) {
            l++;
        }
        
        return l;
    }
}