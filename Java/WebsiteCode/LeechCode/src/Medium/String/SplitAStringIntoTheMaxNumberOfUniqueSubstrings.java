package Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/split-a-string-into-the-max-number-of-unique-substrings/">1593. Split a String Into the Max Number of Unique Substrings</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given a string&nbsp;<code>s</code><var>,</var>&nbsp;return <em>the maximum&nbsp;number of unique substrings that the given string can be split into</em>.</p>
 * 
 * <p>You can split string&nbsp;<code>s</code> into any list of&nbsp;<strong>non-empty substrings</strong>, where the concatenation of the substrings forms the original string.&nbsp;However, you must split the substrings such that all of them are <strong>unique</strong>.</p>
 * 
 * <p>A <strong>substring</strong> is a contiguous sequence of characters within a string.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "ababccc"
 * <strong>Output:</strong> 5
 * <strong>Explanation</strong>: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc']. Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "aba"
 * <strong>Output:</strong> 2
 * <strong>Explanation</strong>: One way to split maximally is ['a', 'ba'].
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "aa"
 * <strong>Output:</strong> 1
 * <strong>Explanation</strong>: It is impossible to split the string any further.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>
 * 	<p><code>1 &lt;= s.length&nbsp;&lt;= 16</code></p>
 * 	</li>
 * 	<li>
 * 	<p><code>s</code> contains&nbsp;only lower case English letters.</p>
 * 	</li>
 * </ul>
 * </div></div>
 */
public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {
    public static void main(String[] args) {
        String[] tests = {
            "ababccc"
        };

        for (String s : tests) {
            System.out.println(new SplitAStringIntoTheMaxNumberOfUniqueSubstrings_Solution().maxUniqueSplit(s));
        }
    }
}

// @see BetterCodeAnswer.Medium.String
class SplitAStringIntoTheMaxNumberOfUniqueSubstrings_Solution {
    public int maxUniqueSplit(String s) {
        return 0;
    }
}