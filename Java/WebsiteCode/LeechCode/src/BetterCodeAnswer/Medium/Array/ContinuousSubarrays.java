package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/continuous-subarrays/">2762. Continuous Subarrays</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> integer array <code>nums</code>. A subarray of <code>nums</code> is called <strong>continuous</strong> if:</p>
 * 
 * <ul>
 * 	<li>Let <code>i</code>, <code>i + 1</code>, ..., <code>j</code><sub> </sub>be the indices in the subarray. Then, for each pair of indices <code>i &lt;= i<sub>1</sub>, i<sub>2</sub> &lt;= j</code>, <code><font face="monospace">0 &lt;=</font> |nums[i<sub>1</sub>] - nums[i<sub>2</sub>]| &lt;= 2</code>.</li>
 * </ul>
 * 
 * <p>Return <em>the total number of <strong>continuous</strong> subarrays.</em></p>
 * 
 * <p>A subarray is a contiguous <strong>non-empty</strong> sequence of elements within an array.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [5,4,2,4]
 * <strong>Output:</strong> 8
 * <strong>Explanation:</strong> 
 * Continuous subarray of size 1: [5], [4], [2], [4].
 * Continuous subarray of size 2: [5,4], [4,2], [2,4].
 * Continuous subarray of size 3: [4,2,4].
 * Thereare no subarrys of size 4.
 * Total continuous subarrays = 4 + 3 + 1 = 8.
 * It can be shown that there are no more continuous subarrays.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,2,3]
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> 
 * Continuous subarray of size 1: [1], [2], [3].
 * Continuous subarray of size 2: [1,2], [2,3].
 * Continuous subarray of size 3: [1,2,3].
 * Total continuous subarrays = 3 + 2 + 1 = 6.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div></div>
 */
public class ContinuousSubarrays {
    public static void main(String[] args) {
        
    }
}

// 3ms 57.91MB
class ContinuousSubarrays_Solution {

    public long continuousSubarrays(int[] nums) {
        int right = 0, left = 0;
        int curMin, curMax;
        long windowLen = 0, total = 0;

        // Initialize window with first element
        curMin = curMax = nums[right];

        for (right = 0; right < nums.length; right++) {
            // Update min and max for current window
            curMin = Math.min(curMin, nums[right]);
            curMax = Math.max(curMax, nums[right]);

            // If window condition breaks (diff > 2)
            if (curMax - curMin > 2) {
                // Add subarrays from previous valid window
                windowLen = right - left;
                total += ((windowLen * (windowLen + 1)) / 2);

                // Start new window at current position
                left = right;
                curMin = curMax = nums[right];

                // Expand left boundary while maintaining condition
                while (
                    left > 0 && Math.abs(nums[right] - nums[left - 1]) <= 2
                ) {
                    left--;
                    curMin = Math.min(curMin, nums[left]);
                    curMax = Math.max(curMax, nums[left]);
                }

                // Remove overcounted subarrays if left boundary expanded
                if (left < right) {
                    windowLen = right - left;
                    total -= ((windowLen * (windowLen + 1)) / 2);
                }
            }
        }

        // Add subarrays from final window
        windowLen = right - left;
        total += ((windowLen * (windowLen + 1)) / 2);

        return total;
    }
}