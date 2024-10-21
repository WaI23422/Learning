package Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/rearrange-array-elements-by-sign/">2149.Rearrange Array Elements by Sign</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> integer array <code>nums</code> of <strong>even</strong> length consisting of an <strong>equal</strong> number of positive and negative integers.</p>

<p>You should <strong>rearrange</strong> the elements of <code>nums</code> such that the modified array follows the given conditions:</p>

<ol>
	<li>Every <strong>consecutive pair</strong> of integers have <strong>opposite signs</strong>.</li>
	<li>For all integers with the same sign, the <strong>order</strong> in which they were present in <code>nums</code> is <strong>preserved</strong>.</li>
	<li>The rearranged array begins with a positive integer.</li>
</ol>

<p>Return <em>the modified array after rearranging the elements to satisfy the aforementioned conditions</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [3,1,-2,-5,2,-4]
<strong>Output:</strong> [3,-2,1,-5,2,-4]
<strong>Explanation:</strong>
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.  
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [-1,1]
<strong>Output:</strong> [1,-1]
<strong>Explanation:</strong>
1 is the only positive integer and -1 the only negative integer in nums.
So nums is rearranged to [1,-1].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>nums.length</code> is <strong>even</strong></li>
	<li><code>1 &lt;= |nums[i]| &lt;= 10<sup>5</sup></code></li>
	<li><code>nums</code> consists of <strong>equal</strong> number of positive and negative integers.</li>
</ul>
</div>
 */
public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[][] tests = {
            {3,1,-2,-5,2,-4},
            {3,-1,-2,-4,5,2},
            {-1,1},
            {-1,-2,-1,1,2,3},
            {-2,-1,1,2,2,-4}
        };

        for (int[] nums : tests) {
            System.out.println(Arrays.toString(new RearrangeArrayElementsBySign_Solution().rearrangeArray(nums)));
        }
    }
}

// 2213 ms 78.6 MB
class RearrangeArrayElementsBySign_Solution {
    public int[] rearrangeArray(int[] nums) {

        OUT:
        for (int i = 0; i < nums.length-1; i++) {
            int firstPointer = i, secondPointer = i+1;
            
            // Check for first index of the array not negative:
            if (i == 0 && nums[firstPointer] < 0) {
                while (nums[secondPointer] < 0) {
                    swap(nums, firstPointer, secondPointer);
                    secondPointer++;
                }
                
                swap(nums, firstPointer, secondPointer);

                continue OUT;
            } 

            // Check if each pair satisfy the condition:
            if (nums[firstPointer] < 0 && nums[secondPointer] < 0) {
                int holdIndex = secondPointer; secondPointer++;
                while (nums[secondPointer] < 0) {
                    swap(nums, holdIndex, secondPointer);
                    secondPointer++;
                }
                swap(nums, holdIndex, secondPointer);
            } else if (nums[firstPointer] > 0 && nums[secondPointer] > 0) {
                int holdIndex = secondPointer; secondPointer++;
                while (nums[secondPointer] > 0) {
                    swap(nums, holdIndex, secondPointer);
                    secondPointer++;
                }
                swap(nums, holdIndex, secondPointer);
            }
        }
        
        return nums;
    }

    private void swap(int[] nums, int index1, int index2) {
        int hold = nums[index2];
        nums[index2] = nums[index1];
        nums[index1] = hold;
    }
}
