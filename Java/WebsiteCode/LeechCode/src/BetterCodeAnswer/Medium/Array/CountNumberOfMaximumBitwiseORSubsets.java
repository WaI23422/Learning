package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/count-number-of-maximum-bitwise-or-subsets/">2044. Count Number of Maximum Bitwise-OR Subsets</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code>, find the <strong>maximum</strong> possible <strong>bitwise OR</strong> of a subset of <code>nums</code> and return <em>the <strong>number of different non-empty subsets</strong> with the maximum bitwise OR</em>.</p>
 * 
 * <p>An array <code>a</code> is a <strong>subset</strong> of an array <code>b</code> if <code>a</code> can be obtained from <code>b</code> by deleting some (possibly zero) elements of <code>b</code>. Two subsets are considered <strong>different</strong> if the indices of the elements chosen are different.</p>
 * 
 * <p>The bitwise OR of an array <code>a</code> is equal to <code>a[0] <strong>OR</strong> a[1] <strong>OR</strong> ... <strong>OR</strong> a[a.length - 1]</code> (<strong>0-indexed</strong>).</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [3,1]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
 * - [3]
 * - [3,1]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,2,2]
 * <strong>Output:</strong> 7
 * <strong>Explanation:</strong> All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 2<sup>3</sup> - 1 = 7 total subsets.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [3,2,1,5]
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> The maximum possible bitwise OR of a subset is 7. There are 6 subsets with a bitwise OR of 7:
 * - [3,5]
 * - [3,1,5]
 * - [3,2,5]
 * - [3,2,1,5]
 * - [2,5]
 * - [2,1,5]</pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 16</code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * </div></div>
 */
public class CountNumberOfMaximumBitwiseORSubsets {
    public static void main(String[] args) {
        int[][] tests = {
            {3,1},
            {3,2,1,5}
        };

        for (int[] nums : tests) {
            System.out.println(new CountNumberOfMaximumBitwiseORSubsets_Solution().countMaxOrSubsets(nums));
        }
    }
}

// 5ms 40.73MB
class CountNumberOfMaximumBitwiseORSubsets_Solution1 {
    private int maxOr;
    private int count;

    private void dfs(int[] nums, int index, int currentOr) {
        for (int i = index; i < nums.length; i++) {
            dfs(nums, i + 1, currentOr | nums[i]);
        }

        if (currentOr == maxOr) {
            count++;
        }
    }

    public int countMaxOrSubsets(int[] nums) {
        maxOr = 0; 
        count = 0;

        for (int num : nums) {
            maxOr |= num;
        }

        dfs(nums, 0, 0);

        return count;
    }
}

// 1ms 40.94MB
class CountNumberOfMaximumBitwiseORSubsets_Solution {
    static int[] tail = new int[16];
    int[] nums;
    int max;
    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max |= nums[i];
        }
        int v = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            v |= nums[i];
            tail[i] = v;
        }
        
        return recurse(0, 0);
    }
    
    int recurse(int i, int partial) {
        if (partial == max) {
            return 1 << (nums.length - i);
        }
        if (i == nums.length || ((partial | tail[i]) != max)) {
            return 0;
        }
        return recurse(i+1, partial | nums[i])
            + recurse(i+1, partial);
    }
}