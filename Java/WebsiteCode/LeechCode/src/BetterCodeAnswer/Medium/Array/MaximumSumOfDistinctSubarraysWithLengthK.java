package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximum-sum-of-distinct-subarrays-with-length-k/">2461. Maximum Sum of Distinct Subarrays With Length K</a>
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given an integer array <code>nums</code> and an integer <code>k</code>. Find the maximum subarray sum of all the subarrays of <code>nums</code> that meet the following conditions:</p>
 * 
 * <ul>
 * 	<li>The length of the subarray is <code>k</code>, and</li>
 * 	<li>All the elements of the subarray are <strong>distinct</strong>.</li>
 * </ul>
 * 
 * <p>Return <em>the maximum subarray sum of all the subarrays that meet the conditions</em><em>.</em> If no subarray meets the conditions, return <code>0</code>.</p>
 * 
 * <p><em>A <strong>subarray</strong> is a contiguous non-empty sequence of elements within an array.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,5,4,2,9,9,9], k = 3
 * <strong>Output:</strong> 15
 * <strong>Explanation:</strong> The subarrays of nums with length 3 are:
 * - [1,5,4] which meets the requirements and has a sum of 10.
 * - [5,4,2] which meets the requirements and has a sum of 11.
 * - [4,2,9] which meets the requirements and has a sum of 15.
 * - [2,9,9] which does not meet the requirements because the element 9 is repeated.
 * - [9,9,9] which does not meet the requirements because the element 9 is repeated.
 * We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [4,4,4], k = 3
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> The subarrays of nums with length 3 are:
 * - [4,4,4] which does not meet the requirements because the element 4 is repeated.
 * We return 0 because no subarrays meet the conditions.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= k &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * </div></div>
 */
public class MaximumSumOfDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        int[][][] tests= {
            {
                {1,5,4,2,9,9,9},
                {3}
            }
        };

        for (int[][] test : tests) {
            int nums[] = test[0],
                k = test[1][0];

            System.out.println(new MaximumSumOfDistinctSubarraysWithLengthK_Solution().maximumSubarraySum(nums, k));
        }
    }   
}

// 4ms 60.52MB
class MaximumSumOfDistinctSubarraysWithLengthK_Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int maxNum = 0;
        for(int num:nums){
            maxNum = Math.max(maxNum,num);
        }
        int[] counts = new int[maxNum+1];
        int dupCount=0;
        long totalSum=0;
        long curSum =0;
        for(int i =0;i<k;i++){
            if(counts[nums[i]]>=1){
                dupCount++;
            }
            counts[nums[i]]++;
            curSum+= nums[i];
        }
        if(dupCount==0){
            totalSum=curSum;
        }
        for(int i =k;i<nums.length;i++){
            if(counts[nums[i]]>=1){
                dupCount++;
            }
            counts[nums[i]]++;
            curSum+= nums[i];  
            if(counts[nums[i-k]]>1){
                dupCount--;
            }
            counts[nums[i-k]]--;
            curSum-=nums[i-k];
            if(dupCount==0){
                totalSum = Math.max(totalSum,curSum);
            } 
        }
        return totalSum;
    }
}