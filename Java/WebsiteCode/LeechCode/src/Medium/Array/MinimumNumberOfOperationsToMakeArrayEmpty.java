package Medium.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/minimum-number-of-operations-to-make-array-empty/">2870.Minimum Number of Operations to Make Array Empty</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> array <code>nums</code> consisting of positive integers.</p>

<p>There are two types of operations that you can apply on the array <strong>any</strong> number of times:</p>

<ul>
	<li>Choose <strong>two</strong> elements with <strong>equal</strong> values and <strong>delete</strong> them from the array.</li>
	<li>Choose <strong>three</strong> elements with <strong>equal</strong> values and <strong>delete</strong> them from the array.</li>
</ul>

<p>Return <em>the <strong>minimum</strong> number of operations required to make the array empty, or </em><code>-1</code><em> if it is not possible</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,3,3,2,2,4,2,3,4]
<strong>Output:</strong> 4
<strong>Explanation:</strong> We can apply the following operations to make the array empty:
- Apply the first operation on the elements at indices 0 and 3. The resulting array is nums = [3,3,2,4,2,3,4].
- Apply the first operation on the elements at indices 2 and 4. The resulting array is nums = [3,3,4,3,4].
- Apply the second operation on the elements at indices 0, 1, and 3. The resulting array is nums = [4,4].
- Apply the first operation on the elements at indices 0 and 1. The resulting array is nums = [].
It can be shown that we cannot make the array empty in less than 4 operations.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [2,1,2,2,3,3]
<strong>Output:</strong> -1
<strong>Explanation:</strong> It is impossible to empty the array.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
</ul>
</div></div>
 */
public class MinimumNumberOfOperationsToMakeArrayEmpty {
    public static void main(String[] args) {
        int[][] tests = {
            {2,3,3,2,2,4,2,3,4},
            {2,1,2,2,3,3},
            {13,7,13,7,13,7,13,13,7},
        };

        for (int[] nums : tests) {
            System.out.println(new MinimumNumberOfOperationsToMakeArrayEmpty_Solution().minOperations(nums));
        }
    }
}

// 22 ms 63.2 MB
class MinimumNumberOfOperationsToMakeArrayEmpty_Solution {
    public int minOperations(int[] nums) {
        int opr = 0;
        
        Map<Integer,Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        if (freq.containsValue(1)) {return -1;}

        for (Map.Entry<Integer,Integer> entry : freq.entrySet()) {
            if (entry.getValue() <= 3) {opr++;}
            else if (entry.getValue() % 3 == 0) {opr +=  entry.getValue()/3;}
            else if (entry.getValue() %3 == 2) {opr += entry.getValue()/3 +1;}
            else {opr += (entry.getValue() - 4)/3 + 2;}
        }

        System.gc(); // 32 ms 55.2 MB
        return opr;
    }
}
