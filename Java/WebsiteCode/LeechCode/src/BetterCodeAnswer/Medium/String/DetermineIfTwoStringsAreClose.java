package BetterCodeAnswer.Medium.String;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/determine-if-two-strings-are-close/">1657.Determine if Two Strings Are Close</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Two strings are considered <strong>close</strong> if you can attain one from the other using the following operations:</p>

<ul>
	<li>Operation 1: Swap any two <strong>existing</strong> characters.

	<ul>
		<li>For example, <code>a<u>b</u>cd<u>e</u> -&gt; a<u>e</u>cd<u>b</u></code></li>
	</ul>
	</li>
	<li>Operation 2: Transform <strong>every</strong> occurrence of one <strong>existing</strong> character into another <strong>existing</strong> character, and do the same with the other character.
	<ul>
		<li>For example, <code><u>aa</u>c<u>abb</u> -&gt; <u>bb</u>c<u>baa</u></code> (all <code>a</code>'s turn into <code>b</code>'s, and all <code>b</code>'s turn into <code>a</code>'s)</li>
	</ul>
	</li>
</ul>

<p>You can use the operations on either string as many times as necessary.</p>

<p>Given two strings, <code>word1</code> and <code>word2</code>, return <code>true</code><em> if </em><code>word1</code><em> and </em><code>word2</code><em> are <strong>close</strong>, and </em><code>false</code><em> otherwise.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> word1 = "abc", word2 = "bca"
<strong>Output:</strong> true
<strong>Explanation:</strong> You can attain word2 from word1 in 2 operations.
Apply Operation 1: "a<u>bc</u>" -&gt; "a<u>cb</u>"
Apply Operation 1: "<u>a</u>c<u>b</u>" -&gt; "<u>b</u>c<u>a</u>"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> word1 = "a", word2 = "aa"
<strong>Output:</strong> false
<strong>Explanation: </strong>It is impossible to attain word2 from word1, or vice versa, in any number of operations.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> word1 = "cabbba", word2 = "abbccc"
<strong>Output:</strong> true
<strong>Explanation:</strong> You can attain word2 from word1 in 3 operations.
Apply Operation 1: "ca<u>b</u>bb<u>a</u>" -&gt; "ca<u>a</u>bb<u>b</u>"
<code>Apply Operation 2: "</code><u>c</u>aa<u>bbb</u>" -&gt; "<u>b</u>aa<u>ccc</u>"
Apply Operation 2: "<u>baa</u>ccc" -&gt; "<u>abb</u>ccc"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word1.length, word2.length &lt;= 10<sup>5</sup></code></li>
	<li><code>word1</code> and <code>word2</code> contain only lowercase English letters.</li>
</ul>
</div>
 */
public class DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        String[][] tests = {
            {"abc","bca"},
            {"a","aa"},
            {"cabbba","abbccc"},
            {"uau","ssx"},
        };

        for (String[] strings : tests) {
            String word1  = strings[0], word2 = strings[1];

            System.out.println(new DetermineIfTwoStringsAreClose_Solution().closeStrings(word1, word2));
        }
    }
}

// 9 ms 45.8 MB
class DetermineIfTwoStringsAreClose_Solution2 {
    public boolean closeStrings(String word1, String word2) {
         int len1, len2;
         
         if ((len1 = word1.length()) != (len2 = word2.length()))
             return false;
         byte[] by1 = word1.getBytes(), by2 = word2.getBytes();
         int[] ch1 = new int[26], ch2 = new int[26];
 
         shams(by1, ch1, len1);
         shams(by2, ch2, len2);
 
         for (int i = 0; i < 26; i++) 
             if (ch1[i] > 0 ^ ch2[i] > 0)
                 return false;
         Arrays.sort(ch1);
         Arrays.sort(ch2);
         return Arrays.equals(ch1, ch2);
    }

    void shams(byte[] b, int[] i, int l) {
         while (l-- > 0)
             i[b[l] - 97]++;
    }
}

// 5 ms 45.8 MB
class DetermineIfTwoStringsAreClose_Solution {
    @SuppressWarnings("all")
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        if (n != word2.length())  return false;    
        if (word1.equals(word2))  return true;   

        int[] count1 = new int['z' + 1];     
        int[] count2 = new int['z' + 1];    
        byte[] bytes = new byte[n];
        word1.getBytes(0, n, bytes, 0);     // Faster than String.toCharArray().
        for (byte b : bytes)  count1[b]++;
        
        word2.getBytes(0, n, bytes, 0);
        for (byte b : bytes)  count2[b]++;
        
        int maxFreq = 0;
        for (int i = 'a'; i <= 'z'; i++)
            maxFreq = Math.max(maxFreq, Math.max(count1[i], count2[i]));

        byte[] freq = new byte[maxFreq + 1];    
        int count = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            int c1 = count1[i];
            int c2 = count2[i];
            if ((c1 == 0) ^ (c2 == 0))  return false;   
            if (c1 != 0) {
                int f1 = freq[c1]++;
                int f2 = freq[c2]--;
                if (f1 == 0)  count++;  else  if (f1 == -1)  count--;
                if (f2 == 0)  count++;  else  if (f2 ==  1)  count--;
            }
        }
        return count == 0;  
    }
}