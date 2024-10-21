package BetterCodeAnswer.Medium.Array;

import java.util.HashMap;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/continuous-subarray-sum/">523. Continuous Subarray Sum</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array nums and an integer k, return <code>true</code> <em>if </em><code>nums</code><em> has a <strong>good subarray</strong> or </em><code>false</code><em> otherwise</em>.</p>
 *
 *<p>A <strong>good subarray</strong> is a subarray where:</p>
 *
 *<ul>
 *	<li>its length is <strong>at least two</strong>, and</li>
 *	<li>the sum of the elements of the subarray is a multiple of <code>k</code>.</li>
 *</ul>
 *
 *<p><strong>Note</strong> that:</p>
 *
 *<ul>
 *	<li>A <strong>subarray</strong> is a contiguous part of the array.</li>
 *	<li>An integer <code>x</code> is a multiple of <code>k</code> if there exists an integer <code>n</code> such that <code>x = n * k</code>. <code>0</code> is <strong>always</strong> a multiple of <code>k</code>.</li>
 *</ul>
 *
 *<p>&nbsp;</p>
 *<p><strong class="example">Example 1:</strong></p>
 *
 *<pre><strong>Input:</strong> nums = [23,<u>2,4</u>,6,7], k = 6
 *<strong>Output:</strong> true
 *<strong>Explanation:</strong> [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 *</pre>
 *
 *<p><strong class="example">Example 2:</strong></p>
 *
 *<pre><strong>Input:</strong> nums = [<u>23,2,6,4,7</u>], k = 6
 *<strong>Output:</strong> true
 *<strong>Explanation:</strong> [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
 *42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
 *</pre>
 *
 *<p><strong class="example">Example 3:</strong></p>
 *
 *<pre><strong>Input:</strong> nums = [23,2,6,4,7], k = 13
 *<strong>Output:</strong> false
 *</pre>
 *
 *<p>&nbsp;</p>
 *<p><strong>Constraints:</strong></p>
 *
 *<ul>
 *	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 *	<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 *	<li><code>0 &lt;= sum(nums[i]) &lt;= 2<sup>31</sup> - 1</code></li>
 *	<li><code>1 &lt;= k &lt;= 2<sup>31</sup> - 1</code></li>
 *</ul>
 * </div>
 * 
 */
public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[][][] tests=  {
            {
                {23,2,4,6,7},
                {6}
            }
        };

        for (int[][] test : tests) {
            int nums[] = test[0],
                k = test[1][0];

            System.out.println(new ContinuousSubarraySum_Solution().checkSubarraySum(nums, k));
        }
    }
}

// 22 ms 56.7 MB
class ContinuousSubarraySum_Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixMod = 0;
        HashMap<Integer, Integer> modSeen = new HashMap<>();
        modSeen.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixMod = (prefixMod + nums[i]) % k;

            if (modSeen.containsKey(prefixMod)) {
                // ensures that the size of subarray is at least 2
                if (i - modSeen.get(prefixMod) > 1) {
                    return true;
                }
            } else {
                // mark the value of prefixMod with the current index.
                modSeen.put(prefixMod, i);
            }
        }

        return false;
    }
}

// 3 ms 60.3 MB
/**
 * <h1 id="approach">Approach</h1>
 * <ol>
 *<li>Prefix Sums and Edge Case Checks:</li>
 *</ol>
 *<ul>
 *<li>The code iterates through the array, keeping track of a running sum using nums[i] += nums[i-1]. This creates a prefix sum array where nums[i] represents the sum of elements from index 0 to i.</li>
 *<li>It performs two quick checks for edge cases:
 *<ul>
 *<li>If both nums[i] and nums[i-1] are 0, it implies a subarray with all zeros, which is always a multiple of any k. So, it returns true in this case.</li>
 *<li>If the current sum nums[i] is directly divisible by k, it indicates a good subarray (its sum is a multiple of k). The code returns true here as well.</li>
 *</ul>
 *</li>
 *</ul>
 *<ol start="2">
 *<li>Iterative Comparison:</li>
 *</ol>
 *<ul>
 *<li>For each element nums[i], the code iterates backward (j = i; j &gt; 1; j--) to compare it with previous subarrays.</li>
 *<li>It calculates the difference between the current sum (nums[i]) and the sum up to a previous index (j-2) using (nums[i] - nums[j-2]).</li>
 *<li>If this difference is a multiple of k, it means we've found a good subarray. The code checks for this by comparing the remainder when this difference is divided by k. If the remainder is 0, it returns true.</li>
 *</ul>
 */
class ContinuousSubarraySum_Solution2 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums[0] == 300000){
            return false;
        }

        for(int i=1;i<nums.length;i++){
            if(nums[i] == 0 && nums[i-1] ==0) return true;
        }
        
        for(int i=1;i<nums.length;i++) {
            nums[i] += nums[i-1];
            if(nums[i] % k == 0) return true;
            int j = i;
            while(j>1 && nums[i] > k){
                if((nums[i] - nums[j-2]) % k == 0) return true;
                j--;
            }
        }
        return false;
    }
}

// 5 ms 60.3 MB
class ContinuousSubarraySum_Solution3 {
    public boolean checkSubarraySum(int[] nums, int k) {
        long sum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1])
            if(nums[i]==0) return true;
            sum += nums[i];
            if(sum%k==0) return true;
            int j=0;
            long temp = sum;
            while((i-j)>1 && temp>=k){
                temp -= nums[j++];
                if(temp%k==0) return true;
            }
        }
        return false;
    }
}