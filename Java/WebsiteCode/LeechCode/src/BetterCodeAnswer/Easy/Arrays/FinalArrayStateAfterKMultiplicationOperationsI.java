package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/final-array-state-after-k-multiplication-operations-i/">3264. Final Array State After K Multiplication Operations I</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given an integer array <code>nums</code>, an integer <code>k</code>, and an integer <code>multiplier</code>.</p>
 * 
 * <p>You need to perform <code>k</code> operations on <code>nums</code>. In each operation:</p>
 * 
 * <ul>
 * 	<li>Find the <strong>minimum</strong> value <code>x</code> in <code>nums</code>. If there are multiple occurrences of the minimum value, select the one that appears <strong>first</strong>.</li>
 * 	<li>Replace the selected minimum value <code>x</code> with <code>x * multiplier</code>.</li>
 * </ul>
 * 
 * <p>Return an integer array denoting the <em>final state</em> of <code>nums</code> after performing all <code>k</code> operations.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">nums = [2,1,3,5,6], k = 5, multiplier = 2</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[8,4,6,5,6]</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <table><tbody><tr><th>Operation</th><th>Result</th></tr><tr><td>After operation 1</td><td>[2, 2, 3, 5, 6]</td></tr><tr><td>After operation 2</td><td>[4, 2, 3, 5, 6]</td></tr><tr><td>After operation 3</td><td>[4, 4, 3, 5, 6]</td></tr><tr><td>After operation 4</td><td>[4, 4, 6, 5, 6]</td></tr><tr><td>After operation 5</td><td>[8, 4, 6, 5, 6]</td></tr></tbody></table>
 * </div>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">nums = [1,2], k = 3, multiplier = 4</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[16,8]</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <table><tbody><tr><th>Operation</th><th>Result</th></tr><tr><td>After operation 1</td><td>[4, 2]</td></tr><tr><td>After operation 2</td><td>[4, 8]</td></tr><tr><td>After operation 3</td><td>[16, 8]</td></tr></tbody></table>
 * </div>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
 * 	<li><code>1 &lt;= k &lt;= 10</code></li>
 * 	<li><code>1 &lt;= multiplier &lt;= 5</code></li>
 * </ul>
 * </div></div>
 */
public class FinalArrayStateAfterKMultiplicationOperationsI {
    public static void main(String[] args) {
        
    }
}

// 1ms 44.97MB
class FinalArrayStateAfterKMultiplicationOperationsI_Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int[] arr = new int[2];

        for (int i = 0; i < k; i++) {
            arr = getMin(nums);
            nums[arr[1]] = arr[0] * multiplier;
        }

        return nums;
    }

    private int[] getMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int idx = 0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] < min) {
                min = nums[i];
                idx = i;
            }

        return new int[] { min, idx };
    }

}