package BetterCodeAnswer.Hard.Array;

import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/minimum-number-of-operations-to-make-array-continuous/">2009.Minimum Number of Operations to Make Array Continuous</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an integer array <code>nums</code>. In one operation, you can replace <strong>any</strong> element in <code>nums</code> with <strong>any</strong> integer.</p>

<p><code>nums</code> is considered <strong>continuous</strong> if both of the following conditions are fulfilled:</p>

<ul>
	<li>All elements in <code>nums</code> are <strong>unique</strong>.</li>
	<li>The difference between the <strong>maximum</strong> element and the <strong>minimum</strong> element in <code>nums</code> equals <code>nums.length - 1</code>.</li>
</ul>

<p>For example, <code>nums = [4, 2, 5, 3]</code> is <strong>continuous</strong>, but <code>nums = [1, 2, 3, 5, 6]</code> is <strong>not continuous</strong>.</p>

<p>Return <em>the <strong>minimum</strong> number of operations to make </em><code>nums</code><em> </em><strong><em>continuous</em></strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [4,2,5,3]
<strong>Output:</strong> 0
<strong>Explanation:</strong>&nbsp;nums is already continuous.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3,5,6]
<strong>Output:</strong> 1
<strong>Explanation:</strong>&nbsp;One possible solution is to change the last element to 4.
The resulting array is [1,2,3,5,4], which is continuous.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [1,10,100,1000]
<strong>Output:</strong> 3
<strong>Explanation:</strong>&nbsp;One possible solution is to:
- Change the second element to 2.
- Change the third element to 3.
- Change the fourth element to 4.
The resulting array is [1,2,3,4], which is continuous.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>
</div></div>
 */
public class MinimumNumberOfOperationsToMakeArrayContinuous {
    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 3};

        MinimumNumberOfOperationsToMakeArrayContinuous_Solution res = new MinimumNumberOfOperationsToMakeArrayContinuous_Solution();

        System.out.println(res.minOperations(nums));
    }
}

/**
 * <h1 id="solution">Solution:🚀</h1>
 * <h6 id="1-sort-the-nums-array-in-ascending-order-to-ensure-that-the-elements-are-in-increasing-order">1. Sort the <strong>nums</strong> array in ascending order to ensure that the elements are in increasing order.</h6>
 * <h6 id="2-create-a-set-from-the-sorted-nums-array-to-remove-duplicates-this-step-ensures-that-all-elements-are-unique">2. Create a set from the sorted <strong>nums</strong> array to remove duplicates. This step ensures that all elements are unique.</h6>
 * <h6 id="3-initialize-a-variable-ans-with-a-large-value-to-store-the-minimum-number-of-operations-required-to-make-the-array-continuous-you-can-use-sysmaxsize-for-this-purpose">3. Initialize a variable <strong>ans</strong> with a large value to store the minimum number of operations required to make the array continuous. You can use <strong>sys.maxsize</strong> for this purpose.</h6>
 * <h6 id="4-iterate-through-the-unique-elements-of-the-sorted-nums-array-for-each-element-s-in-the-iteration">4. Iterate through the unique elements of the sorted <strong>nums</strong> array. For each element <strong>s</strong> in the iteration:</h6>
 * <ul>
<li>Calculate the expected end element <strong>e</strong> of a continuous subarray. This is done by adding <strong>n - 1</strong> to the current element <strong>s</strong>, where <strong>n</strong> is the length of the input array <strong>nums</strong>. This step ensures that the difference between the maximum and minimum elements in the continuous subarray is <strong>n - 1</strong>.</li>
<li>Use the <strong>bisect_right</strong> function to find the index <strong>idx</strong> where the expected end element <strong>e</strong> would be inserted into the sorted <strong>nums</strong> array while maintaining its order. This index represents the position where the end element of the continuous subarray would be inserted if it exists in <strong>nums</strong>.</li>
<li>Update the <strong>ans</strong> variable with the minimum number of operations needed to make the array continuous. This minimum is calculated as <strong>n - (idx - i)</strong>, where <strong>idx</strong> is the position of the expected end element, and i is the current position of the start element.</li>
</ul>
<h6 id="5-finally-return-the-minimum-number-of-operations-stored-in-the-ans-variable">5. Finally, return the minimum number of operations stored in the <strong>ans</strong> variable.</h6>
<h4 id="insights-used-to-solve-the-problem">Insights used to solve the problem:</h4>
<ul>
<li>
<h6 id="sorting-the-array-and-removing-duplicates-by-creating-a-set-helps-in-ensuring-that-all-elements-are-unique-and-in-ascending-order-which-simplifies-the-calculation-of-the-expected-end-element">Sorting the array and removing duplicates by creating a set helps in ensuring that all elements are unique and in ascending order, which simplifies the calculation of the expected end element.</h6>
</li>
<li>
<h6 id="the-key-insight-is-that-for-an-array-to-be-continuous-the-difference-between-the-maximum-and-minimum-elements-should-be-equal-to-n---1-where-n-is-the-length-of-the-array-therefore-you-can-calculate-the-expected-end-element-based-on-the-start-element-and-find-its-position-in-the-sorted-array-to-determine-the-minimum-number-of-operations-needed">The key insight is that for an array to be continuous, the difference between the maximum and minimum elements should be equal to <strong>n - 1</strong>, where <strong>n</strong> is the length of the array. Therefore, you can calculate the expected end element based on the start element and find its position in the sorted array to determine the minimum number of operations needed.</h6>
</li>
<li>
<h6 id="using-the-bisect_right-function-is-an-efficient-way-to-find-the-index-where-the-expected-end-element-would-be-inserted-as-it-takes-advantage-of-the-sorted-nature-of-the-array">Using the <strong>bisect_right</strong> function is an efficient way to find the index where the expected end element would be inserted, as it takes advantage of the sorted nature of the array.</h6>
</li>
<li>
<h6 id="keeping-track-of-the-minimum-number-of-operations-ans-during-the-iteration-and-updating-it-whenever-a-more-optimal-solution-is-found-ensures-that-you-find-the-minimum-operations-overall">Keeping track of the minimum number of operations (<strong>ans</strong>) during the iteration and updating it whenever a more optimal solution is found ensures that you find the minimum operations overall.</h6>
</li>
</ul>
<h1 id="space-and-time-complexity️">Space and Time Complexity:⏲️</h1>
<h4 id="time-complexity-onlognon--lognonlogn">Time Complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n∗log(n))O(n * log(n))</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">∗</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.01968em;">l</span><span class="mord mathnormal">o</span><span class="mord mathnormal" style="margin-right: 0.03588em;">g</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">))</span></span></span></span></span></h4>
<h4 id="space-complexity-ononon">Space Complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n)O(n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span></h4>

 */
class MinimumNumberOfOperationsToMakeArrayContinuous_Solution {
    // 37 ms
    // 55.9 -> 55.7 (len = num.length)
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int count=Integer.MAX_VALUE,j=1,dup=0, len = nums.length;
        int[] dupArr = new int[len];
        for(int i=0;i<len;i++) {
            while(j<len&&nums[j]<=nums[i]+len-1) {
                if(nums[j]==nums[j-1]) ++dup;
                dupArr[j]=dup;
                j++;
            }
            count = Math.min(count, i+(len-j)+dup-dupArr[i]);
        }
        return count;
    }
}
