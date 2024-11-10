package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/shortest-subarray-with-or-at-least-k-ii/">3097. Shortest Subarray With OR at Least K II</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given an array <code>nums</code> of <strong>non-negative</strong> integers and an integer <code>k</code>.</p>
 * 
 * <p>An array is called <strong>special</strong> if the bitwise <code>OR</code> of all of its elements is <strong>at least</strong> <code>k</code>.</p>
 * 
 * <p>Return <em>the length of the <strong>shortest</strong> <strong>special</strong> <strong>non-empty</strong> <span data-keyword="subarray-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:r1d:"><div>subarray</div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(381px, 331px);"></div></div></div></span> of</em> <code>nums</code>, <em>or return</em> <code>-1</code> <em>if no special subarray exists</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">nums = [1,2,3], k = 2</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">1</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p>The subarray <code>[3]</code> has <code>OR</code> value of <code>3</code>. Hence, we return <code>1</code>.</p>
 * </div>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">nums = [2,1,8], k = 10</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">3</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p>The subarray <code>[2,1,8]</code> has <code>OR</code> value of <code>11</code>. Hence, we return <code>3</code>.</p>
 * </div>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">nums = [1,2], k = 0</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">1</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p>The subarray <code>[1]</code> has <code>OR</code> value of <code>1</code>. Hence, we return <code>1</code>.</p>
 * </div>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>5</sup></code></li>
 * 	<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>0 &lt;= k &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div></div>
 */
public class ShortestSubarrayWithORAtLeastKII {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {1,2,3},
                {2}
            }
        };

        for (int[][] test : tests) {
            int nums[] = test[0],
                k = test[1][0];

            System.out.println(new ShortestSubarrayWithORAtLeastKII_Solution().minimumSubarrayLength(nums, k));
        }
    }
}


// 787ms 70.22MB
class ShortestSubarrayWithORAtLeastKII_Solution {

    public int minimumSubarrayLength(int[] nums, int k) {
        int left = 1;
        int right = nums.length;
        int minLength = -1;

        // Binary search on the length of subarray
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (hasValidSubarray(nums, k, mid)) {
                minLength = mid;
                right = mid - 1; // Try to find smaller length
            } else {
                left = mid + 1; // Try larger length
            }
        }

        return minLength;
    }

    // Checks if there exists a subarray of given length whose bitwise OR is >= k
    private boolean hasValidSubarray(
        int[] nums,
        int targetSum,
        int windowSize
    ) {
        int arrayLength = nums.length;
        int[] bitCounts = new int[32]; // Tracks count of set bits at each position

        // Sliding window approach
        for (int right = 0; right < arrayLength; right++) {
            // Add current number to window
            updateBitCounts(bitCounts, nums[right], 1);

            // Remove leftmost number if window exceeds size
            if (right >= windowSize) {
                updateBitCounts(bitCounts, nums[right - windowSize], -1);
            }

            // Check if current window is valid
            if (
                right >= windowSize - 1 &&
                convertBitCountsToNumber(bitCounts) >= targetSum
            ) {
                return true;
            }
        }
        return false;
    }

    // Updates bit count array when adding/removing a number from window
    private void updateBitCounts(int[] bitCounts, int number, int delta) {
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
            // Check if bit is set at current position
            if (((number >> bitPosition) & 1) != 0) {
                bitCounts[bitPosition] += delta;
            }
        }
    }

    // Converts bit count array back to number using OR operation
    private int convertBitCountsToNumber(int[] bitCounts) {
        int number = 0;
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
            if (bitCounts[bitPosition] != 0) {
                number |= 1 << bitPosition;
            }
        }
        return number;
    }
}