package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-the-power-of-k-size-subarrays-i/">3254. Find the Power of K-Size Subarrays I</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given an array of integers <code>nums</code> of length <code>n</code> and a <em>positive</em> integer <code>k</code>.</p>
 * 
 * <p>The <strong>power</strong> of an array is defined as:</p>
 * 
 * <ul>
 * 	<li>Its <strong>maximum</strong> element if <em>all</em> of its elements are <strong>consecutive</strong> and <strong>sorted</strong> in <strong>ascending</strong> order.</li>
 * 	<li>-1 otherwise.</li>
 * </ul>
 * 
 * <p>You need to find the <strong>power</strong> of all <span data-keyword="subarray-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:r1d:"><div>subarrays</div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(264px, 348px);"></div></div></div></span> of <code>nums</code> of size <code>k</code>.</p>
 * 
 * <p>Return an integer array <code>results</code> of size <code>n - k + 1</code>, where <code>results[i]</code> is the <em>power</em> of <code>nums[i..(i + k - 1)]</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,4,3,2,5], k = 3</span></p>
 * 
 * <p><strong>Output:</strong> [3,4,-1,-1,-1]</p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p>There are 5 subarrays of <code>nums</code> of size 3:</p>
 * 
 * <ul>
 * 	<li><code>[1, 2, 3]</code> with the maximum element 3.</li>
 * 	<li><code>[2, 3, 4]</code> with the maximum element 4.</li>
 * 	<li><code>[3, 4, 3]</code> whose elements are <strong>not</strong> consecutive.</li>
 * 	<li><code>[4, 3, 2]</code> whose elements are <strong>not</strong> sorted.</li>
 * 	<li><code>[3, 2, 5]</code> whose elements are <strong>not</strong> consecutive.</li>
 * </ul>
 * </div>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">nums = [2,2,2,2,2], k = 4</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[-1,-1]</span></p>
 * </div>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">nums = [3,2,3,2,3,2], k = 2</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[-1,3,-1,3,-1]</span></p>
 * </div>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n == nums.length &lt;= 500</code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= k &lt;= n</code></li>
 * </ul>
 * </div></div>
 */
public class FindThePowerOfKSizeSubarraysI {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {},
                {}
            }
        };

        for (int[][] test : tests) {
            int nums[] = test[0],
                k = test[1][0];

                System.out.println(Arrays.toString(new FindThePowerOfKSizeSubarraysI_Solution().resultsArray(nums,k)));
        }
    }
}

// 1ms 45.36MB
class FindThePowerOfKSizeSubarraysI_Solution {

    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums; // If k is 1, every single element is a valid subarray
        }

        int length = nums.length;
        int[] result = new int[length - k + 1];
        Arrays.fill(result, -1); // Initialize results to -1
        int consecutiveCount = 1; // Count of consecutive elements

        for (int index = 0; index < length - 1; index++) {
            if (nums[index] + 1 == nums[index + 1]) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1; // Reset count if not consecutive
            }

            // If we have enough consecutive elements, update the result
            if (consecutiveCount >= k) {
                result[index - k + 2] = nums[index + 1];
            }
        }

        return result;
    }
}