package BetterCodeAnswer.Hard.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/shortest-palindrome/">214. Shortest Palindrome</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code>. You can convert <code>s</code> to a <span data-keyword="palindrome-string" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:r12:"><div>palindrome</div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(365px, 183px);"></div></div></div></span> by adding characters in front of it.</p>
 * 
 * <p>Return <em>the shortest palindrome you can find by performing this transformation</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> s = "aacecaaa"
 * <strong>Output:</strong> "aaacecaaa"
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> s = "abcd"
 * <strong>Output:</strong> "dcbabcd"
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
 * 	<li><code>s</code> consists of lowercase English letters only.</li>
 * </ul>
 * </div>
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        String[] tests = {
            "aacecaa",
            "aacecaaa",
        };

        for (String s : tests) {
            System.out.println(new ShortestPalindrome_Solution().shortestPalindrome(s));
        }
    }
}

// 2ms 44.47MB
class ShortestPalindrome_Solution {

    public String shortestPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return s;
        }

        // Find the longest palindromic prefix
        int left = 0;
        for (int right = length - 1; right >= 0; right--) {
            if (s.charAt(right) == s.charAt(left)) {
                left++;
            }
        }

        // If the whole string is a palindrome, return the original string
        if (left == length) {
            return s;
        }

        // Extract the suffix that is not part of the palindromic prefix
        String nonPalindromeSuffix = s.substring(left);
        StringBuilder reverseSuffix = new StringBuilder(
            nonPalindromeSuffix
        ).reverse();

        // Form the shortest palindrome by prepending the reversed suffix
        return reverseSuffix
            .append(shortestPalindrome(s.substring(0, left)))
            .append(nonPalindromeSuffix)
            .toString();
    }
}

// 225ms 45.15MB
class ShortestPalindrome_Solution2 {

    public String shortestPalindrome(String s) {
        int length = s.length();
        String reversedString = new StringBuilder(s).reverse().toString();

        // Iterate through the string to find the longest palindromic prefix
        for (int i = 0; i < length; i++) {
            if (
                s.substring(0, length - i).equals(reversedString.substring(i))
            ) {
                return new StringBuilder(reversedString.substring(0, i))
                    .append(s)
                    .toString();
            }
        }
        return "";
    }
}

// 6ms 44.54MB
class ShortestPalindrome_Solution3 {

    public String shortestPalindrome(String s) {
        long hashBase = 29;
        long modValue = (long) 1e9 + 7;
        long forwardHash = 0, reverseHash = 0, powerValue = 1;
        int palindromeEndIndex = -1;

        // Calculate rolling hashes and find the longest palindromic prefix
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // Update forward hash
            forwardHash = (forwardHash * hashBase + (currentChar - 'a' + 1)) %
            modValue;

            // Update reverse hash
            reverseHash = (reverseHash + (currentChar - 'a' + 1) * powerValue) %
            modValue;
            powerValue = (powerValue * hashBase) % modValue;

            // If forward and reverse hashes match, update palindrome end index
            if (forwardHash == reverseHash) {
                palindromeEndIndex = i;
            }
        }

        // Find the remaining suffix after the longest palindromic prefix
        String suffix = s.substring(palindromeEndIndex + 1);
        // Reverse the remaining suffix
        StringBuilder reversedSuffix = new StringBuilder(suffix).reverse();

        // Prepend the reversed suffix to the original string and return the result
        return reversedSuffix.append(s).toString();
    }
}

// 8ms 44.78MB - KMP algorithm
class ShortestPalindrome_Solution4 {

    public String shortestPalindrome(String s) {
        String reversedString = new StringBuilder(s).reverse().toString();
        String combinedString = s + "#" + reversedString;
        int[] prefixTable = buildPrefixTable(combinedString);

        int palindromeLength = prefixTable[combinedString.length() - 1];
        StringBuilder suffix = new StringBuilder(
            s.substring(palindromeLength)
        ).reverse();
        return suffix.append(s).toString();
    }

    private int[] buildPrefixTable(String s) {
        int[] prefixTable = new int[s.length()];
        int length = 0;
        for (int i = 1; i < s.length(); i++) {
            while (length > 0 && s.charAt(i) != s.charAt(length)) {
                length = prefixTable[length - 1];
            }
            if (s.charAt(i) == s.charAt(length)) {
                length++;
            }
            prefixTable[i] = length;
        }
        return prefixTable;
    }
}
