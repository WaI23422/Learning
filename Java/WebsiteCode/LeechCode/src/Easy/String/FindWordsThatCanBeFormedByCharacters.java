package Easy.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/find-words-that-can-be-formed-by-characters/">1160.Find Words That Can Be Formed by Characters</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an array of strings <code>words</code> and a string <code>chars</code>.</p>

<p>A string is <strong>good</strong> if it can be formed by characters from chars (each character can only be used once).</p>

<p>Return <em>the sum of lengths of all good strings in words</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> words = ["cat","bt","hat","tree"], chars = "atach"
<strong>Output:</strong> 6
<strong>Explanation:</strong> The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> words = ["hello","world","leetcode"], chars = "welldonehoneyr"
<strong>Output:</strong> 10
<strong>Explanation:</strong> The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 1000</code></li>
	<li><code>1 &lt;= words[i].length, chars.length &lt;= 100</code></li>
	<li><code>words[i]</code> and <code>chars</code> consist of lowercase English letters.</li>
</ul>
</div></div>
 */
public class FindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args) {
        String[][][] tests = {
            {{"cat","bt","hat","tree"},{"atach"}},
            {{"hello","world","leetcode"},{"welldonehoneyr"}},
        };

        for (String[][] strings : tests) {
            String[] words = strings[0];
            String chars = strings[1][0];

            System.out.println(new FindWordsThatCanBeFormedByCharacters_Solution().countCharacters(words, chars));
        }
    }
}

class FindWordsThatCanBeFormedByCharacters_Solution {
    // 82 ms 44.3 MB
    public int countCharacters(String[] words, String chars) {
        int total = 0;

        for (String string : words) {
            char[] charsArray = string.toCharArray();
            StringBuffer charsString = new StringBuffer(chars); 
            
            int check = 0;
            for (char c : charsArray) {
                if (charsString.indexOf(Character.toString(c)) != -1) { charsString.deleteCharAt(charsString.indexOf(Character.toString(c)));check++;}
            }

            if (check == charsArray.length) {total += check;}
        }

        return total;
    }
}