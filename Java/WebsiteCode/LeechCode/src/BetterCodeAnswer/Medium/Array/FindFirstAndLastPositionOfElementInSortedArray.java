package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/find-first-and-last-position-of-element-in-sorted-array/">34.Find First and Last Position of Element in Sorted Array</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an array of integers <code>nums</code> sorted in non-decreasing order, find the starting and ending position of a given <code>target</code> value.</p>

<p>If <code>target</code> is not found in the array, return <code>[-1, -1]</code>.</p>

<p>You must&nbsp;write an algorithm with&nbsp;<code>O(log n)</code> runtime complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 8
<strong>Output:</strong> [3,4]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [5,7,7,8,8,10], target = 6
<strong>Output:</strong> [-1,-1]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [], target = 0
<strong>Output:</strong> [-1,-1]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup>&nbsp;&lt;= nums[i]&nbsp;&lt;= 10<sup>9</sup></code></li>
	<li><code>nums</code> is a non-decreasing array.</li>
	<li><code>-10<sup>9</sup>&nbsp;&lt;= target&nbsp;&lt;= 10<sup>9</sup></code></li>
</ul>
</div></div>
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 7;

        FindFirstAndLastPositionOfElementInSortedArray_Solution result = new FindFirstAndLastPositionOfElementInSortedArray_Solution();

        System.out.println(Arrays.toString(result.searchRange(nums, target)));
    }
}

