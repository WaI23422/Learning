package Hard.Array;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/max-dot-product-of-two-subsequences/">1458.Max Dot Product of Two Subsequences</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given two arrays <code>nums1</code>&nbsp;and <code><font face="monospace">nums2</font></code><font face="monospace">.</font></p>

<p>Return the maximum dot product&nbsp;between&nbsp;<strong>non-empty</strong> subsequences of nums1 and nums2 with the same length.</p>

<p>A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie,&nbsp;<code>[2,3,5]</code>&nbsp;is a subsequence of&nbsp;<code>[1,2,3,4,5]</code>&nbsp;while <code>[1,5,3]</code>&nbsp;is not).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums1 = [2,1,-2,5], nums2 = [3,0,-6]
<strong>Output:</strong> 18
<strong>Explanation:</strong> Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
Their dot product is (2*3 + (-2)*(-6)) = 18.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums1 = [3,-2], nums2 = [2,-6,7]
<strong>Output:</strong> 21
<strong>Explanation:</strong> Take subsequence [3] from nums1 and subsequence [7] from nums2.
Their dot product is (3*7) = 21.</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums1 = [-1,-1], nums2 = [1,1]
<strong>Output:</strong> -1
<strong>Explanation: </strong>Take subsequence [-1] from nums1 and subsequence [1] from nums2.
Their dot product is -1.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 500</code></li>
	<li><code>-1000 &lt;= nums1[i], nums2[i] &lt;= 1000</code></li>
</ul>
</div></div>
 */
public class MaxDotProductOfTwoSubsequences {
    public static void main(String[] args) {
        int[] nums1 = {2,1,-2,5};
        int[] nums2 = {3,0,-6};

        MaxDotProductOfTwoSubsequences_Solution result = new MaxDotProductOfTwoSubsequences_Solution();

        System.out.println(result.maxDotProduct(nums1, nums2));
    }
}

class MaxDotProductOfTwoSubsequences_Solution {
    int[][] memo;
    
    public int dp(int i, int j, int[] nums1, int[] nums2) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }
        
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        
        int use = nums1[i] * nums2[j] + dp(i + 1, j + 1, nums1, nums2);
        memo[i][j] = Math.max(use, Math.max(dp(i + 1, j, nums1, nums2), dp(i, j + 1, nums1, nums2)));
        return memo[i][j];
    }
    
    // 9 ms
    // 42.3 MB
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for (int num: nums1) {
            firstMax = Math.max(firstMax, num);
            firstMin = Math.min(firstMin, num);
        }
        
        for (int num: nums2) {
            secondMax = Math.max(secondMax, num);
            secondMin = Math.min(secondMin, num);
        }
        
        if (firstMax < 0 && secondMin > 0) {
            return firstMax * secondMin;
        }
        
        if (firstMin > 0 && secondMax < 0) {
            return firstMin * secondMax;
        }
        
        memo = new int[nums1.length][nums2.length];
        return dp(0, 0, nums1, nums2);
    }
}