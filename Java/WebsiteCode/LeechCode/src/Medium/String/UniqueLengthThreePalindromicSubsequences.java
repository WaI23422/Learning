package Medium.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/unique-length-3-palindromic-subsequences/">1930.Unique Length-3 Palindromic Subsequences</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given a string <code>s</code>, return <em>the number of <strong>unique palindromes of length three</strong> that are a <strong>subsequence</strong> of </em><code>s</code>.</p>

<p>Note that even if there are multiple ways to obtain the same subsequence, it is still only counted <strong>once</strong>.</p>

<p>A <strong>palindrome</strong> is a string that reads the same forwards and backwards.</p>

<p>A <strong>subsequence</strong> of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.</p>

<ul>
	<li>For example, <code>"ace"</code> is a subsequence of <code>"<u>a</u>b<u>c</u>d<u>e</u>"</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "aabca"
<strong>Output:</strong> 3
<strong>Explanation:</strong> The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "<u>a</u>a<u>b</u>c<u>a</u>")
- "aaa" (subsequence of "<u>aa</u>bc<u>a</u>")
- "aca" (subsequence of "<u>a</u>ab<u>ca</u>")
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "adc"
<strong>Output:</strong> 0
<strong>Explanation:</strong> There are no palindromic subsequences of length 3 in "adc".
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "bbcbaba"
<strong>Output:</strong> 4
<strong>Explanation:</strong> The 4 palindromic subsequences of length 3 are:
- "bbb" (subsequence of "<u>bb</u>c<u>b</u>aba")
- "bcb" (subsequence of "<u>b</u>b<u>cb</u>aba")
- "bab" (subsequence of "<u>b</u>bcb<u>ab</u>a")
- "aba" (subsequence of "bbcb<u>aba</u>")
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists of only lowercase English letters.</li>
</ul>
</div></div>
 */
public class UniqueLengthThreePalindromicSubsequences {
    public static void main(String[] args) {
        String[] test = {
            "aabca",
            "bcdc",
            "bbcbaba",
            "bca",
            "ckafnafqo"
        };

        for (String string : test) {
            System.out.println(new UniqueLengthThreePalindromicSubsequences_Solution().countPalindromicSubsequence(string));
        }
    }
}

class UniqueLengthThreePalindromicSubsequences_Solution {
    // Time Limit Exceeded
    public int countPalindromicSubsequence(String s) {
        int left = 0, right = s.length()-1, total = 0;
        String appear = "";
        char[] sChars = s.toCharArray();

        while (left < s.length()-2) {
            if (left+1 == right) {
                left++; right = s.length() -1;
            }

            if (sChars[left] == sChars[right]) {
                if (!appear.contains(String.valueOf(sChars[left]))) {
                    appear += sChars[left];
                    String appearMid = "";
                    int mid = left+1;
                    while (mid < right) {
                        if (!appearMid.contains(String.valueOf(sChars[mid]))) {
                            appearMid += sChars[mid];
                            total++;
                        }
                        mid++;
                    }

                    right--;
                } else {
                    left++; right = s.length() -1;
                }
            } else {
                right--;
            }
        }

        return total;
    }
}