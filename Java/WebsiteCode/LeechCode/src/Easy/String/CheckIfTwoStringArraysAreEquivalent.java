package Easy.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/check-if-two-string-arrays-are-equivalent/">1662.Check If Two String Arrays are Equivalent</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given two string arrays <code>word1</code> and <code>word2</code>, return<em> </em><code>true</code><em> if the two arrays <strong>represent</strong> the same string, and </em><code>false</code><em> otherwise.</em></p>

<p>A string is <strong>represented</strong> by an array if the array elements concatenated <strong>in order</strong> forms the string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> word1 = ["ab", "c"], word2 = ["a", "bc"]
<strong>Output:</strong> true
<strong>Explanation:</strong>
word1 represents string "ab" + "c" -&gt; "abc"
word2 represents string "a" + "bc" -&gt; "abc"
The strings are the same, so return true.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> word1 = ["a", "cb"], word2 = ["ab", "c"]
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word1.length, word2.length &lt;= 10<sup>3</sup></code></li>
	<li><code>1 &lt;= word1[i].length, word2[i].length &lt;= 10<sup>3</sup></code></li>
	<li><code>1 &lt;= sum(word1[i].length), sum(word2[i].length) &lt;= 10<sup>3</sup></code></li>
	<li><code>word1[i]</code> and <code>word2[i]</code> consist of lowercase letters.</li>
</ul>
</div></div>
 */
public class CheckIfTwoStringArraysAreEquivalent {
    public static void main(String[] args) {
        String[][][] tests = {
            {{"ab", "c"},{"a", "bc"}},
            {{"a", "cb"},{"ab", "c"}},
            {{"abc", "d", "defg"},{"abcddefg"}}
        };

        for (String[][] strings : tests) {
            String[] word1 = strings[0];
            String[] word2 = strings[1];

            System.out.println(new CheckIfTwoStringArraysAreEquivalent_Solution().arrayStringsAreEqual(word1, word2));
        }
    }
}

class CheckIfTwoStringArraysAreEquivalent_Solution {
    // 3 ms 40.5 MB
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int wordIdx1 = 0, wordIdx2 = 0, chIdx1 = 0, chIdx2 = 0;
        
        while(true){
            char ch1 = word1[wordIdx1].charAt(chIdx1);
            char ch2 = word2[wordIdx2].charAt(chIdx2);
            if (ch1 != ch2) return false;
            
            chIdx1++; 
            chIdx2++; 

            if (chIdx1 == word1[wordIdx1].length()) { wordIdx1++;  chIdx1 = 0;  }
            if (chIdx2 == word2[wordIdx2].length()) { wordIdx2++; chIdx2 = 0;}

            if (wordIdx1 == word1.length && wordIdx2 == word2.length) break; 
            if (wordIdx1 == word1.length || wordIdx2 == word2.length) return false;
        }
        return true; 
    }
}


class CheckIfTwoStringArraysAreEquivalent_Solution2 {
    // 1 ms 40.6 MB
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String w1 = "", w2 = ""; // Using StringBuffer 1 ms 40.7 MB

        for (String string : word1) {w1 += string;}

        for (String string : word2) {w2 += string;}

        if (w1.compareTo(w2) == 0) {return true;} else {return false;}
    }
}

class CheckIfTwoStringArraysAreEquivalent_Solution3 {
    // 1 ms 41.1 MB
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Using String.join to concatenate strings in word1 and word2
        String s1 = String.join("", word1);
        String s2 = String.join("", word2);
        
        return s1.equals(s2);
    }
}