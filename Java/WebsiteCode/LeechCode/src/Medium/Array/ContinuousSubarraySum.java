package Medium.Array;

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

// Time Limit Exceed
class ContinuousSubarraySum_Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        
        for (int start = 0; start < n - 1; start++) {
            for (int end = start + 1; end < n; end++) {
                int subarraySum = 0;
                for (int i = start; i <= end; i++) {
                    subarraySum += nums[i];
                }
                
                if (subarraySum == 0 && k == 0) { 
                    return true;
                }
                if (k != 0 && subarraySum % k == 0) {
                    return true;
                }
            }
        }
        
        return false;
    }
}