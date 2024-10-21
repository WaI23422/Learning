package BetterCodeAnswer.Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/number-of-segments-in-a-string/">434. Number of Segments in a String</a>
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code>, return <em>the number of segments in the string</em>.</p>
 * 
 * <p>A <strong>segment</strong> is defined to be a contiguous sequence of <strong>non-space characters</strong>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "Hello, my name is John"
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> The five segments are ["Hello,", "my", "name", "is", "John"]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "Hello"
 * <strong>Output:</strong> 1
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= s.length &lt;= 300</code></li>
 * 	<li><code>s</code> consists of lowercase and uppercase English letters, digits, or one of the following characters <code>"!@#$%^&amp;*()_+-=',.:"</code>.</li>
 * 	<li>The only space character in <code>s</code> is <code>' '</code>.</li>
 * </ul>
 * </div>
 */
public class NumberOfSegmentsInAString {
    public static void main(String[] args) {
        String[] tests = {
            "    foo    bar    ",
            ", , , ,        a, eaefa",
            "Hello, my name is John",
            "",
        };

        for (String s : tests) {
            System.out.println(new NumberOfSegmentsInAString_Solution().countSegments(s));
        }
    }
}

// 0ms 41.42mb
class NumberOfSegmentsInAString_Solution {
    public int countSegments(String s) {
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
}