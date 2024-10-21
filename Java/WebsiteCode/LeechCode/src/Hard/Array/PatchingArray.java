package Hard.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/patching-array/">330. Patching Array</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a sorted integer array <code>nums</code> and an integer <code>n</code>, add/patch elements to the array such that any number in the range <code>[1, n]</code> inclusive can be formed by the sum of some elements in the array.</p>
 * 
 * <p>Return <em>the minimum number of patches required</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,3], n = 6
 * <strong>Output:</strong> 1
 * Explanation:
 * Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
 * Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
 * Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
 * So we only need 1 patch.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,5,10], n = 20
 * <strong>Output:</strong> 2
 * Explanation: The two patches can be [2, 4].
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,2,2], n = 5
 * <strong>Output:</strong> 0
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * 	<li><code>nums</code> is sorted in <strong>ascending order</strong>.</li>
 * 	<li><code>1 &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 * </div>
 */
public class PatchingArray {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {1,3},
                {6}
            },
            {
                {1,5,10},
                {20}
            },
            {
                {1,2,2},
                {5}
            }
            ,
        };   

        for (int[][] test : tests) {
            int nums[] = test[0],
                n = test[1][0];

            System.out.println(new PatchingArray_Solution().minPatches(nums, n));
        }
    }
}

// Memory Limit Exceeded
class PatchingArray_Solution {
    boolean[] range;
    int idx = 0;
    public int minPatches(int[] nums, int n) {
        range = new boolean[n];
        range[0] = true;

        int minPatch = 0;
        combiSum(nums);

        List<Integer> missNums = new ArrayList<>();
        for (int i = 0; i < range.length; i++) {
            if (!range[i]) {
                missNums.add(i+1);
            }
        }

        if (missNums.isEmpty()) {return 0;}

        int maxValAvailable = 0;
        while (!missNums.isEmpty()) {
            int num = missNums.removeFirst();
            if (maxValAvailable < num) {
                maxValAvailable += num;
                maxValAvailable += sumFrom(nums, maxValAvailable);
                minPatch++;
            }
        }

        return minPatch;
    }

    private void combiSum(int[] nums) {
        int total = 0,
            n = range.length;
        for (int num : nums) {
            total+= num;
            int tempTotal = total,
                idx = 0;
            while (tempTotal > 0) {
                if (tempTotal <= n && !range[tempTotal-1]) {
                    range[tempTotal-1] = true;
                }
                tempTotal -= nums[idx++];
            }
        }
    }

    private int sumFrom(int[] arr, int end){
        int total = 0;

        for (; idx < arr.length; idx++) {
            total += arr[idx];
        }

        return total;
    }
}