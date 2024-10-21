package Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-add-to-make-parentheses-valid/">921. Minimum Add to Make Parentheses Valid</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>A parentheses string is valid if and only if:</p>
 * 
 * <ul>
 * 	<li>It is the empty string,</li>
 * 	<li>It can be written as <code>AB</code> (<code>A</code> concatenated with <code>B</code>), where <code>A</code> and <code>B</code> are valid strings, or</li>
 * 	<li>It can be written as <code>(A)</code>, where <code>A</code> is a valid string.</li>
 * </ul>
 * 
 * <p>You are given a parentheses string <code>s</code>. In one move, you can insert a parenthesis at any position of the string.</p>
 * 
 * <ul>
 * 	<li>For example, if <code>s = "()))"</code>, you can insert an opening parenthesis to be <code>"(<strong>(</strong>)))"</code> or a closing parenthesis to be <code>"())<strong>)</strong>)"</code>.</li>
 * </ul>
 * 
 * <p>Return <em>the minimum number of moves required to make </em><code>s</code><em> valid</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "())"
 * <strong>Output:</strong> 1
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "((("
 * <strong>Output:</strong> 3
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
 * 	<li><code>s[i]</code> is either <code>'('</code> or <code>')'</code>.</li>
 * </ul>
 * </div></div>
 */
public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        String[] tests = {
            "())"
        };

        for (String s : tests) {
            System.out.println(new MinimumAddToMakeParenthesesValid_Solution().minAddToMakeValid(s));
        }
    }
}

// 0ms 41.36MB
class MinimumAddToMakeParenthesesValid_Solution {
    public int minAddToMakeValid(String s) {
        int open = 0,
            min = 0;

        for (var c : s.getBytes()) {
            if (c == ')') {
                if (open > 0) {
                    open--;
                } else {
                    min++;
                }
            } else {
                open++;
            }
        }

        return min+open;
    }
}