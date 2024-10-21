package Medium.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/count-subarrays-where-max-element-appears-at-least-k-times/">2962.Count Subarrays Where Max Element Appears at Least K Times</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an integer array <code>nums</code> and a <strong>positive</strong> integer <code>k</code>.</p>

<p>Return <em>the number of subarrays where the <strong>maximum</strong> element of </em><code>nums</code><em> appears <strong>at least</strong> </em><code>k</code><em> times in that subarray.</em></p>

<p>A <strong>subarray</strong> is a contiguous sequence of elements within an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,3,2,3,3], k = 2
<strong>Output:</strong> 6
<strong>Explanation:</strong> The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,4,2,1], k = 3
<strong>Output:</strong> 0
<strong>Explanation:</strong> No subarray contains the element 4 at least 3 times.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>5</sup></code></li>
</ul>
</div>
 */
public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,1,2,1,2,1,1,2},{2}},
            {{61,23,38,23,56,40,82,56,82,82,82,70,8,69,8,7,19,14,58,42,82,10,82,78,15,82},{2}},
            {{1,3,2,3,3},{2}},
            {{1,2},{2}},
            {{1},{1}},
            {{1,1,2,1,1,1},{1}}
        };

        for (int[][] test : tests) {
            int[] nums = test[0];
            int k = test[1][0];

            System.out.println(new CountSubarraysWhereMaxElementAppearsAtLeastKTimes_Solution().countSubarrays(nums, k));
        }
    }
}

// 9 ms 59.6 MB
class CountSubarraysWhereMaxElementAppearsAtLeastKTimes_Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = findMax(nums);
        long count = 0;

        List<Integer> maxPos = allNumPos(nums, max);

        int maxPosSize = maxPos.size();
        if (maxPosSize < k) {return 0;}

        for (int i = 0, j = i+k-1; i < maxPosSize && j < maxPosSize; i++,j++) {
            if (j + 1 < maxPosSize) {
                count += (long)(maxPos.get(i)+1)*(maxPos.get(j+1)- maxPos.get(j)); // (maxPos.get(i)+1)*(maxPos.get(j+1)- maxPos.get(j)) -> 8ms
            } else {
                count += (long)(maxPos.get(i)+1)*(nums.length- maxPos.get(j)); 
            }
        }

        return count;
    }

    private List<Integer> allNumPos(int[] nums, int num) {
        List<Integer> contain = new ArrayList<>();
    
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                contain.add(i);
            }
        }

        return contain;
    }

    private int findMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        return max;
    }
}