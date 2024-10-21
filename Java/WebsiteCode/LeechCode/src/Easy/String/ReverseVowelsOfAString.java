package Easy.String;

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

// 4 ms 45.1 MB
class ReverseVowelsOfAString_Solution {
    public String reverseVowels(String s) {
        int left = 0, right = s.length()-1;
        char leftChar = ' ',
             rightChar = ' ',
             sChars[] = s.toCharArray();
        StringBuffer leftHalf = new StringBuffer(),
                     rightHalf = new StringBuffer();
    
        OUT:
        while (left <= right) {
            leftChar = sChars[left++];
            if (isVowels(leftChar)) {
                while (right >= left) {
                    rightChar = sChars[right--];
                    if (isVowels(rightChar)) {
                        leftHalf.append(rightChar);
                        rightHalf.append(leftChar);
                        continue OUT;
                    } else {
                        rightHalf.append(rightChar);
                    }
                }

                if (right <= left) {
                    leftHalf.append(leftChar);    
                }
            } else {
                leftHalf.append(leftChar);
            }
        }
        
        return leftHalf.append(rightHalf.reverse()).toString();
    }

    private boolean isVowels(char c) {
        if (
            c == 'a' ||
            c == 'e' ||
            c == 'i' ||
            c == 'o' ||
            c == 'u' ||
            c == 'A' ||
            c == 'E' ||
            c == 'I' ||
            c == 'O' ||
            c == 'U'
        ) {
            return true;
        }

        return false;
    }
}