package BetterCodeAnswer.Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/perfect-number/">507. Perfect Number</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>A <a href="https://en.wikipedia.org/wiki/Perfect_number" target="_blank"><strong>perfect number</strong></a> is a <strong>positive integer</strong> that is equal to the sum of its <strong>positive divisors</strong>, excluding the number itself. A <strong>divisor</strong> of an integer <code>x</code> is an integer that can divide <code>x</code> evenly.</p>
 * 
 * <p>Given an integer <code>n</code>, return <code>true</code><em> if </em><code>n</code><em> is a perfect number, otherwise return </em><code>false</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> num = 28
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> 28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, and 14 are all divisors of 28.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> num = 7
 * <strong>Output:</strong> false
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= num &lt;= 10<sup>8</sup></code></li>
 * </ul>
 * </div>
 */
public class PerfectNumber {
    public static void main(String[] args) {
        int[] tests = {
            6,
            28,
            7,
        };

        for (int num : tests) {
            System.out.println(new PerfectNumber_Solution().checkPerfectNumber(num));
        }
    }
}

// 0 ms 40.3 MB
class PerfectNumber_Solution {
    public boolean checkPerfectNumber(int num) {
        return (num ==6 || num == 28 || num == 496 || num == 8128 || num == 33550336) ? true : false;
    }
}

// 29 ms 40.7 MB
class PerfectNumber_Solution2 {
    public boolean checkPerfectNumber(int num) {
        if (num < 2) {
            return false;
        }

        if(num % 2 != 0) {
            return false;
        }

        int sum = 1;
        int max = num;
        for (int i = 2; i < max; i++) {
            if (num % i == 0) {
                System.out.println(i);
                sum += i;
                
                int otherDivisor = num / i;
                if (otherDivisor != i) {
                    System.out.println(otherDivisor);
                    sum += otherDivisor;
                }
                max = otherDivisor;
            }
        }
        return sum == num;
    }
}