package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximum-value-of-an-ordered-triplet-i/">2873. Maximum Value of an Ordered Triplet I</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> integer array <code>nums</code>.</p>
 * 
 * <p>Return <em><strong>the maximum value over all triplets of indices</strong></em> <code>(i, j, k)</code> <em>such that</em> <code>i &lt; j &lt; k</code>. If all such triplets have a negative value, return <code>0</code>.</p>
 * 
 * <p>The <strong>value of a triplet of indices</strong> <code>(i, j, k)</code> is equal to <code>(nums[i] - nums[j]) * nums[k]</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [12,6,1,2,7]
 * <strong>Output:</strong> 77
 * <strong>Explanation:</strong> The value of the triplet (0, 2, 4) is (nums[0] - nums[2]) * nums[4] = 77.
 * It can be shown that there are no ordered triplets of indices with a value greater than 77. 
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,10,3,4,19]
 * <strong>Output:</strong> 133
 * <strong>Explanation:</strong> The value of the triplet (1, 2, 4) is (nums[1] - nums[2]) * nums[4] = 133.
 * It can be shown that there are no ordered triplets of indices with a value greater than 133.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,2,3]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> The only ordered triplet of indices (0, 1, 2) has a negative value of (nums[0] - nums[1]) * nums[2] = -3. Hence, the answer would be 0.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>3 &lt;= nums.length &lt;= 100</code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
 * </ul>
 * </div>
 */
public class MaximumValueOfAnOrderedTripletI {
    public static void main(String[] args) {
        int[][] tests = {
            {1000000,1,1000000},
            {12,6,1,2,7}
        };

        for (int[] nums : tests) {
            System.out.println(new MaximumValueOfAnOrderedTripletI_Solution().maximumTripletValue(nums));
        }
    }
}

// 1ms 42.43MB
class MaximumValueOfAnOrderedTripletI_Solution {
    public long maximumTripletValue(int[] nums) {
        
        long ans = 0;
        int maxDiff = 0; 
        int maxNum = 0;  

        for (int num : nums) {
            ans = Math.max(ans, (long) maxDiff * num);
            maxDiff = Math.max(maxDiff, maxNum - num); 
            maxNum = Math.max(maxNum, num);           
        }
        return ans;
    }
}