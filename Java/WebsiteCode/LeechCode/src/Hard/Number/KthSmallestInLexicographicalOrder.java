package Hard.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/k-th-smallest-in-lexicographical-order/">440. K-th Smallest in Lexicographical Order</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given two integers <code>n</code> and <code>k</code>, return <em>the</em> <code>k<sup>th</sup></code> <em>lexicographically smallest integer in the range</em> <code>[1, n]</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 13, k = 2
 * <strong>Output:</strong> 10
 * <strong>Explanation:</strong> The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 1, k = 1
 * <strong>Output:</strong> 1
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= k &lt;= n &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div>
 */
public class KthSmallestInLexicographicalOrder {
    public static void main(String[] args) {
        int[][] tests = {
            // {804289384,42641503},
            {13,2},
            {13,8},
            {1,1}
        };

        for (int[] test : tests) {
            int n = test[0],
                k = test[1];

            System.out.println(new KthSmallestInLexicographicalOrder_Solution().findKthNumber(n, k));
        }
    }
}

// Time Limit Exceeded
class KthSmallestInLexicographicalOrder_Solution {
    int idx = 0,
        number = 0;
    public int findKthNumber(int n, int k) {
        for (int i = 1; i <= 9; ++i) {
            if (++idx == k) {return i;}
            lexicographicalNum(i, n, k);
        }

        return number;
    }

    public void lexicographicalNum(int currentNumber, int limit, int k) {
        if (currentNumber > limit) return ;

        for (int nextDigit = 0; nextDigit <= 9; ++nextDigit) {
            int nextNumber = currentNumber * 10 + nextDigit;
            if (nextNumber <= limit) {
                if (++idx == k) {
                    number = nextNumber;
                    break;
                }
                lexicographicalNum(nextNumber, limit, k);
            } else {
                break ; 
            }
        }
    }
}