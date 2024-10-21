package Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/fraction-addition-and-subtraction/">592. Fraction Addition and Subtraction</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>expression</code> representing an expression of fraction addition and subtraction, return the calculation result in string format.</p>
 * 
 * <p>The final result should be an <a href="https://en.wikipedia.org/wiki/Irreducible_fraction" target="_blank">irreducible fraction</a>. If your final result is an integer, change it to the format of a fraction that has a denominator <code>1</code>. So in this case, <code>2</code> should be converted to <code>2/1</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> expression = "-1/2+1/2"
 * <strong>Output:</strong> "0/1"
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> expression = "-1/2+1/2+1/3"
 * <strong>Output:</strong> "1/3"
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> expression = "1/3-1/2"
 * <strong>Output:</strong> "-1/6"
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The input string only contains <code>'0'</code> to <code>'9'</code>, <code>'/'</code>, <code>'+'</code> and <code>'-'</code>. So does the output.</li>
 * 	<li>Each fraction (input and output) has the format <code>±numerator/denominator</code>. If the first input fraction or the output is positive, then <code>'+'</code> will be omitted.</li>
 * 	<li>The input only contains valid <strong>irreducible fractions</strong>, where the <strong>numerator</strong> and <strong>denominator</strong> of each fraction will always be in the range <code>[1, 10]</code>. If the denominator is <code>1</code>, it means this fraction is actually an integer in a fraction format defined above.</li>
 * 	<li>The number of given fractions will be in the range <code>[1, 10]</code>.</li>
 * 	<li>The numerator and denominator of the <strong>final result</strong> are guaranteed to be valid and in the range of <strong>32-bit</strong> int.</li>
 * </ul>
 * </div>
 */
public class FractionAdditionAndSubtraction {
    public static void main(String[] args) {
        String[] tests = {
            "1/3-1/2",
            "-1/2+1/2",
            "-1/2+1/2+1/3",
        };

        for (String expression : tests) {
            System.out.println(new FractionAdditionAndSubtraction_Solution().fractionAddition(expression));
        }
    }
}

// 9ms 42.08MB
class FractionAdditionAndSubtraction_Solution {
    public String fractionAddition(String expression) {
        int numerator = 0,
            denominator = 1,
            idx = expression.charAt(0) == '-' ? 1 : 0,
            sign_idx = 0;
        String[] fractions = expression.split("[-+/]");
        char[] expression_chars = expression.toCharArray();
        
        int len = fractions.length;
        for (int i = idx; i < len; i++) {
            int numerator_temp = Integer.parseInt(fractions[i++]),
                denominator_temp = Integer.parseInt(fractions[i]),
                lcm = lcm(denominator, denominator_temp);

            char sign = '+';
            while (expression_chars[sign_idx] != '/') {
                if (expression_chars[sign_idx++] == '-') {
                    sign = '-';  
                }
            }
            sign_idx++;
            if (sign == '-') {
                numerator = numerator*(lcm/denominator) - numerator_temp*(lcm/denominator_temp);
            } else {
                numerator = numerator*(lcm/denominator) + numerator_temp*(lcm/denominator_temp);
            }
            denominator *= (lcm/denominator);
        }

        int gcd = gcd(numerator, denominator);
        if (gcd != 0) {
            numerator /= gcd;
            denominator /= gcd;
        }

        return (denominator < 0 ? "-" : "") + numerator + "/" + Math.abs(denominator);
    }

    private int gcd(int a, int b) {
        if (b == 0) { return a; }
        
        return gcd(b,a % b);
    }

    private int lcm(int a, int b){
        return (a / gcd(a, b)) * b;
    }
}