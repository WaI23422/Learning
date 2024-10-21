package Easy.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sort-array-by-increasing-frequency/">1636. Sort Array by Increasing Frequency</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of integers <code>nums</code>, sort the array in <strong>increasing</strong> order based on the frequency of the values. If multiple values have the same frequency, sort them in <strong>decreasing</strong> order.</p>
 * 
 * <p>Return the <em>sorted array</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,1,2,2,2,3]
 * <strong>Output:</strong> [3,1,1,2,2,2]
 * <strong>Explanation:</strong> '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,3,1,3,2]
 * <strong>Output:</strong> [1,3,3,2,2]
 * <strong>Explanation:</strong> '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [-1,1,-6,4,5,-6,1,4,1]
 * <strong>Output:</strong> [5,-1,4,4,-6,-6,1,1,1]</pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
 * 	<li><code>-100 &lt;= nums[i] &lt;= 100</code></li>
 * </ul>
 * </div>
 */
public class SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        int[][] tests = {
            {1,1,2,2,2,3}
        };

        for (int[] nums : tests) {
            System.out.println(Arrays.toString(new SortArrayByIncreasingFrequency_Solution().frequencySort(nums)));
        }
    }
}

// 8ms 44.23MB
class SortArrayByIncreasingFrequency_Solution {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Integer[] numsObj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsObj[i] = nums[i];
        }

        Arrays.sort(numsObj, (a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return Integer.compare(b, a);
            }
            return Integer.compare(freq.get(a), freq.get(b));
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsObj[i];
        }

        return nums;
    }
}