package Easy.String;

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
            "abccccdd",
            "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"
        };
    
        for (String s : tests) {
            System.out.println(new LongestPalindrome_Solution().longestPalindrome(s));
        }
    }
}

// 1 ms 41.3 MB
class LongestPalindrome_Solution {
    public int longestPalindrome(String s) {
        int letterNumbers[] = new int[58],
            odd = 0,
            longest = 0;

        for (char c : s.toCharArray()) {
            letterNumbers[c-'A']++;
        }

        for (int letterNum : letterNumbers) {
            if (letterNum % 2 == 0) {
                longest += letterNum;
            } else {
                longest += letterNum-1;
                odd = 1;
            }
        }

        return longest + odd;
    }
}

// 1 ms 41.9 MB
class LongestPalindrome_Solution1 {
    public int longestPalindrome(String s) {
        char[] charFrequency = new char[128];
        int oddCount = 0;

        for (char ch : s.toCharArray()) {
            charFrequency[ch]++;
            if (charFrequency[ch] % 2 == 1) {
                oddCount++;
            } else {
                oddCount--;
            }
        }

        if (oddCount > 1) {
            return s.length() - oddCount + 1;
        }
        return s.length();
    }
}