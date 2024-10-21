package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/sum-of-absolute-differences-in-a-sorted-array/">1685.Sum of Absolute Differences in a Sorted Array</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an integer array <code>nums</code> sorted in <strong>non-decreasing</strong> order.</p>

<p>Build and return <em>an integer array </em><code>result</code><em> with the same length as </em><code>nums</code><em> such that </em><code>result[i]</code><em> is equal to the <strong>summation of absolute differences</strong> between </em><code>nums[i]</code><em> and all the other elements in the array.</em></p>

<p>In other words, <code>result[i]</code> is equal to <code>sum(|nums[i]-nums[j]|)</code> where <code>0 &lt;= j &lt; nums.length</code> and <code>j != i</code> (<strong>0-indexed</strong>).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,3,5]
<strong>Output:</strong> [4,3,5]
<strong>Explanation:</strong> Assuming the arrays are 0-indexed, then
result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4,
result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3,
result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,4,6,8,10]
<strong>Output:</strong> [24,15,13,15,21]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= nums[i + 1] &lt;= 10<sup>4</sup></code></li>
</ul>
</div></div>
 */
public class SumOfAbsoluteDifferencesInASortedArray {
    public static void main(String[] args) {
        int[][] tests = {
            {2,3,5},
            {1,2},
            {1,4,6,8,10}
        };

        for (int[] nums : tests) {
            System.out.println(Arrays.toString(new SumOfAbsoluteDifferencesInASortedArray_Solution().getSumAbsoluteDifferences(nums)));
        }
    }
}


/**
 * <h1 id="approach">Approach</h1>
 * <ol>
<li>First, calculate the total sum of the array. This sum will be used to compute the right part of the absolute differences.</li>
<li>Initialize two pointers, <code>left</code> and <code>right</code>, pointing to the start and end of the array.</li>
<li>Iterate through the array, and for each element <code>nums[i]</code>, calculate the absolute difference sum by considering the left and right parts.
<ul>
<li><code>left</code> represents the sum of elements to the left of <code>nums[i]</code>.</li>
<li><code>right</code> represents the sum of elements to the right of <code>nums[i]</code>.</li>
<li>The absolute difference sum for <code>nums[i]</code> is calculated as <code>n * i - left + right - n * (nums.length - i - 1)</code>.</li>
</ul>
</li>
<li>Update the <code>left</code> pointer by adding the current element to it.</li>
<li>Update the <code>right</code> pointer by subtracting the current element from it.</li>
<li>Store the result in the output array <code>r</code>.</li>
</ol>
 */
class SumOfAbsoluteDifferencesInASortedArray_Solution {
    // 3 ms 59.5 MB
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int left = 0;
        int right = sum;

        int[] r = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            right -= n;

            r[i] = n * i - left + right - n * (nums.length - i - 1);

            left += n;
        }

        return r;
    }
}

