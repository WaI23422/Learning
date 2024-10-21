package Easy.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/to-lower-case/">709.To Lower Case</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given a string <code>s</code>, return <em>the string after replacing every uppercase letter with the same lowercase letter</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "Hello"
<strong>Output:</strong> "hello"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "here"
<strong>Output:</strong> "here"
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "LOVELY"
<strong>Output:</strong> "lovely"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> consists of printable ASCII characters.</li>
</ul>
</div></div>
 */
public class ToLowerCase {
    public static void main(String[] args) {
        String s = "Hello";

        ToLowerCase_Solution res =new ToLowerCase_Solution();

        System.out.println(res.toLowerCase(s));
    }
}

class ToLowerCase_Solution {   
    // 6 ms 
    // 41.4 MB
    public String toLowerCase(String s) {
        String sCopy = "";

        for (char c : s.toCharArray()) {
            if (c > 64 && c < 91) {
                sCopy +=  Character.toChars(c + 32)[0];
                continue;
            }

            sCopy += c;
        }
        
        return sCopy;
    }
}

class ToLowerCase_Solution2 {   
    // 1 ms
    // 40.4 MB
    public String toLowerCase(String s) {
        for (char c : s.toCharArray()) {
            if (c > 64 && c < 91) {
                s = s.replace(c, Character.toChars(c + 32)[0]);
            }
        }
        
        return s;
    }
}

class ToLowerCase_Solution3 {   
    // 0 ms
    // 40.3 MB
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}