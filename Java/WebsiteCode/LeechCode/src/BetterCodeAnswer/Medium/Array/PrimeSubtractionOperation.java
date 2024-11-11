package BetterCodeAnswer.Medium.Array;

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

// 3ms 44.27MB
class PrimeSubtractionOperation_Solution {

    public boolean primeSubOperation(int[] nums) {
        int maxElement = getMaxElement(nums);

        // Store the sieve array.
        boolean[] sieve = new boolean[maxElement + 1];
        fill(sieve, true);
        sieve[1] = false;
        for (int i = 2; i <= Math.sqrt(maxElement + 1); i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= maxElement; j += i) {
                    sieve[j] = false;
                }
            }
        }

        // Start by storing the currValue as 1, and the initial index as 0.
        int currValue = 1;
        int i = 0;
        while (i < nums.length) {
            // Store the difference needed to make nums[i] equal to currValue.
            int difference = nums[i] - currValue;

            // If difference is less than 0, then nums[i] is already less than
            // currValue. Return false in this case.
            if (difference < 0) {
                return false;
            }

            // If the difference is prime or zero, then nums[i] can be made
            // equal to currValue.
            if (sieve[difference] == true || difference == 0) {
                i++;
                currValue++;
            } else {
                // Otherwise, try for the next currValue.
                currValue++;
            }
        }
        return true;
    }

    private int getMaxElement(int[] nums) {
        int max = -1;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private void fill(boolean[] arr, boolean value) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value;
        }
    }
}