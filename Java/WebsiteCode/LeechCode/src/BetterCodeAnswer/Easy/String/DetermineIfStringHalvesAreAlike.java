package BetterCodeAnswer.Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/determine-if-string-halves-are-alike/">1704.Determine if String Halves Are Alike</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a string <code>s</code> of even length. Split this string into two halves of equal lengths, and let <code>a</code> be the first half and <code>b</code> be the second half.</p>

<p>Two strings are <strong>alike</strong> if they have the same number of vowels (<code>'a'</code>, <code>'e'</code>, <code>'i'</code>, <code>'o'</code>, <code>'u'</code>, <code>'A'</code>, <code>'E'</code>, <code>'I'</code>, <code>'O'</code>, <code>'U'</code>). Notice that <code>s</code> contains uppercase and lowercase letters.</p>

<p>Return <code>true</code><em> if </em><code>a</code><em> and </em><code>b</code><em> are <strong>alike</strong></em>. Otherwise, return <code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "book"
<strong>Output:</strong> true
<strong>Explanation:</strong> a = "b<u>o</u>" and b = "<u>o</u>k". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "textbook"
<strong>Output:</strong> false
<strong>Explanation:</strong> a = "t<u>e</u>xt" and b = "b<u>oo</u>k". a has 1 vowel whereas b has 2. Therefore, they are not alike.
Notice that the vowel o is counted twice.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s.length</code> is even.</li>
	<li><code>s</code> consists of <strong>uppercase and lowercase</strong> letters.</li>
</ul>
</div>
 */
/**
 * DetermineIfStringHalvesAreAlike
 */
public class DetermineIfStringHalvesAreAlike {
    public static void main(String[] args) {
        String[] tests = {
            "textbook",
            "book"
        };

        for (String string : tests) {
            System.out.println(new DetermineIfStringHalvesAreAlike_Solution().halvesAreAlike(string));
        }
    }
}

// 1 ms 42.1 MB
class DetermineIfStringHalvesAreAlike_Solution {
    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        String firstHalf = s.substring(0, mid);
        String secondHalf = s.substring(mid);
        
        int countFirst = countVowels(firstHalf);
        int countSecond = countVowels(secondHalf);
        
        return countFirst == countSecond;
    }
    
    private int countVowels(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if ("AEIOUaeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
}