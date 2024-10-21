package Easy.String;

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

class BackspaceStringCompare_Solution {
    // 2 ms 
    // 41.8 MB
    static String stringSpaceClear(String str){
        int track = 0;

        while (track < str.length()) {
            if (str.charAt(track) == '#') { 
                if ( track == 0) { 
                    str = str.substring(1, str.length());
                    continue; 
                } 

                str = str.substring(0, track-1) + str.substring(track+1, str.length());
                track--;

                continue;
            }

            track++;
        }   

        return str;
    }
    
    public boolean backspaceCompare(String s, String t) {
        return stringSpaceClear(s).equals(stringSpaceClear(t));
    }
}