package Easy.Arrays;


import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/squares-of-a-sorted-array/">977.Squares of a Sorted Array</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code> sorted in <strong>non-decreasing</strong> order, return <em>an array of <strong>the squares of each number</strong> sorted in non-decreasing order</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [-4,-1,0,3,10]
<strong>Output:</strong> [0,1,9,16,100]
<strong>Explanation:</strong> After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [-7,-3,2,3,11]
<strong>Output:</strong> [4,9,9,49,121]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code><span>1 &lt;= nums.length &lt;= </span>10<sup>4</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>nums</code> is sorted in <strong>non-decreasing</strong> order.</li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Squaring each element and sorting the new array is very trivial, could you find an <code>O(n)</code> solution using a different approach?</div>
 */
public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[][] tests = {
            {-4,-1,0,3,10},
            {-7,-3,2,3,11},
            {11,-7,-3,2,3}
        };

        for (int[] nums : tests) {
            System.out.println(Arrays.toString(new SquaresOfASortedArray_Solution().sortedSquares(nums)));
        }
    }
}

// 10 ms 45.9 MB
class SquaresOfASortedArray_Solution {
    public int[] sortedSquares(int[] nums) {
        
        nums = Arrays.stream(nums).map(t->t*t).toArray();
        Arrays.sort(nums);

        return nums;
    }
}
