package Easy.Arrays;


/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/maximum-product-difference-between-two-pairs/">1913.Maximum Product Difference Between Two Pairs</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>The <strong>product difference</strong> between two pairs <code>(a, b)</code> and <code>(c, d)</code> is defined as <code>(a * b) - (c * d)</code>.</p>

<ul>
	<li>For example, the product difference between <code>(5, 6)</code> and <code>(2, 7)</code> is <code>(5 * 6) - (2 * 7) = 16</code>.</li>
</ul>

<p>Given an integer array <code>nums</code>, choose four <strong>distinct</strong> indices <code>w</code>, <code>x</code>, <code>y</code>, and <code>z</code> such that the <strong>product difference</strong> between pairs <code>(nums[w], nums[x])</code> and <code>(nums[y], nums[z])</code> is <strong>maximized</strong>.</p>

<p>Return <em>the <strong>maximum</strong> such product difference</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [5,6,2,7,4]
<strong>Output:</strong> 34
<strong>Explanation:</strong> We can choose indices 1 and 3 for the first pair (6, 7) and indices 2 and 4 for the second pair (2, 4).
The product difference is (6 * 7) - (2 * 4) = 34.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [4,2,5,9,7,4,8]
<strong>Output:</strong> 64
<strong>Explanation:</strong> We can choose indices 3 and 6 for the first pair (9, 8) and indices 1 and 5 for the second pair (2, 4).
The product difference is (9 * 8) - (2 * 4) = 64.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>4 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul></div></div>
 */
public class MaximumProductDifferenceBetweenTwoPairs {
    public static void main(String[] args) {
        int[][] tests = {
            {5,6,2,7,4},
            {4,2,5,9,7,4,8},
            {1,1,3,3},
            {1,2,3,3,4,5}
        };

        for (int[] nums : tests) {
            System.out.println(new MaximumProductDifferenceBetweenTwoPairs_Solution().maxProductDifference(nums));
        }
    }
}

// 2 ms 44.1 MB
class MaximumProductDifferenceBetweenTwoPairs_Solution {
    public int maxProductDifference(int[] nums) {
        int 
            max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, 
            min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE,
            hold; 

        for (int num : nums) {
            if (num > max1) { 
                hold = max1; max1 = num;
                if (hold > max2) {max2 = hold;}
            } else if (num > max2) {
                max2 = num;
            }

            if (num < min2) {
                hold = min2; min2 = num;
                if (hold < min1) {min1 = hold;}
            } else if (num < min1) {
                min1 = num;
            }
        }

        System.gc(); // 3 ms 40.9 MB
        return (max1*max2) - (min1*min2);
    }
}