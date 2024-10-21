package BetterCodeAnswer.Medium.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/sort-vowels-in-a-string/">2785.Sort Vowels in a String</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given a <strong>0-indexed</strong> string <code>s</code>, <strong>permute</strong> <code>s</code> to get a new string <code>t</code> such that:</p>

<ul>
	<li>All consonants remain in their original places. More formally, if there is an index <code>i</code> with <code>0 &lt;= i &lt; s.length</code> such that <code>s[i]</code> is a consonant, then <code>t[i] = s[i]</code>.</li>
	<li>The vowels must be sorted in the <strong>nondecreasing</strong> order of their <strong>ASCII</strong> values. More formally, for pairs of indices <code>i</code>, <code>j</code> with <code>0 &lt;= i &lt; j &lt; s.length</code> such that <code>s[i]</code> and <code>s[j]</code> are vowels, then <code>t[i]</code> must not have a higher ASCII value than <code>t[j]</code>.</li>
</ul>

<p>Return <em>the resulting string</em>.</p>

<p>The vowels are <code>'a'</code>, <code>'e'</code>, <code>'i'</code>, <code>'o'</code>, and <code>'u'</code>, and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "lEetcOde"
<strong>Output:</strong> "lEOtcede"
<strong>Explanation:</strong> 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants. The vowels are sorted according to their ASCII values, and the consonants remain in the same places.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "lYmpH"
<strong>Output:</strong> "lYmpH"
<strong>Explanation:</strong> There are no vowels in s (all characters in s are consonants), so we return "lYmpH".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists only of letters of the&nbsp;English alphabet&nbsp;in <strong>uppercase and lowercase</strong>.</li>
</ul>
</div></div>
 */
public class SortVowelsInAString {
    public static void main(String[] args) {
        String[] tests = {
            "lEetcOde",
            "lYmpH"
        };

        for (String s : tests) {
            System.out.println(new SortVowelsInAString_Solution().sortVowels(s));
        }
    }
}

/**
 * <h1 id="approach">Approach</h1>
 * <ol>
<li>
<p>Initialize arrays to count the occurrences of vowels (<code>vowelCount</code>) and to map the ASCII values of characters (<code>countIndexMap</code>). These arrays help in determining the positions of vowels in the rearranged string.</p>
</li>
<li>
<p>Iterate through the characters of the input string <code>s</code>:</p>
<ul>
<li>For each vowel encountered, update the <code>vowelCount</code> array.</li>
<li>Populate the <code>countIndexMap</code> array to map each character to its ASCII value.</li>
</ul>
</li>
<li>
<p>Iterate through the <code>vowelCount</code> array to rearrange the vowels in the result string (<code>result</code>). Update the characters in the <code>result</code> array based on the count of each vowel, ensuring they are sorted according to their ASCII values.</p>
</li>
<li>
<p>Return the final string obtained after rearranging both vowels and consonants.</p>
</li>
</ol>

 */
class SortVowelsInAString_Solution {
    // 5 ms
    // 44.5 MB
    public String sortVowels(String s) {
        int[] vowelCount = new int[11];
        int[] countIndexMap = new int[128];
        char[] result = s.toCharArray();
        char[] charMap = "AEIOUaeiou".toCharArray();

        for (int i = 0; i < charMap.length; i++) 
            countIndexMap[charMap[i]] = i + 1;

        for (char c : result) 
            vowelCount[countIndexMap[c]]++;
        int j = 1;
        int i = 0;

        while (j < vowelCount.length) {
            if (vowelCount[j] > 0)
                while (i < result.length) {
                    if (countIndexMap[result[i]] == 0) {
                        i++;
                        continue;
                    }
                    vowelCount[j]--;
                    result[i++] = charMap[j - 1];
                    break;
                }
            else
                j++;  
        }
        return new String(result);
    }
}