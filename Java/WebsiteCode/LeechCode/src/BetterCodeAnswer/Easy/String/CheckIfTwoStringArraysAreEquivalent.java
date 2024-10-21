package BetterCodeAnswer.Easy.String;

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
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for(String word : word1){
            str1.append(word);
        }
        for(String word : word2){
            str2.append(word);
        }
        
        String s1 = str1.toString();
        String s2 = str2.toString();

        if(s1.equals(s2)){
            return true;
        }
        else{
            return false;
        }
    }
}
