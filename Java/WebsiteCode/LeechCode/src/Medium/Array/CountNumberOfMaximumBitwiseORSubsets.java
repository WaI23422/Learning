package Medium.Array;

import java.util.Stack;

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
            {3,2,1,5},
            {3,1},
        };

        for (int[] nums : tests) {
            System.out.println(new CountNumberOfMaximumBitwiseORSubsets_Solution().countMaxOrSubsets(nums));
        }
    }
}

//Brute-Force: 65ms 47.17MB
class CountNumberOfMaximumBitwiseORSubsets_Solution {
    public int countMaxOrSubsets(int[] nums) {
        int count = 0,
            max = 0;
        Stack<Integer> st = new Stack<>();

        for (int num : nums) { max |= num; }

        Stack<Integer> temp_st = new Stack<>();
        for (int num : nums) {
            temp_st.addAll(st);
            while (!temp_st.empty()) {
                int temp_num = temp_st.pop() | num;
                if (temp_num == max) { count++; }

                st.add(temp_num);
            }

            if (num == max) { count++; }
            st.add(num);
        }

        return count;
    }
}
