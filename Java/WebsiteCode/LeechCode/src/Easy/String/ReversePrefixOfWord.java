package Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/reverse-prefix-of-word/">2000. Reverse Prefix of Word</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a <strong>0-indexed</strong> string <code>word</code> and a character <code>ch</code>, <strong>reverse</strong> the segment of <code>word</code> that starts at index <code>0</code> and ends at the index of the <strong>first occurrence</strong> of <code>ch</code> (<strong>inclusive</strong>). If the character <code>ch</code> does not exist in <code>word</code>, do nothing.</p>

<ul>
	<li>For example, if <code>word = "abcdefd"</code> and <code>ch = "d"</code>, then you should <strong>reverse</strong> the segment that starts at <code>0</code> and ends at <code>3</code> (<strong>inclusive</strong>). The resulting string will be <code>"<u>dcba</u>efd"</code>.</li>
</ul>

<p>Return <em>the resulting string</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> word = "<u>abcd</u>efd", ch = "d"
<strong>Output:</strong> "<u>dcba</u>efd"
<strong>Explanation:</strong>&nbsp;The first occurrence of "d" is at index 3. 
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> word = "<u>xyxz</u>xe", ch = "z"
<strong>Output:</strong> "<u>zxyx</u>xe"
<strong>Explanation:</strong>&nbsp;The first and only occurrence of "z" is at index 3.
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> word = "abcd", ch = "z"
<strong>Output:</strong> "abcd"
<strong>Explanation:</strong>&nbsp;"z" does not exist in word.
You should not do any reverse operation, the resulting string is "abcd".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word.length &lt;= 250</code></li>
	<li><code>word</code> consists of lowercase English letters.</li>
	<li><code>ch</code> is a lowercase English letter.</li>
</ul>
</div>
 */
public class ReversePrefixOfWord {
    public static void main(String[] args) {
        String[][] tests = {
            {"a","b"},
            {"xyxzxe","z"}
        };

        for (String[] test : tests) {
            String word = test[0];
            char ch = test[1].charAt(0);
        
            System.out.println(new ReversePrefixOfWord_Solution().reversePrefix(word, ch));
        }
    }
}

// 1 ms 41.8 MB
class ReversePrefixOfWord_Solution {
    public String reversePrefix(String word, char ch) {
        char[] wordChars = word.toCharArray();

        int inx = -1;
        for (int i = 0; i < wordChars.length; i++) {
            if (wordChars[i] == ch) {
                inx = i;
                break;
            }
        }

        if (inx == -1) {return word;}

        StringBuffer wordReverse = new StringBuffer();
        for (int i = inx; i >= 0; i--) {
            wordReverse.append(wordChars[i]);
        }

        for (int i = inx+1; i < wordChars.length; i++) {
            wordReverse.append(wordChars[i]);
        }

        return wordReverse.toString();
    }
}