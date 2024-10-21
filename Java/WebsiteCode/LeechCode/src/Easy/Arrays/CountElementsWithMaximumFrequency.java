package Easy.Arrays;


import java.util.Arrays;
import java.util.Collections;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/count-elements-with-maximum-frequency/">3005.Count Elements With Maximum Frequency</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an array <code>nums</code> consisting of <strong>positive</strong> integers.</p>

<p>Return <em>the <strong>total frequencies</strong> of elements in</em><em> </em><code>nums</code>&nbsp;<em>such that those elements all have the <strong>maximum</strong> frequency</em>.</p>

<p>The <strong>frequency</strong> of an element is the number of occurrences of that element in the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,2,3,1,4]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
So the number of elements in the array with maximum frequency is 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3,4,5]
<strong>Output:</strong> 5
<strong>Explanation:</strong> All elements of the array have a frequency of 1 which is the maximum.
So the number of elements in the array with maximum frequency is 5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
</ul>
</div>
 */
public class CountElementsWithMaximumFrequency {
    public static void main(String[] args) {
        int[][] tests = {
            {1,2,2,3,1,4},
            {1,2,3,4,5}
        };

        for (int[] nums : tests) {
            System.out.println(new CountElementsWithMaximumFrequency_Solution().maxFrequencyElements(nums));
        }
    }
}

// 1 ms 41.9 MB
class CountElementsWithMaximumFrequency_Solution {
    public int maxFrequencyElements(int[] nums) {
        int count = 0, max = Integer.MIN_VALUE;
        int[] freq = new int[101];

        for (int i : nums) { freq[i]++; }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > max) {
                max = freq[i];
                count = freq[i];
            } else if (freq[i] == max) {
                count+= freq[i];
            }
        }
 
        return count;
    }
}

// 6 ms 42.2 MB
class CountElementsWithMaximumFrequency_Solution2 {
    public int maxFrequencyElements(int[] nums) {
        Integer[] freq = new Integer[101];
        Arrays.fill(freq, 0);

        for (int i : nums) { freq[i]++; }

        Arrays.sort(freq, Collections.reverseOrder());
        int max = freq[0], count = max, j = 1;
        while (j < freq.length && freq[j] == max) {
            j++; count+= max;
        }

        return count;
    }
}
