package BetterCodeAnswer.Medium.Array;

/*
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-the-duplicate-number/">287.Find the Duplicate Number</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of integers <code>nums</code> containing&nbsp;<code>n + 1</code> integers where each integer is in the range <code>[1, n]</code> inclusive.</p>

<p>There is only <strong>one repeated number</strong> in <code>nums</code>, return <em>this&nbsp;repeated&nbsp;number</em>.</p>

<p>You must solve the problem <strong>without</strong> modifying the array <code>nums</code>&nbsp;and uses only constant extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,3,4,2,2]
<strong>Output:</strong> 2
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [3,1,3,4,2]
<strong>Output:</strong> 3
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [3,3,3,3,3]
<strong>Output:</strong> 3</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>nums.length == n + 1</code></li>
	<li><code>1 &lt;= nums[i] &lt;= n</code></li>
	<li>All the integers in <code>nums</code> appear only <strong>once</strong> except for <strong>precisely one integer</strong> which appears <strong>two or more</strong> times.</li>
</ul>

<p>&nbsp;</p>
<p><b>Follow up:</b></p>

<ul>
	<li>How can we prove that at least one duplicate number must exist in <code>nums</code>?</li>
	<li>Can you solve the problem in linear runtime complexity?</li>
</ul>
</div>
 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[][] tests = {
            {1,3,4,2,2},
            {3,1,3,4,2},
            {3,3,3,3,3}
        };

        for (int[] nums : tests) {
            System.out.println(new FindTheDuplicateNumber_Solution().findDuplicate(nums));
        }
    }
}

// 1 ms 58.54 MB
class FindTheDuplicateNumber_Solution {
    public int findDuplicate(int[] nums) {
        boolean[] taken = new boolean[nums.length];
        
        for (int num : nums) {
            if (taken[num]) {
                return num;
            }
            taken[num] = true;
        }
        return 0;
    }
}