package Medium.String;

/**
 *  <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-length-of-string-after-deleting-similar-ends/">1750.Minimum Length of String After Deleting Similar Ends</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code> consisting only of characters <code>'a'</code>, <code>'b'</code>, and <code>'c'</code>. You are asked to apply the following algorithm on the string any number of times:</p>

<ol>
	<li>Pick a <strong>non-empty</strong> prefix from the string <code>s</code> where all the characters in the prefix are equal.</li>
	<li>Pick a <strong>non-empty</strong> suffix from the string <code>s</code> where all the characters in this suffix are equal.</li>
	<li>The prefix and the suffix should not intersect at any index.</li>
	<li>The characters from the prefix and suffix must be the same.</li>
	<li>Delete both the prefix and the suffix.</li>
</ol>

<p>Return <em>the <strong>minimum length</strong> of </em><code>s</code> <em>after performing the above operation any number of times (possibly zero times)</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "ca"
<strong>Output:</strong> 2
<strong>Explanation: </strong>You can't remove any characters, so the string stays as is.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "cabaabac"
<strong>Output:</strong> 0
<strong>Explanation:</strong> An optimal sequence of operations is:
- Take prefix = "c" and suffix = "c" and remove them, s = "abaaba".
- Take prefix = "a" and suffix = "a" and remove them, s = "baab".
- Take prefix = "b" and suffix = "b" and remove them, s = "aa".
- Take prefix = "a" and suffix = "a" and remove them, s = "".</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "aabccabba"
<strong>Output:</strong> 3
<strong>Explanation:</strong> An optimal sequence of operations is:
- Take prefix = "aa" and suffix = "a" and remove them, s = "bccabb".
- Take prefix = "b" and suffix = "bb" and remove them, s = "cca".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> only consists of characters <code>'a'</code>, <code>'b'</code>, and <code>'c'</code>.</li>
</ul>
</div>
 */
public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    public static void main(String[] args) {
        String[] tests = {
            "ca",
            "cabaabac",
            "aabccabba",
            "a",
            "abbbbbbbbbbbbbbbbbbba"
        };

        for (String s : tests) {
            System.out.println(new MinimumLengthOfStringAfterDeletingSimilarEnds_Solution().minimumLength(s));
        }
    }
}

// 4 ms 45 MB
class MinimumLengthOfStringAfterDeletingSimilarEnds_Solution {
    public int minimumLength(String s) {
        int left = 0 , right = s.length() - 1, remove = 0;
        char prevChar = 0;
        char[] sChars = s.toCharArray();

        while (left < right) {
            if (sChars[left] == sChars[right]) {
                prevChar = sChars[left];
                remove += 2;
                left++; right--;
            } else if (sChars[left] == prevChar) {
                remove++;
                left++;
            } else if (sChars[right] == prevChar) {
                remove++;
                right--;
            } else {
                break;
            }
        }
        
        if (left == right && sChars[left] == prevChar) {remove++;}

        return s.length()-remove;
    }
}