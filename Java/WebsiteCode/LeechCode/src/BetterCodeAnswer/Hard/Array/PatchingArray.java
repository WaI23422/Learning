package BetterCodeAnswer.Hard.Array;

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
                {1,2,2},
                {5}
            }
            ,{
                {1,3},
                {6}
            },
            {
                {1,5,10},
                {20}
            }
        };   

        for (int[][] test : tests) {
            int nums[] = test[0],
                n = test[1][0];

            System.out.println(new PatchingArray_Solution().minPatches(nums, n));
        }
    }
}

// 1 ms 43.7 MB
/**
 * <ol>
 * <li>Initialize <code>missing</code> to 1, which is the smallest number we want to be able to form.</li>
 * <li>Use a variable <code>i</code> to iterate through the array and another variable <code>patches</code> to count the number of patches needed.</li>
 * <li>While <code>missing</code> is less than or equal to <code>n</code>:
 * <ul>
 * <li>If the current array element (<code>nums[i]</code>) is less than or equal to <code>missing</code>, add this element to <code>missing</code> and move to the next element (<code>i++</code>).</li>
 * <li>If the current array element is greater than <code>missing</code>, patch the <code>missing</code> value by adding <code>missing</code> itself, and increment the <code>patches</code> counter.</li>
 * </ul>
 * </li>
 * <li>Repeat until <code>missing</code> exceeds <code>n</code>.</li>
 * <li>Return the number of patches needed.</li>
 * </ol>
 */
class PatchingArray_Solution {
    public int minPatches(int[] nums, int n) {
        long missing = 1;
        int patches = 0;
        int index = 0;

        while (missing <= n) {
            if (index < nums.length && nums[index] <= missing) {
                missing += nums[index];
                index++;
            } else {
                missing += missing;
                patches++;
            }
        }

        return patches;
    }
}