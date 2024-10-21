package BetterCodeAnswer.Easy.Arrays;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/range-sum-query-immutable/">303. Range Sum Query - Immutable</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code>, handle multiple queries of the following type:</p>

<ol>
	<li>Calculate the <strong>sum</strong> of the elements of <code>nums</code> between indices <code>left</code> and <code>right</code> <strong>inclusive</strong> where <code>left &lt;= right</code>.</li>
</ol>

<p>Implement the <code>NumArray</code> class:</p>

<ul>
	<li><code>NumArray(int[] nums)</code> Initializes the object with the integer array <code>nums</code>.</li>
	<li><code>int sumRange(int left, int right)</code> Returns the <strong>sum</strong> of the elements of <code>nums</code> between indices <code>left</code> and <code>right</code> <strong>inclusive</strong> (i.e. <code>nums[left] + nums[left + 1] + ... + nums[right]</code>).</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input</strong>
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
<strong>Output</strong>
[null, 1, -1, -3]

<strong>Explanation</strong>
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= left &lt;= right &lt; nums.length</code></li>
	<li>At most <code>10<sup>4</sup></code> calls will be made to <code>sumRange</code>.</li>
</ul>
</div>
 */
public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        Object[][][][] tests = {
            {
                {{"NumArray", "sumRange", "sumRange", "sumRange"}},
                {{-2, 0, 3, -5, 2, -1},{0, 2},{2, 5},{0,5}}
            }
        };

        for (Object[][][] test : tests) {
            String[] actions = Arrays.stream(test[0][0])
                                    .map(Object::toString)
                                    .toArray(String[]::new);
            int[][] nums = Arrays.stream(test[1])
                                 .map(
                                        row -> Arrays.stream(row)
                                                 .mapToInt(obj -> (int) obj)
                                                 .toArray()
                                    )
                                 .toArray(int[][]::new);

            Object[] res = new Object[actions.length];
            int i = 1;
            NumArray array = new NumArray(nums[0]);
            res[0] = null;
            for (String action : actions) {
                if (action.equals("NumArray")) {} 
                else {
                    res[i] = array.sumRange(nums[i][0],nums[i][1]);
                    i++;
                }
            }

            System.out.println(Arrays.toString(res));
        }
    }
}

// 7 ms 49 MB
class NumArray {
    int[] n;
    int[] prefixSums;
    public NumArray(int[] nums) {
        n = nums;
        prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            prefixSums[i] = prefixSums[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSums[right];
        }else {
            return prefixSums[right] - prefixSums[left-1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */