package BetterCodeAnswer.Medium.Number;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/lexicographical-numbers/">386. Lexicographical Numbers</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer <code>n</code>, return all the numbers in the range <code>[1, n]</code> sorted in lexicographical order.</p>
 * 
 * <p>You must write an algorithm that runs in&nbsp;<code>O(n)</code>&nbsp;time and uses <code>O(1)</code> extra space.&nbsp;</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> n = 13
 * <strong>Output:</strong> [1,10,11,12,13,2,3,4,5,6,7,8,9]
 * </pre><p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> n = 2
 * <strong>Output:</strong> [1,2]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
 * </ul>
 * </div>
 */
public class LexicographicalNumbers {
    public static void main(String[] args) {
        int[] tests = {
            2,
            5,
            6,
        };

        for (int n : tests) {
            System.out.println(new LexicographicalNumbers_Solution().lexicalOrder(n));
        }
    }
}

// 1ms 48.36MB
class LexicographicalNumbers_Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> lexicographicalNumbers = new ArrayList<>();
        for (int start = 1; start <= 9; ++start) {
            generateLexicalNumbers(start, n, lexicographicalNumbers);
        }
        return lexicographicalNumbers;
    }

    private void generateLexicalNumbers(
        int currentNumber,
        int limit,
        List<Integer> result
    ) {
        if (currentNumber > limit) return;

        result.add(currentNumber);

        for (int nextDigit = 0; nextDigit <= 9; ++nextDigit) {
            int nextNumber = currentNumber * 10 + nextDigit;
            if (nextNumber <= limit) {
                generateLexicalNumbers(nextNumber, limit, result);
            } else {
                break; 
            }
        }
    }
}

// 5ms 48.36MB
class LexicographicalNumbers_Solution2 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> lexicographicalNumbers = new ArrayList<>();
        int currentNumber = 1;

        for (int i = 0; i < n; ++i) {
            lexicographicalNumbers.add(currentNumber);

            if (currentNumber * 10 <= n) {
                currentNumber *= 10;
            } else {
                while (currentNumber % 10 == 9 || currentNumber >= n) {
                    currentNumber /= 10;
                }
                currentNumber += 1; 
            }
        }

        return lexicographicalNumbers;
    }
}