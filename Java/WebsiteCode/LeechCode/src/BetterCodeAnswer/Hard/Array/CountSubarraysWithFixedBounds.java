package BetterCodeAnswer.Hard.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/count-subarrays-with-fixed-bounds/">2444.Count Subarrays With Fixed Bounds</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an integer array <code>nums</code> and two integers <code>minK</code> and <code>maxK</code>.</p>

<p>A <strong>fixed-bound subarray</strong> of <code>nums</code> is a subarray that satisfies the following conditions:</p>

<ul>
	<li>The <strong>minimum</strong> value in the subarray is equal to <code>minK</code>.</li>
	<li>The <strong>maximum</strong> value in the subarray is equal to <code>maxK</code>.</li>
</ul>

<p>Return <em>the <strong>number</strong> of fixed-bound subarrays</em>.</p>

<p>A <strong>subarray</strong> is a <strong>contiguous</strong> part of an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,3,5,2,7,5], minK = 1, maxK = 5
<strong>Output:</strong> 2
<strong>Explanation:</strong> The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,1,1,1], minK = 1, maxK = 1
<strong>Output:</strong> 10
<strong>Explanation:</strong> Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i], minK, maxK &lt;= 10<sup>6</sup></code></li>
</ul>
</div>
 */
public class CountSubarraysWithFixedBounds {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,1,1,1},{1},{1}},
            {{3,5,4,2,3,5,1,7,2,5},{2},{5}},
            {{1,3,5,2,1,7,5},{1},{5}},
            {{1,3,5,2,7,5},{1},{5}},
        };
    
        for (int[][] test : tests) {
            int minK = test[1][0],
                maxK = test[2][0];
            int[] nums = test[0];

            System.out.println(new CountSubarraysWithFixedBounds_Solution().countSubarrays(nums, minK, maxK));
        }
    }
}

// 5 ms 60 MB
class CountSubarraysWithFixedBounds_Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minI = -1, maxI = -1, left = -1, right = 0;
        long count = 0;
        while(right < nums.length){
            if(nums[right] < minK || nums[right] > maxK){
                minI = right;
                maxI = right;
                left = right;
            }
            minI = nums[right] == minK ? right : minI;
            maxI = nums[right] == maxK ?  right : maxI;
            count += Math.min(minI, maxI) - left;
            right++;
        }
        return count;
    }
}