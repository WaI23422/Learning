package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-swaps-to-group-all-1s-together-ii/">2134. Minimum Swaps to Group All 1's Together II</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>A <strong>swap</strong> is defined as taking two <strong>distinct</strong> positions in an array and swapping the values in them.</p>
 * 
 * <p>A <strong>circular</strong> array is defined as an array where we consider the <strong>first</strong> element and the <strong>last</strong> element to be <strong>adjacent</strong>.</p>
 * 
 * <p>Given a <strong>binary</strong> <strong>circular</strong> array <code>nums</code>, return <em>the minimum number of swaps required to group all </em><code>1</code><em>'s present in the array together at <strong>any location</strong></em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [0,1,0,1,1,0,0]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> Here are a few of the ways to group all the 1's together:
 * [0,<u>0</u>,<u>1</u>,1,1,0,0] using 1 swap.
 * [0,1,<u>1</u>,1,<u>0</u>,0,0] using 1 swap.
 * [1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
 * There is no way to group all 1's together with 0 swaps.
 * Thus, the minimum number of swaps required is 1.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [0,1,1,1,0,0,1,1,0]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> Here are a few of the ways to group all the 1's together:
 * [1,1,1,0,0,0,0,1,1] using 2 swaps (using the circular property of the array).
 * [1,1,1,1,1,0,0,0,0] using 2 swaps.
 * There is no way to group all 1's together with 0 or 1 swaps.
 * Thus, the minimum number of swaps required is 2.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,1,0,0,1]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> All the 1's are already grouped together due to the circular property of the array.
 * Thus, the minimum number of swaps required is 0.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>nums[i]</code> is either <code>0</code> or <code>1</code>.</li>
 * </ul>
 * </div>
 */
public class MinimumSwapsToGroupAll1sTogetherII {
    public static void main(String[] args) {
        int[][] tests= {
            {1,1,0},
            {0,1},
            {1},
            {0,1,0,1,1,0,0},
            {1,1,0,0,1}
        };

        for (int[] nums : tests) {
            System.out.println(new MinimumSwapsToGroupAll1sTogetherII_Solution().minSwaps(nums));
        }
    }
}

// 9ms 61.35MB
class MinimumSwapsToGroupAll1sTogetherII_Solution {

    public int minSwaps(int[] nums) {
        // Calculate the minimum swaps needed to group all 1s or all 0s together
        int op1 = minSwapsHelper(nums, 0); // Grouping all 0s together
        int op2 = minSwapsHelper(nums, 1); // Grouping all 1s together
        return Math.min(op1, op2);
    }

    // Helper function to calculate the minimum swaps required to group all `val` together
    public int minSwapsHelper(int[] data, int val) {
        int length = data.length;
        int[] rightSuffixSum = new int[length + 1];

        // Construct the suffix sum array for counting opposite values (val ^ 1)
        for (int i = length - 1; i >= 0; i--) {
            rightSuffixSum[i] = rightSuffixSum[i + 1];
            if (data[i] == (val ^ 1)) rightSuffixSum[i]++;
        }
        // Total zeros in the array if `val` is 1 (or vice versa)
        int totalSwapsNeeded = rightSuffixSum[0];
        // Track current number of required swaps in the current segment
        int currentSwapCount = 0;
        int minimumSwaps =
            totalSwapsNeeded - rightSuffixSum[length - totalSwapsNeeded];

        // Iterate to find the minimum swaps by sliding the potential block of grouped `val`
        for (int i = 0; i < totalSwapsNeeded; i++) {
            if (data[i] == (val ^ 1)) currentSwapCount++;
            int remaining = (totalSwapsNeeded - i - 1);
            int requiredSwaps =
                ((i + 1) - currentSwapCount) +
                (remaining - rightSuffixSum[length - remaining]);
            minimumSwaps = Math.min(minimumSwaps, requiredSwaps);
        }
        return minimumSwaps;
    }
}

// 9ms 59.26MB
class MinimumSwapsToGroupAll1sTogetherII_Solution2 {

    public int minSwaps(int[] nums) {
        // Calculate the minimum swaps needed to group all 1s or all 0s together
        int op1 = minSwapsHelper(nums, 0); // Grouping all 0s together
        int op2 = minSwapsHelper(nums, 1); // Grouping all 1s together
        return Math.min(op1, op2);
    }

    // Helper function to calculate the minimum swaps required
    // to group all `val` together
    public int minSwapsHelper(int[] data, int val) {
        int length = data.length;
        int totalValCount = 0;

        // Count the total number of `val` in the array
        for (int i = length - 1; i >= 0; i--) {
            if (data[i] == val) totalValCount++;
        }

        // If there is no `val` or the array is full of `val`,
        // no swaps are needed
        if (totalValCount == 0 || totalValCount == length) return 0;

        int start = 0, end = 0;
        int maxValInWindow = 0, currentValInWindow = 0;

        // Initial window setup: count the number of `val` in
        // the first window of size `totalValCount`
        while (end < totalValCount) {
            if (data[end++] == val) currentValInWindow++;
        }
        maxValInWindow = Math.max(maxValInWindow, currentValInWindow);

        // Slide the window across the array to find the
        // maximum number of `val` in any window
        while (end < length) {
            if (data[start++] == val) currentValInWindow--;
            if (data[end++] == val) currentValInWindow++;
            maxValInWindow = Math.max(maxValInWindow, currentValInWindow);
        }

        // Minimum swaps are the total `val` minus
        // the maximum found in any window
        return totalValCount - maxValInWindow;
    }
}

//4ms 62.30MB
class MinimumSwapsToGroupAll1sTogetherII_Solution3 {
    public int minSwaps(int[] nums) {
        // 1. count the total ones 
        // 2. as its circular property in array we need to append the array to it
        // 3. we need to find ones - max ones in the window of size ones

        int n = nums.length, ones = 0;
        int[] circular = new int[n * 2];
        for(int i = 0; i < n; ++i) {
            circular[i] = circular[i + n] = nums[i];
            ones += nums[i];
        }

        // create a window of size ones
        int maxOnes = 0, curOnes = 0, i = 0, j = 0;
        for(j = 0; j < ones; ++j) {
            curOnes += circular[j];
        }

        if(maxOnes < curOnes) {
            maxOnes = curOnes;
        }

        while(j < circular.length) {
            curOnes = curOnes - circular[i] + circular[j];
            if(maxOnes < curOnes) {
                maxOnes = curOnes;
            }
            ++j;
            ++i;
        }

        return ones - maxOnes;
    }
}