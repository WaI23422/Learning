package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/prime-subtraction-operation/">2601. Prime Subtraction Operation</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> integer array <code>nums</code> of length <code>n</code>.</p>
 * 
 * <p>You can perform the following operation as many times as you want:</p>
 * 
 * <ul>
 * 	<li>Pick an index <code>i</code> that you haven’t picked before, and pick a prime <code>p</code> <strong>strictly less than</strong> <code>nums[i]</code>, then subtract <code>p</code> from <code>nums[i]</code>.</li>
 * </ul>
 * 
 * <p>Return <em>true if you can make <code>nums</code> a strictly increasing array using the above operation and false otherwise.</em></p>
 * 
 * <p>A <strong>strictly increasing array</strong> is an array whose each element is strictly greater than its preceding element.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [4,9,6,10]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> In the first operation: Pick i = 0 and p = 3, and then subtract 3 from nums[0], so that nums becomes [1,9,6,10].
 * In the second operation: i = 1, p = 7, subtract 7 from nums[1], so nums becomes equal to [1,2,6,10].
 * After the second operation, nums is sorted in strictly increasing order, so the answer is true.</pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [6,8,11,12]
 * <strong>Output:</strong> true
 * <strong>Explanation: </strong>Initially nums is sorted in strictly increasing order, so we don't need to make any operations.</pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [5,8,3]
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> It can be proven that there is no way to perform operations to make nums sorted in strictly increasing order, so the answer is false.</pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 1000</code></li>
 * 	<li><code><font face="monospace">nums.length == n</font></code></li>
 * </ul>
 * </div></div>
 */
public class PrimeSubtractionOperation {
    public static void main(String[] args) {
        int[][] tests = {
            {2,2},
            {8,19,3,4,9}
        };

        for (int[] nums : tests) {
            System.out.println(new PrimeSubtractionOperation_Solution().primeSubOperation(nums));
        }
    }
}

// 5ms 43.9MB
class PrimeSubtractionOperation_Solution1 {
    public boolean primeSubOperation(int[] nums) {
        final int[] primes_1000 = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};
        int len = nums.length,
            prev = -1;


        for (int i = 0; i < len; i++) {
            int idx = 0,
                num = nums[i],
                min = num;
            while (idx < primes_1000.length && primes_1000[idx] < num) {
                min = num - primes_1000[idx++];
            }
            
            while (min <= prev && idx >= 1) {
                if (idx == 1) {
                    min += primes_1000[--idx];
                } else {
                    min += primes_1000[--idx] - primes_1000[idx-1];
                }
            }
            
            if (min <= prev) {return false;}
            prev = min;
        }

        return true;

    }
}

// 117ms 44.31MB
class PrimeSubtractionOperation_Solution {
    public boolean[] findPrime(int range){
        boolean[] not_primes = new boolean[range+1];

        not_primes[1] = true;
        for (int i = 2; i < not_primes.length; i++) {
            if (!not_primes[i]) {
                for (int j = i+1; j < not_primes.length; j++) {
                    if (j%i == 0) {not_primes[j] = true;}
                }
            }
        }

        return not_primes;
    }

    public boolean primeSubOperation(int[] nums) {
        boolean[] not_prime = findPrime(1000); 
        int len = nums.length,
            prev = -1;

        for (int i = 0; i < len; i++) {
            int num = nums[i],
                idx = num-1,
                min = num;
            while (idx >= 0) {
                if (!not_prime[idx]) {
                    min = num - idx;
                    if (min > prev) {break;}
                }
                idx--;
            }

            if (min <= prev) {
                return false;
            }
            prev = min;
        }

        return true;

    }
}