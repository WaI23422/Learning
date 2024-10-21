package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/partition-array-for-maximum-sum/">1043.Partition Array for Maximum Sum</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>arr</code>, partition the array into (contiguous) subarrays of length <strong>at most</strong> <code>k</code>. After partitioning, each subarray has their values changed to become the maximum value of that subarray.</p>

<p>Return <em>the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a <strong>32-bit</strong> integer.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> arr = [1,15,7,9,2,5,10], k = 3
<strong>Output:</strong> 84
<strong>Explanation:</strong> arr becomes [15,15,15,9,10,10,10]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
<strong>Output:</strong> 83
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> arr = [1], k = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 500</code></li>
	<li><code>0 &lt;= arr[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= k &lt;= arr.length</code></li>
</ul>
</div>
 */
public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,15,7,9,2,5,10},{3}},
            {{1,4,1,5,7,3,6,1,9,9,3},{4}},
            {{1},{1}},
            {{1,2,3,4},{4}}
        };

        for (int[][] test : tests) {
            int[] arr = test[0];
            int k = test[1][0];

            System.out.println(new PartitionArrayForMaximumSum_Solution().maxSumAfterPartitioning(arr, k));
        }
    }
}

// 4 ms 41.9 MB
class PartitionArrayForMaximumSum_Solution {
    int sum(int []arr,int i,int n){
        int sum=Integer.MIN_VALUE;int j=i;
        for(;i<=n;i++){
            sum=Math.max(sum,arr[i]);
        }
        return sum*(n-j+1);
    }

    public int maxSum(int[] arr, int k,int n,int[]t) {
        if(t[n]!=-1)
            return t[n];
        if(k>=n+1){
            t[n]=sum(arr,0,n);
            return t[n];
        }

        int max=Integer.MIN_VALUE;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            if(n<k)
                break;
            max=Math.max(max,arr[n-i]);
            ans=Math.max(ans,(i+1)*max+maxSum(arr,k,n-i-1,t));
            t[n]=ans;
        }
            
        return ans;
    }
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[]t=new int[arr.length];
        for(int i=0;i<t.length;i++){
            t[i]=-1;
        }

        int max=maxSum(arr,k,arr.length-1,t);
       
        return max;
    }
}

// 9 ms 41.8 MB
class PartitionArrayForMaximumSum_Solution2 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length;
        int K = k + 1;

        int[] dp = new int[k + 1];
        Arrays.fill(dp, 0);

        for (int start = N - 1; start >= 0; start--) {
            int currMax = 0;
            int end = Math.min(N, start + k);

            for (int i = start; i < end; i++) {
                currMax = Math.max(currMax, arr[i]);
                dp[start % K] = Math.max(dp[start % K], dp[(i + 1) % K] + currMax * (i - start + 1));
            }
        }
        return dp[0];
    }
}
