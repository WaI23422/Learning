package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximum-width-ramp/">962. Maximum Width Ramp</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>A <strong>ramp</strong> in an integer array <code>nums</code> is a pair <code>(i, j)</code> for which <code>i &lt; j</code> and <code>nums[i] &lt;= nums[j]</code>. The <strong>width</strong> of such a ramp is <code>j - i</code>.</p>
 * 
 * <p>Given an integer array <code>nums</code>, return <em>the maximum width of a <strong>ramp</strong> in </em><code>nums</code>. If there is no <strong>ramp</strong> in <code>nums</code>, return <code>0</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [6,0,8,2,1,5]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [9,8,1,0,1,9,4,0,4,1]
 * <strong>Output:</strong> 7
 * <strong>Explanation:</strong> The maximum width ramp is achieved at (i, j) = (2, 9): nums[2] = 1 and nums[9] = 1.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= nums.length &lt;= 5 * 10<sup>4</sup></code></li>
 * 	<li><code>0 &lt;= nums[i] &lt;= 5 * 10<sup>4</sup></code></li>
 * </ul>
 * </div></div>
 */
public class MaximumWidthRamp {
    public static void main(String[] args) {
        int[][] tests = {
            {6,0,8,2,1,5}
        };

        for (int[] nums : tests) {
            System.out.println(new MaximumWidthRamp_Solution().maxWidthRamp(nums));
        }
    }
}

// Brute-Force: Time Limit Exceeded
class MaximumWidthRamp_Solution1 {
    public int maxWidthRamp(int[] nums) {
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    max = Math.max(j - i,max);
                }
            }
        }

        return max;
    }
}

// Time Limit Exceeded
class MaximumWidthRamp_Solution2 {
    public int maxWidthRamp(int[] nums) {
        int max = 0,
            len = nums.length;
        
        for (int i = 0; i < len; i++) {
            for (int j = len-1; j >= 0; j--) {
                if (nums[j] >= nums[i]) {
                    max = Math.max(max, j-i);
                    break;
                }
            }
        }

        return max;
    }
}

// 3ms 55.08MB
class MaximumWidthRamp_Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];

        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        int left = 0, right = 0;
        int maxWidth = 0;

        while (right < n) {
            while (left < right && nums[left] > rightMax[right]) {
                left++;
            }
            maxWidth = Math.max(maxWidth, right - left);
            right++;
        }

        return maxWidth;
    }
}