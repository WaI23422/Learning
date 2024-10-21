package Medium.String;

/*
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/palindromic-substrings/">647.Palindromic Substrings</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>s</code>, return <em>the number of <strong>palindromic substrings</strong> in it</em>.</p>

<p>A string is a <strong>palindrome</strong> when it reads the same backward as forward.</p>

<p>A <strong>substring</strong> is a contiguous sequence of characters within the string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "abc"
<strong>Output:</strong> 3
<strong>Explanation:</strong> Three palindromic strings: "a", "b", "c".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "aaa"
<strong>Output:</strong> 6
<strong>Explanation:</strong> Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>
</div>
 */
public class PalindromicSubstrings {
    public static void main(String[] args) {
        String[] tests = {
            "abc",
            "aaa",
            "abbbcac"
        };
        
        for (String s : tests) {
            System.out.println(new PalindromicSubstrings_Solution().countSubstrings(s));
        }
    }
}

// 1828 ms 45.3 MB
class PalindromicSubstrings_Solution {
    public int countSubstrings(String s) {
        if (s.length() == 1) {return 1;}

        int countPalindrom = s.length();
        StringBuilder newS = new StringBuilder(s); 

        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (isPalindrom(newS.substring(i, j+1))) {countPalindrom++;}
            }
        }

        return countPalindrom;
    }

    public boolean isPalindrom(String s) {
        // return s.equals(new StringBuilder(s).reverse().toString());
    
        if (s.isEmpty()) {
        	return true;
        }

        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
        	char currFirst = s.charAt(start);
        	char currLast = s.charAt(last);
        	if (!Character.isLetterOrDigit(currFirst )) {
        		start++;
        	} else if(!Character.isLetterOrDigit(currLast)) {
        		last--;
        	} else {
        		if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
        			return false;
        		}
        		start++;
        		last--;
        	}
        }

        return true;
    }
}