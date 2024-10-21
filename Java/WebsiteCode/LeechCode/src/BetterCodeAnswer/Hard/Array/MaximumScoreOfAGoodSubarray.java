package BetterCodeAnswer.Hard.Array;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/maximum-score-of-a-good-subarray/">1793.Maximum Score of a Good Subarray</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an array of integers <code>nums</code> <strong>(0-indexed)</strong> and an integer <code>k</code>.</p>

<p>The <strong>score</strong> of a subarray <code>(i, j)</code> is defined as <code>min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1)</code>. A <strong>good</strong> subarray is a subarray where <code>i &lt;= k &lt;= j</code>.</p>

<p>Return <em>the maximum possible <strong>score</strong> of a <strong>good</strong> subarray.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,4,3,7,4,5], k = 3
<strong>Output:</strong> 15
<strong>Explanation:</strong> The optimal subarray is (1, 5) with a score of min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15. 
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [5,5,4,5,4,1,1,1], k = 0
<strong>Output:</strong> 20
<strong>Explanation:</strong> The optimal subarray is (0, 4) with a score of min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= k &lt; nums.length</code></li>
</ul>
</div></div>
 */
public class MaximumScoreOfAGoodSubarray {
    public static void main(String[] args) {
        int[][][] test = {
            {{1,4,3,7,4,5},{3}},
            {{5,5,4,5,4,1,1,1},{0}}
        };

        MaximumScoreOfAGoodSubarray_Solution res = new MaximumScoreOfAGoodSubarray_Solution();

        for (int i = 0; i < test.length; i++) {
            int[] nums = test[i][0];
            int k = test[i][1][0];

            System.out.println(res.maximumScore(nums, k));
        }

    }
}

/**
 * <h1 id="intuition">Intuition:</h1>
 * 
 * <p>The goal is to find a good subarray, which starts at index <code>k</code>. A good subarray is one where <code>k</code> is positioned in such a way that it optimizes the minimum value of the subarray while maximizing its length.</p>
 * 
 * <h1 id="approach">Approach:</h1>
 * 
 * <ol>
<li>Initialize the result variable <code>res</code> and the minimum variable <code>mini</code> to the value at index <code>k</code>. The idea is to start with <code>k</code> as the midpoint of the subarray.</li>
<li>Initialize two pointers, <code>i</code> and <code>j</code>, both initially set to <code>k</code>. These pointers will help expand the subarray.</li>
<li>While one of the pointers (<code>i</code> or <code>j</code>) is not at the boundary of the array:
<ul>
<li>If <code>i</code> is at the left boundary (0), increment <code>j</code>.</li>
<li>If <code>j</code> is at the right boundary (<code>n - 1</code>), decrement <code>i</code>.</li>
<li>If the element at <code>A[i - 1]</code> is smaller than the element at <code>A[j + 1]</code>, increment <code>j</code> to expand the subarray to the right.</li>
<li>Otherwise, decrement <code>i</code> to expand the subarray to the left.</li>
</ul>
</li>
<li>Update <code>mini</code> with the minimum value between <code>A[i]</code> and <code>A[j]</code>.</li>
<li>Update <code>res</code> with the maximum of the current <code>res</code> and <code>mini * (j - i + 1)</code>. This step is crucial as it calculates the score of the current subarray and keeps track of the maximum score found.</li>
<li>Continue the process until one of the pointers reaches a boundary.</li>
<li>Finally, return <code>res</code> as the maximum score of a good subarray.</li>
</ol>
 */
class MaximumScoreOfAGoodSubarray_Solution {
    // 8 ms 
    // 56.8 MB
    public int maximumScore(int[] nums, int k) {
        int res = nums[k], mini = nums[k], i = k, j = k, n = nums.length;
        while (i > 0 || j < n - 1) {
            if (i == 0)
                ++j;
            else if (j == n - 1)
                --i;
            else if (nums[i - 1] < nums[j + 1])
                ++j;
            else
                --i;
            mini = Math.min(mini, Math.min(nums[i], nums[j]));
            res = Math.max(res, mini * (j - i + 1));
        }
        return res;
    }
}
