package Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-remove-to-make-valid-parentheses/">1249. Minimum Remove to Make Valid Parentheses</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <font face="monospace">s</font> of <code>'('</code> , <code>')'</code> and lowercase English characters.</p>

<p>Your task is to remove the minimum number of parentheses ( <code>'('</code> or <code>')'</code>, in any positions ) so that the resulting <em>parentheses string</em> is valid and return <strong>any</strong> valid string.</p>

<p>Formally, a <em>parentheses string</em> is valid if and only if:</p>

<ul>
	<li>It is the empty string, contains only lowercase characters, or</li>
	<li>It can be written as <code>AB</code> (<code>A</code> concatenated with <code>B</code>), where <code>A</code> and <code>B</code> are valid strings, or</li>
	<li>It can be written as <code>(A)</code>, where <code>A</code> is a valid string.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "lee(t(c)o)de)"
<strong>Output:</strong> "lee(t(c)o)de"
<strong>Explanation:</strong> "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "a)b(c)d"
<strong>Output:</strong> "ab(c)d"
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "))(("
<strong>Output:</strong> ""
<strong>Explanation:</strong> An empty string is also valid.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is either<code>'('</code> , <code>')'</code>, or lowercase English letter<code>.</code></li>
</ul>
</div>
 */
public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        String[] tests = {
            "())()(((",
            "lee(t(c)o)de)",
            "a)b(c)d",
            "))((",
            "(",
            ")",
        };

        for (String s : tests) {
            System.out.println(new MinimumRemoveToMakeValidParentheses_Solution().minRemoveToMakeValid(s));
        }
    }   
}

// 581 ms 46 MB
class MinimumRemoveToMakeValidParentheses_Solution {
    public String minRemoveToMakeValid(String s) {
        int open=0,close=0,flag=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') {
                open++;
                flag+=1;
            }
            else if(s.charAt(i)==')'&&flag>0) {
                close++;
                flag--;
            }
        }
        int k=Math.min(open,close);
        String ans="";
        open=k;
        close=k;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(open>0) {
                    ans+='(';
                    open--;
                }
                continue;
            } 
            if(s.charAt(i)==')') {
               if(close>0&&close>open) {
                  ans+=')'; 
                  close--;
               }
               continue;
            }
            else ans+=s.charAt(i);
        }
        return ans;
    }
}