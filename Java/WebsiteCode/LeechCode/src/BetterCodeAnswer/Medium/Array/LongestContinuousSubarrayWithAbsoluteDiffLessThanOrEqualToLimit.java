package BetterCodeAnswer.Medium.Array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

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

// 72 ms 60.5 MB
class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit_Solution {

    public int longestSubarray(int[] nums, int limit) {
        // TreeMap to maintain the elements within the current window
        TreeMap<Integer, Integer> window = new TreeMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < nums.length; ++right) {
            window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);

            // Check if the absolute difference between the maximum and minimum values in the current window exceeds the limit
            while (window.lastKey() - window.firstKey() > limit) {
                // Remove the element at the left pointer from the TreeMap
                window.put(nums[left], window.get(nums[left]) - 1);
                if (window.get(nums[left]) == 0) {
                    window.remove(nums[left]);
                }
                // Move the left pointer to the right to exclude the element causing the violation
                ++left;
            }

            // Update maxLength with the length of the current valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

// 28 ms 57.5 MB
class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit_Solution2 {

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; ++right) {
            // Maintain the maxDeque in decreasing order
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);

            // Maintain the minDeque in increasing order
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);

            // Check if the current window exceeds the limit
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                // Remove the elements that are out of the current window
                if (maxDeque.peekFirst() == nums[left]) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == nums[left]) {
                    minDeque.pollFirst();
                }
                ++left;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

// 12 ms 57.5 MB
class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit_Solution23 {

    // maitain max val of cur slide window in head of deque
    static int[] maxDeque ;
    static int[] minDeque;
    static int maxHead;
    static int maxTail;
    static int minHead;
    static int minTail;

    // maintain min val of cur silde window in head of deque
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        maxDeque = new int[n];
        minDeque = new int[n];

        // queue range [h,t)
        maxHead=0;
        maxTail=0;
        minHead=0;
        minTail=0;

        // take each num in nums as start of slide window
        // get max len of window with any two elements in window is less than or equal to limit.

        int res =0;
        int r=0;
        for(int l =0;l<n;l++){

            // window is [l,r), check if add r to window still meet condition
            while(r<n&&withinLimit(nums,nums[r],limit)){
                addToLast(nums,r);
                r++;
            }
            // [l,r) is max len of a valid window using l as start 
            res= Math.max(res, r-l);

           removeExpired(l);
        }

        return res;
        
    }

    public boolean withinLimit(int[] nums,int num,int limit){
        int max = maxHead<maxTail?Math.max(nums[maxDeque[maxHead]], num):num;
        int min = minHead<minTail?Math.min(nums[minDeque[minHead]],num):num;

        return max-min<=limit;
    }

    public void addToLast(int[] nums,int r){
        // add to max deque 
        while(maxHead<maxTail&&nums[maxDeque[maxTail-1]]<=nums[r]){
             maxTail--;
        }
        maxDeque[maxTail++]=r;

        // add to min deque
        while(minHead<minTail&&nums[minDeque[minTail-1]]>=nums[r]){
            minTail--;
        }
        minDeque[minTail++]=r;

    }

    public void removeExpired(int l){
        if(maxDeque[maxHead]==l){
            maxHead++;
        }

        if(minDeque[minHead]==l){
            minHead++;
        }
    }

}