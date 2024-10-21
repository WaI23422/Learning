package Hard.String;

import java.util.Stack;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/parsing-a-boolean-expression/">1106. Parsing A Boolean Expression</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>A <strong>boolean expression</strong> is an expression that evaluates to either <code>true</code> or <code>false</code>. It can be in one of the following shapes:</p>
 * 
 * <ul>
 * 	<li><code>'t'</code> that evaluates to <code>true</code>.</li>
 * 	<li><code>'f'</code> that evaluates to <code>false</code>.</li>
 * 	<li><code>'!(subExpr)'</code> that evaluates to <strong>the logical NOT</strong> of the inner expression <code>subExpr</code>.</li>
 * 	<li><code>'&amp;(subExpr<sub>1</sub>, subExpr<sub>2</sub>, ..., subExpr<sub>n</sub>)'</code> that evaluates to <strong>the logical AND</strong> of the inner expressions <code>subExpr<sub>1</sub>, subExpr<sub>2</sub>, ..., subExpr<sub>n</sub></code> where <code>n &gt;= 1</code>.</li>
 * 	<li><code>'|(subExpr<sub>1</sub>, subExpr<sub>2</sub>, ..., subExpr<sub>n</sub>)'</code> that evaluates to <strong>the logical OR</strong> of the inner expressions <code>subExpr<sub>1</sub>, subExpr<sub>2</sub>, ..., subExpr<sub>n</sub></code> where <code>n &gt;= 1</code>.</li>
 * </ul>
 * 
 * <p>Given a string <code>expression</code> that represents a <strong>boolean expression</strong>, return <em>the evaluation of that expression</em>.</p>
 * 
 * <p>It is <strong>guaranteed</strong> that the given expression is valid and follows the given rules.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> expression = "&amp;(|(f))"
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> 
 * First, evaluate |(f) --&gt; f. The expression is now "&amp;(f)".
 * Then, evaluate &amp;(f) --&gt; f. The expression is now "f".
 * Finally, return false.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> expression = "|(f,f,f,t)"
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> The evaluation of (false OR false OR false OR true) is true.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> expression = "!(&amp;(f,t))"
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> 
 * First, evaluate &amp;(f,t) --&gt; (false AND true) --&gt; false --&gt; f. The expression is now "!(f)".
 * Then, evaluate !(f) --&gt; NOT false --&gt; true. We return true.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= expression.length &lt;= 2 * 10<sup>4</sup></code></li>
 * 	<li>expression[i] is one following characters: <code>'('</code>, <code>')'</code>, <code>'&amp;'</code>, <code>'|'</code>, <code>'!'</code>, <code>'t'</code>, <code>'f'</code>, and <code>','</code>.</li>
 * </ul>
 * </div></div>
 */
public class ParsingABooleanExpression {
    public static void main(String[] args) {
        String[] tests = {
            "|(&(t,f,t),&(t,f,t),&(t,f,t),t)",
            "|(&(t,f,t),t)",
            "&(|(f))",
            "|(f,f,f,t)",
            "!(&(f,t))"
        };

        for (String expression : tests) {
            System.out.println(new ParsingABooleanExpression_Solution().parseBoolExpr(expression));
        }
    }
}

// 9ms 42.54MB
class ParsingABooleanExpression_Solution {
    public boolean parseBoolExpr(String expression) {
        char[] expression_char = expression.toCharArray();
        Stack<Boolean> st = new Stack<>(); 
        Stack<Integer> pre_count = new Stack<>();

        int count = 0,
            limit = 0;
        for (int i = expression_char.length-1; i >= 0; i--) {
            switch (expression_char[i]) {
                case '&':
                    boolean temp_and = true;
                    for (int j = 0; j < limit; j++) {
                        temp_and &= st.pop();
                    }
                    st.add(temp_and);
                    break;

                case '!':
                    st.add(!st.pop());
                    break;

                case '|':
                    boolean temp_or = false;
                    for (int j = 0; j < limit; j++) {
                        temp_or |= st.pop();
                    }
                    st.add(temp_or);
                    break;

                case 't':
                    st.add(true);
                    count++;
                    break;
                    
                case 'f':
                    st.add(false);
                    count++;
                    break;

                case ')':
                    pre_count.add(count);
                    count = 0;
                    break;

                case '(':
                    limit = count;
                    count = pre_count.pop()+1;
                    break;
            }
        }

        return st.pop();
    }
}