package BetterCodeAnswer.Medium.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/fraction-to-recurring-decimal/">166. Fraction to Recurring Decimal</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given two integers representing the <code>numerator</code> and <code>denominator</code> of a fraction, return <em>the fraction in string format</em>.</p>
 * 
 * <p>If the fractional part is repeating, enclose the repeating part in parentheses.</p>
 * 
 * <p>If multiple answers are possible, return <strong>any of them</strong>.</p>
 * 
 * <p>It is <strong>guaranteed</strong> that the length of the answer string is less than <code>10<sup>4</sup></code> for all the given inputs.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> numerator = 1, denominator = 2
 * <strong>Output:</strong> "0.5"
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> numerator = 2, denominator = 1
 * <strong>Output:</strong> "2"
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> numerator = 4, denominator = 333
 * <strong>Output:</strong> "0.(012)"
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>-2<sup>31</sup> &lt;=&nbsp;numerator, denominator &lt;= 2<sup>31</sup> - 1</code></li>
 * 	<li><code>denominator != 0</code></li>
 * </ul>
 * </div>
 */
public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        int[][] tests = {
            {1,2147483647},
            {-22,-2},
            {-50,3},
            {22,7},
            {37,300},
            {12,4},
            {12,5},
            {1,2},
            {4,333}
        };

        for (int[] test : tests) {
            int numerator = test[0],
                denominator = test[1];

            System.out.println(new FractionToRecurringDecimal_Solution().fractionToDecimal(numerator, denominator));
        }
    }
}

// 0ms 41.29MB;
class FractionToRecurringDecimal_Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long lnum = numerator, lden = denominator;
        if (lnum == 0) {
            return "0";
        }
        if (lnum % lden == 0) {
            return Long.toString(lnum / lden);
        }
        StringBuilder number = new StringBuilder();
        if ((lden < 0) ^ (lnum < 0)) {
            number.append('-');
        }
        lnum = Math.abs(lnum);
        lden = Math.abs(lden);
        number.append(Long.toString(lnum / lden)).append('.');
        long GCD = gcd(lnum, lden);
        lnum /= GCD;
        lden /= GCD;
        lnum %= lden;
        lnum *= 10;
        int twos = 0, fives = 0;
        long temp = lden;
        for (; temp % 2 == 0; twos++) {
            temp /= 2;
        }
        for (; temp % 5 == 0; fives++) {
            temp /= 5;
        }
        if (temp == 1) {
            while (lnum != 0) {
                number.append(lnum / lden);
                lnum = (lnum % lden) * 10;
            }
        } else {
            int nonRepLen = Math.max(twos, fives);
            for (int i = 0; i < nonRepLen; i++) {
                number.append(lnum / lden);
                lnum = (lnum % lden) * 10;
            }
            long initRem = lnum;
            StringBuilder nonRep = new StringBuilder();
            do {
                nonRep.append(lnum / lden);
                lnum = (lnum % lden) * 10;
            } while (lnum != initRem);
            number.append('(').append(nonRep.toString()).append(')');
        }
        return number.toString();
    }
    private long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}