package Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/string-compression-iii/">3163. String Compression III</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given a string <code>word</code>, compress it using the following algorithm:</p>
 * 
 * <ul>
 * 	<li>Begin with an empty string <code>comp</code>. While <code>word</code> is <strong>not</strong> empty, use the following operation:
 * 
 * 	<ul>
 * 		<li>Remove a maximum length prefix of <code>word</code> made of a <em>single character</em> <code>c</code> repeating <strong>at most</strong> 9 times.</li>
 * 		<li>Append the length of the prefix followed by <code>c</code> to <code>comp</code>.</li>
 * 	</ul>
 * 	</li>
 * </ul>
 * 
 * <p>Return the string <code>comp</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">word = "abcde"</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">"1a1b1c1d1e"</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p>Initially, <code>comp = ""</code>. Apply the operation 5 times, choosing <code>"a"</code>, <code>"b"</code>, <code>"c"</code>, <code>"d"</code>, and <code>"e"</code> as the prefix in each operation.</p>
 * 
 * <p>For each prefix, append <code>"1"</code> followed by the character to <code>comp</code>.</p>
 * </div>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">word = "aaaaaaaaaaaaaabb"</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">"9a5a2b"</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p>Initially, <code>comp = ""</code>. Apply the operation 3 times, choosing <code>"aaaaaaaaa"</code>, <code>"aaaaa"</code>, and <code>"bb"</code> as the prefix in each operation.</p>
 * 
 * <ul>
 * 	<li>For prefix <code>"aaaaaaaaa"</code>, append <code>"9"</code> followed by <code>"a"</code> to <code>comp</code>.</li>
 * 	<li>For prefix <code>"aaaaa"</code>, append <code>"5"</code> followed by <code>"a"</code> to <code>comp</code>.</li>
 * 	<li>For prefix <code>"bb"</code>, append <code>"2"</code> followed by <code>"b"</code> to <code>comp</code>.</li>
 * </ul>
 * </div>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= word.length &lt;= 2 * 10<sup>5</sup></code></li>
 * 	<li><code>word</code> consists only of lowercase English letters.</li>
 * </ul>
 * </div></div>
 */
public class StringCompressionIII {
    public static void main(String[] args) {
        String[] tests = {
            "abcde",
            "aaaaaaaaaaaaaabb",
            "aaaaaaaaa",
        };

        for (String word : tests) {
            System.out.println(new StringCompressionIII_Solution().compressedString(word));
        }
    }
}

// 19ms 45.60MB
class StringCompressionIII_Solution {
    public String compressedString(String word) {
        int count = 1,
            len = word.length();
        char pre_char = word.charAt(0);
        StringBuffer ans = new StringBuffer();

        for (int i = 1; i < len; i++) {
            if (pre_char == word.charAt(i)) {
                count++;
                if (count == 9) {
                    ans.append(count).append(pre_char);
                    count = 0;
                }
            } else {
                if (count != 0) {
                    ans.append(count).append(pre_char);
                }
                count = 1;
                pre_char = word.charAt(i);
            }
        }

        if (count != 0) {
            ans.append(count).append(pre_char);
        }

        return ans.toString();
    }
}