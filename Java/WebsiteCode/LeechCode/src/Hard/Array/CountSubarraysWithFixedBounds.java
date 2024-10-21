package Hard.Array;

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
            {{1,3,5},{1},{5}},
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

// Time Limit Exceeded
class CountSubarraysWithFixedBounds_Solution1 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0, len = nums.length;

        for (int i = 0; i < len; i++) {
            int min = nums[i], max = nums[i],j=i;
            while (min >= minK && max <= maxK && j < len) {
                if (min > nums[j]) {min = nums[j];}
                if (max < nums[j]) {max = nums[j];}

                if (min == minK && max == maxK) {count++;}
                
                j++;
            }
        }
        
        return count;
    }
}

// 8 ms 61.2 MB
class CountSubarraysWithFixedBounds_Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int badIdx = -1, leftIdx = -1, rightIdx = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (!(minK <= nums[i] && nums[i] <= maxK)) {
                badIdx = i;
            }

            if (nums[i] == minK) {
                leftIdx = i;
            }

            if (nums[i] == maxK) {
                rightIdx = i;
            }

            res += Math.max(0, Math.min(leftIdx, rightIdx) - badIdx);
        }

        return res;
    }
}