package BetterCodeAnswer.Hard.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-the-closest-palindrome/">564. Find the Closest Palindrome</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>n</code> representing an integer, return <em>the closest integer (not including itself), which is a palindrome</em>. If there is a tie, return <em><strong>the smaller one</strong></em>.</p>
 * 
 * <p>The closest is defined as the absolute difference minimized between two integers.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = "123"
 * <strong>Output:</strong> "121"
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = "1"
 * <strong>Output:</strong> "0"
 * <strong>Explanation:</strong> 0 and 2 are the closest palindromes but we return the smallest which is 0.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n.length &lt;= 18</code></li>
 * 	<li><code>n</code> consists of only digits.</li>
 * 	<li><code>n</code> does not have leading zeros.</li>
 * 	<li><code>n</code> is representing an integer in the range <code>[1, 10<sup>18</sup> - 1]</code>.</li>
 * </ul>
 * </div>
 */
public class FindTheClosestPalindrome {
    public static void main(String[] args) {
        String[] tests = {
            "121"
        };

        for (String n : tests) {
            System.out.println(new FindTheClosestPalindrome_Solution().nearestPalindromic(n));
        }
    }
}

// 1ms 41.49MB
class FindTheClosestPalindrome_Solution {
    public String nearestPalindromic(String numberStr) {
        long number = Long.parseLong(numberStr);
        if (number <= 10) return String.valueOf(number - 1);
        if (number == 11) return "9";

        int length = numberStr.length();
        long leftHalf = Long.parseLong(numberStr.substring(0, (length + 1) / 2));
        
        long[] palindromeCandidates = new long[5];
        palindromeCandidates[0] = generatePalindromeFromLeft(leftHalf - 1, length % 2 == 0);
        palindromeCandidates[1] = generatePalindromeFromLeft(leftHalf, length % 2 == 0);
        palindromeCandidates[2] = generatePalindromeFromLeft(leftHalf + 1, length % 2 == 0);
        palindromeCandidates[3] = (long)Math.pow(10, length - 1) - 1;
        palindromeCandidates[4] = (long)Math.pow(10, length) + 1;

        long nearestPalindrome = 0;
        long minDifference = Long.MAX_VALUE;

        for (long candidate : palindromeCandidates) {
            if (candidate == number) continue;
            long difference = Math.abs(candidate - number);
            if (difference < minDifference || (difference == minDifference && candidate < nearestPalindrome)) {
                minDifference = difference;
                nearestPalindrome = candidate;
            }
        }

        return String.valueOf(nearestPalindrome);
    }

    private long generatePalindromeFromLeft(long leftHalf, boolean isEvenLength) {
        long palindrome = leftHalf;
        if (!isEvenLength) leftHalf /= 10;
        while (leftHalf > 0) {
            palindrome = palindrome * 10 + leftHalf % 10;
            leftHalf /= 10;
        }
        return palindrome;
    }
}