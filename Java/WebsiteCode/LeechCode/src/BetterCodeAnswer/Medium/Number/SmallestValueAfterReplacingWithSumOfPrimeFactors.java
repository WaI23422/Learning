package BetterCodeAnswer.Medium.Number;

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

// 0ms 40.54MB
class SmallestValueAfterReplacingWithSumOfPrimeFactors_Solution {
    public int smallestValue(int n) {
        if(isPrime(n)) return n; // otherwise it will run forever
        int sum = getPrimeFactorSum(n);
        if(sum == n) return n;  // otherwise it will run forever
        return smallestValue(sum);
    }
    
    public boolean isPrime(int n) { // to check if number is prime
        if(n == 2) return true;
        for(int i = 2; i < Math.sqrt(n) + 1; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    
    public int getFirstPrimeFactor(int n) { // to get first prime number
        if(isPrime(n)) return n;
        for(int i = 2; i < n; i++) {
            if(n % i == 0) return i;
        }
        return n;
    }

    public int getPrimeFactorSum(int n) { //sum of prime factors of a number
        int sum = 0;
        while(!isPrime(n)) {
            int m = getFirstPrimeFactor(n);
            n /= m;
            sum += m;
        }
        sum += n;
        return sum;
    }
    
}