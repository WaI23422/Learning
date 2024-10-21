package Easy.String;

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

// 11 ms 44.6 MB
class LicenseKeyFormatting_Solution {
    public String licenseKeyFormatting(String s, int k) {
        String[] sPart = s.split("-");
        StringBuffer licenseKey = new StringBuffer();

        int totalLen = 0;
        for (String part : sPart) {
            totalLen+=part.length();
        }

        int count=1;
        for (int i =  sPart.length-1; i >= 0; i--) {
            char[] partChars = sPart[i].toCharArray();

            for (int j = partChars.length-1; j >= 0; j--) {
                licenseKey.append(Character.toUpperCase(partChars[j]));
                if (count%k == 0 && count != totalLen) {
                    licenseKey.append("-");
                }
                count++;
            }
        }

        return licenseKey.reverse().toString();
    }
}

// 10 ms 44.6 MB
class LicenseKeyFormatting_Solution2 {
    public String licenseKeyFormatting(String s, int k) {
        var sb = new StringBuilder();

        int curr = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            var c = s.charAt(i);
            if (c == '-') continue;
            if (c >= 'a' && c <= 'z') c = (char)(c - 'a' + 'A');

            sb.append(c);
            curr++;
            if (curr == k && i != 0) {
                sb.append('-');
                curr = 0;
            }
        }

        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.setLength(sb.length() - 1);
        }

        return sb.reverse().toString();
    }
}