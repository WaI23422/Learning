package Easy.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/redistribute-characters-to-make-all-strings-equal/">1897.Redistribute Characters to Make All Strings Equal</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an array of strings <code>words</code> (<strong>0-indexed</strong>).</p>

<p>In one operation, pick two <strong>distinct</strong> indices <code>i</code> and <code>j</code>, where <code>words[i]</code> is a non-empty string, and move <strong>any</strong> character from <code>words[i]</code> to <strong>any</strong> position in <code>words[j]</code>.</p>

<p>Return <code>true</code> <em>if you can make<strong> every</strong> string in </em><code>words</code><em> <strong>equal </strong>using <strong>any</strong> number of operations</em>,<em> and </em><code>false</code> <em>otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> words = ["abc","aabc","bc"]
<strong>Output:</strong> true
<strong>Explanation:</strong> Move the first 'a' in <code>words[1] to the front of words[2],
to make </code><code>words[1]</code> = "abc" and words[2] = "abc".
All the strings are now equal to "abc", so return <code>true</code>.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> words = ["ab","a"]
<strong>Output:</strong> false
<strong>Explanation:</strong> It is impossible to make all the strings equal using the operation.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 100</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 100</code></li>
	<li><code>words[i]</code> consists of lowercase English letters.</li>
</ul>
</div></div>
 */
public class RedistributeCharactersToMakeAllStringsEqual {
    public static void main(String[] args) {
        String[][] tests = {
            {"abc","aabc","bc"},
            {"ab","a"},
        };

        for (String[] words : tests) {
            System.out.println(new RedistributeCharactersToMakeAllStringsEqual_Solution().makeEqual(words));
        }
    }
}

// 1 ms 44 MB
class RedistributeCharactersToMakeAllStringsEqual_Solution {
    public boolean makeEqual(String[] words) {
        int[] charactersArr = new int[26];

        StringBuilder s = new StringBuilder();

        for (String word : words) {s.append(word);}

        if (s.length() % words.length != 0) {return false;}

        char[] charsWord = new char[s.length()];
        s.getChars(0, s.length(), charsWord, 0);

        for (char c : charsWord) {
            charactersArr[c-'a']++;
        }

        for (int number : charactersArr) {
            if (number % words.length != 0) {return false;}
        }

        System.gc(); // 6 ms 42 MB
        return true;
    }
}