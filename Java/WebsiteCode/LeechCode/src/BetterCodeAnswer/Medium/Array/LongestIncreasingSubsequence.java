package BetterCodeAnswer.Medium.Array;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/longest-increasing-subsequence/">300.Longest Increasing Subsequence</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an integer array <code>nums</code>, return <em>the length of the longest <strong>strictly increasing </strong></em><span data-keyword="subsequence-array" class=" cursor-pointer relative text-dark-blue-s text-sm"><div class="popover-wrapper inline-block" data-headlessui-state=""><div><div aria-expanded="false" data-headlessui-state="" id="headlessui-popover-button-:re:"><div><em><strong>subsequence</strong></em></div></div><div style="position: fixed; z-index: 40; inset: 0px auto auto 0px; transform: translate(237px, 269px);"></div></div></div></span>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [10,9,2,5,3,7,101,18]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [0,1,0,3,2,3]
<strong>Output:</strong> 4
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [7,7,7,7,7,7,7]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2500</code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><b>Follow up:</b>&nbsp;Can you come up with an algorithm that runs in&nbsp;<code>O(n log(n))</code> time complexity?</p>
</div></div>
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[][] tests = {
            {10,9,2,5,3,7,101,18},
            {0,1,0,3,2,3},
            {7,7,7,7,7,7,7},
        };

        for (int[] nums : tests) {
            System.out.println(new LongestIncreasingSubsequence_Solution().lengthOfLIS(nums));
        }
    }
}

// 2 ms 43.9 MB
/**
 * <h1 id="approach">Approach</h1>
 * <p>We can solve this problem efficiently using dynamic programming. The key idea is to maintain an array <code>tails</code> where <code>tails[i]</code> represents the smallest ending element of all increasing subsequences of length <code>i+1</code>. This array is crucial in determining where the current element <code>x</code> fits in the existing subsequences.</p>
 * <ol>
<li>
<p>Initialize an array <code>tails</code> of the same length as <code>nums</code> to store the ending elements of increasing subsequences.</p>
</li>
<li>
<p>Initialize a variable <code>size</code> to keep track of the current length of the longest increasing subsequence.</p>
</li>
<li>
<p>Iterate through each element <code>x</code> in <code>nums</code>:</p>
<ul>
<li>
<p>Use binary search to find the correct position for <code>x</code> in the <code>tails</code> array.</p>
</li>
<li>
<p>Update the corresponding position in <code>tails</code> with <code>x</code>.</p>
</li>
<li>
<p>If <code>x</code> is greater than all ending elements in <code>tails</code>, append it to the end and increment <code>size</code>.</p>
</li>
</ul>
</li>
<li>
<p>The final value of <code>size</code> represents the length of the longest increasing subsequence.</p>
</li>
</ol>
 */
class LongestIncreasingSubsequence_Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}