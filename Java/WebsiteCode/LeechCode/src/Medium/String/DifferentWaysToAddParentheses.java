package Medium.String;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/different-ways-to-add-parentheses/">241. Different Ways to Add Parentheses</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>expression</code> of numbers and operators, return <em>all possible results from computing all the different possible ways to group numbers and operators</em>. You may return the answer in <strong>any order</strong>.</p>
 * 
 * <p>The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed <code>10<sup>4</sup></code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> expression = "2-1-1"
 * <strong>Output:</strong> [0,2]
 * <strong>Explanation:</strong>
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> expression = "2*3-4*5"
 * <strong>Output:</strong> [-34,-14,-10,-10,10]
 * <strong>Explanation:</strong>
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14 
 * ((2*(3-4))*5) = -10 
 * (2*((3-4)*5)) = -10 
 * (((2*3)-4)*5) = 10
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= expression.length &lt;= 20</code></li>
 * 	<li><code>expression</code> consists of digits and the operator <code>'+'</code>, <code>'-'</code>, and <code>'*'</code>.</li>
 * 	<li>All the integer values in the input expression are in the range <code>[0, 99]</code>.</li>
 * </ul>
 * </div>
 */
public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        String[] tests  = {
            "2*3-4*5",
            "2-1-1",
        };

        for (String expression : tests) {
            System.out.println(new DifferentWaysToAddParentheses_Solution().diffWaysToCompute(expression));
        }
    }
}

// 2ms 42.7MB
class DifferentWaysToAddParentheses_Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<>();

        if (expression.length() == 0) return results;

        if (expression.length() == 1) {
            results.add(Integer.parseInt(expression));
            return results;
        }

        if (
            expression.length() == 2 && Character.isDigit(expression.charAt(0))
        ) {
            results.add(Integer.parseInt(expression));
            return results;
        }

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (Character.isDigit(currentChar)) continue;

            List<Integer> leftResults = diffWaysToCompute(
                expression.substring(0, i)
            );
            List<Integer> rightResults = diffWaysToCompute(
                expression.substring(i + 1)
            );

            for (int leftValue : leftResults) {
                for (int rightValue : rightResults) {
                    int computedResult = 0;
                    
                    switch (currentChar) {
                        case '+':
                            computedResult = leftValue + rightValue;
                            break;
                        case '-':
                            computedResult = leftValue - rightValue;
                            break;
                        case '*':
                            computedResult = leftValue * rightValue;
                            break;
                    }

                    results.add(computedResult);
                }
            }
        }

        return results;
    }
}