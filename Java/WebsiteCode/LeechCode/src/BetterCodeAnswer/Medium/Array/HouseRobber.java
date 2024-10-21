package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/house-robber/">198.House Robber</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and <b>it will automatically contact the police if two adjacent houses were broken into on the same night</b>.</p>

<p>Given an integer array <code>nums</code> representing the amount of money of each house, return <em>the maximum amount of money you can rob tonight <b>without alerting the police</b></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3,1]
<strong>Output:</strong> 4
<strong>Explanation:</strong> Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [2,7,9,3,1]
<strong>Output:</strong> 12
<strong>Explanation:</strong> Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 400</code></li>
</ul>
</div>
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[][] tests = {
            {1,2,3,1},
            {2,7,9,3,1},
            {10,2,3,9},
        };

        for (int[] nums : tests) {
            System.out.println(new HouseRobber_Solution().rob(nums));
        }
    }
}

// 0 ms 41.3 MB
/**
 * <h1 id="intuition">Intuition</h1>
 * <p>The problem can be solved by dynamic programming, considering the two scenarios at each house: whether to rob it or not. The goal is to maximize the total amount of money robbed without alerting the police.</p>
 * <h1 id="approach">Approach</h1>
 * <ol>
<li>Use two variables, <code>rob</code> and <code>norob</code>, to keep track of the maximum amount of money robbed with or without robbing the current house.</li>
<li>Iterate through each house, and at each step, calculate the maximum amount of money if the current house is robbed (<code>newRob</code>) and if it is not robbed (<code>newNoRob</code>).</li>
<li>Update <code>rob</code> and <code>norob</code> for the next iteration.</li>
<li>The final result is the maximum amount between the two scenarios: robbing the last house or not robbing it.</li>
</ol>
 */
class HouseRobber_Solution {
    public int rob(int[] nums) {
        int rob = 0;
        int norob = 0;
        for (int i = 0; i < nums.length; i ++) {
            int newRob = norob + nums[i];
            int newNoRob = Math.max(norob, rob);
            rob = newRob;
            norob = newNoRob;
        }
        return Math.max(rob, norob);
    }
}