package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sort-an-array/">912. Sort an Array</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of integers <code>nums</code>, sort the array in ascending order and return it.</p>
 * 
 * <p>You must solve the problem <strong>without using any built-in</strong> functions in <code>O(nlog(n))</code> time complexity and with the smallest space complexity possible.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [5,2,3,1]
 * <strong>Output:</strong> [1,2,3,5]
 * <strong>Explanation:</strong> After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [5,1,1,2,0,0]
 * <strong>Output:</strong> [0,0,1,1,2,5]
 * <strong>Explanation:</strong> Note that the values of nums are not necessairly unique.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 5 * 10<sup>4</sup></code></li>
 * 	<li><code>-5 * 10<sup>4</sup> &lt;= nums[i] &lt;= 5 * 10<sup>4</sup></code></li>
 * </ul>
 * </div>
 */
public class SortAnArray {
    public static void main(String[] args) {
        int[][] tests = {
            {5,2,3,1}
        };
        
        for (int[] nums : tests) {
            System.out.println(new SortAnArray_Solution().sortArray(nums));
        }
    }
}

// 3ms 56.96MB
class SortAnArray_Solution {
    public int[] sortArray(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int n = max - min;
        int[] arr = new int[n + 1];

        for (int num : nums) {
            arr[num - min]++;
        }

        int index = 0;

        for (int i = 0; i <= n; i++) {
            while (arr[i] > 0) {
                nums[index] = min;
                index++;
                arr[i]--;
            }

            min++;
        }

        return nums;
    }
}
    