package Medium.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/ugly-number-ii/">264. Ugly Number II</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>An <strong>ugly number</strong> is a positive integer whose prime factors are limited to <code>2</code>, <code>3</code>, and <code>5</code>.</p>
 * 
 * <p>Given an integer <code>n</code>, return <em>the</em> <code>n<sup>th</sup></code> <em><strong>ugly number</strong></em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 10
 * <strong>Output:</strong> 12
 * <strong>Explanation:</strong> [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 1
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 1690</code></li>
 * </ul>
 * </div>
 */
public class UglyNumberII {
    public static void main(String[] args) {
        int[] tests = {
            3,
            5,
            10
        };

        for (int n : tests) {
            System.out.println(new UglyNumberII_Solution().nthUglyNumber(n));
        }
    }
}

// Time Limit Exceeded
class UglyNumberII_Solution1 {
    public int nthUglyNumber(int n) {
        int count = 0,
            ugly_last = 0,
            num = 1;
        while (count < n) {
            if (isUgly(num)) {
                count++;
                ugly_last = num;
            }
            num++;
        }

        return ugly_last;
    }

    private boolean isUgly(int num){
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }
}

// 2ms 41.91MB
class UglyNumberII_Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        for(int i=1;i<n;i++){

            int twoMul = dp[p1] * 2;
            int threeMul = dp[p2] * 3;
            int fiveMul = dp[p3] * 5;

            dp[i] = Math.min(twoMul, Math.min(threeMul,fiveMul ));

            if(dp[i] == twoMul) p1++;
            if(dp[i] == threeMul) p2++;
            if(dp[i] ==  fiveMul) p3++;
            
        }

        return dp[n-1];

    }
}