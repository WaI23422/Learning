package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-increment-to-make-array-unique/">945. Minimum Increment to Make Array Unique</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an integer array <code>nums</code>. In one move, you can pick an index <code>i</code> where <code>0 &lt;= i &lt; nums.length</code> and increment <code>nums[i]</code> by <code>1</code>.</p>
 * 
 * <p>Return <em>the minimum number of moves to make every value in </em><code>nums</code><em> <strong>unique</strong></em>.</p>
 * 
 * <p>The test cases are generated so that the answer fits in a 32-bit integer.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,2,2]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> After 1 move, the array could be [1, 2, 3].
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [3,2,1,2,1,7]
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong> After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
 * It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>0 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * </div>
 */
public class MinimumIncrementToMakeArrayUnique {
    public static void main(String[] args) {
        int[][] tests = {
            {1,2,2},
            {3,2,1,2,1,7,100000}
        };

        for (int[] nums : tests) {
            System.out.println(new MinimumIncrementToMakeArrayUnique_Solution().minIncrementForUnique(nums));
        }
    }
}

// 45 ms 55.19 MB
class MinimumIncrementToMakeArrayUnique_Solution {
    public int minIncrementForUnique(int[] nums) {
        int numsLimit[] = new int[100_002],
            minStep = 0;

        for (int num : nums) {
            numsLimit[num]++;
        }

        for (int i = 0; i < numsLimit.length; i++) {
            int move = 0;
            if (i == numsLimit.length -1) {
                minStep += move > 1 ? move-1:0;
                break;
            }
            
            if (numsLimit[i] > 1) {
                move = numsLimit[i] - 1;
                minStep += move;
                numsLimit[i+1] += move;
            }
            
            // 47 ms 54.6 MB
            // if (numsLimit[i] > 1) {
            //     int move = numsLimit[i] - 1;
            //     minStep += move;
            //     numsLimit[i+1] += move;
            // }            
        }

        return minStep;
    }
}