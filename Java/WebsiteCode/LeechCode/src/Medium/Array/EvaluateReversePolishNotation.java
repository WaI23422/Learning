package Medium.Array;

import java.util.Stack;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/evaluate-reverse-polish-notation/">150.Evaluate Reverse Polish Notation</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an array of strings <code>tokens</code> that represents an arithmetic expression in a <a href="http://en.wikipedia.org/wiki/Reverse_Polish_notation" target="_blank">Reverse Polish Notation</a>.</p>

<p>Evaluate the expression. Return <em>an integer that represents the value of the expression</em>.</p>

<p><strong>Note</strong> that:</p>

<ul>
	<li>The valid operators are <code>'+'</code>, <code>'-'</code>, <code>'*'</code>, and <code>'/'</code>.</li>
	<li>Each operand may be an integer or another expression.</li>
	<li>The division between two integers always <strong>truncates toward zero</strong>.</li>
	<li>There will not be any division by zero.</li>
	<li>The input represents a valid arithmetic expression in a reverse polish notation.</li>
	<li>The answer and all the intermediate calculations can be represented in a <strong>32-bit</strong> integer.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> tokens = ["2","1","+","3","*"]
<strong>Output:</strong> 9
<strong>Explanation:</strong> ((2 + 1) * 3) = 9
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> tokens = ["4","13","5","/","+"]
<strong>Output:</strong> 6
<strong>Explanation:</strong> (4 + (13 / 5)) = 6
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
<strong>Output:</strong> 22
<strong>Explanation:</strong> ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= tokens.length &lt;= 10<sup>4</sup></code></li>
	<li><code>tokens[i]</code> is either an operator: <code>"+"</code>, <code>"-"</code>, <code>"*"</code>, or <code>"/"</code>, or an integer in the range <code>[-200, 200]</code>.</li>
</ul>
</div>
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[][] tests = {
            {"2","1","+","3","*"},
            {"4","13","5","/","+"},
            {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}
        };

        for (String[] tokens : tests) {
            System.out.println(new EvaluateReversePolishNotation_Solution().evalRPN(tokens));
        }
    }    
}

// 5 ms 44.7 MB
class EvaluateReversePolishNotation_Solution {
    public int evalRPN(String[] tokens) {
        int num1,num2;

        Stack<Integer> contain = new Stack<Integer>();
        
        for (String string : tokens) {
            switch (string) {
                case "+":
                    contain.add(contain.pop() + contain.pop());
                    break;
                
                case "-":
                    num1 = contain.pop(); num2 = contain.pop();
                    contain.add(num2-num1);
                    break;

                case "*":
                    contain.add(contain.pop()* contain.pop());
                    break;

                case "/":
                    num1 = contain.pop(); num2 = contain.pop();
                    contain.add(num2/num1);
                    break;
                default:
                    contain.add(Integer.valueOf(string));
                    break;
            }
        }

        System.gc(); // 6 ms 43 MB
        return contain.pop();
    }
}