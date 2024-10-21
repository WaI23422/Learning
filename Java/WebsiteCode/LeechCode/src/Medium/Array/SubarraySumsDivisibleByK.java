package Medium.Array;

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

// Time Limit Exceeded
class SubarraySumsDivisibleByK_Solution1 {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0,
            cnt = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum%k == 0) {cnt++;}

            int preSum = sum,
                j = 0;
            while (j < i) {
                preSum -= nums[j++];
                if (preSum%5 == 0) {cnt++;}
            }
        }

        return cnt;
    }
}

// 4 ms 46 MB
class SubarraySumsDivisibleByK_Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int rm[] = new int[k],
            prefixSumRm = 0,
            cnt = 0;
        
        rm[0] = 1;
        for (int num : nums) {
            prefixSumRm = (prefixSumRm + num % k+k) % k;

            cnt += rm[prefixSumRm];
            rm[prefixSumRm]++;
        }

        return cnt;
    }
}