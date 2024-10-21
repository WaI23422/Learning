package BetterCodeAnswer.Easy.String;

import java.util.HashMap;
import java.util.Stack;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/valid-parentheses/">20.Valid Parentheses</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given a string <code>s</code> containing just the characters <code>'('</code>, <code>')'</code>, <code>'{'</code>, <code>'}'</code>, <code>'['</code> and <code>']'</code>, determine if the input string is valid.</p>

<p>An input string is valid if:</p>

<ol>
	<li>Open brackets must be closed by the same type of brackets.</li>
	<li>Open brackets must be closed in the correct order.</li>
	<li>Every close bracket has a corresponding open bracket of the same type.</li>
</ol>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "()"
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "()[]{}"
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "(]"
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of parentheses only <code>'()[]{}'</code>.</li>
</ul>
</div></div>
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String[] test  = {
            "([])",
            "()[]{}",
            "(]",
            "([)]"
        };

        for (String s : test) {
            System.out.println(new ValidParentheses_Solution().isValid(s));
        }
    }    
}

class ValidParentheses_Solution {
    // 0 ms 40.4 MB
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }

        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack[++top] = c;
            } else {
                if (top == -1) {
                    return false;
                }
                if ((c == ')' && stack[top] != '(') ||
                    (c == ']' && stack[top] != '[') ||
                    (c == '}' && stack[top] != '{')) {
                    return false;
                }
                top--;
            }
        }
        return top == -1;
    }
}

class ValidParentheses_Solution2 {
    // 2 ms 40.4 MB
    public boolean isValid(String parentheses) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (int i = 0; i < parentheses.length(); i++) {
            if (map.containsKey(parentheses.charAt(i))) {
                stack.push(parentheses.charAt(i));
            } else if (!stack.isEmpty() && parentheses.charAt(i) == map.get(stack.peek())) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}