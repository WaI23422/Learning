package BetterCodeAnswer.Hard.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/integer-to-english-words/">273. Integer to English Words</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Convert a non-negative integer <code>num</code> to its English words representation.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> num = 123
 * <strong>Output:</strong> "One Hundred Twenty Three"
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> num = 12345
 * <strong>Output:</strong> "Twelve Thousand Three Hundred Forty Five"
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> num = 1234567
 * <strong>Output:</strong> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= num &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 * </div>
 */
public class IntegerToEnglishWords {
    public static void main(String[] args) {
        int[] tests = {
            2147483647,
            1,
            0,
            12,
            120012,
        };

        for (int num : tests) {
            System.out.println(new IntegerToEnglishWords_Solution().numberToWords(num));
        }
    }
}

// 1ms 43.08MB
class IntegerToEnglishWords_Solution {

    private final String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helper(num);
    }

    private String helper(int num) {
        StringBuilder result = new StringBuilder();
        if (num < 20) {
            result.append(belowTwenty[num]);
        } else if (num < 100) {
            result.append(tens[num / 10]).append(" ").append(belowTwenty[num % 10]);
        } else if (num < 1000) {
            result.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        } else if (num < 1000000) {
            result.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        } else if (num < 1000000000) {
            result.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        } else {
            result.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
        }
        return result.toString().trim();
    }
}