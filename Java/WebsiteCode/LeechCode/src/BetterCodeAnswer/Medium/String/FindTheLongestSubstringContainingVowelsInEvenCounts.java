package BetterCodeAnswer.Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-the-longest-substring-containing-vowels-in-even-counts/">1371. Find the Longest Substring Containing Vowels in Even Counts</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the string <code>s</code>, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "eleetminicoworoep"
 * <strong>Output:</strong> 13
 * <strong>Explanation: </strong>The longest substring is "leetminicowor" which contains two each of the vowels: <strong>e</strong>, <strong>i</strong> and <strong>o</strong> and zero of the vowels: <strong>a</strong> and <strong>u</strong>.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "leetcodeisgreat"
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> The longest substring is "leetc" which contains two e's.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "bcbcbc"
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> In this case, the given string "bcbcbc" is the longest because all vowels: <strong>a</strong>, <strong>e</strong>, <strong>i</strong>, <strong>o</strong> and <strong>u</strong> appear zero times.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 5 x 10^5</code></li>
 * 	<li><code>s</code>&nbsp;contains only lowercase English letters.</li>
 * </ul>
 * </div>
 */
public class FindTheLongestSubstringContainingVowelsInEvenCounts {
    public static void main(String[] args) {
        String[] tests = {
            "id",
            "leetcodeisgreat",
            "eleetminicoworoep"
        };

        for (String s : tests) {
            System.out.println(new FindTheLongestSubstringContainingVowelsInEvenCounts_Solution().findTheLongestSubstring(s));
        }
    }   
}