/**
 * <h1 id="algorithm-explanationbinary-search-">Algorithm Explanation:(Binary Search) 🚀</h1>
 * 
 * <h6 id="1-the-algorithm-uses-a-modified-binary-search-approach-to-find-both-the-leftmost-and-rightmost-occurrences-of-the-target-element-in-a-sorted-array">1. The algorithm uses a modified binary search approach to find both the leftmost and rightmost occurrences of the target element in a sorted array.</h6>
 * <h6 id="2-it-defines-a-binary_search-function-that-takes-three-parameters">2. It defines a <strong>binary_search</strong> function that takes three parameters:</h6>
 * <ul>
<li><strong>nums:</strong> The sorted array to search in.</li>
<li><strong>target:</strong> The target value we are looking for.</li>
<li><strong>left:</strong> A boolean flag indicating whether to search for the leftmost (<strong>True</strong>) or rightmost (<strong>False</strong>) occurrence of the target.</li>
</ul>
<h6 id="3-inside-the-binary_search-function">3. Inside the <strong>binary_search</strong> function:</h6>
<ul>
<li>Initialize <strong>low</strong> and <strong>high</strong> indices to the beginning and end of the array, respectively.</li>
<li>Initialize <strong>index</strong> to -1, which will store the index of the target if found.</li>
</ul>
<h6 id="4-the-algorithm-enters-a-while-loop-that-continues-as-long-as-low-is-less-than-or-equal-to-high">4. The algorithm enters a while loop that continues as long as <strong>low</strong> is less than or equal to <strong>high</strong>.</h6>
<h6 id="5-in-each-iteration-of-the-while-loop">5. In each iteration of the while loop:</h6>
<ul>
<li>Calculate the <strong>mid</strong> index.</li>
<li>Check if <strong>nums[mid]</strong> is equal to the target. If it is:</li>
<li>Update <strong>index</strong> to the current <strong>mid</strong> value.</li>
<li>Adjust <strong>low</strong> and <strong>high</strong> indices accordingly based on the <strong>left</strong> flag:</li>
<li>If <strong>left</strong> is <strong>True</strong>, set <strong>high</strong> to <strong>mid - 1</strong> to search for the leftmost occurrence.</li>
<li>If <strong>left</strong> is <strong>False</strong>, set <strong>low</strong> to <strong>mid + 1</strong> to search for the rightmost occurrence.</li>
<li>If <strong>nums[mid]</strong> is less than the target, update <strong>low</strong> to <strong>mid + 1</strong> to search on the right side.</li>
<li>If <strong>nums[mid]</strong> is greater than the target, update <strong>high</strong> to <strong>mid - 1</strong> to search on the left side.</li>
</ul>
<h6 id="6-after-the-while-loop-the-binary_search-function-returns-index-which-contains-the-index-of-either-the-leftmost-or-rightmost-occurrence-of-the-target">6. After the while loop, the <strong>binary_search</strong> function returns <strong>index</strong>, which contains the index of either the leftmost or rightmost occurrence of the target.</h6>
<h6 id="7-in-the-main-searchrange-function">7. In the main <strong>searchRange</strong> function:</h6>
<ul>
<li>Call the <strong>binary_search</strong> function twice, once to find the leftmost occurrence (<strong>left=True</strong>) and once to find the rightmost occurrence (<strong>left=False</strong>) of the target.</li>
</ul>
<h6 id="8-finally-return-a-list-left_index-right_index-where-left_index-is-the-index-of-the-leftmost-occurrence-and-right_index-is-the-index-of-the-rightmost-occurrence-of-the-target-if-the-target-is-not-found-both-indices-will-be--1">8. Finally, return a list <strong>[left_index, right_index]</strong>, where <strong>left_index</strong> is the index of the leftmost occurrence, and <strong>right_index</strong> is the index of the rightmost occurrence of the target. If the target is not found, both indices will be -1.</h6>
<h1 id="time-complexity-️">Time Complexity: ⏲️</h1>
<h6 id="the-time-complexity-of-the-algorithm-is-olognolog-nologn-because-it-performs-two-binary-searches-each-binary-search-takes-olognolog-nologn-time-in-the-worst-case-because-it-divides-the-search-space-in-half-with-each-iteration-since-we-perform-two-separate-binary-searches-one-to-find-the-leftmost-occurrence-and-another-to-find-the-rightmost-occurrence-the-overall-time-complexity-remains-olognolog-nologn">The time complexity of the algorithm is <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(logN)O(log N)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.01968em;">l</span><span class="mord mathnormal">o</span><span class="mord mathnormal" style="margin-right: 0.03588em;">g</span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span><span class="mclose">)</span></span></span></span></span> because it performs two binary searches. Each binary search takes <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(logN)O(log N)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.01968em;">l</span><span class="mord mathnormal">o</span><span class="mord mathnormal" style="margin-right: 0.03588em;">g</span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span><span class="mclose">)</span></span></span></span></span> time in the worst case because it divides the search space in half with each iteration. Since we perform two separate binary searches (one to find the leftmost occurrence and another to find the rightmost occurrence), the overall time complexity remains <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(logN)O(log N)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.01968em;">l</span><span class="mord mathnormal">o</span><span class="mord mathnormal" style="margin-right: 0.03588em;">g</span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span><span class="mclose">)</span></span></span></span></span>.</h6>
The time complexity of the algorithm is 
<span class="math math-inline"><span class="katex"><span class="katex-mathml">O(logN)O(log N)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.01968em;">l</span><span class="mord mathnormal">o</span><span class="mord mathnormal" style="margin-right: 0.03588em;">g</span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span><span class="mclose">)</span></span></span></span></span>
 because it performs two binary searches. Each binary search takes 
 <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(logN)O(log N)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.01968em;">l</span><span class="mord mathnormal">o</span><span class="mord mathnormal" style="margin-right: 0.03588em;">g</span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span><span class="mclose">)</span></span></span></span></span>
  time in the worst case because it divides the search space in half with each iteration. Since we perform two separate binary searches (one to find the leftmost occurrence and another to find the rightmost occurrence), the overall time complexity remains 
  <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(logN)O(log N)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.01968em;">l</span><span class="mord mathnormal">o</span><span class="mord mathnormal" style="margin-right: 0.03588em;">g</span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span><span class="mclose">)</span></span></span></span></span>
  <h1 id="space-complexity-️">Space Complexity: 🛰️</h1>
  <h6 id="the-space-complexity-of-the-algorithm-is-o1o1o1-which-means-it-uses-a-constant-amount-of-extra-space-regardless-of-the-input-size-the-algorithm-doesnt-create-any-additional-data-structures-or-allocate-memory-based-on-the-size-of-the-input-array-nums-it-uses-a-few-variables-such-as-low-high-index-and-the-functions-arguments-that-occupy-a-constant-amount-of-memory-therefore-the-space-complexity-is-constant-and-not-dependent-on-the-input-size">The space complexity of the algorithm is <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(1)O(1)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord">1</span><span class="mclose">)</span></span></span></span></span>, which means it uses a constant amount of extra space regardless of the input size. The algorithm doesn't create any additional data structures or allocate memory based on the size of the input array <strong>nums</strong>. It uses a few variables (such as <strong>low</strong>, <strong>high</strong>, <strong>index</strong>, and the function's arguments) that occupy a constant amount of memory. Therefore, the space complexity is constant and not dependent on the input size.</h6>

 */
