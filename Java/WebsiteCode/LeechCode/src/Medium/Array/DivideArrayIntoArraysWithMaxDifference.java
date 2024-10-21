package Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/divide-array-into-arrays-with-max-difference/">2966.Divide Array Into Arrays With Max Difference</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an integer array <code>nums</code> of size <code>n</code> and a positive integer <code>k</code>.</p>

<p>Divide the array into one or more arrays of size <code>3</code> satisfying the following conditions:</p>

<ul>
	<li><strong>Each</strong> element of <code>nums</code> should be in <strong>exactly</strong> one array.</li>
	<li>The difference between <strong>any</strong> two elements in one array is less than or equal to <code>k</code>.</li>
</ul>

<p>Return <em>a </em><strong>2D</strong><em> array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return <strong>any</strong> of them.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,3,4,8,7,9,3,5,1], k = 2
<strong>Output:</strong> [[1,1,3],[3,4,5],[7,8,9]]
<strong>Explanation:</strong> We can divide the array into the following arrays: [1,1,3], [3,4,5] and [7,8,9].
The difference between any two elements in each array is less than or equal to 2.
Note that the order of elements is not important.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,3,3,2,7,3], k = 3
<strong>Output:</strong> []
<strong>Explanation:</strong> It is not possible to divide the array satisfying all the conditions.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>n</code> is a multiple of <code>3</code>.</li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>5</sup></code></li>
</ul>
</div>
 */
public class DivideArrayIntoArraysWithMaxDifference {
    public static void main(String[] args) {
        int[][][] tests = {
            // {{1,3,4,8,7,9,3,5,1},{2}},
            // {{1,3,3,2,7,3},{3}},
            {{15,13,12,13,12,14,12,2,3,13,12,14,14,13,5,12,12,2,13,2,2},{2}}
        };

        for (int[][] test : tests) {
            int[] nums = test[0];
            int k = test[1][0];

            int[][] ans = new DivideArrayIntoArraysWithMaxDifference_Solution().divideArray(nums, k);

            System.out.print("[");
            for (int[] arr : ans) {
                System.out.print(Arrays.toString(arr));
            }
            System.out.println("]");
        }
    }
}

// 423 ms 55.7 MB 
class DivideArrayIntoArraysWithMaxDifference_Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] result = new int[0][0];
        
        for (int i = 0; i + 2 < nums.length; ++i) {
            if (i % 3 == 0) {
                if (nums[i + 2] - nums[i] <= k) {
                    int[] triplet = {nums[i], nums[i + 1], nums[i + 2]};
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = triplet;
                } else {
                    return new int[0][0];
                }
            }
        }
        
        return result;
    }
}