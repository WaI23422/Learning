package BetterCodeAnswer.Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/license-key-formatting/">482. License Key Formatting</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a license key represented as a string <code>s</code> that consists of only alphanumeric characters and dashes. The string is separated into <code>n + 1</code> groups by <code>n</code> dashes. You are also given an integer <code>k</code>.</p>
 * 
 * <p>We want to reformat the string <code>s</code> such that each group contains exactly <code>k</code> characters, except for the first group, which could be shorter than <code>k</code> but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.</p>
 * 
 * <p>Return <em>the reformatted license key</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "5F3Z-2e-9-w", k = 4
 * <strong>Output:</strong> "5F3Z-2E9W"
 * <strong>Explanation:</strong> The string s has been split into two parts, each part has 4 characters.
 * Note that the two extra dashes are not needed and can be removed.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "2-5g-3-J", k = 2
 * <strong>Output:</strong> "2-5G-3J"
 * <strong>Explanation:</strong> The string s has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>s</code> consists of English letters, digits, and dashes <code>'-'</code>.</li>
 * 	<li><code>1 &lt;= k &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * </div>
 */
public class LicenseKeyFormatting {
    public static void main(String[] args) {
        Object[][] tests = {
            {"5F3Z-2e-9-w",4},
            {"2-5g-3-J", 2}
        };

        for (Object[] test : tests) {
            String s = (String) test[0];
            int k = (int) test[1];

            System.out.println(new LicenseKeyFormatting_Solution().licenseKeyFormatting(s, k));
        }
    }
}

// 3 ms 44.6 MB
class LicenseKeyFormatting_Solution {
    public String licenseKeyFormatting(String s, int k) {
        char[] chars = s.toCharArray();
        int clearLength = 0;
        for (char aChar : chars) if (aChar != '-') clearLength++;
        int j = clearLength % k == 0 ? k : clearLength % k;
        char[] result = new char[clearLength + (clearLength - 1) / k];
        for (int i = 0, h = 0; i < chars.length; i++, j--) {
            if (chars[i] != '-') {
                if (j == 0) {
                    j = k;
                    result[h] = '-';
                    h++;
                }
                var c = chars[i];
                result[h] = c < 97 ? c : (char) (c - 32);
                h++;
            } else {
                j++;
            }
        }
        return new String(result);
    }
}

// 7 ms 44.6 MB
class LicenseKeyFormatting_Solution2 {
    public String licenseKeyFormatting(String s, int k) {
        int dashCount = 0;
        for (int i = 0; i < s.length(); ++i){
            if (s.charAt(i) == '-'){
                dashCount++;
            }
        }

        int numAlphanumeric = s.length() - dashCount;
        int numCharsBeforeDash = numAlphanumeric % k;
        if (numCharsBeforeDash == 0 && numAlphanumeric > 0){
            numCharsBeforeDash = k;
        }

        StringBuilder result = new StringBuilder();
        int sIndex = 0;

        for (int i = 0; i < numCharsBeforeDash; ++i){
            while (s.charAt(sIndex) == '-'){
                sIndex++;
            }
            result.append(toUppercase(s.charAt(sIndex)));
            sIndex++;
        }
        
        for (int i = numCharsBeforeDash; i < numAlphanumeric; i = i + k){
            result.append('-');
            for (int count = 0; count < k; ++count){
                while (s.charAt(sIndex) == '-'){
                    sIndex++;
                }
                result.append(toUppercase(s.charAt(sIndex)));
                sIndex++;
            }
        }
        return result.toString();
    }

    private char toUppercase(char ch){
        char uppercaseChar = ch;
        if (ch >= 'a' && ch <= 'z'){
            uppercaseChar = (char)(ch - 'a' + 'A');
        }
        return uppercaseChar;
    }
}