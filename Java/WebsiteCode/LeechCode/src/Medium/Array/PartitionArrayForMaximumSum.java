package Medium.Array;


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

// 6 ms 42.5 MB
class PartitionArrayForMaximumSum_Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length+1];
        for(int index=arr.length-1;index>=0;index--){
            int max = Integer.MIN_VALUE;
            int ans = Integer.MIN_VALUE;
            int len = 0;   
            for(int i=index;i<index+k && i<arr.length;i++){
                len++;                                                                    
                max = Math.max(max, arr[i]);
                ans = Math.max(ans, len*max + dp[i+1]);
            }
            dp[index] =  ans;
        }
        return dp[0];
    }
}