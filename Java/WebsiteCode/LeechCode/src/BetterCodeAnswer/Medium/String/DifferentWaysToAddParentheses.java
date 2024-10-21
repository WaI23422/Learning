package BetterCodeAnswer.Medium.String;

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

// 1ms 42.00MB
class DifferentWaysToAddParentheses_Solution {
    List<Integer>[][] dp;
    @SuppressWarnings("unchecked")
    public List<Integer> diffWaysToCompute(String ep) {
        dp = new ArrayList[ep.length()][ep.length()];
        return fun(ep, 0, ep.length()-1);
    }
    private List<Integer> fun(String a, int start, int end) {
        List<Integer> ret = new ArrayList<>();
        if (dp[start][end] != null)
        return dp[start][end];
        int x = operand(a, start, end);
        if (x != -1) {
            ret.add(x);
            dp[start][end] = ret;
            return ret;
        }
        for (int i = start; i <= end; i ++ ){ 
            if (!isOp(a.charAt(i)))
            continue;
            List<Integer> left = fun(a, start, i - 1);
            List<Integer> right = fun(a, i + 1, end);
            for (int j = 0 ;j < left.size(); j++) {
                for (int k = 0 ; k < right.size(); k++) {
                    if (a.charAt(i) == '*')
                    ret.add(left.get(j)*right.get(k));
                    if (a.charAt(i) == '+')
                    ret.add(left.get(j)+right.get(k));
                    if (a.charAt(i) == '-')
                    ret.add(left.get(j)-right.get(k));
                }
            }
        }
        dp[start][end] = ret;
        return ret;
    }
    private int operand(String a, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isOp(a.charAt(i)))
            return -1;
        }
        int value = 0;
        for (int i = start; i <= end; i++)
        value = value * 10 + (a.charAt(i) - '0');
        return value;
    }
    private boolean isOp(char c) {
        return c == '*' || c == '-' || c == '+';
    }
}