// 10ms 45.20MB
/**
 * <h3 id="approach-bitmasking" level="3" class="group/heading relative"><a href="#approach-bitmasking" class="!text-sd-muted-foreground absolute right-full top-1/2 -translate-y-1/2 cursor-pointer pr-0.5 text-xs opacity-0 group-hover/heading:opacity-100" aria-hidden="true" tabindex="-1"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3"><svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="link" class="svg-inline--fa fa-link absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512" spacing="square"><path fill="currentColor" d="M579.8 267.7c56.5-56.5 56.5-148 0-204.5c-50-50-128.8-56.5-186.3-15.4l-1.6 1.1c-14.4 10.3-17.7 30.3-7.4 44.6s30.3 17.7 44.6 7.4l1.6-1.1c32.1-22.9 76-19.3 103.8 8.6c31.5 31.5 31.5 82.5 0 114L422.3 334.8c-31.5 31.5-82.5 31.5-114 0c-27.9-27.9-31.5-71.8-8.6-103.8l1.1-1.6c10.3-14.4 6.9-34.4-7.4-44.6s-34.4-6.9-44.6 7.4l-1.1 1.6C206.5 251.2 213 330 263 380c56.5 56.5 148 56.5 204.5 0L579.8 267.7zM60.2 244.3c-56.5 56.5-56.5 148 0 204.5c50 50 128.8 56.5 186.3 15.4l1.6-1.1c14.4-10.3 17.7-30.3 7.4-44.6s-30.3-17.7-44.6-7.4l-1.6 1.1c-32.1 22.9-76 19.3-103.8-8.6C74 372 74 321 105.5 289.5L217.7 177.2c31.5-31.5 82.5-31.5 114 0c27.9 27.9 31.5 71.8 8.6 103.9l-1.1 1.6c-10.3 14.4-6.9 34.4 7.4 44.6s34.4 6.9 44.6-7.4l1.1-1.6C433.5 260.8 427 182 377 132c-56.5-56.5-148-56.5-204.5 0L60.2 244.3z"></path></svg></div></a>Approach: Bitmasking</h3>
 * <h4 id="intuition">Intuition</h4>
 * <p>Given a string <code>s</code>, we need to find the length of the longest substring in which any vowel present must appear an even number of times. A brute force approach would involve iterating through every substring and counting vowels, but this would result in a Time Limit Exceeded (TLE). Instead, we need to think of a more efficient solution, aiming for a linear or log-linear time complexity.</p>
 * <p>Observe that we don't need to know the exact count of the vowels to solve this problem; we only need to know the parity of each vowel (whether it appears an even or odd number of times). The parity of each vowel can be stored in a boolean or bit, where <code>0</code> means even and <code>1</code> means odd. We need five bits to track the parity of all five vowels (a, e, i, o, u), resulting in 2^5 = 32 possible states.</p>
 * <p>We can assign the first bit to <code>a</code>, the second to <code>e</code>, and so on. The state of the vowels can be represented as a binary string. For instance, <code>00000</code> means all vowels have even counts, while <code>10000</code> means only <code>a</code> has an odd count.<br>
 * By converting these binary states to integers, we can assign values to the vowels: <code>a = 1</code>, <code>e = 2</code>, <code>i = 4</code>, <code>o = 8</code>, and <code>u = 16</code>. If both <code>a</code> and <code>i</code> have odd counts, their total value would be <code>1 + 4 = 5</code>. A total value of <code>0</code> means all vowels have even counts.</p>
 * <p><img src="https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/Figures/1371/image2.drawio.png" alt="fig"></p>
 * <p>To find substrings with even vowels, we can use the XOR operator to update and track the parity of the vowels. If a vowel appears an even number of times, the result of XOR will be 0; if it appears an odd number of times, the result will be 1.</p>
 * <p>We compute a running XOR for each vowel as we traverse the string. To check for substrings with even vowels, we consider two cases:</p>
 * <ol>
 * <li>If the current XOR value is <code>00000</code> (i.e., all vowels have even counts), the substring from the start of the string to the current position contains even vowels.</li>
 * <li>If the current XOR value has occurred before, the substring between the first occurrence of that XOR value and the current position also contains even vowels.</li>
 * </ol>
 * <p><img src="https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/Figures/1371/slide1.drawio.png" alt="fig"></p>
 * <h4 id="algorithm">Algorithm</h4>
 * <ol>
 * <li>Initialize an integer variable <code>prefixXOR</code> and set it to 0.</li>
 * <li>Initialize a character array <code>characterMap[26]</code> where specific vowel characters <code>('a', 'e', 'i', 'o', 'u')</code> have unique mask values <code>(1, 2, 4, 8, 16)</code>.</li>
 * <li>Initialize an array <code>mp</code> of size 32, where all elements are set to -1. This will store the index of the first occurrence of each <code>prefixXOR</code> value.</li>
 * <li>Initialize an integer variable <code>longestSubstring</code> and set it to <code>0</code>.</li>
 * <li>Iterate through each character in the string <code>s</code>:
 * <ul>
 * <li>Update <code>prefixXOR</code> by XORing it with the mask value of the current character (from <code>characterMap</code>).</li>
 * <li>If the current <code>prefixXOR</code> value is not found in <code>mp</code> and <code>prefixXOR</code> is not 0:
 * <ul>
 * <li>Store the current index in <code>mp</code> at the position corresponding to <code>prefixXOR</code>.</li>
 * </ul>
 * </li>
 * <li>Update <code>longestSubstring</code> by comparing it with the difference between the current index and <code>mp[prefixXOR]</code>.</li>
 * </ul>
 * </li>
 * <li>Return <code>longestSubstring</code> as the final result.</li>
 * </ol>
 */
class FindTheLongestSubstringContainingVowelsInEvenCounts_Solution {

    public int findTheLongestSubstring(String s) {
        int prefixXOR = 0;
        int[] characterMap = new int[26];
        characterMap['a' - 'a'] = 1;
        characterMap['e' - 'a'] = 2;
        characterMap['i' - 'a'] = 4;
        characterMap['o' - 'a'] = 8;
        characterMap['u' - 'a'] = 16;
        int[] mp = new int[32];
        for (int i = 0; i < 32; i++) mp[i] = -1;
        int longestSubstring = 0;
        for (int i = 0; i < s.length(); i++) {
            prefixXOR ^= characterMap[s.charAt(i) - 'a'];
            if (mp[prefixXOR] == -1 && prefixXOR != 0) mp[prefixXOR] = i;
            longestSubstring = Math.max(longestSubstring, i - mp[prefixXOR]);
        }
        return longestSubstring;
    }
}