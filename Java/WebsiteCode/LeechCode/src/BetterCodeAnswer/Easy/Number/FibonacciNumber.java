package BetterCodeAnswer.Easy.Number;

import java.util.HashMap;
import java.util.Map;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/fibonacci-number/">509. Fibonacci Number</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>The <b>Fibonacci numbers</b>, commonly denoted <code>F(n)</code> form a sequence, called the <b>Fibonacci sequence</b>, such that each number is the sum of the two preceding ones, starting from <code>0</code> and <code>1</code>. That is,</p>
 * 
 * <pre>F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n &gt; 1.
 * </pre>
 * 
 * <p>Given <code>n</code>, calculate <code>F(n)</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 2
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> F(2) = F(1) + F(0) = 1 + 0 = 1.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 3
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> F(3) = F(2) + F(1) = 1 + 1 = 2.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 4
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> F(4) = F(3) + F(2) = 2 + 1 = 3.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= n &lt;= 30</code></li>
 * </ul>
 * </div>
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        int[] tests = {
            1,
            2,
            3
        }; 

        for (int n : tests) {
            System.out.println(new FibonacciNumber_Solution().fib(n));
        }
    }
}

// 0 ms 40.1 MB
class FibonacciNumber_Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);
        return result;
    }
}

// 17 ms 40.8 MB
class FibonacciNumber_Solution2 {
    public int fib(int n) {
        int sum=0,sum1=0,sum2=0;
        if(n==0  || n==1) return n;
        
        sum1 =  fib(n-1);
        sum2 =    fib(n-2);
        sum +=sum1 + sum2;

        return sum;
    }
}