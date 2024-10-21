package BetterCodeAnswer.Medium.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/">1509. Minimum Difference Between Largest and Smallest Value in Three Moves</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an integer array <code>nums</code>.</p>
 * 
 * <p>In one move, you can choose one element of <code>nums</code> and change it to <strong>any value</strong>.</p>
 * 
 * <p>Return <em>the minimum difference between the largest and smallest value of <code>nums</code> <strong>after performing at most three moves</strong></em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [5,3,2,4]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> We can make at most 3 moves.
 * In the first move, change 2 to 3. nums becomes [5,3,3,4].
 * In the second move, change 4 to 3. nums becomes [5,3,3,3].
 * In the third move, change 5 to 3. nums becomes [3,3,3,3].
 * After performing 3 moves, the difference between the minimum and maximum is 3 - 3 = 0.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,5,0,10,14]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> We can make at most 3 moves.
 * In the first move, change 5 to 0. nums becomes [1,0,0,10,14].
 * In the second move, change 10 to 0. nums becomes [1,0,0,0,14].
 * In the third move, change 14 to 1. nums becomes [1,0,0,0,1].
 * After performing 3 moves, the difference between the minimum and maximum is 1 - 0 = 1.
 * It can be shown that there is no way to make the difference 0 in 3 moves.</pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [3,100,20]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> We can make at most 3 moves.
 * In the first move, change 100 to 7. nums becomes [3,7,20].
 * In the second move, change 20 to 7. nums becomes [3,7,7].
 * In the third move, change 3 to 7. nums becomes [7,7,7].
 * After performing 3 moves, the difference between the minimum and maximum is 7 - 7 = 0.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div>
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public static void main(String[] args) {
        int[][] tests = {
            {82,81,95,75,20},
            {5,3,2,4},
        };

        for (int[] nums : tests) {
            System.out.println(new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves_Solution().minDifference(nums));
        }
    }
}

class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves_Solution {
    // 32 ms 55 MB
    public int minDifference(int[] nums) {
        int numsSize = nums.length;
        if (numsSize <= 4) {
            return 0;
        }

        // Find the four smallest elements using a fixed-size max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > 4) {
                maxHeap.poll();
            }
        }
        List<Integer> smallestFour = new ArrayList<>(maxHeap);
        Collections.sort(smallestFour);

        // Find the four largest elements using a fixed-size min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > 4) {
                minHeap.poll();
            }
        }
        List<Integer> largestFour = new ArrayList<>(minHeap);
        Collections.sort(largestFour);

        int minDiff = Integer.MAX_VALUE;
        // Four scenarios to compute the minimum difference
        for (int i = 0; i < 4; i++) {
            minDiff = Math.min(
                minDiff,
                largestFour.get(i) - smallestFour.get(i)
            );
        }

        return minDiff;
    }
}

// 2 ms 56.9 MB
class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves_Solution2 {
    public int minDifference(int[] nums) {
         // 74 82 29 1 38 23 19 22 48 59 62 
        //  1 19 22 23 29 38 48 59 62 74 82

        if(nums.length<=4){
            return 0;
        }

        // Arrays.sort(nums);

        for(int i=0; i<4 ;i++){
            if(i>nums.length/2){
                break;
            }
            find_min_move_to_start(nums,i);
            find_max_move_to_end(nums,i);
        }

        int i=0;
        int j= nums.length-1;

        int last_3 = nums[j-3] - nums[i];
        int diff1 = nums[j-2] - nums[i+1];
        int diff2 = nums[j-1] - nums[i+2];
        int first_3 = nums[j] - nums[i+3];   // 0 1 5 10 14
         
        int ans = Math.min(Math.min(last_3, diff1), Math.min(diff2, first_3));

        return ans;
    }

    public void find_min_move_to_start(int[] nums, int idx){

        int min_idx= idx;

        for(int i=idx; i<nums.length-idx; i++){
            if(nums[min_idx]> nums[i]){
                min_idx = i;
            }
        }

        int temp1 = nums[idx];
        nums[idx] = nums[min_idx];
        nums[min_idx] = temp1;
    }
    
    public void find_max_move_to_end(int[] nums, int idx){

        int max_idx= idx;
        for(int i=idx; i<nums.length-idx; i++){
            if(nums[max_idx] < nums[i]){
                max_idx = i;
            }
        }

        int temp2 = nums[nums.length-1-idx];
        nums[nums.length-1-idx] = nums[max_idx];
        nums[max_idx] = temp2;
    }
}

// 3 ms 56.9 MB
class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves_Solution3 {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 3) {
            return 0;
        }
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int min4 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int max4 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min4 = min3;
                min3 = min2;
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min4 = min3;
                min3 = min2;
                min2 = num;
            } else if (num < min3) {
                min4 = min3;
                min3 = num;
            } else if (num < min4) {
                min4 = num;
            }

            if (num > max1) {
                max4 = max3;
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max4 = max3;
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max4 = max3;
                max3 = num;
            } else if (num > max4) {
                max4 = num;
            }
        }
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, max1 - min4);
        ans = Math.min(ans, max2 - min3);
        ans = Math.min(ans, max3 - min2);
        ans = Math.min(ans, max4 - min1);
        return ans;
    }
}