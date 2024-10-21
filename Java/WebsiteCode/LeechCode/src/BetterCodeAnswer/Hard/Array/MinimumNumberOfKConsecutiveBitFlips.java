package BetterCodeAnswer.Hard.Array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-number-of-k-consecutive-bit-flips/">995. Minimum Number of K Consecutive Bit Flips</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a binary array <code>nums</code> and an integer <code>k</code>.</p>
 * 
 * <p>A <strong>k-bit flip</strong> is choosing a <strong>subarray</strong> of length <code>k</code> from <code>nums</code> and simultaneously changing every <code>0</code> in the subarray to <code>1</code>, and every <code>1</code> in the subarray to <code>0</code>.</p>
 * 
 * <p>Return <em>the minimum number of <strong>k-bit flips</strong> required so that there is no </em><code>0</code><em> in the array</em>. If it is not possible, return <code>-1</code>.</p>
 * 
 * <p>A <strong>subarray</strong> is a <strong>contiguous</strong> part of an array.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [0,1,0], k = 1
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> Flip nums[0], then flip nums[2].
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,1,0], k = 2
 * <strong>Output:</strong> -1
 * <strong>Explanation:</strong> No matter how we flip subarrays of size 2, we cannot make the array become [1,1,1].
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [0,0,0,1,0,1,1,0], k = 3
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> 
 * Flip nums[0],nums[1],nums[2]: nums becomes [1,1,1,1,0,1,1,0]
 * Flip nums[4],nums[5],nums[6]: nums becomes [1,1,1,1,1,0,0,0]
 * Flip nums[5],nums[6],nums[7]: nums becomes [1,1,1,1,1,1,1,1]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= k &lt;= nums.length</code></li>
 * </ul>
 * </div> 
 */
public class MinimumNumberOfKConsecutiveBitFlips {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {1,1,1,1,0,1,1,0},
                {3}
            },
        };  

        for (int[][] test : tests) {
            int nums[] = test[0],
                k = test[1][0];

            System.out.println(new MinimumNumberOfKConsecutiveBitFlips_Solution().minKBitFlips(nums, k));
        }
    }
}

// 5 ms 60.47 MB 
class MinimumNumberOfKConsecutiveBitFlips_Solution {

    public int minKBitFlips(int[] nums, int k) {
        // Keeps track of flipped states
        boolean[] flipped = new boolean[nums.length];
        // Tracks valid flips within the past window
        int validFlipsFromPastWindow = 0;
        // Counts total flips needed
        int flipCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                // Decrease count of valid flips from the past window if needed
                if (flipped[i - k]) {
                    validFlipsFromPastWindow--;
                }
            }

            // Check if current bit needs to be flipped
            if (validFlipsFromPastWindow % 2 == nums[i]) {
                // If flipping the window extends beyond the array length, return -1
                if (i + k > nums.length) {
                    return -1;
                }
                // Increment the count of valid flips and mark current as flipped
                validFlipsFromPastWindow++;
                flipped[i] = true;
                flipCount++;
            }
        }

        return flipCount;
    }
}

// 5 ms 55.34 MB 
class MinimumNumberOfKConsecutiveBitFlips_Solution2 {

    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length; // Length of the input array
        Deque<Integer> flipQueue = new LinkedList<>(); // Queue to keep track of flips
        int flipped = 0; // Current flip state
        int result = 0; // Total number of flips

        for (int i = 0; i < n; i++) {
            // Remove the effect of the oldest flip if it's out of the current window
            if (i >= k) {
                flipped ^= flipQueue.poll();
            }

            // If the current bit is 0 (i.e., it needs to be flipped)
            if (flipped == nums[i]) {
                // If we cannot flip a subarray starting at index i
                if (i + k > n) {
                    return -1;
                }
                // Add a flip at this position
                flipQueue.offer(1);
                flipped ^= 1; // Toggle the flipped state
                result += 1; // Increment the flip count
            } else {
                flipQueue.offer(0);
            }
        }

        return result;
    }
}

// 4 ms 55.46 MB
class MinimumNumberOfKConsecutiveBitFlips_Solution4 {
    public int minKBitFlips(int[] A, int K) {
        int n = A.length, flipped = 0, res = 0;
        int[] isFlipped = new int[n];
        for (int i = 0; i < A.length; ++i) {
            if (i >= K)
                flipped ^= isFlipped[i - K];
            if (flipped == A[i]) {
                if (i + K > A.length)
                    return -1;
                isFlipped[i] = 1;
                flipped ^= 1;
                res++;
            }
        }
        return res;
    }
}