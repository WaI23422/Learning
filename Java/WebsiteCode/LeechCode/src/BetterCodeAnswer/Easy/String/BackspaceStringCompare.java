package BetterCodeAnswer.Easy.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/backspace-string-compare/">844.Backspace String Compare</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given two strings <code>s</code> and <code>t</code>, return <code>true</code> <em>if they are equal when both are typed into empty text editors</em>. <code>'#'</code> means a backspace character.</p>

<p>Note that after backspacing an empty text, the text will continue empty.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "ab#c", t = "ad#c"
<strong>Output:</strong> true
<strong>Explanation:</strong> Both s and t become "ac".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "ab##", t = "c#d#"
<strong>Output:</strong> true
<strong>Explanation:</strong> Both s and t become "".
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "a#c", t = "b"
<strong>Output:</strong> false
<strong>Explanation:</strong> s becomes "c" while t becomes "b".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code><span>1 &lt;= s.length, t.length &lt;= 200</span></code></li>
	<li><span><code>s</code> and <code>t</code> only contain lowercase letters and <code>'#'</code> characters.</span></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Can you solve it in <code>O(n)</code> time and <code>O(1)</code> space?</p>
</div></div>
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "a##c", t = "#a#c";

        BackspaceStringCompare_Solution res = new BackspaceStringCompare_Solution();

        System.out.println(res.backspaceCompare(s, t));
    }
}

/**
 * <h1 id="approach-1-two-pointers">Approach 1: Two Pointers</h1>
 * 
 * <ol>
<li>
<p><strong>Processing the String</strong>: To emulate the "typing" and "erasing" action, we navigate through each string with two pointers. The main pointer (<code>i</code>) traverses each character, while the auxiliary pointer (<code>k</code> for <code>s</code> and <code>p</code> for <code>t</code>) indicates the effective position of the last character post backspaces.</p>
<ul>
<li>If the character at the main pointer isn't <code>#</code>, it's "typed" at the location of the auxiliary pointer, which is then incremented.</li>
<li>If the character is <code>#</code>, the preceding character is "erased" by decrementing the auxiliary pointer.</li>
<li>The concluding value of the auxiliary pointer after processing gives the effective string length after considering backspaces.</li>
</ul>
</li>
<li>
<p><strong>Comparing the Strings</strong>: After processing, the effective lengths (final values of <code>k</code> and <code>p</code>) are compared. A difference in lengths directly implies the strings aren't equal. If the lengths align, a character-by-character comparison is performed up to their effective lengths.</p>
</li>
</ol>
 */
class BackspaceStringCompare_Solution {
    // 0 ms 
    // 40.3 MB
    public boolean backspaceCompare(String S, String T) {
        char[] sChars = S.toCharArray();
        char[] tChars = T.toCharArray();
        
        int k = processString(sChars);
        int p = processString(tChars);

        if (k != p) return false;

        for (int i = 0; i < k; i++) {
            if (sChars[i] != tChars[i]) return false;
        }

        return true;
    }

    private int processString(char[] chars) {
        int k = 0;
        for (char c : chars) {
            if (c != '#') {
                chars[k++] = c;
            } else if (k > 0) {
                k--;
            }
        }
        return k;
    }
}