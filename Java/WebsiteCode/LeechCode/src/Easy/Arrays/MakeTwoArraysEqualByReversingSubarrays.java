package Easy.Arrays;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/make-two-arrays-equal-by-reversing-subarrays/">1460. Make Two Arrays Equal by Reversing Subarrays</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given two integer arrays of equal length <code>target</code> and <code>arr</code>. In one step, you can select any <strong>non-empty subarray</strong> of <code>arr</code> and reverse it. You are allowed to make any number of steps.</p>
 * 
 * <p>Return <code>true</code> <em>if you can make </em><code>arr</code><em> equal to </em><code>target</code><em>&nbsp;or </em><code>false</code><em> otherwise</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> target = [1,2,3,4], arr = [2,4,1,3]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> You can follow the next steps to convert arr to target:
 * 1- Reverse subarray [2,4,1], arr becomes [1,4,2,3]
 * 2- Reverse subarray [4,2], arr becomes [1,2,4,3]
 * 3- Reverse subarray [4,3], arr becomes [1,2,3,4]
 * There are multiple ways to convert arr to target, this is not the only way to do so.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> target = [7], arr = [7]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> arr is equal to target without any reverses.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> target = [3,7,9], arr = [3,7,11]
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> arr does not have value 9 and it can never be converted to target.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>target.length == arr.length</code></li>
 * 	<li><code>1 &lt;= target.length &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= target[i] &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= arr[i] &lt;= 1000</code></li>
 * </ul>
 * </div>
 */
public class MakeTwoArraysEqualByReversingSubarrays {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {1,2,3,4},
                {2,4,1,3}
            }
        };

        for (int[][] test : tests) {
            int[] target = test[0],
                  arr = test[1];

            System.out.println(new MakeTwoArraysEqualByReversingSubarrays_Solution().canBeEqual(target, arr));
        }
    }
}

// 4ms 44.16MB -> 3ms 44.15MB
class MakeTwoArraysEqualByReversingSubarrays_Solution1 {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {return false;} // Add:

        Arrays.sort(target);
        Arrays.sort(arr);

        // Add: 
        for (int i = 0; i < arr.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }

        // return Arrays.compare(target, arr) == 0;
        return true;
    }
}

// 2ms 44.56MB
class MakeTwoArraysEqualByReversingSubarrays_Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {return false;}

        int nums[] = new int[1001];

        for (int i = 0; i < target.length; i++) {
            nums[target[i]]++;
            nums[arr[i]]--;
        }

        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}