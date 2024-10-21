package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/maximum-product-of-two-elements-in-an-array/">1464.Maximum Product of Two Elements in an Array</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content">Given the array of integers <code>nums</code>, you will choose two different indices <code>i</code> and <code>j</code> of that array. <em>Return the maximum value of</em> <code>(nums[i]-1)*(nums[j]-1)</code>.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [3,4,5,2]
<strong>Output:</strong> 12 
<strong>Explanation:</strong> If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12. 
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,5,4,5]
<strong>Output:</strong> 16
<strong>Explanation:</strong> Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [3,7]
<strong>Output:</strong> 12
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 500</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10^3</code></li>
</ul>
</div></div>
 */
public class MaximumProductOfTwoElementsInAnArray {
    public static void main(String[] args) {
        int[][] tests = {
            {3,4,5,2},
            {1,5,4,5},
            {3,7}
        };

        for (int[] nums : tests) {
            System.out.println(new MaximumProductOfTwoElementsInAnArray_Solution().maxProduct(nums));
        }
    }
}

// 0 ms 42.3 MB
class MaximumProductOfTwoElementsInAnArray_Solution {
    public int maxProduct(int[] nums) {
        int max1 = nums[0];
        int max2 = nums[1];

        for(int i=2;i<nums.length;i++){
            if(nums[i] > max1){
                max2 = (max1 > max2 ) ? max1:max2;
                max1 = nums[i];
            }
            else if(nums[i] > max2){
                max2 = nums[i];
            }
        }

        return (max1-1)*(max2-1);
    }
}
