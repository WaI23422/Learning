package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/frequency-of-the-most-frequent-element/">1838.Frequency of the Most Frequent Element</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>The <strong>frequency</strong> of an element is the number of times it occurs in an array.</p>

<p>You are given an integer array <code>nums</code> and an integer <code>k</code>. In one operation, you can choose an index of <code>nums</code> and increment the element at that index by <code>1</code>.</p>

<p>Return <em>the <strong>maximum possible frequency</strong> of an element after performing <strong>at most</strong> </em><code>k</code><em> operations</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,4], k = 5
<strong>Output:</strong> 3<strong>
Explanation:</strong> Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,4,8,13], k = 5
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are multiple optimal solutions:
- Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
- Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
- Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [3,9,6], k = 2
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>5</sup></code></li>
</ul>
</div></div>
 */
public class FrequencyOfTheMostFrequentElement {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,4},{5}},
            {{1,4,8,13},{5}},
            {{3,9,6},{1}}, 
        };

        for (int[][] is : tests) {
            int[] nums = is[0];
            int k = is[1][0];

            System.out.println(new FrequencyOfTheMostFrequentElement_Solution().maxFrequency(nums, k));
        }
    }
}

/**
 * <h1 id="approach">Approach</h1>
 * 
 * <ol>
<li>Sort the array in ascending order.</li>
<li>Use two pointers, i and j, to create a sliding window.</li>
<li>Maintain a sum variable to track the sum of elements within the window.</li>
<li>Increment i and adjust the window until the difference between the total sum and the sum within the window is less than or equal to k.</li>
<li>Keep track of the maximum window length, which represents the maximum frequency.</li>
</ol>
 */
class FrequencyOfTheMostFrequentElement_Solution {
    // 28 ms 62.1 MB
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int sum = 0;
        int maxLength = 0;

        for (i = 0; i < nums.length; i++) {
            sum += nums[i];

            while ((i - j + 1) * nums[i] - sum > k) {
                sum -= nums[j];
                j++;
            }

            maxLength = Math.max(maxLength, i - j + 1);
        }

        return maxLength;
    }
}

class FrequencyOfTheMostFrequentElement_Solution2 {
    // 11 ms 58.2 MB
    public int maxFrequency(int[] nums, int k) {
        countingSort(nums);
        int start = 0;
        int preSum = 0;
        int total = 1;
        for (int i = 0; i < nums.length; i++) {
            int length = i - start + 1;
            int product = nums[i] * length;
            preSum += nums[i];            
            while (product - preSum > k) {
                preSum -= nums[start++];
                length--;
                product = nums[i] * length;
            }
            total = Math.max(total, length);
        }
      
        return total;
    }
    private void countingSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            max = Math.max(max, num);
        }
        int[] map = new int[max + 1];
        for(int num: nums) {
            map[num]++;
        }
        int i = 0;
        int j = 0;
        while(i <= max) {
            if (map[i]-- > 0) {
                nums[j++] = i;
            } else {
                i++;
            }
        }        
    }
}