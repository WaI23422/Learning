package Medium.Number;

// import java.util.ArrayList;
// import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/smallest-value-after-replacing-with-sum-of-prime-factors/">2507. Smallest Value After Replacing With Sum of Prime Factors</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a positive integer <code>n</code>.</p>
 * 
 * <p>Continuously replace <code>n</code> with the sum of its <strong>prime factors</strong>.</p>
 * 
 * <ul>
 * 	<li>Note that if a prime factor divides <code>n</code> multiple times, it should be included in the sum as many times as it divides <code>n</code>.</li>
 * </ul>
 * 
 * <p>Return <em>the smallest value </em><code>n</code><em> will take on.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 15
 * <strong>Output:</strong> 5
 * <strong>Explanation:</strong> Initially, n = 15.
 * 15 = 3 * 5, so replace n with 3 + 5 = 8.
 * 8 = 2 * 2 * 2, so replace n with 2 + 2 + 2 = 6.
 * 6 = 2 * 3, so replace n with 2 + 3 = 5.
 * 5 is the smallest value n will take on.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 3
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> Initially, n = 3.
 * 3 is the smallest value n will take on.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * </div>
 */
public class SmallestValueAfterReplacingWithSumOfPrimeFactors {
    public static void main(String[] args) {
        int[] tests = {
            4,
            2,
            15,
            100
        };

        for (int n : tests) {
            System.out.println(new SmallestValueAfterReplacingWithSumOfPrimeFactors_Solution().smallestValue(n));
        }
    }
}

// 1ms 40.72MB -> 0ms 40.4MB
class SmallestValueAfterReplacingWithSumOfPrimeFactors_Solution {
    public int smallestValue(int n) {
        // List<Integer> appears = new ArrayList<>();

        while (!isPrime(n)) { // !(isPrime(n) || appears.contains(n))
            // appears.add(n);
            if (n == 4) { return 4;}

            int temp = 0; 
            for (int i = 2; i*i <= n; ) {
                if (n%i == 0) {
                    temp += i;
                    n/=i;
                } else {
                    i++;
                }
            }
            n = temp + (n == 1 ? 0 : n);
        }

        return n;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n%i == 0) {
                return false;
            } 
        }

        return true;
    }
}