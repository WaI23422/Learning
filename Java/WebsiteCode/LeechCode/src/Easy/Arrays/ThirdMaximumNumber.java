package Easy.Arrays;

import java.util.TreeSet;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/third-maximum-number/">414. Third Maximum Number</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code>, return <em>the <strong>third distinct maximum</strong> number in this array. If the third maximum does not exist, return the <strong>maximum</strong> number</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [3,2,1]
<strong>Output:</strong> 1
<strong>Explanation:</strong>
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2]
<strong>Output:</strong> 2
<strong>Explanation:</strong>
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [2,2,3,1]
<strong>Output:</strong> 1
<strong>Explanation:</strong>
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Can you find an <code>O(n)</code> solution?</div>
 */
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[][] tests = {
            {1,2,2,5,3,5},
            {3,2,1},
            {1,2},
            {2,2,3,1}
        };

        for (int[] nums : tests) {
            System.out.println(new ThirdMaximumNumber_Solution().thirdMax(nums));   
        }
    }
}

// 5 ms 44.4 MB
class ThirdMaximumNumber_Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> ts=new TreeSet<Integer>();

        for(int num:nums){
            ts.add(num);
            if(ts.size()>3){
                ts.remove(ts.first());
            }
        }

        return ts.size()==3?ts.first():ts.last();
    }
}