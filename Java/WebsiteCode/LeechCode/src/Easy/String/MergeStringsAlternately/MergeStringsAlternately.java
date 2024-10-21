package Easy.String.MergeStringsAlternately;
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
public class MergeStringsAlternately {
    public static void main(String[] args) {
        String word1 = "ab";
        String word2 = "pqrs";
        MergeStringsAlternately_Solution solution = new MergeStringsAlternately_Solution();

        System.out.println(solution.mergeAlternately(word1, word2));
    }
}

class MergeStringsAlternately_Solution {
    // 7 ms
    // 42 MB
    public String mergeAlternately(String word1, String word2) {
        String res = "";
        int lenShort;
        int lenLong;
        String LongerString;
        if (word1.length() < word2.length()) {
            lenShort = word1.length();
            lenLong = word2.length();
            LongerString = word2;
        } else {
            lenShort = word2.length();
            lenLong = word1.length();
            LongerString = word1;
        }

        for (int i = 0; i < lenShort; i++) {
            res += Character.toString(word1.charAt(i)) + Character.toString(word2.charAt(i));    
        }
        
        if (word1.length() != word2.length()) {
            for (int i = lenShort ; i < lenLong; i++) {
                res += Character.toString(LongerString.charAt(i));
            }
        }

        return res;
    }
}
