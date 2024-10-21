package Medium.Array;

import java.util.Arrays;

// import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sort-colors/">75. Sort Colors</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array <code>nums</code> with <code>n</code> objects colored red, white, or blue, sort them <strong><a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a> </strong>so that objects of the same color are adjacent, with the colors in the order red, white, and blue.</p>
 * 
 * <p>We will use the integers <code>0</code>, <code>1</code>, and <code>2</code> to represent the color red, white, and blue, respectively.</p>
 * 
 * <p>You must solve this problem without using the library's sort function.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,0,2,1,1,0]
 * <strong>Output:</strong> [0,0,1,1,2,2]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,0,1]
 * <strong>Output:</strong> [0,1,2]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>n == nums.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 300</code></li>
 * 	<li><code>nums[i]</code> is either <code>0</code>, <code>1</code>, or <code>2</code>.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong>&nbsp;Could you come up with a one-pass algorithm using only&nbsp;constant extra space?</p>
 * </div>
 */
public class SortColors {
    public static void main(String[] args) {
        int[][] tests = {
            {2,0,2,1,1,0},
            {0,1,2}
        };

        for (int[] nums : tests) {
            new SortColors_Solution().sortColors(nums);

            System.out.println(Arrays.toString(nums));
        }
    }
}

// 0 ms 41.9 MB
class SortColors_Solution {
    public void sortColors(int[] nums) {
        // Arrays.sort(nums); 0 ms 42.4 MB

        int colors[] = new int[3],
            idx = 0;

        for (int num : nums) {
            colors[num]++;
        }

        for (int i = 0; i < colors.length; i++) {
            int colorNum = colors[i];
            for (int j = 0; j < colorNum; j++) {
                nums[idx++] = i;
            }
        }
    }
}
