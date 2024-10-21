package Medium.Number;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/2-keys-keyboard/">650. 2 Keys Keyboard</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There is only one character <code>'A'</code> on the screen of a notepad. You can perform one of two operations on this notepad for each step:</p>
 * 
 * <ul>
 * 	<li>Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).</li>
 * 	<li>Paste: You can paste the characters which are copied last time.</li>
 * </ul>
 * 
 * <p>Given an integer <code>n</code>, return <em>the minimum number of operations to get the character</em> <code>'A'</code> <em>exactly</em> <code>n</code> <em>times on the screen</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 3
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> Initially, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 1
 * <strong>Output:</strong> 0
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 1000</code></li>
 * </ul>
 * </div>
 */
public class TwoKeysKeyboard {
    public static void main(String[] args) {
        int[] tests = {
            // 1,2,3,4,5,
            // 6,
            // 10,
            9,
            1000
        };

        for (int n : tests) {
            System.out.println(new TwoKeysKeyboard_Solution().minSteps(n));
        }
    }
}

// 112ms 40.20MB
class PrimeNums{
    boolean[] prime_1000 = new boolean[1001];

    PrimeNums() {
        Arrays.fill(prime_1000, true);
        for (int i = 2; i < prime_1000.length; i++) {
            if (prime_1000[2]) {
                for (int j = i+1; j < prime_1000.length; j++) {
                    if (j%i==0) { prime_1000[j] = false; }
                }
            }
        }
    }
}

class TwoKeysKeyboard_Solution1 {
    public int minSteps(int n) {
        if (n == 1) {return 0;}
        
        PrimeNums rangePrime = new PrimeNums();

        if (rangePrime.prime_1000[n]) {return n;}

        int min = 0;
        for (int i = 2; i < 1000; i++) {
            if (rangePrime.prime_1000[i]) {
                while (n%i == 0) {
                    n /= i;
                    min += i;
                }
            }
        }

        return min;
    }
}

// 0ms 40.47MB
class TwoKeysKeyboard_Solution {
    public int minSteps(int n) {
        if (n == 1) {return 0;}

        if (isPrime(n)) {return n;}

        int[] prime_1000 = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,521,523,541,547,557,563,569,571,577,587,593,599,601,607,613,617,619,631,641,643,647,653,659,661,673,677,683,691,701,709,719,727,733,739,743,751,757,761,769,773,787,797,809,811,821,823,827,829,839,853,857,859,863,877,881,883,887,907,911,919,929,937,941,947,953,967,971,977,983,991,997};
        int min = 0;

        for (int p : prime_1000) {
            if (n == 1) {break;}

            while (n%p == 0) {
                n /= p;
                min += p;    
            }
        }

        return min;
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