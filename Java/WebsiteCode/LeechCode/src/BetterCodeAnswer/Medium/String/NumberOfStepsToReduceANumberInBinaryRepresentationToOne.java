package BetterCodeAnswer.Medium.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/">1404. Number of Steps to Reduce a Number in Binary Representation to One</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the binary representation of an integer as a string <code>s</code>, return <em>the number of steps to reduce it to </em><code>1</code><em> under the following rules</em>:</p>
 * 
 * <ul>
 * 	<li>
 * 	<p>If the current number is even, you have to divide it by <code>2</code>.</p>
 * 	</li>
 * 	<li>
 * 	<p>If the current number is odd, you have to add <code>1</code> to it.</p>
 * 	</li>
 * </ul>
 * 
 * <p>It is guaranteed that you can always reach one for all test cases.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "1101"
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> "1101" corressponds to number 13 in their decimal representation.
 * Step 1) 13 is odd, add 1 and obtain 14.&nbsp;
 * Step 2) 14 is even, divide by 2 and obtain 7.
 * Step 3) 7 is odd, add 1 and obtain 8.
 * Step 4) 8 is even, divide by 2 and obtain 4.&nbsp; 
 * Step 5) 4 is even, divide by 2 and obtain 2.&nbsp;
 * Step 6) 2 is even, divide by 2 and obtain 1.&nbsp; 
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "10"
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> "10" corressponds to number 2 in their decimal representation.
 * Step 1) 2 is even, divide by 2 and obtain 1.&nbsp; 
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> s = "1"
 * <strong>Output:</strong> 0
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= s.length&nbsp;&lt;= 500</code></li>
 * 	<li><code>s</code> consists of characters '0' or '1'</li>
 * 	<li><code>s[0] == '1'</code></li>
 * </ul>
 * </div>
 */
public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    public static void main(String[] args) {
        String[] tests = {
            "1101"
        };

        for (String s : tests) {
            System.out.println(new NumberOfStepsToReduceANumberInBinaryRepresentationToOne_Solution().numSteps(s));
        }
        
    }
}

// 2 ms 41.4 MB 
class NumberOfStepsToReduceANumberInBinaryRepresentationToOne_Solution {

    private void divideByTwo(StringBuilder s) {
        s.deleteCharAt(s.length() - 1);
    }

    private void addOne(StringBuilder s) {
        int i = s.length() - 1;

        // Iterating while the character is 1 and changing to 0
        while (i >= 0 && s.charAt(i) != '0') {
            s.setCharAt(i, '0');
            i--;
        }

        if (i < 0) {
            s.insert(0, '1');
        } else {
            s.setCharAt(i, '1');
        }
    }

    public int numSteps(String s) {
        StringBuilder str = new StringBuilder(s);

        int operations = 0;
        while (str.length() > 1) {
            int N = str.length();

            if (str.charAt(N - 1) == '0') {
                divideByTwo(str);
            } else {
                addOne(str);
            }

            operations++;
        }

        return operations;
    }
}

// 1 ms 41.4 MB
class NumberOfStepsToReduceANumberInBinaryRepresentationToOne_Solution2 {

    public int numSteps(String s) {
        int N = s.length();

        int operations = 0;
        int carry = 0;
        for (int i = N - 1; i > 0; i--) {
            int digit = Character.getNumericValue(s.charAt(i)) + carry;

            if (digit % 2 == 1) {
                operations += 2;
                carry = 1;
            } else {
                operations++;
            }
        }

        return operations + carry;
    }
}