class FindFirstAndLastPositionOfElementInSortedArray_Solution {
    // 0 ms
    // 44.1 MB
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false);

        if (leftIndex <= rightIndex) {
            return new int[]{leftIndex, rightIndex};
        } else {
            return new int[]{-1, -1};
        }
    }

    private int binarySearch(int[] nums, int target, boolean findLeft) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = mid;
                if (findLeft) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return index;
    }
}

/**
 * <h1 id="algorithm-explanationlinear-search-">Algorithm Explanation:(Linear Search) 🚀</h1>
 * 
 * <h6 id="the-solution-youve-provided-finds-the-starting-and-ending-positions-of-a-given-target-value-in-a-sorted-array-nums-using-a-linear-search-approach-however-it-doesnt-meet-the-requirement-of-having-olognolog-nologn-runtime-complexity">The solution you've provided finds the starting and ending positions of a given target value in a sorted array <strong>nums</strong> using a linear search approach. However, it doesn't meet the requirement of having <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(logN)O(log N)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.01968em;">l</span><span class="mord mathnormal">o</span><span class="mord mathnormal" style="margin-right: 0.03588em;">g</span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span><span class="mclose">)</span></span></span></span></span> runtime complexity.</h6>
 * <h6 id="1-initialize-start-and-end-to--1-these-variables-will-be-used-to-store-the-starting-and-ending-positions-of-the-target-value">1. Initialize <strong>start</strong> and <strong>end</strong> to -1. These variables will be used to store the starting and ending positions of the target value.</h6>
 * <h6 id="2-loop-through-the-array-nums-from-the-beginning-left-to-right-using-a-for-loop-inside-the-loop-check-if-the-current-element-is-equal-to-the-target-value">2. Loop through the array <strong>nums</strong> from the beginning (left to right) using a <strong>for</strong> loop. Inside the loop, check if the current element is equal to the target value.</h6>
 * <h6 id="3-if-the-current-element-is-equal-to-the-target-value-set-the-start-variable-to-the-current-index-i-and-break-out-of-the-loop">3. If the current element is equal to the target value, set the <strong>start</strong> variable to the current index <strong>i</strong> and break out of the loop.</h6>
 * <h6 id="4-after-the-first-loop-check-if-start-is-still--1-if-it-is-that-means-the-target-value-was-not-found-in-the-array-so-return--1--1-as-the-result">4. After the first loop, check if <strong>start</strong> is still -1. If it is, that means the target value was not found in the array, so return <strong>[-1, -1]</strong> as the result.</h6>
 * <h6 id="5-next-loop-through-the-array-nums-in-reverse-right-to-left-using-another-for-loop-inside-this-loop-again-check-if-the-current-element-is-equal-to-the-target-value">5. Next, loop through the array <strong>nums</strong> in reverse (right to left) using another <strong>for</strong> loop. Inside this loop, again check if the current element is equal to the target value.</h6>
 * <h6 id="6-if-the-current-element-is-equal-to-the-target-value-set-the-end-variable-to-the-current-index-i-and-break-out-of-the-loop">6. If the current element is equal to the target value, set the <strong>end</strong> variable to the current index <strong>i</strong> and break out of the loop.</h6>
 * <h6 id="7-finally-after-both-loops-return-start-end-as-the-result-this-will-give-you-the-starting-and-ending-positions-of-the-target-value-in-the-array-or--1--1-if-the-target-value-is-not-present">7. Finally, after both loops, return <strong>[start, end]</strong> as the result. This will give you the starting and ending positions of the target value in the array, or <strong>[-1, -1]</strong> if the target value is not present.</h6>
 * <h4 id="while-this-solution-works-it-has-a-time-complexity-of-ononon-as-it-iterates-through-the-entire-array-in-both-forward-and-backward-directions">While this solution works, it has a time complexity of <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n)O(n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span>, as it iterates through the entire array in both forward and backward directions.</h4>
 */
class FindFirstAndLastPositionOfElementInSortedArray_Solution2 {
    // 0 ms
    // 44.2 MB
    public int[] searchRange(int[] nums, int target) {
        int start = -1, end = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            return new int[]{-1, -1};
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                end = i;
                break;
            }
        }

        return new int[]{start, end};
    }
}