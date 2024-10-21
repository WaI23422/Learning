package BetterCodeAnswer.Hard.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/subarrays-with-k-different-integers/">992.Subarrays with K Different Integers</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <em>the number of <strong>good subarrays</strong> of </em><code>nums</code>.</p>

<p>A <strong>good array</strong> is an array where the number of different integers in that array is exactly <code>k</code>.</p>

<ul>
	<li>For example, <code>[1,2,3,1,2]</code> has <code>3</code> different integers: <code>1</code>, <code>2</code>, and <code>3</code>.</li>
</ul>

<p>A <strong>subarray</strong> is a <strong>contiguous</strong> part of an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,1,2,3], k = 2
<strong>Output:</strong> 7
<strong>Explanation:</strong> Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,1,3,4], k = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i], k &lt;= nums.length</code></li>
</ul>
</div>
 */
public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,1,2,3},{2}},
            {{1,2,1,3,4},{3}}
        };

        for (int[][] test : tests) {
            int[] nums = test[0];
            int k = test[1][0];

            System.out.println(new SubarraysWithKDifferentIntegers_Solution().subarraysWithKDistinct(nums, k));
        }
    }
}

// 3 ms 46.5 MB
class SubarraysWithKDifferentIntegers_Solution {
    public int subarraysWithKDistinct(int[] nums, int K) {
        int[] numFreq = new int[nums.length+1];
        int distinct = 0, start = 0, minEnd = 0, total = 0;
        while (distinct == K || minEnd < nums.length) {
            while (distinct < K && minEnd < nums.length) 
                if (numFreq[nums[minEnd++]]++ == 0) 
                    distinct++;
            int maxEnd = minEnd;
            while (maxEnd < nums.length && numFreq[nums[maxEnd]] > 0)
                maxEnd++;
            while (distinct == K) {
                if (numFreq[nums[start++]]-- == 1)
                    distinct--;
                total += (maxEnd - minEnd + 1);
            }
       }
       return total;
   }
}

// 4 ms 47 MB
class SubarraysWithKDifferentIntegers_Solution2 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    private int helper(int nums[], int k) {
        if (k == 0) {
            return 0;
        } else {
            int count[] = new int[nums.length + 1];
            int windowStart = 0, windowEnd = 0, res = 0;
            int currCount = 0;

            while (windowEnd != nums.length) {
                int curr = nums[windowEnd++];
                
                if (count[curr] == 0) {
                    currCount++;
                }
                count[curr]++;

                while (currCount > k) {
                    if (--count[nums[windowStart++]] == 0) {
                        currCount--;
                    }
                }

                res += windowEnd - windowStart;
            }

            return res;
        }
    }
}