package Medium.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sum-of-square-numbers/">633. Sum of Square Numbers</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a non-negative integer <code>c</code>, decide whether there're two integers <code>a</code> and <code>b</code> such that <code>a<sup>2</sup> + b<sup>2</sup> = c</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> c = 5
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> 1 * 1 + 2 * 2 = 5
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> c = 3
 * <strong>Output:</strong> false
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= c &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 * </div>
 */
public class SumOfSquareNumbers {
    public static void main(String[] args) {
        int[] tests = {
            5,
            3,
            2147483647
        };

        for (int num : tests) {
            System.out.println(new SumOfSquareNumbers_Solution().judgeSquareSum(num));
        }
    }
}

// 3 ms 40.5 MB
class SumOfSquareNumbers_Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 3) {return true;}
        int end = (int) Math.sqrt(c);

        for (int i = 0; i < end; i++) {
            double minus = Math.sqrt(c - i*i);

            if ((int) minus == minus) {return true;}
        }

        return false;
    }
}