package BetterCodeAnswer.Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-number-of-steps-to-make-two-strings-anagram/">1347.Minimum Number of Steps to Make Two Strings Anagram</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given two strings of the same length <code>s</code> and <code>t</code>. In one step you can choose <strong>any character</strong> of <code>t</code> and replace it with <strong>another character</strong>.</p>

<p>Return <em>the minimum number of steps</em> to make <code>t</code> an anagram of <code>s</code>.</p>

<p>An <strong>Anagram</strong> of a string is a string that contains the same characters with a different (or the same) ordering.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "bab", t = "aba"
<strong>Output:</strong> 1
<strong>Explanation:</strong> Replace the first 'a' in t with b, t = "bba" which is anagram of s.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "leetcode", t = "practice"
<strong>Output:</strong> 5
<strong>Explanation:</strong> Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "anagram", t = "mangaar"
<strong>Output:</strong> 0
<strong>Explanation:</strong> "anagram" and "mangaar" are anagrams. 
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s.length == t.length</code></li>
	<li><code>s</code> and <code>t</code> consist of lowercase English letters only.</li>
</ul>
</div>
 */
public class MinimumNumberOfStepsToMakeTwoStringsAnagram {
    public static void main(String[] args) {
        String[][] tests = {
            {"bab","aba"},
            {"leetcode","practice"},
            {"anagram","mangaar"},
            {"abb","bba"},
        };

        for (String[] strings : tests) {
            String s = strings[0], t = strings[1];

            System.out.println(new MinimumNumberOfStepsToMakeTwoStringsAnagram_Solution().minSteps(s, t));
        }
    }
}

// 6 ms 45.4 MB
class MinimumNumberOfStepsToMakeTwoStringsAnagram_Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        byte[] sb = s.getBytes(), tb = t.getBytes();
        for (byte b : sb) {
          count[b - 'a']++;
        }
        for (byte b : tb) {
          count[b - 'a']--;
        }
        int res = 0;
        for (int i : count) {
          res += Math.abs(i);
        }
        return res / 2;
    }
}
