package Hard.Array;

import java.util.ArrayList;

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
        int[] nums = {44,28,33,49,4,2,35,28,25,38,47,20,14,30,27,38,42,14,34};

        MinimumNumberOfOperationsToMakeArrayContinuous_Solution res = new MinimumNumberOfOperationsToMakeArrayContinuous_Solution();

        System.out.println(res.minOperations(nums));
    }
}

class MinimumNumberOfOperationsToMakeArrayContinuous_Solution {
    // Time Limit Exceeded
    public int minOperations(int[] nums) {
        int minNumbChange = Integer.MAX_VALUE;
        int numbChange;
        int len = nums.length;
        ArrayList<Integer> arrNumb = new ArrayList<>();

        for (int i = 0; i < len; i++){
            numbChange = 0;
            arrNumb.clear();
            for (int num : nums) {
                if (num > nums[i] + len - 1 || num < nums[i]) {
                    numbChange++;
                    continue;
                }

                if (!arrNumb.contains(num)) {
                    arrNumb.add(num);
                } else {
                    numbChange++;
                }
            }

            if (minNumbChange > numbChange) {
                minNumbChange = numbChange;
            } 
        }

        return minNumbChange;
    }
}