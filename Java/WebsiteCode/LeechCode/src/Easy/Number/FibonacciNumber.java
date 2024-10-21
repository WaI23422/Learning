package Easy.Number;

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

// 0 ms 40.2 MB
class FibonacciNumber_Solution {
    public int fib(int n) {
        if (n == 0) {return 0;}
        
        int at = 1,
            first = 0,
            second = 1;

        while (at < n) {
            if (at++%2 == 0) {
                second += first;
            } else {
                first += second;
            }
        }

        return at%2 == 0 ? first : second;
    }
}