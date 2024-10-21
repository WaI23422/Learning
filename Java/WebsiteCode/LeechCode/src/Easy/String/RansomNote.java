package Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/ransom-note/">383. Ransom Note</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given two strings <code>ransomNote</code> and <code>magazine</code>, return <code>true</code><em> if </em><code>ransomNote</code><em> can be constructed by using the letters from </em><code>magazine</code><em> and </em><code>false</code><em> otherwise</em>.</p>

<p>Each letter in <code>magazine</code> can only be used once in <code>ransomNote</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> ransomNote = "a", magazine = "b"
<strong>Output:</strong> false
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> ransomNote = "aa", magazine = "ab"
<strong>Output:</strong> false
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> ransomNote = "aa", magazine = "aab"
<strong>Output:</strong> true
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= ransomNote.length, magazine.length &lt;= 10<sup>5</sup></code></li>
	<li><code>ransomNote</code> and <code>magazine</code> consist of lowercase English letters.</li>
</ul>
</div>
 */
public class RansomNote {
    public static void main(String[] args) {
        String[][] tests = {
            {"",""}
        };

        for (String[] test : tests) {
            String ransomNote = test[0],
                   magazine = test[1];

            System.out.println(new RansomNote_Solution().canConstruct(ransomNote, magazine));
        }
    } 
}

// 1 ms 44.5 MB
class RansomNote_Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {return false;}
        
        int[] numberCharMagazine = new int[26];
        char[] magazineChars = magazine.toCharArray(),
               ransomNoteChars = ransomNote.toCharArray(); 

        for (char c : magazineChars) {
            numberCharMagazine[c-'a']++;
        }

        for (char c : ransomNoteChars) {
            int remain = --numberCharMagazine[c-'a'];

            if (remain < 0) {return false;}
        }

        return true;
    }
}