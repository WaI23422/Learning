package Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/single-number-iii/">260. Single Number III</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code>, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in <strong>any order</strong>.</p>
 * 
 * <p>You must write an&nbsp;algorithm that runs in linear runtime complexity and uses&nbsp;only constant extra space.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1,2,1,3,2,5]
 * <strong>Output:</strong> [3,5]
 * <strong>Explanation: </strong> [5, 3] is also a valid answer.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [-1,0]
 * <strong>Output:</strong> [-1,0]
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [0,1]
 * <strong>Output:</strong> [1,0]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
 * 	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
 * 	<li>Each integer in <code>nums</code> will appear twice, only two integers will appear once.</li>
 * </ul>
 * </div>
 */
public class SingleNumberIII {
    public static void main(String[] args) {
        int[][] tests = {
            {0,1,1,2},
            {0,1,2,2},
            {1,2,1,3,2,5}
        };

        for (int[] nums : tests) {
            System.out.println(Arrays.toString(new SingleNumberIII_Solution().singleNumber(nums)));
        }
    }
}

// 3 ms 46 MB
class SingleNumberIII_Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);

        int preNum = nums[0],
            singleTwo[] = new int[2],
            idx = 0,
            len = nums.length;

        for (int i = 1; i < len; i++) {
            if (idx == 2) {break;}

            if (preNum == nums[i]) {
                preNum = nums[++i];
            } else {
                singleTwo[idx++] = preNum;
                preNum = nums[i];
            }

            if (i == len-1) {singleTwo[idx++] = nums[i];}
        }

        return singleTwo;
    }
}