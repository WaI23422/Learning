package BetterCodeAnswer.Medium.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/largest-divisible-subset/">368.Largest Divisible Subset</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a set of <strong>distinct</strong> positive integers <code>nums</code>, return the largest subset <code>answer</code> such that every pair <code>(answer[i], answer[j])</code> of elements in this subset satisfies:</p>

<ul>
	<li><code>answer[i] % answer[j] == 0</code>, or</li>
	<li><code>answer[j] % answer[i] == 0</code></li>
</ul>

<p>If there are multiple solutions, return any of them.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> [1,2]
<strong>Explanation:</strong> [1,3] is also accepted.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,4,8]
<strong>Output:</strong> [1,2,4,8]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 2 * 10<sup>9</sup></code></li>
	<li>All the integers in <code>nums</code> are <strong>unique</strong>.</li>
</ul>
</div>
 */
public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[][] tests = {
            {1,2,3},
            {1,2,4,8},
            {1},
            {1,2,3,7,14,28}
        };

        for (int[] nums : tests) {
            System.out.println(new LargestDivisibleSubset_Solution().largestDivisibleSubset(nums).toString());
        }
    }
}

// 12 ms 42.5 MB
class LargestDivisibleSubset_Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        Arrays.sort(nums);
        int[] hash = new int[nums.length];
        int maxi = -1;
        int lastIndex = 0;
        for(int index=0;index<nums.length;index++){
            hash[index] = index;
            for(int col=0;col<index;col++){
                
                if(nums[index]%nums[col]==0 && 1 + dp[col] > dp[index]){
                    dp[index] = 1 + dp[col];
                    hash[index] = col;
                }
            }
            if(dp[index]>maxi){
                maxi = dp[index];
                lastIndex = index;
            }
        } 
        List<Integer> lst = new ArrayList<Integer>();
        lst.add(nums[lastIndex]);
        while(hash[lastIndex]!=lastIndex){
            lastIndex = hash[lastIndex];
            lst.add(nums[lastIndex]);
        }
        return lst;
    }
    
}