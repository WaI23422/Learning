package Medium.Array;

import java.util.HashMap;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/contiguous-array/">525. Contiguous Array</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a binary array <code>nums</code>, return <em>the maximum length of a contiguous subarray with an equal number of </em><code>0</code><em> and </em><code>1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [0,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [0,1,0]
<strong>Output:</strong> 2
<strong>Explanation:</strong> [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>
</div>
 */
public class ContiguousArray {
    public static void main(String[] args) {
        int[][] tests = {
            {1,1,1,1,1,1,1,0,0,0,0,1,1,0,1,0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0,1,1,0,0,0,0,1,0,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,1,0,0,1,1,0,1,0,0,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1,1},
            {0,1,0,0,0,1,0,1},
            {0,1,1,0,1,0,0},
            {0,1},
            {0,1,0},
            {0,1,0,1},
            {1,1,1,1},
            {0,0,0,0},
            {0,1,1,1,0,0},
            {1},
        };

        for (int[] nums : tests) {
            System.out.println(new ContiguousArray_Solution().findMaxLength(nums));
        }
    }
}

// 23ms 55.31MB
class ContiguousArray_Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int zeros = 0, ones = 0, maxLen = 0;
        
        hashmap.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros++; else ones++;
            int diff = zeros - ones;
            
            if (hashmap.containsKey(diff)) {
                maxLen = Math.max(maxLen, i - hashmap.get(diff));
            } else {
                hashmap.put(diff, i);
            }
        }
        
        return maxLen;
    }
}