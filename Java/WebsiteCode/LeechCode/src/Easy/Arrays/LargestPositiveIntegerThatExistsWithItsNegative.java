package Easy.Arrays;


/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/largest-positive-integer-that-exists-with-its-negative/">2441. Largest Positive Integer That Exists With Its Negative</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code> that <strong>does not contain</strong> any zeros, find <strong>the largest positive</strong> integer <code>k</code> such that <code>-k</code> also exists in the array.</p>

<p>Return <em>the positive integer </em><code>k</code>. If there is no such integer, return <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [-1,2,-3,3]
<strong>Output:</strong> 3
<strong>Explanation:</strong> 3 is the only valid k we can find in the array.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [-1,10,6,7,-7,1]
<strong>Output:</strong> 7
<strong>Explanation:</strong> Both 1 and 7 have their corresponding negative values in the array. 7 has a larger value.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [-10,8,6,7,-2,-3]
<strong>Output:</strong> -1
<strong>Explanation:</strong> There is no a single valid k, we return -1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>nums[i] != 0</code></li>
</ul>
</div>
 */
public class LargestPositiveIntegerThatExistsWithItsNegative {
    public static void main(String[] args) {
        int[][] tests = {
            {-1,2,-3,3},
            {-1,10,6,7,-7,1},
            {-10,8,6,7,-2,-3},
            {-30,34,1,32,26,-9,-30,22,-49,29,48,47,38,4,43,12,-1,-8,11,-37,32,40,9,15,-34,-34,-16,-5,26,-44,-36,-13,-16,10,39,-17,-22,17,-16}
        };

        for (int[] nums : tests) {
            System.out.println(new LargestPositiveIntegerThatExistsWithItsNegative_Solution().findMaxK(nums));
        }
    }
}

// 2 ms 44.7 MB
class LargestPositiveIntegerThatExistsWithItsNegative_Solution {
    public int findMaxK(int[] nums) {
        int[] numsStore = new int[2001];
        int max = -1;
    
        for (int num : nums) {
            if (num > 0) {
                if (numsStore[num + 1000] != 0 && num > max) {
                    max = num;
                }
                numsStore[num]++;
            } else {
                int posVer = Math.abs(num);
                if (numsStore[posVer] != 0 && posVer > max) { max =posVer;}
                numsStore[posVer+1000]++;
            }
        }

        return max;
    }
}