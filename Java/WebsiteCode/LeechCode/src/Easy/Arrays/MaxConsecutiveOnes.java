package Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/max-consecutive-ones/">485. Max Consecutive Ones</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a binary array <code>nums</code>, return <em>the maximum number of consecutive </em><code>1</code><em>'s in the array</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,1,0,1,1,1]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,0,1,1,0,1]
 * <strong>Output:</strong> 2
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>nums[i]</code> is either <code>0</code> or <code>1</code>.</li>
 * </ul>
 * </div>
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[][] tests = {
            {1,1,0,1,1,1},
        };

        for (int[] nums : tests) {
            System.out.println( new MaxConsecutiveOnes_Solution().findMaxConsecutiveOnes(nums));
        }
    }
}

// 2 ms 45.7 MB
class MaxConsecutiveOnes_Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int continues = 0,
            maxCon = 0;

        for (int num : nums) {
            if (num == 1) {
                if (++continues > maxCon) {
                    maxCon = continues;
                }
                // maxCon = Math.max(++continues, maxCon); 3ms
            } else {
                continues = 0;
            }
        }

        return maxCon;
    }
}