/**
 * <h4 id="approach-1-prefix-sum">Approach 1: Prefix Sum</h4>
 * <p><strong>Intuition</strong></p>
 * <p>Because the input is given sorted, let's try to split the problem into two parts. For a given <code>num</code> at index <code>i</code>, the answer for this index is the sum of:</p>
 * <ol>
<li>The sum of absolute differences between <code>num</code> and all numbers less than <code>num</code>.</li>
<li>The sum of absolute differences between <code>num</code> and all numbers greater than <code>num</code>.</li>
</ol>
<p>As <code>nums</code> is sorted, we can focus on all indices less than <code>i</code> for the first part and all indices greater than <code>i</code> for the second part. Let's start with the first part with the following example.</p>
<p><img src="https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/Figures/1685/1.png" alt="example"><br>
<br></p>
<p>The sum of differences is equivalent to the sum we would have to add to the numbers to make them all equal to <code>8</code>.</p>
<p><img src="https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/Figures/1685/2.png" alt="example"><br>
<br></p>
<p>If we made all the numbers equal to <code>8</code>, they would have a sum equal to <code>8</code> times the count of numbers <code>leftCount</code>. In this specific example, they would have a sum of <code>3 * 8 = 24</code>. In general, for an index <code>i</code>, there are <code>i</code> elements less than <code>nums[i]</code>, so we have <code>leftCount = i</code> and these numbers would have a sum of <code>leftCount * nums[i]</code>.</p>
<p>Their current sum is <code>leftSum = 1 + 4 + 6 = 11</code>. Thus, we can find the sum of absolute differences for these elements as <code>leftTotal = 24 - 11 = 13</code>. In general, we have <code>leftTotal = leftCount * nums[i] - leftSum</code>. This makes sense as it is the difference between what the elements would be if they were all equal to <code>nums[i]</code> minus what they currently are, which is precisely what the problem is asking for.</p>
<p>What about the elements on the right?</p>
<p><img src="https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/Figures/1685/3.png" alt="example"><br>
<br></p>
<p>We can make use of the same idea - how much would we need to <strong>subtract</strong> from the numbers on the right to make them all equal to <code>8</code>? Note we subtract here instead of adding because the numbers on the right are greater.</p>
<p><img src="https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/Figures/1685/4.png" alt="example"><br>
<br></p>
<p>How many elements are on the right? In this example, there are <code>3</code>, so they would have a sum of <code>8 * 3 = 24</code>. In general, for an index <code>i</code>, there are <code>rightCount = n - 1 - i</code> elements on its right, and they would have a sum of <code>rightCount * nums[i]</code> if we reduced them all.</p>
<p>In our example, they currently have a sum of <code>rightSum = 12 + 18 + 21 = 51</code>. Thus, the sum of absolute differences is <code>51 - 24 = 27</code>. In general, we can find the sum of absolute differences as <code>rightTotal = rightSum - rightCount * nums[i]</code>.</p>
<p>Now, we know how to find the answer for each index <code>i</code>. But how do we find <code>leftSum</code> and <code>rightSum</code>? We can make use of prefix sums to find the sum of any subarray in <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(1)O(1)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord">1</span><span class="mclose">)</span></span></span></span></span>.</p>
<p>We start by building a prefix sum array <code>prefix</code>, where <code>prefix[i]</code> represents the sum of all elements up to and including index <code>i</code>. Then, we can calculate <code>leftSum = prefix[i] - nums[i]</code> and <code>rightSum = prefix[n - 1] - prefix[i]</code>. Note that this is simply how we are implementing the prefix sum in this article, and you may implement it in whatever way you are most comfortable. The important thing is that we can quickly calculate <code>leftSum</code> and <code>rightSum</code>.</p>
<p>Once we have <code>prefix</code>, we iterate over each index <code>i</code> and use the process we described above to find <code>leftTotal</code> and <code>rightTotal</code>. Then, the answer for index <code>i</code> is simply <code>leftTotal + rightTotal</code>.</p>
<p><strong>Algorithm</strong></p>
<p>Let <code>n</code> be the length of <code>nums</code>.</p>
<ol>
<li>Create a <code>prefix</code> sum of <code>nums</code>.</li>
<li>Initialize the answer list <code>ans</code>.</li>
<li>Iterate <code>i</code> over the indices of <code>nums</code>:
<ul>
<li>Calculate <code>leftSum</code> using <code>prefix</code>.</li>
<li>Calculate <code>rightSum</code> using <code>prefix</code>.</li>
<li>Calculate <code>leftCount = i</code>.</li>
<li>Calculate <code>rightCount = n - 1 - i</code>.</li>
<li>Calculate <code>leftTotal = leftCount * nums[i] - leftSum</code>.</li>
<li>Calculate <code>rightTotal = rightSum - rightCount * nums[i]</code>.</li>
<li>Add <code>leftTotal + rightTotal</code> to <code>ans</code>.</li>
</ul>
</li>
<li>Return <code>ans</code>.</li>
</ol>
 */
class SumOfAbsoluteDifferencesInASortedArray_Solution2 {
    // 4 ms 57.6 MB
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int leftSum = prefix[i] - nums[i];
            int rightSum = prefix[n - 1] - prefix[i];
            
            int leftCount = i;
            int rightCount = n - 1 - i;
            
            int leftTotal = leftCount * nums[i] - leftSum;
            int rightTotal = rightSum - rightCount * nums[i];
            
            ans[i] = leftTotal + rightTotal;
        }
        
        return ans;
    }
}