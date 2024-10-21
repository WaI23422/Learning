package BetterCodeAnswer.Easy.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/reverse-vowels-of-a-string/">345. Reverse Vowels of a String</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code>, reverse only all the vowels in the string and return it.</p>

<p>The vowels are <code>'a'</code>, <code>'e'</code>, <code>'i'</code>, <code>'o'</code>, and <code>'u'</code>, and they can appear in both lower and upper cases, more than once.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "hello"
<strong>Output:</strong> "holle"
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "leetcode"
<strong>Output:</strong> "leotcede"
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 3 * 10<sup>5</sup></code></li>
	<li><code>s</code> consist of <strong>printable ASCII</strong> characters.</li>
</ul>
</div>
 */
public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        String[] tests = {
            "ai",
            ".a",
            "a.",
            "hello",
            "leetcode",
        };

        for (String s : tests) {
            System.out.println(new ReverseVowelsOfAString_Solution().reverseVowels(s));
        }
    }
}

// 1 ms 45.1 MB
class ReverseVowelsOfAString_Solution {
    public String reverseVowels(String s) {
        boolean[] isVowel = new boolean[128];
        isVowel['a'] = true;
        isVowel['e'] = true;
        isVowel['i'] = true;
        isVowel['o'] = true;
        isVowel['u'] = true;
        isVowel['A'] = true;
        isVowel['E'] = true;
        isVowel['I'] = true;
        isVowel['O'] = true;
        isVowel['U'] = true;
        char[] c = s.toCharArray();
        int i=0, j=c.length-1;
        while(i<j)
        {
            while(!isVowel[c[i]] && i<j)
            i++;
            while(!isVowel[c[j]] && j>i)
            j--;
            
            if(isVowel[c[i]] && isVowel[c[j]])
            {
                char ch = c[i];
                c[i] = c[j];
                c[j] = ch;
                i++;
                j--;
            }
            
        }
        

        return new String(c);
    }
}