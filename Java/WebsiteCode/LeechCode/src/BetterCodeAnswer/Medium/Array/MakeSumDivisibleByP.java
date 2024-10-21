package BetterCodeAnswer.Medium.Array;

import java.util.HashMap;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/make-sum-divisible-by-p/">1590. Make Sum Divisible by P</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given an array of positive integers <code>nums</code>, remove the <strong>smallest</strong> subarray (possibly <strong>empty</strong>) such that the <strong>sum</strong> of the remaining elements is divisible by <code>p</code>. It is <strong>not</strong> allowed to remove the whole array.</p>
 * 
 * <p>Return <em>the length of the smallest subarray that you need to remove, or </em><code>-1</code><em> if it's impossible</em>.</p>
 * 
 * <p>A <strong>subarray</strong> is defined as a contiguous block of elements in the array.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [3,1,4,2], p = 6
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The sum of the elements in nums is 10, which is not divisible by 6. We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [6,3,5,2], p = 9
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> We cannot remove a single element to get a sum divisible by 9. The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,2,3], p = 3
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> Here the sum is 6. which is already divisible by 3. Thus we do not need to remove anything.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>1 &lt;= p &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div></div>
 * 
 */
public class MakeSumDivisibleByP {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {3,1,4,2},
                {6}
            },
            {
                {6,3,5,2},
                {9}
            },
        };

        for (int[][] test : tests) {
            int nums[] = test[0],
                p = test[1][0];

            System.out.println(new MakeSumDivisibleByP_Solution().minSubarray(nums, p));
        }
    }
}

// 22ms 55.68MB
class MakeSumDivisibleByP_Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        double sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % p == 0.0)
            return 0;
        HashMap<Integer, Integer> mh = new HashMap<>();
        sum %= p;
        int s = (int)(sum);
        int len = n, mod = 0;
        for (int i = 0; i < n; i++) {
            if (len == 1)
                return 1;
            mod = (nums[i] + mod) % p;
            mh.put(mod, i);
            if (s == mod)
                len = Math.min(i + 1, len);
            if (mh.get((mod + p - s) % p) != null) 
                len = Math.min(len, i -  mh.get((mod + p - s) % p));
        }
        if(len==n)
            return -1;
        return len;
    }
}