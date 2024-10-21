package BetterCodeAnswer.Medium.String;

import java.util.ArrayList;

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

// 1ms 42.08MB
class FractionAdditionAndSubtraction_Solution {

    class Fraction {
        public boolean isNegative;
        public int numerator;
        public int denominator;

        public void placeNumerator(char n) {
            if(numerator > 0) {
                numerator *= 10;
            }
            numerator += Character.getNumericValue(n);
        }
        public void placeDenominator(char n) {
            if(denominator > 0) {
                denominator *= 10;
            }
            denominator += Character.getNumericValue(n);
        }
        public int getSignedNumerator() {
            return isNegative ? -numerator : numerator;
        }
        public void add(Fraction other) {
            int finalResult = this.getSignedNumerator() +
                other.getSignedNumerator();

            this.isNegative = (finalResult < 0);
            this.numerator = Math.abs(finalResult);

            if(finalResult == 0) {
                this.denominator = 1;
            }
        }
        public void reduce() {
            if(denominator == 1) {
                return;
            }
            if(denominator % numerator == 0) {
                denominator = denominator / numerator;
                numerator = 1;
                return;
            }
            if(numerator % denominator == 0) {
                numerator = numerator / denominator;
                denominator = 1;
                return;
            }
            int multipleCap = Math.min(numerator, denominator) / 2;

            for(int i = 2; i <= multipleCap; i++) {
                // If not evenly divisible, continue.
                if(numerator % i != 0 || denominator % i != 0) {
                    continue;
                }
                numerator = numerator / i;
                denominator = denominator / i;
                multipleCap = Math.min(numerator, denominator) / 2;
                i = 1;
            }
        }
        public String toString() {
            StringBuilder str = new StringBuilder();
            if(isNegative) {
                str.append('-');
            }
            str.append(numerator);
            str.append('/');
            str.append(denominator);
            return str.toString();
        }
    }
    public String fractionAddition(String expression) {

        ArrayList<Fraction> allFractions = parseFractions(expression);
        Fraction baseFraction = allFractions.get(0);

        for(int i = 1; i < allFractions.size(); i++) {
            Fraction actedUponFraction = allFractions.get(i);

            int baseDenominator = baseFraction.denominator;
            baseFraction.numerator *= actedUponFraction.denominator;
            baseFraction.denominator *= actedUponFraction.denominator;
            actedUponFraction.numerator *= baseDenominator;
            actedUponFraction.denominator *= baseDenominator;

            baseFraction.add(actedUponFraction);
            baseFraction.reduce();
        }
        return baseFraction.toString();
    }
    public ArrayList<Fraction> parseFractions(String expression) {
        ArrayList<Fraction> allFractions = new ArrayList<>();
        int i = 0;
        do {
            Fraction fraction = new Fraction();
            char currentChar = expression.charAt(i);

            if(currentChar == '-') {
                fraction.isNegative = true;
                i = i + 1;
            }
            if(currentChar == '+') {
                i = i + 1;
            }
            currentChar = expression.charAt(i);
            do {
                fraction.placeNumerator(currentChar);
                i = i + 1;
                currentChar = expression.charAt(i);
            } while(currentChar != '/');
            i = i + 1;

            currentChar = expression.charAt(i);
            do {
                fraction.placeDenominator(currentChar);
                i = i + 1;

                if(i >= expression.length()) {
                    break;
                }
                currentChar = expression.charAt(i);

            } while(i < expression.length() && 
                currentChar != '+' &&
                currentChar != '-');

            allFractions.add(fraction);

        } while(i < expression.length());

        return allFractions;
    }
}