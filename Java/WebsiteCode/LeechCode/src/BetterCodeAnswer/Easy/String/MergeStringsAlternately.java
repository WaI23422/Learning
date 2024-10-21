package BetterCodeAnswer.Easy.String;
/**
 * <div class="xFUwe" data-track-load="description_content"><p>You are given two strings <code>word1</code> and <code>word2</code>. Merge the strings by adding letters in alternating order, starting with <code>word1</code>. If a string is longer than the other, append the additional letters onto the end of the merged string.</p>

<p>Return <em>the merged string.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> word1 = "abc", word2 = "pqr"
<strong>Output:</strong> "apbqcr"
<strong>Explanation:</strong>&nbsp;The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> word1 = "ab", word2 = "pqrs"
<strong>Output:</strong> "apbqrs"
<strong>Explanation:</strong>&nbsp;Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> word1 = "abcd", word2 = "pq"
<strong>Output:</strong> "apbqcd"
<strong>Explanation:</strong>&nbsp;Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word1.length, word2.length &lt;= 100</code></li>
	<li><code>word1</code> and <code>word2</code> consist of lowercase English letters.</li>
</ul></div>
 */
class MergeStringsAlternately_Solution {
    // 0 ms
    // 40.6 MB
    public String mergeAlternately(String word1, String word2) {
        int len = word1.length() + word2.length();
        int i, j;
        char[] arr = new char[len];

        if (word1.length() < word2.length()) {
            j = 0;
            for (i = 0; i < word1.length(); i++) {
                arr[j] = word1.charAt(i);
                arr[j+1] = word2.charAt(i);
                j+=2;
            }

            while (j < len) {
                arr[j++] = word2.charAt(i++);
            }
        }
        else {
            j = 0;

            for (i = 0; i < word2.length(); i++) {
                arr[j] = word1.charAt(i);
                arr[j+1] = word2.charAt(i);
                j+=2;
            }

            while (j < len) {
                arr[j++] = word1.charAt(i++);
            }
        }
        return new String(arr);
    }
}

class MergeStringsAlternately_Solution2 {
    // 1 ms
    // 40.8 MB
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
            i++;
        }
        return result.toString();
    }
}