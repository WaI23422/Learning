package Medium.Array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/">1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of integers <code>nums</code> and an integer <code>limit</code>, return the size of the longest <strong>non-empty</strong> subarray such that the absolute difference between any two elements of this subarray is less than or equal to <code>limit</code><em>.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [8,2,4,7], limit = 4
 * <strong>Output:</strong> 2 
 * <strong>Explanation:</strong> All subarrays are: 
 * [8] with maximum absolute diff |8-8| = 0 &lt;= 4.
 * [8,2] with maximum absolute diff |8-2| = 6 &gt; 4. 
 * [8,2,4] with maximum absolute diff |8-2| = 6 &gt; 4.
 * [8,2,4,7] with maximum absolute diff |8-2| = 6 &gt; 4.
 * [2] with maximum absolute diff |2-2| = 0 &lt;= 4.
 * [2,4] with maximum absolute diff |2-4| = 2 &lt;= 4.
 * [2,4,7] with maximum absolute diff |2-7| = 5 &gt; 4.
 * [4] with maximum absolute diff |4-4| = 0 &lt;= 4.
 * [4,7] with maximum absolute diff |4-7| = 3 &lt;= 4.
 * [7] with maximum absolute diff |7-7| = 0 &lt;= 4. 
 * Therefore, the size of the longest subarray is 2.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [10,1,2,4,7,2], limit = 5
 * <strong>Output:</strong> 4 
 * <strong>Explanation:</strong> The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 &lt;= 5.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [4,2,2,2,4,4,2,2], limit = 0
 * <strong>Output:</strong> 3
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>0 &lt;= limit &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div>
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {8,2,4,7},
                {4},
            },
        };
        
        for (int[][] test : tests) {
            int nums[] = test[0],
                limit = test[1][0];

            System.out.println(new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit_Solution().longestSubarray(nums, limit));
        }
    }
}

// 69 ms 60.5 MB
class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit_Solution {
    // Time Limit Exceeded
    // public int longestSubarray(int[] nums, int limit) {
    //     int longestSubarray = 0;

    //     for (int i = 0; i < nums.length; i++) {
    //         int left = 0;
    //         while (left <= i) {
    //             int[] minMax = findMinMax(nums,left,i);
    //             if (Math.abs(minMax[0] - minMax[1]) <= limit && i-left+1 > longestSubarray) {
    //                 longestSubarray = i-left+1;
    //             }
    //             left++;
    //         }
    //     }

    //     return longestSubarray;
    // }

    // private int[] findMinMax(int[] nums, int start, int end) {
    //     int[] minMax = new int[2];
    //     minMax[0] = Integer.MAX_VALUE;

    //     for (int i = start; i <= end; i++) {
    //         if (nums[i] < minMax[0]) { minMax[0] = nums[i];}
    //         if (nums[i] > minMax[1]) { minMax[1] = nums[i];}
    //     }
        
    //     return minMax;
    // }   

    // Time Limit Exceeded
    // public int longestSubarray(int[] nums, int limit) {
    //     int longestSubarray = 0;

    //     int[] copyNums = nums.clone();
    //     Arrays.sort(copyNums);
    //     if (copyNums[nums.length-1] - copyNums[0] <= limit) {return nums.length;}

    //     for (int i = 0; i < nums.length; i++) {
    //         int right = i,
    //             min = Integer.MAX_VALUE,
    //             max = 0;
    //         while (right < nums.length) {
    //             if (nums[right] == min || nums[right] == max) {
    //                 longestSubarray = right-i+1;
    //             }
    //             if (nums[right] < min) { min = nums[right];}
    //             if (nums[right] > max) { max = nums[right];}
                
    //             // Time Limit Exceeded
    //             // if (Math.abs(min - max) <= limit && right-i+1 > longestSubarray) {
    //             //      longestSubarray = right-i+1;
    //             // }
    //             if (Math.abs(min - max) > limit) {break;}

    //             if (right-i+1 > longestSubarray) {
    //                 longestSubarray = right-i+1;
    //             }

    //             right++;
    //         }
    //     }

    //     return longestSubarray;
    // }

    // 69 ms 60.5 MB
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );

        int left = 0, maxLength = 0;

        for (int right = 0; right < nums.length; ++right) {
            maxHeap.offer(new int[] { nums[right], right });
            minHeap.offer(new int[] { nums[right], right });

            while (maxHeap.peek()[0] - minHeap.peek()[0] > limit) {
                left = Math.min(maxHeap.peek()[1], minHeap.peek()[1]) + 1;

                while (maxHeap.peek()[1] < left) {
                    maxHeap.poll();
                }
                while (minHeap.peek()[1] < left) {
                    minHeap.poll();
                }
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}