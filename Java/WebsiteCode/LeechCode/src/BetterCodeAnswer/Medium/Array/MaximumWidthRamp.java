package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;
import java.util.Stack;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximum-width-ramp/">962. Maximum Width Ramp</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>A <strong>ramp</strong> in an integer array <code>nums</code> is a pair <code>(i, j)</code> for which <code>i &lt; j</code> and <code>nums[i] &lt;= nums[j]</code>. The <strong>width</strong> of such a ramp is <code>j - i</code>.</p>
 * 
 * <p>Given an integer array <code>nums</code>, return <em>the maximum width of a <strong>ramp</strong> in </em><code>nums</code>. If there is no <strong>ramp</strong> in <code>nums</code>, return <code>0</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [6,0,8,2,1,5]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [9,8,1,0,1,9,4,0,4,1]
 * <strong>Output:</strong> 7
 * <strong>Explanation:</strong> The maximum width ramp is achieved at (i, j) = (2, 9): nums[2] = 1 and nums[9] = 1.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= nums.length &lt;= 5 * 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= nums[i] &lt;= 5 * 10<sup>4</sup></code></li>
 * </ul>
 * </div></div>
 */
public class MaximumWidthRamp {
    public static void main(String[] args) {
        int[][] tests = {
            {6,0,8,2,1,5}
        };

        for (int[] nums : tests) {
            System.out.println(new MaximumWidthRamp_Solution().maxWidthRamp(nums));
        }
    }
}

// 34ms 55.95MB
class MaximumWidthRamp_Solution1 {

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];

        // Initialize the array with indices
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on corresponding values in nums and ensure stability
        Arrays.sort(indices, (i, j) ->
            nums[i] != nums[j] ? nums[i] - nums[j] : i - j
        );

        int minIndex = n; // Minimum index encountered so far
        int maxWidth = 0;

        // Calculate maximum width ramp
        for (int i : indices) {
            maxWidth = Math.max(maxWidth, i - minIndex);
            minIndex = Math.min(minIndex, i);
        }

        return maxWidth;
    }
}

// 30ms 56.37MB
class MaximumWidthRamp_Solution2 {

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> indicesStack = new Stack<>();

        // Fill the stack with indices in increasing order of their values
        for (int i = 0; i < n; i++) {
            if (indicesStack.isEmpty() || nums[indicesStack.peek()] > nums[i]) {
                indicesStack.push(i);
            }
        }

        int maxWidth = 0;

        // Traverse the array from the end to the start
        for (int j = n - 1; j >= 0; j--) {
            while (
                !indicesStack.isEmpty() && nums[indicesStack.peek()] <= nums[j]
            ) {
                maxWidth = Math.max(maxWidth, j - indicesStack.peek());
                // Pop the index since it's already processed
                indicesStack.pop();
            }
        }

        return maxWidth;
    }
}

// 3ms 55.64MB
class MaximumWidthRamp_Solution {
    public int maxWidthRamp(int[] nums) {
        int low = 1, high = nums.length-1, res = 0;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(possible(nums, mid)) {
                res = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        return res;
    }

    private boolean possible(int[] nums, int width) {
        int i=0,j=width;
        int min = nums[i];
        while(j < nums.length) {
            if(nums[j] >= min) return true;
            j++;
            min = Math.min(min, nums[++i]);
        }   
        return false;
    }
}