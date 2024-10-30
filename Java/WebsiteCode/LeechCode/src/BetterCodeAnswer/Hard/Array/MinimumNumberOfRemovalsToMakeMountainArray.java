package BetterCodeAnswer.Hard.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-number-of-removals-to-make-mountain-array/">1671. Minimum Number of Removals to Make Mountain Array</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You may recall that an array <code>arr</code> is a <strong>mountain array</strong> if and only if:</p>
 * 
 * <ul>
 * 	<li><code>arr.length &gt;= 3</code></li>
 * 	<li>There exists some index <code>i</code> (<strong>0-indexed</strong>) with <code>0 &lt; i &lt; arr.length - 1</code> such that:
 * 	<ul>
 * 		<li><code>arr[0] &lt; arr[1] &lt; ... &lt; arr[i - 1] &lt; arr[i]</code></li>
 * 		<li><code>arr[i] &gt; arr[i + 1] &gt; ... &gt; arr[arr.length - 1]</code></li>
 * 	</ul>
 * 	</li>
 * </ul>
 * 
 * <p>Given an integer array <code>nums</code>​​​, return <em>the <strong>minimum</strong> number of elements to remove to make </em><code>nums<em>​​​</em></code><em> </em><em>a <strong>mountain array</strong>.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,3,1]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> The array itself is a mountain array so we do not need to remove any elements.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,1,1,5,6,2,3,1]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> One solution is to remove the elements at indices 0, 1, and 5, making the array nums = [1,5,6,3,1].
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>3 &lt;= nums.length &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li>It is guaranteed that you can make a mountain array out of <code>nums</code>.</li>
 * </ul>
 * </div></div>
 */
public class MinimumNumberOfRemovalsToMakeMountainArray {
    public static void main(String[] args) {
        int[][] tests = {
            {2,3,1,3,1},
            {1,3,1},
            {2,3,1,4,1},
            {2,1,1,5,6,2,3,1},
        };

        for (int[] nums : tests) {
            System.out.println(new MinimumNumberOfRemovalsToMakeMountainArray_Solution().minimumMountainRemovals(nums));
        }
    }
}

/**
 * 6ms 44.88MB
 */
class MinimumNumberOfRemovalsToMakeMountainArray_Solution {
    public int minimumMountainRemovals(int[] nums) {
               int n=nums.length;
        int[] lis=new int[n];
        int[] lis1=new int[n];
        int[] dp=new int[n];
        int[] dp1=new int[n];
        int len=0;
        int j=0;
        for(int a:nums){
            int i= Arrays.binarySearch(lis,0,len,a);
            if(i<0){
                i=-(i+1);
            }
            lis[i]=a;
            if(len==i){
                len++;
            dp[j]=len;
            }else{
                dp[j]=i+1;
            }
            j++;
        }
        int len1=0;
        for(int i=n-1;i>=0;i--){
            int k=Arrays.binarySearch(lis1,0,len1,nums[i]);
            if(k<0){
                k=-(k+1);
            }
            lis1[k]=nums[i];
            if(len1==k){
                len1++;
            dp1[i]=len1;
            }else{
                dp1[i]=k+1;
            }
        }
        int max=0;
        for(int i=1;i<n-1;i++){
            if(dp[i]>1 && dp1[i]>1)
                max=Math.max(max,dp[i]+dp1[i]);
        }
        return n-max+1;
    }
}