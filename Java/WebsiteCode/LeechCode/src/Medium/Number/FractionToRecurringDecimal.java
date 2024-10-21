package Medium.Number;

import java.util.HashMap;

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

// Wrong
class FractionToRecurringDecimal_Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {return "0";}
        if (numerator == denominator) {return "1";}
        StringBuffer sol = new StringBuffer();
        if (numerator < 0 || denominator < 0) {
            int addNegative = 0;
            if (numerator < 0) {
                numerator = ~numerator+1;
                addNegative += 1;
            }
            if (denominator < 0) {
                denominator = ~denominator+1;
                addNegative += 1;
            }
            if (addNegative == 1) {
                sol.append("-");
            }
        } 

        int num = numerator/denominator;
            numerator -= num*denominator;
        sol.append(num);
        if (numerator != 0) {
            sol.append(".");
        }

        HashMap<Double, Integer>  divisionPair = new HashMap<>();
        while (numerator != 0) {
            // numerator *= 10: (numerator * 8 = numerator << 3) + (numerator*2 = numerator << 1) 
            numerator = (numerator << 3) + (numerator << 1);

            if (numerator == denominator) {
                sol.append("1");
                break;
            } else if (numerator < denominator) {
                sol.append("0");
            } else {
                Double tempDivPair = (double) numerator /denominator;
                if (divisionPair.containsKey(tempDivPair)) {
                    int idx = divisionPair.get(tempDivPair);
                    return sol.substring(0, idx) + "(" + sol.substring(idx, sol.length()) + ")";
                } else {
                    divisionPair.put(tempDivPair, sol.length());

                    num = numerator/denominator;
                    sol.append(String.valueOf(num));
                    numerator-= num*denominator;
                }
            }
        }

        return sol.toString();
    }
}

// 1ms 41.17MB
class FractionToRecurringDecimal_Solution2 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        
        // fractional part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}