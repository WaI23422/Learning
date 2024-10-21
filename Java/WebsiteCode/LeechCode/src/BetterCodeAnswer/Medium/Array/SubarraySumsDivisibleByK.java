package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/subarray-sums-divisible-by-k/">974. Subarray Sums Divisible by K</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <em>the number of non-empty <strong>subarrays</strong> that have a sum divisible by </em><code>k</code>.</p>
 * 
 * <p>A <strong>subarray</strong> is a <strong>contiguous</strong> part of an array.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [4,5,0,-2,-3,1], k = 5
 * <strong>Output:</strong> 7
 * <strong>Explanation:</strong> There are 7 subarrays with a sum divisible by k = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [5], k = 9
 * <strong>Output:</strong> 0
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
 * 	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>2 &lt;= k &lt;= 10<sup>4</sup></code></li>
 * </ul>
 * </div>
 * 
 */
public class SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {5},
                {9}
            },
            {
                {4,5,0,-2,-3,1},
                {5}
            }
        };

        for (int[][] test : tests) {
            int nums[] = test[0],
                k = test[1][0];

            System.out.println(new SubarraySumsDivisibleByK_Solution().subarraysDivByK(nums, k));
        }
    }
}

// 2 ms 45.7 MB
class SubarraySumsDivisibleByK_Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Use counting array to record the frequency of all the prefix sum remainders.
        int[] counting = new int[k];
        for (int i = 0, remainder = 0; i < nums.length; i++) {
            // Note that the integer in 'nums' can be negative.
            // Thus, we need to adjust the negative remainder to positive remainder.
            // Below accounts for both negative and positive remainders.
            // We can also check if the remainder is negative, then add a 'k' to make the remainder positive.
            // For Example, nums = [-2,3,2], k = 5,
            // remainder for the prefix sum of [-2,1,3] are -2, 1 and 3 respectively.
            // We know that [3,2] sum to 5, which is divisible by 5.
            // After converting -2 to 3, by adding 5, it has the same remainder with prefix sum 3.
            remainder = ((remainder + nums[i]) % k + k) % k;
            counting[remainder]++;
        }

        // The result contains all the prefix sum with remainder 0,
        // as all the prefix sum with remainder of 0 is itself divisible by 'k'.
        // However, do note that the prefix sum with remainder 0 also able to form subarray sums that is divisible by 'k'
        // with one another, which will be calculated next.
        // For Example: nums = [5,5,5,5], k = 5,
        // The prefix sum of [5,10,15,20] are themselves divisible by 5, while also forming subarray sums divisible by 5
        // with 10 [5,5] - 5 [5] == 5, 15 [5,5,5] - 5 [5] == 10, etc.
        int result = counting[0];

        // The prefix sums with the same remainder can form subarray sums that is divisible by 'k' with each other.
        // For each remainder, the number of subarray that is divisible by 'k' is the number of combinations from the frequency.
        // Equation for the number of combinations of n items is n * "(n - 1) / 2".
        for (int frequency : counting)
            result += frequency * (frequency - 1) / 2;

        return result;
    }
}